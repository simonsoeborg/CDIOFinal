/*
Author: Simon Fridolf
Github: IceMonk3y
*/
 var hostUserURL = '/CDIOFinal_war_exploded/test/users/';

// Load userSideMenu code functionality:
function includeUserSideMenu() {
     $(".grid-contentSidebar").load("brugerAdminSidebar.html");}

// Functionality to load different lists:
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

// Functionality to deactivate and reactivate users.
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

 // Functionality to create users, this includes a translation function to Json.
 function dataCreateToJSON() {
    return JSON.stringify({
        "id": 0,
        "firstname": $('#firstname').val(),
        "lastname": $('#lastname').val(),
        "initial": "",
        "role": $('#role').val(),
        "status": ""
    });
}

function createUser() {
    console.log('Creating new user');
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: hostUserURL,
            dataType: "json",
            data: dataCreateToJSON(),
            success: function (data, textStatus, req) {
                alert('User created Successfully!');
                displayContent('brugerAdminFront.html');
                loadActiveUserList();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('Error creating user: ' + textStatus);
            }
        })
}


// Functionality to edit users, this includes a Json translation as well as a function to display the previous data.
function dataEditToJSON(id) {
    return JSON.stringify({
        "id": id,
        "firstname": $('#firstname').val(),
        "lastname": $('#lastname').val(),
        "role": $('#role').val(),
    });
}

function displayEditUser(id) {
    displayContent('EditUser.html');
    $.ajax({
        type: 'GET',
        url: hostUserURL + id,
        dataType: "json",
        success: function (result) {
            document.getElementById('firstname').value = result.firstname;
            document.getElementById('lastname').value = result.lastname;
            document.getElementById('role').value = result.role;

            var input = document.getElementById('myID');
            input.value = id;
            document.getElementById('editUserBtn').onclick = function () {
                execEditUser();
            };
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert("unable to find user");
        }
    });
}

function execEditUser() {
    $.ajax({
        type: 'PUT',
        url: hostUserURL + id,
        contentType: 'application/json',
        dataType: "json",
        data: dataEditToJSON(id),
        success: function (data, textStatus, req) {
            alert('User Successfully updated!');
            displayContent('brugerAdminFront.html');
            loadActiveUserList();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error updating user with id: '+ id + ' | ' + textStatus);
        }
    })
}


// Functions for generating the tables needed to store the users.
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