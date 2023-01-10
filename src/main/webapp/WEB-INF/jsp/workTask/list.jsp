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
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/common/cookieUtil.js?t=20200928"></script>
    <title>任务管理</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    <!--只显示用户有的店铺-->
    标题：
    <input class="easyui-validatebox textbox" name="s_title">
    任务单号：
    <input class="easyui-validatebox textbox" name="s_workTaskNo">
    负责人：
    <select class="easyui-combobox" id="s_chargeUserId" style="width:100px;">
    </select>
    </select>
    处理人：
    <select class="easyui-combobox" id="s_dealUserId" style="width:100px;">
    </select>
    状态：
    <select class="easyui-combobox" id="s_status" style="width:100px;">
        <option value="">全部</option>
        <option value="0">待处理</option>
        <option value="1">进行中</option>
        <option value="2">已完成</option>
        <option value="3">取消</option>
    </select>
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
</div>
<!--列表-->
<table id="dg" style="width: 100%; height: auto">

</table>
<!--入库单编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 800px; height: 700px; padding: 10px 20px"
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
                    <input class="easyui-validatebox textbox" name="title" style="width: 90%">
                </td>
            </tr>
            <tr class="view_status">
                <td>编号：</td>
                <td colspan="3">
                    <input class="easyui-validatebox textbox" name="workTaskNo" readonly="readonly" style="width: 90%">
                </td>
            </tr>
            <tr>
                <td>内容：</td>
                <td colspan="3">
                    <input class="easyui-textbox" data-options="multiline:true" name="content"
                           style="width: 90%;height:150px">
                </td>
            </tr>
            <tr class="view_status">
                <td>解决方案：</td>
                <td colspan="3">
                    <input class="easyui-textbox" data-options="multiline:true" name="solution"
                           style="width: 90%;height:150px">
                </td>
            </tr>
            <tr class="view_show">
                <td>审核意见：</td>
                <td colspan="3">
                    <input class="easyui-textbox" data-options="multiline:true" name="auditContent"
                           style="width: 90%;height:50px">
                </td>
            </tr>
            <tr>
                <td>处理级别：</td>
                <td>
                    <select class="easyui-combobox" name="level" data-options="required:true" style="width:100px;">
                        <option value="1">紧急</option>
                        <option value="2">普通</option>
                        <option value="3">不急</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>计划开始时间：</td>
                <td>
                    <input class="easyui-datebox" type="text" name="beginTime">
                </td>
                <td>计划结束时间：</td>
                <td>
                    <input class="easyui-datebox" type="text" name="endTime">
                </td>
            </tr>
            <tr>
                <td>负责人：</td>
                <td colspan="3">
                    <input class="easyui-textbox" type="text" name="chargeUserRealNames" id="chargeUserRealNames"
                           data-options="multiline:true,required:true"
                           style="width: 70%;height:25px">
                    <a href="#" onclick="showDlgChargeUser()">选择负责人</a>
                    <input type="hidden" name="chargeUserIds" id="chargeUserIds">
                </td>
            </tr>
            <tr class="view_hide">
                <td>是否需要审核：</td>
                <td>
                    <select class="easyui-combobox" name="auditStatus" style="width:100px;">
                        <option value="0">不需要</option>
                        <option value="1">需要</option>
                    </select>
                </td>
            </tr>
            <tr class="view_status">
                <td>状态：</td>
                <td>
                    <select class="easyui-combobox" name="status" style="width:100px;">
                        <option value="0">取消</option>
                        <option value="1">进行中</option>
                        <option value="2">已完成</option>
                        <option value="3">待审核</option>
                    </select>
                </td>
                <td>处理人：</td>
                <td>
                    <select class="easyui-combobox" id="dealUserId" name="dealUserId" style="width:100px;">
                    </select>
                </td>
            </tr>
            <tr class="view_status">
                <td>处理状态：</td>
                <td>
                    <select class="easyui-combobox" name="dealStatus" style="width:100px;" readonly="readonly">
                        <option value="0">未处理</option>
                        <option value="1">处理及时</option>
                        <option value="2">处理超时</option>
                    </select>
                </td>
                <td>实际结束时间：</td>
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

