function genTableHTMLForRecepts(recept) {
    return '<tr>' + '<td>' + recept.receptid + '</td>' +
        '<td>' + recept.receptnavn + '</td>' +
        '<td>' + recept.raavareid + '</td>' +
        '<td>' + recept.raavarenavn + '</td>' +
        '<td>' + recept.maengde + ' g</td>' +
        '<td>' + recept.tolerance + '</td>' +
        '<td><button class="btn-alert" type="submit" onclick="deleteRecept(recept.receptId);">Slet</button></td>'+
    '</tr>';
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


function receptDataCreateToJSON() {
    return JSON.stringify({
        "receptid": $('#receptid').val(),
        "receptnavn": $('#receptnavn').val(),
        "raavareid": $('#raavareid').val(),
        "raavarenavn": $('#raavarenavn').val(),
        "meangde": $('#maengde').val(),
        "tolerance": $('#tolerance').val()
    })
}

function createRecept() {
    $("#add-recept").on('click', function () {
        $.ajax({
            type: 'POST',
            url: '/CDIOFinal_war_exploded/test/recepts/',
            dataType: "json",
            data: receptDataCreateToJSON(),
            success: function (newRecept) {
                $recepts.append(genTableHTMLForRecepts(newRecept))
            }
        })
    })
}



