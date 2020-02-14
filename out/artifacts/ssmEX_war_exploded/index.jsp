<%--
  Created by IntelliJ IDEA.
  User: xycode
  Date: 2020/1/14
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
  <head>
    <title>webLecture</title>
  </head>
  <body>
    <h3>
      hello, this is ssm integration
    </h3>

    <a href="userService/findAllUser" style="font-size: 20px">查询所有用户</a> <br/><br/>

    <form action="userService/addUser" method="post">
		ID: <input type="number" name="id"> <br/>
		UserName: <input type="text" name="username"> <br/>
		Password: <input type="text" name="password"> <br/>
		Money: <input type="number" name="money"> <br/>
		<input type="submit" value="添加"> <br/>
	</form>

<%--	tip: 嵌入js代码,实现获取文本框的内容,拼接成url,达到删除User的功能--%>
	<form action="userService/deleteUserByID/" method="post">
		要删除的用户ID: <input type="number" name="id" id="deletedUserID"> <br/>
		<input type="submit" value="删除" onclick="deleteUserByID()"> <br/>
	</form>
	<script type="text/javascript">
        function deleteUserByID(){
            var textNode=document.getElementById("deletedUserID");
			// console.log(textNode.parentNode.action+textNode.value);
			textNode.parentNode.action+=textNode.value;
        }
	</script>



  </body>
</html>
