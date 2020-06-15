/*
Author: Simon Søborg
Github: simonsoeborg
*/



var IndexRepeat = 0;

function repeatObject() {
  if(IndexRepeat < 2) {
    IndexRepeat++;
    if(IndexRepeat >= 1) {
      showRunAllBatchesButton();
    }

    if(IndexRepeat === 1) {
      document.getElementById('repeatableObjectOne').style.display = "block";
      document.getElementById('repeatableObjectOne').style.visibility = "visible";

    }

    if (IndexRepeat === 2) {
      document.getElementById('repeatableObjectTwo').style.display = "block";
      document.getElementById('repeatableObjectTwo').style.visibility = "visible";
    }

  } else {
    alert("Der kan kun tilføjes max 3 afvejninger af gangen.");
  }

  if(repeatI < 5) {
    if(repeatI >= 1) {
      showRunAllBatchesButton();
    }
  }
}

function executeUpdateCommands(number) {
  let afvejningHostURL = '/CDIOFinal_war_exploded/test/afvejning/';

  if(number === 0) {
    // Run only stuff from inputs in repeatableObjectZero
    $.ajax({
      type: 'POST',
      contentType: 'application/json',
      url: afvejningHostURL,
      dataType: 'json',
      data: afvejningToJSONZero(),
      success: function (data, textStatus, req) {
        var data0 = document.getElementById('taraBelastningZero').val();
        var data1 = document.getElementById('raavareZero').val();
        var data2 = document.getElementById('maengdeZero').val();
        alert(data0 + ", " + data1 + ", " + data2 + " er blevet tilføjet til databasen!");
      },
      error: function () {

      }
    })
  }

  if(number === 1) {
    // Run only stuff from inputs in repeatableObjectOne

  }

  if(number === 2) {
    // Run only stuff from inputs in repeatableObjectTwo

  }

  if(number === 9) {
    // Run all. For loop.
  }
}

function afvejningToJSONZero() {
  return JSON.stringify({
    "tara": $('#taraBelastningZero').val(),
    "rbid": $('#raavareZero').val(),
    "rbId": $('#maengdeZero').val()
  });
}

function afvejningToJSONOne() {
  return JSON.stringify({
    "tara": $('#taraBelastningOne').val(),
    "rbid": $('#raavareOne').val(),
    "rbId": $('#maengdeOne').val()
  });
}

function afvejningToJSONTwo() {
  return JSON.stringify({
    "tara": $('#taraBelastningTwo').val(),
    "rbid": $('#raavareTwo').val(),
    "rbId": $('#maengdeTwo').val()
  });
}

function showRunAllBatchesButton() {
  document.getElementById('runAllBatchesButton').style.display = 'block';
}

function findLaborant() {
  var hostLabURL = '/CDIOFinal_war_exploded/test/afvejning/lab?labNr=';
  var labNr = document.getElementById('labNr').value;
  $.ajax({
    type: 'GET',
    url: hostLabURL + labNr,
    dataType: "text",
    success: function (result) {
      if(result == null || result == " ") {
        alert("Error using " + labNr + "! \nTry again or use another laborant nr.");
      } else {
        document.getElementById('labNameResponse').innerHTML = "Laborant: " + result;
        document.getElementById('wrapper').style.display = "block";
        document.getElementById('afvejningStep1').style.display = "none";
        document.getElementById('produktionStatus').style.visibility = "visible";
      }
    },
    error: function (jqXHR, textStatus, errorThrown) {
      alert("Unable to find laborant");
    }
  });
}

function findProduktBatch() {
  var hostPBURL = '/CDIOFinal_war_exploded/test/afvejning/pb?pbNr=';
  var produktbatchNr = document.getElementById('produktbatchNr').value;
  $.ajax({
    type: 'GET',
    url: hostPBURL + produktbatchNr,
    dataType: "text",
    success: function (result) {
      if(result == null || result == " ") {
        alert("Error using " + produktbatchNr + "! \nTry again or use another produktbatch nr.");
      } else {
        document.getElementById('receptNameResponse').innerHTML = "Recept: " + result;
        document.getElementById('produktBatchAndReceptName').style.display = "none";
        getIngredients(produktbatchNr);
      }
    },
    error: function (jqXHR, textStatus, errorThrown) {
      alert("Unable to find receipt");
    }
  });
}

function getIngredients(pbId) {
  let hostURLGetIngredients = "/CDIOFinal_war_exploded/test/afvejning/" + pbId;

  $.ajax({
    type: 'GET',
    contentType: 'application/json',
    url: hostURLGetIngredients,
    dataType: 'json',
    success: function (data, textStatus, req) {
      $.each(data, function (index, value) {
        $("#getIngredients").append(genTableHTMLForAfvejningTable(value))
      })
    },
    error: function (jqXHR, textStatus, errorThrown) {
      console.log('Der skete en fejl ved forsøg på indhentning af data' + textStatus);
    }
  })
}

function genTableHTMLForAfvejningTable(value) {
  let data = '<tr>' +
              '<td>'+ value.raavareId +'</td>' +
              '<td>' + value.raavarenavn +'</td>' +
              '<td>'+ value.maengde + '</td>' +
              '<td>'+ value.tolerance + '</td>';
  return data;
}