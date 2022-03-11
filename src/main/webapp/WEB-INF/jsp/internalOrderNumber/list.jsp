<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2020/6/30
  Time: 10:54
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
    <title>内部单号</title>
    <style>
        .textbox-wide {
            width: 400px;
        }
    </style>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    <!--只显示用户有的店铺-->
    单号：
    <input class="easyui-validatebox textbox" id="s_orderNumber">
    创建时间：
    <input class="easyui-datebox" id="s_createTimeStart">
    -
    <input class="easyui-datebox" id="s_createTimeEnd">
    物流渠道：
    <select class="easyui-combobox" id="s_transportTypeId" style="width:160px;">
    </select>
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
</div>
<table id="dg" style="width: 100%; height: auto">

</table>
<!--编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 700px; height: 300px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
    <div class="ftitle">
        <b>内部单号管理</b>
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
            <tr class="add_hide">
                <td>单号：</td>
                <td>
                    <input class="easyui-textbox textbox-wide" type="text" readonly="readonly" name="orderNumber">
                </td>
            </tr>
            <tr>
                <td>数量：</td>
                <td>
                    <input class="easyui-numberbox textbox-wide" name="number" id="number"
                           data-options="min:1,precision:0,required:true">
                </td>
            <tr>
                <td>物流渠道：</td>
                <td colspan="3">
                    <select class="easyui-combobox" id="transportTypeId" style="width:160px;" name="transportTypeId"
                            data-options="required:true">

                    </select>
                </td>
            </tr>
            </tr>
            <tr>
                <td>备注：</td>
                <td colspan="3">
                    <input class="easyui-textbox textbox-wide" type="text" name="remark" style="width:90%;">
                </td>
            </tr>
            <tr>
                <td>财务备注：</td>
                <td colspan="3">
                    <input class="easyui-textbox textbox-wide" type="text" name="financialRemark" style="width:90%;">
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

<div id="dlgFinancialRemarkHis" class="easyui-dialog" style="width: 850px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', top:50,align:'center'">
    <input type="hidden" id="dlgFinancialRemarkHis_internalOrderNumberId">
    <!--查询条件-->
    <div class="easyui-panel">
        <a href="javascript:void(0)" onclick="bindInternalOrderNumberFinancialRemarkHis()" class="easyui-linkbutton"
           data-options="iconCls:'icon-search'"
           style="width: 80px">查 询</a>
    </div>
    <table id="dgInternalOrderNumberFinancialRemarkHis" style="width: 100%; height: auto">
    </table>
</div>
</body>
<script type="text/javascript">
    //绑定运输方式
    bindTransportType();

    function bindTransportType() {
        $.post('${pageContext.request.contextPath }/transportType/comboboxlist', {}, function (data) {
            $('#s_transportTypeId').combobox({
                data: data,
                valueField: 'id',
                textField: 'transportTypeName'
            });
            $('#transportTypeId').combobox({
                data: data,
                valueField: 'id',
                textField: 'transportTypeName'
            });
            bindData();
        });
    }

    function getQueryParams() {
        queryParams = {
            orderNumber: $("#s_orderNumber").val(),
            createTimeStart: $("#s_createTimeStart").val(),
            createTimeEnd: $("#s_createTimeEnd").val(),
            transportTypeId: $('#s_transportTypeId').combobox('getValue')
        };
        return queryParams;
    }

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/internalOrderNumber/listInternalOrderNumber";
        title = "内部单号管理";
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
                {title: '单号', field: 'orderNumber', width: 130},
                {title: '数量', field: 'number', width: 100},
                {title: '物流渠道', field: 'transportTypeName', width: 130},
                {title: '重量kg', field: 'totalWeight', width: 60},
                {
                    title: '操作', field: 'id', width: 150,
                    formatter: function (value, row, index) {
                        return '<a href="javascript:;" onclick="downPDF(\'' + row.id + '\')" title="下载PDF">下载PDF</a>';
                    }
                },
                {title: '创建时间', field: 'createTime', width: 180},
                {title: '修改时间', field: 'updateTime', width: 180},
                {title: '备注', field: 'remark', width: 200},
                {
                    title: '财务备注', field: 'financialRemark', width: 222,
                    formatter: function (value, row, rowIndex) {
                        let text;
                        if (isEmpty(value)) {
                            text= '<input class="textbox" onchange="saveFinancialRemark(this,' + row.id + ')">';
                        } else {
                            text= '<input class="textbox" value="' + value + '" onchange="saveFinancialRemark(this,' + row.id + ')">';
                        }
                        text=text+'<a href="#" onclick="showFinancialRemarkHis(' + row.id + ')" title="查看">查看</a>';
                        return text;
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
    function showFinancialRemarkHis(internalOrderNumberId) {
        $('#dlgFinancialRemarkHis').dialog('open').dialog('setTitle', '财务备注历史');
        $('#dlgFinancialRemarkHis_internalOrderNumberId').val(internalOrderNumberId);
        bindInternalOrderNumberFinancialRemarkHis();
    }
    function bindInternalOrderNumberFinancialRemarkHis() {
        dg = '#dgInternalOrderNumberFinancialRemarkHis';
        url = "${pageContext.request.contextPath }/internalOrderNumberFinancialRemarkHis/listInternalOrderNumberFinancialRemarkHis";
        title = "店铺sku头程费信息";
        queryParams = {
            internalOrderNumberId: $('#dlgFinancialRemarkHis_internalOrderNumberId').val()
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
            idField: 'id',
            queryParams: queryParams,  //异步查询的参数
            columns: [[
                {field: 'ck', checkbox: true},   //选择
                {title: '财务备注', field: 'financialRemark', width: 160},
                {title: '修改人', field: 'createUserRealName', width: 80},
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
        })
        $(dg).datagrid('clearSelections');
    }
    function showViewDialog() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $('#dlg').dialog('open').dialog('setTitle', '查看');
            $('#frm').form('load', rows[0]);
            $("#btn_save").hide();
            $(".add_hide").show();
            $(".view_hide").show();
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function showAddDialog() {
        $('#dlg').dialog('open').dialog('setTitle', '添加');
        $('#frm').form('clear');
        $(".add_hide").hide();
        $("#btn_save").show();
    }

    function showEditDialog() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $('#dlg').dialog('open').dialog('setTitle', '修改');
            $('#frm').form('load', rows[0]);
            $("#btn_save").show();
            $(".add_hide").show();
            $(".view_hide").hide();
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function save() {
        var number = $("div#dlg input[name='number']").val();
        if (number == '') {
            $.messager.alert("提示", '请填写数量');
            return;
        }
        var transportTypeId = $('#transportTypeId').combobox('getValue');
        if (isEmpty(transportTypeId)) {
            $.messager.alert("提示", '请选择物流渠道');
            return;
        }
        $('#frm').form('submit', {
            url: '${pageContext.request.contextPath }/internalOrderNumber/saveInternalOrderNumber',
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

    function downPDF(id) {
        window.open('${pageContext.request.contextPath }/internalOrderNumber/downPDF?id=' + id)
    }
    function saveFinancialRemark(input, id){
            var financialRemark = $(input).val();
            $.post('${pageContext.request.contextPath }/internalOrderNumber/saveFinancialRemark', {
                financialRemark: financialRemark,
                id: id
            }, function (data) {
                if (data.code == '200') {
                } else {
                    $.messager.alert("提示", data.message);
                }
            });
    }
</script>
</html>
