/*
Author: Karl Emil Hansen
Github: KEHansen
*/

let rbHostURL = '/CDIOFinal_war_exploded/test/raavarebatch/';

function loadRaavareBatchList() {
    console.log("Loading Råvare Batches");
    let hostGetURL = rbHostURL + 'load';
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
            '<td>' + raavareBatch.raavareNavn + '</td>' +
            '<td>' + raavareBatch.maengde + ' kg</td>' +
            '<td>' + raavareBatch.leverandoer + '</td>' +
            '<td><button class="btn-alert" type="submit" onclick="deleteRaavareBatch(' + raavareBatch.rbId + ');">Slet</button></td>' +
            '</tr>'
}

/*function getRaavareNavn(raavareId) {
    let hostGetNameURL = hostURL + 'raavare/' + raavareId;
    event.preventDefault();
    $.ajax({
        url: hostGetNameURL,
        type: 'GET',
        dataType: "text",
        success: function (res) {
            raavareNavn = res;
        },
    });
}*/

function deleteRaavareBatch(rbId) {
    event.preventDefault();
    $.ajax({
        url: rbHostURL + rbId,
        method: 'DELETE',
        success: function () {
            alert(' Råvare Batch med id: ' + rbId + ' er blevet slettet!');
            loadRaavareBatchList();
        }
    });
}

function createRaavareBatch() {

    let hostCreateURL = rbHostURL + 'create';
    console.log('Opretter ny RåvareBatch');
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: hostCreateURL,
        dataType: "json",
        data: rbCreateToJSON(),
        success: function () {
            alert('Succes! RåvareBatch oprettet');
            loadRaavareBatchList();
        },
        error: function (jqXHR, textStatus) {
            alert('Fejl ved oprettelsen af RåvareBatch: ' + textStatus);
        }
    });
}

function showRaavareNavn() {
    var raavareId = document.getElementById('raavareId').value;
    let hostShowURL = rbHostURL + 'raavare/' + raavareId
    $.ajax({
        url: hostShowURL,
        type: 'GET',
        dataType: "text",
        success: function (res) {
            document.getElementById('raavareNavn').innerHTML = res;
        }
    });
}

function rbCreateToJSON() {
    return JSON.stringify({
        "rbId": $('#rbId').val(),
        "raavareId": $('#raavareId').val(),
        "maengde": $('#maengde').val(),
        "leverandoer": $('#leverandoer').val()
    });
}