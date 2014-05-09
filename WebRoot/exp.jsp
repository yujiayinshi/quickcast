<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    
    <script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
	<script type="text/javascript">
	
	//Work_Edu
	function  workexp_insert(){
 		var ajax_data = $("#work_exp").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "exp.do?method=workexp_insert",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  workexp_update(){
 		var ajax_data = $("#work_exp").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "exp.do?method=workexp_update",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  queryByWorkexpId(){
 		var ajax_data = $("#work_exp").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "exp.do?method=queryByWorkexpId",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  workexp_delete(){
 		var ajax_data = $("#work_exp").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "exp.do?method=workexp_delete",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  queryByWorkuserId(){
 		var ajax_data = $("#work_exp").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "exp.do?method=queryByWorkuserId",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  deleteByWorkuserId(){
 		var ajax_data = $("#work_exp").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "exp.do?method=deleteByWorkuserId",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  deleteByWorkexpId(){
 		var ajax_data = $("#work_exp").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "exp.do?method=deleteByWorkexpId",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	
	//Edu_Exp
	function  eduexp_insert(){
 		var ajax_data = $("#edu_exp").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "exp.do?method=eduexp_insert",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  eduexp_update(){
 		var ajax_data = $("#edu_exp").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "exp.do?method=eduexp_update",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  queryByEduexpId(){
 		var ajax_data = $("#edu_exp").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "exp.do?method=queryByEduexpId",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  eduexp_delete(){
 		var ajax_data = $("#edu_exp").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "exp.do?method=eduexp_delete",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  queryByEduuserId(){
 		var ajax_data = $("#edu_exp").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "exp.do?method=queryByEduuserId",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  deleteByEduuserId(){
 		var ajax_data = $("#edu_exp").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "exp.do?method=deleteByEduuserId",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  deleteByEduexpId(){
 		var ajax_data = $("#edu_exp").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "exp.do?method=deleteByEduexpId",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	//Prj_Exp
	function  prjexp_insert(){
 		var ajax_data = $("#prj_exp").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "exp.do?method=prjexp_insert",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  prjexp_update(){
 		var ajax_data = $("#prj_exp").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "exp.do?method=prjexp_update",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  queryByPrjexpId(){
 		var ajax_data = $("#prj_exp").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "exp.do?method=queryByPrjexpId",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  prjexp_delete(){
 		var ajax_data = $("#prj_exp").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "exp.do?method=prjexp_delete",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  queryByPrjuserId(){
 		var ajax_data = $("#prj_exp").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "exp.do?method=queryByPrjuserId",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  deleteByPrjuserId(){
 		var ajax_data = $("#prj_exp").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "exp.do?method=deleteByPrjuserId",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  deleteByPrjexpId(){
 		var ajax_data = $("#prj_exp").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "exp.do?method=deleteByPrjexpId",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	</script>
</head>
<body>
     Work_Exp
     <form id="work_exp">
     exp_id:<input type=text name="exp_id"/><br/>
     user_id:<input type=text name="user_id"/><br/>
     start_time:<input type=text name="start_time"/><br/>
     end_time:<input type=text name="end_time"/><br/>
     etp_name:<input type=text name="etp_name"/><br/>
     etp_industry:<input type=text name="etp_industry"/><br/>
     etp_nature:<input type=text name="etp_nature"/><br/>
     etp_size:<input type=text name="etp_size"/><br/>
     etp_desc:<input type=text name="etp_desc"/><br/>
     profession:<input type=text name="profession"/><br/>
     work_place:<input type=text name="work_place"/><br/>
     work_duty:<input type=text name="work_duty"/><br/>
     
     <button type = "button" onclick = "workexp_insert()">workexp_insert</button>
     <button type = "button" onclick = "workexp_update()">workexp_update</button>
     <button type = "button" onclick = "queryByWorkexpId()">queryByWorkexpId</button>
     <button type = "button" onclick = "workexp_delete()">workexp_delete</button>
     <button type = "button" onclick = "queryByWorkuserId()">queryByWorkuserId</button>
     <button type = "button" onclick = "deleteByWorkuserId()">deleteByWorkuserId</button>
     <button type = "button" onclick = "deleteByWorkexpId()">deleteByWorkexpId</button>
     </form>
     
     <br/>
     Edu_Exp
     <form id="edu_exp">
     exp_id:<input type=text name="exp_id"/><br/>
     user_id:<input type=text name="user_id"/><br/>
     school_name:<input type=text name="school_name"/><br/>
     study_date:<input type=text name="study_date"/><br/>
     major:<input type=text name="major"/><br/>
     edu_bg:<input type=text name="edu_bg"/><br/>
     
     <button type = "button" onclick = "eduexp_insert()">eduexp_insert</button>
     <button type = "button" onclick = "eduexp_update()">eduexp_update</button>
     <button type = "button" onclick = "queryByEduexpId()">queryByEduexpId</button>
     <button type = "button" onclick = "eduexp_delete()">eduexp_delete</button>
     <button type = "button" onclick = "queryByEduuserId()">queryByEduuserId</button>
     <button type = "button" onclick = "deleteByEduuserId()">deleteByEduuserId</button>
     <button type = "button" onclick = "deleteByEduexpId()">deleteByEduexpId</button>
     </form>
     
     <br/>
     Prj_Exp
     <form id="prj_exp">
     exp_id:<input type=text name="exp_id"/><br/>
     user_id:<input type=text name="user_id"/><br/>
     prj_name:<input type=text name="prj_name"/><br/>
     etp_name:<input type=text name="etp_name"/><br/>
     prj_profession:<input type=text name="prj_profession"/><br/>
     start_time:<input type=text name="start_time"/><br/>
     end_time:<input type=text name="end_time"/><br/>
     prj_desc:<input type=text name="prj_desc"/><br/>
     prj_duty:<input type=text name="prj_duty"/><br/>
     prj_achievement:<input type=text name="prj_achievement"/><br/>
     
     <button type = "button" onclick = "prjexp_insert()">prjexp_insert</button>
     <button type = "button" onclick = "prjexp_update()">prjexp_update</button>
     <button type = "button" onclick = "queryByPrjexpId()">queryByPrjexpId</button>
     <button type = "button" onclick = "prjexp_delete()">prjexp_delete</button>
     <button type = "button" onclick = "queryByPrjuserId()">queryByPrjuserId</button>
     <button type = "button" onclick = "deleteByPrjuserId()">deleteByPrjuserId</button>
     <button type = "button" onclick = "deleteByPrjexpId()">deleteByPrjexpId</button>
     </form>
</body>
</html>