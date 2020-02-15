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

<%--	添加用户--%>
	<h4>添加用户</h4>
    <form action="userService/addUser" method="post">
		ID: <input type="number" name="id"> <br/>
		UserName: <input type="text" name="username"> <br/>
		Password: <input type="text" name="password"> <br/>
		Money: <input type="number" name="money"> <br/>
		<input type="submit" value="添加"> <br/>
	</form>

<%--	删除用户--%>
<%--	tip: 嵌入js代码,实现获取文本框的内容,拼接成url,达到删除User的功能--%>
	<h4>删除用户</h4>
	<form action="userService/deleteUserByID/" method="post">
		要删除的用户ID: <input type="number" name="id" id="deletedUserID"> <br/>
		<input type="submit" value="删除" onclick="deleteUserByID()"> <br/>
	</form>
	<script type="text/javascript">
        function deleteUserByID(){
            var textNode=document.getElementById("deletedUserID");
            // alert(textNode.parentNode.action+textNode.value);
            textNode.parentNode.action+=textNode.value;
        }
	</script>

<%--	更新用户--%>
	<h4>更新用户</h4>
	<form action="userService/updateUser" method="post">
		ID: <input type="number" name="id"> <br/>
		UserName: <input type="text" name="username"> <br/>
		Password: <input type="text" name="password"> <br/>
		Money: <input type="number" name="money"> <br/>
		<input type="submit" value="更新"> <br/>
	</form>

<%--	查询用户--%>
	<h4>查询用户</h4>
	<form action="userService/findUserByID/" method="post">
		要查询的用户ID: <input type="number" name="id" id="foundUserID"> <br/>
		<input type="submit" value="查询" onclick="findUserByID()"> <br/>

		<script type="text/javascript">
            function findUserByID(){
                //notice: 注意id不能与函数名相同(这里就是foundUserID),会出错
                var textNode=document.getElementById("foundUserID");
                // alert(textNode.parentNode.action+textNode.value);
                textNode.parentNode.action+=textNode.value;
            }
		</script>
	</form>

  </body>
</html>
