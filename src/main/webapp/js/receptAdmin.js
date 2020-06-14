
$(function (){
    var $recepts = $('#recepts');
    $.ajax({
        type: 'GET',
        url: '/CDIOFinal_war_exploded/test/recepts/',
        success: function(recepts){
            $.each(recepts, function(i, recept){
                $recepts.append('<li>ReceptID: ' + recept.receptid + ', drink:' + recept.receptname + '</li>');
            });
        },
        error: function () {
            alert("error loading recepts")
        }
    })
});

function dataCreateToJSON() {
    return JSON.stringify({
        "receptid": $('#receptid').val(),
        "receptname": $('#lastname').val(),
    });
}

function createUser(){
    var $receptid = $('#receptid');
    var $receptname = $('#receptname');
    $("#add-recept").on('click', function(){
        $.ajax({
            type: 'POST',
            dataType: "json",
            data: dataCreateToJSON(),
            success: function(newRecept){
                $recepts.append('<li>ReceptID: ' + newRecept.receptid + ', drink:' + newRecept.receptname + '</li>');
            }
    });
}


