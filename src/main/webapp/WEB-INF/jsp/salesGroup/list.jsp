<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/27
  Time: 10:24
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
    <title>销售分组管理</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    分组名称：
    <input class="easyui-validatebox textbox" id="s_groupName">
    用户
    <select class="easyui-combobox" id="s_userId" style="width:100px;">
    </select>
    状态：
    <select class="easyui-combobox" id="s_status" style="width:100px;">
        <option value="">全部</option>
        <option value="1">启用</option>
        <option value="0">停用</option>
    </select>
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
</div>
<table id="dg" style="width: 100%; height: auto">

</table>
<!--编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 700px; height: 600px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons'">
    <div class="ftitle">
        <b>销售分组管理</b>
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
                <td>分组名称：</td>
                <td>
                    <input class="easyui-textbox textbox-wide" type="text" name="groupName"
                           data-options="required:true">
                </td>
            </tr>
            <tr>
                <td>状态：</td>
                <td>

                    <select class="easyui-combobox" id="status" name="status" style="width:100px;"
                            data-options="required:true">
                        <option value="1">启用</option>
                        <option value="0">停用</option>
                    </select>
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
<!--编辑页面-->
<div id="dlgUserMain" class="easyui-dialog" style="width: 700px; height: 600px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:55,align:'center'">
    <div class="ftitle">
        <b>销售用户管理</b>
        <hr/>
    </div>
    <!--查询条件-->
    <div class="easyui-panel">
        <input type="hidden" id="s_salesGroupId">
        <a href="javascript:void(0)" onclick="bindDataUser()" class="easyui-linkbutton"
           data-options="iconCls:'icon-search'"
           style="width: 80px">查 询</a>
    </div>
    <table id="dgUser" style="width: 100%; height: auto">

    </table>
    <!--编辑页面-->
    <div id="dlgUser" class="easyui-dialog" style="width: 700px; height: 300px; padding: 10px 20px"
         data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:55,align:'center'">
        <div class="ftitle">
            <b>分组用户管理</b>
            <hr/>
        </div>
        <form id="frmUser" method="post" novalidate="novalidate">
            <table>
                <tr style="display: none">
                    <td>id：</td>
                    <td>
                        <input class="easyui-validatebox textbox" name="id">
                        <input class="easyui-validatebox textbox" name="salesGroupId" id="salesGroupId">
                    </td>
                </tr>
                <tr>
                    <td>用户：</td>
                    <td>

                        <select class="easyui-combobox" id="userId" name="userId" style="width:100px;"
                                data-options="required:true">
                        </select>
                    </td>
                </tr>
            </table>
            <div style="text-align:center;">
                <a href="javascript:void(0)" class="easyui-linkbutton"
                   data-options="iconCls:'icon-ok'" id="btn_saveUser" onclick="saveUser()">确定</a>
                <a href="javascript:void(0)" class="easyui-linkbutton"
                   data-options="iconCls:'icon-cancel'" onclick="closeDialogUser()">关闭</a>
            </div>
        </form>
    </div>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        bindUserId();
        bindData();
    });

    function bindUserId() {
        $.post('${pageContext.request.contextPath }/user/comboboxlist', {}, function (data) {
            $('#s_userId').combobox({
                data: data,
                valueField: 'userId',
                textField: 'realName'
            });
            $('#userId').combobox({
                data: data,
                valueField: 'userId',
                textField: 'realName'
            });
        });
    }

    function getQueryParams() {
        queryParams = {
            groupName: $('#s_groupName').val(),
            userId: $("#s_userId").val(),
            status: $("#s_status").val()
        };
        return queryParams;
    }

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/salesGroup/listSalesGroup";
        title = "销售分组管理";
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
            singleSelect: true,
            pageSize: 15,
            pageList: [10, 15, 20, 30, 50],
            rownumbers: true,
            //sortName: 'ID',    //根据某个字段给easyUI排序
            //sortOrder: 'asc',
            remoteSort: false,
            idField: 'shopSkuId',
            queryParams: queryParams,  //异步查询的参数
            columns: [[
                {field: 'ck', checkbox: true},   //选择
                {title: '分组名称', field: 'groupName', width: 120},
                {title: '用户', field: 'realNames', width: 500},
                {title: '创建时间', field: 'createTime', width: 170},
                {title: '修改时间', field: 'updateTime', width: 170},
                {title: '备注', field: 'remark', width: 120},
                {
                    title: '状态', field: 'status', width: 50,
                    formatter: function (value, rowData, rowIndex) {
                        if (value == null) {
                            return '';
                        }
                        if (value == 1) {
                            return '启用';
                        } else if (value == 0) {
                            return '停用';
                        }
                    }
                }
            ]],
            toolbar: [{
                id: 'btnAdd',
                text: '添加',
                iconCls: 'icon-add',
                handler: function () {
                    showAddDialog();//实现添加记录的页面
                }
            }, '-', {
                id: 'btnView',
                text: '查看',
                iconCls: 'icon-search',
                handler: function () {
                    showViewDialog();//实现查看记录详细信息的方法
                }
            }, '-', {
                id: 'btnEdit',
                text: '修改',
                iconCls: 'icon-edit',
                handler: function () {
                    showEditDialog();//实现修改记录的方法
                }
            }, '-', {
                id: 'btnEditUser',
                text: '修改用户',
                iconCls: 'icon-edit',
                handler: function () {
                    showEditUserDialog();//实现修改记录的方法
                }
            }, '-', {
                id: 'btnDelete',
                text: '停用',
                iconCls: 'icon-remove',
                handler: function () {
                    deleteInfo();//实现直接删除数据的方法
                }
            },
                '-', {
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

    function showEditDialog() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $('#dlg').dialog('open').dialog('setTitle', '修改');
            $('#frm').form('load', rows[0]);
            $("#btn_save").show();
            $(".view_hide").hide();
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function showAddDialog() {
        $('#dlg').dialog('open').dialog('setTitle', '添加');
        $('#frm').form('clear');
        $("#btn_save").show();
        $(".view_hide").hide();
    }

    function showViewDialog() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $('#dlg').dialog('open').dialog('setTitle', '查看');
            $('#frm').form('load', rows[0]);
            $("#btn_save").hide();
            $(".view_hide").show();
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function save() {
        //防止重复点击
        var groupName = $("div#dlg input[name='groupName']").val();
        if (title == '') {
            $.messager.alert("提示", '请填写分组名称');
            return;
        }
        var status = $("div#dlg input[name='status']").val();
        if (status == '') {
            $.messager.alert("提示", '请填写状态');
            return;
        }
        $('#frm').form('submit', {
            url: '${pageContext.request.contextPath }/salesGroup/saveSalesGroup',
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

    function deleteInfo() {
        //防止重复点击
        var rows = $('#dg').datagrid('getSelections');
        if (!rows || rows.length == 0) {
            $.messager.alert("提示", "请选择要停用的数据.");
            return;
        }
        $.messager.confirm('提示', '确认停用这条数据吗？', function (r) {
            if (r) {
                $.post('${pageContext.request.contextPath }/salesGroup/deleteSalesGroup', {id: rows[o].id}, function (data) {
                    if (data.code == '200') {
                        bindData();
                    } else {
                        $.messager.alert("提示", data.message);
                    }
                });
            }
        });
    }

    function showEditUserDialog() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $('#dlgUserMain').dialog('open').dialog('setTitle', '销售用户管理');
            $("#s_salesGroupId").val(rows[0].id);
            bindDataUser();
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }


    function bindDataUser() {
        dg = '#dgUser';
        url = "${pageContext.request.contextPath }/salesGroupUser/listSalesGroupUser";
        title = "分组用户管理";
        $(dg).datagrid({   //定位到Table标签，Table标签的ID是grid
            url: url,   //指向后台的Action来获取当前菜单的信息的Json格式的数据
            title: title,
            iconCls: 'icon-view',
            nowrap: true,
            autoRowHeight: true,
            striped: true,
            collapsible: true,
            pagination: true,
            singleSelect: true,
            pageSize: 15,
            pageList: [10, 15, 20, 30, 50],
            rownumbers: true,
            //sortName: 'ID',    //根据某个字段给easyUI排序
            //sortOrder: 'asc',
            remoteSort: false,
            idField: 'shopSkuId',
            queryParams: {salesGroupId: $("#s_salesGroupId").val()},  //异步查询的参数
            columns: [[
                {field: 'ck', checkbox: true},   //选择
                {title: '分组名称', field: 'groupName', width: 120},
                {title: '用户名', field: 'realName', width: 120}
            ]],
            toolbar: [{
                id: 'btnAdd',
                text: '添加',
                iconCls: 'icon-add',
                handler: function () {
                    showAddUserDialog();//实现添加记录的页面
                }
            }, '-', {
                id: 'btnDelete',
                text: '删除',
                iconCls: 'icon-remove',
                handler: function () {
                    deleteUserInfo();//实现直接删除数据的方法
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

    function showAddUserDialog() {
        $("#salesGroupId").val($("#s_salesGroupId").val());
        $('#dlgUser').dialog('open').dialog('setTitle', '添加');
        $('#frm').form('clear');
        $("#btn_saveUser").show();
        $(".view_hide").hide();
    }

    function saveUser() {
        $('#frmUser').form('submit', {
            url: '${pageContext.request.contextPath }/salesGroupUser/saveSalesGroupUser',
            onSubmit: function () {
                var validate = $(this).form('validate');
                return validate;
            },
            success: function (data) {
                res = eval('(' + data + ')');
                if (res.code == '200') {
                    closeDialogUser();
                    bindDataUser();
                    bindData();
                } else {
                    $.messager.alert("提示", res.message);
                }
            }
        });
    }

    function deleteUserInfo() {
        //防止重复点击
        var rows = $('#dgUser').datagrid('getSelections');
        if (!rows || rows.length == 0) {
            $.messager.alert("提示", "请选择要停用的数据.");
            return;
        }
        $.messager.confirm('提示', '确认停用这条数据吗？', function (r) {
            if (r) {
                $.post('${pageContext.request.contextPath }/salesGroupUser/deleteSalesGroupUser', {id: rows[0].id}, function (data) {
                    if (data.code == '200') {
                        $('#dlgUser').dialog('close');
                        bindDataUser();
                        bindData();
                    } else {
                        $.messager.alert("提示", data.message);
                    }
                });
            }
        });
    }

    function closeDialogUser() {
        $('#dlgUser').dialog('close');
    }
</script>
</html>
