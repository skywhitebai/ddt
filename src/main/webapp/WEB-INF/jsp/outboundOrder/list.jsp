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
            src="${pageContext.request.contextPath }/static/js/common/common.js?t=20200929"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/common/selectShopSku.js"></script>
    <title>出库单</title>
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
    出库时间：
    <input class="easyui-datebox" id="s_outboundTimeStart">
    -
    <input class="easyui-datebox" id="s_outboundTimeEnd">
    批号：
    <input class="easyui-validatebox textbox" id="s_batchNumber">
    FBA编号：
    <input class="easyui-validatebox textbox" id="s_fbaNo">
    店铺sku：
    <input class="easyui-validatebox textbox" id="s_shopSku">
    type：
    <select class="easyui-combobox" id="s_type" style="width:100px;">
        <option value="">全部</option>
        <option value="1">手工出库</option>
        <option value="2">fba装箱单出库</option>
    </select>
    状态：
    <select class="easyui-combobox" id="s_status" style="width:100px;">
        <option value="">全部</option>
        <option value="1">待出库</option>
        <option value="2">已出库</option>
        <option value="0">取消</option>
    </select>
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
</div>
<!--出库单列表-->
<table id="dg" style="width: 100%; height: auto">

</table>
<!--出库单编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 700px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true,top:50, align:'center'">
    <div class="ftitle">
        <b>出库单</b>
        <hr/>
    </div>
    <form id="frm" method="post" novalidate="novalidate">
        <table>
            <tr style="display: none">
                <td>出库单id：</td>
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
            <tr>
                <td>FBA编号：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="fbaNo" name="fbaNo">
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


<!--编辑页面出库单店铺sku页面-->
<div id="dlgOutboundOrderShopSku" class="easyui-dialog" style="width: 900px; height: 600px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:50,align:'center'">
    <div class="ftitle">
        <b>出库单店铺sku管理</b>
        <hr/>
    </div>
    <form id="frmOutboundOrderShopSku" method="post" novalidate="novalidate">
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
                <td>FBA编号：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="fbaNo" readonly="readonly">
                </td>
                <td>状态：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="statusName" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>产品sku：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="dlgOutboundOrderShopSku_sku"></td>
                <td>店铺sku：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="dlgOutboundOrderShopSku_shopSku"></td>
            </tr>
        </table>
        <a href="javascript:void(0)" onclick="bindOutboundOrderShopSkuData()" class="easyui-linkbutton"
           data-options="iconCls:'icon-search'"
           style="width: 80px">查 询</a>
    </form>
    <table id="dgOutboundOrderShopSku" style="width: 100%; height: auto">

    </table>
</div>


<!--编辑页面-->
<div id="dlgOutboundOrderShopSkuInfo" class="easyui-dialog" style="width: 700px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', top:50,align:'center'">
    <div class="ftitle">
        <b>出库单店铺sku管理</b>
        <hr/>
    </div>
    <form id="frmOutboundOrderShopSkuInfo" method="post" novalidate="novalidate">
        <table>
            <tr style="display: none">
                <td>出库单id：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="outboundOrderId">
                </td>
                <td>出库单店铺skuid：</td>
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
                <td>出库数量：</td>
                <td>
                    <input class="easyui-numberbox" name="outboundQuantity" data-options="min:1,precision:0">
                </td>
            </tr>
            <tr>
                <td>备注：</td>
                <td colspan="3">
                    <input class="easyui-textbox" type="text" name="remark" style="width: 90%">
                </td>
            </tr>
            <tr class="view_hide_outboundOrderShopSku">
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
               data-options="iconCls:'icon-ok'" id="btn_save_outboundOrderShopSku"
               onclick="saveOutboundOrderShopSku()">确定</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-cancel'" onclick="closeOutboundOrderShopSkuInfoDialog()">关闭</a>
        </div>
    </form>
