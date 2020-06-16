
var hostURL = "/CDIOFinal_war_exploded/test/raavare/";

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
        '<td><button class="btn-alert" type="submit" onclick="deleteRaavare(' + raavare.raavareid + ');">Slet</button></td>' +
        '</tr>';
}

function deleteRaavare(id) {
    var hostDeleteURL = "/CDIOFinal_war_exploded/test/raavare/" + id;
    event.preventDefault();
    $.ajax({
        url: hostDeleteURL,
        method: 'DELETE',
        success: function (data) {
            alert(' råvare med id: ' + id + ' er blevet slettet!');
            loadRaavareList();
        }
    });
}
function createRaavare() {
    var hostCreateURL = "/CDIOFinal_war_exploded/test/raavare/";
    console.log('Creating ny råvare');
    var id = document.getElementById('raavareid').value;
    var navn = document.getElementById('raavarenavn').value;
    console.log(id);
    console.log(navn);
    if (controlRaavareID(id) && controlRaavareNavn(navn)) {
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: hostCreateURL,
            dataType: "json",
            data: raavareDataCreateToJSON(id, navn),
            success: function (data, textStatus, req) {
                loadRaavareList();
                alert(' råvare successful oprettet!');
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('fejl ved oprettelsen af råvaren: ' + textStatus);
            }
        })
    }
}

function raavareDataCreateToJSON(id, navn) {
    return JSON.stringify({
        "raavareid": id,
        "raavarenavn": navn
    });
}

function controlRaavareID(ID) {
    if (ID.length !== 5) {
        alert("råvarens ID skal indholde 5-tal");
        return false;
    }
    return true
}
function controlRaavareNavn(raavareNavn) {
    if(raavareNavn.length < 2 && raavareNavn.length > 20) {
        alert("råvarens navn skal være minimum 2 og maks 20");
        console.log("False!");
        return false;
    } else {
        console.log("True!");
        return true;
    }
}