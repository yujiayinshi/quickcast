<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    
    <script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
	<script type="text/javascript">
function  insert_friend_list(){
 var ajax_data = $("#friend_list").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "friend_list.do?method=imp_friend_list_insert",
        data: ajax_data, 
        success: function(data) {
          alert("success");
          alert(data);
          //window.location.href = "index.jsp";
        }
    });
}


function  update_friend_list(){
 var ajax_data = $("#friend_list").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "friend_list.do?method=imp_friend_list_update",
        data: ajax_data, 
        success: function(data) {
          alert("success");
          //window.location.href = "index.jsp";
        }
    });
}


function  queryByPartnerId_friend_list(){
 var ajax_data = $("#friend_list").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "friend_list.do?method=imp_friend_list_queryByPartnerId",
        data: ajax_data, 
        success: function(data) {
          alert("success");
          //window.location.href = "index.jsp";
        }
    });
}


function  queryBySelfId_friend_list(){
 var ajax_data = $("#friend_list").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "friend_list.do?method=imp_friend_list_queryBySelfId",
        data: ajax_data, 
        success: function(data) {
          alert("success");
          //window.location.href = "index.jsp";
        }
    });
}


function  queryByRltsId_friend_list(){
 var ajax_data = $("#friend_list").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "friend_list.do?method=imp_friend_list_queryByRltsId",
        data: ajax_data, 
        success: function(data) {
          alert("success");
          //window.location.href = "index.jsp";
        }
    });
}


function  delete_friend_list(){
 var ajax_data = $("#friend_list").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "friend_list.do?method=imp_friend_list_delete",
        data: ajax_data, 
        success: function(data) {
          alert("success");
          //window.location.href = "index.jsp";
        }
    });
}


function  deleteByRltsId_friend_list(){
 var ajax_data = $("#friend_list").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "friend_list.do?method=imp_friend_list_deleteByRltsId",
        data: ajax_data, 
        success: function(data) {
          alert("success");
          //window.location.href = "index.jsp";
        }
    });
}


function  deleteByPartnerId_friend_list(){
 var ajax_data = $("#friend_list").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "friend_list.do?method=imp_friend_list_deleteByPartnerId",
        data: ajax_data, 
        success: function(data) {
          alert("success");
          //window.location.href = "index.jsp";
        }
    });
}


function  deleteBySelfId_friend_list(){
 var ajax_data = $("#friend_list").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "friend_list.do?method=imp_friend_list_deleteBySelfId",
        data: ajax_data, 
        success: function(data) {
          alert("success");
          //window.location.href = "index.jsp";
        }
    });
}


	</script>
</head>
<body>
     Friend_List
     <form id="friend_list">
     rlts_id:<input type=text name="rlts_id"/><br/>
     partner_id:<input type=text name="partner_id"/><br/>
     self_id:<input type=text name="self_id"/><br/>
     status:<input type=text name="status"/><br/>
     
     <button type = "button" onclick = "insert_friend_list()">insert_friend_list</button>
     <button type = "button" onclick = "update_friend_list()">update_friend_list</button>
     <button type = "button" onclick = "queryByPartnerId_friend_list()">queryByPartnerId_friend_list</button>
     <button type = "button" onclick = "queryBySelfId_friend_list()">queryBySelfId_friend_list</button>
     <button type = "button" onclick = "queryByRltsId_friend_list()">queryByRltsId_friend_list</button>
     <button type = "button" onclick = "delete_friend_list()">delete_friend_list()</button>
     <button type = "button" onclick = "deleteByRltsId_friend_list()">deleteByRltsId_friend_list()</button>
     <button type = "button" onclick = "deleteByPartnerId_friend_list()">deleteByPartnerId_friend_list()</button>
     <button type = "button" onclick = "deleteBySelfId_friend_list()">deleteBySelfId_friend_list</button>
     </form>
</body>
</html>