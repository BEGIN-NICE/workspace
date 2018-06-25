$(function(){
	$("#username").blur(function(){
	
		//获取文本框的值
		var username = $(this).val();
		
		//通过onload的方式异步请求	
		//jQuery完成ajax异步请求
		//$("#s1").load("/webday18/JqLoginServlet",{"username":username});	

		
		//通过post的方法异步请求
		$.post("/webday18/JqLoginServlet",{"username":username},function(data){
			if(data==1){
				$("#s1").html("<font color='red'>用户名已被占用</font>");
				$("#sub").attr("disabled",false);
			}else{
				$("#s1").html("<font color='green'>用户名可以使用</font>");
			}
		})
		
		
		
	})
});