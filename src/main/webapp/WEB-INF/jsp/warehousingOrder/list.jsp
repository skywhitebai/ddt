<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2020/4/10
  Time: 9:49
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
    <title>入库单</title>
</head>
<body>

<!--查询条件-->
<div class="easyui-panel">
    <!--只显示用户有的店铺-->
    店铺：
    <select class="easyui-combobox" id="s_shopId" style="width:150px;">
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
</div>
<!--入库单列表-->
<table id="dg" style="width: 100%; height: auto">

</table>

<!--入库单编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 700px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true,top:50, align:'center'">
    <div class="ftitle">
        <b>入库单</b>
        <hr/>
    </div>
    <form id="frm" method="post" novalidate="novalidate">
        <table>
            <tr style="display: none">
                <td>入库单id：</td>
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
                <td>入库单类型：</td>
                <td colspan="3">
                    <select class="easyui-combobox" id="type" name="type" style="width: 120px"
                            data-options="required:true">
                        <option value="1">生产单入库</option>
                        <option value="2">手工入库</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="produceOrderInfo">生产单批次号：</td>
                <td class="produceOrderInfo">
                    <input class="easyui-textbox" type="text" id="produceOrderBatchNumber"
                           name="produceOrderBatchNumber">
                    <a href="javascript:void(0)" onclick="showProduceOrderDialog()" class="easyui-linkbutton"
                       data-options="iconCls:'icon-search'"
                       style="width: 80px">选择</a>
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

<div id="dlgProduceOrder" class="easyui-dialog" style="width: 550px; height: 600px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:50,align:'center'">
    <div class="ftitle">
        <b>生产单</b>
        <hr/>
    </div>
    <!--查询条件-->
    <div class="easyui-panel">
        <!--只显示用户有的店铺-->
        店铺：
        <select class="easyui-combobox" id="s_dlgProudceOrder_shopId" style="width:150px;">
        </select>
        店铺sku：
        <input class="easyui-validatebox textbox" id="s_dlgProudceOrder_shopSku">
        生产单批次号：
        <input class="easyui-validatebox textbox" id="s_dlgProudceOrder_produceOrderBatchNumber">
        状态：
        <select class="easyui-combobox" id="s_dlgProudceOrder_status" style="width:100px;">
            <option value="">全部</option>
            <option value="1">待入库</option>
            <option value="2">部分入库</option>
        </select>
        <a href="javascript:void(0)" onclick="bindProduceOrder()" class="easyui-linkbutton"
           data-options="iconCls:'icon-search'"
           style="width: 80px">查 询</a>
    </div>
    <table id="dgProduceOrder" style="width: 100%; height: auto">

    </table>
</div>
<!--编辑页面入库单店铺sku页面-->
<div id="dlgWarehousingOrderShopSku" class="easyui-dialog" style="width: 800px; height: 600px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', top:50,align:'center'">
    <div class="ftitle">
        <b>入库单店铺sku管理</b>
        <hr/>
    </div>
    <form id="frmWarehousingOrderShopSku" method="post" novalidate="novalidate">
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
                <td class="warehousingOrderShopSkuHide">生产单批次号：</td>
                <td class="warehousingOrderShopSkuHide">
                    <input class="easyui-textbox" type="text" name="produceOrderBatchNumber" readonly="readonly">
                </td>
            </tr>
        </table>
        <a href="javascript:void(0)" onclick="bindWarehousingOrderShopSkuData()" class="easyui-linkbutton"
           data-options="iconCls:'icon-search'"
           style="width: 80px">查 询</a>
    </form>
    <table id="dgWarehousingOrderShopSku" style="width: 100%; height: auto">

    </table>
</div>

