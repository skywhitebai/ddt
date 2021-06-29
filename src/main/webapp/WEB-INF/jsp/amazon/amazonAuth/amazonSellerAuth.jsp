<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2021/6/28
  Time: 10:37
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
            src="${pageContext.request.contextPath }/static/js/common/common.js?t=20201028"></script>

    <title>亚马逊授权</title>
</head>
<body>
<div class="easyui-panel">
    <div>
        <div>
            <span>商户id</span><input type="text"
                                    readonly="readonly"
                                    style="width: 500px"
                                    id="sellingPartnerId"/>
        </div>
        <br/>
        <div>
            <span>token</span><input type="text"
                                     readonly="readonly"
                                     style="width: 500px" id="spapiOauthCode"/>
        </div>
    </div>
    <div>
        <a href="javascript:void(0)" onclick="saveAmazonAuth()" class="easyui-linkbutton"
           data-options="iconCls:'icon-search'"
           style="width: 80px">保存</a>
    </div>
</div>
</body>
<script type="text/javascript">
    initAuthInfo();
    function initAuthInfo() {
        sellingPartnerId = getQueryVariable("sellingPartnerId");
        spapiOauthCode = getQueryVariable("spapiOauthCode");
        if (isEmpty(sellingPartnerId)) {
            $.messager.alert("提示", "商户id不能为空");
            return;
        }
        if (isEmpty(spapiOauthCode)) {
            $.messager.alert("提示", "token不能为空");
            return;
        }
        $("#sellingPartnerId").val(sellingPartnerId);
        $("#spapiOauthCode").val(spapiOauthCode);
    }

    function saveAmazonAuth() {
        sellingPartnerId = $("#sellingPartnerId").val();
        spapiOauthCode = $("#spapiOauthCode").val();
        if (isEmpty(sellingPartnerId)) {
            $.messager.alert("提示", "商户id不能为空");
            return;
        }
        if (isEmpty(spapiOauthCode)) {
            $.messager.alert("提示", "token不能为空");
            return;
        }
        $.post('${pageContext.request.contextPath }/amazonAuth/saveAmazonAuth', {
            sellingPartnerId: sellingPartnerId,
            spapiOauthCode: spapiOauthCode
        }, function (data) {
            if (data.code == '200') {
                window.location.href = "${pageContext.request.contextPath }/";
            }
            else {
                $.messager.alert("提示", data.message);
            }
        });
    }
</script>
</html>
