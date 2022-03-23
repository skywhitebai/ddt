<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/22
  Time: 22:28
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

    <title>日报系统</title>
</head>
<body>

<!--查询条件-->
<div class="easyui-panel">
    日期 <input class="easyui-datebox" id="reportDay" name="reportDay" onchange="bindData()">
    <a href="javascript:void(0)" onclick="initDay(-1)" class="easyui-linkbutton"
       data-options="iconCls:'icon-search'"
       style="width: 80px">前一天</a>
    <a href="javascript:void(0)" onclick="initDay(1)" class="easyui-linkbutton"
       data-options="iconCls:'icon-search'"
       style="width: 80px">后一天</a>
    </td>
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
</div>
<table id="dg" style="width: 100%; height: auto">
</table>
</body>
<script type="text/javascript">
    // 初始化内容
    $(document).ready(function () {
        initReportDay();
    });

    function initReportDay() {
        var reportDay = getQueryVariable("reportDay")
        if (reportDay!=false) {
            $("#reportDay").datebox('setValue', reportDay);
        } else {
            $("#reportDay").datebox('setValue', getToDay());
        }
        bindData();
    }

    function bindData() {
        var reportDay = $("#reportDay").val();
        if (isEmpty(reportDay)) {
            $.messager.alert("提示", "请选择日期.");
            return;
        }
        dg = '#dg';
        url = "${pageContext.request.contextPath }/dailyReport/countListDailyReport";
        title = "日志系统";
        queryParams = {
            reportDay: reportDay
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
                {field: 'ck', checkbox: true},
                {
                    title: '姓名', field: 'realName', width: 110,
                    formatter: function (value, rowData, rowIndex) {
                        if (rowData.type == 1) {
                            return value;
                        } else {
                            return value + '<span style="color:red">(补填)</span>';
                        }
                    }
                },
                {title: '今日总结', field: 'todayWorkContent', width: 200},
                {title: '明日计划', field: 'tomorrowWorkPlan', width: 200},
                {title: '创建时间', field: 'createTime', width: 140}
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
    function initDay(days) {
        var reportDay = $("#reportDay").val();
        if (isEmpty(reportDay)) {
            $.messager.alert("提示", "请选择日期.");
            return;
        }
        var newDay = addDayByStr(reportDay, days);
        $("#reportDay").datebox('setValue', newDay);
        bindData();
    }
</script>
</html>
