<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
String name=(String)session.getAttribute("flag");
if(name==null){
	response.setHeader("refresh", "0;url=error.html");

}

%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
.ts1{
	text-align:inherit;
}
.ts2{
	color:red;
	font-family:楷体;
	font-size:15px;	
}
.gs{
	height:100px;
}
.input{
	resize:none;
	font-family:微软雅黑;
	font-size:18px;
	width:100%;
	height:100%;
	border:hidden;

}
.input1{
	resize:none;
	font-family:微软雅黑;
	font-size:18px;
	width:99%;
	height:95%;


}

.bt1{width:75%; height:35px; font-size: 18px;
        font-family:微软雅黑;background-color:aqua;
        text-align: center; border-radius:15px;}
.bt2{width:75%; height:35px; font-size: 18px;
        font-family:微软雅黑;text-align: center;
        background-color:aqua;border-radius:15px;}
</style>
<script type="text/javascript" src="js/ajax.js"></script>
<script type="text/javascript" src="js/xkfl.js"></script>
<script type="text/javascript" src="js/hy.js"></script>
<script type="text/javascript" src="js/cursor.js"></script>
<script src="js/jquery.js"></script>
<script src="layer/layer.js"></script>
<script src="js/pop_layer.js"></script>
<script src="js/cursor.js"></script>
</head>
<body>
<center>
<form id="demand">
	<table width="75%" border="2" cellpadding="0"  bordercolor="aqua">
					<tr>
						<th colspan="4">河北省重大技术需求征集表</th>
					</tr>
					<tr>
						<td colspan="1" width="25%">机构名称：</td>
						<td colspan="1"><input class="input" type="text" name="jgmc" id="jgmc"></td>
						<td colspan="1">归口管理部门：</td>
						<td colspan="1"><input class="input" type="text" name="gkglbm" id="gkglbm"></td>
					</tr>
					<tr>
						<td colspan="1">通讯地址：</td>
						<td colspan="1"><input class="input" type="text" name="txdz" id="txdz"></td>
						<td colspan="1">所在地域：</td>
						<td colspan="1"><input class="input" type="text" name="szdy" id="szdy"></td>
					</tr>
					<tr>
						<td colspan="1">网址：</td><td colspan="1" width="25%"><input class="input" type="text" name="dwwz" id="dwwz"></td>
						<td colspan="1">电子信箱：</td><td colspan="1" width="25%"><input class="input" type="text" name="dzxx" id="dzxx"></td>
					</tr>
					<tr>
						<td colspan="1">法人代表：</td><td colspan="1"><input class="input" type="text" name="frdb" id="frdb"></td>
						<td colspan="1">邮政编码：</td><td colspan="1"><input class="input" type="text" name="yzbm" id="yzbm" maxlength="6"></td>
					</tr>
					<tr>
						<td colspan="1">联系人：</td><td colspan="1"><input class="input" type="text" name="lxr" id="lxr"></td>
						<td colspan="1">联系人电话：</td><td colspan="1"><input class="input" type="text" name="lxrdh" id="lxrdh" maxlength="11"></td>
					</tr>
					<tr>
                  		<td>机构属性</td>
                  		<td colspan="3">
                      		<input id="unit" name="jgsx" type="radio" value="企业" checked>企业
                      		<input id="unit" name="jgsx" type="radio" value="高等院校">高等院校
                      		<input id="unit" name="jgsx" type="radio" value="研究机构">研究机构
                      		<input id="unit" name="jgsx" type="radio" value="其他">其他
                  		</td>
               		</tr> 
					<tr>
						<td colspan="1" class="ts1">机构简介：
							<p class="ts2"><strong>(单位基本情况，研究基础，限200字！)</strong></p></td>
						<td colspan="3">
							<div class="gs"><textarea class="input1" cols="10" name="jgjj"maxlength="200" colspan="3"></textarea></div>
						</td>
					</tr>
					<tr>
						<td colspan="1">技术需求名称：</td>
						<td colspan="3"><input class="input" type="text" name="jsxqmc" id="jsxqmc"></td>
					</tr>
					<tr>
						<td colspan="1">起始需求年份：</td>
						<td colspan="1">
							<select name="qsxqnf" class="input" id="qs" onchange="changeXqnx()">  
								<option value="2010">2010</option>  
								<option value="2011">2011</option>  
								<option value="2012">2012</option> 
								<option value="2013">2013</option> 
								<option value="2014">2014</option> 
								<option value="2015">2015</option> 
								<option value="2016">2016</option> 
								<option value="2017">2017</option> 
							</select> 
						</td>
						
						<td colspan="1">截止需求年份：</td>
						<td colspan="1">
							<select name="jzxqnf" class="input" id="jz">  
								<option value="2010">2010</option>  
								<option value="2011">2011</option>  
								<option value="2012">2012</option> 
								<option value="2013">2013</option> 
								<option value="2014">2014</option> 
								<option value="2015">2015</option> 
								<option value="2016">2016</option> 
								<option value="2017">2017</option> 
								<option value="2018">2018</option> 
								<option value="2019">2019</option>  
							</select> 
						</td>
					</tr>
					<tr>
						<td colspan="1" class="ts1">重大科技需求概述：
							<p class="ts2"><strong>(主要内容，技术指标、预期经济和社会效益等，限500字！)</strong></p></td>
						<td colspan="3"><div class="gs"><textarea class="input1" cols="15" name="xqgs"maxlength="500" colspan="3"></textarea></div>
						</td>
					</tr>
					<tr>
						<td>拟投入资金总额：</td>
						<td colspan="2"><input class="input" type="text" name="promoney" id="xmzj" maxlength="5" value="1"></td>
						<td colspan="1">万元</td>
					</tr>
					<tr>
						<td>科技活动类型：</td>
						<td colspan="3">
							<input type="radio" name="yjlx" value="基础研究" checked onClick="checkYjlx()">基础研究
							<input type="radio" name="yjlx" value="应用研究" onClick="checkYjlx()">应用研究
							<input type="radio" name="yjlx" value="试验发展" onClick="checkYjlx()">试验发展
							<input type="radio" name="yjlx" value="研究与试验发展成果应用" onClick="checkYjlx()">研究与试验发展成果应用
							<input type="radio" name="yjlx" value="技术推广与科技服务" onClick="checkYjlx()">技术推广与科技服务
						</td>
					</tr>
				
				    <tr id="xkfl" style="display:table-row">
				    	<td colspan="1" width="25%">学科分类：</td>
						<td colspan="1" width="25%">
							<select name="xk1" class="input" id="xk1">  
							</select> 
						</td>
            
						<td colspan="1" width="25%">
							<select name="xk2" class="input" id="xk2">  
							</select> 
						</td>
            
						<td colspan="1" width="25%">
							<select name="xk3" class="input" id="xk3">  
							</select> 
							</td>
					</tr>

	            	
				
					<tr  style="display:none" id="xqjsly">
	                	<td colspan="1"> 需求技术所属领域：</td>      
	                	<td colspan="3">                                        
	                  		<input id="ly" name="ly" type="checkbox" value="电子信息技术">电子信息技术  
	                  		<input id="ly" name="ly" type="checkbox" value="光机电一体化">光机电一体化 	
	                  		<input id="ly" name="ly" type="checkbox" value="生物技术与制药 ">生物技术与制药            
	                  		<input id="ly" name="ly" type="checkbox" value="新材料及应用技术" >新材料及应用技术
	                  		<input id="ly" name="ly" type="checkbox" value="资源与环境">资源与环境
	                  		<input id="ly" name="ly" type="checkbox" value="新能源与高效节能技术">新能源与高效节能技术
	                  		<input id="ly" name="ly" type="checkbox" value="现代农业技术">现代农业技术
	                 		<input id="ly" name="ly" type="checkbox" value="软件" >软件 
	                 		<input id="ly" name="ly" type="checkbox" value="海洋" >海洋 
	                 		<input id="ly" name="ly" type="checkbox" value="医疗卫生" >医疗卫生 
	                 		<input id="ly" name="ly" type="checkbox" value="社会公共事业" >社会公共事业
	                  		<input id="ly" name="ly" type="checkbox" value="其他">其他                          
	                	</td>
	            	</tr>
					
					<tr style="display:none" id="yyhy">
						<td colspan="1" width="25%">需求技术应用行业：</td>
						<td colspan="1" width="25%">
							<select name="hy1" class="input" id="hy1">  
							</select> 
						</td>
            
						<td colspan="1" width="25%">
							<select name="hy2" class="input" id="hy2">  
							</select> 
						</td>
            
						<td colspan="1" width="25%">
                			<p class="ts2">
                    			<strong>2017年国民经济行业分类（GB/T 4754—2017） 国家统计局</strong>
                			</p>
						</td>
					</tr>
					
					<tr>
						<td>技术需求合作模式：</td>
						<td colspan="3">
							<input type="radio" name="hzms" value="技术入股" checked="checked">技术入股
							<input type="radio" name="hzms" value="合作开发">合作开发
							<input type="radio" name="hzms" value="独立开发">独立开发
							<input type="radio" name="hzms" value="技术转让">技术转让
						</td>
					</tr>
					
	</table>
