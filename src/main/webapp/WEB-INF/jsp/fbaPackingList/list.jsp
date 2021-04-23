<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
        <link rel="stylesheet" href="${pageContext.request.contextPath }/static//css/main.css?t=20200928" type="text/css">
        <script type="text/javascript"
                src="${pageContext.request.contextPath }/static/js/common/common.js?t=20201028"></script>
        <title>fba装箱单列表</title>
    </head>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    店铺：
    <select id="s_shopId" style="width:150px;">
    </select>
    店铺sku：
    <input class="easyui-validatebox textbox" id="s_shopSku">
    产品sku：
    <input class="easyui-validatebox textbox" id="s_sku">
    shipmentId：
    <input class="easyui-validatebox textbox" id="s_shipmentId">
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
    <a href="javascript:void(0)" onclick="showDialogImportFbaPackingList()" class="easyui-linkbutton"
       data-options="iconCls:'icon-search'"
       style="">导入fba装箱单信息</a>
</div>
<table id="dg" style="width: 100%; height: auto">
</table>
<!--编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 850px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:10, align:'center'">
    <div class="ftitle">
        <b>fba装箱单信息</b>
        <hr/>
    </div>
    <form id="frm" method="post" novalidate="novalidate">
        <table>
            <tr style="display: none">
                <td>id：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="id">
                </td>
            </tr>
            <tr>
                <td>店铺名：</td>
                <td colspan="3">
                    <input class="easyui-textbox" type="text" name="shopName" style="width: 90%">
                </td>
            </tr>
            <tr>
                <td>shipmentId：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="shipmentId">
                </td>
                <td>Name：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="name">
                </td>
            </tr>
            <tr>
                <td>Plan ID：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="planId">
                </td>
            </tr>
            <tr>
                <td>Ship To：</td>
                <td colspan="3">
                    <input class="easyui-validatebox textbox" name="shipTo" style="width: 95%">
                </td>
            </tr>

            <tr>
                <td>Total SKUs：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="totalSkus">
                </td>
                <td>Total Units：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="totalUnits">
                </td>
            </tr>
            <tr>
                <td>Pack list：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="packList">
                </td>
            </tr>
            <tr class="view_hide">
                <td>创建时间：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="createTime"></td>

                <td>更新时间：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="updateTime"></td>
            </tr>
        </table>
        <div style="text-align:center;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-cancel'" onclick="closeDialog()">关闭</a>
        </div>
    </form>
</div>

<!--导入页面-->
<div id="dlg_importFbaPackingList" class="easyui-dialog" style="width: 600px; height: 300px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:10, align:'center'">
    <div class="ftitle">
        <b>fba装箱单导入</b>
    </div>
    <form id="frm_importFbaPackingList" method="post" novalidate="novalidate" enctype="multipart/form-data">
        <input type="file" id="importFbaPackingListFile" name="file" accept=".xls,.xlsx"/>
        <div style="text-align:center;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" onclick="importFbaPackingList()">导入</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-cancel'" onclick="closeDialogImportFbaPackingList()">关闭</a>
        </div>
    </form>
</div>
<!--编辑页面-->
<div id="dlgShopSku" class="easyui-dialog" style="width: 850px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
    <input type="hidden" id="dlgShopSku_fbaPackingListId">
    <!--查询条件-->
    <div class="easyui-panel">
        店铺sku：
        <input class="easyui-validatebox textbox" id="dlgShopSku_shopSku">
        产品sku：
        <input class="easyui-validatebox textbox" id="dlgShopSku_sku">
        <a href="javascript:void(0)" onclick="bindShopSku()" class="easyui-linkbutton"
           data-options="iconCls:'icon-search'"
           style="width: 80px">查 询</a>
    </div>
    <table id="dgShopSku" style="width: 100%; height: auto">
    </table>
</div>

<!--编辑页面-->
<div id="dlg_InvoiceInfo" class="easyui-dialog" style="width: 1000px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
    <input type="hidden" id="dlg_InvoiceInfo_fbaPackingListId">
    <!--查询条件-->
    <div class="easyui-panel">
        内部单号：
        <input class="easyui-validatebox textbox" id="dlg_InvoiceInfo_orderNumber">
        <a href="javascript:void(0)" onclick="bindInvoiceInfo()" class="easyui-linkbutton"
           data-options="iconCls:'icon-search'"
           style="width: 80px">查 询</a>
    </div>
    <table id="dg_InvoiceInfo" style="width: 100%; height: auto">
    </table>
