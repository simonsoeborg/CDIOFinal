 var hostUserURL = '/CDIOFinal_war_exploded/test/users/';

function loadActiveUserList() {
    console.log("Loading Active Users");
    $.get(hostUserURL, function (data, textStatus, req) {
        $("#loadAllActiveUserList").empty();
        $.each(data, function (i, user) {
            $("#loadAllActiveUserList").append(genTableHTMLForUserList((user)));
        });
    });
}

function genTableHTMLForUserList(user) {
    return  '<tr><td>' + user.id + '</td>' +
        '<td>' + user.firstname +'</td>' +
        '<td>' + user.lastname + '</td>' +
        '<td>' + user.initial + '</td>' +
        '<td>' + user.role + '</td>' +
        '<td>' + user.status + '</td>' +
        '</tr>'
}