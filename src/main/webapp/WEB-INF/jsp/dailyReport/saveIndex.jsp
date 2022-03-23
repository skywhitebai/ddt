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
<h1>
    日报填写
</h1>
<div>
</div>
<div class="easyui-panel" style="width: 700px">
    <form id="frm" method="post" novalidate="novalidate">
        <table>
            <tr>
                <td>
                    日期 <input class="easyui-datebox" id="reportDay" name="reportDay" onchange="bindData()">
                </td>
            </tr>
            <tr>
                <td>
                    <a href="javascript:void(0)" onclick="initDay(-1)" class="easyui-linkbutton"
                       data-options="iconCls:'icon-search'"
                       style="width: 80px">前一天</a>
                    <a href="javascript:void(0)" onclick="initDay(1)" class="easyui-linkbutton"
                       data-options="iconCls:'icon-search'"
                       style="width: 80px">后一天</a>
                </td>
            </tr>
            <tr>
                <td>今日总结：</td>
            </tr>
            <tr>
                <td>
                    <input class="easyui-textbox" data-options="multiline:true" name="todayWorkContent"
                           id="todayWorkContent" style="width:500px;height:150px">
                </td>
            </tr>
            <tr>
                <td>明日计划：</td>
            </tr>
            <tr>
                <td>
                    <input class="easyui-textbox" data-options="multiline:true" name="tomorrowWorkPlan"
                           id="tomorrowWorkPlan" style="width:500px;height:150px">
                </td>
            </tr>
        </table>
        <div style="text-align:center;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" id="btn_save" onclick="save()">确定</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-cancel'" onclick="closeDialog()">关闭</a>
        </div>
        <div>
            日报填写建议：
            <br>
            （1）今日总结列出当天工作内容，突出重点，一般第一条是最重要工作。
            <br>
            （2）总结需写明需求或者功能，也可以列所遇困难和解决方案。
            <br>
            （3）明日计划按优先级列出第二天的工作计划，一般第一条是最高优先级。
            <br>
            （4）每天下班前填写完毕，每天的填写时间是从早上5点到第二天的5点。
        </div>
    </form>
</div>
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
        $.post('${pageContext.request.contextPath }/dailyReport/getDailyReport', {reportDay: reportDay}, function (data) {
            var dailyReport = data.data;
            if (dailyReport != null) {
                $("#todayWorkContent").textbox("setValue",dailyReport.todayWorkContent);
                $("#tomorrowWorkPlan").textbox("setValue",dailyReport.tomorrowWorkPlan);
            }else{
                $("#todayWorkContent").textbox("setValue","");
                $("#tomorrowWorkPlan").textbox("setValue","");
            }
        });
    }

    function save() {
        var todayWorkContent = $("#todayWorkContent").val();
        var tomorrowWorkPlan = $("#tomorrowWorkPlan").val();
        if (isEmpty(todayWorkContent)) {
            $.messager.alert("提示", "今日总结不能为空.");
            return;
        }
        if (isEmpty(tomorrowWorkPlan)) {
            $.messager.alert("提示", "明日不能为空.");
            return;
        }
        $('#frm').form('submit', {
            url: '${pageContext.request.contextPath }/dailyReport/saveDailyReport',
            onSubmit: function () {
                var validate = $(this).form('validate');
                return validate;
            },
            success: function (data) {
                res = eval('(' + data + ')');
                if (res.code == '200') {
                    $.messager.alert("提示", res.message);
                } else {
                    $.messager.alert("提示", res.message);
                }
            }
        });
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
