/* Site functionality */

// SinglePage functionality:
function displayContent(page) {
    $("body").load(page);
}

// Load header code functionality:
function includeMainHeader() {
    $("#globalHeader").load("globalHeader.html");
}

// Load footer code functionality:
function includeFooter() {
    $("#globalFooter").load("globalVertMenu.html");
}

/* End of Site functionality */
