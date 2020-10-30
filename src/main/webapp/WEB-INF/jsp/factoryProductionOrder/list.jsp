<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2020/10/10
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.5.4/themes/default/easyui.css"
          type="text/css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.5.4/themes/icon.css"
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
    <title>工厂生产单管理</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    店铺：
    <select id="s_shopId" style="width:150px;">
    </select>
    工厂生产单id：
    <input class="easyui-numberbox" id="s_id" data-options="min:1,precision:0">
    店铺sku
    <input class="easyui-validatebox textbox" id="s_shopSku">
    产品sku
    <input class="easyui-validatebox textbox" id="s_sku">
    状态：
    <select class="easyui-combobox" id="s_status" style="width:100px;">
        <option value="">全部</option>
        <option value="1">待确认</option>
        <option value="2">已确认</option>
        <option value="0">取消</option>
    </select>
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
</div>
<table id="dg" style="width: 100%; height: auto">
</table>

<!--工厂生产单产品信息-->
<div id="dlgFactoryProductionOrderShopSku" class="easyui-dialog" style="width: 800px; height: 660px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, align:'center'">
    <div>
        <input type="hidden" id="s_factoryProductionOrderShopSku_factoryProductionOrderId">
        店铺父sku
        <input class="easyui-validatebox textbox" id="s_factoryProductionOrderShopSku_shopParentSku"
               data-options="disable:true">
        <a href="javascript:void(0)" onclick="bindFactoryProductionOrderShopSkuData()" class="easyui-linkbutton"
           data-options="iconCls:'icon-search'"
           style="width: 80px">查 询</a>
    </div>
    <table id="dgFactoryProductionOrderShopSku" style="width: 100%; height: auto">
    </table>
    <div style="text-align:center;">
        <a href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-cancel'" onclick="closeDlgFactoryProductionOrderShopSku()">关闭</a>
    </div>
</div>
<!--工厂生产单详情-->
<div id="dlgFactoryProductionOrderInfo" class="easyui-dialog" style="width: 1100px; height: 660px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, align:'center'">
    <div>
        店铺父sku
        <input class="easyui-validatebox textbox" id="s_factoryProductionOrderInfo_shopParentSku"
               data-options="disable:true">
        <a href="javascript:void(0)" onclick="bindFactoryProductionOrderInfoData()" class="easyui-linkbutton"
           data-options="iconCls:'icon-search'"
           style="width: 80px">查 询</a>
    </div>
    <table id="dgFactoryProductionOrderInfo" style="width: 100%; height: auto">
    </table>
    <div style="text-align:center;">
        <a href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-cancel'" onclick="closeDlgFactoryProductionOrderInfo()">关闭</a>
    </div>
