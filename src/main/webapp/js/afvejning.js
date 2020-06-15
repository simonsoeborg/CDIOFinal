/*
Author: Simon Søborg
Github: simonsoeborg
*/
var repeatI = 1;

function repeatObject() {
  if(repeatI < 5) {
    if(repeatI >= 1) {
      showRunAllBatchesButton();
    }
    var raavareOrig = document.getElementById('raavareOrig').id;
    var maengdeOrig = document.getElementById('maengdeOrig').id;
    var orig = document.getElementById('repeatableObject' + repeatI);
    var repeat = orig.cloneNode(true);

    repeat.id = "repeatableObject" + ++repeatI;

    document.getElementById('raavareOrig').id = raavareOrig + repeatI;
    document.getElementById('maengdeOrig').id = maengdeOrig + repeatI;

    orig.parentNode.appendChild(repeat);
  }
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
      }
    },
    error: function (jqXHR, textStatus, errorThrown) {
      alert("Unable to find receipt");
    }
  });
}
