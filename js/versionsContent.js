
$(document).ready(function() {

    $('.navbar-brand').click(function(e) {
    	// gestion des notifications push
    	var socket;
        if (window.WebSocket) {
            socket = new WebSocket("ws://localhost:8090/ws/");
          //  socket = new WebSocket("ws://echo.websocket.org");
            socket.onmessage = function (event) {
                alert("Received data from websocket: " + event.data);
            }
            socket.onopen = function (event) {
                alert("Web Socket opened!");
            };
            socket.onclose = function (event) {
                alert("Web Socket closed.");
            };
        } else {
            alert("Your browser does not support Websockets. (Use Chrome)");
        }
        function send(message) {
            if (!window.WebSocket) {
                return;
            }
            if (socket.readyState == WebSocket.OPEN) {
                socket.send(message);
            } else {
                alert("The socket is not open.");
            }
        }
        
    	
    });
	// gestion de la liste des versions
   $('.availableVersionsButton').click(function(e) {
   	e.preventDefault();
   	var isActive = $('#versionsBlock').hasClass("active");
	var html = $('#versionsBlock')[0].innerHTML;
	html = "";
	if (!isActive) {
		for (v in datas.versions) {
			html += "<p><a style='margin-right: 10px' href='deploy/" + datas.versions[v] + 
			"' download='" + "deploy/" + datas.versions[v] + 
			"' class='btn btn-lg btn-outline'><i class='fa fa-download'></i></a>" + datas.versions[v] + "</p>";
		}
		$('#versionsBlock').addClass('active');
		$('#versionsBlock')[0].innerHTML = html;
	}
	else {
		$('#versionsBlock').removeClass('active');
	}
	$('#versionsBlock').collapse('toggle');
   });
});