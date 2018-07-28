<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>商品库存</td>
		</tr>
		<s:iterator value="ps" var="p">
			<tr>
				<td><s:property value="#p.name"/></td>
				<td><s:property value="#p.price"/></td>
				<td><s:property value="#p.count"/></td>
			</tr>
		</s:iterator>
	
	</table>
	<s:debug/>
	<hr>
	<table>
		<tr>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>商品库存</td>
		</tr>
		<s:iterator value="ps" var="p">
			<tr>
				<td><s:property value="name"/></td>
				<td><s:property value="price"/></td>
				<td><s:property value="count"/></td>
			</tr>
		</s:iterator>
	
	</table>
	<s:debug/>
</body>
</html>