<div id="dlgAuditStatus" class="easyui-dialog" style="width: 700px; height: 600px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true,top:50, align:'center'">
    <div class="ftitle">
        <b>工单</b>
        <hr/>
    </div>
    <form id="frmAuditStatus" method="post" novalidate="novalidate">
        <table>
            <tr style="display: none">
                <td>id：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="workTaskId" id="workTaskId">
                </td>
            </tr>
            <tr>
                <td>审核结果：</td>
                <td colspan="3">
                    <select class="easyui-combobox" name="auditStatus" data-options="required:true"
                            style="width:100px;">
                        <option value="2">审核通过</option>
                        <option value="3">审核不通过</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>审核意见：</td>
                <td colspan="3">
                    <input class="easyui-textbox" data-options="multiline:true,required:true" name="auditContent"
                           style="width: 500px;height:200px">
                </td>
            </tr>
        </table>
        <div style="text-align:center;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" id="btn_save_audit_status" onclick="saveAuditStatus()">确定</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-cancel'" onclick="closeDlgAuditStatus()">关闭</a>
        </div>
    </form>
</div>
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
<div id="dlgWorkTaskLog" class="easyui-dialog" style="width: 800px; height: 700px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:55,align:'center'">
    <table id="dgWorkTaskLog" style="width: 100%; height: auto">

    </table>
</div>

<div id="dlgFile" class="easyui-dialog" style="width: 600px; height: 600px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true,top:50, align:'center'">
    <form id="frmFile" method="post" enctype="multipart/form-data">
        <table>
            <tr style="display: none">
                <td>entityId：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="entityId">
                </td>
                <td>fileType：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="fileType">

                </td>
            </tr>
            <tr>
                <td><input type="file" id="file" name="file"></td>
                <td>
                    <a href="javascript:void(0)" class="easyui-linkbutton"
                       data-options="iconCls:'icon-ok'" onclick="btnUploadFile()">上传附件</a>
                </td>
            </tr>
        </table>
    </form>
    <table id="dgFile" style="width: 100%; height: auto">
    </table>