</form>
<br>
<div class="bt1" onclick="formCheck()" onMouseOut="this.style.backgroundColor='aqua'" onMouseOver="this.style.backgroundColor='blue'"><strong>确&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;认</strong></div>
<br>
<div class="bt2" onclick="cancel()" onMouseOut="this.style.backgroundColor='aqua'" onMouseOver="this.style.backgroundColor='red'"><strong>取&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;消</strong></div>
<br>
<div class="bt1" onclick='reSet()' onMouseOut="this.style.backgroundColor='aqua'" onMouseOver="this.style.backgroundColor='blue'"><strong>重&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;置</strong></div>

</center>
<script language="javascript">
function reSet(){
	loadHy();
	document.getElementById("demand").reset();
	loadXkfl();
	
}
var ly="";
var idArr=new Array("jgmc","txdz","dwwz","dzxx","frdb","lxr","jgjj","jsxqmc","xmzj","yzbm","lxrdh");
function getLy(){
    obj = document.getElementsByName("ly");
    ly = [];
    for(k in obj){
        if(obj[k].checked)
            ly.push(obj[k].value);
    }
}
function formCheck(){
	getLy();
	var a=new Array(document.forms[0].jgmc.value,
						   document.forms[0].txdz.value,
						   document.forms[0].dwwz.value,
						   document.forms[0].dzxx.value,
						   document.forms[0].frdb.value,
						   document.forms[0].lxr.value,
						   document.forms[0].jgjj.value,
						   document.forms[0].jsxqmc.value,
						   document.forms[0].xmzj.value,
						   document.forms[0].yzbm.value,
						   document.forms[0].lxrdh.value,
						   document.forms[0].yjlx.value,
						   document.forms[0].xk3.value,
						   document.forms[0].hy2.value,
						   ly,
						   document.forms[0].jgsx.value,
						   document.forms[0].xqgs.value,
						   document.forms[0].hzms.value,
						   document.forms[0].qsxqnf.value,
						   document.forms[0].jzxqnf.value,
						   document.forms[0].gkglbm.value,
						   document.forms[0].szdy.value);
	if(a[0]==""||a[1]==""||a[2]==""||a[3]==""||a[4]==""||a[5]==""||a[6]==""||a[7]==""||a[8]==""||a[20]==""||a[21]==""||a[6]==""||a[16]==""){
		alert("输入不能为空！");
		return ;
	}
	if(a[9].length!=6){
		alert("请输入正确的邮政编码!");
		document.getElementById('yzbm').focus();
		return ;
	}
	if(a[10].length!=11){
		alert("请输入正确的手机号码!");
		document.getElementById('lxrdh').focus();
		return ;
	}
	if(a[11]=="基础研究"){
		if(a[12]==""){
			alert("请输入学科分类!");
			document.getElementById('xkfl').focus();
			return ;
		}
		else{
			var url="NeedSubmit";
			var params="jgmc="+dCode(a[0])+"&txdz="+dCode(a[1])+"&dwwz="+dCode(a[2])+"&dzxx="+dCode(a[3])+"&frdb="+dCode(a[4])+"&lxr="+dCode(a[5])+"&jgjj="+dCode(a[6])+"&jsxqmc="+dCode(a[7])+"&xmzj="+dCode(a[8])+"&yzbm="+dCode(a[9])+"&lxrdh="+dCode(a[10])+"&yjlx="+dCode(a[11])+"&xkfl="+dCode(a[12])+"&yyhy="+dCode("")+"&ly="+dCode("")+"&jgsx="+dCode(a[15])+"&xqgs="+dCode(a[16])+"&hzms="+dCode(a[17])+"&qsxqnf="+dCode(a[18])+"&jzxqnf="+dCode(a[19])+"&gkglbm="+dCode(a[20])+"&szdy="+dCode(a[21])+"&tjyh="+dCode(<%=name%>);
    		sendRequest(url,params,'GET',getresult);
		}
	}
	if(a[11]!="基础研究"){
		if(a[13]==""||a[14]==""){
			alert("需求技术所属领域和应用行业不能为空!");
			return ;
		}
		else{
			var url="NeedSubmit";
			var params="jgmc="+dCode(a[0])+"&txdz="+dCode(a[1])+"&dwwz="+dCode(a[2])+"&dzxx="+dCode(a[3])+"&frdb="+dCode(a[4])+"&lxr="+dCode(a[5])+"&jgjj="+dCode(a[6])+"&jsxqmc="+dCode(a[7])+"&xmzj="+dCode(a[8])+"&yzbm="+dCode(a[9])+"&lxrdh="+dCode(a[10])+"&yjlx="+dCode(a[11])+"&xkfl="+dCode("")+"&yyhy="+dCode(a[13])+"&ly="+dCode(a[14])+"&jgsx="+dCode(a[15])+"&xqgs="+dCode(a[16])+"&hzms="+dCode(a[17])+"&qsxqnf="+dCode(a[18])+"&jzxqnf="+dCode(a[19])+"&gkglbm="+dCode(a[20])+"&szdy="+dCode(a[21])+"&tjyh="+dCode(<%=name%>);
    		sendRequest(url,params,'GET',getresult);
		}
	}
}
function getresult(){
	if(xmlHttpRequest.readyState==4){
		if(xmlHttpRequest.status==200){
			
			var info=xmlHttpRequest.responseText;
			alert(info);
		}
	}
}
window.onload=function(){
	document.getElementById('jgmc').focus();
	loadXkfl();
	loadHy();
}
function cancel(){
	window.location.href="right.html";
	
}
function checkYjlx(){
	var yjlx=document.forms[0].yjlx.value;
	var t1=document.getElementById("xkfl");
	var t2=document.getElementById("xqjsly");
	var t3=document.getElementById("yyhy");
	if(yjlx=="基础研究"){
		t1.style.display='table-row';
		t2.style.display='none';
		t3.style.display='none';

	}
	else{
		t1.style.display='none';
		t2.style.display='table-row';
		t3.style.display='table-row';

	}
}

