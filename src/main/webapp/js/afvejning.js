
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
  var labNr = document.getElementById('labNr').value;
  console.log(labNr);
  $.ajax({
    type: 'GET',
    url: hostURL + labNr,
    dataType: "json",
    success: function (result) {
      console.log(result);
      document.getElementById('labNameResponse').innerHTML = "Hej " + result;
    },
    error: function (jqXHR, textStatus, errorThrown) {
      alert("Unable to find laborant");
    }
  });
}
