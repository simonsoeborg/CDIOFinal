/*Author:
Freja Nørgaard Jensen*/

let ReceptUrl = '/CDIOFinal_war_exploded/test/recepts/';

// ---------------------Den første tabel---------------------------


function genTableHTMLForRecepts(recept) {
    return '<tr>' + '<td>' + recept.receptid + '</td>' +
        '<td>' + recept.receptnavn + '</td>' +
        '<td>' + recept.raavareid + '</td>' +
        '<td>' + recept.raavarenavn + '</td>' +
        '<td>' + recept.maengde + ' g</td>' +
        '<td>' + recept.tolerance + ' %</td>' +
        '<td><button class="btn-alert" type="submit" onclick="deleteReceptKomponent(' + recept.raavareid + ', ' + recept.receptid +');">Slet</button></td>'+
    '</tr>';
}

function loadRecepts() {
    console.log("Loading Recepts");
    $.get(ReceptUrl, function (data, textStatus, req) {
        $("#loadAllRecepts").empty();
        $.each(data, function (i, recept) {
            $("#loadAllRecepts").append(genTableHTMLForRecepts(recept));
        });
    });
}


function receptDataCreateToJSON() {
    return JSON.stringify({
        "receptid": $('#receptid').val(),
        "receptnavn": $('#receptnavn').val(),
        "raavareid": $('#raavareid').val(),
        "maengde": $('#maengde').val(),
        "tolerance": $('#tolerance').val()
    })
}

// ---------------------Oprette recept---------------------------


function createRecept() {
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: ReceptUrl,
        dataType: "json",
        data: receptDataCreateToJSON(),
        success: function () {
            alert('Succes! Recept oprettet');
            loadRecepts();
            loadReceptId();
        },
        error: function (jqXHR, textStatus) {
            alert('Fejl ved oprettelsen af Recept: ' + textStatus);
        }
    })

}

// ---------------------Slette recept---------------------------

function deleteReceptKomponent(raavareid, receptid) {
    let deleteReceptUrl = '/CDIOFinal_war_exploded/test/recepts/komponent/' + raavareid + "/" + receptid;
    event.preventDefault();
    $.ajax({
        url: deleteReceptUrl,
        method: 'DELETE',
        success: function () {
            alert('Recept/Receptkomponent ' + raavareid + ' er slettet');
            loadRecepts();
        }
    });
}

// ---------------------Loader receptid og receptnavn ind i nr 2 tabel---------------------------


function genTableHTMLForReceptId(receptid) {
    return '<tr>' + '<td>' + receptid.receptid + '  ' + receptid.receptnavn + '</td>' +
        '<td><button class="btn-alert" type="submit" ' +
        'onclick="deleteReceptId(' + receptid.receptid + ');">Slet</button></td>'+
        '</tr>'
}

function loadReceptId() {
    console.log("Loading ReceptIDs");
    $.get(ReceptUrl + 'receptIdOversigt', function (receptIdData, textStatus, req) {
        $("#loadAllReceptsId").empty();
        $.each(receptIdData, function (i, receptid) {
            $("#loadAllReceptsId").append(genTableHTMLForReceptId(receptid));
            loadRecepts();
        });
    });
}

function deleteReceptId(id) {
    event.preventDefault();
    $.ajax({
        url: ReceptUrl + id,
        method: 'DELETE',
        success: function () {
            alert(' Recept med id: ' + id + ' er blevet slettet!');
            loadReceptId();
        }
    });
}

//---------------------Loader råvare fra RaavareAdmin---------------------------


function loadRaavareId() {
    console.log("Loading Raavare");
    let RaavareURL = "/CDIOFinal_war_exploded/test/raavare/load/";
    $.get(RaavareURL, function (raavareData, textStatus, req) {
        $("#raavareid").empty();
        $.each(raavareData, function (i, raavare) {
            $("#raavareid").append(genTableRaavareId(raavare.raavarenavn, raavare.raavareid));
        });
    });
}

$(document).ready(function(){
    loadRaavareId()
});

function genTableRaavareId(raavarenavn, raavareid) {
    return '<option value="'+ raavareid + '">'+ raavarenavn +'</option>'

}



//-----------------------------------------------------------------
