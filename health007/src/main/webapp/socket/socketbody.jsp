 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
 
 
    <div class="chat_box" id="connect" onclick="connect();">
        	SoS
    </div>

    <div class="msg_box" style="right:200px; display:none">
        <div class="msg_head">小幫手
            <div class="close" id="disconnect" onclick="disconnect();">x</div>
        </div>
        <div class="msg_wrap">
            <div class="msg_body">
                <div class="msg_insert"></div>
            </div>
            <div class="msg_footer"><textarea class="msg_input" rows="4" style="resize: none;" id="message" onkeydown="if (event.keyCode == 13) sendMessage();"></textarea></div>
        </div>
    </div>