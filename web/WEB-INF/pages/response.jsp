<%--
  Created by IntelliJ IDEA.
  User: xycode
  Date: 2020/2/12
  Time: 1:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
	<title>测试response</title>
</head>
<body>
	<h3 style="color: coral; font-weight: bold; font-size: 20px">测试response成功</h3>
<%--	EL表达式, 需要设置isELIgnored="false"--%>
	<h4 style="color: cadetblue">共享的user数据:</h4>
	<p>${user}</p>
</body>
</html>
