<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2020/5/12
  Time: 17:38
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
    <title>店铺sku库存变更记录</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    <!--只显示用户有的店铺-->
    店铺：
    <select class="easyui-combobox" id="s_shopId" style="width:150px;">
    </select>
    创建时间：
    <input class="easyui-datebox" id="s_createTimeStart">
    -
    <input class="easyui-datebox" id="s_createTimeEnd">
    店铺sku：
    <input class="easyui-validatebox textbox" id="s_shopSku">
    产品sku：
    <input class="easyui-validatebox textbox" id="s_sku">
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
</div>
<!--列表-->
<table id="dg" style="width: 100%; height: auto">

</table>
</body>
<script type="text/javascript">
    // 初始化内容
    bindShop();

    function bindShop() {
        $.post('${pageContext.request.contextPath }/shop/comboboxlist', {}, function (data) {
            $('#s_shopId').combobox({
                data: data,
                valueField: 'shopId',
                textField: 'shopName'
            });
            bindData();
        });
    }

    function getQueryParams() {
        queryParams = {
            shopId: $('#s_shopId').combobox('getValue'),
            createTimeStart: $("#s_createTimeStart").val(),
            createTimeEnd: $("#s_createTimeEnd").val(),
            batchNumber: $("#s_batchNumber").val(),
            shopSku: $("#s_shopSku").val(),
            status: $("#s_status").val(),
            sku: $("#s_sku").val()
        };
        return queryParams;
    }

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/inventoryChangeRecord/listInventoryChangeRecord";
        title = "出库单管理";
        queryParams = getQueryParams();
        $(dg).datagrid({   //定位到Table标签，Table标签的ID是grid
                url: url,   //指向后台的Action来获取当前菜单的信息的Json格式的数据
                title: title,
                iconCls: 'icon-view',
                nowrap: true,
                autoRowHeight: true,
                striped: true,
                collapsible: true,
                pagination: true,
                singleSelect: true,
                pageSize: 15,
                pageList: [10, 15, 20, 30, 50],
                rownumbers: true,
                //sortName: 'ID',    //根据某个字段给easyUI排序
                //sortOrder: 'asc',
                remoteSort: false,
                idField: 'id',
                queryParams: queryParams,  //异步查询的参数
                columns: [[
                    {field: 'ck', checkbox: true},   //选择
                    {title: '店铺名', field: 'shopName', width: 120},
                    {title: '店铺sku', field: 'shopSku', width: 120},
                    {title: '产品sku', field: 'sku', width: 120},
                    {title: '变更类型', field: 'changeTypeName', width: 80},
                    {title: '批号', field: 'batchNumber', width: 140},
                    {title: '变更前库存', field: 'inventoryQuantityOld', width: 80},
                    {title: '变更值', field: 'modifiedQuantity', width: 80},
                    {title: '变更后库存', field: 'inventoryQuantityNew', width: 80},
                    {title: '变更人', field: 'createByRealName', width: 80},
                    {title: '创建时间', field: 'createTime', width: 180},
                    {title: '修改时间', field: 'updateTime', width: 180},
                    {title: '备注', field: 'remark', width: 180}
                ]],
                toolbar: [{
                    id: 'btnReload',
                    text: '刷新',
                    iconCls: 'icon-reload',
                    handler: function () {
                        //实现刷新栏目中的数据
                        $(dg).datagrid("reload");
                    }
                }]
            }
        )
        $(dg).datagrid('clearSelections');
    }

</script>
</html>