<!--编辑页面-->
<div id="dlgWarehousingOrderShopSkuInfo" class="easyui-dialog" style="width: 700px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:50, align:'center'">
    <div class="ftitle">
        <b>入库单店铺sku管理</b>
        <hr/>
    </div>
    <form id="frmWarehousingOrderShopSkuInfo" method="post" novalidate="novalidate">
        <table>
            <tr style="display: none">
                <td>入库单id：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="warehousingOrderId">
                </td>
                <td>入库单店铺skuid：</td>
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
                <td>入库数量：</td>
                <td>
                    <input class="easyui-numberbox" name="warehousingQuantity" data-options="min:1,precision:0">
                </td>
            </tr>
            <tr>
                <td>备注：</td>
                <td colspan="3">
                    <input class="easyui-textbox" type="text" name="remark" style="width: 90%">
                </td>
            </tr>
            <tr class="view_hide_produceOrderShopSku">
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
               data-options="iconCls:'icon-ok'" id="btn_save_warehousingOrderShopSku"
               onclick="saveWarehousingOrderShopSku()">确定</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-cancel'" onclick="closeWarehousingOrderShopSkuInfoDialog()">关闭</a>
        </div>
    </form>
</div>
<div id="dlgImportWarehousingOrderShopSku" class="easyui-dialog" style="width: 700px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:50, align:'center'">
    <div class="ftitle">
        <b>入库单店铺sku导入</b>
        <hr/>
        模板下载：
        <a href="${pageContext.request.contextPath }/static/template/warehousingOrder/warehousingOrderShopSkuImportTemplate.xlsx"
           target="_blank">模板下载</a>
    </div>
    <form id="frm_importWarehousingOrderShopSku" method="post" novalidate="novalidate" enctype="multipart/form-data">
        <input type="file" id="importWarehousingOrderShopSkuFile" name="file" accept=".xls,.xlsx"/>
        <input type="hidden" id="warehousingOrderId" name="warehousingOrderId">
        <div style="text-align:center;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" onclick="importWarehousingOrderShopSku()">导入</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-cancel'" onclick="closeDlgImportWarehousingOrderShopSku()">关闭</a>
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
            $('#s_dlgProudceOrder_shopId').combobox({
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
            warehousingTimeStart: $("#s_warehousingTimeStart").val(),
            warehousingTimeEnd: $("#s_warehousingTimeEnd").val(),
            batchNumber: $("#s_batchNumber").val(),
            shopSku: $("#s_shopSku").val(),
            type: $("#s_type").val(),
            produceOrderBatchNumber: $("#s_produceOrderBatchNumber").val(),
            status: $("#s_status").val()
        };
        return queryParams;
    }

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/warehousingOrder/listWarehousingOrder";
        title = "入库单管理";
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
                    {
                        title: '入库时间', field: 'warehousingTime', width: 140, formatter: function (value, row, index) {
                        if (!isEmpty(value)) {
                            return value.substring(0, 10);
                        }
                    }
                    },
                    {title: '入库类型', field: 'typeName', width: 120},
                    {title: '生产单批号', field: 'produceOrderBatchNumber', width: 120},
                    {title: '批号', field: 'batchNumber', width: 140},
                    {title: '状态', field: 'statusName', width: 50},
                    {title: '入库数量', field: 'warehousingQuantityTotal', width: 66},
                    {title: '创建时间', field: 'createTime', width: 180},
                    {title: '修改时间', field: 'updateTime', width: 180},
                    {title: '备注', field: 'remark', width: 180},
                    {
                        title: '操作', field: 'deal', width: 200, formatter: function (value, row, index) {
                        var content = '<a href="javascript:void(0)" onclick="exportWarehousingOrderShopSkuById(' + row.id + ')" class="easyui-linkbutton" >导出店铺sku</a>';
                        if (row.status == 1) {
                            content += '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="showImportWarehousingOrderShopSkuById(' + row.id + ')" class="easyui-linkbutton" >导入店铺sku</a>';
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
                    id: 'btnWarehousingOrderShopSku',
                    text: '入库单店铺sku管理',
                    iconCls: 'icon-edit',
                    handler: function () {
                        showWarehousingOrderShopSkuDialog();
                    }
                }, '-', {
                    id: 'btnWarehousing',
                    text: '入库',
                    iconCls: 'icon-edit',
                    handler: function () {
                        //入库操作
                        warehousing();
                    }
                }, '-', {
                    id: 'btnDelete',
                    text: '作废',
                    iconCls: 'icon-remove',
                    handler: function () {
                        cancelWarehousingOrder();//实现直接删除数据的方法
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

    //入库
    function warehousing() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            //添加二次确认
            $.messager.confirm('提示', '确认要设置店铺[' + rows[0].shopName + '],批号[' + rows[0].batchNumber + ']的入库单为已入库吗？', function (r) {
                if (r) {
                    warehousingById(rows[0].id);
                }
            });
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    //入库
    function warehousingById(id) {
        $.post('${pageContext.request.contextPath }/warehousingOrder/warehousing', {id: id}, function (data) {
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
        var type = $("div#dlg input[name='type']").val();
        if (type == '') {
            $.messager.alert("提示", '请选择入库类型');
            return;
        } else if (type == '1') {
            var produceOrderBatchNumber = $("div#dlg input[name='produceOrderBatchNumber']").val();
            if (produceOrderBatchNumber == '') {
                $.messager.alert("提示", '请填写生产单批次号');
                return;
            }
        }
        $('#frm').form('submit', {
            url: '${pageContext.request.contextPath }/warehousingOrder/saveWarehousingOrder',
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

    function cancelWarehousingOrder() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $.messager.confirm('提示', '确认废除店铺[' + rows[0].shopName + '],批号[' + rows[0].batchNumber + ']的入库单吗？', function (r) {
                if (r) {
                    $.post('${pageContext.request.contextPath }/warehousingOrder/cancelWarehousingOrder', {id: rows[0].id}, function (data) {
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

    function showWarehousingOrderShopSkuDialog() {
        var rows = $('#dg').datagrid('getSelections');
        if (!rows || rows.length != 1) {
            $.messager.alert("提示", "请选择一条记录.");
            return;
        }
        if (rows[0].type == 1) {
            $(".warehousingOrderShopSkuHide").show();
        } else {
            $(".warehousingOrderShopSkuHide").hide();
        }
        $('#dlgWarehousingOrderShopSku').dialog('open').dialog('setTitle', '入库单店铺sku管理');
        $('#frmWarehousingOrderShopSku').form('load', rows[0]);
        bindWarehousingOrderShopSkuData();
    }


    function bindWarehousingOrderShopSkuData() {
        dg = '#dgWarehousingOrderShopSku';
        url = "${pageContext.request.contextPath }/warehousingOrderShopSku/listWarehousingOrderShopSku";
        title = "入库单店铺sku管理";
        queryParams = {warehousingOrderId: $('#dg').datagrid('getSelections')[0].id};
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
                {title: '生产数量', field: 'productionQuantity', width: 50},
                {
                    title: '入库数量', field: 'warehousingQuantity', width: 66,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-numberbox " min="1" precision="0" onchange="saveWarehousingQuantity(this,' + row.id + ')">';
                        } else {
                            return '<input class="easyui-numberbox" min="1" precision="0" value="' + value + '" onchange="saveWarehousingQuantity(this,' + row.id + ')">';
                        }
                    }
                },
                {title: '创建时间', field: 'createTime', width: 180},
                {title: '修改时间', field: 'updateTime', width: 180},
                {title: '备注', field: 'remark', width: 180}
            ]],
            toolbar: [{
                id: 'btnWarehousingOrderShopSkuView',
                text: '查看',
                iconCls: 'icon-search',
                handler: function () {
                    showViewWarehousingOrderShopSkuDialog();//实现查看记录详细信息的方法
                }
            }, '-', {
                id: 'btnAdd',
                text: '添加',
                iconCls: 'icon-add',
                handler: function () {
                    showAddWarehousingOrderShopSkuDialog();//实现查看记录详细信息的方法
                }
            }, '-', {
                id: 'btnEdit',
                text: '修改',
                iconCls: 'icon-edit',
                handler: function () {
                    showEditWarehousingOrderShopSkuDialog();//实现修改记录的方法
                }
            }, '-', {
                id: 'btnDelete',
                text: '删除',
                iconCls: 'icon-remove',
                handler: function () {
                    deleteWarehousingOrderShopSku();//实现直接删除数据的方法
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
                showViewWarehousingOrderShopSkuDialog();
            }
        })
        $(dg).datagrid('clearSelections');
    }

    function showAddWarehousingOrderShopSkuDialog() {
        $('#dlgWarehousingOrderShopSkuInfo').dialog('open').dialog('setTitle', '添加入库单店铺sku');
        $('#frmWarehousingOrderShopSkuInfo').form('clear');
        $("#btn_save_warehousingOrderShopSku").show();
        $(".view_hide_warehousingOrderShopSku").hide();
        $("div#dlgWarehousingOrderShopSkuInfo input[name='warehousingOrderId']").val($('#dg').datagrid('getSelections')[0].id);
    }

    function showEditWarehousingOrderShopSkuDialog() {
        var rows = $('#dgWarehousingOrderShopSku').datagrid('getSelections');
        if (!rows || rows.length != 1) {
            $.messager.alert("提示", "请选择一条记录.");
            return;
        }
        $('#dlgWarehousingOrderShopSkuInfo').dialog('open').dialog('setTitle', '编辑入库单店铺sku');
        $('#frmWarehousingOrderShopSkuInfo').form('load', rows[0]);
        $("#btn_save_warehousingOrderShopSku").show();
        $(".view_hide_warehousingOrderShopSku").hide();
    }

    function showViewWarehousingOrderShopSkuDialog() {
        var rows = $('#dgWarehousingOrderShopSku').datagrid('getSelections');
        if (!rows || rows.length != 1) {
            $.messager.alert("提示", "请选择一条记录.");
            return;
        }
        $('#dlgWarehousingOrderShopSkuInfo').dialog('open').dialog('setTitle', '查看入库单店铺sku');
        $('#frmWarehousingOrderShopSkuInfo').form('load', rows[0]);
        $("#btn_save_warehousingOrderShopSku").hide();
        $(".view_hide_warehousingOrderShopSku").show();
    }

    function saveWarehousingOrderShopSku() {
        var shopSku = $("div#dlgWarehousingOrderShopSkuInfo input[name='shopSku']").val();
        if (shopSku == '') {
            $.messager.alert("提示", '请填写店铺sku');
            return;
        }
        var warehousingQuantity = $("div#dlgWarehousingOrderShopSkuInfo input[name='warehousingQuantity']").val();
        if (warehousingQuantity == '') {
            $.messager.alert("提示", '请填写入库数量');
            return;
        }
        $('#frmWarehousingOrderShopSkuInfo').form('submit', {
            url: '${pageContext.request.contextPath }/warehousingOrderShopSku/saveWarehousingOrderShopSku',
            onSubmit: function () {
                var validate = $(this).form('validate');
                return validate;
            },
            success: function (data) {
                res = eval('(' + data + ')');
                if (res.code == '200') {
                    closeWarehousingOrderShopSkuInfoDialog();
                    bindWarehousingOrderShopSkuData();
                }
                else {
                    $.messager.alert("提示", res.message);
                }
            }
        });
    }

    function deleteWarehousingOrderShopSku() {
        var rows = $('#dgWarehousingOrderShopSku').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $.messager.confirm('提示', '确认废除店铺[' + rows[0].shopName + '],店铺sku[' + rows[0].shopSku + ']的生产单店铺sku吗？', function (r) {
                if (r) {
                    $.post('${pageContext.request.contextPath }/warehousingOrderShopSku/deleteWarehousingOrderShopSku', {id: rows[0].id}, function (data) {
                        if (data.code == '200') {
                            bindWarehousingOrderShopSkuData();
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

    function closeWarehousingOrderShopSkuInfoDialog() {
        $('#dlgWarehousingOrderShopSkuInfo').dialog('close');
    }

    function showImportWarehousingOrderShopSkuById(warehousingOrderId) {
        $('#dlgImportWarehousingOrderShopSku').dialog('open').dialog('setTitle', '导入入库单店铺sku');
        $('#warehousingOrderId').val(warehousingOrderId);
    }

    function importWarehousingOrderShopSku() {
        var importWarehousingOrderShopSkuFile = $("#importWarehousingOrderShopSkuFile").val();
        if (importWarehousingOrderShopSkuFile == '') {
            $.messager.alert("提示", "请选择导入的文件");
            return;
        }
        var dom = document.getElementById("importWarehousingOrderShopSkuFile");
        var fileSize = dom.files[0].size;
        if (fileSize > 30000000) {
            $.messager.alert("提示", "上传文件过大,请上传小于30M的文件");
            return false;
        }
        $('#frm_importWarehousingOrderShopSku').form('submit', {
            url: '${pageContext.request.contextPath }/warehousingOrderShopSku/importWarehousingOrderShopSku',
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

    function closeDlgImportWarehousingOrderShopSku(warehousingOrderId) {
        $('#dlgImportWarehousingOrderShopSku').dialog('close');
    }

    function exportWarehousingOrderShopSkuById(warehousingOrderId) {
        var url = "${pageContext.request.contextPath }/warehousingOrderShopSku/exportWarehousingOrderShopSku?warehousingOrderId=" + warehousingOrderId;
        window.open(url);
    }

    function showProduceOrderDialog() {
        $('#dlgProduceOrder').dialog('open').dialog('setTitle', '选择生产单');
        var shopId = $('#shopId').combobox('getValue');
        if (!isEmpty(shopId)) {
            $('#s_dlgProudceOrder_shopId').combobox('setValue', shopId);
        } else {
            $('#s_dlgProudceOrder_shopId').combobox('setValue', null);
        }
        bindProduceOrder();
    }

    function bindProduceOrder() {
        dg = '#dgProduceOrder';
        url = "${pageContext.request.contextPath }/produceOrder/listProduceOrder";
        title = "生产单管理";
        queryParams = {
            shopId: $('#s_dlgProudceOrder_shopId').combobox('getValue'),
            batchNumber: $("#s_dlgProudceOrder_produceOrderBatchNumber").val(),
            shopSku: $("#s_dlgProudceOrder_shopSku").val(),
            status: $("#s_dlgProudceOrder_status").val()
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
                    {title: '店铺名', field: 'shopName', width: 120},
                    {title: '批号', field: 'batchNumber', width: 140},
                    {title: '状态', field: 'statusName', width: 100},
                    {
                        title: '操作', field: 'deal', width: 60, formatter: function (value, row, index) {
                        var content = '<a href="javascript:void(0)" onclick="selectProduceOrder(\'' + row.batchNumber + '\',' + row.shopId + ')" class="easyui-linkbutton" >选择</a>';
                        return content;
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
            }
        )
        $(dg).datagrid('clearSelections');
    }

    function selectProduceOrder(batchNumber, shopId) {
        $('#dlgProduceOrder').dialog('close');
        $('#produceOrderBatchNumber').textbox('setValue', batchNumber);
        $('#shopId').combobox('setValue', shopId);
        $('#type').combobox('setValue', "1");
    }
    function saveWarehousingQuantity(input, id) {
        var warehousingQuantity = $(input).val();
        if (isEmpty(warehousingQuantity)) {
            $.messager.alert("提示", "入库数量不能为空");
            return;
        }
        var r = /^[1-9][0-9]*$/;　　//正整数
        if (!r.test(warehousingQuantity)) {
            $.messager.alert("提示", "入库数量必须为大于等于1的数字.");
            $(input).focus()
            return;
        }
        $.post('${pageContext.request.contextPath }/warehousingOrderShopSku/saveWarehousingQuantity', {
            warehousingQuantity: warehousingQuantity,
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
