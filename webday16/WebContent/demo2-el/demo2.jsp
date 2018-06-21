<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL表达式获取数据</h1>
	<%
		pageContext.setAttribute("pname", "pvalue");
		request.setAttribute("rname", "rvalue");
		session.setAttribute("sname", "svalue");
		application.setAttribute("aname", "avalue");	
	%>
	<h2>通过对用域对象getAttribute获取对应域中的值</h2>
	<%=pageContext.getAttribute("pname") %>
	<%=request.getAttribute("rname") %>
	<%=session.getAttribute("sname") %>
	<%=application.getAttribute("aname") %>
	
	<h2>通过EL表达式获取四个域中的值</h2>
	
	${pname };
	${rname };
	${sname };
	${aname };
	
</body>
</html>