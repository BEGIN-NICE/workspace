$(function(){
	$("#province").change(function(){
		var $pid = $(this).val();
		$("#city").html("<option value=''>"+"-请选择-"+"</option>");
		$.post("/webday18/CityServlet",{"pid":$pid},function(data){
			$(data).find("city").each(function(i,n){
				alert(i);
				alert($(this).html())
				var $cid  = $(this).children("cid").text();
				var $city  = $(this).children("city").text();
				$("#city").append("<option value='"+$cid+"'>"+$city+"</option>");
			})
			
		})
	})
})