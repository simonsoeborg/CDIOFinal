function genTableHTMLForRecepts(recept) {
    return '<tr>' + '<td>' + recept.receptId + '</td>' +
        '<td>' + recept.receptNavn + '</td>' +
        '<td>' + recept.raavareNavn + '</td>' +
        '<td>' + recept.maengde + ' g</td>' +
        '<td>' + recept.tolerance + '</td>' +
        '<td><button class="btn-alert" type="submit" onclick="deleteRecept(recept.receptId);">Slet</button></td>'+
    '</tr>';
}

function loadRecepts() {
    let loadReceptUrl = '/CDIOFinal_war_exploded/test/recepts/';
    console.log("Loading Recepts");
    $.get(loadReceptUrl, function (data, textStatus, req) {
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
        "meangde": $('#maengde').val(),
        "tolerance": $('#tolerance').val()
    })
}

function createRecept() {
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: '/CDIOFinal_war_exploded/test/recepts/',
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



