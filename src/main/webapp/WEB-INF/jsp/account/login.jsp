<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/3
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.5.4/themes/default/easyui.css"
          type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.5.4/themes/icon.css"
          type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.5.4/demo/demo.css"
          type="text/css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.5.4/jquery.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.5.4/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.5.4/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/common/common.js?t=20200929"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/common/cookieUtil.js?t=20200928"></script>
    <title>用户登录</title>
    <style>
        .login {
            text-align: center; /*让div内部文字居中*/
            background-color: #fff;
            border-radius: 20px;
            width: 300px;
            height: 350px;
            margin: auto;
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            font-size: large;
        }
    </style>
    <script type="text/javascript">
        //获取url中的参数
        function getQueryString(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", 'i'); // 匹配目标参数
            var result = window.location.search.substr(1).match(reg); // 对querystring匹配目标参数
            if (result != null) {
                return decodeURIComponent(result[2]);
            } else {
                return null;
            }
        }

        function login() {
            var userName = $("#userName").val();
            var password = $("#password").val();
            if (userName == '') {
                $.messager.alert("提示", "请填写用户名.");
                return;
            }
            if (password == '') {
                $.messager.alert("提示", "请填写密码.");
                return;
            }
            $.post('${pageContext.request.contextPath }/account/dologin', {userName: userName, password: password}, function (data) {
                if (data.code == '200') {
                    $.messager.alert("提示", "登录成功");
                    var backUrl = getQueryString("backUrl");
                    if (isEmpty(backUrl)) {
                        backUrl = "${pageContext.request.contextPath }/";
                    }
                    setCookie("loginUserName",data.data.userName);
                    var rightStrs="";
                    if(data.data.rightStrList!=null){
                        rightStrs=data.data.rightStrList.join(',');
                    }
                    setCookie("rightStrs",","+rightStrs+",");
                    window.location.href = backUrl;
                }
                else {
                    if (data.erroList != null && data.erroList.length > 0) {
                        $.messager.alert("提示", data.erroList[0].message);
                    } else {
                        $.messager.alert("提示", data.message);
                    }
                }
            });
        }
        function getKey()
        {
            if(event.keyCode==13){
                login();
            }
        }

    </script>

</head>
<body>

<div class="login">
    用户名：<input type="text" name="userName" id="userName" value=""/><br>
    密&nbsp;&nbsp;码：<input type="password" name="password" id="password" onkeypress="getKey();" value=""/><br>
    <input type="button" id="btn_login" onclick="login()" value="登录">
</div>

</body>
</html>
