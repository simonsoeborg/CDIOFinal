/*
Author: Simon Fridolf
Github: IceMonk3y
*/
 var hostUserURL = '/CDIOFinal_war_exploded/test/users/';

// Load userSideMenu code functionality:
function includeUserSideMenu() {
     $(".grid-contentSidebar").load("brugerAdminSidebar.html");}


function loadActiveUserList() {
    let getAllActiveUsersURL = hostUserURL + 'activated';
    console.log("Loading Active Users");
    $.get(getAllActiveUsersURL, function (data, textStatus, req) {
        $("#loadActiveUserList").empty();
        $.each(data, function (i, user) {
            $("#loadActiveUserList").append(genTableHTMLForActiveUserList((user)));
        });
    });
}

 function loadDeactivatedUserList() {
     let getAllDeactivatedUsersURL = hostUserURL+'deactivated';
     console.log("Loading deactivated Users");
     $.get(getAllDeactivatedUsersURL, function (data, textStatus, req) {
         $("#loadDeactivatedUserList").empty();
         $.each(data, function (i, user) {
             $("#loadDeactivatedUserList").append(genTableHTMLForDeactivatedUserList((user)));
         });
     });
 }


 function deactivate (id) {
     event.preventDefault();
     $.ajax({
         url: hostUserURL + 'deactivate' +'?id='+ id,
         method: 'PUT',
         success: function (data) {
             alert(' Bruger med id: ' + id + ' er blevet deaktiveret !');
             loadActiveUserList();
         }
     });
 }

 function activate (id) {
     event.preventDefault();
     $.ajax({
         url: hostUserURL + 'activate' +'?id='+ id,
         method: 'PUT',
         success: function (data) {
             alert(' Bruger med id: ' + id + ' er blevet aktiveret !');
             loadDeactivatedUserList();
         }
     });
 }


function genTableHTMLForActiveUserList(user) {
    return  '<tr><td>' + user.id + '</td>' +
        '<td>' + user.firstname +'</td>' +
        '<td>' + user.lastname + '</td>' +
        '<td>' + user.initial + '</td>' +
        '<td>' + user.role + '</td>' +
        '<td><button id="edit-button" class="btn-alert"  type="submit">Rediger</button></td>' +
        '<td><button class="btn-alert" type="submit" onclick="deactivate('+ user.id+' );">Deaktiver</button></td>' +
        '</tr>';
}

 function genTableHTMLForDeactivatedUserList(user) {
     return  '<tr><td>' + user.id + '</td>' +
         '<td>' + user.firstname +'</td>' +
         '<td>' + user.lastname + '</td>' +
         '<td>' + user.initial + '</td>' +
         '<td>' + user.role + '</td>' +
         '<td><button id="edit-button" class="btn-alert"  type="submit">Rediger</button></td>' +
         '<td><button id="activate-button" class="btn-alert" type="submit" onclick="activate('+ user.id+' );">Aktiver</button></td>' +
         '</tr>';
 }