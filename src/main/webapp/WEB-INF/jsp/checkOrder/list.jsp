<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2020/5/9
  Time: 11:23
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
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/common/selectShopSku.js"></script>
    <title>盘点单</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    <!--只显示用户有的店铺-->
    店铺：
    <select class="easyui-combobox" id="s_shopId" style="width:150px;">
    </select>
    盘点时间：
    <input class="easyui-datebox" id="s_checkTimeStart">
    -
    <input class="easyui-datebox" id="s_checkTimeEnd">
    批号：
    <input class="easyui-validatebox textbox" id="s_batchNumber">
    店铺sku：
    <input class="easyui-validatebox textbox" id="s_shopSku">
    产品sku：
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
<!--盘点单列表-->
<table id="dg" style="width: 100%; height: auto">

</table>
<!--盘点单编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 700px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true,top:50, align:'center'">
    <div class="ftitle">
        <b>盘点单</b>
        <hr/>
    </div>
    <form id="frm" method="post" novalidate="novalidate">
        <table>
            <tr style="display: none">
                <td>盘点单id：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="id">
                </td>
            </tr>
            <tr>
                <td>店铺名：</td>
                <td colspan="3">
                    <select id="shopId" name="shopId" style="width: 90%" data-options="required:true">
                    </select>
                </td>
            </tr>
            <tr class="view_status">
                <td>批号：</td>
                <td>
                    <input class="easyui-textbox" type="text" readonly="readonly" name="batchNumber">
                </td>
                <td>状态：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="statusName" readonly="readonly">
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
                    <input class="easyui-validatebox textbox" name="createTime"></td>

                <td>更新时间：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="updateTime"></td>
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


<!--编辑页面盘点单店铺sku页面-->
<div id="dlgCheckOrderShopSku" class="easyui-dialog" style="width: 800px; height: 600px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:50, align:'center'">
    <div class="ftitle">
        <b>盘点单店铺sku管理</b>
        <hr/>
    </div>
    <form id="frmCheckOrderShopSku" method="post" novalidate="novalidate">
        <table>
            <tr>
                <td>店铺名：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="shopName" readonly="readonly">
                </td>
                <td>批号：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="batchNumber" readonly="readonly">
                </td>
                <td>状态：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="statusName" readonly="readonly">
                </td>
            </tr>
        </table>
        <a href="javascript:void(0)" onclick="bindCheckOrderShopSkuData()" class="easyui-linkbutton"
           data-options="iconCls:'icon-search'"
           style="width: 80px">查 询</a>
    </form>
    <table id="dgCheckOrderShopSku" style="width: 100%; height: auto">

    </table>
</div>


<!--编辑页面-->
<div id="dlgCheckOrderShopSkuInfo" class="easyui-dialog" style="width: 700px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:50, align:'center'">
    <div class="ftitle">
        <b>盘点单店铺sku管理</b>
        <hr/>
    </div>
    <form id="frmCheckOrderShopSkuInfo" method="post" novalidate="novalidate">
        <table>
            <tr style="display: none">
                <td>盘点单id：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="checkOrderId">
                </td>
                <td>盘点单店铺skuid：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="id">
                </td>
            </tr>
            <tr>
                <td>店铺sku：</td>
                <td colspan="3">
                    <input class="easyui-validatebox textbox" name="shopSku" id="info_shopSkuId">
                    <a href="javascript:void(0)" onclick="showShopSkuDialog()" class="easyui-linkbutton"
                       data-options="iconCls:'icon-search'"
                       style="width: 80px">选择</a>
                </td>
            </tr>
            <tr>

                <td>最新库存数量：</td>
                <td>
                    <input class="easyui-numberbox" name="inventoryQuantityNew" data-options="min:1,precision:0">
                </td>
            </tr>
            <tr>
                <td>备注：</td>
                <td colspan="3">
                    <input class="easyui-textbox" type="text" name="remark" style="width: 90%">
                </td>
            </tr>
            <tr class="view_hide_checkOrderShopSku">
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
               data-options="iconCls:'icon-ok'" id="btn_save_checkOrderShopSku"
               onclick="saveCheckOrderShopSku()">确定</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-cancel'" onclick="closeCheckOrderShopSkuInfoDialog()">关闭</a>
        </div>
    </form>
