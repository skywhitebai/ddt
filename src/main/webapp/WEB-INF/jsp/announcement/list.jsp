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
    <title>公告管理</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    标题：
    <input class="easyui-validatebox textbox" id="s_title">
    状态：
    <select class="easyui-combobox" id="s_status" style="width:100px;">
        <option value="">全部</option>
        <option value="1">启用</option>
        <option value="0">停用</option>
    </select>
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>开始时间 结束时间暂未启用
</div>
<table id="dg" style="width: 100%; height: auto">

</table>
<!--编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 600px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
    <div class="ftitle">
        <b>公告信息</b>
        <hr/>
    </div>
    <form id="frm" method="post" novalidate="novalidate">
        <table>
            <tr style="display: none">
                <td>announcementId：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="announcementId">
                </td>
            </tr>
            <tr>
                <td>标题：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="title" data-options="required:true">
                </td>
            </tr>
            <tr>
                <td>内容：</td>
                <td colspan="3">
                    <input class="easyui-textbox" name="content" data-options="multiline:true,required:true"
                           style="width:450px;height:100px">
                </td>
            </tr>
            <tr>
                <td>开始时间：</td>
                <td>
                    <input class="easyui-datetimebox" name="startTime">
                </td>
                <td>结束时间：</td>
                <td>
                    <input class="easyui-datetimebox" name="endTime">
                </td>
            </tr>
            <tr>
                <td>状态：</td>
                <td>
                    <select class="easyui-combobox" name="status" style="width:100px;" data-options="required:true">
                        <option value="1">启用</option>
                        <option value="0">停用</option>
                    </select>
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
<script type="text/javascript">
    bindData();

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/announcement/list";
        title = "公告管理";
        queryParams = {
            title: $("#s_title").val(),
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
            idField: 'announcementId',
            queryParams: queryParams,  //异步查询的参数
            columns: [[
                {field: 'ck', checkbox: true},   //选择
                {title: '标题', field: 'title', width: 100},
                {title: '内容', field: 'content', width: 100},
                {title: '开始时间', field: 'startTime', width: 180},
                {title: '结束时间', field: 'endTime', width: 180},
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

    function showAddDialog() {
        $('#dlg').dialog('open').dialog('setTitle', '添加');
        $('#frm').form('clear');
        $("#btn_save").show();
        $(".view_hide").hide();
    }

    function save() {
        //防止重复点击
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
        var status = $("div#dlg input[name='status']").val();
        if (status == '') {
            $.messager.alert("提示", '请选择状态');
            return;
        }
//        var startTime = $("div#dlg input[name='startTime']").val();
//        if (startTime == '') {
//            $.messager.alert("提示", '请填写开始时间');
//            return;
//        }
//        var endTime = $("div#dlg input[name='endTime']").val();
//        if (endTime == '') {
//            $.messager.alert("提示", '请填写结束时间');
//            return;
//        }

        $('#frm').form('submit', {
            url: '${pageContext.request.contextPath }/announcement/save',
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
                var announcementIds = new Array();
                for (var i = 0; i < rows.length; i++) {
                    announcementIds.push(rows[i].announcementId);
                }
                $.post('${pageContext.request.contextPath }/announcement/delete', {announcementIds: announcementIds}, function (data) {
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

</script>
</body>
</html>
