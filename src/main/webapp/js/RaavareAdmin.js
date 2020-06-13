
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
    if (controlRaavareID($('#raavareid').val()) && controlRaavareNavn($('#raavarenavn').val())) {
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: hostCreateURL,
            dataType: "json",
            data: dataCreateToJSON(),
            success: function (data, textStatus, req) {
                alert('råvare successful oprettet!');
                loadRaavareList();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('fejl ved oprettelsen af råvaren: ' + textStatus);
            }
        })
    }
}

function dataCreateToJSON() {
    return JSON.stringify({
        "raavareid": $('#raavareid').val(),
        "raavarenavn": $('#raavarenavn').val()
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
    if (!(raavareNavn.length > 1) && !(raavareNavn.length < 21)) {
        alert("råvarens navn skal være minimum 2 og maks 20");
        return false;
    }
    return true;
}

function searchRaavare(raavarenavn) {
    raavarenavn = document.getElementById('soegraavarenavn').value;
    var hostSearchURL = '/CDIOFinal_war_exploded/test/raavare/' + raavarenavn;
    console.log(hostSearchURL);
    console.log("Searching råvare");
    if (hostSearchURL != null && hostSearchURL != ' ') {
        $.get(hostSearchURL, function (data) {
            $("#loadAllRaavareList").empty();
            $.each(data, function (i, raavarenavn) {
                $("#loadAllRaavareList").append(genTableHTMLForRaavare(raavarenavn));
            });
        });
    } else alert("kan ikke finde råvaren: " + raavarenavn);

}