<%--
  Created by IntelliJ IDEA.
  User: winx
  Date: 2020/3/27
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>注册界面</h2>
<form action="${pageContext.request.contextPath}/zhuce" method="post">
    账号：<input type="text" name="username"><br>
    密码：<input type="text" name="password"><br>
    激活：<input type="tetx" name="state"><br>
    <input type="submit">
</form>
</body>
</html>
