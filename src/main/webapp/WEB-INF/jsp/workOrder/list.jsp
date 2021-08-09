<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/8/9
  Time: 21:28
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
            src="${pageContext.request.contextPath }/static/js/common/common.js?t=20201028"></script>
    <title>工单管理</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    <!--只显示用户有的店铺-->
    标题：
    <select class="easyui-combobox" id="s_title" style="width:150px;">
    </select>
    入库时间：
    <input class="easyui-datebox" id="s_warehousingTimeStart">
    -
    <input class="easyui-datebox" id="s_warehousingTimeEnd">
    批号：
    <input class="easyui-validatebox textbox" id="s_batchNumber">
    店铺sku：
    <input class="easyui-validatebox textbox" id="s_shopSku">
    入库类型：
    <select class="easyui-combobox" id="s_type" style="width:100px;">
        <option value="">全部</option>
        <option value="1">生产单入库</option>
        <option value="2">手工入库</option>
    </select>
    生产单批次号：
    <input class="easyui-validatebox textbox" id="s_produceOrderBatchNumber">
    状态：
    <select class="easyui-combobox" id="s_status" style="width:100px;">
        <option value="">全部</option>
        <option value="1">待入库</option>
        <option value="2">已入库</option>
        <option value="0">取消</option>
    </select>
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
    <a href="javascript:void(0)" onclick="exportWarehousingOrder()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
    >下载入库单</a>
</div>
<!--入库单列表-->
<table id="dg" style="width: 100%; height: auto">

</table>
</body>
</html>
