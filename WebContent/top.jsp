<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<%
String name=(String)session.getAttribute("flag");

%>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/cursor.js"></script>
<style type="text/css">
body{
	background-color:rgb(231,241,250);
}
          .div-inline{
             display: inline;
          }
          .div1{
             float: left;
          }
</style>

</head>
<script type="text/javascript">
	var name=<%=name%>;
	
	window.onload = function() {
		var date = new Date();  
		var y = date.getFullYear();
		var m = date.getMonth();
		var d = date.getDate();  
		var h=date.getHours();
		var m1=date.getMinutes();  
		document.getElementById('user').innerHTML="用户:"+name;
		document.getElementById('show').innerHTML=y+"年"+(m+1)+"月"+d+"日"+"  "+h+"时"+m1+"分";
		
	}//每秒执行一次
	setInterval("window.onload()","1000");
</script>
<body>

	<div>
       <img src="images/index.jpg" width="100%" height="65" alt="加载失败">
    </div>
    <div style="text-align:center;">
         <label id="show"></label> 
         &nbsp;&nbsp;&nbsp;<label id="user"></label>     
    </div>


</body>
</html>