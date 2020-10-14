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
                src="${pageContext.request.contextPath }/static/js/common/common.js?t=20200929"></script>
        <title>订单列表</title>
    </head>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    店铺：
    <select id="s_shopId" style="width:150px;">
    </select>
    亚马逊订单id：
    <input class="easyui-validatebox textbox" id="s_amazonOrderId">
    店铺sku：
    <input class="easyui-validatebox textbox" id="s_sku">
    创建订单时间
    <input class="easyui-datetimebox" id="s_purchaseDateStart">
    -
    <input class="easyui-datetimebox" id="s_purchaseDateEnd">
    订单最后更新时间
    <input class="easyui-datetimebox" id="s_lastUpdateDateStart">
    -
    <input class="easyui-datetimebox" id="s_lastUpdateDateEnd">
    订单状态：
    <select class="easyui-combobox" id="s_orderStatus" style="width:100px;">
        <option value="">全部</option>
        <option value="Shipped">Shipped</option>
        Pending
        <option value="Pending">Pending</option>
    </select>
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
    <a href="javascript:void(0)" onclick="showDialogImportOrder()" class="easyui-linkbutton"
       data-options="iconCls:'icon-search'"
       style="">导入订单</a>
    <a href="javascript:void(0)" onclick="showDialogGetShopSku()" class="easyui-linkbutton"
       data-options="iconCls:'icon-search'"
       style="">运单号获取店铺sku</a>
</div>
<table id="dg" style="width: 100%; height: auto">
</table>
<!--编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 800px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
    <div class="ftitle">
        <b>订单信息</b>
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
                <td>亚马逊订单id：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="amazonOrderId">
                </td>
                <td>merchantOrderId：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="merchantOrderId">
                </td>
            </tr>
            <tr>
                <td>创建订单的日期：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="purchaseDate">
                </td>
                <td>订单更新时间：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="lastUpdatedDate">
                </td>
            </tr>

            <tr>
                <td>订单状态：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="orderStatus">
                </td>
                <td>fulfillmentChannel：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="fulfillmentChannel">
                </td>
            </tr>
            <tr>
                <td>salesChannel：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="salesChannel">
                </td>
                <td>orderChannel：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="orderChannel">
                </td>
            </tr>
            <tr>
                <td>url：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="url">
                </td>
                <td>shipServiceLevel：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="shipServiceLevel">
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
                    <input class="easyui-validatebox textbox" name="sku">
                </td>
                <td>asin：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="asin">
                </td>
            </tr>
            <tr>
                <td>itemStatus：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="itemStatus">
                </td>
                <td>quantity：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="quantity">
                </td>
            </tr>
            <tr>
                <td>currency：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="currency">
                </td>
            <tr>
                <td>itemPrice：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="itemPrice">
                </td>
                <td>itemTax：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="itemTax">
                </td>

            </tr>
            <tr>
                <td>shippingPrice：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="shippingPrice">
                </td>
                <td>shippingTax：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="shippingTax">
                </td>
            </tr>
            <tr>
                <td>giftWrapPrice：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="giftWrapPrice">
                </td>
                <td>giftWrapTax：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="giftWrapTax">
                </td>
            </tr>
            <tr>
                <td>itemPromotionDiscount：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="itemPromotionDiscount">
                </td>
                <td>shipPromotionDiscount：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="shipPromotionDiscount">
                </td>
            </tr>
            <tr>
                <td>shipCity：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="shipCity">
                </td>
                <td>shipState：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="shipState">
                </td>
            </tr>
            <tr>
                <td>shipPostalCode：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="shipPostalCode">
                </td>
                <td>shipCountry：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="shipCountry">
                </td>
            </tr>
            <tr>
                <td>promotionIds：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="promotionIds">
                </td>
                <td>isBusinessOrder：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="isBusinessOrder">
                </td>
            </tr>
            <tr>
                <td>purchaseOrderNumber：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="purchaseOrderNumber">
                </td>
                <td>priceDesignation：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="priceDesignation">
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
<div id="dlg_importOrder" class="easyui-dialog" style="width: 600px; height: 300px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
    <div class="ftitle">
        <b>订单导入</b>
        <hr/>
        模板下载：
        <a href="${pageContext.request.contextPath }/static/template/orderImport/orderImportTemplate.xlsx"
           target="_blank">模板下载</a>
    </div>
    <form id="frm_importOrder" method="post" novalidate="novalidate" enctype="multipart/form-data">
        <input type="file" id="importOrderFile" name="file" accept=".xls,.xlsx"/>
        <div style="text-align:center;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" onclick="importOrder()">导入</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-cancel'" onclick="closeDialogImportOrder()">关闭</a>
        </div>
    </form>
