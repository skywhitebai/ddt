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
        <title>fba库存列表</title>
    </head>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    店铺：
    <select id="s_shopId" style="width:150px;">
    </select>
    店铺sku：
    <input class="easyui-validatebox textbox" id="s_sku">
    fnsku：
    <input class="easyui-validatebox textbox" id="s_fnsku">
    asin：
    <input class="easyui-validatebox textbox" id="s_asin">
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
    <a href="javascript:void(0)" onclick="showDialogImport()" class="easyui-linkbutton"
       data-options="iconCls:'icon-search'"
       style="">导入预留库存信息</a>
</div>
<table id="dg" style="width: 100%; height: auto">
</table>
<!--编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 850px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
    <div class="ftitle">
        <b>亚马逊预留库存信息</b>
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
                <td>产品名：</td>
                <td colspan="3">
                    <input class="easyui-textbox" type="text" name="productName" style="width: 90%">
                </td>
            </tr>
            <tr>
                <td>sku：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="sku">
                </td>
                <td>fnsku：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="fnsku">
                </td>
            </tr>
            <tr>
                <td>asin：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="asin">
                </td>
            </tr>
            <tr>
                <td>reservedQty：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="reservedQty">
                </td>
                <td>reservedCustomerorders：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="reservedCustomerorders">
                </td>
            </tr>

            <tr>
                <td>reservedFcTransfers：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="reservedFcTransfers">
                </td>
                <td>reservedFcProcessing：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="reservedFcProcessing">
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
<div id="dlg_import" class="easyui-dialog" style="width: 600px; height: 300px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
    <div class="ftitle">
        <b>fba导入</b>
        <hr/>
        模板下载：
        <a href="${pageContext.request.contextPath }/static/template/amazonReservedInventory/amazonReservedInventoryImportTemplate.xlsx"
           target="_blank">模板下载</a>
    </div>
    <form id="frm_import" method="post" novalidate="novalidate" enctype="multipart/form-data">
        <input type="file" id="importFile" name="file" accept=".xls,.xlsx"/>
        <div style="text-align:center;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" onclick="importData()">导入</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-cancel'" onclick="closeDialogImport()">关闭</a>
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

    function showDialogImport() {
        $('#dlg_import').dialog('open').dialog('setTitle', '导入');
    }

    function closeDialogImport() {
        $('#dlg_import').dialog('close');
    }
    function closeDialog() {
        $('#dlg').dialog('close');
    }
    function importData() {
        var importFile = $("#importFile").val();
        if (importFile == '') {
            $.messager.alert("提示", "请选择导入的文件");
            return;
        }
        var dom = document.getElementById("importFile");
        var fileSize = dom.files[0].size;
        if (fileSize > 30000000) {
            $.messager.alert("提示", "上传文件过大,请上传小于30M的文件");
            return false;
        }
        $('#frm_import').form('submit', {
            url: '${pageContext.request.contextPath }/amazonReservedInventory/importAmazonReservedInventory',
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
        url = "${pageContext.request.contextPath }/amazonReservedInventory/listAmazonReservedInventory";
        title = "亚马逊预留库存管理";
        queryParams = {
            shopId: $("#s_shopId").combobox('getValue'),
            sku: $("#s_sku").val(),
            fnsku: $("#s_fnsku").val(),
            asin: $("#s_asin").val()
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
                {title: 'sku', field: 'sku', width: 140},
                {title: 'fnsku', field: 'fnsku', width: 160},
                {title: 'asin', field: 'asin', width: 160},
                {title: '产品名', field: 'productName', width: 80},
                {title: 'reservedQty', field: 'reservedQty', width: 120},
                {title: 'reservedCustomerorders', field: 'reservedCustomerorders', width: 120},
                {title: 'reservedFcTransfers', field: 'reservedFcTransfers', width: 120},
                {title: 'reservedFcProcessing', field: 'reservedFcProcessing', width: 120},
                {title: '创建时间', field: 'createTime', width: 180},
                {title: '修改时间', field: 'updateTime', width: 180}
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
</script>
</html>
