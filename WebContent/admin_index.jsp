<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String name=(String)session.getAttribute("flag");
if(name==null){
	out.print("<script language='javaScript'> alert('请登录！');</script>");
	response.setHeader("refresh", "0;url=login.html");
}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>河北省重大技术需求征集系统管理员界面</title>
</head>
	<frameset frameborder="no" rows="100px, *">
    	<frame name="ahead" src="admin_top.jsp">
			<frameset  cols="285px, *">
				<frame name="aleft" src="admin_left.html">
				<frame name="aright" src="admin_right.html">
			</frameset>
	</frameset>
</html>