</div>
<div id="dlgImportCheckOrderShopSku" class="easyui-dialog" style="width: 700px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:50, align:'center'">
    <div class="ftitle">
        <b>盘点单店铺sku导入</b>
        <hr/>
        模板下载：
        <a href="${pageContext.request.contextPath }/static/template/checkOrder/checkOrderShopSkuImportTemplate.xlsx"
           target="_blank">模板下载</a>
    </div>
    <form id="frm_importCheckOrderShopSku" method="post" novalidate="novalidate" enctype="multipart/form-data">
        <input type="file" id="importCheckOrderShopSkuFile" name="file" accept=".xls,.xlsx"/>
        <input type="hidden" id="checkOrderId" name="checkOrderId">
        <div style="text-align:center;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" onclick="importCheckOrderShopSku()">导入</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-cancel'" onclick="closeDlgImportCheckOrderShopSku()">关闭</a>
        </div>
    </form>
</div>


<div id="dlgShopSku" class="easyui-dialog" style="width: 660px; height: 600px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:50,align:'center'">
    <div class="ftitle">
        <b>店铺sku</b>
        <hr/>
    </div>
    <!--查询条件-->
    <div class="easyui-panel">
        店铺：
        <input class="easyui-validatebox textbox" id="s_dlgShopSku_shopName" readonly="readonly">
        <input type="hidden" id="s_dlgShopSku_shopId">
        店铺sku：
        <input class="easyui-validatebox textbox" id="s_dlgShopSku_shopSku">
        <a href="javascript:void(0)" onclick="bindShopSku()" class="easyui-linkbutton"
           data-options="iconCls:'icon-search'"
           style="width: 80px">查 询</a>
    </div>
    <table id="dgShopSku" style="width: 100%; height: auto">

    </table>
</div>

<div id="dlgCheckOrderShopSkuStorageLocation" class="easyui-dialog"
     style="width: 850px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', top:50,align:'center'">
    <input type="hidden" id="dlgCheckOrderShopSkuStorageLocation_checkOrderShopSkuId">
    <!--查询条件-->
    <div class="easyui-panel">
        <a href="javascript:void(0)" onclick="bindCheckOrderShopSkuStorageLocation()" class="easyui-linkbutton"
           data-options="iconCls:'icon-search'"
           style="width: 80px">查 询</a>
    </div>
    <table id="dgCheckOrderShopSkuStorageLocation" style="width: 100%; height: auto">
    </table>
</div>
<div id="dlgCheckOrderShopSkuStorageLocationInfo" class="easyui-dialog"
     style="width: 700px; height: 560px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:50,align:'center'">
    <div class="ftitle">
        <b>库位管理</b>
        <hr/>
    </div>
    <form id="frmCheckOrderShopSkuStorageLocationInfo" method="post" novalidate="novalidate">
        <table>
            <tr style="display: none">
                <td>checkOrderShopSkuId：</td>
                <td>
                    <input class="easyui-validatebox textbox"
                           id="frmCheckOrderShopSkuStorageLocationInfo_checkOrderShopSkuId"
                           name="checkOrderShopSkuId">
                    <input class="easyui-validatebox textbox" name="id">
                </td>
            </tr>
            <tr style="display: none">
                <td>仓库名：</td>
                <td>
                    <select id="s_CheckOrderShopSkuStorageLocationInfo_shopId" style="width:150px;" name="shopId">
                    </select>
                </td>
            </tr>
            <tr>
                <td>库位：</td>
                <td>
                    <select id="s_CheckOrderShopSkuStorageLocationInfo_storageLocationId" style="width:150px;"
                            name="storageLocationId">
                    </select>
                </td>
            </tr>
            <tr>
                <td>备注：</td>
                <td colspan="3">
                    <input class="easyui-textbox" type="text" name="remark" style="width: 90%">
                </td>
            </tr>
        </table>
        <div style="text-align:center;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" id="btn_saveCheckOrderShopSkuStorageLocation"
               onclick="saveCheckOrderShopSkuStorageLocation()">确定</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-cancel'" onclick="closeCheckOrderShopSkuStorageLocationInfo()">关闭</a>
        </div>
    </form>
