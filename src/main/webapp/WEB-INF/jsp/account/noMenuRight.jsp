<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2019/8/7
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>没有菜单操作权限</title>
    <style>
        .main {
            width: 800px;
            margin: 0 auto;
            padding-top: 100px;
        }

        .main a {
            display: inline-block;
            border: 1px solid #E8E8E8;
            text-decoration: none;
            margin-top: 50px;
            padding: 5px 10px;
        }
    </style>
</head>

<body>
<div class="main">
    <h2>没有菜单操作权限，请重新登录 <a href="${pageContext.request.contextPath }/account/login">去登录</a></h2>
</div>
</body>
</html>