function loadXkfl(){
	var x1 = document.getElementById("xk1");
	var x2 = document.getElementById("xk2");
	var x3 = document.getElementById("xk3");
	x1.options.length=0;
	x2.options.length=0;
	x3.options.length=0;
	for(var i=0;i<xkfl_1.length;i++){
		x1.add(new Option(xkfl_1[i],xkfl_1[i]), null);
	}
	for(var i=0;i<xkfl_2[0].length;i++){
		x2.add(new Option(xkfl_2[0][i],xkfl_2[0][i]), null);
	}
	for(var i=0;i<xkfl_3[0][0].length;i++){
		x3.add(new Option(xkfl_3[0][0][i],xkfl_3[0][0][i]), null);
	}
	x1.onchange=function (){
		var index1=x1.selectedIndex;
		loadFirstSecond(index1);
		var index2=x2.selectedIndex;
		loadSecondThird(index1,index2);
	}
	
	x2.onchange=function(){
		var index1=x1.selectedIndex;
		var index2=x2.selectedIndex;
		loadSecondThird(index1,index2);
	}
}

function loadFirstSecond(a){
	var x2 = document.getElementById("xk2");
	x2.options.length=0;
	for(var i=0;i<xkfl_2[a].length;i++){
		x2.add(new Option(xkfl_2[a][i],xkfl_2[a][i]), null);
	}

}

