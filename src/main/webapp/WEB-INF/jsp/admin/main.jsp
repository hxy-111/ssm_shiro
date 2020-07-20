<%--
  Created by IntelliJ IDEA.
  User: winx
  Date: 2020/3/26
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

登录成功后的后台主页面
<br>
<br>
<a href="${pageContext.request.contextPath}/logout.html">退出登录</a>
<br>
<br>
<a href="${pageContext.request.contextPath}/admin/userlist.html">用户列表</a>
<br>
<br>
<a href="${pageContext.request.contextPath}/admin/adduser.html">添加用户</a>

<br>
<br>
<shiro:guest>
    游客访问 <a href="${pageContext.request.contextPath}/login">登录</a>
</shiro:guest>
</body>
</html>
