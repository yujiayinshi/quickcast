<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    
    <script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
	<script type="text/javascript">
	
	//Seeker_Info
	function  seekerinfo_insert(){
 		var ajax_data = $("#seeker_info").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "info.do?method=seekerinfo_insert",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  seekerinfo_update(){
 		var ajax_data = $("#seeker_info").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "info.do?method=seekerinfo_update",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  queryBySeekerInfoId(){
 		var ajax_data = $("#seeker_info").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "info.do?method=queryBySeekerInfoId",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  seekerinfo_delete(){
 		var ajax_data = $("#seeker_info").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "info.do?method=seekerinfo_delete",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  queryBySeekerUserId(){
 		var ajax_data = $("#seeker_info").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "info.do?method=queryBySeekerUserId",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  deleteBySeekerInfoId(){
 		var ajax_data = $("#seeker_info").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "info.do?method=deleteBySeekerInfoId",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  deleteBySeekerUserId(){
 		var ajax_data = $("#seeker_info").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "info.do?method=deleteBySeekerUserId",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	
	//Hunter_Info
	function  hunterinfo_insert(){
 		var ajax_data = $("#hunter_info").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "info.do?method=hunterinfo_insert",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  hunterinfo_update(){
 		var ajax_data = $("#hunter_info").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "info.do?method=hunterinfo_update",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  queryByHunterInfoId(){
 		var ajax_data = $("#hunter_info").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "info.do?method=queryByHunterInfoId",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  hunterinfo_delete(){
 		var ajax_data = $("#hunter_info").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "info.do?method=hunterinfo_delete",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  queryByHunterUserId(){
 		var ajax_data = $("#hunter_info").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "info.do?method=queryByHunterUserId",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  deleteByHunterInfoId(){
 		var ajax_data = $("#hunter_info").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "info.do?method=deleteByHunterInfoId",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  deleteByHunterUserId(){
 		var ajax_data = $("#hunter_info").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "info.do?method=deleteByHunterUserId",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	//Etp_Info
	function  etpinfo_insert(){
 		var ajax_data = $("#etp_info").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "info.do?method=etpinfo_insert",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  etpinfo_update(){
 		var ajax_data = $("#etp_info").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "info.do?method=etpinfo_update",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  queryByEtpInfoId(){
 		var ajax_data = $("#etp_info").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "info.do?method=queryByEtpInfoId",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  etpinfo_delete(){
 		var ajax_data = $("#etp_info").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "info.do?method=etpinfo_delete",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  queryByEtpUserId(){
 		var ajax_data = $("#etp_info").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "info.do?method=queryByEtpUserId",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  deleteByEtpInfoId(){
 		var ajax_data = $("#etp_info").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "info.do?method=deleteByEtpInfoId",
         	data: ajax_data, 
         	success: function(data) {
            alert(data);
            //window.location.href = "index.jsp";
        	}
    	});
	}
	
	function  deleteByEtpUserId(){
 		var ajax_data = $("#etp_info").serialize();
		 alert(ajax_data);
 		 $.ajax({
        	type: "post",
       		url: "info.do?method=deleteByEtpUserId",
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
     Seeker_Info
     <form id="seeker_info">
     info_id:<input type=text name="info_id"/><br/>
     user_id:<input type=text name="user_id"/><br/>
     mobile:<input type=text name="mobile"/><br/>
     seeker_photo:<input type=text name="seeker_photo"/><br/>
     gender:<input type=text name="gender"/><br/>
     age:<input type=text name="age"/><br/>
     marital_status:<input type=text name="marital_status"/><br/>
     highest_edu:<input type=text name="highest_edu"/><br/>
     edu_type:<input type=text name="edu_type"/><br/>
     start_time:<input type=text name="start_time"/><br/>
     end_time:<input type=text name="end_time"/><br/>
     job_status:<input type=text name="job_status"/><br/>
     self_intro:<input type=text name="self_intro"/><br/>
     work_place:<input type=text name="work_place"/><br/>
     etp_name:<input type=text name="etp_name"/><br/>
     seeker_profession:<input type=text name="seeker_profession"/><br/>
     etp_industry:<input type=text name="etp_industry"/><br/>
     tech_direction:<input type=text name="tech_direction"/><br/>
     
     <button type = "button" onclick = "seekerinfo_insert()">seekerinfo_insert</button>
     <button type = "button" onclick = "seekerinfo_update()">seekerinfo_update</button>
     <button type = "button" onclick = "seekerinfo_delete()">seekerinfo_delete</button>
     <button type = "button" onclick = "queryBySeekerInfoId()">queryBySeekerInfoId</button>
     <button type = "button" onclick = "queryBySeekerUserId()">queryBySeekerUserId</button>
     <button type = "button" onclick = "deleteBySeekerInfoId()">deleteBySeekerInfoId</button>
     <button type = "button" onclick = "deleteBySeekerUserId()">deleteBySeekerUserId</button>
     </form>
     
     <br/>
     Hunter_Info
     <form id="hunter_info">
     info_id:<input type=text name="info_id"/><br/>
     user_id:<input type=text name="user_id"/><br/>
     etp_name:<input type=text name="etp_name"/><br/>
     gender:<input type=text name="gender"/><br/>
     mobile:<input type=text name="mobile"/><br/>
     work_phone:<input type=text name="work_phone"/><br/>
     hunter_fax:<input type=text name="hunter_fax"/><br/>
     work_email:<input type=text name="work_email"/><br/>
     work_time:<input type=text name="work_time"/><br/>
     t_area:<input type=text name="t_area"/><br/>
     work_city:<input type=text name="work_city"/><br/>
     msg_addr:<input type=text name="msg_addr"/><br/>
     self_intro:<input type=text name="self_intro"/><br/>
     partner:<input type=text name="partner"/><br/>
     etp_intro:<input type=text name="etp_intro"/><br/>
     business_card:<input type=text name="business_card"/><br/>
     certificate:<input type=text name="certificate"/><br/>
     check_status:<input type=text name="check_status"/><br/>
     
     <button type = "button" onclick = "hunterinfo_insert()">hunterinfo_insert</button>
     <button type = "button" onclick = "hunterinfo_update()">hunterinfo_update</button>
     <button type = "button" onclick = "hunterinfo_delete()">hunterinfo_delete</button>
     <button type = "button" onclick = "queryByHunterInfoId()">queryByHunterInfoId</button>
     <button type = "button" onclick = "queryByHunterUserId()">queryByHunterUserId</button>
     <button type = "button" onclick = "deleteByHunterInfoId()">deleteByHunterInfoId</button>
     <button type = "button" onclick = "deleteByHunterUserId()">deleteByHunterUserId</button>
     </form>
          
     <br/>
     Etp_Info
     <form id="etp_info">
     info_id:<input type=text name="info_id"/><br/>
     user_id:<input type=text name="user_id"/><br/>
     etp_name:<input type=text name="etp_name"/><br/>
     etp_size:<input type=text name="etp_size"/><br/>
     etp_nature:<input type=text name="etp_nature"/><br/>
     etp_addr:<input type=text name="etp_addr"/><br/>
     etp_industry:<input type=text name="etp_industry"/><br/>
     etp_email:<input type=text name="etp_email"/><br/>
     msg_addr:<input type=text name="msg_addr"/><br/>
     contact_person:<input type=text name="contact_person"/><br/>
     etp_phone:<input type=text name="etp_phone"/><br/>
     etp_intro:<input type=text name="etp_intro"/><br/>
     certificate:<input type=text name="certificate"/><br/>
     check_status:<input type=text name="check_status"/><br/>
     
     <button type = "button" onclick = "etpinfo_insert()">etpinfo_insert</button>
     <button type = "button" onclick = "etpinfo_update()">etpinfo_update</button>
     <button type = "button" onclick = "etpinfo_delete()">etpinfo_delete</button>
     <button type = "button" onclick = "queryByEtpInfoId()">queryByEtpInfoId</button>
     <button type = "button" onclick = "queryByEtpUserId()">queryByEtpUserId</button>
     <button type = "button" onclick = "deleteByEtpInfoId()">deleteByEtpInfoId</button>
     <button type = "button" onclick = "deleteByEtpUserId()">deleteByEtpUserId</button>
     </form>
</body>
</html>