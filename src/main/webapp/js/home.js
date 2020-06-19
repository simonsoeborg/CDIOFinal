// import { setRole, getRole} from "./user";


function resetAll() {
    document.getElementById("sideMenuUL li").style.display = "none";
}

function welcome() {
    let role = sessionStorage.getItem("role");
    document.getElementById('scriptName').innerHTML="Velkommen - Du er logget ind som " + role;
}


async function userLayout(obj) {
    let role = obj.id;
    sessionStorage.setItem('role', role);

    displayContent('home.html');
}


function access() {
    let role = sessionStorage.getItem('role');
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
    }
}


