<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>需求详情</title>
<style type="text/css">
.bt{
	width:80%; height:35px; font-size: 24px;
        font-family:微软雅黑;background-color:aqua;
        text-align: center;border-radius:10px;
}
</style>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/cursor.js"></script>
<script type="text/javascript" src="js/pop_layer.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
</head>
<body>
<jsp:useBean id="needService" class="com.service.impl.NeedServiceImpl"/>
<jsp:useBean id="need" class="com.model.Need"/>
<center>
<%
String num=new String(request.getParameter("num").getBytes("ISO-8859-1"),"utf-8");
need=needService.findNeedByNum(num);

out.println("<table border=1 width='90%' cellpadding='0' cellspacing='0' bordercolor='aqua'>");
out.println("<tr height='30px'>");
out.print("<td width='20%'>需求名称</td>");
out.print("<td>"+need.getJsxqmc()+"</td>");

out.println("<tr>");
out.print("<td height='30px'>起始需求年份</td>");
out.print("<td>"+need.getQsxqnf()+"</td>");

out.println("<tr>");
out.print("<td height='30px'>截止需求年份</td>");
out.print("<td>"+need.getJzxqnf()+"</td>");

out.println("<tr>");
out.print("<td height='30px'>归口管理部门</td>");
out.print("<td>"+need.getGkglbm()+"</td>");

out.println("<tr>");
out.print("<td height='30px'>所在地域</td>");
out.print("<td>"+need.getSzdy()+"</td>");

out.println("<tr>");
out.print("<td height='30px'>需求编号</td>");
out.print("<td>"+need.getNum()+"</td>");

out.println("<tr height='30px'>");
out.print("<td>机构名称</td>");
out.print("<td>"+need.getJgmc()+"</td>");

out.println("<tr height='30px'>");
out.print("<td>通讯地址</td>");
out.print("<td>"+need.getTxdz()+"</td>");

out.println("<tr height='30px'>");
out.print("<td>单位网址</td>");
out.print("<td>"+need.getDwwz()+"</td>");

out.println("<tr height='30px'>");
out.print("<td>电子信箱</td>");
out.print("<td>"+need.getDzxx()+"</td>");

out.println("<tr height='30px'>");
out.print("<td>法人代表</td>");
out.print("<td>"+need.getFrdb()+"</td>");

out.println("<tr height='30px'>");
out.print("<td>邮政编码</td>");
out.print("<td>"+need.getYzbm()+"</td>");

out.println("<tr height='30px'>");
out.print("<td>联系人</td>");
out.print("<td>"+need.getLxr()+"</td>");

out.println("<tr height='30px'>");
out.print("<td>联系人电话</td>");
out.print("<td>"+need.getLxrdh()+"</td>");

out.println("<tr height='30px'>");
out.print("<td>机构属性</td>");
out.print("<td>"+need.getJgsx()+"</td>");

out.println("<tr height='120px'>");
out.print("<td>机构简介</td>");
out.print("<td>"+need.getJgjj()+"</td>");

out.println("<tr height='30px'>");
out.print("<td>学科分类</td>");
out.print("<td>"+need.getXkfl()+"</td>");

out.println("<tr height='30px'>");
out.print("<td>领域</td>");
out.print("<td>"+need.getLy()+"</td>");

out.println("<tr height='30px'>");
out.print("<td>应用行业</td>");
out.print("<td>"+need.getYyhy()+"</td>");

out.println("<tr height='300px'>");
out.print("<td>需求概述</td>");
out.print("<td>"+need.getXqgs()+"</td>");

out.println("<tr height='30px'>");
out.print("<td>研究类型</td>");
out.print("<td>"+need.getYjlx()+"</td>");

out.println("<tr height='30px'>");
out.print("<td>合作模式</td>");
out.print("<td>"+need.getHzms()+"</td>");

out.println("<tr height='30px'>");
out.print("<td>计划投资</td>");
out.print("<td>"+need.getXmzj()+"万元</td>");

out.println("<tr height='30px'>");
out.print("<td>审核状态</td>");
out.print("<td>"+need.getState()+"</td>");

out.println("</table>");
out.println("<br>");
out.println("<div class='bt' onclick=window.history.back(-1) onMouseOut=this.style.backgroundColor='aqua' onMouseOver=this.style.backgroundColor='red'><strong>返&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;回</strong></div>");

%>
</center>
</body>
</html>