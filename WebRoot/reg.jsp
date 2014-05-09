<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
<%@ include file="common.jsp"%>
<script type="text/javascript">

//注册
function  reg(){
 var ajax_data = $("#reg").serialize();
 //alert(ajax_data);
 $.ajax({
        type: "post",
        url: "user_reg.do?method=reg",
        data: ajax_data, 
        success: function(data) {
         if(data != "false"){
          alert(data);
          
         
         }
         else alert("something wrong!");
         
         // alert(data);
         // window.location.href = "index.jsp";
        }
    });
 
}

function check_uname(){
     var x = document.getElementById("user_name").value;
     
      $.ajax({
        type: "post",
        url: "user_reg.do?method=check_uname",
        data: {user_name:x},
        success: function(data) {

        alert(data);
        }
    });

}


function check_email(){
var x = document.getElementById("email").value;

 $.ajax({
        type: "post",
        url: "user_reg.do?method=check_email",
        data: {email:x},
        success: function(data) {
        alert(data);
        }
    });


}

</script>


<title>Insert title here</title>
</head>
<body>
      <form id = "reg">
           用户名：<input type=text id = "user_name"  name="user_name" onchange = "check_uname()" /><br/>
           密  码：<input type=password name="password"/><br/>
                    中文名：<input type=text id = "cn_tname"  name="cn_tname" /><br/>
                    英文名：<input type=text id = "eng_name"  name="eng_name"  /><br/>
            邮 箱：<input type=text id = "email"  name="email" onchange = "check_email()" /><br/>
          
          <button type = "button" onclick = "reg()" >注册</button>
      </form>

</body>
</html>