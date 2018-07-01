$(function(){
	$("#province").change(function(){
		var $pid = $("#province").val();
		$.post("/webday18/CityJsonServlet2",{"pid":$pid},function(data){
			$(data).each(function(){
				$("#city").append("<option value='"+this.cid+"'>"+this.city+"</option>")
			})
		},"json")
	})
})