</div>
<!--导入页面-->
<div id="dlgGetShopSku" class="easyui-dialog" style="width: 600px; height: 300px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
    <div class="ftitle">
        <b>运单号获取店铺sku</b>
        <hr/>
        模板下载：
        <a href="${pageContext.request.contextPath }/static/template/orderImport/getShopSkuTemplate.xlsx"
           target="_blank">模板下载</a>
    </div>
    <form id="frmGetShopSku" method="post" novalidate="novalidate" enctype="multipart/form-data">
        <input type="file" id="getShopSkuFile" name="file" accept=".xls,.xlsx"/>
        <div style="text-align:center;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" onclick="getShopSku()">导入</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-cancel'" onclick="closeDialogGetShopSku()">关闭</a>
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

    function showDialogGetShopSku() {
        $('#dlgGetShopSku').dialog('open').dialog('setTitle', '运单号获取店铺sku');
    }
    function closeDialogGetShopSku() {
        $('#dlgGetShopSku').dialog('close');
    }
    function getShopSku() {
        var getShopSkuFile = $("#getShopSkuFile").val();
        if (getShopSkuFile == '') {
            $.messager.alert("提示", "请选择文件");
            return;
        }
        var dom = document.getElementById("getShopSkuFile");
        var fileSize = dom.files[0].size;
        if (fileSize > 30000000) {
            $.messager.alert("提示", "文件过大,请选择小于30M的文件");
            return false;
        }
        $('#frmGetShopSku').form('submit', {
            url: '${pageContext.request.contextPath }/orderImport/getShopSku',
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
                    $.messager.alert("提示", "获取成功");
                    bindData();
                }
                else {
                    $.messager.alert("提示", res.message);
                }
            }
        });
    }

    function showDialogImportOrder() {
        $('#dlg_importOrder').dialog('open').dialog('setTitle', '订单导入');
    }

    function closeDialogImportOrder() {
        $('#dlg_importOrder').dialog('close');
    }
    function closeDialog() {
        $('#dlg').dialog('close');
    }
    function importOrder() {
        var importOrderFile = $("#importOrderFile").val();
        if (importOrderFile == '') {
            $.messager.alert("提示", "请选择导入的文件");
            return;
        }
        var dom = document.getElementById("importOrderFile");
        var fileSize = dom.files[0].size;
        if (fileSize > 30000000) {
            $.messager.alert("提示", "上传文件过大,请上传小于30M的文件");
            return false;
        }
        $('#frm_importOrder').form('submit', {
            url: '${pageContext.request.contextPath }/orderImport/importOrder',
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
        url = "${pageContext.request.contextPath }/orderImport/listOrderImport";
        title = "订单管理";
        queryParams = {
            shopId: $("#s_shopId").combobox('getValue'),
            amazonOrderId: $("#s_amazonOrderId").val(),
            sku:$("#s_sku").val(),
            purchaseDateStart: $("#s_purchaseDateStart").val(),
            purchaseDateEnd: $("#s_purchaseDateEnd").val(),
            lastUpdateDateStart: $("#s_lastUpdateDateStart").val(),
            lastUpdateDateEnd: $("#s_lastUpdateDateEnd").val(),
            orderStatus: $("#s_orderStatus").val(),
            marketplaceId: $("#s_marketplaceId").val(),
            buyerName: $("#s_buyerName").val()
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
                {title: '亚马逊订单号', field: 'amazonOrderId', width: 140},
                {title: '创建订单时间', field: 'purchaseDate', width: 160},
                {title: '订单最后更新时间', field: 'lastUpdatedDate', width: 160},
                {title: '订单状态', field: 'orderStatus', width: 80},
                {title: 'sku', field: 'sku', width: 140},
                {title: '产品名', field: 'productName', width: 120},
                {title: 'asin', field: 'asin', width: 120},
                {title: 'itemStatus', field: 'itemStatus', width: 120},
                {title: 'currency', field: 'currency', width: 80},
                {title: 'itemPrice', field: 'itemPrice', width: 80},
                {title: 'itemTax', field: 'itemTax', width: 80},
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
