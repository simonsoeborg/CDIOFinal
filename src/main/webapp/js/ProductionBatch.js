
let pbHostURL = '/CDIOFinal_war_exploded/test/Produktbatch/';

function loadProduktBatchList() {
    console.log("Loading Produkt Batches");
    let hostGetURL = rbHostURL + 'load';
    $.get(hostGetURL, function (data) {
        $("#loadAllProduktBatchList").empty();
        $.each(data, function (i, ProduktBatch) {
            $("#loadAllProduktBatchList").append(genTableHTMLForProduktBatch(ProduktBatch));
        });
    });
}

function genTableHTMLForProduktBatch(ProduktBatch) {
    return  '<tr><td>' + ProduktBatch.pbId + '</td>' +
        '<td>' + ProduktBatch.receptId +'</td>' +
        '<td>' + ProduktBatch.status + '</td>' +
        '<td>' + ProduktBatch.id+ '</td>' +
        '<td>' + ProduktBatch.rbid+ '</td>' +
        '<td>' + ProduktBatch.afvejetmaengde+ ' kg</td>' +
        '<td>' + ProduktBatch.tara+ '</td>' +
        '<td><button class="btn-alert" type="submit" onclick="deleteProduktBatch(' + ProduktBatch.pbId + ');">Slet</button></td>' +
        '</tr>'
}

function deleteProduktBatch(pbId) {
    event.preventDefault();
    $.ajax({
        url: pbHostURL + pbId,
        method: 'DELETE',
        success: function () {
            alert(' Produkt Batch med id: ' + pbId + ' er blevet slettet!');
            loadProduktBatchList();
        }
    });
}

function createProduktBatch() {

    let hostCreateURL = pbHostURL + 'create';
    console.log('Opretter ny ProduktBatch');
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: hostCreateURL,
        dataType: "json",
        data: pbCreateToJSON(),
        success: function () {
            alert('Succes! ProduktBatch oprettet');
            loadProduktBatchList();
        },
        error: function (jqXHR, textStatus) {
            alert('Fejl ved oprettelsen af ProduktBatch: ' + textStatus);
        }
    });
}

function showProduktNavn() {
    var produktId = document.getElementById('pbId').value;
    let hostShowURL = rbHostURL + 'produkt/' + pbid;
    $.ajax({
        url: hostShowURL,
        type: 'GET',
        dataType: "text",
        success: function (res) {
            document.getElementById('ProduktNavn').innerHTML = res;
        },
    });
}

function pbCreateToJSON() {
    return JSON.stringify({
        "pbId": $('#pbId').val(),
        "receptId": $('#receptId').val(),
        "status": $('#status').val(),
        "userId": $('#UserId').val()
    });
}