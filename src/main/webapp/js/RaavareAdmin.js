
var hostURL = "/CDIOFinal_war_exploded/test/raavare/";

function loadRaavareList() {
    let hostURLGetList = "/CDIOFinal_war_exploded/test/raavare/load/";
    console.log("Loading raavare");
    $.get(hostURLGetList, function (data, textStatus, req) {
        $("#loadAllRaavareList").empty();
        $.each(data, function (i, raavare) {
            $("#loadAllRaavareList").append(genTableHTMLForRaavare(raavare));
        });
    });
}

function genTableHTMLForRaavare(raavare) {
    return '<tr>' +
        '<td>'+ raavare.raavareid + '</td>'  +
        '<td>' + raavare.raavarenavn +'</td>' +
        '<td><button class="btn-alert" type="submit" onclick="deleteRaavare(' + raavare.raavareid + ');">Slet</button></td>' +
        '</tr>';
}
function deleteRaavare(id) {
    var hostDeleteURL = "/CDIOFinal_war_exploded/test/raavare/" + id;
    event.preventDefault();
    $.ajax({
        url: hostDeleteURL,
        method: 'DELETE',
        success: function (data) {
            alert(' råvare med id: ' + id + ' er blevet slettet!');
            loadRaavareList();
        }
    });
}
function createRaavare() {
    var hostCreateURL = "/CDIOFinal_war_exploded/test/raavare/";
    console.log('Creating ny råvare');
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: hostCreateURL,
            dataType: "json",
            data: dataCreateToJSON(),
            success: function (data, textStatus, req) {
                alert('råvare successful oprettet!');
                loadRaavareList();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('fejl ved oprettelsen af råvaren: ' + textStatus);
            }
        })
}

function dataCreateToJSON() {
    return JSON.stringify({
        "raavareid": $('#raavareid').val(),
        "raavarenavn": $('#raavarenavn').val()
    });
}