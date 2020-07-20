<%--
  Created by IntelliJ IDEA.
  User: winx
  Date: 2020/3/26
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    账号： <input name="username" type="text"><br>
    密码： <input name="password" type="text"><br>
    <input type="submit"><br>
    <a href="${pageContext.request.contextPath}/zhuce1">注册</a>
</form>
</body>
</html>
