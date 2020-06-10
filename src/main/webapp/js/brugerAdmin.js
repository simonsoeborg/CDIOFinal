var hostURL = '/CDIOFinal_war_exploded/test/brugerAdmin/';

function loadUserList() {
    console.log("Loading Userlist ");
    $.get(hostURL, function (data, textStatus, req) {
        $("#loadAllRaavareBatchList").empty();
        $.each(data, function (i, raavareBatch) {
            $("#loadAllRaavareBatchList").append(genTableHTMLForRaavareBatch(raavareBatch));
        });
    });
}

function genTableHTMLForRaavareBatch(raavareBatch) {
    return  '<tr><td>' + raavareBatch.rbId + '</td>' +
        '<td>' + raavareBatch.raavareId +'</td>' +
        '<td>' + raavareBatch.maengde + '</td>' +
        '<td><button class="btn-alert" type="submit" onclick="deleteRaavareBatch(' + raavareBatch.rbId + ');">Slet</button></td>' +
        '</td>'
}