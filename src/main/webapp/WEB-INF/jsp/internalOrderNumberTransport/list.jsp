<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2020/7/1
  Time: 17:03
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
    <title>内部单号运输信息</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    <!--只显示用户有的店铺-->
    单号：
    <input class="easyui-validatebox textbox" id="s_orderNumber">
    子单号：
    <input class="easyui-validatebox textbox" id="s_subOrderNumber">
    fbaShipmentId：
    <input class="easyui-validatebox textbox" id="s_fbaShipmentId">
    转单号：
    <input class="easyui-validatebox textbox" id="s_transferOrderNo">
    物流渠道：
    <select class="easyui-combobox" id="s_transportTypeId" style="width:160px;">
    </select>
    装箱单：
    <select class="easyui-combobox" id="s_existFbaShipmentIdShort" style="width:100px;">
        <option value="">全部</option>
        <option value="1">有</option>
        <option value="0">无</option>
    </select>
    费率锁定状态：
    <select class="easyui-combobox" id="s_lockHeadTripCostRate" style="width:100px;">
        <option value="">全部</option>
        <option value="1">已锁定</option>
        <option value="0">未锁定</option>
    </select>
    创建时间：
    <input class="easyui-datebox" id="s_createTimeStart">
    -
    <input class="easyui-datebox" id="s_createTimeEnd">
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
    <a href="javascript:void(0)" onclick="showDialogImport('transferOrderNo')" class="easyui-linkbutton"
       data-options="iconCls:'icon-search'">导入转单号</a>
    <a href="javascript:void(0)" onclick="showDialogImport('headTripCostRate')" class="easyui-linkbutton"
       data-options="iconCls:'icon-search'">导入头程费率</a>
    <a href="javascript:void(0)" onclick="exportInternalOrderNumberTransport()" class="easyui-linkbutton"
       data-options="iconCls:'icon-search'">导出内部单号发货记录</a>
</div>
<table id="dg" style="width: 100%; height: auto">

</table>
<!--编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 700px; height: 300px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
    <div class="ftitle">
        <b>内部单号运输管理</b>
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
                    <input class="easyui-textbox" type="text" readonly="readonly" name="orderNumber">
                </td>
                <td>子单号：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="subOrderNumber" data-options="required:true">
                </td>
            </tr>
            <tr>
                <td>fbaShipmentId：</td>
                <td colspan="3">
                    <input class="easyui-textbox" type="text" name="fbaShipmentId" data-options="required:true"
                           style="width:90%;">
                </td>
            </tr>
            <tr>
                <td>转单号：</td>
                <td colspan="3">
                    <input class="easyui-textbox" type="text" name="transferOrderNo" data-options="required:true"
                           style="width:90%;">
                </td>
            </tr>
            <tr>
                <td>物流渠道：</td>
                <td>
                    <select class="easyui-combobox" id="transportTypeId" style="width:160px;" name="transportTypeId"
                            data-options="required:true">

                    </select>
                </td>
                <td>头程费率：</td>
                <td>
                    <input class="easyui-numberbox" data-options="precision:3,min:0.001,max:0.200" id="headTripCostRate"
                           name="headTripCostRate"></input>
                </td>
            </tr>
            <tr>
                <td>备注：</td>
                <td colspan="3">
                    <input class="easyui-textbox textbox-wide" type="text" name="remark" style="width:90%;">
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

