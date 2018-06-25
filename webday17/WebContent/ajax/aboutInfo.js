$(function(){
	$("#innerInfo").keyup(function(){
		var info = $(this).val();
			$.post("/webday17/AboutInfoServlet",{"info":info},function(data){
				if(info!=""&&data!=""){
					$("#aboutInfo").show().html(data);
				}else{
					$("#aboutInfo").hide();
				}
			})

	})
})

$(function(){
	$(document).click(function(){
		$("#aboutInfo").hide();
	})
})