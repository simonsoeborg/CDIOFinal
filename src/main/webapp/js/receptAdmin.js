let ReceptUrl = '/CDIOFinal_war_exploded/test/recepts/';

function genTableHTMLForRecepts(recept) {
    return '<tr>' + '<td>' + recept.receptid + '</td>' +
        '<td>' + recept.receptnavn + '</td>' +
        '<td>' + recept.raavareid + '</td>' +
        '<td>' + recept.raavarenavn + '</td>' +
        '<td>' + recept.maengde + ' g</td>' +
        '<td>' + recept.tolerance + '</td>' +
        '<td><button class="btn-alert" onclick="deleteReceptKomponent(recept.receptid);">Slet</button></td>'+
    '</tr>';
}

function loadRecepts() {
    let ReceptUrl = '/CDIOFinal_war_exploded/test/recepts/';
    console.log("Loading Recepts");
    $.get(ReceptUrl, function (data, textStatus, req) {
        $("#loadAllRecepts").empty();
        $.each(data, function (i, recept) {
            $("#loadAllRecepts").append(genTableHTMLForRecepts(recept));
        });
    });
}


function receptDataCreateToJSON() {
    return JSON.stringify({
        "receptid": $('#receptid').val(),
        "receptnavn": $('#receptnavn').val(),
        "raavareid": $('#raavareid').val(),
        "raavarenavn": $('#raavarenavn').val(),
        "meangde": $('#maengde').val(),
        "tolerance": $('#tolerance').val()
    })
}


function createRecept() {
    console.log('Opretter ny recept');
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: ReceptUrl,
        dataType: "json",
        data: receptDataCreateToJSON(),
        success: function () {
            alert('Recept oprettet');
            loadRecepts();
        },
        error: function (jqXHR, textStatus) {
            alert('Fejl ved oprettelsen ' + textStatus);
        }
    });
}

function deleteReceptKomponent(id) {
    event.preventDefault();
    $.ajax({
        method: 'DELETE',
        url: ReceptUrl + id,
        success: function () {
            alert(' Recept med id: ' + id + ' er blevet slettet!');
            loadRecepts();
        }
    });
}



