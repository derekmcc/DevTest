window.onload = makeRequest;
var xhr = false;

function makeRequest() {
	if (window.XMLHttpRequest) {
	// code for IE7+, Firefox, Chrome, Opera, Safari	
		xhr = new XMLHttpRequest();
	}
	else {	
		if (window.ActiveXObject) {
		// code for IE6, IE5
			try {
			xhr = new activeXObject("Microsoft.XMLHTTP");
			}
			catch (e) { }
		}}
	// if xhr contains a value
	if (xhr) {
	// if there is a change of state calls function showContents
	// it opens the file first and then sends the request and then
	// calls showContents
		myFunction(xhr);
	// Uses the GET command to get the colors.xml file, true is 	// for asynchronous	
		xhr.open("GET", "http://localhost/part3.xml", true);
	// Sends the request	
		xhr.send(null);
	}
	else {
	// put an error message into the body with id "updateArea" 	// on HTML document
		document.getElementById("updateArea").innerHTML = "Sorry, but I couldn't create an XMLHttpRequest";
	}
}
function showContents() {
// if readystate = 4 => complete
	if (xhr.readyState == 4) {
	// if status = 200 => ok
		if (xhr.status == 200) {
		// get the response, ie xml file
			var outMsg = xhr.responseText;
		}
		//else {
		//	var outMsg = "There was a problem with the 			request " + xhr.status;
		//}
		// display the xml details in the "updateArea"
		document.getElementById("updateArea").innerHTML = outMsg;
	}
}

function myFunction(xml) {
  var x, i, xmlDoc, txt;
  xmlDoc = xml.responseXML;
  txt = "";
  x = xmlDoc.getElementsByTagName("AccountCode");
  for (i = 0; i< x.length; i++) {
    txt += x[i].childNodes[0].nodeValue + "<br>";
  }
  document.getElementById("updateArea").innerHTML = txt;
}
