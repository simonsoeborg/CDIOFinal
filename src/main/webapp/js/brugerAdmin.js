 var hostUserURL = '/CDIOFinal_war_exploded/test/users/';

function loadActiveUserList() {
    let getAllUsersURL = '/CDIOFinal_war_exploded/test/users/';
    console.log("Loading Active Users");
    $.get(getAllUsersURL, function (data, textStatus, req) {
        $("#loadActiveUserList").empty();
        $.each(data, function (i, user) {
            $("#loadActiveUserList").append(genTableHTMLForUserList((user)));
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