</div>

<div id="cover">
    <div id="coverMsg">
        <img src="${pageContext.request.contextPath }/static/img/loading.gif" width="100px">
    </div>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        bindShop();
        bindData();
    });

    function bindShop() {
        $('#s_shopId').combobox({
            valueField: 'shopId',
            textField: 'shopName',
            url: "${pageContext.request.contextPath }/shop/userShopComboboxlist",//获取数据
        });
    }

    function showDialogImportFbaPackingList() {
        $('#dlg_importFbaPackingList').dialog('open').dialog('setTitle', 'fba装箱单导入');
    }

    function closeDialogImportFbaPackingList() {
        $('#dlg_importFbaPackingList').dialog('close');
    }

    function closeDialog() {
        $('#dlg').dialog('close');
    }

    function importFbaPackingList() {
        var importFbaPackingListFile = $("#importFbaPackingListFile").val();
        if (importFbaPackingListFile == '') {
            $.messager.alert("提示", "请选择导入的文件");
            return;
        }
        var dom = document.getElementById("importFbaPackingListFile");
        var fileSize = dom.files[0].size;
        if (fileSize > 30000000) {
            $.messager.alert("提示", "上传文件过大,请上传小于30M的文件");
            return false;
        }
        $('#frm_importFbaPackingList').form('submit', {
            url: '${pageContext.request.contextPath }/fbaPackingList/importFbaPackingList',
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
                    $.messager.alert("提示", "上传成功");
                    bindData();
                }
                else {
                    $.messager.alert("提示", res.message);
                }
            }
        });
    }

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/fbaPackingList/listFbaPackingList";
        title = "fba装箱单管理";
        queryParams = {
            shopId: $("#s_shopId").combobox('getValue'),
            shopSku: $("#s_shopSku").val(),
            sku: $("#s_sku").val(),
            shipmentId: $("#s_shipmentId").val()
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
                {title: '店铺名', field: 'shopName', width: 120},
                {title: 'Shipment ID', field: 'shipmentId', width: 140},
                {title: 'Name', field: 'name', width: 160},
                {title: 'Plan ID', field: 'planId', width: 160},
                {title: 'Total SKUs', field: 'totalSkus', width: 80},
                {title: 'Total Units', field: 'totalUnits', width: 140},
                {title: 'Pack list', field: 'packList', width: 120},
                {title: 'Ship To', field: 'shipTo', width: 120},
                {
                    title: '店铺sku信息', field: 'shopSkuInfo', width: 100,
                    formatter: function (value, row, index) {
                        return '<a href="javascript:;" onclick="showShopSkuInfo(\'' + row.id + '\')" title="店铺sku信息">店铺sku信息</a>';
                    }
                },
                {
                    title: '发票管理', field: 'deal', width: 100,
                    formatter: function (value, row, index) {
                        return '<a href="javascript:;" onclick="showInvoiceInfo(\'' + row.id + '\')" title="发票管理">发票管理</a>';
                    }
                },
                {
                    title: '生成出库单', field: 'outboundOrderStatus', width: 100,
                    formatter: function (value, row, index) {
                        if (value == 1) {
                            return '已生成出库单';
                        } else {
                            return '<a href="javascript:;" onclick="generateOutboundOrder(\'' + row.id + '\')" title="生成出库单">生成出库单</a>';
                        }
                    }
                },
                {title: '创建时间', field: 'createTime', width: 180},
                {title: '修改时间', field: 'updateTime', width: 180},
                {title: '备注', field: 'remark', width: 120}
            ]],
            toolbar: [{
                id: 'btnView',
                text: '查看',
                iconCls: 'icon-search',
                handler: function () {
                    showViewDialog();//实现查看记录详细信息的方法
                }
            }, '-', {
                id: 'btnReload',
                text: '刷新',
                iconCls: 'icon-reload',
                handler: function () {
                    //实现刷新栏目中的数据
                    $(dg).datagrid("reload");
                }
            }],
            onDblClickRow: function (rowIndex, rowData) {
                $(dg).datagrid('uncheckAll');
                $(dg).datagrid('checkRow', rowIndex);
                showViewDialog();
            }
        })
        $(dg).datagrid('clearSelections');
    }

    function showViewDialog() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $('#dlg').dialog('open').dialog('setTitle', '查看');
            $('#frm').form('load', rows[0]);
            $(".view_hide").show();
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function showShopSkuInfo(id) {
        $('#dlgShopSku').dialog('open').dialog('setTitle', 'fba装箱单店铺sku信息');
        $('#dlgShopSku_fbaPackingListId').val(id);
        $('#dlgShopSku_shopSku').val(null);
        bindShopSku();
    }

    function bindShopSku() {
        dg = '#dgShopSku';
        url = "${pageContext.request.contextPath }/fbaPackingListShopSku/listFbaPackingListShopSku";
        title = "fba装箱单店铺sku管理";
        queryParams = {
            fbaPackingListId: $('#dlgShopSku_fbaPackingListId').val(),
            shopSku: $('#dlgShopSku_shopSku').val(),
            sku: $('#dlgShopSku_sku').val()
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
                {title: '店铺sku', field: 'shopSku', width: 160},
                {title: '产品sku', field: 'sku', width: 160},
                {title: 'FBA Shipment ID', field: 'fbaShipmentId', width: 180},
                {title: '数量', field: 'quantity', width: 80},
                {title: '创建时间', field: 'createTime', width: 180},
                {title: '修改时间', field: 'updateTime', width: 180}
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

    function showInvoiceInfo(id) {
        $('#dlg_InvoiceInfo').dialog('open').dialog('setTitle', 'fba装箱单发票信息');
        $('#dlg_InvoiceInfo_fbaPackingListId').val(id);
        $('#dlg_InvoiceInfo_orderNumber').val(null);
        bindInvoiceInfo();
    }

    function generateOutboundOrder(id) {
        $.post('${pageContext.request.contextPath }/fbaPackingList/generateOutboundOrder', {id: id}, function (data) {
            if (data.code == '200') {
                $.messager.alert("提示", "生成成功");
                bindData();
            } else {
                $.messager.alert("提示", data.message);
            }

        });
    }

    function bindInvoiceInfo() {
        dg = '#dg_InvoiceInfo';
        url = "${pageContext.request.contextPath }/fbaPackingList/listInvoiceInfo";
        title = "fba装箱单发票管理";
        queryParams = {
            fbaPackingListId: $('#dlg_InvoiceInfo_fbaPackingListId').val(),
            orderNumber: $('#dlg_InvoiceInfo_orderNumber').val()
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
                {title: '内部单号', field: 'orderNumber', width: 130},
                {title: '物流渠道', field: 'transportTypeName', width: 120},
                {title: '箱数', field: 'fbaShipmentIdCount', width: 40},
                {title: 'sku数量', field: 'shopSkuCount', width: 50},
                {title: '商品数量', field: 'shopSkuQuantity', width: 50},
                {
                    title: '操作', field: 'deal', width: 500,
                    formatter: function (value, row, index) {
                        return '<a href="javascript:;" onclick="downInvoice(\'' + row.fbaPackingListId + '\',\'' + row.orderNumber + '\',\'ky\')" title="生成空运发票">生成空运发票</a>'
                            + '&nbsp;&nbsp;<a href="javascript:;" onclick="downInvoice(\'' + row.fbaPackingListId + '\',\'' + row.orderNumber + '\',\'kp\')" title="生成空派发票">生成空派发票</a>'
                            + '&nbsp;&nbsp;<a href="javascript:;" onclick="downInvoice(\'' + row.fbaPackingListId + '\',\'' + row.orderNumber + '\',\'hy\')" title="生成海运发票">生成海运发票</a>'
                            + '&nbsp;&nbsp;<a href="javascript:;" onclick="downInvoice(\'' + row.fbaPackingListId + '\',\'' + row.orderNumber + '\',\'hy2\')" title="生成新的海运发票">生成新的海运发票</a>'
                            + '&nbsp;&nbsp;<a href="javascript:;" onclick="downInvoice(\'' + row.fbaPackingListId + '\',\'' + row.orderNumber + '\',\'dl\')" title="生成DL海运发票">生成DL海运发票</a>';
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

    function downInvoice(fbaPackingListId, orderNumber, type) {
        var url = '${pageContext.request.contextPath }/fbaPackingList/downInvoice?fbaPackingListId=' + fbaPackingListId + "&orderNumber=" + orderNumber + "&type=" + type;
        window.open(url);
    }
</script>
</html>
