// import { setRole, getRole} from "./user";


function resetAll() {
    document.getElementById("sideMenuUL li").style.display = "none";
}

async function userLayout(obj) {
    let role = obj.id;
    console.log(role);

// Todo: Lave en løsning hvorpå information fra html klasserne kan overskrifes. (Hvilket kræver at information omkring id'et kan overføres.
    // todo: ps. show owerwritter IKKE style display none.
// Show div html based on role
    if (role === "loginAdministrator") {
        $(".farmaceut").show();
        console.log("login as Farmaceut")


       /* document.getElementsByClassName("administrator")[0].style.display="block";
        let x = document.getElementsByClassName("administrator")[0].style.display="block";
        console.log(x);*/

    }

    if (role === "loginFarmaceut"){
        $(".farmaceut").show();
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



