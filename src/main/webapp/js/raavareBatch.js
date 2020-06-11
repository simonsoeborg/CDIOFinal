/* Author: Karl Emil */

var hostURL = '/CDIOFinal_war_exploded/test/raavarebatch/';

function loadRaavareBatchList() {
    console.log("Loading Råvare Batches");
    let hostGetURL = hostURL + 'load';
    $.get(hostGetURL, function (data) {
        $("#loadAllRaavareBatchList").empty();
        $.each(data, function (i, raavareBatch) {
            $("#loadAllRaavareBatchList").append(genTableHTMLForRaavareBatch(raavareBatch));
        });
    });
}

function genTableHTMLForRaavareBatch(raavareBatch) {
    return  '<tr><td>' + raavareBatch.rbId + '</td>' +
            '<td>' + raavareBatch.raavareId +'</td>' +
            '<td>' + getRaavareNavn(raavareBatch.raavareId) +'</td>' +
            '<td>' + raavareBatch.maengde + ' kg</td>' +
            '<td>' + raavareBatch.leverandoer + '</td>' +
            '<td><button class="btn-alert" type="submit" onclick="deleteRaavareBatch(' + raavareBatch.rbId + ');">Slet</button></td>' +
            '</tr>'
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

function getRaavareNavn(raavareId) {
    console.log("kaldes dette?");
    let hostGetNameURL = hostURL + 'raavare/' + raavareId;
    $.get(hostGetNameURL, function (data) {
            alert("Data: " + data);
            return data;
        });
}