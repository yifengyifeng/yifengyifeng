<%@ page language="java" contentType="text/html; charset=UTF-8" import="com.model.*,com.service.impl.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	margin: 1;
	padding: 0;
	font-size: 16px;
	font-family: "Microsoft Yahei", Verdana, Arial, Helvetica, sans-serif;
	
}
.menuMargin{
	background-color:#36F;
	width:100%;
	height:5px;
}
.menuBorder{
	background-color:#36F;
	width:100%;
	height:2px;
}
.menuMain{
	background-color:aqua;
	width:100%;
	text-align:center;
	height:45px;
	line-height:45px;
}
.menuListBody{
	background-color:#FFF;
	width:100%;
	height:auto;
	text-align:center;
	display:none;
}
.menuList{
	background-color:#FFF;
	width:100%;
	height:35px;
	text-align:center;	
	line-height:35px
}
a{
	text-decoration:none;
	display: block;	
}
</style>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/cursor.js"></script>
</head>
<jsp:useBean id="userService" class="com.service.impl.UserServiceImpl"/>
<jsp:useBean id="limitService" class="com.service.impl.LimitServiceImpl"/>
<%
String name=(String)session.getAttribute("flag");
if(name==null){
	out.print("<script language='javascript'>alert('请登录！');</script>");
	response.setHeader("refresh", "0;url=login.html");
}
name=name.substring(1, name.length()-1);
System.out.println(name);
User us=userService.getUser(name);
int limi=us.getLimit();
Limit limit=limitService.findLimitById(limi);
%>
<body>
<div class="menuMargin">
    </div>
    <div class="menuMain" id="dTop">
    	<strong>需求征集</strong>
    </div>
    <div class="menuListBody" id="ddTop">
    	<div class="menuList"> <a target="myframe" href="needsub.jsp" id="addneed">在线填报</a></div>
		<div class="menuList"> <a target="myframe" href="myneed.html">我的需求</a></div>
		<div class="menuList"> <a target="myframe" href="AllNeed.html" id="allneed">所有需求</a></div>
		<div class="menuList"> <a target="myframe" href="admin_allneed.html" id="checkneed">审核需求</a></div>
		<div class="menuList"> <a target="myframe" href="staneed.jsp" id="staneed">统计需求</a></div>
		<div class="menuList"> <a target="myframe" href="flll.html" id="query1">分类浏览</a></div>
		<div class="menuList"> <a target="myframe" href="gaoji.html" id="query2">高级检索</a></div>
    </div>
    
    <div class="menuBorder"></div>

    <div class="menuMain" id="dBott">
    	<strong>个人管理</strong>
    </div>
    <div class="menuListBody" id="ddBott">
    	<div class="menuList"> <a target="myframe" href="alterpwd.html" id="uppwd">修改密码</a></div>
		<div class="menuList"> <a target="myframe" href="registerin.html">用户注册</a></div>
		<div class="menuList"> <a target="myframe" href="exit.jsp">安全退出</a> </div>
    </div>
    <div class="menuMargin">
    </div>
</body>
</html>
<script type="text/javascript"> 
$(document).ready(function(){
	
	$("#dTop").click(function(){
		$("#ddTop").slideToggle("slow");
	});
	$("#dBott").click(function(){
		$("#ddBott").slideToggle("slow");
	});
	
	$("a").mouseout(
		function(){
			$(this).css("background-color","#FFF");	
		}
	);
	$("a").mouseover(
		function(){
			$(this).css("background-color","#09F");	
		}
	);
	
});
window.onload=function(){
	var ll=new Array(<%=limit.isAllneed()%>,<%=limit.isAddneed()%>,<%=limit.isCheckneed()%>,<%=limit.isUppwd()%>,
						<%=limit.isStaneed()%>,<%=limit.isQueryneed()%>);
	var idl=new Array("#allneed","#addneed","#checkneed","#uppwd","#staneed","#query1","#query2");
	for(var i=0;i<5;i++){
		if(ll[i]==false){
			$(idl[i]).attr("href","nolimit.html"); 
		}
	}
	if(ll[5]==false){
		$(idl[5]).attr("href","nolimit.html"); 
		$(idl[6]).attr("href","nolimit.html"); 
	}
}
</script>