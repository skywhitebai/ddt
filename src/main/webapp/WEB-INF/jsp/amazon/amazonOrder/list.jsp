<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/11
  Time: 16:16
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

    <title>亚马逊订单列表</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    店铺merchantId：
    <input class="easyui-validatebox textbox" id="s_merchantId">
    marketplaceId：
    <input class="easyui-validatebox textbox" id="s_marketplaceId">
    amazonOrderId：
    <input class="easyui-validatebox textbox" id="s_amazonOrderId">
    sellerOrderId：
    <input class="easyui-validatebox textbox" id="s_sellerOrderId">
    下单时间
    <input class="easyui-datebox" id="s_purchaseDateStart">
    -
    <input class="easyui-datebox" id="s_purchaseDateEnd">
    订单状态：
    <select class="easyui-combobox" id="s_orderStatus" style="width:100px;">
        <option value="">全部</option>
        <option value="Canceled">Canceled</option>
        <option value="Shipped">Shipped</option>
        <option value="Pending">Pending</option>
    </select>
    buyerEmail：
    <input class="easyui-validatebox textbox" id="s_buyerEmail">
    卖家sku：
    <input class="easyui-validatebox textbox" id="s_sellerSku">
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
    <a href="javascript:void(0)" onclick="downAmazonOrder()" class="easyui-linkbutton"
       data-options="iconCls:'icon-search'"
       >下载亚马逊库存信息</a>
</div>
<table id="dg" style="width: 100%; height: auto">

</table>
<!--编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 1000px; height:800px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
    <div class="ftitle">
        <b>亚马逊订单信息</b>
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
                <td>店铺merchantId：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="merchantId">
                </td>
                <td>merchantId：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="merchantId">
                </td>
            </tr>
            <tr>
                <td>amazonOrderId：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="amazonOrderId">
                </td>
                <td>sellerOrderId：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="sellerOrderId">
                </td>
            </tr>
            <tr>
                <td>purchaseDate：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="purchaseDate">
                </td>
                <td>lastUpdateDate：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="lastUpdateDate">
                </td>
            </tr>
            <tr>
                <td>
                    orderDate：
                </td>
                <td>
                    <input class="easyui-validatebox textbox" name="orderDate">
                </td>
                <td>orderStatus：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="orderStatus">
                </td>
            </tr>
            <tr>
                <td>orderType：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="orderType">
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
                <td>shipServiceLevel：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="shipServiceLevel">
                </td>
                <td>shipmentServiceLevelCategory：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="shipmentServiceLevelCategory">
                </td>
            </tr>
            <tr>
                <td>currency：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="currency">
                </td>
                <td>totalAmount：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="totalAmount">
                </td>
            </tr>
            <tr>
                <td>rateAmount：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="rateAmount">
                </td>
                <td>numberOfItemsShipped：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="numberOfItemsShipped">
                </td>
            </tr>
            <tr>
                <td>numberOfItemsUnshipped：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="numberOfItemsUnshipped">
                </td>
                <td>paymentExecutionDetail：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="paymentExecutionDetail">
                </td>
            </tr>
            <tr>
                <td>paymentMethod：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="paymentMethod">
                </td>
                <td>paymentMethodDetails：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="paymentMethodDetails">
                </td>
            </tr>
            <tr>
                <td>easyShipShipmentStatus：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="easyShipShipmentStatus">
                </td>
                <td>earliestShipDate：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="earliestShipDate">
                </td>
            </tr>
            <tr>
                <td>latestShipDate：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="latestShipDate">
                </td>
                <td>earlyestDeliveryDate：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="earlyestDeliveryDate">
                </td>
            </tr>
            <tr>
                <td>latestDeliveryDate：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="latestDeliveryDate">
                </td>
                <td>businessOrder：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="businessOrder">
                </td>
            </tr>
            <tr>
                <td>prime：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="prime">
                </td>
                <td>premiumOrder：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="premiumOrder">
                </td>
            </tr>
            <tr>
                <td>globalExpressEnabled：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="globalExpressEnabled">
                </td>
                <td>replacementOrder：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="replacementOrder">
                </td>
            </tr>
            <tr>
                <td>replacedOrderId：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="replacedOrderId">
                </td>
                <td>promiseResponseDueDate：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="promiseResponseDueDate">
                </td>
            </tr>
            <tr>
                <td>estimatedShipDateSet：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="estimatedShipDateSet">
                </td>
                <td>businessOrder：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="businessOrder">
                </td>
            </tr>
            <tr>
                <td>soldByAb：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="soldByAb">
                </td>
                <td>assignedShipFromLocationAddress：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="assignedShipFromLocationAddress">
                </td>
            </tr>
            <tr>
                <td>buyerEmail：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="buyerEmail">
                </td>
                <td>stateOrRegion：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="stateOrRegion">
                </td>
            </tr>
            <tr>
                <td>countryCode：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="countryCode">
                </td>
                <td>postalCode：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="postalCode">
                </td>
            </tr>
            <tr>
                <td>city：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="city">
                </td>
                <td>county：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="county">
                </td>
            </tr>
            <tr>
                <td>addressLine1：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="addressLine1">
                </td>
                <td>syncOrderItemStatus：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="syncOrderItemStatus">
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


