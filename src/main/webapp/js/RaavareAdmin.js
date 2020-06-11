
var hotRaavareURL = "/CDIOFinal_war_exploded/test/raavare/";

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
        '<td>' + raavare.leverandoer + '</td>' +
        '<td><button class="btn-alert" type="submit" onclick="deleteRaavare(' + raavare.raavareid + ');">Slet</button></td>' +
        '</tr>';
}

function deleteRaavare(raavareId) {
    event.preventDefault();
    $.ajax({
        url: hotRaavareURL + raavareId,
        method: 'DELETE',
        success: function (data) {
            alert(' råvare med id: ' + raavareId + ' er blevet slettet!');
            loadRaavareList();
        }
    });
}