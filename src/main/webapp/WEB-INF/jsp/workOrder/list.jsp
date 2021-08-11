<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/8/9
  Time: 21:28
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

    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.5.4/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/main.css?t=20200928" type="text/css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/common/common.js?t=20201028"></script>
    <title>工单管理</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    <!--只显示用户有的店铺-->
    标题：
    <select class="easyui-combobox" id="s_title" style="width:150px;">
    </select>
    状态：
    <select class="easyui-combobox" id="s_status" style="width:100px;">
        <option value="">全部</option>
        <option value="1">进行中</option>
        <option value="2">已完成</option>
        <option value="3">取消</option>
    </select>
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
</div>
<!--入库单列表-->
<table id="dg" style="width: 100%; height: auto">

</table>
<!--入库单编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 700px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true,top:50, align:'center'">
    <div class="ftitle">
        <b>工单</b>
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
                <td>标题：</td>
                <td colspan="3">
                    <input class="easyui-validatebox textbox" name="id" width="90%">
                </td>
            </tr>
            <tr>
                <td>内容：</td>
                <td colspan="3">
                    <input class="easyui-validatebox textbox" name="id" width="90%">
                </td>
            </tr>
            <tr>
                <td>处理级别：</td>
                <td>
                    <select class="easyui-combobox" name="level" style="width:100px;">
                        <option value="1">紧急</option>
                        <option value="2">普通</option>
                        <option value="3">不急</option>
                    </select>
                </td>
                <td>处理结束时间：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="actualEndTime" readonly="readonly">
                </td>
            </tr>
            <tr class="view_status">
                <td>状态：</td>
                <td>
                    <select class="easyui-combobox" name="status" style="width:100px;">
                        <option value="">全部</option>
                        <option value="1">进行中</option>
                        <option value="2">已完成</option>
                        <option value="3">取消</option>
                    </select>
                </td>0
            </tr>
            <tr class="view_status">
                <td>处理状态：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="daelTimeStausName" readonly="readonly">
                </td>
                <td>实际处理时间：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="actualEndTime" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>备注：</td>
                <td colspan="3">
                    <input class="easyui-textbox" type="text" name="remark" style="width: 90%">
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
               data-options="iconCls:'icon-ok'" id="btn_save" onclick="save()">确定</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-cancel'" onclick="closeDialog()">关闭</a>
        </div>
    </form>
</div>
</body>
</html>
