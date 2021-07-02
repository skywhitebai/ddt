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

    <title>亚马逊订单商品列表</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    amazonOrderId：
    <input class="easyui-validatebox textbox" id="s_amazonOrderId">
    asin：
    <input class="easyui-validatebox textbox" id="s_asin">
    sellerSku：
    <input class="easyui-validatebox textbox" id="s_sellerSku">
    title：
    <input class="easyui-validatebox textbox" id="s_title">
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
    <a href="javascript:void(0)" onclick="downAmazonOrderItem()" class="easyui-linkbutton"
       data-options="iconCls:'icon-search'"
       >下载亚马逊订单商品信息</a>
</div>
<table id="dg" style="width: 100%; height: auto">

</table>
<!--编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 1000px; height: 800px; padding: 10px 20px"
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
                <td>amazonOrderId：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="amazonOrderId">
                </td>
                <td>asin：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="asin">
                </td>
            </tr>
            <tr>
                <td>sellerSku：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="sellerSku">
                </td>
                <td>orderItemId：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="orderItemId">
                </td>
            </tr>
            <tr>
                <td>title：</td>
                <td colspan="3">
                    <input class="easyui-validatebox textbox" style="widows:90%;" name="title">
                </td>
            </tr>
            <tr>
                <td>
                    quantityOrdered：
                </td>
                <td>
                    <input class="easyui-validatebox textbox" name="quantityOrdered">
                </td>
                <td>quantityShipped：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="quantityShipped">
                </td>
            </tr>
            <tr>
                <td>numberOfItems：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="numberOfItems">
                </td>
                <td>pointsNumber：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="pointsNumber">
                </td>
            </tr>
            <tr>
                <td>pointsMonetaryValueAmount：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="pointsMonetaryValueAmount">
                </td>
                <td>pointsMonetaryValueCurrencyCode：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="pointsMonetaryValueCurrencyCode">
                </td>
            </tr>
            <tr>
                <td>itemPriceAmount：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="itemPriceAmount">
                </td>
                <td>itemPriceCurrencyCode：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="itemPriceCurrencyCode">
                </td>
            </tr>
            <tr>
                <td>shippingPriceAmount：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="shippingPriceAmount">
                </td>
                <td>shippingPriceCurrencyCode：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="shippingPriceCurrencyCode">
                </td>
            </tr>
            <tr>
                <td>itemTaxAmount：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="itemTaxAmount">
                </td>
                <td>itemTaxCurrencyCode：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="itemTaxCurrencyCode">
                </td>
            </tr>
            <tr>
                <td>shippingTaxAmount：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="shippingTaxAmount">
                </td>
                <td>shippingTaxCurrencyCode：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="shippingTaxCurrencyCode">
                </td>
            </tr>
            <tr>
                <td>shippingDiscountAmount：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="shippingDiscountAmount">
                </td>
                <td>shippingDiscountCurrencyCode：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="shippingDiscountCurrencyCode">
                </td>
            </tr>
            <tr>
                <td>shippingDiscountTaxAmount：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="shippingDiscountTaxAmount">
                </td>
                <td>shippingDiscountTaxCurrencyCode：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="shippingDiscountTaxCurrencyCode">
                </td>
            </tr>
            <tr>
                <td>promotionDiscountAmount：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="promotionDiscountAmount">
                </td>
                <td>promotionDiscountCurrencyCode：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="promotionDiscountCurrencyCode">
                </td>
            </tr>
            <tr>
                <td>promotionDiscountTaxAmount：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="promotionDiscountTaxAmount">
                </td>
                <td>promotionDiscountTaxCurrencyCode：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="promotionDiscountTaxCurrencyCode">
                </td>
            </tr>
            <tr>
                <td>promotionIdList：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="promotionIdList">
                </td>
                <td>coDFeeAmount：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="coDFeeAmount">
                </td>
            </tr>
            <tr>
                <td>coDFeeCurrencyCode：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="coDFeeCurrencyCode">
                </td>
                <td>coDFeeDiscountAmount：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="coDFeeDiscountAmount">
                </td>
            </tr>
            <tr>
                <td>coDFeeDiscountCurrencyCode：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="coDFeeDiscountCurrencyCode">
                </td>
                <td>isGift：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="isGift">
                </td>
            </tr>
            <tr>
                <td>conditionNote：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="conditionNote">
                </td>
                <td>conditionId：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="conditionId">
                </td>
            </tr>
            <tr>
                <td>conditionSubtypeId：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="conditionSubtypeId">
                </td>
                <td>scheduledDeliveryStartDate：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="scheduledDeliveryStartDate">
                </td>
            </tr>
            <tr>
                <td>scheduledDeliveryEndDate：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="scheduledDeliveryEndDate">
                </td>
                <td>priceDesignation：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="priceDesignation">
                </td>
            </tr>
            <tr>
                <td>taxCollectionModel：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="taxCollectionModel">
                </td>
                <td>taxCollectionResponsibleParty：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="taxCollectionResponsibleParty">
                </td>
            </tr>
            <tr>
                <td>serialNumberRequired：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="serialNumberRequired">
                </td>
                <td>isTransparency：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="isTransparency">
                </td>
            </tr>
            <tr>
                <td>iossNumber：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="iossNumber">
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
        url = "${pageContext.request.contextPath }/amazonOrderItem/listAmazonOrderItem";
        title = "亚马逊库存管理";
        queryParams = {
            amazonOrderId: $("#s_amazonOrderId").val(),
            asin: $("#s_asin").val(),
            sellerSku: $("#s_sellerSku").val(),
            title: $("#s_title").val()
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
                {title: 'amazonOrderId', field: 'amazonOrderId', width: 100},
                {title: 'asin', field: 'asin', width: 50},
                {title: 'sellerSku', field: 'sellerSku', width: 50},
                {title: 'orderItemId', field: 'orderItemId', width: 50},
                {title: 'title', field: 'title', width: 50},
                {title: 'quantityOrdered', field: 'quantityOrdered', width: 50},
                {title: 'quantityShipped', field: 'quantityShipped', width: 50},
                {title: 'numberOfItems', field: 'numberOfItems', width: 50},
                {title: 'pointsNumber', field: 'pointsNumber', width: 50},
                {title: 'pointsMonetaryValueAmount', field: 'pointsMonetaryValueAmount', width: 50},
                {title: 'pointsMonetaryValueCurrencyCode', field: 'pointsMonetaryValueCurrencyCode', width: 50},
                {title: 'itemPriceAmount', field: 'itemPriceAmount', width: 50},
                {title: 'itemPriceCurrencyCode', field: 'itemPriceCurrencyCode', width: 50},
                {title: 'shippingPriceAmount', field: 'shippingPriceAmount', width: 50},
                {title: 'shippingPriceCurrencyCode', field: 'shippingPriceCurrencyCode', width: 50},
                {title: 'itemTaxAmount', field: 'itemTaxAmount', width: 50},
                {title: 'itemTaxCurrencyCode', field: 'itemTaxCurrencyCode', width: 50},
                {title: 'shippingTaxAmount', field: 'shippingTaxAmount', width: 50},
                {title: 'shippingTaxCurrencyCode', field: 'shippingTaxCurrencyCode', width: 50},
                {title: 'shippingDiscountAmount', field: 'shippingDiscountAmount', width: 50},
                {title: 'shippingDiscountCurrencyCode', field: 'shippingDiscountCurrencyCode', width: 50},
                {title: 'shippingDiscountTaxAmount', field: 'shippingDiscountTaxAmount', width: 50},
                {title: 'shippingDiscountTaxCurrencyCode', field: 'shippingDiscountTaxCurrencyCode', width: 50},
                {title: 'promotionDiscountAmount', field: 'promotionDiscountAmount', width: 50},
                {title: 'promotionDiscountCurrencyCode', field: 'promotionDiscountCurrencyCode', width: 50},
                {title: 'promotionDiscountTaxAmount', field: 'promotionDiscountTaxAmount', width: 50},
                {title: 'promotionDiscountTaxCurrencyCode', field: 'promotionDiscountTaxCurrencyCode', width: 50},
                {title: 'promotionIdList', field: 'promotionIdList', width: 50},
                {title: 'coDFeeAmount', field: 'coDFeeAmount', width: 50},
                {title: 'coDFeeCurrencyCode', field: 'coDFeeCurrencyCode', width: 50},
                {title: 'coDFeeDiscountAmount', field: 'coDFeeDiscountAmount', width: 50},
                {title: 'coDFeeDiscountCurrencyCode', field: 'coDFeeDiscountCurrencyCode', width: 50},
                {title: 'isGift', field: 'isGift', width: 50},
                {title: 'conditionNote', field: 'conditionNote', width: 50},
                {title: 'conditionId', field: 'conditionId', width: 50},
                {title: 'conditionSubtypeId', field: 'conditionSubtypeId', width: 50},
                {title: 'scheduledDeliveryStartDate', field: 'scheduledDeliveryStartDate', width: 50},
                {title: 'scheduledDeliveryEndDate', field: 'scheduledDeliveryEndDate', width: 50},
                {title: 'priceDesignation', field: 'priceDesignation', width: 50},
                {title: 'taxCollectionModel', field: 'taxCollectionModel', width: 50},
                {title: 'taxCollectionResponsibleParty', field: 'taxCollectionResponsibleParty', width: 50},
                {title: 'serialNumberRequired', field: 'serialNumberRequired', width: 50},
                {title: 'isTransparency', field: 'isTransparency', width: 50},
                {title: 'iossNumber', field: 'iossNumber', width: 50},
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

    function downAmazonOrderItem() {
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
