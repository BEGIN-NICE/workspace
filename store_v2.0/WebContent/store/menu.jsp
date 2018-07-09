<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

<script type="text/javascript">
	$(function(){
		$.post("${pageContext.request.contextPath}/CategoryServlet",{"method":"findAll"},function(data){
			$(data).each(function(i,n){
				$("#category").append("<li><a href='${pageContext.request.contextPath}/ProductServlet?cid="+n.cid+"&method=findByCid&currPage=1'>"+n.cname+"</a></li>")
			})
		},"json")
	})
	
	$(function(){
		$("#category").children().click(function(){
			$("#category").children().each(function(i,n){
				$(n).removeClass("active");
			})
			$(this).addClass("active");
		})
		
		$("#search").blur(function(){
			var $val = $(this).val();
			if($val==""){
				$("#searchsubmit").attr("disabled",true);
			}else{
				$("#searchsubmit").attr("disabled",false);
			}
		})
	})
</script>

<div class="container-fluid">
	<div class="col-md-4">
		<img src="${pageContext.request.contextPath }/img/logo2.png" />
	</div>
	<div class="col-md-5">
		<img src="${pageContext.request.contextPath }/img/header.png" />
	</div>
	<div class="col-md-3" style="padding-top: 20px">
		<ol class="list-inline">
			<c:if test="${empty user }">
				<li><a href="${pageContext.request.contextPath }/UserServlet?method=loginUI">登录</a></li>
				<li><a href="${pageContext.request.contextPath }/UserServlet?method=registerUI">注册</a></li>
				<li><a href="${pageContext.request.contextPath }/store/cart.jsp">购物车</a></li>
			</c:if>
			<c:if test="${not empty user }">
				<li>你好:${user.username }</li>
				<li><a href="${pageContext.request.contextPath }/UserServlet?method=exit">退出</a></li>
				<li><a href="${pageContext.request.contextPath }/OrderServlet?method=findByUid">我的订单</a></li>
				<li><a href="${pageContext.request.contextPath }/store/cart.jsp">购物车</a></li>
			</c:if>
		</ol>
	</div>
</div>
<!--
            	时间：2015-12-30
            	描述：导航条
            -->
<div class="container-fluid">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${pageContext.request.contextPath }">首页</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav" id="category">
					<!-- <li class="active"><a href="product_list.htm">手机数码<span
							class="sr-only">(current)</span></a></li>
					<li><a href="#">电脑办公</a></li> -->
				</ul>
				<form class="navbar-form navbar-right" role="search" action="${pageContext.request.contextPath }/SearchServlet?method=search" method="post">
					<div class="form-group">
						<input type="text" id="search" name="search" class="form-control" placeholder="Search">
					</div>
					<button disabled="disabled" id="searchsubmit" type="submit" class="btn btn-default">Submit</button>
				</form>

			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
</div>
