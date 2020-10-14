<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/11
  Time: 16:16
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

    <title>用户列表</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    用户名：
    <input class="easyui-validatebox textbox" id="s_userName">
    手机号：
    <input class="easyui-validatebox textbox" id="s_mobile">
    真实姓名：
    <input class="easyui-validatebox textbox" id="s_realName">
    性别：<select class="easyui-combobox" id="s_gender" style="width:100px;">
    <option value="">全部</option>
    <option value="1">男</option>
    <option value="2">女</option>
    <option value="3">保密</option>
</select>
    邮箱：
    <input class="easyui-validatebox textbox" id="s_email">
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
<div id="dlg" class="easyui-dialog" style="width: 600px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
    <div class="ftitle">
        <b>用户信息</b>
        <hr/>
    </div>
    <form id="frm" method="post" novalidate="novalidate">
        <table>
            <tr style="display: none">
                <td>userId：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="userId">
                </td>
            </tr>
            <tr>
                <td>用户名：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="userName" data-options="required:true">
                </td>
                <td>电话号码：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="mobile" data-options="required:true">
                </td>
            </tr>
            <tr>
                <td>真实姓名：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="realName" data-options="required:true">
                </td>
                <td>性别：</td>
                <td>
                    <select class="easyui-combobox" name="gender" style="width:100px;" data-options="required:true">
                        <option value="1">男</option>
                        <option value="2">女</option>
                        <option value="3">保密</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>email：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="email">
                </td>
                <td>状态：</td>
                <td>
                    <select class="easyui-combobox" name="status" style="width:100px;" data-options="required:true">
                        <option value="1">启用</option>
                        <option value="0">停用</option>
                    </select>
                </td>
            </tr>
            <tr class="view_hide">
                <td>登录次数：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="loginTimes">
                </td>
                <td>最后登录时间：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="lastLoginTime">
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
<!--重置用户密码-->
<div id="dlgResetPassword" class="easyui-dialog" style="width: 600px; height: 300px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true,  align:'center'">
    <div class="ftitle">
        <b>重置用户密码</b>
        <hr/>
    </div>
    <form id="frmResetPassword" method="post" novalidate="novalidate">
        <table>
            <tr style="display: none">
                <td>userId：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="userId">
                </td>
            </tr>
            <tr>
                <td>用户名：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="userName" readonly="readonly">
                </td>
                <td>真实姓名：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="realName" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>新密码：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="newPassword" data-options="required:true">
                </td>
            </tr>
        </table>
        <div style="text-align:center;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" id="btn_reset_password" onclick="saveResetPassword()">确定</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-cancel'" onclick="closeResetPasswordDialog()">关闭</a>
        </div>
    </form>
</div>
<!--角色页面-->
<div id="dlgUserRole" class="easyui-dialog" style="width: 600px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, align:'center'">
    <div class="ftitle">
        <b>用户角色</b>
        <hr/>
    </div>
    <input type="hidden" id="userRole_userId">
    <!--用户角色-->
    <table id="dgUserRole" style="width: 100%; height: auto">

    </table>
    <!--添加角色-->
    <div id="dlgAddUserRole" class="easyui-dialog" style="width: 300px; height: 200px; padding: 10px 20px"
         data-options="closed:true, resizable:true, modal:true, align:'center'">

        <select id="s_roleId" style="width:150px;" class="easyui-combobox">
        </select>
        <div style="text-align:center;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" id="btn_save_userRole" onclick="saveUserRole()">确定</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-cancel'" onclick="closeAddUserRoleDialog()">关闭</a>
        </div>
    </div>
    <div style="text-align:center;">
        <a href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-cancel'" onclick="closeUserRoleDialog()">关闭</a>
    </div>
