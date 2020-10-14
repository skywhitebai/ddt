<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/30
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商户sku信息转换</title>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/main.css?t=20200928" type="text/css">

</head>
<body>
<!--sku导入页面-->
<div style="width: 600px; height: 300px; padding: 10px 20px">
    <div class="ftitle">
        <b>店铺sku信息转换</b>
        <hr/>
        模板下载：
        <a href="${pageContext.request.contextPath }/static/template/productInfoTemplate1.xlsx" target="_blank">模板1</a>

        <a href="${pageContext.request.contextPath }/static/template/productInfoTemplate2.xlsx" target="_blank">模板2</a><br>
    </div>
    <form id="frm_transformShopSkuInfo" method="post" novalidate="novalidate" enctype="multipart/form-data">
        <input type="file" id="transformShopSkuInfoFile" name="file" accept=".xls,.xlsx"/>
        <div style="text-align:center;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" onclick="transformShopSkuInfo()">转换</a>
        </div>
    </form>
</div>
<div class="cover"></div>
<script type="text/javascript">
    function transformShopSkuInfo() {
        var transformShopSkuInfoFile = $("#transformShopSkuInfoFile").val();
        if (transformShopSkuInfoFile == '') {
            $.messager.alert("提示", "请选择要转换的的文件");
            return;
        }
        var dom = document.getElementById("transformShopSkuInfoFile");
        var fileSize = dom.files[0].size;
        if (fileSize > 30000000) {
            $.messager.alert("提示","上传文件过大,请上传小于30M的文件");
            return false;
        }
        //弹出遮罩
        showCover();
        $('#frm_transformShopSkuInfo').form('submit', {
            url: '${pageContext.request.contextPath }/shopSku/transformShopSkuInfo',
            onSubmit: function () {
                return $(this).form('validate');
            },
            success: function (data) {
                res=eval("("+data+")")
                if (res.code == '200') {
                    $.messager.alert("提示", "转换成功");
                }
                else {
                    $.messager.alert("提示", res.message);
                }
            }
        });
    }

    function showCover() {
        $('div.cover').css("display","block");
        setTimeout(function () {
            $('div.cover').css("display","none");
        }, 2000)
    }

</script>
</body>
</html>
