<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2020/8/28
  Time: 16:54
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
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/common/selectShopSkuFromTo.js"></script>
    <title>调拨单</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    <!--只显示用户有的店铺-->
    调出店铺：
    <select class="easyui-combobox" id="s_shopIdFrom" style="width:150px;">
    </select>
    调入店铺：
    <select class="easyui-combobox" id="s_shopIdTo" style="width:150px;">
    </select>
    创建时间：
    <input class="easyui-datebox" id="s_createTimeStart">
    -
    <input class="easyui-datebox" id="s_createTimeEnd">
    调拨时间：
    <input class="easyui-datebox" id="s_transferTimeStart">
    -
    <input class="easyui-datebox" id="s_transferTimeEnd">
    批号：
    <input class="easyui-validatebox textbox" id="s_batchNumber">
    产品sku：
    <input class="easyui-validatebox textbox" id="s_sku">
    调出店铺sku：
    <input class="easyui-validatebox textbox" id="s_shopSkuFrom">
    调入店铺sku：
    <input class="easyui-validatebox textbox" id="s_shopSkuTo">
    状态：
    <select class="easyui-combobox" id="s_status" style="width:100px;">
        <option value="">全部</option>
        <option value="1">待调拨</option>
        <option value="2">已调拨</option>
        <option value="0">取消</option>
    </select>
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
</div>
<!--调拨单列表-->
<table id="dg" style="width: 100%; height: auto">

</table>

<!--调拨单编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 700px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true,top:50, align:'center'">
    <div class="ftitle">
        <b>调拨单</b>
        <hr/>
    </div>
    <form id="frm" method="post" novalidate="novalidate">
        <table>
            <tr style="display: none">
                <td>调拨单Id：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="id">
                </td>
            </tr>
            <tr>
                <td>调出店铺：</td>
                <td>
                    <select id="shopIdFrom" name="shopIdFrom" style="width: 90%" data-options="required:true">
                    </select>
                </td>
                <td>调入店铺：</td>
                <td>
                    <select id="shopIdTo" name="shopIdTo" style="width: 90%" data-options="required:true">
                    </select>
                </td>
            </tr>
            <tr class="view_status">
                <td>批号：</td>
                <td>
                    <input class="easyui-textbox" type="text" data-options="disabled:true" name="batchNumber">
                </td>
                <td>状态：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="statusName" data-options="disabled:true">
                </td>
            </tr>
            <tr class="view_status">
                <td>调拨时间：</td>
                <td>
                    <input class="easyui-textbox" type="text" data-options="disabled:true" name="transferTime">
                </td>
            </tr>
            <tr>
                <td>备注：</td>
                <td colspan="3">
                    <input class="easyui-textbox" type="text" name="remark" style="width: 90%">
                </td>
            </tr>
            <tr class="view_hide">
                <td>创建时间：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="createTime" data-options="disabled:true"></td>

                <td>更新时间：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="updateTime" data-options="disabled:true"></td>
            </tr>
        </table>
        <div style="text-align:center;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" id="btn_save" onclick="save()">确定</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-cancel'" onclick="closeDialog()">关闭</a>
        </div>
    </form>
</div>


