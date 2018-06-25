function checkUsername() {
	var username = document.getElementById("username").value;
	var xhr = getXhr();
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4&&xhr.status==200){
			document.getElementById("s1").innerHTML=xhr.responseText;
		}
	};
	xhr.open("GET","/webday18/LoginServlet?username="+username,true);
	xhr.send();
}

function checkPassword() {
	var password = document.getElementById("password").value;
	var xhr = getXhr();
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4&&xhr.status==200){
			var num = xhr.responseText;
			if(num==0){
			document.getElementById("s2").innerHTML="<font color='red'>密码已被占用</font>";
			document.getElementById("sub").disabled="false";
			}else{
			document.getElementById("s2").innerHTML="<font color='green'>密码可以使用</font>";
			}
		}
	};
	xhr.open("POST","/webday18/LoginServlet",true);
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
	//application/x-www-form-urlencoded
	xhr.send("password="+password);
}






//获得异步对象
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