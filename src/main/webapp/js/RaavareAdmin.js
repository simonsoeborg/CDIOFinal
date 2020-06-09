
var hostURL = '/CDIOFinal_war_exploded/test/raavare/';

$(document).ready(function () {
    loadRaavareList();
});

function loadRaavareList() {
    console.log("Loading raavarer");
    $.get(hostURL, function (data, textStatus, req) {
        $("#loadAllRaavareList").empty();
        $.each(data, function (i, raavare) {
            $("#loadAllRaavareList").append(genTableHTMLForRaavare(raavare));
        });
    });
}

function genTableHTMLForRaavare(raavare) {
    return '<tr><td>'+ raavare.raavareId + '</td>'  +
        '<td>' + raavare.raavareNavn +'</td>' +
        '<td>' + raavare.leveradoer + '</td>' +
        '<td><button class="btn-alert" type="submit" onclick="deleteRaavare(' + raavare.raavareId + ');">Slet</button></td>' +
        '</tr>'
}

function deleteRaavare(raavareId) {
    event.preventDefault();
    $.ajax({
        url: hostURL + raavareId,
        method: 'DELETE',
        success: function (data) {
            alert(' råvare med id: ' + raavareId + ' er blevet slettet!');
            loadRaavareList();
        }
    });
}