<!--编辑页面调拨单店铺sku页面-->
<div id="dlgTransferOrderShopSku" class="easyui-dialog" style="width: 900px; height: 600px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:50,align:'center'">
    <div class="ftitle">
        <b>调拨单店铺sku管理</b>
        <hr/>
    </div>
    <form id="frmTransferOrderShopSku" method="post" novalidate="novalidate">
        <table>
            <tr>
                <td>调出店铺名：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="shopNameFrom" data-options="disabled:true">
                </td>
                <td>调入店铺名：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="shopNameTo" data-options="disabled:true">
                </td>
                <td>批号：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="batchNumber" data-options="disabled:true">
                </td>
                <td>状态：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="statusName" data-options="disabled:true">
                </td>
            </tr>
            <tr>
                <td>产品sku：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="dlgTransferOrderShopSku_sku"></td>
                <td>调出店铺sku：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="dlgTransferOrderShopSku_shopSkuFrom"></td>
                <td>调入店铺sku：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="dlgTransferOrderShopSku_shopSkuTo"></td>
            </tr>
        </table>
        <a href="javascript:void(0)" onclick="bindTransferOrderShopSkuData()" class="easyui-linkbutton"
           data-options="iconCls:'icon-search'"
           style="width: 80px">查 询</a>
    </form>
    <table id="dgTransferOrderShopSku" style="width: 100%; height: auto">

    </table>

    <!--编辑页面-->
    <div id="dlgTransferOrderShopSkuInfo" class="easyui-dialog" style="width: 700px; height: 500px; padding: 10px 20px"
         data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', top:50,align:'center'">
        <div class="ftitle">
            <b>调拨单店铺sku管理</b>
            <hr/>
        </div>
        <form id="frmTransferOrderShopSkuInfo" method="post" novalidate="novalidate">
            <table>
                <tr style="display: none">
                    <td>调拨单id：</td>
                    <td>
                        <input class="easyui-validatebox textbox" name="transferOrderId">
                    </td>
                    <td>调拨单店铺skuid：</td>
                    <td>
                        <input class="easyui-validatebox textbox" name="id">
                    </td>
                </tr>
                <tr>
                    <td>调出店铺sku：</td>
                    <td colspan="3">
                        <input class="easyui-validatebox textbox" name="shopSkuFrom" id="info_shopSkuFrom" >
                        <a href="javascript:void(0)" onclick="showShopSkuDialogFrom()" class="easyui-linkbutton"
                           data-options="iconCls:'icon-search'"
                           style="width: 80px">选择</a>
                    </td>
                </tr>
                <tr>
                    <td>调入店铺sku：</td>
                    <td colspan="3">
                        <input class="easyui-validatebox textbox" name="shopSkuTo" id="info_shopSkuTo" >
                        <a href="javascript:void(0)" onclick="showShopSkuDialogTo()" class="easyui-linkbutton"
                           data-options="iconCls:'icon-search'"
                           style="width: 80px">选择</a>
                    </td>
                </tr>
                <tr>

                    <td>调拨数量：</td>
                    <td>
                        <input class="easyui-numberbox" name="transferQuantity" data-options="min:1,precision:0">
                    </td>
                </tr>
                <tr>
                    <td>备注：</td>
                    <td colspan="3">
                        <input class="easyui-textbox" type="text" name="remark" style="width: 90%">
                    </td>
                </tr>
                <tr class="view_hide_transferOrderShopSku">
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
                   data-options="iconCls:'icon-ok'" id="btn_save_transferOrderShopSku"
                   onclick="saveTransferOrderShopSku()">确定</a>
                <a href="javascript:void(0)" class="easyui-linkbutton"
                   data-options="iconCls:'icon-cancel'" onclick="closeTransferOrderShopSkuInfoDialog()">关闭</a>
            </div>
        </form>
    </div>
    <div id="dlgImportTransferOrderShopSku" class="easyui-dialog"
         style="width: 700px; height: 500px; padding: 10px 20px"
         data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:50, align:'center'">
        <div class="ftitle">
            <b>调拨单店铺sku导入</b>
            <hr/>
            模板下载：
            <a href="${pageContext.request.contextPath }/static/template/transferOrder/transferOrderShopSkuImportTemplate.xlsx?20201015"
               target="_blank">模板下载</a>
        </div>
        <form id="frm_importTransferOrderShopSku" method="post" novalidate="novalidate" enctype="multipart/form-data">
            <input type="file" id="importTransferOrderShopSkuFile" name="file" accept=".xls,.xlsx"/>
            <input type="hidden" id="transferOrderId" name="transferOrderId">
            <div style="text-align:center;">
                <a href="javascript:void(0)" class="easyui-linkbutton"
                   data-options="iconCls:'icon-ok'" onclick="importTransferOrderShopSku()">导入</a>
                <a href="javascript:void(0)" class="easyui-linkbutton"
                   data-options="iconCls:'icon-cancel'" onclick="closeDlgImportTransferOrderShopSku()">关闭</a>
            </div>
        </form>
    </div>
    <div id="dlgShopSkuFrom" class="easyui-dialog" style="width: 660px; height: 600px; padding: 10px 20px"
         data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:50,align:'center'">
        <div class="ftitle">
            <b>店铺sku</b>
            <hr/>
        </div>
        <!--查询条件-->
        <div class="easyui-panel">
            店铺：
            <input class="easyui-validatebox textbox" id="s_dlgShopSkuFrom_shopName" data-options="disable:true">
            <input type="hidden" id="s_dlgShopSkuFrom_shopId">
            店铺sku：
            <input class="easyui-validatebox textbox" id="s_dlgShopSkuFrom_shopSku">
            产品sku：
            <input class="easyui-validatebox textbox" id="s_dlgShopSkuFrom_sku_id">
            <a href="javascript:void(0)" onclick="bindShopSkuFrom()" class="easyui-linkbutton"
               data-options="iconCls:'icon-search'"
               style="width: 80px">查 询</a>
        </div>
        <table id="dgShopSkuFrom" style="width: 100%; height: auto">

        </table>
    </div>
    <div id="dlgShopSkuTo" class="easyui-dialog" style="width: 660px; height: 600px; padding: 10px 20px"
         data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:50,align:'center'">
        <div class="ftitle">
            <b>店铺sku</b>
            <hr/>
        </div>
        <!--查询条件-->
        <div class="easyui-panel">
            店铺：
            <input class="easyui-validatebox textbox" id="s_dlgShopSkuTo_shopName" data-options="disable:true">
            <input type="hidden" id="s_dlgShopSkuTo_shopId">
            店铺sku：
            <input class="easyui-validatebox textbox" id="s_dlgShopSkuTo_shopSku">
            产品sku：
            <input class="easyui-validatebox textbox" id="s_dlgShopSkuTo_sku_id">
            <a href="javascript:void(0)" onclick="bindShopSkuTo()" class="easyui-linkbutton"
               data-options="iconCls:'icon-search'"
               style="width: 80px">查 询</a>
        </div>
        <table id="dgShopSkuTo" style="width: 100%; height: auto">

        </table>
    </div>
    <div id="cover">
        <div id="coverMsg">
            <img src="${pageContext.request.contextPath }/static/img/loading.gif" width="100px">
        </div>
    </div>