<!--导入信息-->
<div id="dlgImport" class="easyui-dialog" style="width: 800px; height: 400px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:50, align:'center'">
    <div class="ftitle">
        <b id="importTitle"></b>
        <hr/>
        模板下载：
        <a href="" id="importTemplate"
           target="_blank">模板下载</a>
    </div>
    <form id="frmImport" method="post" novalidate="novalidate" enctype="multipart/form-data">
        <input type="file" id="importFile" name="file" accept=".xls,.xlsx"/>
        <div style="text-align:center;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" onclick="doImport()">导入</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-cancel'" onclick="closeDialogImport()">关闭</a>
        </div>
    </form>
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
            subOrderNumber: $("#s_subOrderNumber").val(),
            fbaShipmentId: $("#s_fbaShipmentId").val(),
            transferOrderNo: $("#s_transferOrderNo").val(),
            createTimeStart: $("#s_createTimeStart").val(),
            createTimeEnd: $("#s_createTimeEnd").val(),
            transportTypeId: $('#s_transportTypeId').combobox('getValue'),
            lockHeadTripCostRate: $('#s_lockHeadTripCostRate').combobox('getValue'),
            existFbaShipmentIdShort: $('#s_existFbaShipmentIdShort').combobox('getValue')
        };
        return queryParams;
    }

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/internalOrderNumberTransport/listInternalOrderNumberTransport";
        title = "内部单号运输信息";
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
                {title: '单号', field: 'orderNumber', width: 120},
                {title: '子单号', field: 'subOrderNumber', width: 140},
                {title: 'fbaShipmentId', field: 'fbaShipmentId', width: 190},
                {title: '转单号', field: 'transferOrderNo', width: 190},
                {title: '物流渠道', field: 'transportTypeName', width: 120},
                {
                    title: '重量kg', field: 'weight', width: 90,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-numberbox " min="0" precision="2" onchange="saveWeight(this,' + row.id + ')">';
                        } else {
                            return '<input class="easyui-numberbox" min="0" precision="2" value="' + value + '" onchange="saveWeight(this,' + row.id + ')">';
                        }
                    }
                },
                {title: '头程费率', field: 'headTripCostRate', width: 65},
                {
                    title: '锁定费率', field: 'lockHeadTripCostRate', width: 65,
                    formatter: function (value, row, index) {
                        if (value == 1) {
                            return '锁定';
                        } else {
                            return '未锁定';
                        }
                    }
                },
                {
                    title: '装箱单', field: 'existFbaShipmentIdShort', width: 65,
                    formatter: function (value, row, index) {
                        if (value == 0) {
                            return '无';
                        } else if (value == 1) {
                            return '有';
                        }
                    }
                },
                {title: '创建时间', field: 'createTime', width: 180},
                {title: '修改时间', field: 'updateTime', width: 180},
                {title: '备注', field: 'internalOrderNumberRemark', width: 120},
                {title: 'fba发货信息', field: 'fplInfo', width: 700}
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
        window.open("${pageContext.request.contextPath }/internalOrderNumberTransport/add")
    }

    function showEditDialog() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            if (rows[0].lockHeadTripCostRate == 1) {
                $("#headTripCostRate").numberbox('disable', true);
            } else {
                $("#headTripCostRate").numberbox('enable', true);
            }
            $('#dlg').dialog('open').dialog('setTitle', '修改');
            $('#frm').form('load', rows[0]);
            $("#btn_save").show();
            $(".view_hide").hide();
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function sendOrderNumberTransport() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $.messager.confirm('提示', '是否要将子单号：' + rows[0].subOrderNumber + ',设置为已发货？', function (r) {
                if (r) {
                    $.post('${pageContext.request.contextPath }/internalOrderNumberTransport/sendInternalOrderNumberTransport', {id: rows[0].id}, function (data) {
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

    function closeDialog() {
        $('#dlg').dialog('close');
    }

    function saveWeight(input, id) {
        var weight = $(input).val();
        if (isEmpty(weight)) {
            weight = null;
        }else{
            var r = /^[+]{0,1}(\d+)$|^[+]{0,1}(\d+\.\d+)$/;　　//正数
            if (!r.test(weight)) {
                $.messager.alert("提示", "补货数量必须为大于等于0的数字.");
                $(input).focus()
                return;
            }
        }

        $.post('${pageContext.request.contextPath }/internalOrderNumberTransport/saveInternalOrderNumberTransportWight', {
            id: id,
            weight: weight
        }, function (data) {
            if (data.code == '200') {
            }
            else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function save() {
        var subOrderNumber = $("div#dlg input[name='subOrderNumber']").val();
        if (subOrderNumber == '') {
            $.messager.alert("提示", '请填写子单号');
            return;
        }
        var fbaShipmentId = $("div#dlg input[name='fbaShipmentId']").val();
        if (fbaShipmentId == '') {
            $.messager.alert("提示", 'fbaShipmentId');
            return;
        }
        var transferOrderNo = $("div#dlg input[name='transferOrderNo']").val();
        if (transferOrderNo == '') {
            $.messager.alert("提示", '请填写转单号');
            return;
        }
        var transportTypeId = $('#transportTypeId').combobox('getValue');
        if (isEmpty(transportTypeId)) {
            $.messager.alert("提示", '请选择物流渠道');
            return;
        }
        $('#frm').form('submit', {
            url: '${pageContext.request.contextPath }/internalOrderNumberTransport/saveInternalOrderNumberTransport',
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

    var importUrl;

    function showDialogImport(importType) {
        var importTitle;
        switch (importType) {
            case 'transferOrderNo':
                importTitle = "导入转单号";
                importTemplateUrl = "${pageContext.request.contextPath }/static/template/internalOrderNumberTransport/transferOrderNoImportTemplate.xlsx";
                importUrl = '${pageContext.request.contextPath }/internalOrderNumberTransport/importTransferOrderNo';
                break;
            case 'headTripCostRate':
                importTitle = "导入头程费率（不会更新已锁定数据）";
                importTemplateUrl = "${pageContext.request.contextPath }/static/template/internalOrderNumberTransport/headTripCostRateImportTemplate.xlsx";
                importUrl = '${pageContext.request.contextPath }/internalOrderNumberTransport/importHeadTripCostRate';
                break;
        }
        if (isEmpty(importTitle)) {
            $.messager.alert("提示", "请选择正确的导入类型.");
            return;
        }
        $("#importTitle").text(importTitle);
        $("#importTemplate").attr("href", importTemplateUrl);
        $('#dlgImport').dialog('open').dialog('setTitle', importTitle);
    }

    function closeDialogImport() {
        $('#dlgImport').dialog('close');
    }

    function doImport() {
        var importFile = $("#importFile").val();
        if (importFile == '') {
            $.messager.alert("提示", "请选择导入的文件");
            return;
        }
        var dom = document.getElementById("importFile");
        var fileSize = dom.files[0].size;
        if (fileSize > 30000000) {
            $.messager.alert("提示", "上传文件过大,请上传小于30M的文件");
            return false;
        }
        if (isEmpty(importUrl)) {
            $.messager.alert("提示", "请选择正确的导入类型");
            return;
        }
        $('#frmImport').form('submit', {
            url: importUrl,
            onSubmit: function () {
                var isValid = $(this).form('validate');
                if (isValid) {
                    showCover();
                }
                return isValid;
            },
            success: function (data) {
                hideCover();
                res = eval("(" + data + ")")
                if (res.code == '200') {
                    $.messager.alert("提示", "上传成功");
                    bindData();
                }
                else {
                    $.messager.alert("提示", res.message);
                }
            }
        });
    }

    function exportInternalOrderNumberTransport() {
        queryParams = getQueryParams();
        url = "${pageContext.request.contextPath }/internalOrderNumberTransport/exportInternalOrderNumberTransport" + getUrlParams(queryParams);
        window.open(url);
    }

</script>
</html>
