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
    <style>
        #cover{
            position: fixed;
            top: 0;
            left: 0;
            height: 100%;
            width: 100%;
            background-color: rgba(0,0,0,0.3);
            display:none;
            z-index:1000;
        }
    </style>
</head>
<body>
<!--sku导入页面-->
<div style="width: 600px; height: 300px; padding: 10px 20px">
    <div class="ftitle">
        <b>sku信息转换</b>
        <hr/>
        模板下载：
        <a href="${pageContext.request.contextPath }/static/template/productInfoTemplate1.xlsx" target="_blank">模板1</a>

        <a href="${pageContext.request.contextPath }/static/template/productInfoTemplate2.xlsx" target="_blank">模板2</a><br>
    </div>
    <form id="frm_transformSkuInfo" method="post" novalidate="novalidate" enctype="multipart/form-data">
        <input type="file" id="transformSkuInfoFile" name="file" accept=".xls,.xlsx"/>
        <div style="text-align:center;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" onclick="transformSkuInfo()">转换</a>
        </div>
    </form>
</div>
<div id="cover"></div>
<script type="text/javascript">
    function transformSkuInfo() {
        var transformSkuInfoFile = $("#transformSkuInfoFile").val();
        if (transformSkuInfoFile == '') {
            $.messager.alert("提示", "请选择要转换的的文件");
            return;
        }
        var dom = document.getElementById("transformSkuInfoFile");
        var fileSize = dom.files[0].size;
        if (fileSize > 30000000) {
            $.messager.alert("提示","上传文件过大,请上传小于30M的文件");
            return false;
        }
        //弹出遮罩
        showCover();
        $('#frm_transformSkuInfo').form('submit', {
            url: '${pageContext.request.contextPath }/skuInfo/transformSkuInfoAll',
            onSubmit: function () {
                return $(this).form('validate');
            },
            success: function (data) {
                res=eval("("+data+")")
                if (res.code == '200') {
                    $.messager.alert("提示", "上传成功");
                    bindImgData();
                }
                else {
                    $.messager.alert("提示", res.message);
                }
                //关闭遮罩
            }
        });
    }
  function showCover() {
      var cover=document.getElementById('cover');
      cover.style.display='block';
      setTimeout(function(){
          cover.style.display='none';
      },2000)
  }
</script>
</body>
</html>
