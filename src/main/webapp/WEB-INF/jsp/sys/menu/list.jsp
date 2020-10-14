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

    <title>菜单列表</title>
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
<div id="dlg" class="easyui-dialog" style="width: 600px; height: 300px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:50,align:'center'">
    <div class="ftitle">
        <b>产品信息</b>
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
                <td>菜单名：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="menuName" data-options="required:true">
                </td>
                <td>父菜单：</td>
                <td>
                    <select class="easyui-combotree" id="parentMenuId" name="parentMenuId"
                            data-options="required:true"/>
                </td>
            </tr>
            <tr>
                <td>url：</td>
                <td colspan="3">
                    <input class="easyui-validatebox textbox" name="url" style="width: 90%">
                </td>
            </tr>
            <tr>
                <td>状态：</td>
                <td>
                    <select class="easyui-combobox" name="status" style="width:100px;" data-options="required:true">
                        <option value="1">显示</option>
                        <option value="0">隐藏</option>
                    </select>
                </td>
                <td>排序：</td>
                <td>
                    <input class="easyui-numberbox" name="sort" data-options="min:0,precision:0,required:true">
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
<%--权限列表--%>
<div id="dlgRightList" class="easyui-dialog" style="width: 600px; height: 600px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:50,align:'center'">
    <div class="ftitle">
        <b>权限管理</b>
        <hr/>
        <input type="hidden" id="dlgRightList_menuId">
    </div>
    <table id="dgRight" style="width: 100%; height: auto">

    </table>
    <div style="text-align:center;">
        <a href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-cancel'" onclick="closeDlgRightList()">关闭</a>
    </div>
</div>
<!--编辑页面-->
<div id="dlgRight" class="easyui-dialog" style="width: 600px; height: 300px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:50,align:'center'">
    <div class="ftitle">
        <b>权限管理</b>
        <hr/>
    </div>
    <form id="frmRight" method="post" novalidate="novalidate">
        <table>
            <tr style="display: none">
                <td>rightId：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="id">
                    <input type="hidden" name="menuId">
                </td>

            </tr>
            <tr>
                <td>权限名：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="rightName"
                           data-options="required:true">
                </td>
                <td>权限字符串：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="rightStr">
                </td>
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
               data-options="iconCls:'icon-ok'" id="btn_saveRight" onclick="saveRight()">确定</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-cancel'" onclick="closeDlgRight()">关闭</a>
        </div>
    </form>

