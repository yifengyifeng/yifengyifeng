<%@ page language="java" contentType="text/html; charset=UTF-8" import="com.service.impl.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery.js"></script>
<script src="layer/layer.js"></script>
<script src="js/pop_layer.js"></script>
<script src="layui/layui.js"></script>
<link rel="stylesheet" href="layui/css/layui.css">
</head>
<jsp:useBean id="needService" class="com.service.impl.NeedServiceImpl"/>
<%
int yNum=needService.getNeedNumByState("已通过");
int bNum=needService.getNeedNumByState("被退回");
int wNum=needService.getNeedNumByState("未审核");
int sum=yNum+bNum+wNum;
int z=yNum*100/sum;
int y=bNum*100/sum;
int x=100-z-y;
System.out.println(sum+"|"+x+"|"+y+"|"+z);
%>
<body>
<br><br>
<div class="site-demo-button" style="margin-top: 20px; margin-bottom: 0;">
  <button class="layui-btn site-demo-active" data-type="loading">开始统计</button>
</div>

<br><br>
<fieldset class="layui-elem-field layui-field-title">
    <legend>未审核：</legend>
 </fieldset>
<div height="100" class="layui-progress layui-progress-big" lay-showpercent="true" lay-filter="demo1">
  <div class="layui-progress-bar layui-bg-red" lay-percent="0%" st="未审核" id="wsh"></div>
</div>

<br><br>
<fieldset class="layui-elem-field layui-field-title">
    <legend>被退回：</legend>
 </fieldset>
<div height="100" class="layui-progress layui-progress-big" lay-showpercent="true" lay-filter="demo2">
  <div class="layui-progress-bar layui-bg-red" lay-percent="0%" st="被退回" id="bth"></div>
</div>
<br><br>

<fieldset class="layui-elem-field layui-field-title">
    <legend>已通过：</legend>
 </fieldset>
<div height="100" class="layui-progress layui-progress-big" lay-showpercent="true" lay-filter="demo3">
  <div class="layui-progress-bar layui-bg-red" lay-percent="0%" st="已通过" id="ytg"></div>
</div>
</body>
</html>
<script>
layui.use('element', function(){
	var x=<%=x%>;
	var y=<%=y%>;
	var z=<%=z%>;
  var $ = layui.jquery
  ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
  
  //触发事件
  var active = {
		  loading: function(othis){
      var DISABLED = 'layui-btn-disabled';
      if(othis.hasClass(DISABLED)) return;
    
      //模拟loading
      var a = 0,b=0,c=0, timer = setInterval(function(){
        a = a + Math.random()*5|0;  
        b = b + Math.random()*5|0; 
        c = c + Math.random()*5|0; 
        if(a>x){a = x; }
        if(b>y){b = y; }
        if(c>z){c = z; }
        if(a==x&&b==y&&c==z){
        	clearInterval(timer);
            othis.removeClass(DISABLED);
        }
        
        element.progress('demo1', a+'%');
        element.progress('demo2', b+'%');
        element.progress('demo3', c+'%');
      }, 300+Math.random()*300);
      
      othis.addClass(DISABLED);
    }
  };
  
  $('.site-demo-active').on('click', function(){
    var othis = $(this), type = $(this).data('type');
    active[type] ? active[type].call(this, othis) : '';
  });
});
window.onload=function(){
	$("html").css("cursor","pointer");
}

$("#wsh").mouseover(function(){
	var t=$(this).attr("st");
	layer.tips('点击此处，可查看'+t+'的需求信息！', '#wsh', { tips: 2,time:1500});
});
$("#ytg").mouseover(function(){
	var t=$(this).attr("st");
	layer.tips('点击此处，可查看'+t+'的需求信息！', '#ytg', { tips: 2,time:1500});
});
$("#bth").mouseover(function(){
	var t=$(this).attr("st");
	layer.tips('点击此处，可查看'+t+'的需求信息！', '#bth', { tips: 2,time:1500});
	
});

$("#bth").click(function(){
	var t=$(this).attr("st");
	window.location.href="state_need.jsp?st="+t;
});
$("#wsh").click(function(){
	var t=$(this).attr("st");
	window.location.href="state_need.jsp?st="+t;
});
$("#ytg").click(function(){
	var t=$(this).attr("st");
	window.location.href="state_need.jsp?st="+t;
});
</script>