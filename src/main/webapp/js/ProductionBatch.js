//let pbHostURL = '/CDIOFinal_war_exploded/test/ProductionBatch/';

function loadProduktBatchList() {
    let pbHostURL = '/CDIOFinal_war_exploded/test/ProductionBatch/load';
    console.log("Loading Produkt Batches");
    $.get(pbHostURL, function (data) {
        console.log("test");
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
        '<td><button class="btn-alert" type="submit" onclick="deleteProduktBatch(' + produktBatch.pbid + ', ' + produktBatch.pbid+');">Slet</button></td>' +
        '</td>'
}

function deleteProduktBatch(pbid) {
    event.preventDefault();
    $.ajax({
        url: pbHostURL + pbid,
        method: 'DELETE',
        success: function () {
            alert(' Produkt Batch med id: ' + pbid + ' er blevet slettet!');
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
    var produktId = document.getElementById('pbid').value;
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
        "receptid": $('#receptid').val(),
        "status": $('#status').val(),
        "userid": $('#userid').val(),
        "rbid": $('#rbid').val(),
        "tara": $('#tara').val(),
        "afvejningsmaengde": $('#afvejningsmaengde').val(),



    });
}