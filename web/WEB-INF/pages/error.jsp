<%--
  Created by IntelliJ IDEA.
  User: xycode
  Date: 2020/2/12
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
	<title>拦截器生效</title>
</head>
<body>
	<h3 style="color: coral; font-weight: bold; font-size: 20px">拦截成功,转到新页面</h3>
	<p>
<%--		嵌入Java代码--%>
		<% System.out.println("渲染error.jsp成功"); %>
	</p>
</body>
</html>
