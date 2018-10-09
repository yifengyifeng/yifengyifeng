<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><h1 color="red">安全退出中...</h1></center>
<%
session.invalidate();
%>

</body>
</html>
<script>
	window.onload=function(){
		window.setTimeout("parent.location.href='login.html'",100); 
	}
</script>