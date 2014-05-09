<%@ page language="java"  pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@ include file="common.jsp"%>
<script type="text/javascript">
function login(){

var ajax_data = $("#login").serialize();
var login_data = {"user_name":"3","password":"3"};
// alert(ajax_data);

 $.ajax({
        type: "post",
        url: "user_reg.do?method=login",
        data: ajax_data, 
        // dataType:"json",      
       // contentType:"application/json",    
        success: function(data) {
      var s = decodeURI(data);
     s = decodeURI(s);
         alert(s);
 //        data=JSON.parse(data);
//         if(data.login_report[0].status=="success"){
//         alert(data.login_report[0].data[0].user_type);
         
         
        }
    });

}


</script>
  </head>
  
  <body>
  <form id = "login">
    用户名：<input type=text id = "user_name"  name="user_name"/><br/>
    密  码：<input type=password name="password"/><br/>
    <button type = "button" onclick = "login()">登录</button>
   </form>
  </body>
</html>
