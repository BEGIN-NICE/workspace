<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/ajax/aboutInfo.js"></script>
<style type="text/css">
	#aboutInfo{
		border: 1px solid;
		width: 150px;
		opacity:1;
		background:white;
		filter:alpha(opacity:100);
		position: absolute;
		margin-left: 54px;
		margin-top: 103px;
		display: none;
	}
	#innerInfo{
		width:150px;
	}
</style>
<script type="text/javascript">
	function addPage() {
		window.location.href= "/webday17/jsp/addProduct.jsp";
	}
	
	function delProduct(pid) {
		 var flag = confirm("你确定删除该商品吗");
		 if(flag==true){
			window.location.href= "/webday17/ProductDeleteServlet?pid="+pid;
		 }
	}
	function delMore() {
	
			document.getElementById("form1").action = "${pageContext.request.contextPath}/ProductDeleteAllServlet"

	}
	$(function(){
		$("#selectAll").click(function(){
			$("input[id='ids']").prop("checked", $(this).prop("checked"));
		})
	});
</script>
</head>
<body>
<!-- 设置搜索提示按钮 -->
<div id="aboutInfo" >
</div>
					
	<h1>商品的分页列表页面</h1>
	<form id="form1"
		action="${pageContext.request.contextPath }/ProductSearchServlet"
		method="post">
		<table border="1px" width="800">
			<tr height="60">
				<td colspan="8">名称：<input id="innerInfo" type="text" name="pname"><input
					type="submit" value="查询">&nbsp;&nbsp;&nbsp;&nbsp; <input
					type="button" value="添加" onclick="addPage()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="submit" value="批量删除" onclick="delMore()">
					
				
				</td>
			</tr>
			<tr>
				<td>序号</td>
				<td><input id="selectAll" type="checkbox"></td>
				<td>商品名称</td>
				<td>市场价格</td>
				<td>商城价格</td>
				<td>是否热门</td>
				<td>是否下架</td>
				<td>操作</td>
			</tr>
			<c:forEach var="p" items="${pageBean.list }" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td><input id="ids" name="ids" type="checkbox"
						value="${p.pid }"></td>
					<td>${p.pname }</td>
					<td>${p.market_price }</td>
					<td>${p.shop_price }</td>
					<td><c:if test="${p.is_hot == 1 }">
				是
				</c:if> <c:if test="${p.is_hot == 0 }">
				否
				</c:if></td>
					<td><c:if test="${p.pflag == 1 }">
				是
				</c:if> <c:if test="${p.pflag == 0 }">
				否
				</c:if></td>
					<td><a
						href="${pageContext.request.contextPath }/ProductFindServlet?pid=${p.pid}">修改</a>|<a
						href="#" onclick="delProduct(${p.pid})">删除</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="8">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<c:if test="${pageBean.currPage > 1 }">
						<a
							href="${pageContext.request.contextPath }/ProductByPageServlet?currPage=1">首页</a>&nbsp;&nbsp; 
						<a
							href="${pageContext.request.contextPath }/ProductByPageServlet?currPage=${pageBean.currPage - 1 }">上一页</a>&nbsp;&nbsp; 
					</c:if> 
					<c:forEach var="page" begin="1" end="${pageBean.totalPage }"
						varStatus="status">
						<c:if test="${pageBean.currPage != status.count }">
							<a href="${pageContext.request.contextPath }/ProductByPageServlet?currPage=${status.count }">${status.count }</a>&nbsp; 
						</c:if>
						<c:if test="${pageBean.currPage == status.count }">
							${status.count } &nbsp;
						</c:if>
					</c:forEach> 
					<c:if test="${pageBean.currPage < pageBean.totalPage }">
				  &nbsp;<a
							href="${pageContext.request.contextPath }/ProductByPageServlet?currPage=${pageBean.currPage + 1 }">下一页</a>&nbsp;&nbsp; 
						<a
							href="${pageContext.request.contextPath }/ProductByPageServlet?currPage=${pageBean.totalPage}">尾页</a>
					</c:if>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>