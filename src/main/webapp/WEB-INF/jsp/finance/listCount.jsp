<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/5/18
  Time: 23:43
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
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/main.css?t=20200928" type="text/css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/common/common.js?t=20201028"></script>
    <title>财务汇总信息</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    类型：
    <select class="easyui-combobox" id="s_type" style="width:100px;">
        <option value="salesmanUser">销售员</option>
        <option value="shop">店铺</option>
        <option value="salesGroup">小组</option>
    </select>
    年月
    <input class="easyui-validatebox textbox" id="s_month">
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
</div>

<!--入库单列表-->
<table id="dg" style="width: 100%; height: auto">

</table>
</body>
<script type="text/javascript">
    $(function () {
        initMonth('s_month');
    });

    function bindData() {
        var type=$("#s_type").combobox('getValue');
        if(isEmpty(type)){
            $.messager.alert("提示", "请选择类型");
            return;
        }
        var month=$("#s_month").val();
        if(isEmpty(month)){
            $.messager.alert("提示", "请选择月份");
            return;
        }
        dg = '#dg';
        url = "${pageContext.request.contextPath }/financialStatement/listFinancialStatementCount";
        title = "财务列表";
        queryParams = {
            type: type,
            month:month
        };
        $(dg).datagrid({   //定位到Table标签，Table标签的ID是grid
            url: url,   //指向后台的Action来获取当前菜单的信息的Json格式的数据
            title: title,
            iconCls: 'icon-view',
            nowrap: true,
            autoRowHeight: false,
            striped: true,
            collapsible: true,
            pagination: false,
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
                    title: '年月', field: 'month', width: 80, formatter: function (value, row, index) {
                        if (value) {
                            return value.substr(0, 7);
                        }
                    }
                },
                {title: '开发员', field: 'developerUserName', width: 100},
                {title: '销售员', field: 'salesmanUserName', width: 100},
                {title: '销售分组', field: 'salesGroupName', width: 100},
                {title: '父SKU', field: 'shopParentSku', width: 100},
                {title: '产品sku', field: 'sku', width: 100},
                {title: '平台sku', field: 'shopSku', width: 100},
                {title: '成本货号', field: 'productCode', width: 100},
                {title: '销售数量', field: 'saleQuantity', width: 100},
                {title: '订单销售额', field: 'productSales', width: 100},
                {title: '航运优惠', field: 'productSalesTax', width: 100},
                {title: 'shipping credits', field: 'shippingCredits', width: 100},
                {title: '促销折扣', field: 'shippingCreditsTax', width: 100},
                {title: 'gift wrap credits', field: 'giftWrapCredits', width: 100},
                {title: 'giftwrap credits tax', field: 'giftWrapCreditsTax', width: 100},
                {title: 'Amazon销售费用', field: 'promotionalRebates', width: 100},
                {title: 'FBA 费用', field: 'promotionalRebatesTax', width: 100},
                {title: 'marketplace withheld tax', field: 'marketplaceWithheldTax', width: 100},
                {title: 'selling fees', field: 'sellingFees', width: 100},
                {title: 'fba fees', field: 'fbaFees', width: 100},
                {title: 'other transaction fees', field: 'otherTransactionFees', width: 100},
                {title: 'other', field: 'other', width: 100},
                {title: '订单合计', field: 'total', width: 100},
                {title: '退货数量', field: 'refundSaleQuantity', width: 100},
                {title: '退货销售额', field: 'refundProductSales', width: 100},
                {title: '退货航运优惠', field: 'refundProductSalesTax', width: 100},
                {title: '退货ShippingCredits', field: 'refundShippingCredits', width: 100},
                {title: '退货促销折扣', field: 'refundShippingCreditsTax', width: 100},
                {title: '退货GiftWrapCredits', field: 'refundGiftWrapCredits', width: 100},
                {title: '退货GiftWrapCreditsTax', field: 'refundGiftWrapCreditsTax', width: 100},
                {title: '退货Amazon销售费用', field: 'refundPromotionalRebates', width: 100},
                {title: '退货FBA Fee费用', field: 'refundPromotionalRebatesTax', width: 100},
                {title: '退货MarketplaceWithheldTax', field: 'refundMarketplaceWithheldTax', width: 100},
                {title: '退货SellingFees', field: 'refundSellingFees', width: 100},
                {title: '退货FbaFees', field: 'refundFbaFees', width: 100},
                {title: '退货OtherTransactionFees', field: 'refundOtherTransactionFees', width: 100},
                {title: '退货Other', field: 'refundOther', width: 100},
                {title: '退货合计', field: 'refundTotal', width: 100},
                {title: '店铺月费', field: 'sellerpaymentsReportFeeSubscription', width: 100},
                {title: 'LD', field: 'lightningDealFee', width: 100},
                {title: 'CPC-推广费用', field: 'costOfAdvertising', width: 100},
                {title: '广告收入', field: 'advertisingIncome', width: 100},
                {title: 'FBA Inventory Reimbursement - Customer Return', field: 'fbaInventoryReimbursementCustomerReturn', width: 100},
                {title: 'FBA Inventory Reimbursement - Damaged:Warehouse', field: 'fbaInventoryReimbursementDamagedWarehouse', width: 100},
                {title: 'FBA Inventory Reimbursement - Customer Service Issue', field: 'fbaInventoryReimbursementCustomerServiceIssue', width: 100},
                {title: 'FBA Inventory Reimbursement - Fee Correction', field: 'fbaInventoryReimbursementFeeCorrection', width: 100},
                {title: 'FBA Inventory Reimbursement - General Adjustment', field: 'fbaInventoryReimbursementGeneralAdjustment', width: 100},
                {title: 'FBA Inventory Reimbursement - Lost:Inbound', field: 'fbaInventoryReimbursementLostInbound', width: 100},
                {title: 'FBA Inventory Reimbursement - Lost:Warehouse', field: 'fbaInventoryReimbursementLostWarehouse', width: 100},
                {title: 'Non-subscription Fee Adjustment', field: 'nonSubscriptionFeeAdjustment', width: 100},
                {title: 'FBA Inventory Placement Service Fee', field: 'fbaInventoryPlacementServiceFee', width: 100},
                {title: 'FBA Customer Return Per Unit Fee', field: 'fbaCustomerReturnPerUnitFee', width: 100},
                {title: 'FBA Inventory Storage Fee', field: 'fbaInventoryStorageFee', width: 100},
                {title: 'BA Long-Term Storage Fee', field: 'fbaLongTermStorageFee', width: 100},
                {title: 'FBA Removal Order: Disposal Fee', field: 'fbaRemovalOrderDisposalFee', width: 100},
                {title: 'Coupon Redemption Fee', field: 'couponRedemptionFee', width: 100},
                {title: 'Early Reviewer Program fee', field: 'earlyReviewerProgramFee', width: 100},
                {title: '回款', field: 'moneyBack', width: 100},
                {title: '回款/销售额', field: 'moneyBackRate', width: 100},
                {title: '主营业务收入（人民币）', field: 'mainBusinessIncome', width: 100},
                {title: '有效回款合计（人民币）', field: 'totalEffectiveReceipts', width: 100},
                {title: '主动销毁数量', field: 'sellableRequestedQuantity', width: 100},
                {title: '主动销毁成本', field: 'sellableCost', width: 100},
                {title: 'unsell销毁数量', field: 'unsellableRequestedQuantity', width: 100},
                {title: 'unsell销毁成本', field: 'unsellableCost', width: 100},
                {title: '采购成本', field: 'procurementCost', width: 100},
                {title: '头程费成本', field: 'fbaHeadTripCost', width: 100},
                {title: '头程空海抵扣', field: 'headDeductionFee', width: 100},
                {title: '主营业务利润', field: 'mainBusinessProfit', width: 100},
                {title: '销售毛利率', field: 'grossMarginOnSales', width: 100},
                {title: 'ROI', field: 'roi', width: 100},
                {title: '期初数量', field: 'initialQuantity', width: 100},
                {title: '期初库存', field: 'initialInventoryCost', width: 100},
                {title: '期末数量', field: 'finalQuantity', width: 100},
                {title: '期末库存', field: 'finalInventoryCost', width: 100},
                {title: '库存周转率', field: 'inventoryTurnover', width: 100},
                {title: '人工调整', field: 'manualAdjustment', width: 100},
                {title: '新品', field: 'newProduct', width: 50},
                {title: '退款率', field: 'refundRate', width: 100},
                {title: '广告占销售额比例', field: 'advertisingSalesPercentage', width: 100},
                {title: '产品月份', field: 'productMonth', width: 100},
                {title: '汇率', field: 'exchangeRate', width: 100},
                {title: '成本价', field: 'costPrice', width: 100},
                {title: '头程费用', field: 'headTripCost', width: 100},
                {title: '开发等级', field: 'developmentLevel', width: 100},
                {title: '展示广告', field: 'displayAdvertising', width: 100},
                {title: '展示广告带来的收入', field: 'displayAdvertisingIncome', width: 100},
                {title: '品牌广告', field: 'brandAdvertising', width: 100},
                {title: '品牌广告带来的收入', field: 'brandAdvertisingIncome', width: 100},
                {title: '货币名称', field: 'currencyName', width: 100},
                {title: 'Liquidations', field: 'liquidations', width: 100},
                {title: 'Liquidations Adjustments', field: 'liquidationsAdjustments', width: 100},
                {title: 'TBYB Order Payment', field: 'tbybOrderPayment', width: 100},
                {title: 'TBYB Trial Shipment', field: 'tbybTrialShipment', width: 100},
                {title: '当月发送价值', field: 'sendCost', width: 100},
                {title: '当月发送价值货值', field: 'sendCostPrice', width: 100},
                {title: '当月发送价值头程', field: 'sendHeadTripCost', width: 100},
                {title: '月销售价值', field: 'saleCost', width: 100},
                {title: '0-14月产品实际销售额', field: 'newProductSellingFees', width: 100},
                {title: '14月产品+实际销售额', field: 'oldProductSellingFees', width: 100},
                {title: '0-14月产品业绩额', field: 'newProductMainBusinessProfit', width: 100},
                {title: '14月产品+业绩额', field: 'oldProductMainBusinessProfit', width: 100},
                {title: '平均库存价值', field: 'averageInventoryCost', width: 100},
                {title: 'AROI', field: 'aroi', width: 100},
                {title: '周转次数', field: 'inventoryTurnoverTimes', width: 100},
                {title: 'ROI考核系数', field: 'roiAssessmentCoefficient', width: 100}
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

</script>
</html>
