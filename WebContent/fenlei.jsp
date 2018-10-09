<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.List,java.net.URLDecoder,com.model.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>河北省重大技术需求征集系统</title>
<style type="text/css">
body{boder:0;}
h1,h2{
	color:red;
	font-family: "Microsoft Yahei", Verdana, Arial, Helvetica, sans-serif;
}
</style>
</head>
<body>
<jsp:useBean id="needService" class="com.service.impl.NeedServiceImpl"/>
<center>
		<%
		int pageNum=1;
		int pageMax=10;
		int needNum=0;
		String fl=(String)request.getParameter("fl");
		int choose=Integer.parseInt((String)request.getParameter("choose"));
		out.print("<h1>"+fl+"</h1>");
		List<Need> v=null;
		String name=(String)session.getAttribute("flag");
		if(name==null){
			out.print("<h1>请登录！</h1>");

		}
		else{
			
			v=needService.query(choose, fl);
			needNum=v.size();
			if(needNum==0){
				out.println("<h2>此分类未有提交任何信息！</h2>");
			}
			else{
				if(needNum%pageMax==0){
					pageNum=needNum/pageMax;
				}
				else{
					pageNum=needNum/pageMax+1;
				}
				
				for(int p=1;p<=pageNum;p++){
					int pageNeedNum=pageMax;
					if(p==pageNum&&needNum%pageMax!=0){
						pageNeedNum=needNum%pageMax;
					}
					out.println("<div width='95%' height='"+pageMax+"*30+30' id='"+p+"' style='display:none;cursor:hand'>");
					out.println("<table border=1 width='95%' cellpadding='0' cellspacing='0' bordercolor='#C4DEFF'>");
					out.println("<tr height='30' bgcolor='#64FFFF'><th>序号</th><th>需求编号</th><th>提交时间</th><th>技术需求名称</th><th>审核状态</th><th>操作</th></tr>");
					for(int i=0;i<pageNeedNum;i++){
						int num=i+p*pageMax-pageMax;
						String trid="need"+i;
						out.println("<tr onMouseOut=this.style.backgroundColor='rgb(255,255,255)' onMouseOver=this.style.backgroundColor='rgb(50,200,210)' align='center' height='30'>");
						out.print("<td>"+(i+1)+"</td>");
						out.print("<td>"+v.get(i+p*pageMax-pageMax).getNum()+"</td>");
						out.print("<td>"+v.get(i+p*pageMax-pageMax).getTjsj()+"</td>");
						out.print("<td>"+v.get(i+p*pageMax-pageMax).getJsxqmc()+"</td>");
						out.print("<td>"+v.get(i+p*pageMax-pageMax).getState()+"</td>");
						out.print("<td><a style='text-decoration: none' href='only_detail.jsp?num="+v.get(i+p*pageMax-pageMax).getNum()+"'>详情</td>");
						out.print("</tr>");
					}
					out.println("</table>");
					out.println("</div>");
				}	
				
				out.println("<table border=0 width='95%' id='pagetable'>");
				out.print("<tr>");
				out.print("<td></td><td></td><td></td><td></td><td></td><td></td>");
				out.print("</tr>");
				out.print("<tr>");
				out.print("<td colspan='1'>共有"+needNum+"条记录，当前第<nobr id='pageindex'></nobr>/"+pageNum+"页</td>");
				out.print("<td colspan='1'><a style='text-decoration: none' href='#' onclick='pageFirst()'>首页</a></td>");
				out.print("<td colspan='1'><a style='text-decoration: none' href='#' onclick='pageUp()'>上一页</a></td>");
				out.print("<td colspan='1'><a style='text-decoration: none' href='#' onclick='pageDown()'>下一页</a></td>");
				out.print("<td colspan='1'><a style='text-decoration: none' href='#' onclick='pageLast()'>尾页</a></td>");
				out.print("<td colspan='1'>");
				out.print("<nobr>转到第");
				out.print("<select id='p'></select> 页");
				out.print("<a style='text-decoration: none' href='#' onclick='pageTurn()'> 跳转</a>");
				out.print("</nobr></td>");
				out.print("</tr>");
				out.println("</table>");
			} 
		}
		
		%>

</center>
</body>
</html>
<script language="javascript">
	var pageThis=1;
	var page=<%=pageNum%>;

	function pageUp(){
		if(pageThis>1){
			var a=document.getElementById(pageThis-1);
			var b=document.getElementById(pageThis);
			a.style.display='block';
			b.style.display='none';
			pageThis--;
			document.getElementById('pageindex').innerHTML=pageThis;
		}
		
	}
	function pageDown(){
		if(pageThis<page){
			var a=document.getElementById(pageThis+1);
			var b=document.getElementById(pageThis);
			a.style.display='block';
			b.style.display='none';
			pageThis++;
			document.getElementById('pageindex').innerHTML=pageThis;
		}
	}
	function pageTurn(){
		var p=document.getElementById('p').value;
		if(p!=pageThis){
			var a=document.getElementById(p);
			var b=document.getElementById(pageThis);
			a.style.display='block';
			b.style.display='none';
			pageThis=p;
			document.getElementById('pageindex').innerHTML=pageThis;
		}
	}
	function pageFirst(){
		if(pageThis!=1){
			var a=document.getElementById("1");
			var b=document.getElementById(pageThis);
			a.style.display='block';
			b.style.display='none';
			pageThis=1;
			document.getElementById('pageindex').innerHTML=pageThis;
		}
	}
	function pageLast(){
		if(pageThis!=page){
			var a=document.getElementById(page);
			var b=document.getElementById(pageThis);
			a.style.display='block';
			b.style.display='none';
			pageThis=page;
			document.getElementById('pageindex').innerHTML=pageThis;
		}
	}
	window.onload=function(){
		var c=document.getElementById("1");
		c.style.display='block';
		document.getElementById('pageindex').innerHTML=pageThis;
		loadOption();
	}
	function loadOption(){
		var p = document.getElementById("p");
		for(var i=1;i<=page;i++){
			p.add(new Option(i,i), null);
		}
	}
	
</script>