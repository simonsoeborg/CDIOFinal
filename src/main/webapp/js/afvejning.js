/*
Author: Simon Søborg
Github: simonsoeborg
*/

var IndexRepeat = 0;
var produktbatchNr = 0;
let afvejningHostURL = HostURL + 'afvejning/';

function repeatObject() {
  if(IndexRepeat < 2) {
    IndexRepeat++;

    if(IndexRepeat === 1) {
      showRunAllBatchesButton();
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
}

function executeUpdateCommands(number) {
  let postfix;

  if(produktbatchNr !== 0) {
    if(number === 0) {
      // Run only stuff from inputs in repeatableObjectZero
      postfix = "Zero";
      $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: afvejningHostURL,
        dataType: 'json',
        data: afvejningToJSON(0),
        success: function (data, textStatus, req) {
          var data0 = document.getElementById('taraBelastning' + postfix).value;
          var data1 = document.getElementById('raavare' + postfix).value;
          var data2 = document.getElementById('maengde' + postfix).value;
          document.getElementById('serverUpdateSuccess' + postfix).style.visibility = 'visible';
          console.log(data0 + ", " + data1 + ", " + data2 + " er blevet tilføjet til databasen!");
          updateProduktBatchStatus(produktbatchNr);
        }
      })
    }

    if(number === 1) {
      // Run only stuff from inputs in repeatableObjectOne
      postfix = "One";
      $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: afvejningHostURL,
        dataType: 'json',
        data: afvejningToJSON(1),
        success: function (data, textStatus, req) {
          var data0 = document.getElementById('taraBelastning' + postfix).value;
          var data1 = document.getElementById('raavare' + postfix).value;
          var data2 = document.getElementById('maengde' + postfix).value;
          document.getElementById('serverUpdateSuccess' + postfix).style.visibility = 'visible';
          console.log(data0 + ", " + data1 + ", " + data2 + " er blevet tilføjet til databasen!");
          updateProduktBatchStatus(produktbatchNr);
        }
      })
    }

    if(number === 2) {
      // Run only stuff from inputs in repeatableObjectTwo
      postfix = "Two";
      $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: afvejningHostURL,
        dataType: 'json',
        data: afvejningToJSON(2),
        success: function (data, textStatus, req) {
          var data0 = document.getElementById('taraBelastning' + postfix).value;
          var data1 = document.getElementById('raavare' + postfix).value;
          var data2 = document.getElementById('maengde' + postfix).value;
          document.getElementById('serverUpdateSuccess' + postfix).style.visibility = 'visible';
          console.log(data0 + ", " + data1 + ", " + data2 + " er blevet tilføjet til databasen!");
          updateProduktBatchStatus(produktbatchNr);
        }
      })
    }
  } else {
    alert("Du mangler at skrive et Produktbatch nummer!");
  }
}

function executeAllUpdateCommands() {
  var postfix;
  // Run all. For loop.
  if(produktbatchNr !== 0) {
    for (var i = 0; i <= IndexRepeat; i++) {
      if (i === 0) {
        postfix = "Zero";
      }
      if (i === 1) {
        postfix = "One";
      }
      if (i === 2) {
        postfix = "Two";
      }


      // Run only stuff from inputs in repeatableObjectOne
      $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: afvejningHostURL,
        dataType: 'json',
        data: afvejningToJSON(i),
        success: function (data, textStatus, req) {
          var data0 = document.getElementById('taraBelastning' + postfix).value;
          var data1 = document.getElementById('raavare' + postfix).value;
          var data2 = document.getElementById('maengde' + postfix).value;
          document.getElementById('serverUpdateSuccess' + postfix).style.visibility = 'visible';
          console.log(data0 + ", " + data1 + ", " + data2 + " er blevet tilføjet til databasen!");
          updateProduktBatchStatus(produktbatchNr);
        }
      })
    }
  } else {
    alert("Du mangler at skrive et Produktbatch nummer!")
  }
}

function afvejningToJSON(number) {
  let postfix;
  if(number === 0) {
    postfix = "Zero";
  }
  if(number === 1) {
    postfix = "One";
  }
  if(number === 2) {
    postfix = "Two";
  }

  return JSON.stringify({
    "pbid": produktbatchNr,
    "rbid": document.getElementById('raavare' + postfix).value,
    "afvejetmaengde": document.getElementById('maengde' + postfix).value,
    "tara": document.getElementById('taraBelastning' + postfix).value
  });
}

function showRunAllBatchesButton() {
  document.getElementById('runAllBatchesButton').style.display = 'block';
}

function findLaborant() {
  var hostLabURL = afvejningHostURL + 'lab?labNr=';
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
      }
    },
    error: function (jqXHR, textStatus, errorThrown) {
      alert("Unable to find laborant");
    }
  });
}

function findProduktBatch() {
  var hostPBURL = afvejningHostURL + 'pb?pbNr=';
  produktbatchNr = document.getElementById('produktbatchNr').value;
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
        getProduktBatchStatus(produktbatchNr);
        getIngredients(produktbatchNr);
        document.getElementById('ReceptList').style.display = "block";
      }
    },
    error: function (jqXHR, textStatus, errorThrown) {
      alert("Unable to find receipt");
    }
  });
}

function getProduktBatchStatus(id) {
  var hostPBStatusURL = afvejningHostURL + 'status/';
  $.ajax({
    type: 'GET',
    url: hostPBStatusURL + id,
    dataType: "text",
    success: function (result) {
      if(result == null || result == " ") {
        alert("Error using " + id + "! \nTry again or use another produktbatch nr.");
      } else {
        document.getElementById('produktionStatus').style.visibility = "visible";
        document.getElementById('produktionStatus').innerHTML = "Produktion Status: \n" + result;
      }
    },
    error: function (jqXHR, textStatus, errorThrown) {
      alert("Unable to find status");
    }
  });
}

function updateProduktBatchStatus(id) {
  var hostPBUpdateStatusURL = afvejningHostURL + 'status/update/';
  $.ajax({
    type: 'PUT',
    url: hostPBUpdateStatusURL + id,
    dataType: "text",
    success: function (result) {
      getProduktBatchStatus(id);
    },
    error: function (jqXHR, textStatus, errorThrown) {
      alert("Unable to find update status");
    }
  });
}

function getIngredients(pbId) {
  let hostURLGetIngredients = afvejningHostURL + pbId;
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
  });
}

function genTableHTMLForAfvejningTable(value) {
  let data = '<tr>' +
      '<td>'+ value.rkraavareid +'</td>' +
      '<td>' + value.rkraavarenavn +'</td>' +
      '<td>'+ value.rkmaengde + ' kg</td>' +
      '<td>'+ value.rktolerance + ' %</td>' +
      '</tr>';
  return data;
}