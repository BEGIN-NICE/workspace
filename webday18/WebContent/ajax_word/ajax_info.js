$(function(){
	$("#search").keyup(function(){
		var info = $(this).val();
		if(info==""){
			$("#div1").hide();
		}else{
		$.get("/webday18/JqSearchServlet",{"search":info},function(data){
			$("#div1").show().html(data);
		});
		}
	});
});

$(function(){
	$(document).click(function(){
		$("#div1").hide();
	})
})