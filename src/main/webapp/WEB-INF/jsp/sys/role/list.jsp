<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2019/6/21
  Time: 8:50
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

    <title>角色管理</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
</div>
<table id="dg" style="width: 100%; height: auto">

</table>

<!--编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 500px; height: 280px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:50,align:'center'">
    <div class="ftitle">
        <b>角色信息</b>
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
                <td>角色名：</td>
                <td colspan="3">
                    <input class="easyui-textbox" type="text" name="roleName" style="width: 90%"
                           data-options="required:true">
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
            <tr>
                <td>备注:</td>
                <td colspan="3">
                    <input class="easyui-textbox" type="text" name="remark" style="width: 90%">
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
<!--角色菜单管理-->
<div id="dlgRoleMenu" class="easyui-dialog" style="width: 500px; height: 700px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:55,align:'center'">
    <input type="hidden" id="roleMenuRoleId">
    <ul id="menuTree"></ul>
    <div style="text-align:center;">
        <a href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-ok'" id="btn_save_role_menu" onclick="saveRoleMenuRight()">确定</a>
        <a href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-cancel'" onclick="closeDialogRoleMenu()">关闭</a>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        bindData();
    });

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/role/list";
        title = "角色管理";
        queryParams = {};
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
            idField: 'userId',
            queryParams: queryParams,  //异步查询的参数
            columns: [[
                {field: 'ck', checkbox: true},   //选择
                {title: '角色', field: 'roleName', width: 100},
                {title: '创建时间', field: 'createTime', width: 180},
                {title: '修改时间', field: 'updateTime', width: 180},
                {title: '备注', field: 'remark', width: 300}
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
                id: 'btnRoleMenu',
                text: '角色菜单权限管理',
                iconCls: 'icon-edit',
                handler: function () {
                    showRoleMenuDialog();//实现修改记录的方法
                }
            }, '-', {
                id: 'btnDelete',
                text: '删除',
                iconCls: 'icon-remove',
                handler: function () {
                    deleteInfo();//实现直接删除数据的方法
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

    function showAddDialog() {
        $('#dlg').dialog('open').dialog('setTitle', '添加');
        $('#frm').form('clear');
        $("#btn_save").show();
        $(".view_hide").hide();
    }

    function save() {
        //防止重复点击
        var roleName = $("div#dlg input[name='roleName']").val();
        if (roleName == '') {
            $.messager.alert("提示", '请填写角色名');
            return;
        }
        $('#frm').form('submit', {
            url: '${pageContext.request.contextPath }/role/save',
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

    function showRoleMenuDialog() {
        var rows = $('#dg').datagrid('getSelections');
        if (!rows || rows.length != 1) {
            $.messager.alert("提示", "请选择一条记录.");
            return;
        }
        $('#roleMenuRoleId').val(rows[0].id);
        $('#dlgRoleMenu').dialog('open').dialog('setTitle', '角色菜单权限管理');
        bindMenuTree();
    }

    function bindMenuTree() {
        $("#menuTree").tree({
            checkbox: true,
            cascadeCheck: false,
            url: "${pageContext.request.contextPath }/menu/menuRightTree",
            onLoadSuccess: function (data) {
                checkMenuTree();
                checkRightTree();
            }
        });
    }

    function checkMenuTree() {
        var roleId = $('#roleMenuRoleId').val();
        $.post('${pageContext.request.contextPath }/roleMenu/roleMenuList', {roleId: roleId}, function (data) {
            if (data.code == '200') {
                for (var i = 0; i < data.data.length; i++) {
                    var node = $('#menuTree').tree('find', "menu," + data.data[i].menuId);
                    if (node) {
                        $("#menuTree").tree("check", node.target);
                    }
                }
            }
            else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function checkRightTree() {
        var roleId = $('#roleMenuRoleId').val();
        $.post('${pageContext.request.contextPath }/roleRight/roleRightList', {roleId: roleId}, function (data) {
            if (data.code == '200') {
                for (var i = 0; i < data.data.length; i++) {
                    var node = $('#menuTree').tree('find', "right," + data.data[i].rightId);
                    if (node) {
                        $("#menuTree").tree("check", node.target);
                    }
                }
            }
            else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function deleteInfo() {
        //防止重复点击
        var rows = $('#dg').datagrid('getSelections');
        if (!rows || rows.length != 1) {
            $.messager.alert("提示", "请选择一条记录.");
            return;
        }
        $.messager.confirm('提示', '确认删除这条数据吗？删除时会删除对应用户的角色', function (r) {
            if (r) {
                var id = rows[0].id;
                $.post('${pageContext.request.contextPath }/role/delete', {id: id}, function (data) {
                    if (data.code == '200') {
                        $('#dlg').dialog('close');
                        bindData();
                    }
                    else {
                        $.messager.alert("提示", data.message);
                    }
                });
            }
        });
    }

    function closeDialogRoleMenu() {
        $('#dlgRoleMenu').dialog('close');
    }

    function saveRoleMenuRight() {
        var roleId = $('#roleMenuRoleId').val();
        var nodes = $('#menuTree').tree('getChecked');
        var menuRightIds = new Array();
        for (var i = 0; i < nodes.length; i++) {
            menuRightIds.push(nodes[i].id);
        }
        $.post('${pageContext.request.contextPath }/roleMenu/saveRoleMenuRight', {
            roleId: roleId,
            menuRightIds: menuRightIds
        }, function (data) {
            if (data.code == '200') {
                closeDialogRoleMenu();
            }
            else {
                $.messager.alert("提示", data.message);
            }
        });
    }
</script>
</body>
</html>
