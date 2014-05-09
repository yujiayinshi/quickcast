<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
	<script type="text/javascript">
function getCookie(c_name)
{
if (document.cookie.length>0)
{ 
c_start=document.cookie.indexOf(c_name + "=")
if (c_start!=-1)
{ 
c_start=c_start + c_name.length+1 
c_end=document.cookie.indexOf(";",c_start)
if (c_end==-1) c_end=document.cookie.length
return unescape(document.cookie.substring(c_start,c_end))
} 
}
return ""
}
function check_cookie() {
    username = getCookie('username');
    if (username != null && username != "") {
       window.location.href = "home.jsp";
       alert(username);
    } else {

       window.location.href = "login.jsp";
    }
    
}
function delCookie(name) //删除cookie
{
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null) document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
    location.href="index.jsp";
}



function setCookie(c_name,value,expiredays)
{
var exdate=new Date()
exdate.setDate(exdate.getDate()+expiredays)
document.cookie=c_name+ "=" +escape(value)+
((expiredays==null) ? "" : "; expires="+exdate.toGMTString())
}
function exit(){
delCookie('username');
delCookie('user_id');

}

function init(){
check_cookie();

}


</script>