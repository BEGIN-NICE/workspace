<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />	
		<script src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<script type="text/javascript">
			function showDetail(id){
				var $div = $("#div"+id).html();
				if($div ==""){
					$.post("${ pageContext.request.contextPath }/AdminOrderServlet",{"method":"detail","oid":id},function(data){
						$("#div"+id).html(data);
					})
				}else{
					$("#div"+id).html("");
				}
			}
		</script>
	</HEAD>
	<body>
		<br>
		<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/user/list.jsp" method="post">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>订单列表</strong>
						</TD>
					</tr>
					
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="10%">
										序号
									</td>
									<td align="center" width="10%">
										订单编号
									</td>
									<td align="center" width="10%">
										订单金额
									</td>
									<td align="center" width="10%">
										收货人
									</td>
									<td align="center" width="10%">
										订单状态
									</td>
									<td align="center" width="50%">
										订单详情
									</td>
								</tr>
									<c:forEach var="o" items="${pageBean.list }" varStatus="status">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="18%">
												${status.count }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${o.oid }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${o.total }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${o.name }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<c:if test="${o.state==1 }">
													未付款
												</c:if>
												<c:if test="${o.state==2 }">
													<a href="${ pageContext.request.contextPath }/AdminOrderServlet?method=updateState&oid=${o.oid}"><font color="blue">发货</font></a>
												</c:if>
												<c:if test="${o.state==3 }">
													等待确认收货
												</c:if>
												<c:if test="${o.state==4 }">
													订单完成
												</c:if>
											
											</td>
											<td align="center" style="HEIGHT: 22px">
												<input type="button" value="订单详情" id="but${o.oid }" onclick="showDetail('${o.oid}')"/>
											</td>
										</tr>
										<tr>
											<td colspan="6">
												<div id="div${o.oid }"></div>
											</td>
										</tr>
								</c:forEach>	
							</table>
						</td>
					</tr>
					<tr align="center">
						<td colspan="7">
							第${pageBean.currPage }/${pageBean.totalPage }页 
							<c:if test="${pageBean.currPage != 1 }">
								<a href="${ pageContext.request.contextPath }/AdminOrderServlet?method=findAllByPage&currPage=1">首页</a>|
								<a href="${ pageContext.request.contextPath }/AdminOrderServlet?method=findAllByPage&currPage=${pageBean.currPage-1}">上一页</a>|
							</c:if>
							
							<c:forEach var="i" begin="1" end="${pageBean.totalPage }">
								<c:if test="${pageBean.currPage==i }">${i }</c:if>
								<c:if test="${pageBean.currPage != i }">
								<a href="${ pageContext.request.contextPath }/AdminOrderServlet?method=findAllByPage&currPage=${i}">[${i }]</a>
								</c:if>
							</c:forEach>
							
							<c:if test="${pageBean.currPage != pageBean.totalPage }">
								<a href="${ pageContext.request.contextPath }/AdminOrderServlet?method=findAllByPage&currPage=${pageBean.currPage+1}">下一页</a>|
								<a href="${ pageContext.request.contextPath }/AdminOrderServlet?method=findAllByPage&currPage=${pageBean.totalPage}">尾页</a>|
							</c:if>
						</td>
					</tr>
				</TBODY>
			</table>
		</form>
	</body>
</HTML>

