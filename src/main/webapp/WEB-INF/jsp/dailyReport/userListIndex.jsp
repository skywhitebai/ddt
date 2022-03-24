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
            src="${pageContext.request.contextPath }/static/js/common/common.js?t=20220324"></script>

    <title>日报系统</title>
</head>
<body>

<!--查询条件-->
<div class="easyui-panel">
    <input type="hidden" id="userId">
    日期 <input class="easyui-datebox" id="reportDayStart">- <input class="easyui-datebox" id="reportDayEnd">
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
</div>
<table id="dg" style="width: 100%; height: auto">
</table>
</body>
<script type="text/javascript">
    // 初始化内容
    $(document).ready(function () {
        initUserId();
    });
    function initUserId() {
        var userId = getQueryVariable("userId")
        if (userId!=false) {
            $("#userId").val(userId);
        }
        bindData();
    }
    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/dailyReport/userListDailyReport";
        title = "工作日报";
        queryParams = {
            reportDayStart: $("#reportDayStart").val(),
            reportDayEnd: $("#reportDayEnd").val(),
            userId: $("#userId").val()
        };
        $(dg).datagrid({   //定位到Table标签，Table标签的ID是grid
            url: url,   //指向后台的Action来获取当前菜单的信息的Json格式的数据
            title: title,
            iconCls: 'icon-view',
            nowrap: false,
            autoRowHeight: true,
            striped: true,
            collapsible: true,
            pagination: true,
            singleSelect: true,
            pageSize: 15,
            pageList: [10, 15, 20, 30, 50, 100, 200, 500],
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
                {
                    title: '日期', field: 'reportDay', width: 110,
                    formatter: function (value, rowData, rowIndex) {
                        return value.slice(0,10);
                    }
                },
                {title: '今日总结', field: 'todayWorkContent', width: 500},
                {title: '明日计划', field: 'tomorrowWorkPlan', width: 500},
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
</script>
</html>
