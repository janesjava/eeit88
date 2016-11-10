<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    
    var MyPoint = "/MyEchoServer";
    var host = window.location.host;
    var path = window.location.pathname;
    var webCtx = path.substring(0, path.indexOf('/', 1));
    var endPointURL = "ws://" + window.location.host + webCtx + MyPoint;
	var statusOutput = document.getElementById("statusOutput");
	var webSocket;
	
	function connect() {
		// 建立 websocket 物件
		webSocket = new WebSocket(endPointURL);
		
		webSocket.onopen = function(event) {
			updateStatus("WebSocket 成功連線");

			document.getElementById('connect').disabled = true;
			document.getElementById('disconnect').disabled = false;
		};

		webSocket.onmessage = function(event) {	//只要服務器端發送了消息，我們就可以通過onmessage拿到發送的數據

	        var jsonObj = JSON.parse(event.data);
// 	        var message = jsonObj.userName + " ： " + jsonObj.message + "\r\n";
	        var message = jsonObj.message + "\r\n";


			if(jsonObj.userName=="Customer"){
				$("<div class='msg_a'> " + message + "</div>").insertBefore('.msg_insert');
			}else{
				$("<div class='msg_b'> " + message + "</div>").insertBefore('.msg_insert');
			}

	        $('.msg_body').scrollTop($('.msg_body')[0].scrollHeight);
		};

		webSocket.onclose = function(event) {
			updateStatus("WebSocket 已離線");
		};
	}
	
	

	var inputUserName = "Customer";

	
	function sendMessage() {

	    var userName = inputUserName;

	    
	    var inputMessage = document.getElementById("message");
	    var message = inputMessage.value.trim();
	    
	    if (message == ""){
	        alert ("訊息請勿空白!");
	        inputMessage.focus();	
	    }else{
	        var jsonObj = {"userName" : userName, "message" : message};
	        webSocket.send(JSON.stringify(jsonObj));	//字串化  //向遠程伺服器發送數據
	        inputMessage.value = "";
	        inputMessage.focus();
	    }
	}

	
	function disconnect () {
		webSocket.close();
		document.getElementById('connect').disabled = false;
		document.getElementById('disconnect').disabled = true;
	}

	
	function updateStatus(newStatus) {	//顯示:成功連線
		statusOutput.innerHTML = newStatus;
	}
    
</script>