
var repeatI = 1;

function repeatObject() {
  var orig = document.getElementById('repeatableObject' + repeatI);
  var repeat = orig.cloneNode(true);

  repeat.id = "repeatableObject" + ++repeatI;

  repeat.onclick = repeatObject;
  orig.parentNode.appendChild(repeat);

}

var hostURL = '/CDIOFinal_war_exploded/test/afvejning/';

function findLaborant() {
  var hostLabURL = '/CDIOFinal_war_exploded/test/afvejning/lab?labNr=';
  var labNr = document.getElementById('labNr').value;
  $.ajax({
    type: 'GET',
    url: hostLabURL + labNr,
    dataType: "text",
    success: function (result) {
      document.getElementById('labNameResponse').innerHTML = "Laborant: " + result;
      document.getElementById('afvejningStep1').style.display = "none";
      document.getElementById('produktionStatus').style.visibility = "visible";
    },
    error: function (jqXHR, textStatus, errorThrown) {
      alert("Unable to find laborant");
    }
  });
}

function findProduktBatch() {
  var hostPBURL = '/CDIOFinal_war_exploded/test/afvejning/pb/';
  var produktbatchNr = document.getElementById('produktbatchNr').value;
  $.ajax({
    type: 'GET',
    url: hostPBURL + produktbatchNr,
    dataType: "text",
    success: function (result) {
      document.getElementById('receptNameResponse').innerHTML = "Recept: " + result;
    },
    error: function (jqXHR, textStatus, errorThrown) {
      alert("Unable to find receipt");
    }
  });
}
