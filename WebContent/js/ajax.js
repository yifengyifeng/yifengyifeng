/**
 * 
 */
var xmlHttpRequest=null;

function createXHR(){
	if(window.ActiveXObject){
        xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
    }
	else if (window.XMLHttpRequest){
        xmlHttpRequest = new XMLHttpRequest();
    }  
}

function sendRequest(url,params,method,handle){
	//alert(params);
	createXHR();
	if(!xmlHttpRequest){
		alert("error!");
		return false;
	}
		
	
	if(method=="GET"){
		
		xmlHttpRequest.open(method,url+'?'+params,true);
		xmlHttpRequest.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=UTF-8");
		xmlHttpRequest.send(null);
		xmlHttpRequest.onreadystatechange=handle;
	}
	if(method=="POST"){
		xmlHttpRequest.open(method,url+'?'+params,true);
		xmlHttpRequest.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=UTF-8");
		xmlHttpRequest.send(null);
		xmlHttpRequest.onreadystatechange=handle;
	}
}

function dCode(str){
	return encodeURI(encodeURI(str));
}