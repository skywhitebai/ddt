<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2020/7/2
  Time: 10:51
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
    <title>运输渠道管理</title>
</head>
<style>
    .textbox-wide {
        width: 400px;
    }
</style>
<body>
<!--查询条件-->
<div class="easyui-panel">
    <!--只显示用户有的店铺-->
    运输渠道：
    <input class="easyui-validatebox textbox" id="s_transportTypeName">
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
</div>
<table id="dg" style="width: 100%; height: auto">

</table>
<!--编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 700px; height: 300px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
    <div class="ftitle">
        <b>运输渠道管理</b>
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
                <td>运输渠道：</td>
                <td>
                    <input class="easyui-textbox textbox-wide" type="text" name="transportTypeName"
                           data-options="required:true">
                </td>
            </tr>
            <tr>
                <td>排序（倒序）：</td>
                <td>
                    <input class="easyui-numberbox textbox-wide" name="sort"
                           data-options="min:1,precision:0,required:true">
                </td>
            </tr>
            <tr>
                <td>备注：</td>
                <td>
                    <input class="easyui-textbox textbox-wide" type="text" name="remark">
                </td>
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
<script type="text/javascript">
    bindData();

    function getQueryParams() {
        queryParams = {
            transportTypeName: $("#s_transportTypeName").val()
        };
        return queryParams;
    }

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/transportType/listTransportType";
        title = "运输方式管理";
        queryParams = getQueryParams();
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
                {title: '运输方式', field: 'transportTypeName', width: 120},
                {title: '排序', field: 'sort', width: 60},
                {title: '备注', field: 'remark', width: 200}
            ]],
            toolbar: [{
                id: 'btnAdd',
                text: '添加',
                iconCls: 'icon-add',
                handler: function () {
                    showAddDialog();//实现添加记录的页面
                }
            }, '-', {
                id: 'btnEdit',
                text: '修改',
                iconCls: 'icon-edit',
                handler: function () {
                    showEditDialog();//实现修改记录的方法
                }
            }, '-', {
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
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function showAddDialog() {
        $('#dlg').dialog('open').dialog('setTitle', '添加');
        $('#frm').form('clear');
        $("#btn_save").show();
    }

    function showEditDialog() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $('#dlg').dialog('open').dialog('setTitle', '修改');
            $('#frm').form('load', rows[0]);
            $("#btn_save").show();
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function save() {
        var transportTypeName = $("div#dlg input[name='transportTypeName']").val();
        if (transportTypeName == '') {
            $.messager.alert("提示", '请填写运输渠道');
            return;
        }
        var sort = $("div#dlg input[name='sort']").val();
        if (sort == '') {
            $.messager.alert("提示", '请填写排序');
            return;
        }
        $('#frm').form('submit', {
            url: '${pageContext.request.contextPath }/transportType/saveTransportType',
            onSubmit: function () {
                var validate = $(this).form('validate');
                return validate;
            },
            success: function (data) {
                res = eval('(' + data + ')');
                if (res.code == '200') {
                    closeDialog();
                    bindData();
                }
                else {
                    $.messager.alert("提示", res.message);
                }
            }
        });
    }

    function closeDialog() {
        $('#dlg').dialog('close');
    }
</script>
</html>
