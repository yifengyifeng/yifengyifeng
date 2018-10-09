<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.net.URLDecoder,com.service.impl.*,com.model.User"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="userService" class="com.service.impl.UserServiceImpl"/>
<%

String userName=(String)request.getParameter("un");
userName=URLDecoder.decode(userName,"UTF-8");
String username=userName.substring(1,userName.length()-1);
System.out.println(username);
User user=userService.getUser(username);
int limit=user.getLimit();
if(limit==0){
	session.setAttribute("flag",userName);
	response.setHeader("refresh", "0;url=admin_index.jsp");
}
else{
	session.setAttribute("flag",userName);
	response.setHeader("refresh", "0;url=index.jsp");
}



%>

</body>
</html>