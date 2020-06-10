
var hostURL = '/CDIOFinal_war_exploded/test/raavare/';

$(document).ready(function () {
    loadRaavareList();
});

function loadRaavareList() {
    console.log("Loading raavare");
    $.get(hostURL, function (data, textStatus, req) {
        $("#loadAllRaavareList").empty();
        $.each(data, function (i, raavare) {
            $("#loadAllRaavareList").append(genTableHTMLForRaavare(raavare));
        });
    });
}

function loadRaavareList2() {
    $("#loadAllRaavareList").empty();
    $.ajax( {
        type: 'GET',
        url: hostURL,
        dataType: "json",
        success: function (data) {
            $.each(data, function (i, raavare) {
                console.log("Loading raavare");
                $("#loadAllRaavareList").append(genTableHTMLForRaavare(raavare));
                console.log(raavare.raavareId);
                console.log(raavare.raavareNavn);
                console.log(raavare.leverandoer);
            })
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("Unable to load raavare list");
        }
    });
}

function genTableHTMLForRaavare(raavare) {
    return '<tr>' +
        '<td>'+ raavare.raavareId + '</td>'  +
        '<td>' + raavare.raavareNavn +'</td>' +
        '<td>' + raavare.leverandoer + '</td>' +
        '<td><button class="btn-alert" type="submit" onclick="deleteRaavare(' + raavare.id + ');">Slet</button></td>' +
        '</tr>'
}

function deleteRaavare(raavareId) {
    event.preventDefault();
    $.ajax({
        url: hostURL + raavareId,
        method: 'DELETE',
        success: function (data) {
            alert(' råvare med id: ' + raavareId + ' er blevet slettet!');
            loadRaavareList();
        }
    });
}