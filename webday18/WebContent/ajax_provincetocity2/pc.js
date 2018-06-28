$(function(){
	$("#province").change(function(){
		var $pid = $(this).val();
		$("#city").html("<option value=''>"+"-请选择-"+"</option>");
		$.post("/webday18/CityServlet2",{"pid":$pid},function(data){
			$(data).find("city").each(function(i,n){
				
				var $cid  = $(this).attr("cid");
				var $city  = $(this).attr("city");
				$("#city").append("<option value='"+$cid+"'>"+$city+"</option>");
			})
			
		})
	})
})