</div>
<div id="cover">
    <div id="coverMsg">
        <img src="${pageContext.request.contextPath }/static/img/loading.gif" width="100px">
    </div>
</div>
</body>

<script type="text/javascript">
    // 初始化内容
    $(document).ready(function () {
        bindStorageLocation();
        bindShop();
    });

    function bindStorageLocation() {
        $('#s_CheckOrderShopSkuStorageLocationInfo_storageLocationId').combobox({
            valueField: 'id',
            textField: 'locationNo',
            url: "${pageContext.request.contextPath }/storageLocation/comboboxlist",//获取数据
        });
    }

    function bindShop() {
        $.post('${pageContext.request.contextPath }/shop/comboboxlist', {}, function (data) {
            $('#s_shopId').combobox({
                data: data,
                valueField: 'shopId',
                textField: 'shopName'
            });
            $('#shopId').combobox({
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
            checkTimeStart: $("#s_checkTimeStart").val(),
            checkTimeEnd: $("#s_checkTimeEnd").val(),
            batchNumber: $("#s_batchNumber").val(),
            shopSku: $("#s_shopSku").val(),
            sku: $("#s_sku").val(),
            status: $("#s_status").val()
        };
        return queryParams;
    }

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/checkOrder/listCheckOrder";
        title = "盘点单管理";
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
                    {
                        title: '盘点时间', field: 'checkTime', width: 140, formatter: function (value, row, index) {
                        if (!isEmpty(value)) {
                            return value.substring(0, 10);
                        }
                    }
                    },
                    {title: '批号', field: 'batchNumber', width: 140},
                    {title: '状态', field: 'statusName', width: 50},
                    {title: '最新库存数量', field: 'inventoryQuantityNewTotal', width: 66},
                    {title: '创建时间', field: 'createTime', width: 180},
                    {title: '修改时间', field: 'updateTime', width: 180},
                    {title: '备注', field: 'remark', width: 180},
                    {
                        title: '操作', field: 'deal', width: 200, formatter: function (value, row, index) {
                        var content = '<a href="javascript:void(0)" onclick="exportCheckOrderShopSkuById(' + row.id + ')" class="easyui-linkbutton" >导出店铺sku</a>';
                        if (row.status == 1) {
                            content += '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="showImportCheckOrderShopSkuById(' + row.id + ')" class="easyui-linkbutton" >导入店铺sku</a>';
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
                    id: 'btnCheckOrderShopSku',
                    text: '盘点单店铺sku管理',
                    iconCls: 'icon-edit',
                    handler: function () {
                        showCheckOrderShopSkuDialog();
                    }
                }, '-', {
                    id: 'btnCheck',
                    text: '确认',
                    iconCls: 'icon-edit',
                    handler: function () {
                        confirmCheckOrder();
                    }
                }, '-', {
                    id: 'btnDelete',
                    text: '取消',
                    iconCls: 'icon-remove',
                    handler: function () {
                        cancelCheckOrder();
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
                onDblClickRow:
                    function (rowIndex, rowData) {
                        $(dg).datagrid('uncheckAll');
                        $(dg).datagrid('checkRow', rowIndex);
                        showViewDialog();
                    }
            }
        )
        $(dg).datagrid('clearSelections');
    }

    //确认
    function confirmCheckOrder() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
        //添加二次确认
            $.messager.confirm('提示', '确认要设置店铺[' + rows[0].shopName + '],批号[' + rows[0].batchNumber + ']的盘点单为已确认吗？', function (r) {
                if (r) {
                    confirmCheckOrderById(rows[0].id);
                }
            });
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }
    //确认
    function confirmCheckOrderById(id) {
        $.post('${pageContext.request.contextPath }/checkOrder/confirmCheckOrder', {id: id}, function (data) {
            if (data.code == '200') {
                bindData();
            }
            else {
                $.messager.alert("提示", data.message);
            }
        });
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
        var shopId = $("div#dlg input[name='shopId']").val();
        if (shopId == '') {
            $.messager.alert("提示", '请选择店铺');
            return;
        }
        $('#frm').form('submit', {
            url: '${pageContext.request.contextPath }/checkOrder/saveCheckOrder',
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

    function cancelCheckOrder() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $.messager.confirm('提示', '确认废除店铺[' + rows[0].shopName + '],批号[' + rows[0].batchNumber + ']的盘点单吗？', function (r) {
                if (r) {
                    $.post('${pageContext.request.contextPath }/checkOrder/cancelCheckOrder', {id: rows[0].id}, function (data) {
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

    function showCheckOrderShopSkuDialog() {
        var rows = $('#dg').datagrid('getSelections');
        if (!rows || rows.length != 1) {
            $.messager.alert("提示", "请选择一条记录.");
            return;
        }
        $('#dlgCheckOrderShopSku').dialog('open').dialog('setTitle', '盘点单店铺sku管理');
        $('#frmCheckOrderShopSku').form('load', rows[0]);
        bindCheckOrderShopSkuData();
    }


    function bindCheckOrderShopSkuData() {
        dg = '#dgCheckOrderShopSku';
        url = "${pageContext.request.contextPath }/checkOrderShopSku/listCheckOrderShopSku";
        title = "盘点单店铺sku管理";
        queryParams = {checkOrderId: $('#dg').datagrid('getSelections')[0].id};
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
                {field: 'ck', checkbox: true},   //选择
                {title: '店铺名', field: 'shopName', width: 120},
                {title: '产品sku', field: 'sku', width: 140},
                {title: '店铺sku', field: 'shopSku', width: 140},
                {
                    title: '最新库存数量', field: 'inventoryQuantityNew', width: 66,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-numberbox " min="1" precision="0" onchange="saveInventoryQuantityNew(this,' + row.id + ')">';
                        } else {
                            return '<input class="easyui-numberbox" min="1" precision="0" value="' + value + '" onchange="saveInventoryQuantityNew(this,' + row.id + ')">';
                        }
                    }
                },
                {
                    title: '库位',
                    field: 'locationNos',
                    width: 120,
                    formatter: function (value, row, index) {
                        if (isEmpty(value)) {
                            value = '暂无库位';
                        }
                        return "<a href='#' onclick=\"showDlgCheckOrderShopSkuStorageLocation(" + row.id + ")\" title='" + value + "' >" + value + "</a>";
                    }
                },
                {title: '创建时间', field: 'createTime', width: 180},
                {title: '修改时间', field: 'updateTime', width: 180},
                {title: '备注', field: 'remark', width: 180}
            ]],
            toolbar: [{
                id: 'btnCheckOrderShopSkuView',
                text: '查看',
                iconCls: 'icon-search',
                handler: function () {
                    showViewCheckOrderShopSkuDialog();//实现查看记录详细信息的方法
                }
            }, '-', {
                id: 'btnAdd',
                text: '添加',
                iconCls: 'icon-add',
                handler: function () {
                    showAddCheckOrderShopSkuDialog();//实现查看记录详细信息的方法
                }
            }, '-', {
                id: 'btnEdit',
                text: '修改',
                iconCls: 'icon-edit',
                handler: function () {
                    showEditCheckOrderShopSkuDialog();//实现修改记录的方法
                }
            }, '-', {
                id: 'btnDelete',
                text: '删除',
                iconCls: 'icon-remove',
                handler: function () {
                    deleteCheckOrderShopSku();//实现直接删除数据的方法
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
                showViewCheckOrderShopSkuDialog();
            }
        })
        $(dg).datagrid('clearSelections');
    }

    function showAddCheckOrderShopSkuDialog() {
        $('#dlgCheckOrderShopSkuInfo').dialog('open').dialog('setTitle', '添加盘点单店铺sku');
        $('#frmCheckOrderShopSkuInfo').form('clear');
        $("#btn_save_checkOrderShopSku").show();
        $(".view_hide_checkOrderShopSku").hide();
        $("div#dlgCheckOrderShopSkuInfo input[name='checkOrderId']").val($('#dg').datagrid('getSelections')[0].id);
    }

    function showEditCheckOrderShopSkuDialog() {
        var rows = $('#dgCheckOrderShopSku').datagrid('getSelections');
        if (!rows || rows.length != 1) {
            $.messager.alert("提示", "请选择一条记录.");
            return;
        }
        $('#dlgCheckOrderShopSkuInfo').dialog('open').dialog('setTitle', '编辑盘点单店铺sku');
        $('#frmCheckOrderShopSkuInfo').form('load', rows[0]);
        $("#btn_save_checkOrderShopSku").show();
        $(".view_hide_checkOrderShopSku").hide();
    }

    function showViewCheckOrderShopSkuDialog() {
        var rows = $('#dgCheckOrderShopSku').datagrid('getSelections');
        if (!rows || rows.length != 1) {
            $.messager.alert("提示", "请选择一条记录.");
            return;
        }
        $('#dlgCheckOrderShopSkuInfo').dialog('open').dialog('setTitle', '查看盘点单店铺sku');
        $('#frmCheckOrderShopSkuInfo').form('load', rows[0]);
        $("#btn_save_checkOrderShopSku").hide();
        $(".view_hide_checkOrderShopSku").show();
    }

    function saveCheckOrderShopSku() {
        var shopSku = $("div#dlgCheckOrderShopSkuInfo input[name='shopSku']").val();
        if (shopSku == '') {
            $.messager.alert("提示", '请填写店铺sku');
            return;
        }
        var inventoryQuantityNew = $("div#dlgCheckOrderShopSkuInfo input[name='inventoryQuantityNew']").val();
        if (inventoryQuantityNew == '') {
            $.messager.alert("提示", '请填写最新库存数量');
            return;
        }
        $('#frmCheckOrderShopSkuInfo').form('submit', {
            url: '${pageContext.request.contextPath }/checkOrderShopSku/saveCheckOrderShopSku',
            onSubmit: function () {
                var validate = $(this).form('validate');
                return validate;
            },
            success: function (data) {
                res = eval('(' + data + ')');
                if (res.code == '200') {
                    closeCheckOrderShopSkuInfoDialog();
                    bindCheckOrderShopSkuData();
                }
                else {
                    $.messager.alert("提示", res.message);
                }
            }
        });
    }

    function deleteCheckOrderShopSku() {
        var rows = $('#dgCheckOrderShopSku').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $.messager.confirm('提示', '确认废除店铺[' + rows[0].shopName + '],店铺sku[' + rows[0].shopSku + ']的生产单店铺sku吗？', function (r) {
                if (r) {
                    $.post('${pageContext.request.contextPath }/checkOrderShopSku/deleteCheckOrderShopSku', {id: rows[0].id}, function (data) {
                        if (data.code == '200') {
                            bindCheckOrderShopSkuData();
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

    function closeCheckOrderShopSkuInfoDialog() {
        $('#dlgCheckOrderShopSkuInfo').dialog('close')
    }

    function showImportCheckOrderShopSkuById(checkOrderId){
        $('#dlgImportCheckOrderShopSku').dialog('open').dialog('setTitle', '导入盘点单店铺sku');
        $('#checkOrderId').val(checkOrderId);
    }
    function importCheckOrderShopSku() {
        var importCheckOrderShopSkuFile = $("#importCheckOrderShopSkuFile").val();
        if (importCheckOrderShopSkuFile == '') {
            $.messager.alert("提示", "请选择导入的文件");
            return;
        }
        var dom = document.getElementById("importCheckOrderShopSkuFile");
        var fileSize = dom.files[0].size;
        if (fileSize > 30000000) {
            $.messager.alert("提示", "上传文件过大,请上传小于30M的文件");
            return false;
        }
        $('#frm_importCheckOrderShopSku').form('submit', {
            url: '${pageContext.request.contextPath }/checkOrderShopSku/importCheckOrderShopSku',
            onSubmit: function () {
                var isValid =$(this).form('validate');
                if(isValid){
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
    function closeDlgImportCheckOrderShopSku(checkOrderId) {
        $('#dlgImportCheckOrderShopSku').dialog('close');
    }
    function exportCheckOrderShopSkuById(checkOrderId) {
        var url = "${pageContext.request.contextPath }/checkOrderShopSku/exportCheckOrderShopSku?checkOrderId=" + checkOrderId;
        window.open(url);
    }

    function saveInventoryQuantityNew(input, id) {
        var inventoryQuantityNew = $(input).val();
        if (isEmpty(inventoryQuantityNew)) {
            $.messager.alert("提示", "最新库存数量不能为空");
            return;
        }
        var r = /^(0|[1-9][0-9]*)$/;　　//正整数
        if (!r.test(inventoryQuantityNew)) {
            $.messager.alert("提示", "最新库存必须为大于等于0的数字.");
            $(input).focus()
            return;
        }
        $.post('${pageContext.request.contextPath }/checkOrderShopSku/saveInventoryQuantityNew', {
            inventoryQuantityNew: inventoryQuantityNew,
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
    function showDlgCheckOrderShopSkuStorageLocation(checkOrderShopSkuId) {
        $('#dlgCheckOrderShopSkuStorageLocation').dialog('open').dialog('setTitle', '库位管理');
        $('#dlgCheckOrderShopSkuStorageLocation_checkOrderShopSkuId').val(checkOrderShopSkuId);
        bindCheckOrderShopSkuStorageLocation();
    }

    function getCheckOrderShopSkuStorageLocationQueryParams() {
        queryParams = {
            checkOrderShopSkuId: $("#dlgCheckOrderShopSkuStorageLocation_checkOrderShopSkuId").val()
        };
        return queryParams;
    }

    function bindCheckOrderShopSkuStorageLocation() {
        dg = '#dgCheckOrderShopSkuStorageLocation';
        url = "${pageContext.request.contextPath }/checkOrderShopSkuStorageLocation/listCheckOrderShopSkuStorageLocation";
        title = "库位管理";
        queryParams = getCheckOrderShopSkuStorageLocationQueryParams();
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
                {field: 'ck', checkbox: true},   //选择
                {title: '仓库名', field: 'shopName', width: 120},
                {title: '库位', field: 'locationNo', width: 120},
                {title: '店铺sku', field: 'shopSku', width: 120},
                {title: '创建时间', field: 'createTime', width: 180},
                {title: '修改时间', field: 'updateTime', width: 180},
                {title: '备注', field: 'remark', width: 120}
            ]],
            toolbar: [{
                id: 'btnAddCheckOrderShopSkuStorageLocation',
                text: '添加',
                iconCls: 'icon-add',
                handler: function () {
                    showAddCheckOrderShopSkuStorageLocationDialog();//实现添加记录的页面
                }
            }, '-', {
                id: 'btnView',
                text: '查看',
                iconCls: 'icon-search',
                handler: function () {
                    showViewCheckOrderShopSkuStorageLocationDialog();//实现查看记录详细信息的方法
                }
            }, '-', {
                id: 'btnEditCheckOrderShopSkuStorageLocation',
                text: '修改',
                iconCls: 'icon-edit',
                handler: function () {
                    showEditCheckOrderShopSkuStorageLocationDialog();//实现修改记录的方法
                }
            }, '-', {
                id: 'btnDeleteCheckOrderShopSkuStorageLocation',
                text: '删除',
                iconCls: 'icon-remove',
                handler: function () {
                    deleteCheckOrderShopSkuStorageLocationInfo();//实现直接删除数据的方法
                }
            },
                '-', {
                    id: 'btnReloadCheckOrderShopSkuStorageLocation',
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
                showViewCheckOrderShopSkuStorageLocationDialog();
            }
        })
        $(dg).datagrid('clearSelections');
    }

    function showAddCheckOrderShopSkuStorageLocationDialog() {
        $('#dlgCheckOrderShopSkuStorageLocationInfo').dialog('open').dialog('setTitle', '添加');
        $("#btn_saveCheckOrderShopSkuStorageLocation").show();
        $(".view_hide").hide();
        $("#frmCheckOrderShopSkuStorageLocationInfo_checkOrderShopSkuId").val($("#dlgCheckOrderShopSkuStorageLocation_checkOrderShopSkuId").val());
    }

    function showViewCheckOrderShopSkuStorageLocationDialog() {
        var rows = $('#dgCheckOrderShopSkuStorageLocation').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $('#dlgCheckOrderShopSkuStorageLocationInfo').dialog('open').dialog('setTitle', '查看');
            $('#frmCheckOrderShopSkuStorageLocationInfo').form('load', rows[0]);
            $("#btn_saveCheckOrderShopSkuStorageLocation").hide();
            $(".view_hide").show();
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function showEditCheckOrderShopSkuStorageLocationDialog() {
        var rows = $('#dgCheckOrderShopSkuStorageLocation').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $('#dlgCheckOrderShopSkuStorageLocationInfo').dialog('open').dialog('setTitle', '修改');
            $('#frmCheckOrderShopSkuStorageLocationInfo').form('load', rows[0]);
            $("#btn_saveCheckOrderShopSkuStorageLocation").show();
            $(".view_hide").hide();
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function deleteCheckOrderShopSkuStorageLocationInfo() {
        var rows = $('#dgCheckOrderShopSkuStorageLocation').datagrid('getSelections');
        if (!rows || rows.length != 1) {
            $.messager.alert("提示", "请选择一条要删除的数据.");
            return;
        }
        $.messager.confirm('提示', '确认删除这' + rows.length + '条数据吗？', function (r) {
            if (r) {
                var checkOrderShopSkuStorageLocationId = rows[0].id;
                $.post('${pageContext.request.contextPath }/checkOrderShopSkuStorageLocation/deleteCheckOrderShopSkuStorageLocation', {checkOrderShopSkuStorageLocationId: checkOrderShopSkuStorageLocationId}, function (data) {
                    if (data.code == '200') {
                        $('#dlg').dialog('close');
                        bindCheckOrderShopSkuStorageLocation();
                    } else {
                        $.messager.alert("提示", data.message);
                    }
                });
            }
        });
    }

    function closeCheckOrderShopSkuStorageLocationInfo() {
        $('#dlgCheckOrderShopSkuStorageLocationInfo').dialog('close');
    }

    function saveCheckOrderShopSkuStorageLocation() {
        $('#frmCheckOrderShopSkuStorageLocationInfo').form('submit', {
            url: '${pageContext.request.contextPath }/checkOrderShopSkuStorageLocation/saveCheckOrderShopSkuStorageLocation',
            onSubmit: function () {
                var validate = $(this).form('validate');
                return validate;
            },
            success: function (data) {
                res = eval('(' + data + ')');
                if (res.code == '200') {
                    closeCheckOrderShopSkuStorageLocationInfo();
                    bindCheckOrderShopSkuStorageLocation();
                } else {
                    $.messager.alert("提示", res.message);
                }
            }
        });
    }
</script>
</html>
