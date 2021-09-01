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
    <input class="easyui-validatebox textbox" name="s_title">
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
<div id="dlg" class="easyui-dialog" style="width: 700px; height: 550px; padding: 10px 20px"
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
                    <input class="easyui-validatebox textbox" name="title"  style="width: 90%">
                </td>
            </tr>
            <tr>
                <td>内容：</td>
                <td colspan="3">
                    <input class="easyui-textbox" data-options="multiline:true" name="content"  style="width: 90%;height:200px">
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
                <td>计划结束时间：</td>
                <td>
                    <input class="easyui-datebox" type="text" name="planEndTime">
                </td>
            </tr>
            <tr class="view_status">
                <td>状态：</td>
                <td>
                    <select class="easyui-combobox" name="status" style="width:100px;">
                        <option value="1">进行中</option>
                        <option value="2">已完成</option>
                        <option value="3">取消</option>
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
<script type="text/javascript">
    bindData();

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/workOrder/listWorkOrder";
        title = "工单管理";
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
                    {title: '标题', field: 'title', width: 120},
                    {
                        title: '状态', field: 'status', width: 50, formatter: function (value, row, index) {
                            if (value == 1) {
                                return "进行中";
                            } else if (value == 2) {
                                return "已完成";
                            } else if (value == 3) {
                                return "取消";
                            }

                        }
                    },
                    {title: '等级', field: 'level',  width: 50, formatter: function (value, row, index) {
                            if (value == 1) {
                                return "紧急";
                            } else if (value == 2) {
                                return "普通";
                            } else if (value == 3) {
                                return "不急";
                            }

                        }
                    },
                    {title: '计划结束时间', field: 'planEndTime', width: 150},
                    {title: '实际结束时间', field: 'actualEndTime', width: 150},
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
                        cancelWorkOrder();//实现直接删除数据的方法
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
                        showEditDialog();
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
        $('#frm').form('submit', {
            url: '${pageContext.request.contextPath }/workOrder/saveWorkOrder',
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

    function cancelWorkOrder() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $.messager.confirm('提示', '确认取消标题[' + rows[0].title + ']的工单吗？', function (r) {
                if (r) {
                    $.post('${pageContext.request.contextPath }/workOrder/cancelWorkOrder', {id: rows[0].id}, function (data) {
                        if (data.code == '200') {
                            bindData();
                        }
                        else {
                            $.messager.alert("提示", data.message);
                        }
                    });
                }
            });
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }
</script>
</html>