<script type="text/javascript">
    bindData();

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/amazonOrder/listAmazonOrder";
        title = "亚马逊订单管理";
        queryParams = {
            merchantId: $('#s_merchantId').val(),
            marketplaceId: $("#s_marketplaceId").val(),
            amazonOrderId: $("#s_amazonOrderId").val(),
            purchaseDateStart: $("#s_purchaseDateStart").val(),
            purchaseDateEnd: $("#s_purchaseDateEnd").val(),
            orderStatus: $("#s_orderStatus").val(),
            buyerEmail: $("#s_buyerEmail").val(),
            sellerSku: $("#s_sellerSku").val()
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
                {title: 'merchantId', field: 'merchantId', width: 120},
                {title: 'marketplaceId', field: 'marketplaceId', width: 100},
                {title: 'amazonOrderId', field: 'amazonOrderId', width: 100},
                {title: 'sellerOrderId', field: 'sellerOrderId', width: 100},
                {title: 'purchaseDate', field: 'purchaseDate', width: 120},
                {title: 'lastUpdateDate', field: 'lastUpdateDate', width: 120},
                {title: 'orderDate', field: 'orderDate', width: 120},
                {title: 'orderStatus', field: 'orderStatus', width: 50},
                {title: 'orderType', field: 'orderType', width: 50},
                {title: 'fulfillmentChannel', field: 'fulfillmentChannel', width: 50},
                {title: 'salesChannel', field: 'salesChannel', width: 50},
                {title: 'orderChannel', field: 'orderChannel', width: 50},
                {title: 'shipServiceLevel', field: 'shipServiceLevel', width: 50},
                {title: 'shipmentServiceLevelCategory', field: 'shipmentServiceLevelCategory', width: 50},
                {title: 'currency', field: 'currency', width: 50},
                {title: 'totalAmount', field: 'totalAmount', width: 50},
                {title: 'rateAmount', field: 'rateAmount', width: 50},
                {title: 'numberOfItemsShipped', field: 'numberOfItemsShipped', width: 50},
                {title: 'numberOfItemsUnshipped', field: 'numberOfItemsUnshipped', width: 50},
                {title: 'paymentExecutionDetail', field: 'paymentExecutionDetail', width: 50},
                {title: 'paymentMethod', field: 'paymentMethod', width: 50},
                {title: 'paymentMethodDetails', field: 'paymentMethodDetails', width: 50},
                {title: 'easyShipShipmentStatus', field: 'easyShipShipmentStatus', width: 50},
                {title: 'earliestShipDate', field: 'earliestShipDate', width: 50},
                {title: 'latestShipDate', field: 'latestShipDate', width: 50},
                {title: 'earlyestDeliveryDate', field: 'earlyestDeliveryDate', width: 50},
                {title: 'latestDeliveryDate', field: 'latestDeliveryDate', width: 50},
                {title: 'businessOrder', field: 'businessOrder', width: 50},
                {title: 'prime', field: 'prime', width: 50},
                {title: 'premiumOrder', field: 'premiumOrder', width: 50},
                {title: 'globalExpressEnabled', field: 'globalExpressEnabled', width: 50},
                {title: 'replacementOrder', field: 'replacementOrder', width: 50},
                {title: 'replacedOrderId', field: 'replacedOrderId', width: 50},
                {title: 'promiseResponseDueDate', field: 'promiseResponseDueDate', width: 50},
                {title: 'estimatedShipDateSet', field: 'estimatedShipDateSet', width: 50},
                {title: 'soldByAb', field: 'soldByAb', width: 50},
                {title: 'assignedShipFromLocationAddress', field: 'assignedShipFromLocationAddress', width: 50},
                {title: 'buyerEmail', field: 'buyerEmail', width: 50},
                {title: 'stateOrRegion', field: 'stateOrRegion', width: 50},
                {title: 'countryCode', field: 'countryCode', width: 50},
                {title: 'postalCode', field: 'postalCode', width: 50},
                {title: 'city', field: 'city', width: 50},
                {title: 'county', field: 'county', width: 50},
                {title: 'addressLine1', field: 'addressLine1', width: 50},
                {title: 'createTime', field: 'createTime', width: 100},
                {title: 'updateTime', field: 'updateTime', width: 100}
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
            $("#btn_save").hide();
            $(".view_hide").show();
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function downAmazonOrder() {
        $.messager.alert("提示", "暂未实现.");
        return;
        shopId = $('#s_shopId').combobox('getValue');
        if (shopId == '') {
            $.messager.alert("提示", "请选择店铺.");
            return;
        }
        sellerSku = $("#s_sellerSku").val();
        url = "${pageContext.request.contextPath }/inventory/downShopInventoryInfo?shopId=" + shopId + "&sellerSku" + sellerSku;
        window.open(url);
    }

    function closeDialog() {
        $('#dlg').dialog('close');
    }
</script>
</body>
</html>