</div>
<script type="text/javascript">
    bindData();

    function bindRole() {
        $('#s_roleId').combobox({
            valueField: 'id',
            textField: 'roleName',
            url: "${pageContext.request.contextPath }/role/comboboxlist"//获取数据
        });
    }

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/user/list";
        title = "用户管理";
        queryParams = {
            userName: $("#s_userName").val(),
            mobile: $("#s_mobile").val(),
            realName: $("#s_realName").val(),
            gender: $("#s_gender").val(),
            email: $("#s_email").val(),
            status: $("#s_status").val()
        };
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
                {title: '用户名', field: 'userName', width: 100},
                {title: '电话号码', field: 'mobile', width: 100},
                {title: '姓名', field: 'realName', width: 200},
                {title: '用户角色', field: 'roleNames', width: 200},
                {
                    title: '性别', field: 'gender', width: 50,
                    formatter: function (value, rowData, rowIndex) {
                        if (value == null) {
                            return '';
                        }
                        if (value == 1) {
                            return '男';
                        } else if (value == 2) {
                            return '女';
                        } else if (value == 3) {
                            return '保密';
                        }
                    }
                },
                {title: '邮箱', field: 'email', width: 100},
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
                },
                {title: '登录次数', field: 'loginTimes', width: 80},
                {title: '最后登录时间', field: 'lastLoginTime', width: 180},
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
                id: 'btnUserRole',
                text: '角色',
                iconCls: 'icon-edit',
                handler: function () {
                    showUserRoleDialog();//实现修改记录的方法
                }
            }, '-', {
                id: 'btnResetPassword',
                text: '重置密码',
                iconCls: 'icon-edit',
                handler: function () {
                    showResetPasswordDialog();//实现修改记录的方法
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

    function bindUserRoleData() {
        dg = '#dgUserRole';
        url = "${pageContext.request.contextPath }/userRole/getUserRoles";
        title = "用户管理";
        queryParams = {
            userId: $("#userRole_userId").val()
        };
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
            remoteSort: false,
            queryParams: queryParams,  //异步查询的参数
            columns: [[
                {field: 'ck', checkbox: true},   //选择
                {title: '角色名', field: 'roleName', width: 100}
            ]],
            toolbar: [{
                id: 'btnAddUserRole',
                text: '添加',
                iconCls: 'icon-add',
                handler: function () {
                    showAddUserRoleDialog();//实现添加记录的页面
                }
            }, '-', {
                id: 'btnDeleteUserRole',
                text: '删除',
                iconCls: 'icon-remove',
                handler: function () {
                    deleteUserRole();//实现直接删除数据的方法
                }
            }, '-', {
                id: 'btnReloadUserRole',
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
    function showResetPasswordDialog() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $('#dlgResetPassword').dialog('open').dialog('setTitle', '重置用户密码');
            $('#frmResetPassword').form('load', rows[0]);
            $("div#dlg input[name='newPassword']").val('');
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function showUserRoleDialog() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $('#userRole_userId').val(rows[0].userId);
            closeAddUserRoleDialog();
            $('#dlgUserRole').dialog('open').dialog('setTitle', '用户角色');
            bindUserRoleData();
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function showAddUserRoleDialog() {
        bindRole();
        $('#dlgAddUserRole').dialog('open').dialog('setTitle', '添加用户角色');
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

    function showAddDialog() {
        $('#dlg').dialog('open').dialog('setTitle', '添加（新增用户默认密码为123）');
        $('#frm').form('clear');
        $("#btn_save").show();
        $(".view_hide").hide();
    }

    function saveUserRole() {
        userId = $("#userRole_userId").val();
        roleId = $("#s_roleId").combobox('getValue');
        if(userId==''){
            $.messager.alert("提示", '请选择用户');
            return;
        }
        if(roleId==''){
            $.messager.alert("提示", '请选择角色');
            return;
        }
        $.post('${pageContext.request.contextPath }/userRole/save', {userId: userId,roleId:roleId}, function (data) {
            if (data.code == '200') {
                closeAddUserRoleDialog();
                bindUserRoleData();
            }
            else {
                $.messager.alert("提示", data.message);
            }
        });
    }
    function saveResetPassword() {
        //防止重复点击
        var newPassword = $("div#dlg input[name='newPassword']").val();
        if (newPassword == '') {
            $.messager.alert("提示", '请填写新密码');
            return;
        }
        $('#frmResetPassword').form('submit', {
            url: '${pageContext.request.contextPath }/account/resetPassword',
            onSubmit: function () {
                var validate = $(this).form('validate');
                return validate;
            },
            success: function (data) {
                res = eval('(' + data + ')');
                if (res.code == '200') {
                    closeResetPasswordDialog();
                }
                else {
                    $.messager.alert("提示", res.message);
                }
            }
        });
    }
    function closeResetPasswordDialog() {
        $('#dlgResetPassword').dialog('close');
    }
    function save() {
        //防止重复点击
        var userName = $("div#dlg input[name='userName']").val();
        if (userName == '') {
            $.messager.alert("提示", '请填写用户名');
            return;
        }
        var mobile = $("div#dlg input[name='mobile']").val();
        if (mobile == '') {
            $.messager.alert("提示", '请填写手机号码');
            return;
        }
        var realName = $("div#dlg input[name='realName']").val();
        if (realName == '') {
            $.messager.alert("提示", '请填写真实姓名');
            return;
        }
        var gender = $("div#dlg input[name='gender']").val();
        if (gender == '') {
            $.messager.alert("提示", '请选择性别');
            return;
        }
        var status = $("div#dlg input[name='status']").val();
        if (status == '') {
            $.messager.alert("提示", '请选择状态');
            return;
        }

        $('#frm').form('submit', {
            url: '${pageContext.request.contextPath }/user/save',
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

    function deleteInfo() {
        //防止重复点击
        var rows = $('#dg').datagrid('getSelections');
        if (!rows || rows.length == 0) {
            $.messager.alert("提示", "请选择要删除的数据.");
            return;
        }
        $.messager.confirm('提示', '确认删除这' + rows.length + '条数据吗？', function (r) {
            if (r) {
                var userIds = new Array();
                for (var i = 0; i < rows.length; i++) {
                    userIds.push(rows[i].userId);
                }
                $.post('${pageContext.request.contextPath }/user/delete', {userIds: userIds}, function (data) {
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

    function deleteUserRole() {
        var rows = $('#dgUserRole').datagrid('getSelections');
        if (!rows || rows.length == 0) {
            $.messager.alert("提示", "请选择要删除的数据.");
            return;
        }
        $.messager.confirm('提示', '确认删除这' + rows.length + '条数据吗？', function (r) {
            if (r) {
                var ids = new Array();
                for (var i = 0; i < rows.length; i++) {
                    ids.push(rows[i].id);
                }
                $.post('${pageContext.request.contextPath }/userRole/delete', {ids: ids}, function (data) {
                    if (data.code == '200') {
                        $('#dlg').dialog('close');
                        bindUserRoleData();
                    }
                    else {
                        $.messager.alert("提示", data.message);
                    }
                });
            }
        });
    }

    function closeUserRoleDialog() {
        $('#dlgUserRole').dialog('close');
    }

    function closeAddUserRoleDialog() {
        $('#dlgAddUserRole').dialog('close');
    }
</script>
</body>
</html>
