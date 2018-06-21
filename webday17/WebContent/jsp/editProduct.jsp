<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function addPage() {
		window.location.href= "/webday17/jsp/addProduct.jsp";
	}
</script>
</head>
<body>
<form action="${pageContext.request.contextPath }/ProductEditServlet" method="post">
	<table border="1px" width="800">
		<input type="hidden" name="pid" value="${product.pid }">
		<tr>
			<td>商品名称</td>
			<td><input type="text" name="pname" value="${product.pname }"></td>
		</tr>
		<tr>
			<td>市场价格</td>
			<td><input type="text" name="market_price" value="${product.market_price }"></td>
		</tr>
		<tr>
			<td>商城价格</td>
			<td><input type="text" name="shop_price" value="${product.shop_price }"></td>
		</tr>
		<tr>
			<td>是否热门</td>
			<td><input type="radio" name="is_hot" value="1" <c:if test="${product.is_hot == 1 }"> checked="checked" </c:if>>是
				<input type="radio" name="is_hot" value="0" <c:if test="${product.is_hot == 0 }"> checked="checked" </c:if>>否
			</td>
		</tr>
		<tr>
			<td>是否下架</td>
			<td>
			<select name="pflag">
					<option value="0"  <c:if test="${product.pflag == 0 }"> selected="selected" </c:if> >是</option>
					<option value="1" <c:if test="${product.pflag == 1 }"> selected="selected" </c:if> >否</option>
			</select>
			</td>
		<tr>
		<td>商品分类</td>
			<td>
				<select name="cid">
						<option value="1" <c:if test="${product.cid == 1 }"> selected="selected" </c:if>>手机数码</option>
						<option value="2" <c:if test="${product.cid == 2 }"> selected="selected" </c:if>>电脑办公</option>
						<option value="3" <c:if test="${product.cid == 3 }"> selected="selected" </c:if>>鞋靴箱包</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>商品描述</td>
			<td><textarea name="pdesc" value="${product.pdesc }"></textarea></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="修改"></td>
		</tr>
	</table>
	</form>
</body>
</html>