function loadSecondThird(a,b){
	var x3 = document.getElementById("xk3");
	x3.options.length=0;
	for(var i=0;i<xkfl_3[a][b].length;i++){
		x3.add(new Option(xkfl_3[a][b][i],xkfl_3[a][b][i]), null);
	}
}
function changeXqnx(){
	var b = document.getElementById("jz");
	var qsnf=document.forms[0].qsxqnf.value;
	b.options.length=0;
	for(var i=0;i<10;i++){
		b.add(new Option(qsnf,qsnf), null);
		qsnf++;
	}
}
function loadHy(){
    var a = document.getElementById("hy1");
    var b = document.getElementById("hy2");
    a.options.length=0;
    b.options.length=0;
    for(var i=0;i<hy_1.length;i++){
        a.add(new Option(hy_1[i],hy_1[i]), null);
    }
    for(var i=0;i<hy_2[0].length;i++){
        b.add(new Option(hy_2[0][i],hy_2[0][i]), null);
    }
    a.onchange=function(){
        var index=a.selectedIndex;
        changeHy(index);
    }
}

function changeHy(index){
    var a = document.getElementById("hy2");
    a.options.length=0;
    for(var i=0;i<hy_2[index].length;i++){
        a.add(new Option(hy_2[index][i],hy_2[index][i]), null);
    }
}
</script>
<script type="text/javascript">
var text = document.getElementById("xmzj");
text.onkeyup = function(){
this.value=this.value.replace(/\D/g,'');
}
</script>
<script type="text/javascript">
var text = document.getElementById("lxrdh");
text.onkeyup = function(){
this.value=this.value.replace(/\D/g,'');
}
</script>
<script type="text/javascript">
var text = document.getElementById("yzbm");
text.onkeyup = function(){
this.value=this.value.replace(/\D/g,'');
}
</script>
</body>
</html>