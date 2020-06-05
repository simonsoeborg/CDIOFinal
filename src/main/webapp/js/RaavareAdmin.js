function loadRaavarerList() {
    console.log("Loading raavarer");
    $.get(hostURL, function (data, textStatus, req) {
        $("#loadAllUsers").empty();
        $.each(data, function (i, user) {
            $("#loadAllUsers").append(genTableHTMLForUsers(user));
        });
    });
}