</div>
</body>
<script type="text/javascript">
    bindShop();
    bindData();

    function bindShop() {
        $('#s_shopId').combobox({
            valueField: 'shopId',
            textField: 'shopName',
            url: "${pageContext.request.contextPath }/shop/userShopComboboxlist",//获取数据
        });
    }

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/factoryProductionOrder/listFactoryProductionOrder";
        title = "工厂生产单管理";
        queryParams = {
            shopId: $("#s_shopId").combobox('getValue'),
            id: $("#s_id").val(),
            shopSku: $("#s_shopSku").val(),
            sku: $("#s_sku").val(),
            status: $("#s_status").val()
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
            singleSelect: true,
            pageSize: 15,
            pageList: [10, 15, 20, 30, 50, 100, 200, 500],
            rownumbers: true,
            //sortName: 'ID',    //根据某个字段给easyUI排序
            //sortOrder: 'asc',
            remoteSort: false,
            idField: 'id',
            queryParams: queryParams,  //异步查询的参数
            columns: [[
                {field: 'ck', checkbox: true},   //选择
                {title: '工厂生产单id', field: 'id', width: 88},
                {title: '店铺名', field: 'shopName', width: 120},
                {title: '标题', field: 'title', width: 180},
                {
                    title: '状态', field: 'status', width: 130,
                    formatter: function (value, row, rowIndex) {
                        if (value == 0) {
                            return "取消";
                        } else if (value == 1) {
                            return "待确认";
                        } else if (value == 2) {
                            return "已确认";
                        }
                    }
                },
                {
                    title: '备注', field: 'remark', width: 288,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-numberbox " min="0" precision="0"  onchange="saveFactoryProductionOrderRemark(this,' + row.id + ')">';
                        } else {
                            return '<input class="easyui-textbox" style="width:100%" value="' + value + '" onchange="saveFactoryProductionOrderRemark(this,' + row.id + ')">';
                        }
                    }
                },
                {title: '创建时间', field: 'createTime', width: 180},
                {
                    title: '操作', field: 'stockRecordId', width: 600,
                    formatter: function (value, row, rowIndex) {
                        return '<a href="javascript:void(0)" onclick="showDlgFactoryProductionOrderShopSku(' + row.id + ',\'' + row.title + '\')" class="easyui-linkbutton" >查看生产单店铺sku</a>'
                            + '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="downFactoryProductionOrder(' + row.id + ')" class="easyui-linkbutton" >下载工厂生产单</a>';
                    }
                }
            ]],
            toolbar: [{
                id: 'btnReload',
                text: '刷新',
                iconCls: 'icon-reload',
                handler: function () {
                    //实现刷新栏目中的数据
                    $(dg).datagrid("reload");
                }
            }, '-', {
                id: 'btnConfirm',
                text: '确认',
                iconCls: 'icon-edit',
                handler: function () {
                    confirmFactoryProductionOrder();
                }
            }, '-', {
                id: 'btnDelete',
                text: '取消',
                iconCls: 'icon-remove',
                handler: function () {
                    cancelFactoryProductionOrder();
                }
            }]
        })
        $(dg).datagrid('clearSelections');
    }

    function saveFactoryProductionOrderRemark(input, id) {
        var remark = $(input).val();
        $.post('${pageContext.request.contextPath }/factoryProductionOrder/saveFactoryProductionOrderRemark', {
            id: id,
            remark: remark
        }, function (data) {
            if (data.code == '200') {
                $.messager.alert("提示", "修改成功");
                bindData();
            }
            else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function showDlgFactoryProductionOrderShopSku(factoryProductionOrderId, title) {
        $("#s_factoryProductionOrderShopSku_factoryProductionOrderId").val(factoryProductionOrderId);
        $('#dlgFactoryProductionOrderShopSku').dialog('open').dialog('setTitle', title + '-工厂生产单详情');
        bindFactoryProductionOrderShopSkuData();
    }

    function bindFactoryProductionOrderShopSkuData() {
        dg = '#dgFactoryProductionOrderShopSku';
        url = "${pageContext.request.contextPath }/factoryProductionOrder/listFactoryProductionOrderShopParentSku";
        title = "工厂生产单产品信息";
        queryParams = {
            factoryProductionOrderId: $("#s_factoryProductionOrderShopSku_factoryProductionOrderId").val(),
            shopParentSku: $("#s_factoryProductionOrderShopSku_shopParentSku").val()
        };
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
                {title: '店铺父sku', field: 'shopParentSku', width: 150},
                {title: '生产数量', field: 'productionQuantity', width: 90},
                {
                    title: '操作', field: 'deal', width: 300,
                    formatter: function (value, row, rowIndex) {
                        return '<a href="javascript:void(0)" onclick="showDlgFactoryProductionOrderInfo(\'' + row.shopParentSku + '\')" class="easyui-linkbutton" >生产数量管理</a>'
                            + '&nbsp;&nbsp;&nbsp;&nbsp;' + '<a href="javascript:void(0)" onclick="downFactoryProductionOrderByShopParentSku(\'' + row.shopParentSku + '\')" class="easyui-linkbutton" >下载工厂生产单</a>';
                    }
                }
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
        //$(dg).datagrid('clearSelections');
    }

    function closeDlgFactoryProductionOrderShopSku() {
        $('#dlgFactoryProductionOrderShopSku').dialog('close');
    }

    function showDlgFactoryProductionOrderInfo(shopParentSku) {
        if (isEmpty(shopParentSku)) {
            $.messager.alert("提示", "店铺父sku为空，请晚上店铺sku信息");
            return;
        }
        $("#s_factoryProductionOrderInfo_shopParentSku").val(shopParentSku);
        $('#dlgFactoryProductionOrderInfo').dialog('open').dialog('setTitle', shopParentSku + '-生产数量管理');
        bindFactoryProductionOrderInfoData();
    }

    function bindFactoryProductionOrderInfoData() {
        dg = '#dgFactoryProductionOrderInfo';
        url = "${pageContext.request.contextPath }/factoryProductionOrder/listFactoryProductionOrderInfo";
        title = "工厂生产单生产数量管理";
        queryParams = {
            shopParentSku: $("#s_factoryProductionOrderInfo_shopParentSku").val(),
            factoryProductionOrderId: $("#s_factoryProductionOrderShopSku_factoryProductionOrderId").val()
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
            singleSelect: true,
            pageSize: 50,
            pageList: [10, 15, 20, 30, 50, 100, 200, 500],
            rownumbers: true,
            //sortName: 'ID',    //根据某个字段给easyUI排序
            //sortOrder: 'asc',
            remoteSort: false,
            idField: 'id',
            queryParams: queryParams,  //异步查询的参数
            columns: [[
                {field: 'ck', checkbox: true},   //选择
                {title: '店铺父sku', field: 'shopParentSku', width: 150},
                {title: '颜色', field: 'colour', width: 100},
                {
                    title: 'XS', field: 'productionQuantityXS', width: 60,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-numberbox " min="0" precision="0"  onchange="saveProductionQuantity(this,\'' + row.shopParentSku + '\',\'' + row.colour + '\',\'XS\')">';
                        } else {
                            return '<input class="easyui-numberbox " min="0" precision="0" value="' + value + '" onchange="saveProductionQuantity(this,\'' + row.shopParentSku + '\',\'' + row.colour + '\',\'XS\')">';
                        }
                    }
                },
                {
                    title: 'S', field: 'productionQuantityS', width: 60,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-numberbox " min="0" precision="0"  onchange="saveProductionQuantity(this,\'' + row.shopParentSku + '\',\'' + row.colour + '\',\'S\')">';
                        } else {
                            return '<input class="easyui-numberbox " min="0" precision="0" value="' + value + '" onchange="saveProductionQuantity(this,\'' + row.shopParentSku + '\',\'' + row.colour + '\',\'S\')">';
                        }
                    }
                },
                {
                    title: 'M', field: 'productionQuantityM', width: 60,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-numberbox " min="0" precision="0"  onchange="saveProductionQuantity(this,\'' + row.shopParentSku + '\',\'' + row.colour + '\',\'M\')">';
                        } else {
                            return '<input class="easyui-textbox" style="width:100%" value="' + value + '" onchange="saveProductionQuantity(this,\'' + row.shopParentSku + '\',\'' + row.colour + '\',\'M\')">';
                        }
                    }
                },
                {
                    title: 'L', field: 'productionQuantityL', width: 60,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-numberbox " min="0" precision="0"  onchange="saveProductionQuantity(this,\'' + row.shopParentSku + '\',\'' + row.colour + '\',\'L\')">';
                        } else {
                            return '<input class="easyui-textbox" style="width:100%" value="' + value + '" onchange="saveProductionQuantity(this,\'' + row.shopParentSku + '\',\'' + row.colour + '\',\'L\')">';
                        }
                    }
                },
                {
                    title: 'XL', field: 'productionQuantityXL', width: 60,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-numberbox " min="0" precision="0"  onchange="saveProductionQuantity(this,\'' + row.shopParentSku + '\',\'' + row.colour + '\',\'XL\')">';
                        } else {
                            return '<input class="easyui-textbox" style="width:100%" value="' + value + '" onchange="saveProductionQuantity(this,\'' + row.shopParentSku + '\',\'' + row.colour + '\',\'XL\')">';
                        }
                    }
                },
                {
                    title: '2XL', field: 'productionQuantity2XL', width: 60,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-numberbox " min="0" precision="0"  onchange="saveProductionQuantity(this,\'' + row.shopParentSku + '\',\'' + row.colour + '\',\'2XL\')">';
                        } else {
                            return '<input class="easyui-textbox" style="width:100%" value="' + value + '" onchange="saveProductionQuantity(this,\'' + row.shopParentSku + '\',\'' + row.colour + '\',\'2XL\')">';
                        }
                    }
                },
                {
                    title: '3XL', field: 'productionQuantity3XL', width: 60,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-numberbox " min="0" precision="0"  onchange="saveProductionQuantity(this,\'' + row.shopParentSku + '\',\'' + row.colour + '\',\'3XL\')">';
                        } else {
                            return '<input class="easyui-textbox" style="width:100%" value="' + value + '" onchange="saveProductionQuantity(this,\'' + row.shopParentSku + '\',\'' + row.colour + '\',\'3XL\')">';
                        }
                    }
                },
                {
                    title: '4XL', field: 'productionQuantity4XL', width: 60,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-numberbox " min="0" precision="0"  onchange="saveProductionQuantity(this,\'' + row.shopParentSku + '\',\'' + row.colour + '\',\'4XL\')">';
                        } else {
                            return '<input class="easyui-textbox" style="width:100%" value="' + value + '" onchange="saveProductionQuantity(this,\'' + row.shopParentSku + '\',\'' + row.colour + '\',\'4XL\')">';
                        }
                    }
                },
                {
                    title: '5XL', field: 'productionQuantity5XL', width: 60,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-numberbox " min="0" precision="0"  onchange="saveProductionQuantity(this,\'' + row.shopParentSku + '\',\'' + row.colour + '\',\'5XL\')">';
                        } else {
                            return '<input class="easyui-textbox" style="width:100%" value="' + value + '" onchange="saveProductionQuantity(this,\'' + row.shopParentSku + '\',\'' + row.colour + '\',\'5XL\')">';
                        }
                    }
                },
                {
                    title: '6XL', field: 'productionQuantity6XL', width: 60,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-numberbox " min="0" precision="0"  onchange="saveProductionQuantity(this,\'' + row.shopParentSku + '\',\'' + row.colour + '\',\'6XL\')">';
                        } else {
                            return '<input class="easyui-textbox" style="width:100%" value="' + value + '" onchange="saveProductionQuantity(this,\'' + row.shopParentSku + '\',\'' + row.colour + '\',\'6XL\')">';
                        }
                    }
                }
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

    function saveProductionQuantity(input, shopParentSku, colour, size) {
        var productionQuantity = $(input).val();
        $.post('${pageContext.request.contextPath }/factoryProductionOrder/saveProductionQuantity', {
            shopParentSku: shopParentSku,
            productionQuantity: productionQuantity,
            size: size,
            colour: colour,
            factoryProductionOrderId: $("#s_factoryProductionOrderShopSku_factoryProductionOrderId").val()
        }, function (data) {
            if (data.code == '200') {
                bindData();
            }
            else {
                $.messager.alert("提示", data.message);
                $(input).val("");
            }
        });
    }

    function closeDlgFactoryProductionOrderInfo() {
        $('#dlgFactoryProductionOrderInfo').dialog('close');
    }

    function downFactoryProductionOrderByShopParentSku(shopParentSku) {
        factoryProductionOrderId = $("#s_factoryProductionOrderShopSku_factoryProductionOrderId").val()
        var url = '${pageContext.request.contextPath }/factoryProductionOrder/downFactoryProductionOrderByShopParentSku?shopParentSku=' + shopParentSku + "&factoryProductionOrderId=" + factoryProductionOrderId + "&t=" + getTimestamp();
        window.open(url);
    }

    function downFactoryProductionOrder(factoryProductionOrderId) {
        var url = '${pageContext.request.contextPath }/factoryProductionOrder/downFactoryProductionOrder?factoryProductionOrderId=' + factoryProductionOrderId + "&t=" + getTimestamp();
        window.open(url);
    }
    //确认
    function confirmFactoryProductionOrder() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            //添加二次确认
            $.messager.confirm('提示', '确认要设置店铺[' + rows[0].shopName + ']的工厂生产单为已确认吗？确认后不允许修改数量', function (r) {
                if (r) {
                    confirmFactoryProductionOrderById(rows[0].id);
                }
            });
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }
    function confirmFactoryProductionOrderById(id) {
        $.post('${pageContext.request.contextPath }/factoryProductionOrder/confirmFactoryProductionOrder', {id: id}, function (data) {
            if (data.code == '200') {
                bindData();
            }
            else {
                $.messager.alert("提示", data.message);
            }
        });
    }
    function cancelFactoryProductionOrder() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $.messager.confirm('提示', '确认废除店铺[' + rows[0].shopName + ']的工厂生产单吗？', function (r) {
                if (r) {
                    $.post('${pageContext.request.contextPath }/factoryProductionOrder/cancelFactoryProductionOrder', {id: rows[0].id}, function (data) {
                        if (data.code == '200') {
                            bindData();
                        }
                        else {
                            $.messager.alert("提示", data.message);
                        }
                    });
                }
            });
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }
</script>
</html>
