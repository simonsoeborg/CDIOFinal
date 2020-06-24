let pbHostURL = HostURL + 'ProductionBatch/';

function loadProduktBatchList() {
    console.log("Loading Produkt Batches");
    let hostGetURL = pbHostURL + 'load/';
    $.get(hostGetURL, function (data) {
        $("#loadAllProduktBatchList").empty();
        console.log("test2");
        $.each(data, function (i, produktBatch) {
            console.log(produktBatch);
            $("#loadAllProduktBatchList").append(genTableHTMLForProduktBatch(produktBatch));
        });
    });
}

function genTableHTMLForProduktBatch(produktBatch) {
    return '<tr>' + '<td>' + produktBatch.pbid +'</td>' +
        '<td>' + produktBatch.receptid + '</td>' +
        '<td>' + produktBatch.status + '</td>' +
        '<td>' + produktBatch.userid+ '</td>' +
        '<td>' + produktBatch.rbid + '</td>' +
        '<td>' + produktBatch.afvejetmaengde + '</td>' +
        '<td>' + produktBatch.tara + '</td>' +
        '<td><button class="btn-alert" type="submit" onclick="deleteProduktBatch(' + produktBatch.pbid +','+ produktBatch.rbid +');">Slet</button></td>' +
        '</td>'
}

function deleteProduktBatch(pbid,rbid) {
    let obHostURL = pbHostURL + pbid + "/" + rbid;
    event.preventDefault();
    $.ajax({
        url: obHostURL,
        method: 'DELETE',
        success: function () {
            alert(' Produkt Batch med id: ' + pbid + ' er blevet slettet!');
            loadProduktBatchList();
        }
    });
}

function createProduktBatch() {
    console.log('Opretter ny ProduktBatch');
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: pbHostURL + 'create/',
        dataType: 'json',
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

function pbCreateToJSON() {
    return JSON.stringify({
        "pbid": $('#pbid').val(),
        "receptid": $('#receptid').val(),
        "status": $('#status').val(),
        "userid": $('#userid').val(),
        "rbid": $('#rbid').val(),
        "tara": $('#tara').val(),
        "afvejetmaengde": $('#afvejetmaengde').val()
    });
}