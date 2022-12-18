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
    <title>任务创建管理</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    <!--只显示用户有的店铺-->
    标题：
    <input class="easyui-validatebox textbox" name="s_title">
    </select>
    状态：
    <select class="easyui-combobox" id="s_status" style="width:100px;">
        <option value="">全部</option>
        <option value="0">取消</option>
        <option value="1">进行中</option>
    </select>
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
</div>
<!--列表-->
<table id="dg" style="width: 100%; height: auto">

</table>
<!--编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 700px; height: 600px; padding: 10px 20px"
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
                    <input class="easyui-validatebox textbox" name="title" style="width: 90%"
                           data-options="required:true">
                </td>
            </tr>
            <tr>
                <td>内容：</td>
                <td colspan="3">
                    <input class="easyui-textbox" data-options="multiline:true,required:true" name="content"
                           style="width: 90%;height:200px">
                </td>
            </tr>
            <tr>
                <td>处理级别：</td>
                <td>
                    <select class="easyui-combobox" name="level" style="width:100px;" data-options="required:true">
                        <option value="1">紧急</option>
                        <option value="2">普通</option>
                        <option value="3">不急</option>
                    </select>
                </td>
                <td>类型：</td>
                <td>
                    <select class="easyui-combobox" name="type" id="sType" style="width:100px;"
                            data-options="required:true">
                        <option value="1">每周</option>
                        <option value="2">每月</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <input type="hidden" name="dayNums">
                    <div id="div_day_nums_week" style="display: none">
                        <input type="checkbox" name="week" value="1"/>周一
                        <input type="checkbox" name="week" value="2"/>周二
                        <input type="checkbox" name="week" value="3"/>周三
                        <input type="checkbox" name="week" value="4"/>周四
                        <input type="checkbox" name="week" value="5"/>周五
                        <input type="checkbox" name="week" value="6"/>周六
                        <input type="checkbox" name="week" value="0"/>周日
                    </div>
                    <div id="div_day_nums_month" style="display: none">
                        <input type='checkbox' name='month' value='1'/>1
                        <input type='checkbox' name='month' value='2'/>2
                        <input type='checkbox' name='month' value='3'/>3
                        <input type='checkbox' name='month' value='4'/>4
                        <input type='checkbox' name='month' value='5'/>5
                        <input type='checkbox' name='month' value='6'/>6
                        <input type='checkbox' name='month' value='7'/>7
                        <input type='checkbox' name='month' value='8'/>8
                        <input type='checkbox' name='month' value='9'/>9
                        <input type='checkbox' name='month' value='10'/>10
                        <input type='checkbox' name='month' value='11'/>11
                        <input type='checkbox' name='month' value='12'/>12
                        <input type='checkbox' name='month' value='13'/>13
                        <input type='checkbox' name='month' value='14'/>14
                        <input type='checkbox' name='month' value='15'/>15
                        <input type='checkbox' name='month' value='16'/>16
                        <input type='checkbox' name='month' value='17'/>17
                        <input type='checkbox' name='month' value='18'/>18
                        <input type='checkbox' name='month' value='19'/>19
                        <input type='checkbox' name='month' value='20'/>20
                        <input type='checkbox' name='month' value='21'/>21
                        <input type='checkbox' name='month' value='22'/>22
                        <input type='checkbox' name='month' value='23'/>23
                        <input type='checkbox' name='month' value='24'/>24
                        <input type='checkbox' name='month' value='25'/>25
                        <input type='checkbox' name='month' value='26'/>26
                        <input type='checkbox' name='month' value='27'/>27
                        <input type='checkbox' name='month' value='28'/>28
                        <input type='checkbox' name='month' value='29'/>29
                        <input type='checkbox' name='month' value='30'/>30
                        <input type='checkbox' name='month' value='31'/>31
                    </div>
                </td>
            </tr>
            <tr>
                <td>是否需要审核：</td>
                <td>
                    <select class="easyui-combobox" name="needAudit" style="width:100px;" data-options="required:true">
                        <option value="1">需要</option>
                        <option value="0">不需要</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>计划开始时间：</td>
                <td>
                    <input class="easyui-datebox" type="text" name="beginTime" data-options="required:true">
                </td>
                <td>计划结束时间：</td>
                <td>
                    <input class="easyui-datebox" type="text" name="endTime" data-options="required:true">
                </td>
            </tr>
            <tr class="view_status">
                <td>负责人：</td>
                <td colspan="3">
                    <input class="easyui-textbox" type="text" name="chargeUserRealNames"
                           data-options="multiline:true"
                           style="width: 90%;height:50px">
                </td>
            </tr>
            <tr class="view_status">
                <td>状态：</td>
                <td>
                    <select class="easyui-combobox" name="status" style="width:100px;">
                        <option value="1">进行中</option>
                        <option value="0">取消</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>备注：</td>
                <td colspan="3">
                    <input class="easyui-textbox" type="text" name="remark" data-options="multiline:true"
                           style="width: 90%;height:50px">
                </td>
            </tr>
            <tr class="view_hide">
                <td>最近生成时间：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="dealTime"></td>
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

