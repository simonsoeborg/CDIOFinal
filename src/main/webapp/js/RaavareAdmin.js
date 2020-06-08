
var hostURL = '/CDIOFinal_war_exploded/test/RaavarerServlet/';

function loadRaavarerList() {
    console.log("Loading raavarer");
    $.get(hostURL, function (data, textStatus, req) {
        $("#loadAllRaavarer").empty();
        $.each(data, function (i, raavarer) {
            $("#loadAllRaavarer").append(genTableHTMLForRaavarer(raavarer));
        });
    });
}

function genTableHTMLForRaavarer(raavarer) {
    return '<tr ravareId="' + raavarer.raavareId + '">' +
        '<td>'+ raavarer.raavareId + ' ' + raavarer.raavareNavn +'</td>' +
        '<td>' + raavarer.leveradoer + '</td>' +
        '<td><button class="btn-warning" type="submit" onclick="editRaavarer(' + raavarer.raavareId  + ');">Edit</button></td>' +
        '<td><button class="btn-alert" type="submit" onclick="deleteRaavarer(' + raavarer.raavareId + ');">Delete</button></td>' +
        '</tr>'
}

function deleteRaavarer(raavarerId) {
    event.preventDefault();
    $.ajax({
        url: hostURL + raavarerId,
        method: 'DELETE',
        success: function (data) {
            alert(' råvare med id: ' + raavarerId + ' er blevet slettet!')
            loadUserList();
        }
    });
}