var hostUserURL = '/CDIOFinal_war_exploded/test/users/';

function loadActiveUserList() {
    console.log("Loading Active Users");
    $.get(hostUserURL, function (data, textStatus, req) {
        $("#loadAllActiveUserList").empty();
        $.each(data, function (i, User) {
            $("#loadAllActiveUserList").append(genTableHTMLForUserList((User)));
        });
    });
}

function genTableHTMLForUserList(User) {
    return  '<tr><td>' + User.id + '</td>' +
        '<td>' + User.firstname +'</td>' +
        '<td>' + User.lastname + '</td>' +
        '<td>' + User.initial + '</td>' +
        '<td>' + User.role + '</td>' +
        '<td>' + User.status + '</td>' +
        '</tr>'
}