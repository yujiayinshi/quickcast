<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'rsm_deliver.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
	<script type="text/javascript">
function  insert_deliver(){
 var ajax_data = $("#rsm_deliver").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "rsm_deliver.do?method=imp_deliver_insert",
        data: ajax_data, 
        success: function(date) {
          alert("success");
       //   window.location.href = "index.jsp";
        }
    });
}

function  update_deliver(){
 var ajax_data = $("#rsm_deliver").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "rsm_deliver.do?method=imp_deliver_update",
        data: ajax_data, 
        success: function(date) {
          alert("success");
       //   window.location.href = "index.jsp";
        }
    });
}

function  queryByDeliverId_deliver(){
 var ajax_data = $("#rsm_deliver").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "rsm_deliver.do?method=imp_deliver_queryByDeliverId",
        data: ajax_data, 
        success: function(date) {
          alert("success");
       //   window.location.href = "index.jsp";
        }
    });
}

function  queryByRsmId_deliver(){
 var ajax_data = $("#rsm_deliver").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "rsm_deliver.do?method=imp_deliver_queryByRsmId",
        data: ajax_data, 
        success: function(date) {
          alert("success");
       //   window.location.href = "index.jsp";
        }
    });
}

function  queryByHunterId_deliver(){
 var ajax_data = $("#rsm_deliver").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "rsm_deliver.do?method=imp_deliver_queryByHunterId",
        data: ajax_data, 
        success: function(date) {
          alert("success");
       //   window.location.href = "index.jsp";
        }
    });
}

function  queryByEtpId_deliver(){
 var ajax_data = $("#rsm_deliver").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "rsm_deliver.do?method=imp_deliver_queryByEtpId",
        data: ajax_data, 
        success: function(date) {
          alert("success");
       //   window.location.href = "index.jsp";
        }
    });
}


function  delete_deliver(){
 var ajax_data = $("#rsm_deliver").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "rsm_deliver.do?method=imp_deliver_delete",
        data: ajax_data, 
        success: function(date) {
          alert("success");
       //   window.location.href = "index.jsp";
        }
    });
}

function  deleteByDeliverId_deliver(){
 var ajax_data = $("#rsm_deliver").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "rsm_deliver.do?method=imp_deliver_deleteByDeliverId",
        data: ajax_data, 
        success: function(date) {
          alert("success");
       //   window.location.href = "index.jsp";
        }
    });
}

function  deleteByRsmId_deliver(){
 var ajax_data = $("#rsm_deliver").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "rsm_deliver.do?method=imp_deliver_deleteByRsmId",
        data: ajax_data, 
        success: function(date) {
          alert("success");
       //   window.location.href = "index.jsp";
        }
    });
}


</script>

  </head>
  
  <body>
    简历投递 <br/>
    <form id= "rsm_deliver">
         
           投递编号：<input type=text name="deliver_id"/><br/>
           简历编号：<input type=text name="rsm_id"/><br/>
           企业编号：<input type=text name="etp_id"/><br/>
           猎头编号：<input type=text name="hunter_id"/><br/>               
           
          <button type = "button" onclick = "insert_deliver()">insert_deliver</button>
          <button type = "button" onclick = "update_deliver()">update_deliver</button>
          <button type = "button" onclick = "queryByDeliverId_deliver()">queryByDeliverId_deliver</button>
          <button type = "button" onclick = "queryByRsmId_deliver()">queryByRsmId_deliver</button>
          <button type = "button" onclick = "queryByEtpId_deliver()">queryByEtpId_deliver</button>
          <button type = "button" onclick = "queryByHunterId_deliver()">queryByHunterId_deliver</button>
                   
          <button type = "button" onclick = "delete_deliver()">delete_deliver</button>
          <button type = "button" onclick = "deleteByDeliverId_deliver()">deleteByDeliverId_deliver</button>
          <button type = "button" onclick = "deleteByRsmId_deliver()">deleteByRsmId_deliver</button>
      </form>
  </body>
</html>
