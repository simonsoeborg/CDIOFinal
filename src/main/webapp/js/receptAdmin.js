function genTableHTMLForRecepts(recept) {
    return '<tr>' + '<td>' + recept.receptid + '</td>' +
        '<td>' + recept.receptname + '</td>' +
        '<td>' + recept.raavareid + '</td>' +
        '<td>' + recept.maengde + '</td>' +
        '<td>' + recept.tolerance + '</td>' +
       /* '<td><button class="btn-warning" type="submit" onclick="editUser(' + recept.receptid + ');">Ret</button></td>' +
        '<td><button class="btn-alert" type="submit" onclick="deleteUser(' + recept.receptid + ');">Slet</button></td>' +*/
        '</tr>'
}

function loadRecepts() {
    let loadReceptUrl = '/CDIOFinal_war_exploded/test/recepts/';
    console.log("Loading Recepts");
    $.get(loadReceptUrl, function (data, textStatus, req) {
        $("#loadAllRecepts").empty();
        $.each(data, function (i, recept) {
            $("#loadAllRecepts").append(genTableHTMLForRecepts(recept));
        });
    });
}


function dataCreateToJSON() {
    return JSON.stringify({
        "receptid": $('#receptid').val(),
        "receptname": $('#receptname').val(),
        "raavareid": $('#raavareid').val(),
        "meangde": $('#maengde').val(),
        "tolerance": $('#tolerance').val()
    })
}

function createUser() {
    $("#add-recept").on('click', function () {
        $.ajax({
            type: 'POST',
            url: '/CDIOFinal_war_exploded/test/recepts/',
            dataType: "json",
            data: dataCreateToJSON(),
            success: function (newRecept) {
                $recepts.append(genTableHTMLForRecepts(newRecept))
            }
        })
    })
}



