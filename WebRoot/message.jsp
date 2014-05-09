<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    
    <script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
	<script type="text/javascript">
function  insert_message(){
 var ajax_data = $("#message").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "message.do?method=imp_message_insert",
        data: ajax_data, 
        success: function(date) {
          alert("success");
          //window.location.href = "index.jsp";
        }
    });
}


function  update_message(){
 var ajax_data = $("#message").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "message.do?method=imp_message_update",
        data: ajax_data, 
        success: function(date) {
          alert("success");
          //window.location.href = "index.jsp";
        }
    });
}

function  queryByDispatchId_message(){
 var ajax_data = $("#message").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "message.do?method=imp_message_queryByDispatchId",
        data: ajax_data, 
        success: function(date) {
          alert("success");
          //window.location.href = "index.jsp";
        }
    });
}


function  queryByReceiveId_message(){
 var ajax_data = $("#message").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "message.do?method=imp_message_queryByReceiveId",
        data: ajax_data, 
        success: function(data) {
        data = decodeURIComponent(decodeURIComponent(data));
        alert(data);
          alert("success");
          //window.location.href = "index.jsp";
        }
    });
}

function  queryByMsgId_message(){
 var ajax_data = $("#message").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "message.do?method=imp_message_queryByMsgId",
        data: ajax_data, 
        success: function(date) {
          alert("success");
          //window.location.href = "index.jsp";
        }
    });
}


function  delete_message(){
 var ajax_data = $("#message").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "message.do?method=imp_message_delete",
        data: ajax_data, 
        success: function(date) {
          alert("success");
          //window.location.href = "index.jsp";
        }
    });
}

function  deleteByMsgId_message(){
 var ajax_data = $("#message").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "message.do?method=imp_message_deleteByMsgId",
        data: ajax_data, 
        success: function(date) {
          alert("success");
          //window.location.href = "index.jsp";
        }
    });
}

function  deleteByDispatchId_message(){
 var ajax_data = $("#message").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "message.do?method=imp_message_deleteByDispatchId",
        data: ajax_data, 
        success: function(date) {
          alert("success");
          //window.location.href = "index.jsp";
        }
    });
}

function  deleteByReceiveId_message(){
 var ajax_data = $("#message").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "message.do?method=imp_message_deleteByReceiveId",
        data: ajax_data, 
        success: function(date) {
          alert("success");
          //window.location.href = "index.jsp";
        }
    });
}




	</script>
</head>
<body>
     Message
     <form id="message">
     msg_id:<input type=text name="msg_id"/><br/>
     dispatch_id:<input type=text name="dispatch_id"/><br/>
     receive_id:<input type=text name="receive_id"/><br/>
     title:<input type=text name="title"/><br/>
     content:<input type=text name="content"/><br/>
     status:<input type=text name="status"/><br/>
     dispatch_time:<input type=text name="dispatch_time"/><br/>
     message_type:<input type=text name="message_type"/><br/>
     
     <button type = "button" onclick = "insert_message()">insert_message</button>
     <button type = "button" onclick = "update_message()">update_message</button>
     <button type = "button" onclick = "queryByDispatchId_message()">queryByDispatchId_message</button>
     <button type = "button" onclick = "queryByReceiveId_message()">queryByReceiveId_message</button>
     <button type = "button" onclick = "queryByMsgId_message()">queryByMsgId_message</button>
     <button type = "button" onclick = "delete_message()">delete_message</button>
     <button type = "button" onclick = "deleteByMsgId_message()">deleteByMsgId_message</button>
     <button type = "button" onclick = "deleteByDispatchId_message()">deleteByDispatchId_message</button>
     <button type = "button" onclick = "deleteByReceiveId_message()">deleteByReceiveId_message</button>
     </form>
</body>
</html>