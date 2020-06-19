function displayBlock(id) {
    document.getElementById(id).style.display="block";
}

async function adminRole() {
    displayContent("home.html");
    await displayBlock("brugerAdminMenu");
}

function resetAll() {
    document.getElementById("sideMenuUL li").style.display = "none";
}


function admin() {
        displayContent('home.html');

}

async function userLayout() {
    var role = document.getElementsByClassName("roleButton")[0].id;
    console.log("check who is login");

// Show div html based on role
    if (role === "loginAdministrator") {
        $("div.administrator").show();
        console.log("login as Administrator")

    }

    if (role === "loginFarmaceut"){
        $("div.farmaceut").show();
        console.log("login as Farmaceut")
    }

    if (role === "loginProduktionsleder"){
        $("div.produktionsleder").show();
        console.log("login as Produktionsleder")
    }

    if (role === "loginLaborant"){
        $("div.laborant").show();
        console.log("login as Laborant")
    }

    if (role === "loginDeveloper"){
        $("div.developer").show();
        console.log("login as Developer")
    }
    await displayContent('home.html')
}