</div>
<div id="dlgImportOutboundOrderShopSku" class="easyui-dialog" style="width: 700px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:50, align:'center'">
    <div class="ftitle">
        <b>出库单店铺sku导入</b>
        <hr/>
        模板下载：
        <a href="${pageContext.request.contextPath }/static/template/outboundOrder/outboundOrderShopSkuImportTemplate.xlsx"
           target="_blank">模板下载</a>
    </div>
    <form id="frm_importOutboundOrderShopSku" method="post" novalidate="novalidate" enctype="multipart/form-data">
        <input type="file" id="importOutboundOrderShopSkuFile" name="file" accept=".xls,.xlsx"/>
        <input type="hidden" id="outboundOrderId" name="outboundOrderId">
        <div style="text-align:center;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" onclick="importOutboundOrderShopSku()">导入</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-cancel'" onclick="closeDlgImportOutboundOrderShopSku()">关闭</a>
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
<div id="cover">
    <div id="coverMsg">
        <img src="${pageContext.request.contextPath }/static/img/loading.gif" width="100px">
    </div>
</div>


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
            createTimeStart: $("#s_createTimeStart").val(),
            createTimeEnd: $("#s_createTimeEnd").val(),
            outboundTimeStart: $("#s_outboundTimeStart").val(),
            outboundTimeEnd: $("#s_outboundTimeEnd").val(),
            batchNumber: $("#s_batchNumber").val(),
            fbaNo: $("#s_fbaNo").val(),
            shopSku: $("#s_shopSku").val(),
            status: $("#s_status").val()
        };
        return queryParams;
    }

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/outboundOrder/listOutboundOrder";
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
                    {field: 'ck', outboundbox: true},   //选择
                    {title: '店铺名', field: 'shopName', width: 120},
                    {title: 'FBA编号', field: 'fbaNo', width: 120},
                    {title: '出库时间', field: 'outboundTime', width: 140},
                    {title: '批号', field: 'batchNumber', width: 140},
                    {
                        title: '类型', field: 'type', width: 100, formatter: function (value, row, index) {
                        if (value == 1) {
                            return '手工出库';
                        } else if (value == 2) {
                            return 'FBA装箱单出库';
                        }
                    }
                    },
                    {title: '状态', field: 'statusName', width: 50},
                    {title: '出库数量', field: 'outboundQuantityTotal', width: 66},
                    {title: '创建时间', field: 'createTime', width: 180},
                    {title: '修改时间', field: 'updateTime', width: 180},
                    {title: '备注', field: 'remark', width: 180},
                    {
                        title: '操作', field: 'deal', width: 200, formatter: function (value, row, index) {
                        var content = '<a href="javascript:void(0)" onclick="exportOutboundOrderShopSkuById(' + row.id + ')" class="easyui-linkbutton" >导出店铺sku</a>';
                        if (row.status == 1) {
                            content += '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="showImportOutboundOrderShopSkuById(' + row.id + ')" class="easyui-linkbutton" >导入店铺sku</a>';
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
                    id: 'btnOutboundOrderShopSku',
                    text: '出库单店铺sku管理',
                    iconCls: 'icon-edit',
                    handler: function () {
                        showOutboundOrderShopSkuDialog();
                    }
                }, '-', {
                    id: 'btnOutbound',
                    text: '出库',
                    iconCls: 'icon-edit',
                    handler: function () {
                        outbound();
                    }
                }, '-', {
                    id: 'btnDelete',
                    text: '取消',
                    iconCls: 'icon-remove',
                    handler: function () {
                        cancelOutboundOrder();
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

    //出库
    function outbound() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            //添加二次确认
            $.messager.confirm('提示', '确认要设置店铺[' + rows[0].shopName + '],批号[' + rows[0].batchNumber + ']的出库单为已出库吗？', function (r) {
                if (r) {
                    outboundById(rows[0].id);
                }
            });
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    //出库
    function outboundById(id) {
        $.post('${pageContext.request.contextPath }/outboundOrder/outbound', {id: id}, function (data) {
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
            url: '${pageContext.request.contextPath }/outboundOrder/saveOutboundOrder',
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

    function cancelOutboundOrder() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $.messager.confirm('提示', '确认废除店铺[' + rows[0].shopName + '],批号[' + rows[0].batchNumber + ']的出库单吗？', function (r) {
                if (r) {
                    $.post('${pageContext.request.contextPath }/outboundOrder/cancelOutboundOrder', {id: rows[0].id}, function (data) {
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

    function showOutboundOrderShopSkuDialog() {
        var rows = $('#dg').datagrid('getSelections');
        if (!rows || rows.length != 1) {
            $.messager.alert("提示", "请选择一条记录.");
            return;
        }
        $('#dlgOutboundOrderShopSku').dialog('open').dialog('setTitle', '出库单店铺sku管理');
        $('#frmOutboundOrderShopSku').form('load', rows[0]);
        $('#dlgOutboundOrderShopSku_shopSku').textbox("setValue", "");
        $('#dlgOutboundOrderShopSku_sku').textbox("setValue", "");
        bindOutboundOrderShopSkuData();
    }


    function bindOutboundOrderShopSkuData() {
        dg = '#dgOutboundOrderShopSku';
        url = "${pageContext.request.contextPath }/outboundOrderShopSku/listOutboundOrderShopSku";
        title = "出库单店铺sku管理";
        queryParams = {
            outboundOrderId: $('#dg').datagrid('getSelections')[0].id,
            shopSku: $('#dlgOutboundOrderShopSku_shopSku').val(),
            sku: $('#dlgOutboundOrderShopSku_sku').val()
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
                {field: 'ck', outboundBox: true},   //选择
                {title: '店铺名', field: 'shopName', width: 120},
                {title: '产品sku', field: 'sku', width: 140},
                {title: '店铺sku', field: 'shopSku', width: 140},
                {title: '库存', field: 'inventoryQuantity', width: 38},
                {title: '其他店铺库存', field: 'inventoryQuantityOtherShop', width: 88},
                {title: '仓库库存', field: 'inventoryQuantityWarehouse', width: 75},
                {
                    title: '出库数量', field: 'outboundQuantity', width: 66,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-numberbox " min="1" precision="0" onchange="saveOutboundQuantity(this,' + row.id + ')">';
                        } else {
                            return '<input class="easyui-numberbox" min="1" precision="0" value="' + value + '" onchange="saveOutboundQuantity(this,' + row.id + ')">';
                        }
                    }
                },
                {title: '创建时间', field: 'createTime', width: 180},
                {title: '修改时间', field: 'updateTime', width: 180},
                {title: '备注', field: 'remark', width: 180}
            ]],
            toolbar: [{
                id: 'btnOutboundOrderShopSkuView',
                text: '查看',
                iconCls: 'icon-search',
                handler: function () {
                    showViewOutboundOrderShopSkuDialog();//实现查看记录详细信息的方法
                }
            }, '-', {
                id: 'btnAdd',
                text: '添加',
                iconCls: 'icon-add',
                handler: function () {
                    showAddOutboundOrderShopSkuDialog();//实现查看记录详细信息的方法
                }
            }, '-', {
                id: 'btnEdit',
                text: '修改',
                iconCls: 'icon-edit',
                handler: function () {
                    showEditOutboundOrderShopSkuDialog();//实现修改记录的方法
                }
            }, '-', {
                id: 'btnDelete',
                text: '删除',
                iconCls: 'icon-remove',
                handler: function () {
                    deleteOutboundOrderShopSku();//实现直接删除数据的方法
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
            onDblClickRow: function (rowIndex, rowData) {
                $(dg).datagrid('uncheckAll');
                $(dg).datagrid('checkRow', rowIndex);
                showViewOutboundOrderShopSkuDialog();
            }
        })
        $(dg).datagrid('clearSelections');
        $(dg).datagrid('uncheckAll');
    }

    function showAddOutboundOrderShopSkuDialog() {
        $('#dlgOutboundOrderShopSkuInfo').dialog('open').dialog('setTitle', '添加出库单店铺sku');
        $('#frmOutboundOrderShopSkuInfo').form('clear');
        $("#btn_save_outboundOrderShopSku").show();
        $(".view_hide_outboundOrderShopSku").hide();
        $("div#dlgOutboundOrderShopSkuInfo input[name='outboundOrderId']").val($('#dg').datagrid('getSelections')[0].id);
    }

    function showEditOutboundOrderShopSkuDialog() {
        var rows = $('#dgOutboundOrderShopSku').datagrid('getSelections');
        if (!rows || rows.length != 1) {
            $.messager.alert("提示", "请选择一条记录.");
            return;
        }
        $('#dlgOutboundOrderShopSkuInfo').dialog('open').dialog('setTitle', '编辑出库单店铺sku');
        $('#frmOutboundOrderShopSkuInfo').form('load', rows[0]);
        $("#btn_save_outboundOrderShopSku").show();
        $(".view_hide_outboundOrderShopSku").hide();
    }

    function showViewOutboundOrderShopSkuDialog() {
        var rows = $('#dgOutboundOrderShopSku').datagrid('getSelections');
        if (!rows || rows.length != 1) {
            $.messager.alert("提示", "请选择一条记录.");
            return;
        }
        $('#dlgOutboundOrderShopSkuInfo').dialog('open').dialog('setTitle', '查看出库单店铺sku');
        $('#frmOutboundOrderShopSkuInfo').form('load', rows[0]);
        $("#btn_save_outboundOrderShopSku").hide();
        $(".view_hide_outboundOrderShopSku").show();
    }

    function saveOutboundOrderShopSku() {
        var shopSku = $("div#dlgOutboundOrderShopSkuInfo input[name='shopSku']").val();
        if (shopSku == '') {
            $.messager.alert("提示", '请填写店铺sku');
            return;
        }
        var outboundQuantity = $("div#dlgOutboundOrderShopSkuInfo input[name='outboundQuantity']").val();
        if (outboundQuantity == '') {
            $.messager.alert("提示", '请填写出库数量');
            return;
        }
        $('#frmOutboundOrderShopSkuInfo').form('submit', {
            url: '${pageContext.request.contextPath }/outboundOrderShopSku/saveOutboundOrderShopSku',
            onSubmit: function () {
                var validate = $(this).form('validate');
                return validate;
            },
            success: function (data) {
                res = eval('(' + data + ')');
                if (res.code == '200') {
                    closeOutboundOrderShopSkuInfoDialog();
                    bindOutboundOrderShopSkuData();
                }
                else {
                    $.messager.alert("提示", res.message);
                }
            }
        });
    }

    function deleteOutboundOrderShopSku() {
        var rows = $('#dgOutboundOrderShopSku').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $.messager.confirm('提示', '确认删除店铺[' + rows[0].shopName + '],店铺sku[' + rows[0].shopSku + ']的店铺sku吗？', function (r) {
                if (r) {
                    $.post('${pageContext.request.contextPath }/outboundOrderShopSku/deleteOutboundOrderShopSku', {id: rows[0].id}, function (data) {
                        if (data.code == '200') {
                            bindOutboundOrderShopSkuData();
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

    function closeOutboundOrderShopSkuInfoDialog() {
        $('#dlgOutboundOrderShopSkuInfo').dialog('close')
    }

    function showImportOutboundOrderShopSkuById(outboundOrderId) {
        $('#dlgImportOutboundOrderShopSku').dialog('open').dialog('setTitle', '导入出库单店铺sku');
        $('#outboundOrderId').val(outboundOrderId);
    }

    function importOutboundOrderShopSku() {
        var importOutboundOrderShopSkuFile = $("#importOutboundOrderShopSkuFile").val();
        if (importOutboundOrderShopSkuFile == '') {
            $.messager.alert("提示", "请选择导入的文件");
            return;
        }
        var dom = document.getElementById("importOutboundOrderShopSkuFile");
        var fileSize = dom.files[0].size;
        if (fileSize > 30000000) {
            $.messager.alert("提示", "上传文件过大,请上传小于30M的文件");
            return false;
        }
        $('#frm_importOutboundOrderShopSku').form('submit', {
            url: '${pageContext.request.contextPath }/outboundOrderShopSku/importOutboundOrderShopSku',
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

    function closeDlgImportOutboundOrderShopSku(outboundOrderId) {
        $('#dlgImportOutboundOrderShopSku').dialog('close');
    }

    function exportOutboundOrderShopSkuById(outboundOrderId) {
        var url = "${pageContext.request.contextPath }/outboundOrderShopSku/exportOutboundOrderShopSku?outboundOrderId=" + outboundOrderId;
        window.open(url);
    }

    function saveOutboundQuantity(input, id) {
        var outboundQuantity = $(input).val();
        if (isEmpty(outboundQuantity)) {
            $.messager.alert("提示", "出库数量不能为空");
            return;
        }
        var r = /^[1-9][0-9]*$/;　　//正整数
        if (!r.test(outboundQuantity)) {
            $.messager.alert("提示", "出库数量必须为大于等于1的数字.");
            $(input).focus()
            return;
        }
        $.post('${pageContext.request.contextPath }/outboundOrderShopSku/saveOutboundQuantity', {
            outboundQuantity: outboundQuantity,
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
