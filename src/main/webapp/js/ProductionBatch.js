
let pbHostURL = '/CDIOFinal_war_exploded/test/ProductionBatch/';

function loadProduktBatchList() {
    console.log("Loading Produkt Batches");
    let hostGetURL = rbHostURL + 'load';
    $.get(hostGetURL, function (data) {
        $("#loadAllProduktBatchList").empty();
        $.each(data, function (i, produktBatch) {
            $("#loadAllProduktBatchList").append(genTableHTMLForProduktBatch(produktBatch));
        });
    });
}

function genTableHTMLForProduktBatch(produktBatch) {
    return '<td>' + produktBatch.receptID +'</td>' +
        '<td>' + produktBatch.status + '</td>' +
        '<td>' + produktBatch.tara + '</td>' +
        '<td>' + produktBatch.netto + '</td>' +
        '<td>' + produktBatch.rbid + '</td>' +
        '<td>' + produktBatch.userId+ '</td>' +
        '<tr><td>' + produktBatch.pbId + '</td>' +
        '<td><button class="btn-alert" type="submit" onclick="deleteProduktBatch(' + produktBatch.pbId + ');">Slet</button></td>' +
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
        "receptID": $('#receptID').val(),
        "status": $('#status').val(),
        "tara": $('#tara').val(),
        "netto": $('#netto').val(),
        "rbid": $('#rbid').val(),
        "userId": $('#UserId').val(),
        "pbId": $('#pbId').val(),
    });
}