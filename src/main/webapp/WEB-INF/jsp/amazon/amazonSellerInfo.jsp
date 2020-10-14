<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2018/12/26
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>亚马逊销售数据统计</title>
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
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/common/common.js?t=20200929"></script>

</head>
<body>
<div style="width: 600px; height: 300px; padding: 10px 20px">
    <div class="ftitle">
        <b>亚马逊销售数据统计</b>
        <hr/>
        <label style="color: red">txt数据转换为Excel时需要另存为Excel，不然会读取不到Excel数据</label>
    </div>
    <form id="frm" method="post" novalidate="novalidate" enctype="multipart/form-data">
        <input type="file" id="file" name="file" accept=".xls,.xlsx"/>
        <div style="text-align:center;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" onclick="countSellerInfo()">销售数据统计</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" onclick="orderExport()">订单数据统计</a>
        </div>
    </form>
</div>
<div id="cover">
    <div id="coverMsg">
        <img src="${pageContext.request.contextPath }/static/img/loading.gif" width="100px">
    </div>
</div>
<script type="text/javascript">
    function countSellerInfo() {
        var file = $("#file").val();
        if (file == '') {
            $.messager.alert("提示", "请选择要转换的的文件");
            return;
        }
        var dom = document.getElementById("file");
        var fileSize = dom.files[0].size;
        if (fileSize > 30000000) {
            $.messager.alert("提示", "上传文件过大,请上传小于30M的文件");
            return false;
        }
        $('#frm').form('submit', {
            url: '${pageContext.request.contextPath }/amazon/countSellerInfo',
            onSubmit: function () {
                var isValid = $(this).form('validate');
                if (isValid) {
                    showCover();
                }
                return isValid;
            },
            success: function (data) {
                hideCover();
                res = eval("(" + data + ")")
                if (res.code == '200') {
                    $.messager.alert("提示", "转换成功");
                }
                else {
                    $.messager.alert("提示", res.message);
                }
                //关闭遮罩
            }
        });
    }

    function orderExport() {
        var file = $("#file").val();
        if (file == '') {
            $.messager.alert("提示", "请选择要转换的的文件");
            return;
        }
        var dom = document.getElementById("file");
        var fileSize = dom.files[0].size;
        if (fileSize > 30000000) {
            $.messager.alert("提示", "上传文件过大,请上传小于30M的文件");
            return false;
        }
        //弹出遮罩
        $('#frm').form('submit', {
            url: '${pageContext.request.contextPath }/amazon/orderExport',
            onSubmit: function () {
                var isValid = $(this).form('validate');
                if (isValid) {
                    showCover();
                }
                return isValid;
            },
            success: function (data) {
                hideCover();
                res = eval("(" + data + ")")
                if (res.code == '200') {
                    $.messager.alert("提示", "转换成功");
                }
                else {
                    $.messager.alert("提示", res.message);
                }
                //关闭遮罩
            }
        });
    }
</script>
</body>
</html>
