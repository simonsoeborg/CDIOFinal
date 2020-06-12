 // Load userSideMenu code functionality:
 function includeUserSideMenu() {
     $(".grid-contentSidebar").load("brugerAdminSidebar.html"); }

function loadActiveUserList() {
    let getAllUsersURL = '/CDIOFinal_war_exploded/test/users/activated/';
    console.log("Loading Active Users");
    $.get(getAllUsersURL, function (data, textStatus, req) {
        $("#loadActiveUserList").empty();
        $.each(data, function (i, user) {
            $("#loadActiveUserList").append(genTableHTMLForUserList((user)));
        });
    });
}

 function loadDeactivatedUserList() {
     let getAllDeactivatedUsersURL = '/CDIOFinal_war_exploded/test/users/deactivated/';
     console.log("Loading deactivated Users");
     $.get(getAllDeactivatedUsersURL, function (data, textStatus, req) {
         $("#loadDeactivatedUserList").empty();
         $.each(data, function (i, user) {
             $("#loadDeactivatedUserList").append(genTableHTMLForUserList((user)));
         });
     });
 }

function genTableHTMLForUserList(user) {
    return  '<tr><td>' + user.id + '</td>' +
        '<td>' + user.firstname +'</td>' +
        '<td>' + user.lastname + '</td>' +
        '<td>' + user.initial + '</td>' +
        '<td>' + user.role + '</td>' +
        '</tr>'
}
