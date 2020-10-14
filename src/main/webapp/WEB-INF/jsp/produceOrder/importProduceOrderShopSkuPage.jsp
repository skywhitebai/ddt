<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2020/4/26
  Time: 14:46
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
            src="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.5.4/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/main.css?t=20200928" type="text/css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/common/common.js?t=20200929"></script>
    <title>导入生产单店铺sku</title>
</head>
<body>
<div class="ftitle">
    <b>生产单店铺sku导入</b>
    <hr/>
    模板下载：
    <a href="${pageContext.request.contextPath }/static/template/produceOrder/produceOrderShopSkuImportTemplate.xlsx"
       target="_blank">模板下载</a>
</div>
<form id="frm_importProduceOrderShopSku" method="post" novalidate="novalidate" enctype="multipart/form-data">
    <input type="file" id="importProduceOrderShopSkuFile" name="file" accept=".xls,.xlsx"/>
    <input type="hidden" id="produceOrderId" name="produceOrderId">
    <div style="text-align:center;">
        <a href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-ok'" onclick="importProduceOrderShopSku()">导入</a>
        <a href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-cancel'" onclick="closeIframeDialog()">关闭</a>
    </div>
</form>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        bindFirst();
    });
    function bindFirst() {
        var produceOrderId = getQueryVariable('produceOrderId');
        if (!isEmpty(produceOrderId)) {
            $("#produceOrderId").val(decodeURI(produceOrderId));
        }else{
            $.messager.alert("提示", "生产单id不能为空.");
        }
    }
    function closeIframeDialog() {
        window.parent.closeImportProduceOrderShopSkuDialog();
    }
    function importProduceOrderShopSku() {
        var importProduceOrderShopSkuFile = $("#importProduceOrderShopSkuFile").val();
        if (importProduceOrderShopSkuFile == '') {
            $.messager.alert("提示", "请选择导入的文件");
            return;
        }
        var dom = document.getElementById("importProduceOrderShopSkuFile");
        var fileSize = dom.files[0].size;
        if (fileSize > 30000000) {
            $.messager.alert("提示", "上传文件过大,请上传小于30M的文件");
            return false;
        }
        $('#frm_importProduceOrderShopSku').form('submit', {
            url: '${pageContext.request.contextPath }/produceOrderShopSku/importProduceOrderShopSku',
            onSubmit: function () {
                var isValid =$(this).form('validate');
                if(isValid){
                    window.parent.showCover();
                }
                return isValid;
            },
            success: function (data) {
                window.parent.hideCover();
                res = eval("(" + data + ")")
                if (res.code == '200') {
                    $.messager.alert("提示", "上传成功");
                    /*window.parent.bindProduceOrderShopSkuData();*/
                }
                else {
                    $.messager.alert("提示", res.message);
                }
            }
        });
    }
</script>
</html>