</div>

</body>
<script type="text/javascript">
    init();

    function init() {
        bindShop();
    }

    function bindShop() {
        $.post('${pageContext.request.contextPath }/shop/comboboxlist', {}, function (data) {
            $('#s_shopIdFrom').combobox({
                data: data,
                valueField: 'shopId',
                textField: 'shopName'
            });
            $('#s_shopIdTo').combobox({
                data: data,
                valueField: 'shopId',
                textField: 'shopName'
            });
            $('#shopIdFrom').combobox({
                data: data,
                valueField: 'shopId',
                textField: 'shopName'
            });
            $('#shopIdTo').combobox({
                data: data,
                valueField: 'shopId',
                textField: 'shopName'
            });
            bindData();
        });
    }

    function getQueryParams() {
        queryParams = {
            shopIdFrom: $('#s_shopIdFrom').combobox('getValue'),
            shopIdTo: $('#s_shopIdTo').combobox('getValue'),
            createTimeStart: $("#s_createTimeStart").val(),
            createTimeEnd: $("#s_createTimeEnd").val(),
            transferTimeStart: $("#s_transferTimeStart").val(),
            transferTimeEnd: $("#s_transferTimeEnd").val(),
            batchNumber: $("#s_batchNumber").val(),
            sku: $("#s_sku").val(),
            shopSkuFrom: $("#s_shopSkuFrom").val(),
            shopSkuTo: $("#s_shopSkuTo").val(),
            status: $("#s_status").val()
        };
        return queryParams;
    }

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/transferOrder/listTransferOrder";
        title = "调拨单管理";
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
                    {field: 'ck', transferbox: true},   //选择
                    {title: '调出店铺名', field: 'shopNameFrom', width: 120},
                    {title: '调入店铺', field: 'shopNameTo', width: 120},
                    {title: '调拨时间', field: 'transferTime', width: 140},
                    {title: '批号', field: 'batchNumber', width: 140},
                    {title: '状态', field: 'statusName', width: 50},
                    {title: '调拨数量', field: 'transferQuantityTotal', width: 66},
                    {title: '创建时间', field: 'createTime', width: 180},
                    {title: '修改时间', field: 'updateTime', width: 180},
                    {title: '备注', field: 'remark', width: 180},
                    {
                        title: '操作', field: 'deal', width: 200, formatter: function (value, row, index) {
                        var content = '<a href="javascript:void(0)" onclick="exportTransferOrderShopSkuById(' + row.id + ')" class="easyui-linkbutton" >导出店铺sku</a>';
                        if (row.status == 1) {
                            content += '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="showImportTransferOrderShopSkuById(' + row.id + ')" class="easyui-linkbutton" >导入店铺sku</a>';
                        }
                        return content;
                    }
                    }
                ]],
                toolbar: [{
                    id: 'btnView',
                    text: '查看',
                    iconCls: 'icon-search',
                    handler: function () {
                        showViewDialog();//实现查看记录详细信息的方法
                    }
                }, '-', {
                    id: 'btnAdd',
                    text: '添加',
                    iconCls: 'icon-add',
                    handler: function () {
                        showAddDialog();//实现查看记录详细信息的方法
                    }
                }, '-', {
                    id: 'btnEdit',
                    text: '修改',
                    iconCls: 'icon-edit',
                    handler: function () {
                        showEditDialog();//实现修改记录的方法
                    }
                }, '-', {
                    id: 'btnTransferOrderShopSku',
                    text: '调拨单店铺sku管理',
                    iconCls: 'icon-edit',
                    handler: function () {
                        showTransferOrderShopSkuDialog();
                    }
                }, '-', {
                    id: 'btnTransfer',
                    text: '调拨',
                    iconCls: 'icon-edit',
                    handler: function () {
                        transfer();
                    }
                }, '-', {
                    id: 'btnDelete',
                    text: '取消',
                    iconCls: 'icon-remove',
                    handler: function () {
                        cancelTransferOrder();
                    }
                }, '-', {
                    id: 'btnReload',
                    text: '刷新',
                    iconCls: 'icon-reload',
                    handler: function () {
                        //实现刷新栏目中的数据
                        $(dg).datagrid("reload");
                        $(dg).datagrid('uncheckAll');
                    }
                }],
                onDblClickRow:

                    function (rowIndex, rowData) {
                        $(dg).datagrid('uncheckAll');
                        $(dg).datagrid('checkRow', rowIndex);
                        showViewDialog();
                    }
            }
        )
        $(dg).datagrid('clearSelections');
        $(dg).datagrid('uncheckAll');
    }

    function showViewDialog() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $('#dlg').dialog('open').dialog('setTitle', '查看');
            $('#frm').form('load', rows[0]);
            $("#btn_save").hide();
            $(".view_status").show();
            $(".view_hide").show();
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function showAddDialog() {
        $('#dlg').dialog('open').dialog('setTitle', '添加');
        $('#frm').form('clear');
        $(".view_status").hide();
        $("#btn_save").show();
        $(".view_hide").hide();
    }

    function showEditDialog() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $('#dlg').dialog('open').dialog('setTitle', '修改');
            $('#frm').form('load', rows[0]);
            $(".view_status").show();
            $("#btn_save").show();
            $(".view_hide").hide();
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function closeDialog() {
        $('#dlg').dialog('close');
    }

    function save() {
        var shopIdFrom = $("div#dlg input[name='shopIdFrom']").val();
        if (shopIdFrom == '') {
            $.messager.alert("提示", '请选择调出店铺');
            return;
        }
        var shopIdTo = $("div#dlg input[name='shopIdTo']").val();
        if (shopIdTo == '') {
            $.messager.alert("提示", '请选择调入店铺');
            return;
        }
        $('#frm').form('submit', {
            url: '${pageContext.request.contextPath }/transferOrder/saveTransferOrder',
            onSubmit: function () {
                var validate = $(this).form('validate');
                return validate;
            },
            success: function (data) {
                res = eval('(' + data + ')');
                if (res.code == '200') {
                    closeDialog();
                    bindData();
                }
                else {
                    $.messager.alert("提示", res.message);
                }
            }
        });
    }

    function transfer() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            //添加二次确认
            $.messager.confirm('提示', '确认要设置店铺[' + rows[0].shopNameFrom + '],批号[' + rows[0].batchNumber + ']的调拨单为已调拨吗？', function (r) {
                if (r) {
                    transferById(rows[0].id);
                }
            });
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    //调拨
    function transferById(id) {
        $.post('${pageContext.request.contextPath }/transferOrder/transfer', {id: id}, function (data) {
            if (data.code == '200') {
                bindData();
            }
            else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function cancelTransferOrder() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $.messager.confirm('提示', '确认废除店铺[' + rows[0].shopNameFrom + '],批号[' + rows[0].batchNumber + ']的调拨单吗？', function (r) {
                if (r) {
                    $.post('${pageContext.request.contextPath }/transferOrder/cancelTransferOrder', {id: rows[0].id}, function (data) {
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

    function showTransferOrderShopSkuDialog() {
        var rows = $('#dg').datagrid('getSelections');
        if (!rows || rows.length != 1) {
            $.messager.alert("提示", "请选择一条记录.");
            return;
        }
        $('#dlgTransferOrderShopSku').dialog('open').dialog('setTitle', '调拨单店铺sku管理');
        $('#frmTransferOrderShopSku').form('load', rows[0]);
        $('#dlgTransferOrderShopSku_shopSku').textbox("setValue", "");
        $('#dlgTransferOrderShopSku_sku').textbox("setValue", "");
        bindTransferOrderShopSkuData();
    }

    function bindTransferOrderShopSkuData() {
        dg = '#dgTransferOrderShopSku';
        url = "${pageContext.request.contextPath }/transferOrderShopSku/listTransferOrderShopSku";
        title = "调拨单店铺sku管理";
        queryParams = {
            transferOrderId: $('#dg').datagrid('getSelections')[0].id,
            sku: $('#dlgTransferOrderShopSku_sku').val(),
            shopSkuFrom: $('#dlgTransferOrderShopSku_shopSkuFrom').val(),
            shopSkuTo: $('#dlgTransferOrderShopSku_shopSkuTo').val()
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
                {field: 'ck', transferBox: true},   //选择
                {title: '调出店铺名', field: 'shopNameFrom', width: 120},
                {title: '调入店铺名', field: 'shopNameTo', width: 120},
                {title: '产品sku', field: 'sku', width: 140},
                {title: '调出店铺sku', field: 'shopSkuFrom', width: 140},
                {title: '调入店铺sku', field: 'shopSkuTo', width: 140},
                {title: '库存', field: 'inventoryQuantity', width: 38},
                {
                    title: '调拨数量', field: 'transferQuantity', width: 66,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-numberbox " min="1" precision="0" onchange="saveTransferQuantity(this,' + row.id + ')">';
                        } else {
                            return '<input class="easyui-numberbox" min="1" precision="0" value="' + value + '" onchange="saveTransferQuantity(this,' + row.id + ')">';
                        }
                    }
                },
                {title: '创建时间', field: 'createTime', width: 180},
                {title: '修改时间', field: 'updateTime', width: 180},
                {title: '备注', field: 'remark', width: 180}
            ]],
            toolbar: [{
                id: 'btnTransferOrderShopSkuView',
                text: '查看',
                iconCls: 'icon-search',
                handler: function () {
                    showViewTransferOrderShopSkuDialog();//实现查看记录详细信息的方法
                }
            }, '-', {
                id: 'btnTransferOrderShopSkuAdd',
                text: '添加',
                iconCls: 'icon-add',
                handler: function () {
                    showAddTransferOrderShopSkuDialog();//实现查看记录详细信息的方法
                }
            }, '-', {
                id: 'btnTransferOrderShopSkuEdit',
                text: '修改',
                iconCls: 'icon-edit',
                handler: function () {
                    showEditTransferOrderShopSkuDialog();//实现修改记录的方法
                }
            }, '-', {
                id: 'btnTransferOrderShopSkuDelete',
                text: '删除',
                iconCls: 'icon-remove',
                handler: function () {
                    deleteTransferOrderShopSku();//实现直接删除数据的方法
                }
            }, '-', {
                id: 'btnTransferOrderShopSkuReload',
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
                showViewTransferOrderShopSkuDialog();
            }
        })
        $(dg).datagrid('clearSelections');
        $(dg).datagrid('uncheckAll');
    }

    function showAddTransferOrderShopSkuDialog() {
        $('#dlgTransferOrderShopSkuInfo').dialog('open').dialog('setTitle', '添加调拨单店铺sku');
        $('#frmTransferOrderShopSkuInfo').form('clear');
        $("#btn_save_transferOrderShopSku").show();
        $(".view_hide_transferOrderShopSku").hide();
        $("div#dlgTransferOrderShopSkuInfo input[name='transferOrderId']").val($('#dg').datagrid('getSelections')[0].id);
    }

    function showEditTransferOrderShopSkuDialog() {
        var rows = $('#dgTransferOrderShopSku').datagrid('getSelections');
        if (!rows || rows.length != 1) {
            $.messager.alert("提示", "请选择一条记录.");
            return;
        }
        $('#dlgTransferOrderShopSkuInfo').dialog('open').dialog('setTitle', '编辑调拨单店铺sku');
        $('#frmTransferOrderShopSkuInfo').form('load', rows[0]);
        $("#btn_save_transferOrderShopSku").show();
        $(".view_hide_transferOrderShopSku").hide();
    }

    function showViewTransferOrderShopSkuDialog() {
        var rows = $('#dgTransferOrderShopSku').datagrid('getSelections');
        if (!rows || rows.length != 1) {
            $.messager.alert("提示", "请选择一条记录.");
            return;
        }
        $('#dlgTransferOrderShopSkuInfo').dialog('open').dialog('setTitle', '查看调拨单店铺sku');
        $('#frmTransferOrderShopSkuInfo').form('load', rows[0]);
        $("#btn_save_transferOrderShopSku").hide();
        $(".view_hide_transferOrderShopSku").show();
    }

    function saveTransferOrderShopSku() {
        var shopSkuFrom = $("div#dlgTransferOrderShopSkuInfo input[name='shopSkuFrom']").val();
        if (shopSkuFrom == '') {
            $.messager.alert("提示", '请选择调出店铺sku');
            return;
        }
        var shopSkuTo = $("div#dlgTransferOrderShopSkuInfo input[name='shopSkuTo']").val();
        if (shopSkuTo == '') {
            $.messager.alert("提示", '请选择调入店铺sku');
            return;
        }
        var transferQuantity = $("div#dlgTransferOrderShopSkuInfo input[name='transferQuantity']").val();
        if (transferQuantity == '') {
            $.messager.alert("提示", '请填写调拨数量');
            return;
        }
        $('#frmTransferOrderShopSkuInfo').form('submit', {
            url: '${pageContext.request.contextPath }/transferOrderShopSku/saveTransferOrderShopSku',
            onSubmit: function () {
                var validate = $(this).form('validate');
                return validate;
            },
            success: function (data) {
                res = eval('(' + data + ')');
                if (res.code == '200') {
                    closeTransferOrderShopSkuInfoDialog();
                    bindTransferOrderShopSkuData();
                }
                else {
                    $.messager.alert("提示", res.message);
                }
            }
        });
    }

    function deleteTransferOrderShopSku() {
        var rows = $('#dgTransferOrderShopSku').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $.messager.confirm('提示', '确认删除店铺[' + rows[0].shopNameFrom + '],店铺sku[' + rows[0].shopSkuFrom + ']的店铺sku吗？', function (r) {
                if (r) {
                    $.post('${pageContext.request.contextPath }/transferOrderShopSku/deleteTransferOrderShopSku', {id: rows[0].id}, function (data) {
                        if (data.code == '200') {
                            bindTransferOrderShopSkuData();
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

    function closeTransferOrderShopSkuInfoDialog() {
        $('#dlgTransferOrderShopSkuInfo').dialog('close')
    }

    function showImportTransferOrderShopSkuById(transferOrderId) {
        $('#dlgImportTransferOrderShopSku').dialog('open').dialog('setTitle', '导入调拨单店铺sku');
        $('#transferOrderId').val(transferOrderId);
    }

    function importTransferOrderShopSku() {
        var importTransferOrderShopSkuFile = $("#importTransferOrderShopSkuFile").val();
        if (importTransferOrderShopSkuFile == '') {
            $.messager.alert("提示", "请选择导入的文件");
            return;
        }
        var dom = document.getElementById("importTransferOrderShopSkuFile");
        var fileSize = dom.files[0].size;
        if (fileSize > 30000000) {
            $.messager.alert("提示", "上传文件过大,请上传小于30M的文件");
            return false;
        }
        $('#frm_importTransferOrderShopSku').form('submit', {
            url: '${pageContext.request.contextPath }/transferOrderShopSku/importTransferOrderShopSku',
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
                }
                else {
                    $.messager.alert("提示", res.message);
                }
            }
        });
    }

    function closeDlgImportTransferOrderShopSku(transferOrderId) {
        $('#dlgImportTransferOrderShopSku').dialog('close');
    }

    function exportTransferOrderShopSkuById(transferOrderId) {
        var url = "${pageContext.request.contextPath }/transferOrderShopSku/exportTransferOrderShopSku?transferOrderId=" + transferOrderId;
        window.open(url);
    }

    function saveTransferQuantity(input, id) {
        var transferQuantity = $(input).val();
        if (isEmpty(transferQuantity)) {
            $.messager.alert("提示", "调拨数量不能为空");
            return;
        }
        var r = /^[1-9][0-9]*$/;　　//正整数
        if (!r.test(transferQuantity)) {
            $.messager.alert("提示", "调拨数量必须为大于等于1的数字.");
            $(input).focus();
            return;
        }
        $.post('${pageContext.request.contextPath }/transferOrderShopSku/saveTransferQuantity', {
            transferQuantity: transferQuantity,
            id: id
        }, function (data) {
            if (data.code == '200') {
                //保存成功
                $.messager.alert("提示", data.message);
            }
            else {
                $.messager.alert("提示", data.message);
            }
        });
    }
</script>
</html>
