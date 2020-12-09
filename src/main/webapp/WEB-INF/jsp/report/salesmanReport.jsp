<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2020/12/9
  Time: 12:29
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

    <script src="${pageContext.request.contextPath }/static/js/highcharts/highcharts.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/highcharts/modules/exporting.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/highcharts/modules/export-data.js"></script>
    <title>销售业绩统计</title>
</head>
<body>
<div title="">
    <!--查询条件-->
    <div class="easyui-panel" id="search">
        创建订单时间
        <input class="easyui-datebox" id="s_purchaseDateStart">
        -
        <input class="easyui-datebox" id="s_purchaseDateEnd">
        <a href="javascript:void(0)" onclick="last7()"
           class="easyui-linkbutton"
           data-options="iconCls:'icon-search'"
        >最近7天</a>
        <a href="javascript:void(0)" onclick="last30()" class="easyui-linkbutton"
           data-options="iconCls:'icon-search'"
        >最近30天</a>
        <a href="javascript:void(0)" onclick="last60()" class="easyui-linkbutton"
           data-options="iconCls:'icon-search'"
        >最近60天</a>
        <a href="javascript:void(0)" onclick="last90()" class="easyui-linkbutton"
           data-options="iconCls:'icon-search'"
        >最近90天</a>
        <a href="javascript:void(0)" onclick="bindSalesmanReportChart()" class="easyui-linkbutton"
           data-options="iconCls:'icon-search'"
        >查 询</a>
    </div>
    <div id="container" style="min-width:400px;height:600px"></div>


</div>
</body>
<script  type="text/javascript">
    $(function () {
        initSalesmanReportChart();
    });
    function initSalesmanReportChart() {
        last7();
    }
    function bindSalesmanReportChart() {
        var purchaseDateStart = $("#s_purchaseDateStart").val();
        var purchaseDateEnd = $("#s_purchaseDateEnd").val();
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
        /*  if (dayDiff(purchaseDateStartDate, purchaseDateEndDate) > 90) {
              $.messager.alert("提示", "创建订单开始时间、结束时间相差不能超过90天");
              return false;
          }*/
        queryParams = {
            purchaseDateStart: purchaseDateStart,
            purchaseDateEnd: purchaseDateEnd
        };
        $.post('${pageContext.request.contextPath }/report/salesmanReportChart', queryParams, function (data) {
            if (data.code == '200') {
                bindChart( eval('(' + data.data + ')'));
            }
            else {
                $.messager.alert("提示", data.message);
            }
        });
    }
    function bindChart( data) {
        Highcharts.chart('container', {
            chart: {
                type: 'column'
            },
            title: {
                text: "销售业绩统计"
            },
            subtitle: {
                text: '销售业绩统计'
            },
            xAxis: {
                categories: data.categories
            },
            yAxis: [{
                title: {
                    text: '订单数（个）'
                },
                allowDecimals: false
            }, {
                title: {
                    text: '销售件数（个）'
                },
                allowDecimals: false
            }, {
                title: {
                    text: '销售额（美元）'
                }
            }, {
                title: {
                    text: '客单价（美元）'
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
    function last7() {
        var startDate = new Date(new Date().setDate(new Date().getDate() - 8));
        var endDate = new Date(new Date().setDate(new Date().getDate() - 1));
        $("#s_purchaseDateStart").datebox('setValue', dateToString(startDate));
        $("#s_purchaseDateEnd").datebox('setValue', dateToString(endDate));
        bindSalesmanReportChart();
    }
    function last30() {
        var startDate = new Date(new Date().setDate(new Date().getDate() - 31));
        var endDate = new Date(new Date().setDate(new Date().getDate() - 1));
        $("#s_purchaseDateStart").datebox('setValue', dateToString(startDate));
        $("#s_purchaseDateEnd").datebox('setValue', dateToString(endDate));
        bindSalesmanReportChart();
    }

    function last60() {
        var startDate = new Date(new Date().setDate(new Date().getDate() - 61));
        var endDate = new Date(new Date().setDate(new Date().getDate() - 1));
        $("#s_purchaseDateStart").datebox('setValue', dateToString(startDate));
        $("#s_purchaseDateEnd").datebox('setValue', dateToString(endDate));
        bindSalesmanReportChart();
    }

    function last90() {
        var startDate = new Date(new Date().setDate(new Date().getDate() - 91));
        var endDate = new Date(new Date().setDate(new Date().getDate() - 1));
        $("#s_purchaseDateStart").datebox('setValue', dateToString(startDate));
        $("#s_purchaseDateEnd").datebox('setValue', dateToString(endDate));
        bindSalesmanReportChart();
    }
</script>
</html>