</div>
<div id="cover">
    <div id="coverMsg">
        <img src="${pageContext.request.contextPath }/static/img/loading.gif" width="100px">
    </div>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        bindUserId();
        bindData();
    });

    function bindSalesGroupId() {
        $.post('${pageContext.request.contextPath }/salesGroup/comboboxlist', {}, function (data) {
            $('#s_salesGroupId').combobox({
                data: data,
                valueField: 'id',
                textField: 'groupName'
            });
            $('#salesGroupId').combobox({
                data: data,
                valueField: 'id',
                textField: 'groupName'
            });
        });
    }

    function bindUserId() {
        $.post('${pageContext.request.contextPath }/user/comboboxlist', {}, function (data) {
            $('#s_dealUserId').combobox({
                data: data,
                valueField: 'userId',
                textField: 'realName'
            });
            $('#dealUserId').combobox({
                data: data,
                valueField: 'userId',
                textField: 'realName'
            });
            $('#s_chargeUserId').combobox({
                data: data,
                valueField: 'userId',
                textField: 'realName'
            });
            $('#chargeUserId').combobox({
                data: data,
                valueField: 'userId',
                textField: 'realName'
            });
        });
    }

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/workTask/listWorkTask";
        title = "任务管理";
        queryParams = getQueryParams();
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
                    {title: '编号', field: 'workTaskNo', width: 150},
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
                    {title: '负责人', field: 'chargeUserRealNames', width: 100},
                    {title: '内容', field: 'content', width: 300},
                    {title: '解决方案', field: 'solution', width: 300},
                    {title: '处理人', field: 'dealUserRealName', width: 100},
                    {
                        title: '附件', field: 'file', width: 60,
                        formatter: function (value, rowData, rowIndex) {
                            return '<a href="javascript:;" onclick="showFileDialog(' + rowData.id + ')" >附件</a>';
                        }
                    },
                    {title: '计划开始时间', field: 'beginTime', width: 150},
                    {title: '计划结束时间', field: 'endTime', width: 150},
                    {title: '实际结束时间', field: 'actualEndTime', width: 150},
                    {title: '创建时间', field: 'createTime', width: 180},
                    {title: '修改时间', field: 'updateTime', width: 180},
                    {
                        title: '操作', field: 'auditStatus', width: 150, formatter: function (value, row, index) {
                            var content = "";
                            if (hasRight("auditWorkTask")) {
                                if ((row.auditStatus == 1 || row.auditStatus == 3) && (row.status == 2 || row.status == 3)) {
                                    content = content + '<a href="javascript:void(0)" onclick="showDlgAuditStatus(' + row.id + ')" class="easyui-linkbutton" >审核</a>';
                                }
                            }
                            if (!isEmpty(content)) {
                                content = content + "&nbsp;&nbsp;&nbsp;";
                            }
                            content = content + '<a href="javascript:void(0)" onclick="showDlgWorkTaskLog(' + row.id + ')" class="easyui-linkbutton" >操作记录</a>';
                            return content;
                        }
                    },
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
                },'-', {
                    id: 'btnComplete',
                    text: '完成',
                    iconCls: 'icon-edit',
                    handler: function () {
                        completeWorkTask();//实现修改记录的方法
                    }
                },  '-', {
                    id: 'btnDelete',
                    text: '取消',
                    iconCls: 'icon-remove',
                    handler: function () {
                        cancelworkTask();//实现直接删除数据的方法
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
            workTaskNo: $("#s_workTaskNo").val(),
            chargeUserId: $("#s_chargeUserId").val(),
            dealUserId: $("#s_dealUserId").val(),
            status: $("#s_status").val()
        };
        return queryParams;
    }

    function showViewDialog() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $('#dlg').dialog('open').dialog('setTitle', '查看');
            $('#frm').form('load', rows[0]);
            $("#btn_save").hide();
            $(".view_status").show();
            $(".view_hide").hide();
            $(".view_show").show();
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function showAddDialog() {
        $('#dlg').dialog('open').dialog('setTitle', '添加');
        $('#frm').form('clear');
        $(".view_status").hide();
        $("#btn_save").show();
        $(".view_hide").show();
        $(".view_show").hide();
    }

    function showEditDialog() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $('#dlg').dialog('open').dialog('setTitle', '修改');
            $('#frm').form('load', rows[0]);
            $(".view_status").show();
            $("#btn_save").show();
            $(".view_hide").show();
            $(".view_show").hide();
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
        $('#frm').form('submit', {
            url: '${pageContext.request.contextPath }/workTask/saveWorkTask',
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

    function cancelworkTask() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $.messager.confirm('提示', '确认取消标题[' + rows[0].title + ']的工单吗？', function (r) {
                if (r) {
                    $.post('${pageContext.request.contextPath }/workTask/cancelWorkTask', {id: rows[0].id}, function (data) {
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

    function completeWorkTask() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $.messager.confirm('提示', '确认完成消标题[' + rows[0].title + ']的工单吗？', function (r) {
                if (r) {
                    $.post('${pageContext.request.contextPath }/workTask/completeWorkTask', {id: rows[0].id}, function (data) {
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
    function showDlgAuditStatus(id) {
        $('#workTaskId').val(id);
        $('#dlgAuditStatus').dialog('open').dialog('setTitle', '审核管理');
    }

    function closeDlgAuditStatus() {
        $('#dlgAuditStatus').dialog('close');
    }

    function saveAuditStatus() {
        $('#frmAuditStatus').form('submit', {
            url: '${pageContext.request.contextPath }/workTask/auditWorkTask',
            onSubmit: function () {
                var validate = $(this).form('validate');
                return validate;
            },
            success: function (data) {
                res = eval('(' + data + ')');
                if (res.code == '200') {
                    closeDlgAuditStatus();
                    bindData();
                } else {
                    $.messager.alert("提示", res.message);
                }
            }
        });
    }

    function showDlgChargeUser() {
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
        var userIdStrs = $('#chargeUserIds').val();
        if (!isEmpty(userIdStrs)) {
            var userIds = userIdStrs.split(',');
            for (var i = 0; i < userIds.length; i++) {
                var node = $('#userTree').tree('find', userIds[i]);
                if (node) {
                    $("#userTree").tree("check", node.target);
                }
            }
        }
    }

    function saveChargeUser() {
        var nodes = $('#userTree').tree('getChecked');
        var userIds = "";
        var userNames = "";
        for (var i = 0; i < nodes.length; i++) {
            if (i == 0) {
                userIds = nodes[i].id;
                userNames = nodes[i].text;
            } else {
                userIds = userIds + ',' + nodes[i].id;
                userNames = userNames + ',' + nodes[i].text;
            }
        }
        $('#chargeUserIds').val(userIds);
        $('#chargeUserRealNames').textbox('setValue', userNames);
        closeDlgChargeUser();
    }

    function showDlgWorkTaskLog(id) {
        $('#workTaskId').val(id);
        bindWorkTaskLog();
        $('#dlgWorkTaskLog').dialog('open').dialog('setTitle', '操作记录');
    }

    function closeDlgWorkTaskLog(id) {
        $('#dlgWorkTaskLog').dialog('close');
    }

    function bindWorkTaskLog() {
        dg = '#dgWorkTaskLog';
        url = "${pageContext.request.contextPath }/workTaskLog/listWorkTaskLog";
        title = "操作记录";
        queryParams = {
            workTaskId: $("#workTaskId").val()
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
                    {title: '操作用户', field: 'dealUserRealName', width: 60},
                    {title: '操作内容', field: 'content', width: 150},
                    {title: '创建时间', field: 'createTime', width: 180}
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
            }
        )
        $(dg).datagrid('clearSelections');
    }

    function showFileDialog(id) {
        $('#dlgFile').dialog('open').dialog('setTitle', '附件');
        $('#frmFile').form('clear');
        $("div#dlgFile input[name='entityId']").val(id);
        $("div#dlgFile input[name='fileType']").val("work_task.file");
        bindFileData();
    }

    function bindFileData() {
        dg = '#dgFile';
        url = "${pageContext.request.contextPath }/file/list";
        title = "附件管理";
        queryParams = {
            entityId: $("div#dlgFile input[name='entityId']").val(),
            fileType: $("div#dlgFile input[name='fileType']").val()
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
            pageSize: 5,
            pageList: [5, 10, 15, 20, 30, 50],
            rownumbers: true,
            //sortName: 'ID',    //根据某个字段给easyUI排序
            //sortOrder: 'asc',
            remoteSort: false,
            idField: 'id',
            queryParams: queryParams,  //异步查询的参数
            columns: [[
                {field: 'ck', checkbox: true},   //选择
                {title: '文件名', field: 'fileName', width: 180},
                {
                    title: '文件下载', field: 'fileUrl', width: 100,
                    formatter: function (value, rowData, rowIndex) {
                        return '<a href="javascript:;" onclick="downFile(\'' + value + '\')" >下载</a> ';
                    }
                },
                {title: '创建时间', field: 'createTime', width: 180}
            ]],
            toolbar: [{
                id: 'btnFileDelete',
                text: '删除',
                iconCls: 'icon-remove',
                handler: function () {
                    deleteFileInfo();//实现直接删除数据的方法
                }
            }, '-', {
                id: 'btnImgReload',
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

    function btnUploadFile() {
        var entityId = $("div#dlgFile input[name='entityId']").val();
        if (entityId == '') {
            $.messager.alert("提示", "entityId不能为空");
            return;
        }
        var fileType = $("div#dlgFile input[name='fileType']").val();
        if (fileType == '') {
            $.messager.alert("提示", "文件类型不能为空");
            return;
        }
        var file = $("div#dlgFile input[name='file']").val();
        if (file == '') {
            $.messager.alert("提示", "文件不能为空");
            return;
        }
        var dom = document.getElementById("file");
        var fileSize = dom.files[0].size;
        if (fileSize > 50000000) {
            $.messager.alert("提示", "上传文件过大,请上传小于50M的文件");
            return false;
        }
        showCover();
        $('#frmFile').form('submit', {
            url: '${pageContext.request.contextPath }/file/addFile',
            onSubmit: function () {
                return $(this).form('validate');
            },
            success: function (data) {
                hideCover();
                res = eval("(" + data + ")");
                if (res.code == '200') {
                    $.messager.alert("提示", "上传成功");
                    bindFileData();
                } else {
                    $.messager.alert("提示", res.message);
                }
            }
        });
    }

    function deleteFileInfo() {
        //防止重复点击
        var rows = $('#dgFile').datagrid('getSelections');
        if (!rows || rows.length == 0) {
            $.messager.alert("提示", "请选择要删除的数据.");
            return;
        }
        $.messager.confirm('提示', '确认删除这' + rows.length + '条数据吗？', function (r) {
            if (r) {
                var fileIds = new Array();
                for (var i = 0; i < rows.length; i++) {
                    fileIds.push(rows[i].id);
                }
                $.post('${pageContext.request.contextPath }/file/deleteFile', {fileIds: fileIds}, function (data) {
                    if (data.code == '200') {
                        $('#dlg').dialog('close');
                        bindFileData();
                    } else {
                        $.messager.alert("提示", data.message);
                    }
                });
            }
        });
    }

    function downFile(fileUrl) {
        window.open(fileUrl);
    }
</script>
</html>