</div>
<script type="text/javascript">
    bindData();

    function bindParentMenuId(type) {
        $('#parentMenuId').combotree({
            url: '${pageContext.request.contextPath }/menu/combotree',
            valueField: 'id',
            textField: 'menuName',
            required: true,
            editable: false,
            onlyLeafCheck: true,
            cascaseCheck: true,
            method: 'get',
            onLoadSuccess: function (node, data) {
                if (type == 'add') {
                    $("#parentMenuId").combotree('setValue', 0);
                }
            }
        });
    }

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/menu/treegrid";
        title = "菜单管理";
        queryParams = {};
        $(dg).treegrid({   //定位到Table标签，Table标签的ID是grid
            url: url,   //指向后台的Action来获取当前菜单的信息的Json格式的数据
            title: title,
            rownumbers: true,
            idField: 'id',
            treeField: 'menuName',
            parentField: 'parentMenuId',
            queryParams: queryParams,  //异步查询的参数
            columns: [[
                {field: 'ck', checkbox: true},   //选择
                {title: '菜单名', field: 'menuName', width: 200},
                {title: '排序', field: 'sort', width: 50},
                {title: 'url', field: 'url', width: 200},
                {
                    title: '状态', field: 'status', width: 60,
                    formatter: function (value, rowData, rowIndex) {
                        if (value == null) {
                            return '';
                        }
                        if (value == 1) {
                            return '显示';
                        } else if (value == 0) {
                            return '隐藏';
                        }
                    }
                },
                {
                    title: '操作', field: 'deal', width: 60,
                    formatter: function (value, row, index) {
                        return '<a href="javascript:;" onclick="showRightList(' + row.id + ')" title="权限管理">权限管理</a>';

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
                    $(dg).treegrid("reload");
                }
            }],
            onDblClickRow: function (rowIndex, rowData) {
                $(dg).treegrid('uncheckAll');
                $(dg).treegrid('checkRow', rowIndex);
                showViewDialog();
            }
        })
        $(dg).treegrid('clearSelections');
    }

    function closeDialog() {
        $('#dlg').dialog('close');
    }

    function showAddDialog() {
        bindParentMenuId('add');
        $("#parentMenuId").combotree('setValue', 0);
        $('#dlg').dialog('open').dialog('setTitle', '添加');
        $('#frm').form('clear');
        $("#btn_save").show();
    }

    function showViewDialog() {
        bindParentMenuId('view');
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $('#dlg').dialog('open').dialog('setTitle', '查看');
            $('#frm').form('load', rows[0]);
            $("#btn_save").hide();
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function showEditDialog() {
        bindParentMenuId('edit');
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
        //防止重复点击
        var menuName = $("div#dlg input[name='menuName']").val();
        if (menuName == '') {
            $.messager.alert("提示", '请填写菜单名');
            return;
        }
        var parentMenuId = $("#parentMenuId").combotree('tree').tree('getSelected').id;
        if (parentMenuId == null) {
            $.messager.alert("提示", '请选择父菜单');
            return;
        }
        var status = $("div#dlg input[name='status']").val();
        if (status == '') {
            $.messager.alert("提示", '请选择状态');
            return;
        }
        var sort = $("div#dlg input[name='sort']").val();
        if (sort == '') {
            $.messager.alert("提示", '请填写排序');
            return;
        }
        $('#frm').form('submit', {
            url: '${pageContext.request.contextPath }/menu/save',
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

    function deleteInfo() {
        //防止重复点击
        var rows = $('#dg').datagrid('getSelections');
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
                $.post('${pageContext.request.contextPath }/menu/delete', {ids: ids}, function (data) {
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

    function showRightList(id) {
        $('#dlgRightList').dialog('open').dialog('setTitle', '权限管理');
        $('#dlgRightList_menuId').val(id);
        bindRightList();
    }

    function closeDlgRightList(id) {
        $('#dlgRightList').dialog('close');
    }

    function bindRightList() {
        dg = '#dgRight';
        url = "${pageContext.request.contextPath }/right/listRight";
        title = "菜单管理";
        queryParams = {menuId: $('#dlgRightList_menuId').val()};
        $(dg).datagrid({
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
            idField: 'id',
            queryParams: queryParams,  //异步查询的参数
            columns: [[
                {field: 'ck', checkbox: true},   //选择
                {title: '权限名称', field: 'rightName', width: 130},
                {title: '权限字符串', field: 'rightStr', width: 180},
                {title: '备注', field: 'remark', width: 180}
            ]],
            toolbar: [{
                id: 'btnAddRight',
                text: '添加',
                iconCls: 'icon-add',
                handler: function () {
                    showAddRightDialog();//实现添加记录的页面
                }
            }, '-', {
                id: 'btnEditRight',
                text: '修改',
                iconCls: 'icon-edit',
                handler: function () {
                    showEditRightDialog();//实现修改记录的方法
                }
            }, '-', {
                id: 'btnDeleteRight',
                text: '删除',
                iconCls: 'icon-remove',
                handler: function () {
                    deleteRightInfo();//实现直接删除数据的方法
                }
            }, '-', {
                id: 'btnViewRight',
                text: '查看',
                iconCls: 'icon-search',
                handler: function () {
                    showViewRightDialog();//实现查看记录详细信息的方法
                }
            }, '-', {
                id: 'btnReloadRight',
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

    function showAddRightDialog() {
        $('#dlgRight').dialog('open').dialog('setTitle', '添加权限');
        $('#frmRight').form('clear');
        $("div#dlgRight input[name='menuId']").val($('#dlgRightList_menuId').val());
        $("#btn_saveRight").show();
    }

    function showEditRightDialog() {
        var rows = $('#dgRight').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $('#dlgRight').dialog('open').dialog('setTitle', '修改');
            $('#frmRight').form('load', rows[0]);
            $("#btn_saveRight").show();
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function deleteRightInfo() {
        var rows = $('#dgRight').datagrid('getSelections');
        if (!rows || rows.length == 0) {
            $.messager.alert("提示", "请选择要删除的数据.");
            return;
        }
        $.messager.confirm('提示', '确认删除这' + rows.length + '条数据吗？', function (r) {
            if (r) {
                var rightIds = new Array();
                for (var i = 0; i < rows.length; i++) {
                    rightIds.push(rows[i].id);
                }
                $.post('${pageContext.request.contextPath }/right/deleteRight', {rightIds: rightIds}, function (data) {
                    if (data.code == '200') {
                        bindRightList();
                    }
                    else {
                        $.messager.alert("提示", data.message);
                    }
                });
            }
        });
    }

    function showViewRightDialog() {
        var rows = $('#dgRight').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $('#dlgRight').dialog('open').dialog('setTitle', '查看');
            $('#frmRight').form('load', rows[0]);
            $("#btn_saveRight").hide();
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function saveRight() {
        //防止重复点击
        var rightName = $("div#dlgRight input[name='rightName']").val();
        if (rightName == '') {
            $.messager.alert("提示", '请填写权限名');
            return;
        }
        var rightStr = $("div#dlgRight input[name='rightStr']").val();
        if (rightStr == '') {
            $.messager.alert("提示", '请填写权限字符串');
            return;
        }

        $('#frmRight').form('submit', {
            url: '${pageContext.request.contextPath }/right/saveRight',
            onSubmit: function () {
                var validate = $(this).form('validate');
                return validate;
            },
            success: function (data) {
                res = eval('(' + data + ')');
                if (res.code == '200') {
                    closeDlgRight();
                    bindRightList();
                }
                else {
                    $.messager.alert("提示", res.message);
                }
            }
        });
    }

    function closeDlgRight() {
        $('#dlgRight').dialog('close');
    }
</script>
</body>
</html>
