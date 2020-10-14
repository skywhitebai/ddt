<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2019/11/4
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath }/static/js/jquery-easyui-1.7.0/themes/default/easyui.css"
          type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/js/jquery-easyui-1.7.0/themes/icon.css"
          type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/js/jquery-easyui-1.7.0/demo/demo.css"
          type="text/css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/jquery-easyui-1.7.0/jquery.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/jquery-easyui-1.7.0/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/jquery-easyui-1.7.0/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/common/common.js?t=20200929"></script>

    <script src="${pageContext.request.contextPath }/static/js/highcharts/highcharts.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/highcharts/modules/exporting.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/highcharts/modules/export-data.js"></script>
    <title>销售信息</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel" id="search">
    店铺父sku：
    <input class="easyui-validatebox textbox" id="s_shopParentSku">
    创建订单时间
    <input class="easyui-datebox" id="s_purchaseDateStart">
    -
    <input class="easyui-datebox" id="s_purchaseDateEnd">
    <form id="ff">
        <input class="easyui-radiobutton" name="searchType" value="shopSku" label="店铺sku"
               data-options="labelPosition:'after',labelWidth:80,onChange:bindData">
        <input class="easyui-radiobutton" name="searchType" value="shopParentSku" label="店铺父sku"
               data-options="labelPosition:'after',labelWidth:100,checked:true,onChange:bindData">
    </form>
    <a href="javascript:void(0)" onclick="last30()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
    >最近30天</a>
    <a href="javascript:void(0)" onclick="last60()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
    >最近60天</a>
    <a href="javascript:void(0)" onclick="last90()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
    >最近90天</a>
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
    >查 询</a>
</div>
<div id="container" style="min-width:400px;height:600px"></div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        bindFirst();
    });

    function bindFirst() {
        var shopParentSku = getQueryVariable('shopParentSku');
        var purchaseDateStart = getQueryVariable('purchaseDateStart');
        var purchaseDateEnd = getQueryVariable('purchaseDateEnd');
        if (!isEmpty(shopParentSku)) {
            $("#s_shopParentSku").val(decodeURI(shopParentSku));
        }
        if (!isEmpty(purchaseDateStart)) {
            $("#s_purchaseDateStart").datebox('setValue', decodeURI(purchaseDateStart));
        }
        if (!isEmpty(purchaseDateEnd)) {
            $("#s_purchaseDateEnd").datebox('setValue', decodeURI(purchaseDateEnd));
        }
        if (!isEmpty(shopParentSku) && !isEmpty(purchaseDateStart) && !isEmpty(purchaseDateEnd)) {
            bindData();
        }
    }

    function bindData() {
        var shopParentSku = $("#s_shopParentSku").val();
        var purchaseDateStart = $("#s_purchaseDateStart").val();
        var purchaseDateEnd = $("#s_purchaseDateEnd").val();
        if (isEmpty(shopParentSku)) {
            $.messager.alert("提示", '店铺父sku');
            return;
        }
        if (isEmpty(purchaseDateStart) || isEmpty(purchaseDateEnd)) {
            $.messager.alert("提示", "请选择创建订单时间.");
            return;
        }
        var purchaseDateStartDate = new Date(purchaseDateStart);
        var purchaseDateEndDate = new Date(purchaseDateEnd);
        if (purchaseDateStartDate > purchaseDateEndDate) {
            $.messager.alert("提示", "创建订单开始时间必须小于等于结束时间");
            return false;
        }
        if (dayDiff(purchaseDateStartDate, purchaseDateEndDate) > 90) {
            $.messager.alert("提示", "创建订单开始时间、结束时间相差不能超过90天");
            return false;
        }
        queryParams = {
            shopParentSku: shopParentSku,
            purchaseDateStart: purchaseDateStart,
            purchaseDateEnd: purchaseDateEnd,
            searchType: $("input[name='searchType']:checked").val()
        };
        $.post('${pageContext.request.contextPath }/shopSku/salesCountChart', queryParams, function (data) {
            if (data.code == '200') {
                bindChart(shopParentSku, eval('(' + data.data + ')'));
            }
            else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function bindChart(shopParentSku, data) {
        Highcharts.chart('container', {
            chart: {
                type: 'line'
            },
            title: {
                text: shopParentSku
            },
            subtitle: {
                text: '销量、价格统计图'
            },
            xAxis: {
                categories: data.categories
            },
            yAxis: [{
                title: {
                    text: '销量 (个)'
                },
                allowDecimals: false
            }, {
                title: {
                    text: '价格 (美元)'
                }
            }
            ],
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle'
            },
            plotOptions: {
                line: {
                    dataLabels: {
                        // 开启数据标签
                        enabled: true
                    }
                }
            },
            series: data.series,
            credits: {
                enabled: false
            }
        });
    }

    function last30() {
        var startDate = new Date(new Date().setDate(new Date().getDate() - 31));
        var endDate = new Date(new Date().setDate(new Date().getDate() - 1));
        $("#s_purchaseDateStart").datebox('setValue', dateToString(startDate));
        $("#s_purchaseDateEnd").datebox('setValue', dateToString(endDate));
        bindData();
    }

    function last60() {
        var startDate = new Date(new Date().setDate(new Date().getDate() - 61));
        var endDate = new Date(new Date().setDate(new Date().getDate() - 1));
        $("#s_purchaseDateStart").datebox('setValue', dateToString(startDate));
        $("#s_purchaseDateEnd").datebox('setValue', dateToString(endDate));
        bindData();
    }

    function last90() {
        var startDate = new Date(new Date().setDate(new Date().getDate() - 91));
        var endDate = new Date(new Date().setDate(new Date().getDate() - 1));
        $("#s_purchaseDateStart").datebox('setValue', dateToString(startDate));
        $("#s_purchaseDateEnd").datebox('setValue', dateToString(endDate));
        bindData();
    }
</script>
</html>
