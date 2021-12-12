<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/8/21
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath }/static/js/jquery-easyui-1.7.0/themes/default/easyui.css"
          type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/js/jquery-easyui-1.7.0/themes/icon.css"
          type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/js/jquery-easyui-1.7.0/demo/demo.css"
          type="text/css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/jquery-easyui-1.7.0/jquery.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/jquery-easyui-1.7.0/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/jquery-easyui-1.7.0/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/common/common.js?t=20201028"></script>
    <title>库存历史记录</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    <!--只显示用户有的店铺-->
    产品编码：
    <input class="easyui-validatebox textbox" id="s_productCode">
    产品sku：
    <input class="easyui-validatebox textbox" id="s_sku">
    年月
    <input class="easyui-validatebox textbox" id="s_month">
    <form id="ff">
    <input class="easyui-radiobutton" id="searchType_sku" name="searchType" value="sku" label="产品sku"
           data-options="labelPosition:'after',labelWidth:80,checked:true,onChange:bindData">
    <input class="easyui-radiobutton" name="searchType" value="product" label="产品编码"
           data-options="labelPosition:'after',labelWidth:100,onChange:bindData">
    </form>
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
    <a href="javascript:void(0)" onclick="exportData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">下载</a>
</div>
<!--列表-->
<table id="dg" style="width: 100%; height: auto">

</table>
</body>
<script type="text/javascript">
    $(document).ready(function (){
        initMonth('s_month');
        bindData();
    });

    function getQueryParams() {
        queryParams = {
            productCode: $("#s_productCode").val(),
            sku: $("#s_sku").val(),
            month: $("#s_month").val(),
            searchType:$("input[name='searchType']:checked").val()
        };
        return queryParams;
    }
    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/inventoryQuantityHis/listInventoryQuantityHis";
        title = "库存历史记录";
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
                    {title: '产品编码', field: 'productCode', width: 120},
                    {title: '产品名称', field: 'productName', width: 120},
                    {title: '产品sku', field: 'sku', width: 120},
                    {title: '数量', field: 'inventoryQuantity', width: 80},
                    {
                        title: '年月', field: 'month', width: 80, formatter: function (value, row, index) {
                            if (value) {
                                return value.substr(0, 7);
                            }
                        }
                    },
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
    function exportData() {
        queryParams = getQueryParams();
        url = "${pageContext.request.contextPath }/inventoryQuantityHis/exportInventoryQuantityHis" + getUrlParams(queryParams);
        window.open(url);
    }
</script>
</html>
