<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2019/8/12
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <link rel="stylesheet"
              href="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.5.4/themes/default/easyui.css"
              type="text/css">
        <link rel="stylesheet"
              href="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.5.4/themes/icon.css"
              type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.5.4/demo/demo.css"
              type="text/css">
        <script type="text/javascript"
                src="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.5.4/jquery.min.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.5.4/jquery.easyui.min.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.5.4/locale/easyui-lang-zh_CN.js"></script>
        <title>京东sku打印管理</title>
    </head>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    产品名称：
    <input class="easyui-validatebox textbox" id="s_productName">
    品名：
    <input class="easyui-validatebox textbox" id="s_category">
    型号：
    <input class="easyui-validatebox textbox" id="s_model">
    规格：
    <input class="easyui-validatebox textbox" id="s_spec">
    产品成分：
    <input class="easyui-validatebox textbox" id="s_material">
    执行标准：
    <input class="easyui-validatebox textbox" id="s_criteria">
    安全类别：
    <input class="easyui-validatebox textbox" id="s_securityCategories">
    质量等级：
    <input class="easyui-validatebox textbox" id="s_qualityGrade">
    检验员：
    <input class="easyui-validatebox textbox" id="s_inspector">
    制造商：
    <input class="easyui-validatebox textbox" id="s_manufacturer">
    地址：
    <input class="easyui-validatebox textbox" id="s_productionAddress">
    模板：
    <select class="easyui-combobox" id="s_printTemplate" style="width:100px;">
        <option value="">全部</option>
        <option value="1">布艺</option>
    </select>
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
</div>
<%--数据列表--%>
<table id="dg" style="width: 100%; height: auto">

</table>
<!--编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 700px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
    <div class="ftitle">
        <b>京东sku信息</b>
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
                <td>产品名：</td>
                <td colspan="3">
                    <input class="easyui-textbox" type="text" name="productName" width="90%">
                </td>
            </tr>
            <tr>
                <td>京东sku：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="jdSku">
                </td>
                <td>京东POP条码：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="jdPopCode">
                </td>
            </tr>

            <tr>
                <td>品名：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="category">
                </td>
                <td>品牌：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="brand">
                </td>
            </tr>
            <tr>
                <td>型号：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="model">
                </td>
                <td>规格：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="spec">
                </td>
            </tr>
            <tr>
                <td>产品成分：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="material">
                </td>
                <td>执行标准：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="criteria">
                </td>
            </tr>
            <tr>
                <td>安全类别：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="securityCategories">
                </td>
                <td>质量等级：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="qualityGrade">
                </td>
            </tr>
            <tr>
                <td>检验员：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="inspector">
                </td>
                <td>制造商：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="manufacturer">
                </td>
            </tr>
            <tr>
                <td>地址：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="productionAddress">
                </td>
                <td>打印模板：</td>
                <td>
                    <select class="easyui-combobox" name="printTemplate" style="width:100px;">
                        <option value="1">布艺</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>备注：</td>
                <td colspan="3">
                    <input class="easyui-textbox" type="text" name="remark" width="90%">
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
    $(document).ready(function () {
        bindData();
    });

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/jdSku/list";
        title = "京东sku列表";
        queryParams = {
            productName: $("#s_productName").val(),
            category: $("#s_category").val(),
            model: $("#s_model").val(),
            spec: $("#s_spec").val(),
            material: $("#s_material").val(),
            criteria: $("#s_criteria").val(),
            securityCategories: $("#s_securityCategories").val(),
            qualityGrade: $("#s_qualityGrade").val(),
            inspector: $("#s_inspector").val(),
            manufacturer: $("#s_manufacturer").val(),
            productionAddress: $("#s_productionAddress").val(),
            printTemplate: $("#s_printTemplate").combobox('getValue')
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
                {title: '产品名称', field: 'productName', width: 120},
                {title: '京东sku', field: 'jdSku', width: 120},
                {title: '京东POP条码', field: 'jdPopCode', width: 120},
                {title: '品名', field: 'category', width: 140},
                {title: '品牌', field: 'brand', width: 140},
                {title: '型号', field: 'model', width: 120},
                {title: '规格', field: 'spec', width: 120},
                {title: '产品成分', field: 'material', width: 120},
                {title: '执行标准', field: 'criteria', width: 120},
                {title: '安全类别', field: 'securityCategories', width: 120},
                {title: '质量等级', field: 'qualityGrade', width: 120},
                {title: '检验员', field: 'inspector', width: 120},
                {title: '制造商', field: 'manufacturer', width: 120},
                {title: '地址', field: 'productionAddress', width: 120},
                {title: '打印模板', field: 'printTemplate', width: 120},
                {
                    title: '操作', field: 'shopSku', width: 170, formatter: function (value, row, index) {
                    return "<a href='#' onclick=\"print('" + id + "')\"' title='打印标签' >打印标签</a>";
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

    function save() {
        //防止重复点击
        var productName = $("div#dlg input[name='productName']").val();
        if (productName == '') {
            $.messager.alert("提示", '请填写产品名称');
            return;
        }
        var productCode = $("div#dlg input[name='productCode']").val();
        if (productCode == '') {
            $.messager.alert("提示", '请填写货号');
            return;
        }
        var chineseProductName = $("div#dlg input[name='chineseProductName']").val();
        if (chineseProductName == '') {
            $.messager.alert("提示", '请填写中文报关名');
            return;
        }
        var englishProductName = $("div#dlg input[name='englishProductName']").val();
        if (englishProductName == '') {
            $.messager.alert("提示", '请填写英文报关名');
            return;
        }
        $('#frm').form('submit', {
            url: '${pageContext.request.contextPath }/product/save',
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
                var productIds = new Array();
                for (var i = 0; i < rows.length; i++) {
                    productIds.push(rows[i].productId);
                }
                $.post('${pageContext.request.contextPath }/product/delete', {productIds: productIds}, function (data) {
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
</html>
