<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2019/11/19
  Time: 16:07
  To change this template use File | Settings | File Templates.
  财务统计列表
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
    <title>财务统计列表</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    店铺：
    <select id="s_shopId" style="width:150px;">
    </select>
    年月
    <input class="easyui-validatebox textbox" id="s_month">
    类型：
    <select class="easyui-combobox" id="s_type" style="width:100px;">
        <option value="shop">店铺</option>
        <option value="count">汇总</option>
    </select>
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
    <a href="javascript:void(0)" onclick="exportFinanceStatistic()" class="easyui-linkbutton">导出回款信息</a>

</div>
<table id="dg" style="width: 100%; height: auto">

</table>
</body>
<script type="text/javascript">
    $(function () {
        initMonth('s_month');
        bindShop();
        bindData();
    });

    function bindShop() {
        $('#s_shopId').combobox({
            valueField: 'shopId',
            textField: 'shopName',
            url: "${pageContext.request.contextPath }/shop/comboboxlist",//获取数据
        });
    }

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/financeStatistic/listFinanceStatistic";
        title = "回款信息";
        queryParams = getQueryParams();
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
                {title: '年月', field: 'monthStr', width: 80},
                {title: '期初价值', field: 'initialInventoryCost', width: 80},
                {title: '期末价值', field: 'finalInventoryCost', width: 80},
                {title: '当月发送价值', field: 'sendCost', width: 100},
                {title: '当月发送价值(货值)', field: 'sendCostPrice', width: 130},
                {title: '当月发送价值(头程)', field: 'sendHeadTripCostAfter', width: 130},
                {title: '当月销售价值', field: 'saleCost', width: 100},
                {title: '当月回款', field: 'mainBusinessIncome', width: 80},
                {
                    title: '账外调整', field: 'manualAdjustment', width: 80,
                    formatter: function (value, row, rowIndex) {
                        if ($("#s_type").combobox('getValue') == 'count') {
                            return value;
                        } else if (isEmpty(value)) {
                            return '<input class="easyui-numberbox " precision="2" onchange="saveManualAdjustment(this,' + row.id + ')">';
                        } else {
                            return '<input class="easyui-numberbox" precision="2" value="' + value + '" onchange="saveManualAdjustment(this,' + row.id + ')">';
                        }
                    }
                },
                {title: '当月净入', field: 'netIncome', width: 80},
                {title: '毛利润', field: 'mainBusinessProfit', width: 80},
                {
                    title: '备注', field: 'remark', width: 300,
                    formatter: function (value, row, rowIndex) {
                        if ($("#s_type").combobox('getValue') == 'count') {
                            return value;
                        } else if (isEmpty(value)) {
                            return '<input class="easyui-textbox " style="width:100%"  onchange="saveFinanceStatisticRemark(this,' + row.id + ')">';
                        } else {
                            return '<input class="easyui-textbox" style="width:100%" value="' + value + '" onchange="saveFinanceStatisticRemark(this,' + row.id + ')">';
                        }
                    }
                },
                {title: '创建时间', field: 'createTime', width: 120},
                {title: '修改时间', field: 'updateTime', width: 120}
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

    function getQueryParams() {
        queryParams = {
            shopId: $("#s_shopId").combobox('getValue'),
            type: $("#s_type").combobox('getValue'),
            month: $("#s_month").val()
        };
        return queryParams;
    }

    function saveManualAdjustment(input, id) {
        var manualAdjustment = $(input).val();
        if (isEmpty(manualAdjustment)) {
            manualAdjustment = 0;
        }
        $.post('${pageContext.request.contextPath }/financeStatistic/saveFinanceStatisticManualAdjustment', {
            manualAdjustment: manualAdjustment,
            id: id
        }, function (data) {
            if (data.code == '200') {
                //保存成功
                bindData();
            } else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function saveFinanceStatisticRemark(input, id) {
        var remark = $(input).val();
        $.post('${pageContext.request.contextPath }/financeStatistic/saveFinanceStatisticRemark', {
            remark: remark,
            id: id
        }, function (data) {
            if (data.code == '200') {
                //保存成功
                bindData();
            } else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function exportFinanceStatistic() {
        window.open('${pageContext.request.contextPath }/financeStatistic/exportFinanceStatistic' + getUrlParams(getQueryParams()));
    }
</script>
</html>
