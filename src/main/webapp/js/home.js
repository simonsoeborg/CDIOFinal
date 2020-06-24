/*
Author:Kristoffer Baumgarten & Simon Fridolf
Github: Jackktis & IceMonk3y
*/
hostUserURL = HostURL + 'users/';

function welcome() {
    let role = sessionStorage.getItem("role");
       document.getElementById('scriptName').innerHTML="Velkommen - Du er logget ind som " + role;
}

function userLayout(obj) {
    let role = obj.id;
    sessionStorage.setItem('role', role);

    displayContent('home.html');
}

function access() {
    if (sessionStorage.getItem('role') === "Administrator") {
        document.getElementById('brugerAdminMenu').style.display = "block";
    }
    if (sessionStorage.getItem('role') === "Farmaceut") {
        document.getElementById('raavareAdminMenu').style.display = "block";
        document.getElementById('receptAdminMenu').style.display = "block";
        document.getElementById('raavarebatchAdminMenu').style.display = "block";
        document.getElementById('produktbatchAdminMenu').style.display = "block";
        document.getElementById('afvejningMenu').style.display = "block";
    }
    if (sessionStorage.getItem('role') === "Produktionsleder") {
        document.getElementById('raavarebatchAdminMenu').style.display = "block";
        document.getElementById('produktbatchAdminMenu').style.display = "block";
        document.getElementById('afvejningMenu').style.display = "block";
    }
    if (sessionStorage.getItem('role') === "Laborant") {
        document.getElementById('afvejningMenu').style.display = "block";
    }
    if (sessionStorage.getItem('role') === "Udvikler") {
        document.getElementById('brugerAdminMenu').style.display = "block";
        document.getElementById('raavareAdminMenu').style.display = "block";
        document.getElementById('receptAdminMenu').style.display = "block";
        document.getElementById('raavarebatchAdminMenu').style.display = "block";
        document.getElementById('produktbatchAdminMenu').style.display = "block";
        document.getElementById('afvejningMenu').style.display = "block";
        document.getElementById('speceficUsertable').style.display = "none";

    }
}

/*
Author: Simon Fridolf
Github: IceMonk3y
*/
/* Loading users with the relevant role into each home-page */

function role() {
    let role = sessionStorage.getItem("role");
    if(role === 'Administrator' || role === 'Farmaceut'|| role==='Laborant'){
        document.getElementById('role').innerHTML= "Systemets: " + role+"er";
    }
    else document.getElementById('role').innerHTML= "Systemets: " + role+"e";
}

async function loadUserList() {
    let role = sessionStorage.getItem('role');
    if (role !== 'Udvikler') {
        let getAllUsersHomeURL = hostUserURL + "roles?role=" + role;
        console.log(getAllUsersHomeURL);
        console.log("Loading Users");
        await $.get(getAllUsersHomeURL, function (data, textStatus, req) {
            $("#loadUsersList").empty();
            $.each(data, function (i, user) {
                $("#loadUsersList").append(genTableHTMLForUsers((user)));
            });
        });
        document.getElementsByClassName("loader")[0].className = "loader-disabled";
    }
}
function genTableHTMLForUsers(user) {
    return  '<tr><td>' + user.id + '</td>' +
        '<td>' + user.firstname +'</td>' +
        '<td>' + user.lastname + '</td>' +
        '</tr>';
}