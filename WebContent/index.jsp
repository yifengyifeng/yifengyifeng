<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.net.URLDecoder"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String name=(String)session.getAttribute("flag");
if(name==null){
	out.print("<script language='javascript'>alert('请登录！');</script>");
	response.setHeader("refresh", "0;url=login.html");
}
%>
<html>
<head>
<script src="js/jquery.js"></script>
<script src="layer/layer.js"></script>
<script src="js/pop_layer.js"></script>
<meta charset="UTF-8">
<title>河北省重大技术需求征集系统</title>

</head>

<frameset frameborder="no" rows="100px, *">
    <frame name="head" src="top.jsp">
	<frameset  cols="285px, *">
		<frame name="left" src="left.jsp">
		<frame name="myframe" src="right.html">
	</frameset>
</frameset>

</html>
