
var hostRaavareURL = HostURL + "raavare/";

function loadRaavareList() {
    let hostURLGetList = hostRaavareURL + "load/";
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
    var hostDeleteURL = hostRaavareURL + id;
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
    console.log('Creating ny råvare');
    var id = document.getElementById('raavareid').value;
    var navn = document.getElementById('raavarenavn').value;

    if (controlRaavareID(id) && controlRaavareNavn(navn)) {
        var doesItExistURL = hostRaavareURL + 'status/' + id;
        console.log('søger efter råvarens id ' + id);
        if (doesItExistURL != null && doesItExistURL !== ' ') {
            $.ajax({
                url: doesItExistURL,
                success: function (url) {
                    console.log(url);
                    if(url === false) {
                        alert('råvaren med ID: ' + id + ' eksistere allerede i databasen');
                    }else {
                        $.ajax({
                            type: 'POST',
                            contentType: 'application/json',
                            url: hostRaavareURL,
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

                }, error: function () {
                    console.log('problemer med at finde i databasen');
                }
            })
        }
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
    if(raavareNavn.length > 1 && raavareNavn.length < 21) {
        return true;
    } else {
        alert("råvarens navn skal være minimum 2 og maks 20");
        return false;
    }
}

function searchRaavare(raavarenavn) {
    raavarenavn = document.getElementById('soegraavarenavn').value;
    var hostSearchURL = hostRaavareURL + raavarenavn;
    console.log('søger efter råvare');
    if (hostSearchURL !== hostRaavareURL ) {
        if (hostSearchURL != null && hostSearchURL !== ' ') {
            $.ajax({
                url: hostSearchURL,
                success: function (url) {
                    if ($.trim(url)) {
                        $.get(hostSearchURL, function (data) {
                            $("#loadAllRaavareList").empty();
                            $.each(data, function (i, raavarenavn) {
                                $("#loadAllRaavareList").append(genTableHTMLForRaavare(raavarenavn));
                            });
                        });
                    } else {
                        alert("råvaren findes ikke i databasen. ");
                    }
                },
                error: function () {
                    alert("kan ikke få fat i råvare databasen");
                }

            })

        }
    } else{
        loadRaavareList();
    }
}