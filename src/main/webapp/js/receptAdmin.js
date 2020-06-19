let ReceptUrl = '/CDIOFinal_war_exploded/test/recepts/';

function genTableHTMLForRecepts(recept) {
    return '<tr>' + '<td>' + recept.receptId + '</td>' +
        '<td>' + recept.receptNavn + '</td>' +
        '<td>' + recept.raavareId + '</td>' +
        '<td>' + recept.raavareNavn + '</td>' +
        '<td>' + recept.maengde + ' g</td>' +
        '<td>' + recept.tolerance + ' %</td>' +
   //     '<td><button class="btn-warning" type="submit" onclick="editUser(' + user.id + ');">Ret</button></td>' +
        '<td><button class="btn-alert" type="submit" onclick="deleteReceptKomponent(' + recept.receptId + ');">Slet</button></td>'+
    '</tr>';
}

function loadRecepts() {
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
        "receptId": $('#receptId').val(),
        "receptNavn": $('#receptNavn').val(),
        "raavareId": $('#raavareId').val(),
        "raavareNavn": $('#raavareNavn').html(),
        "maengde": $('#maengde').val(),
        "tolerance": $('#tolerance').val()
    })
}

function createRecept() {
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: ReceptUrl,
        dataType: "json",
        data: receptDataCreateToJSON(),
        success: function () {
            alert('Succes! Recept oprettet');
            loadRecepts();
        },
        error: function (jqXHR, textStatus) {
            alert('Fejl ved oprettelsen af Recept: ' + textStatus);
        }
    })

}

function deleteReceptKomponent(id) {
    event.preventDefault();
    $.ajax({
        url: ReceptUrl+ 'komponent/' + id,
        method: 'DELETE',
        success: function () {
            alert('Recept' + id + 'er slettet');
            loadRecepts();
        }
    });
}

// Den anden tabel ------------------------------------------------


function genTableHTMLForReceptId(receptid) {
    return '<tr>' + '<td>' + receptid.receptId + '  ' + receptid.receptNavn + '</td>' +
        '<td><button class="btn-alert" type="submit" ' +
        'onclick="deleteReceptId(' + receptid.receptId + ');">Slet</button></td>'+
        '</tr>';
}

function loadReceptId() {
    console.log("Loading ReceptIDs");
    $.get(ReceptUrl + 'receptIdOversigt', function (receptIdData, textStatus, req) {
        $("#loadAllReceptsId").empty();
        $.each(receptIdData, function (i, receptid) {
            $("#loadAllReceptsId").append(genTableHTMLForReceptId(receptid));
        });
    });
}

function deleteReceptId(id) {
    event.preventDefault();
    $.ajax({
        url: ReceptUrl,
        method: 'DELETE',
        success: function () {
            alert(' Recept med id: ' + id + ' er blevet slettet!');
            loadReceptId();
        }
    });
}

//-----------------------------------------------------------------
