//ajax的get方式异步请求
function ajax_get() {
	//1.创建对象
	var xhr = getXhr();
	//2.状态监听(回调)
	xhr.onreadystatechange = function() {
		if(xhr.readyState==4 && xhr.status==200){
			document.getElementById("div1").innerHTML=xhr.responseText;
		}
	}
	//3.打开路径
	xhr.open("GET","/webday18/Servlet?username=fanxh&password=123",true);
	//4.发送请求
	xhr.send(null);
	
}

//ajax的post方式的异步请求
function ajax_post() {
	//1.创建对象
	var xhr = getXhr();
	//2.状态监听(回调)
	xhr.onreadystatechange = function() {
		if(xhr.readyState==4 && xhr.status==200){
			document.getElementById("div1").innerHTML=xhr.responseText;
		}
	}
	
	
	//3.打开路径
	xhr.open("post","/webday18/Servlet",true);
	
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	//4.发送请求
	xhr.send("username=fanxh小&&password=123");
	
}

function getXhr() {
	var xmlHttpReq=null;
	if (window.XMLHttpRequest) {//Mozilla 浏览器
		xmlHttpReq = new XMLHttpRequest();
	}else {
		if (window.ActiveXObject) {//IE 浏览器
			try {
				xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
			}
			catch (e) {
				try {//IE 浏览器
					xmlHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
				}
				catch (e) {
				}
			}
		}
	}
	return xmlHttpReq;
}