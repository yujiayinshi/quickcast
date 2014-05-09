<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    
    <script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
	<script type="text/javascript">
function  insert_news(){
 var ajax_data = $("#news").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "news.do?method=imp_news_insert",
        data: ajax_data, 
        success: function(date) {
          alert("success");
          //window.location.href = "index.jsp";
        }
    });
}


function  update_news(){
 var ajax_data = $("#news").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "news.do?method=imp_news_update",
        data: ajax_data, 
        success: function(date) {
          alert("success");
          //window.location.href = "index.jsp";
        }
    });
}

function  queryByPubId_news(){
 var ajax_data = $("#news").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "news.do?method=imp_news_queryByPubId",
        data: ajax_data, 
        success: function(date) {
          alert("success");
          //window.location.href = "index.jsp";
        }
    });
}


function  queryByNewsId_news(){
 var ajax_data = $("#news").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "news.do?method=imp_news_queryByNewsId",
        data: ajax_data, 
        success: function(date) {
          alert("success");
          //window.location.href = "index.jsp";
        }
    });
}

function  delete_news(){
 var ajax_data = $("#news").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "news.do?method=imp_news_delete",
        data: ajax_data, 
        success: function(date) {
          alert("success");
          //window.location.href = "index.jsp";
        }
    });
}


function  deleteByPubId_news(){
 var ajax_data = $("#news").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "news.do?method=imp_news_deleteByPubId",
        data: ajax_data, 
        success: function(date) {
          alert("success");
          //window.location.href = "index.jsp";
        }
    });
}

function  deleteByNewsId_news(){
 var ajax_data = $("#news").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "news.do?method=imp_news_deleteByNewsId",
        data: ajax_data, 
        success: function(date) {
          alert("success");
          //window.location.href = "index.jsp";
        }
    });
}

function  deleteByNewsId_news(){
 var ajax_data = $("#news").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "news.do?method=imp_news_deleteByNewsId",
        data: ajax_data, 
        success: function(date) {
          alert("success");
          //window.location.href = "index.jsp";
        }
    });
}

function  imp_news_display(){
 var ajax_data = $("#news").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "news.do?method=imp_news_display",
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
     News 
     <form id="news">
     news_id:<input type=text name="news_id"/><br/>
     pub_id:<input type=text name="pub_id"/><br/>
     content:<input type=text name="content"/><br/>
     
     <button type = "button" onclick = "imp_news_display()">imp_news_display</button>
     <button type = "button" onclick = "insert_news()">insert_news</button>
     <button type = "button" onclick = "update_news()">update_news</button>
     <button type = "button" onclick = "queryByPubId_news()">queryByPubId_news</button>
     <button type = "button" onclick = "queryByNewsId_news()">queryByNewsId_news</button>
     <button type = "button" onclick = "delete_news()">delete_news</button>
     <button type = "button" onclick = "deleteByPubId_news()">deleteByPubId_news</button>
     <button type = "button" onclick = "deleteByNewsId_news()">deleteByNewsId_news</button>
     </form>
     
     <form id="news-pub">
     <textarea name="post-text" rows="2" cols="40"></textarea>
     <input type="submit"  value="发布"/>
     </form>
</body>
</html>