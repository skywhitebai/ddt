<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2020/4/14
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/main.css?t=20200928" type="text/css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/common/common.js?t=20201028"></script>
    <title>产品即时销售报告</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    店铺：
    <select id="s_shopId" style="width:150px;">
    </select>
    ASIN：
    <input class="easyui-validatebox textbox" id="s_asin">
    店铺sku：
    <input class="easyui-validatebox textbox" id="s_shopSku">
    店铺父sku：
    <input class="easyui-validatebox textbox" id="s_shopParentSku">
    统计类型：
    <select class="easyui-combobox" id="s_skuType" style="width:100px;">
        <option value="shopSku">店铺sku</option>
        <option value="shopParentSku">店铺父sku</option>
    </select>
    销售日期
    <input class="easyui-datebox" id="s_purchaseDate">
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
</div>
<table id="dg" style="width: 100%; height: auto">
</table>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        bindShop();
        $("#s_purchaseDate").datebox('setValue',getToDay());
    });

    function bindShop() {
        $('#s_shopId').combobox({
            valueField: 'shopId',
            textField: 'shopName',
            url: "${pageContext.request.contextPath }/shop/userShopComboboxlist",//获取数据
        });
    }

    function bindData() {
        var shopId = $("#s_shopId").combobox('getValue');
        if (isEmpty(shopId)) {
            $.messager.alert("提示", "请选择店铺.");
            return;
        }
        var purchaseDate = $("#s_purchaseDate").val();
        if (isEmpty(purchaseDate)) {
            $.messager.alert("提示", "请选择销售日期.");
            return;
        }
        dg = '#dg';
        url = "${pageContext.request.contextPath }/report/listSalesReport";
        title = "订单管理";
        queryParams = {
            shopId: shopId,
            asin: $("#s_asin").val(),
            shopSku: $("#s_shopSku").val(),
            purchaseDate: $("#s_purchaseDate").val(),
            shopParentSku: $("#s_shopParentSku").val(),
            skuType: $("#s_skuType").val()
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
                {field: 'ck', checkbox: true},   //选择
                {
                    title: '商品图片', field: 'imgUrl', width: 120,
                    formatter: function (value, rowData, rowIndex) {
                        var res = "";
                        if (value != null && value != '') {
                            res += '<a href="javascript:;"><img  src="' + value + '?x-oss-process=image/resize,m_fill,h_66,w_66"  style="width:66px; height:66px;"/></a> '
                        } else {
                            res += '暂无图片   '
                        }
                        return res;
                    }
                },
                {title: '店铺名', field: 'shopName', width: 120},
                {title: 'ASIN', field: 'asin', width: 120},
                {title: '商品名称', field: 'productName', width: 160},
                {title: '店铺父sku', field: 'shopParentSku', width: 160},
                {title: '店铺sku', field: 'shopSku', width: 160},
                {title: '今日销量', field: 'quantityToday', width: 80},
                {title: '今日净销售额', field: 'netSalesToday', width: 80},
                {title: '今日单价', field: 'unitPriceToday', width: 80},
                {title: '昨日销量', field: 'quantityYesterday', width: 80},
                {title: '昨日净销售额', field: 'netSalesYesterday', width: 80},
                {title: '昨日单价', field: 'unitPriceYesterday', width: 80},
                {title: '上周同日销量', field: 'quantitySameDayLastWeek', width: 80},
                {title: '上周同日净销售额', field: 'netSalesSameDayLastWeek', width: 80},
                {title: '上周同日单价', field: 'unitPriceSameDayLastWeek', width: 80},
                {title: '可售库存', field: 'availableQuantity', width: 80},
                {title: '待收货库存', field: 'inboundQuantity', width: 80},
                {title: '转库中库存', field: 'reservedQuantity', width: 80}
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
