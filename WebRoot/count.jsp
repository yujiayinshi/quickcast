<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

     <style type="text/css">

      text {
        font-family: sans-serif;
        font-size: 12px;
        fill: white;
      }

    </style>
    <script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="http://d3js.org/d3.v3.min.js"></script>
	<script type="text/javascript">
	var count;
function  imp_count_queryByCountUserId(){
 var ajax_data = $("#count").serialize();
 alert(ajax_data);
 $.ajax({
        type: "get",
        url: "count.do?method=imp_count_queryByCountUserId",
      
        success: function(data) {
          alert("success");
          var s = decodeURIComponent(data);
          s = decodeURIComponent(s);
          
          s=JSON.parse(s);
        console.log(s.count[0].seeker_num);  
          count = [s.count[0].seeker_num,s.count[0].hunter_num,s.count[0].etp_num,s.count[0].other_num];
          alert(s);
           var w = 300;
      var h = 300;
      var dataset = count;

      var outerRadius = w / 2;
      var innerRadius = w / 4;
      var arc = d3.svg.arc()
              .innerRadius(innerRadius)
              .outerRadius(outerRadius);
      
      var pie = d3.layout.pie();
      
      //Easy colors accessible via a 10-step ordinal scale
      var color = d3.scale.category10();

      //Create SVG element
      var svg = d3.select("body")
            .append("svg")
            .attr("width", w)
            .attr("height", h);
      
      //Set up groups
      var arcs = svg.selectAll("g.arc")
              .data(pie(dataset))
              .enter()
              .append("g")
              .attr("class", "arc")
              .attr("transform", "translate(" + outerRadius + "," + outerRadius + ")");
      
      //Draw arc paths
      arcs.append("path")
          .attr("fill", function(d, i) {
            return color(i);
          })
          .attr("d", arc);
      
      //Labels
      arcs.append("text")
          .attr("transform", function(d) {
            return "translate(" + arc.centroid(d) + ")";
          })
          .attr("text-anchor", "middle")
          .text(function(d) {
            return d.value;
          });
          //window.location.href = "index.jsp";
        }
    });
}


function  imp_count_queryByCountRsmhandleEtpId(){
 var ajax_data = $("#count").serialize();
 alert(ajax_data);
 $.ajax({
        type: "post",
        url: "count.do?method=imp_count_queryByCountRsmhandleEtpId",
        data: ajax_data,
      
        success: function(data) {
          alert("success");
          var s = decodeURIComponent(data);
          s = decodeURIComponent(s);
          
          s=JSON.parse(s);
          console.log(s);  
          count = [s.count[0].handle_num,s.count[0].receive_num];
          alert(s);
      var w = 300;
      var h = 300;
      var dataset = count;

      var outerRadius = w / 2;

      var arc = d3.svg.arc()
              .outerRadius(outerRadius);
      
      var pie = d3.layout.pie();
      
      //Easy colors accessible via a 10-step ordinal scale
      var color = d3.scale.category10();

      //Create SVG element
      var svg = d3.select("body")
            .append("svg")
            .attr("width", w)
            .attr("height", h);
      
      //Set up groups
      var arcs = svg.selectAll("g.arc")
              .data(pie(dataset))
              .enter()
              .append("g")
              .attr("class", "arc")
              .attr("transform", "translate(" + outerRadius + "," + outerRadius + ")");
      
      //Draw arc paths
      arcs.append("path")
          .attr("fill", function(d, i) {
            return color(i);
          })
          .attr("d", arc);
      
      //Labels
      arcs.append("text")
          .attr("transform", function(d) {
            return "translate(" + arc.centroid(d) + ")";
          })
          .attr("text-anchor", "middle")
          .text(function(d) {
            return d.value;
          });
          //window.location.href = "index.jsp";
        }
    });
}


function  imp_count_queryByCountWorkPlaceId(){
 var ajax_data = $("#count").serialize();
 alert(ajax_data);
 $.ajax({
        type: "get",
        url: "count.do?method=imp_count_queryByCountWorkPlaceId",
      
        success: function(data) {
          alert("success");
          var s = decodeURIComponent(data);
          s = decodeURIComponent(s);
          
          s=JSON.parse(s);
        console.log(s.count[0].beijing_num);   
          count = [s.count[0].beijing_num,s.count[0].shanghai_num,s.count[0].anhui_num,s.count[0].chongqing_num,s.count[0].fujian_num,s.count[0].gansu_num,s.count[0].guangdong_num,s.count[0].guangxi_num,s.count[0].guizhou_num,s.count[0].hainan_num,s.count[0].hebei_num,s.count[0].heilongjiang_num,s.count[0].henan_num,s.count[0].hubei_num,s.count[0].hunan_num,s.count[0].neimenggu_num,s.count[0].jiangsu_num,s.count[0].jiangxi_num,s.count[0].jilin_num,s.count[0].liaoning_num,s.count[0].ningxia_num,s.count[0].qinghai_num,s.count[0].shanxi_num,s.count[0].shandong_num,s.count[0].shan_num,s.count[0].sichuan_num,s.count[0].tianjin_num,s.count[0].xizang_num,s.count[0].xinjiang_num,s.count[0].yunnan_num,s.count[0].zhejiang_num ];
          alert(s);
           var w = 300;
      var h = 300;
      var dataset = count;

      var outerRadius = w / 2;
      var innerRadius = w / 4;
      var arc = d3.svg.arc()
              .innerRadius(innerRadius)
              .outerRadius(outerRadius);
      
      var pie = d3.layout.pie();
      
      //Easy colors accessible via a 10-step ordinal scale
      var color = d3.scale.category10();

      //Create SVG element
      var svg = d3.select("body")
            .append("svg")
            .attr("width", w)
            .attr("height", h);
      
      //Set up groups
      var arcs = svg.selectAll("g.arc")
              .data(pie(dataset))
              .enter()
              .append("g")
              .attr("class", "arc")
              .attr("transform", "translate(" + outerRadius + "," + outerRadius + ")");
      
      //Draw arc paths
      arcs.append("path")
          .attr("fill", function(d, i) {
            return color(i);
          })
          .attr("d", arc);
      
      //Labels
      arcs.append("text")
          .attr("transform", function(d) {
            return "translate(" + arc.centroid(d) + ")";
          })
          .attr("text-anchor", "middle")
          .text(function(d) {
            return d.value;
          });
          //window.location.href = "index.jsp";
        }
    });
}

     
</script>
</head>
<body>  
     <form id="count">
     id:<input type=text name="id"/><br/>
      etp_id:<input type=text name="etp_id"/><br/>
      handle_num:<input type=text name="handle_num"/><br/>
      receive_num:<input type=text name="receive_num"/><br/>
      handle_rate:<input type=text name="handle_rate"/><br/>  
     <button type = "button" onclick = "imp_count_queryByCountUserId()">imp_count_queryByUserType</button>
     <button type = "button" onclick = "imp_count_queryByCountRsmhandleEtpId()">imp_count_queryByCountRsmhandleEtpId</button>
      <button type = "button" onclick = "imp_count_queryByCountWorkPlaceId()">imp_count_queryByCountRsmhandleEtpId</button>
     </form>
</body>
</html>