<!--角色菜单管理-->
<div id="dlgChargeUser" class="easyui-dialog" style="width: 500px; height: 700px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:55,align:'center'">
    <input type="hidden" id="workTaskCreationId">
    <ul id="userTree"></ul>
    <div style="text-align:center;">
        <a href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-ok'" id="btn_save_charge_user" onclick="saveChargeUser()">确定</a>
        <a href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-cancel'" onclick="closeDlgChargeUser()">关闭</a>
    </div>
</div>

<!--任务管理角色管理-->
<div id="dlgChargeRole" class="easyui-dialog" style="width: 500px; height: 700px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:55,align:'center'">
    <ul id="roleTree"></ul>
    <div style="text-align:center;">
        <a href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-ok'" id="btn_save_charge_role" onclick="saveChargeRole()">确定</a>
        <a href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-cancel'" onclick="closeDlgChargeRole()">关闭</a>
    </div>
</div>


</body>
<script type="text/javascript">
    $(document).ready(function () {
        bindData();
        $('#sType').combobox({
            onChange: function (newValue, oldValue) {
                changeType(newValue);
            }
        });
    });

    function bindUserId() {
        $.post('${pageContext.request.contextPath }/user/comboboxlist?status=1', {}, function (data) {
            $('#s_chargeUserId').combobox({
                data: data,
                valueField: 'userId',
                textField: 'realName'
            });
        });
    }

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/workTaskCreation/listWorkTaskCreation";
        title = "任务生成管理";
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
                idField: 'id',
                queryParams: queryParams,  //异步查询的参数
                columns: [[
                    {field: 'ck', checkbox: true},   //选择
                    {title: '标题', field: 'title', width: 200},
                    {
                        title: '等级', field: 'level', width: 50, formatter: function (value, row, index) {
                            if (value == 1) {
                                return "紧急";
                            } else if (value == 2) {
                                return "普通";
                            } else if (value == 3) {
                                return "不急";
                            }

                        }
                    },
                    {
                        title: '状态', field: 'status', width: 50, formatter: function (value, row, index) {
                            if (value == 0) {
                                return "待处理";
                            } else if (value == 1) {
                                return "进行中";
                            } else if (value == 2) {
                                return "已完成";
                            } else if (value == 3) {
                                return "取消";
                            }

                        }
                    },
                    {
                        title: '类型', field: 'type', width: 50, formatter: function (value, row, index) {
                            if (value == 1) {
                                return "每周";
                            } else if (value == 2) {
                                return "每月";
                            }
                        }
                    },
                    {title: '时间', field: 'dayNums', width: 100},
                    {
                        title: '负责人', field: 'chargeUserRealNames', width: 200, formatter: function (value, row, index) {
                            if (isEmpty(value)) {
                                var content = '<a href="javascript:void(0)" onclick="showDlgChargeUser(' + row.id + ')" class="easyui-linkbutton" >暂无负责人</a>';
                                return content;
                            } else {
                                var content = '<a href="javascript:void(0)" onclick="showDlgChargeUser(' + row.id + ')" class="easyui-linkbutton" >' + value + '</a>';
                                return content;
                            }
                        }
                    },
                    {
                        title: '负责角色', field: 'chargeRoleNames', width: 200, formatter: function (value, row, index) {
                            if (isEmpty(value)) {
                                var content = '<a href="javascript:void(0)" onclick="showDlgChargeRole(' + row.id + ')" class="easyui-linkbutton" >暂无负责角色</a>';
                                return content;
                            } else {
                                var content = '<a href="javascript:void(0)" onclick="showDlgChargeRole(' + row.id + ')" class="easyui-linkbutton" >' + value + '</a>';
                                return content;
                            }
                        }
                    },
                    {title: '开始时间', field: 'beginTime', width: 150},
                    {title: '结束时间', field: 'endTime', width: 150},
                    {title: '最近生成时间', field: 'dealTime', width: 150},
                    {title: '创建时间', field: 'createTime', width: 180},
                    {title: '修改时间', field: 'updateTime', width: 180},
                    {title: '备注', field: 'remark', width: 180}
                ]],
                toolbar: [{
                    id: 'btnView',
                    text: '查看',
                    iconCls: 'icon-search',
                    handler: function () {
                        showViewDialog();//实现查看记录详细信息的方法
                    }
                }, '-', {
                    id: 'btnAdd',
                    text: '添加',
                    iconCls: 'icon-add',
                    handler: function () {
                        showAddDialog();//实现查看记录详细信息的方法
                    }
                }, '-', {
                    id: 'btnEdit',
                    text: '修改',
                    iconCls: 'icon-edit',
                    handler: function () {
                        showEditDialog();//实现修改记录的方法
                    }
                }, '-', {
                    id: 'btnDelete',
                    text: '取消',
                    iconCls: 'icon-remove',
                    handler: function () {
                        cancel();//实现直接删除数据的方法
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
                onDblClickRow:
                    function (rowIndex, rowData) {
                        $(dg).datagrid('uncheckAll');
                        $(dg).datagrid('checkRow', rowIndex);
                        showViewDialog();
                    }
            }
        )
        $(dg).datagrid('clearSelections');
    }

    function getQueryParams() {
        queryParams = {
            title: $("#s_title").val(),
            status: $("#s_status").val()
        };
        return queryParams;
    }

    function showViewDialog() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $('#dlg').dialog('open').dialog('setTitle', '查看');
            $('#frm').form('load', rows[0]);
            initDayNums(rows[0]);
            $("#btn_save").hide();
            $(".view_status").show();
            $(".view_hide").show();
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function showAddDialog() {
        $('#dlg').dialog('open').dialog('setTitle', '添加');
        $('#frm').form('clear');
        $(".view_status").hide();
        $("#btn_save").show();
        $(".view_hide").hide();
    }

    function showEditDialog() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $('#dlg').dialog('open').dialog('setTitle', '修改');
            $('#frm').form('load', rows[0]);
            initDayNums(rows[0]);
            $(".view_status").show();
            $("#btn_save").show();
            $(".view_hide").hide();
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function closeDialog() {
        $('#dlg').dialog('close');
    }

    function save() {
        var title = $("div#dlg input[name='title']").val();
        if (title == '') {
            $.messager.alert("提示", '请填写标题');
            return;
        }
        var content = $("div#dlg input[name='content']").val();
        if (content == '') {
            $.messager.alert("提示", '请填写内容');
            return;
        }
        var dayNums = getDayNums();
        if (isEmpty(dayNums)) {
            $.messager.alert("提示", '请选择时间');
            return;
        }
        $("div#dlg input[name='dayNums']").val(dayNums);
        $('#frm').form('submit', {
            url: '${pageContext.request.contextPath }/workTaskCreation/saveWorkTaskCreation',
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

    function cancel() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $.messager.confirm('提示', '确认取消标题[' + rows[0].title + ']的工单吗？', function (r) {
                if (r) {
                    $.post('${pageContext.request.contextPath }/workTaskCreation/cancelWorkTaskCreation', {id: rows[0].id}, function (data) {
                        if (data.code == '200') {
                            bindData();
                        } else {
                            $.messager.alert("提示", data.message);
                        }
                    });
                }
            });
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function showDlgChargeUser(id) {
        $('#workTaskCreationId').val(id);
        $('#dlgChargeUser').dialog('open').dialog('setTitle', '负责人管理');
        bindUserTree();
    }

    function closeDlgChargeUser() {
        $('#dlgChargeUser').dialog('close');
    }

    function bindUserTree() {
        $("#userTree").tree({
            checkbox: true,
            cascadeCheck: false,
            url: "${pageContext.request.contextPath }/user/tree?status=1",
            onLoadSuccess: function (data) {
                checkUserTree();
            }
        });
    }

    function checkUserTree() {
        var workTaskCreationId = $('#workTaskCreationId').val();
        $.post('${pageContext.request.contextPath }/workTaskCreationUser/listWorkTaskCreationUser', {workTaskCreationId: workTaskCreationId}, function (data) {
            if (data.code == '200') {
                for (var i = 0; i < data.data.length; i++) {
                    var node = $('#userTree').tree('find', data.data[i].userId);
                    if (node) {
                        $("#userTree").tree("check", node.target);
                    }
                }
            } else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function saveChargeUser() {
        var workTaskCreationId = $('#workTaskCreationId').val();
        var nodes = $('#userTree').tree('getChecked');
        var userIds = new Array();
        for (var i = 0; i < nodes.length; i++) {
            userIds.push(nodes[i].id);
        }
        $.post('${pageContext.request.contextPath }/workTaskCreationUser/saveWorkTaskCreationUser', {
            workTaskCreationId: workTaskCreationId,
            userIds: userIds
        }, function (data) {
            if (data.code == '200') {
                closeDlgChargeUser();
                bindData();
            } else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function showDlgChargeRole(id) {
        $('#workTaskCreationId').val(id);
        $('#dlgChargeRole').dialog('open').dialog('setTitle', '负责角色管理');
        bindRoleTree();
    }

    function closeDlgChargeRole() {
        $('#dlgChargeRole').dialog('close');
    }

    function bindRoleTree() {
        $("#roleTree").tree({
            checkbox: true,
            cascadeCheck: false,
            url: "${pageContext.request.contextPath }/role/tree?status=1",
            onLoadSuccess: function (data) {
                checkRoleTree();
            }
        });
    }

    function checkRoleTree() {
        var workTaskCreationId = $('#workTaskCreationId').val();
        $.post('${pageContext.request.contextPath }/workTaskCreationRole/listWorkTaskCreationRole', {workTaskCreationId: workTaskCreationId}, function (data) {
            if (data.code == '200') {
                for (var i = 0; i < data.data.length; i++) {
                    var node = $('#RoleTree').tree('find', data.data[i].RoleId);
                    if (node) {
                        $("#RoleTree").tree("check", node.target);
                    }
                }
            } else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function saveChargeRole() {
        var workTaskCreationId = $('#workTaskCreationId').val();
        var nodes = $('#roleTree').tree('getChecked');
        var roleIds = new Array();
        for (var i = 0; i < nodes.length; i++) {
            roleIds.push(nodes[i].id);
        }
        $.post('${pageContext.request.contextPath }/workTaskCreationRole/saveWorkTaskCreationRole', {
            workTaskCreationId: workTaskCreationId,
            roleIds: roleIds
        }, function (data) {
            if (data.code == '200') {
                closeDlgChargeRole();
                bindData();
            } else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function changeType(type) {
        if (type == 1) {
            $("#div_day_nums_week").show();
            $("#div_day_nums_month").hide();
        } else if (type == 2) {
            $("#div_day_nums_week").hide();
            $("#div_day_nums_month").show();
        }
    }

    function initDayNums(row) {
        changeType(row.type);
        var dayNums = row.dayNums.split(",");
        var name;
        if (row.type == 1) {
            name = ("week");
        } else if (row.type == 2) {
            name = ("month");
        }
        checkboxs = document.getElementsByName(name);
        for (k in checkboxs) {
            if (dayNums.includes(checkboxs[k].value)) {
                checkboxs[k].checked = true;
            }
        }
    }

    function getDayNums() {
        var type = $("#sType").combobox('getValue');
        var name;
        if (type == 1) {
            name = ("week");
        } else if (type == 2) {
            name = ("month");
        }
        checkboxs = document.getElementsByName(name);
        var dayNums = '';
        for (k in checkboxs) {
            if (checkboxs[k].checked) {
                if (dayNums == '') {
                    dayNums = checkboxs[k].value;
                } else {
                    dayNums = dayNums + "," + checkboxs[k].value;
                }
            }
        }
        return dayNums;
    }
</script>
</html>
