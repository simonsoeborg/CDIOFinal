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
    $(document).ready(function(){
        displayContent('home.html');
        $("#admin").hide();
        $("#bob").show();
    })
}