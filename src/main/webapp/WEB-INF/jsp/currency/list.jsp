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
    <title>货币类型管理</title>
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
    货币名称：
    <input class="easyui-validatebox textbox" id="s_currencyName">
    货币编码：
    <input class="easyui-validatebox textbox" id="s_currencyCode">
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
</div>
<table id="dg" style="width: 100%; height: auto">

</table>
<!--编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 700px; height: 400px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
    <div class="ftitle">
        <b>货币类型管理</b>
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
                <td>货币名称：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="currencyName"
                           data-options="required:true">
                </td>
                <td>货币编码：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="currencyCode"
                           data-options="required:true">
                </td>
            </tr>
            <tr>
                <td>汇率：</td>
                <td>
                    <input class="easyui-numberbox" data-options="precision:2,min:0.01,max:10000,required:true"
                           name="exchangeRate"></input>
                </td>
            </tr>
            <tr>
                <td>备注：</td>
                <td>
                    <input class="easyui-textbox textbox-wide" type="text" name="remark">
                </td>
            </tr>
            <tr class="view_show">
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
<script type="text/javascript">
    bindData();

    function getQueryParams() {
        queryParams = {
            currencyName: $("#s_currencyName").val(),
            currencyCode: $("#s_currencyCode").val()
        };
        return queryParams;
    }

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/currency/listCurrency";
        title = "货币管理";
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
                {title: '货币名称', field: 'currencyName', width: 120},
                {title: '货币编码', field: 'currencyCode', width: 60},
                {title: '汇率', field: 'exchangeRate', width: 60},
                {title: '备注', field: 'remark', width: 200},
                {title: '创建时间', field: 'createTime', width: 120},
                {title: '修改时间', field: 'updateTime', width: 120}
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
            $(".view_show").show();
            $("#btn_save").hide();
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function showAddDialog() {
        $('#dlg').dialog('open').dialog('setTitle', '添加');
        $('#frm').form('clear');
        $(".view_show").hide();
        $("#btn_save").show();
    }

    function showEditDialog() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $('#dlg').dialog('open').dialog('setTitle', '修改');
            $('#frm').form('load', rows[0]);
            $(".view_show").hide();
            $("#btn_save").show();
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function save() {
        var currencyName = $("div#dlg input[name='currencyName']").val();
        if (currencyName == '') {
            $.messager.alert("提示", '请填写货币名称');
            return;
        }
        var currencyCode = $("div#dlg input[name='currencyCode']").val();
        if (currencyCode == '') {
            $.messager.alert("提示", '请填写货币编码');
            return;
        }

        var exchangeRate = $("div#dlg input[name='exchangeRate']").val();
        if (exchangeRate == '') {
            $.messager.alert("提示", '请填写汇率');
            return;
        }
        $('#frm').form('submit', {
            url: '${pageContext.request.contextPath }/currency/saveCurrency',
            onSubmit: function () {
                var validate = $(this).form('validate');
                return validate;
            },
            success: function (data) {
                res = eval('(' + data + ')');
                if (res.code == '200') {
                    closeDialog();
                    bindData();
                } else {
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
