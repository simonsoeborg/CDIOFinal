/* *********************************************************************** */
/*
Author: Simon Søborg
Github: simonsoeborg
*/
/* Site functionality */

// SinglePage functionality:
function displayContent(page) {
    $("body").load(page);
}

// Load header code functionality:
function includeHeader() {
    $(".grid-menu").load("globalHeader.html");
}

// Load header code functionality:
function includeSideMenu() {
    $(".grid-sideMenu").load("globalSideMenu.html");
}

// Load footer code functionality:
function includeFooter() {
    $(".grid-contentFooter").load("globalFooter.html");
}

/* End of Site functionality */
/* *********************************************************************** */
