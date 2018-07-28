<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function() {
		$("#but").toggle(function() {

							$.post("${pageContext.request.contextPath}/showproduct",
											function(data) {
												alert(data);
												//data = eval(data);
												if (data.type == 1) {
													var html = "<table><tr><td>商品编号</td><td>商品名称</td><td>商品数量</td><td>商品价格</td></tr>"
													for (var i = 0; i < data.list.length; i++) {
														html += "<tr><td>"
																+ data.list[i].id
																+ "</td><td>"
																+ data.list[i].name
																+ "</td><td>"
																+ data.list[i].count
																+ "</td><td>"
																+ data.list[i].price
																+ "</td></tr>"
													}
													html += "</table>"
													$("#div").html(html);
												}else{
													$("#div").html(data.message);
												}
											}, "json");
						}, function() {
							$("#div").html("");
						})

	})
</script>
</head>
<body>
	<button id="but">商品展示</button>
	<div id="div"></div>
	<s:debug />
</body>
</html>