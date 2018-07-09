<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath }/js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" type="text/css"/>

</head>
<body>
<%@ include file="menu.jsp" %>
<form action="https://www.yeepay.com/app-merchant-proxy/node" method="post">
<input type="hidden" name="p0_Cmd" value="${payBean.p0_Cmd }">
<input type="hidden" name="p1_MerId" value="${payBean.p1_MerId }">
<input type="hidden" name="p2_Order" value="${payBean.p2_Order }">
<input type="hidden" name="p3_Amt" value="${payBean.p3_Amt }">
<input type="hidden" name="p4_Cur" value="${payBean.p4_Cur }">
<input type="hidden" name="p8_Url" value="${payBean.p8_Url }">
<input type="hidden" name="pd_FrpId" value="${payBean.pd_FrpId }">
<input type="hidden" name="keyValue" value="${payBean.keyValue }">
<input type="hidden" name="hmac" value="${payBean.hmac }">

<div class="container">
<h1>订单编号:${payBean.p2_Order}&nbsp;&nbsp;总金额:${payBean.p3_Amt }&nbsp;&nbsp;&nbsp;
<input type="submit" value="支付"></h1>
</div>
</form>




<div style="margin-top:50px;">
			<img src="${pageContext.request.contextPath }/image/footer.jpg" width="100%" height="78" alt="我们的优势" title="我们的优势" />
		</div>

		<div style="text-align: center;margin-top: 5px;">
			<ul class="list-inline">
				<li><a>关于我们</a></li>
				<li><a>联系我们</a></li>
				<li><a>招贤纳士</a></li>
				<li><a>法律声明</a></li>
				<li><a>友情链接</a></li>
				<li><a target="_blank">支付方式</a></li>
				<li><a target="_blank">配送方式</a></li>
				<li><a>服务声明</a></li>
				<li><a>广告声明</a></li>
			</ul>
		</div>
		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy; 2005-2016 传智商城 版权所有
		</div>
</body>
</html>