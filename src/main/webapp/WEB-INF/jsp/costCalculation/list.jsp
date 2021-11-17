<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2020/8/13
  Time: 18:44
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
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/main.css?t=20200928" type="text/css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/common/common.js?t=20201028"></script>
    <title>成本核算管理</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    sku
    <input class="easyui-validatebox textbox" id="s_sku">
    年月
    <input class="easyui-validatebox textbox" id="s_month">
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
   <%-- <a href="javascript:void(0)" onclick="exportShopHeadTripCost()" class="easyui-linkbutton"
       data-options="iconCls:'icon-search'">下载成本价</a>--%>
</div>
<table id="dg" style="width: 100%; height: auto">

</table>

<!--编辑页面-->
<div id="dlgCostCalculationSku" class="easyui-dialog" style="width: 850px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', top:50,align:'center'">
    <input type="hidden" id="dlgCostCalculationSku_costCalculationId">
    <!--查询条件-->
    <div class="easyui-panel">
        sku：
        <input class="easyui-validatebox textbox" id="dlgCostCalculationSku_sku">
        <a href="javascript:void(0)" onclick="bindCostCalculationSku()" class="easyui-linkbutton"
           data-options="iconCls:'icon-search'"
           style="width: 80px">查 询</a>
    </div>
    <table id="dgCostCalculationSku" style="width: 100%; height: auto">
    </table>
</div>

<div id="cover">
    <div id="coverMsg">
        <img src="${pageContext.request.contextPath }/static/img/loading.gif" width="100px">
    </div>
</div>
<script type="text/javascript">
    $(function () {
        initMonth('s_month');
        bindData();
    });

    function getQueryParams() {
        queryParams = {
            sku: $("#s_sku").val(),
            month: $("#s_month").val()
        };
        return queryParams;

    }

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/costCalculation/list";
        title = "成本核算管理";
        queryParams = getQueryParams();
        $(dg).datagrid({   //定位到Table标签，Table标签的ID是grid
            url: url,   //指向后台的Action来获取当前菜单的信息的Json格式的数据
            title: title,
            iconCls: 'icon-view',
            nowrap: true,
            autoRowHeight: false,
            striped: true,
            collapsible: true,
            pagination: true,
            nowrap: false,
            //singleSelect: true,
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
                {
                    title: '年月', field: 'month', width: 80, formatter: function (value, row, index) {
                        if (value) {
                            return value.substr(0, 7);
                        }
                    }
                }, {
                    title: 'sku成本',
                    field: 'costCalculationSku',
                    width: 120,
                    formatter: function (value, row, index) {
                        return "<a href='#' onclick=\"showDlgCostCalculationSku(" + row.id + ")\" title='sku成本' >sku成本</a>";
                    }
                },
                {
                    title: '备注', field: 'remark', width: 288,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-textbox " style="width:100%"  onchange="saveRemark(this,' + row.id + ')">';
                        } else {
                            return '<input class="easyui-textbox" style="width:100%" value="' + value + '" onchange="saveRemark(this,' + row.id + ')">';
                        }
                    }
                }, {
                    title: '操作',
                    field: 'deal',
                    width: 120,
                    formatter: function (value, row, index) {
                        return "<a href='#' onclick=\"exportCostCalculationSku(" + row.id + ")\" title='下载成本核算' >下载成本核算</a>";
                    }
                },
                {title: '创建时间', field: 'createTime', width: 150},
                {title: '修改时间', field: 'updateTime', width: 150}
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
        })
        $(dg).datagrid('clearSelections');
    }

    function saveRemark(input, id) {
        var remark = $(input).val();
        $.post('${pageContext.request.contextPath }/costCalculation/saveCostCalculationRemark', {
            id: id,
            remark: remark
        }, function (data) {
            if (data.code == '200') {
            } else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function exportCostCalculationSku(id) {
        url = "${pageContext.request.contextPath }/costCalculationSku/exportCostCalculationSku?costCalculationId" +id;
        window.open(url);
    }

    function showDlgCostCalculationSku(id) {
        $('#dlgCostCalculationSku').dialog('open').dialog('setTitle', 'sku成本信息');
        $('#dlgCostCalculationSku_costCalculationId').val(id);
        $('#dlgCostCalculationSku_sku').val(null);
        bindCostCalculationSku();
    }

    function bindCostCalculationSku() {
        dg = '#dgCostCalculationSku';
        url = "${pageContext.request.contextPath }/costCalculationSku/listCostCalculationSku";
        title = "sku成本";
        queryParams = {
            costCalculationId: $('#dlgCostCalculationSku_costCalculationId').val(),
            sku: $('#dlgCostCalculationSku_sku').val()
        };
        $(dg).datagrid({   //定位到Table标签，Table标签的ID是grid
            url: url,   //指向后台的Action来获取当前菜单的信息的Json格式的数据
            title: title,
            iconCls: 'icon-view',
            nowrap: true,
            autoRowHeight: false,
            striped: true,
            collapsible: true,
            pagination: true,
            //singleSelect: true,
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
                {
                    title: '年月', field: 'month', width: 80, formatter: function (value, row, index) {
                        if (value) {
                            return value.substr(0, 7);
                        }
                    }
                },
                {title: 'sku', field: 'sku', width: 160},
                {title: '工价', field: 'labourCost', width: 80},
                {title: '修改前成本', field: 'costPriceBefore', width: 80},
                {title: '库存', field: 'inventoryQuantity', width: 80},
                {title: '生产数量', field: 'productionQuantity', width: 80},
                {title: '生产总成本', field: 'productionCostTotal', width: 80},
                {title: '生产单个成本', field: 'productionCostPrice', width: 80},
                {title: '修改后成本', field: 'costPriceAfter', width: 80},
                {title: '创建时备注', field: 'createTime', width: 120}
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
        })
        $(dg).datagrid('clearSelections');
    }
</script>

</body>
</html>
