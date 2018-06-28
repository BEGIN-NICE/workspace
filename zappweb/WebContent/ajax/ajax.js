//jq_load方式异步请求
$(function(){
	$("#jq_load").click(function(){
		$("#div1").load("/zappweb/AjaxServlet",{"name":"冯杰","pass":123},function(data){
			/*alert(data);
			$("#div1").html(data);*/
		})
	})
	
})


//jq_post方式异步请求
$(function(){
	$("#jq_post").click(function(){
		$.post("/zappweb/AjaxServlet",{"name":"冯杰","pass":123},function(data){
			$("#div1").html(data);
		})
	})
	
})


//post方式的异步请求
function postMethod(){
	//1.创建对象
	var xhr = getXhr();
	//2.监听
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4&&xhr.status==200){
			document.getElementById("div1").innerHTML = xhr.responseText;
		}
	}
	//建立连接
	xhr.open("POST","/zappweb/AjaxServlet");
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xhr.send("name=冯杰&pass=abc")
}
//get方式的异步请求
function getMethod(){
	var xhr = getXhr();
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			document.getElementById("div1").innerHTML= xhr.responseText;
		}
	}
	xhr.open("GET","/zappweb/AjaxServlet?name=fanxh&pass=123",true);
	xhr.send(null);
	
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