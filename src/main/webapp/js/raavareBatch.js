/* Author: Karl Emil */

var hostURL = '/CDIOFinal_war_exploded/test/raavarebatch/';

function loadRaavareBatchList() {
    console.log("Loading Råvare Batches");
    $.get(hostURL, function (data, textStatus, req) {
        $("#loadAllRaavareBatchList").empty();
        $.each(data, function (i, raavareBatch) {
            $("#loadAllRaavareBatchList").append(genTableHTMLForRaavareBatch(raavareBatch));
        });
    });
}

function genTableHTMLForRaavareBatch(raavareBatch) {
    return  '<tr><td>' + raavareBatch.rbId + '</td>' +
            '<td>' + raavareBatch.raavareId +'</td>' +
            '<td>' + raavareBatch.maengde + '</td>' +
            '<td><button class="btn-alert" type="submit" onclick="deleteRaavareBatch(' + raavareBatch.rbId + ');">Slet</button></td>' +
            '</td>'
}

function deleteRaavareBatch(rbId) {
    event.preventDefault();
    $.ajax({
        url: hostURL + rbId,
        method: 'DELETE',
        success: function (data) {
            alert(' Råvare Batch med id: ' + rbId + ' er blevet slettet!');
            loadRaavareBatchList();
        }
    });
}