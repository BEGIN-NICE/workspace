$(function(){
	$("#province").change(function(){
		var $pid = $(this).val();
		$("#city").html("<option value=''>"+"-请选择-"+"</option>");
		$.post("/webday18/CityJsonServlet",{"pid":$pid},function(data){
			$(data).each(function(i,n){
				$("#city").append("<option value='"+n.cid+"'>"+n.city+"</option>");
			})
			
		},"json")
	})
})