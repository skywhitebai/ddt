<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/9/24
  Time: 19:51
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
    <title>物流财务管理</title>
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
    是否填写实付金额：
    <select class="easyui-combobox" id="s_payAmountStatus" style="width:100px;">
        <option value="">全部</option>
        <option value="1">是</option>
        <option value="0">否</option>
    </select>
    年月
    <input class="easyui-validatebox textbox" id="s_month">
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>

    <a href="javascript:void(0)" onclick="generateTheoreticalAmount()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       >生成理论金额</a>
</div>
<table id="dg" style="width: 100%; height: auto">

</table>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        initMonth('s_month');
        //绑定运输方式
        bindTransportType();
        bindData();
    });

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
            transportTypeId: $('#s_transportTypeId').combobox('getValue'),
            payAmountStatus: $('#s_payAmountStatus').combobox('getValue'),
            month: $("#s_month").val()
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
                {
                    title: '实付金额', field: 'payAmount', width: 80,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-numberbox " min="1" precision="2" onchange="savePayAmount(this,' + row.id + ')">';
                        } else {
                            return '<input class="easyui-numberbox " min="1" precision="2" value="' + value + '" onchange="savePayAmount(this,' + row.id + ')">';
                        }
                    }
                },
                {title: '理论金额', field: 'theoreticalAmount', width: 80},
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
                {title: '财务备注', field: 'financialRemark', width: 200}
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
    function downPDF(id) {
        window.open('${pageContext.request.contextPath }/internalOrderNumber/downPDF?id=' + id)
    }
    function savePayAmount(input, id) {
        var payAmount = $(input).val();
        if (isEmpty(payAmount)) {
            $.messager.alert("提示", "实付金额不能为空");
            return;
        }
        var r = /^[+]{0,1}(\d+)$|^[+]{0,1}(\d+\.\d+)$/;　　//正数
        if (!r.test(payAmount)) {
            $.messager.alert("提示", "实付金额必须为大于0的数字.");
            $(input).focus()
            return;
        }
        $.post('${pageContext.request.contextPath }/internalOrderNumber/savePayAmount', {
            payAmount: payAmount,
            id: id
        }, function (data) {
            if (data.code == '200') {
                //保存成功
                $.messager.alert("提示", data.message);
            }
            else {
                $.messager.alert("提示", data.message);
            }
        });
    }
    function generateTheoreticalAmount() {
        var month=$("#s_month").val();
        if(isEmpty(month)){
            $.messager.alert("提示", "月份不能为空");
            return;
        }
        $.messager.confirm('提示', '确认生成' + month + '月的理论金额吗？FBA头程费生成完毕、内部单号信息、装箱单信息完善后才可以生成。', function (r) {
            if (r) {
                $.post('${pageContext.request.contextPath }/internalOrderNumber/generateTheoreticalAmount', {month: month}, function (data) {
                    if (data.code == '200') {
                        bindData();
                    } else {
                        $.messager.alert("提示", data.message);
                    }
                });
            }
        });
    }
</script>
</html>
