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

    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.5.4/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/main.css?t=20200928" type="text/css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/common/common.js?t=20201028"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/common/cookieUtil.js?t=20200928"></script>
    <style>
        .grid-panel .datagrid-row {
            height: 42px;
        }
    </style>
    <title>产品列表</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    产品名：
    <input class="easyui-validatebox textbox" id="s_productName">
    货号：
    <input class="easyui-validatebox textbox" id="s_productCode">
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
    <a href="javascript:void(0)" id="a_importProduct" onclick="showDialogImport('product')"
       class="easyui-linkbutton a_hide"
       data-options="iconCls:'icon-search'"
       style="">导入产品</a>
    <a href="javascript:void(0)" id="a_importDeveloperUser" onclick="showDialogImport('developerUser')"
       class="easyui-linkbutton a_hide"
       data-options="iconCls:'icon-search'"
       style="">导入产品开发人员</a>
    <a href="javascript:void(0)" id="a_importDevelopmentLevel" onclick="showDialogImport('developmentLevel')"
       class="easyui-linkbutton a_hide"
       data-options="iconCls:'icon-search'"
       style="">导入开发等级</a>
    <a href="javascript:void(0)" id="a_importLabourCost" onclick="showDialogImport('labourCost')"
       class="easyui-linkbutton a_hide"
       data-options="iconCls:'icon-search'"
       style="">导入工价</a>

    <a href="javascript:void(0)" id="a_importhsCode" onclick="showDialogImport('hsCode')"
       class="easyui-linkbutton"
       data-options="iconCls:'icon-search'"
       style="">导入海关编码</a>
    <a href="javascript:void(0)" id="a_exportProduct" onclick="exportProduct()" class="easyui-linkbutton a_hide"
       data-options="iconCls:'icon-search'"
       style="">导出产品</a>
</div>
<table id="dg" style="width: 100%; height: auto">

</table>
<!--编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 600px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
    <div class="ftitle">
        <b>产品信息</b>
        <hr/>
    </div>
    <form id="frm" method="post" novalidate="novalidate">
        <table>
            <tr style="display: none">
                <td>productId：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="productId">
                </td>
            </tr>
            <tr>
                <td>产品名：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="productName" data-options="required:true">
                </td>
                <td>货号：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="productCode" data-options="required:true">
                </td>
            </tr>
            <tr>
                <td>中文报关名：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="chineseProductName" data-options="required:true">
                </td>
                <td>英文报关名：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="englishProductName" data-options="required:true">
                </td>
            </tr>
            <tr>
                <td>海关编码：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="hsCode">
                </td>
            </tr>
            <tr>
                <td>产品描述：</td>
                <td colspan="3">
                    <input class="easyui-textbox" data-options="multiline:true" name="description" value=""
                           style="width:95%;height:66px">
                </td>
            </tr>
            <tr>
                <td>开发人员：</td>
                <td>
                    <%--暂时使用用户下拉列表--%>
                    <select id="s_developerUserId" name="developerUserId" style="width:150px;">
                    </select>
                </td>
                <td>开发时间：</td>
                <td>
                    <input name="developmentTime" id="developmentTime"
                           class="easyui-datebox"/>
                </td>
            </tr>
            <tr>
                <td>开发等级：</td>
                <td>
                    <input class="easyui-numberbox" name="developmentLevel" id="developmentLevel" min="0" max="10"
                           precision="0">
                </td>
                <td>工价：</td>
                <td>
                    <input class="easyui-numberbox" name="labourCost" id="labourCost" readonly="readonly" min="0"
                           max="10000"
                           precision="2">
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
                    <input class="easyui-textbox" data-options="multiline:true" name="remark" value=""
                           style="width:95%;height:66px">
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
<div id="dlgProductLabourCostHis" class="easyui-dialog" style="width: 780px; height: 400px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true,top:50, align:'center'">
    <table id="dgProductLabourCostHis" style="width: 100%; height: auto">
    </table>
</div>
<!--导入信息-->
<div id="dlgImport" class="easyui-dialog" style="width: 600px; height: 300px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
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

<div id="cover">
    <div id="coverMsg">
        <img src="${pageContext.request.contextPath }/static/img/loading.gif" width="100px">
    </div>
</div>
<script type="text/javascript">
    bindData();
    bindDeveloperUserId();
    initOperationRight();

    function initOperationRight() {
        if (hasRight("product/importProduct")) {
            $("#a_importProduct").show()
        }
        if (hasRight("product/importDeveloperUser")) {
            $("#a_importDeveloperUser").show();
            $("#a_importDevelopmentLevel").show();
        }
        if (hasRight("product/exportProduct")) {
            $("#a_exportProduct").show()
        }
        if (!hasRight("product/saveProduct")) {
            $("#btnAdd").hide();
            $("#btnEdit").hide();
        }
        if (!hasRight("product/deleteProduct")) {
            $("#btnDelete").hide()
        }
        if (hasRight("product/labourCost")) {
            $("#a_importLabourCost").show();
            $("#labourCost").attr("readonly", false);
        }
    }

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/product/list";
        title = "产品管理";
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
            idField: 'productId',
            queryParams: queryParams,  //异步查询的参数
            columns: [[
                {field: 'ck', checkbox: true},   //选择
                {title: '产品名', field: 'productName', width: 100},
                {
                    title: '图片', field: 'imgUrl', width: 70,
                    formatter: function (value, rowData, rowIndex) {
                        var res = "";
                        if (value != null && value != '') {
                            res += '<img  src="' + value + '?x-oss-process=image/resize,m_fill,h_66,w_66" onclick="showImg(' + value + ')"  style="width:66px; height:66px;"/>'
                        } else {
                            res += '暂无图片'
                        }
                        return res;
                    }
                },
                {title: '产品编码', field: 'productCode', width: 100},
                {title: '中文报关名', field: 'chineseProductName', width: 100},
                {title: '英文报关名', field: 'englishProductName', width: 100},
                {title: '海关编码', field: 'hsCode', width: 100},
                {title: '开发人员', field: 'developerUserName', width: 100},
                {title: '开发等级', field: 'developmentLevel', width: 65},
                {
                    title: '开发时间', field: 'developmentTime', width: 100,
                    formatter: function (value, rowData, rowIndex) {
                        var res = "";
                        if (value != null && value != '') {
                            res += value.substr(0, 10);
                        }
                        return res;
                    }
                },
                {
                    title: '工价', field: 'labourCost', width: 65,
                    formatter: function (value, rowData, rowIndex) {
                        var res = "";
                        if (value != null && value != '') {
                            res += '<a href="javascript:;" onclick="showProductLabourCostHisDialog(' + rowData.productId + ')" title="查看历史工价">' + value + '</a>';
                        } else {
                            res += '<a href="javascript:;" onclick="showProductLabourCostHisDialog(' + rowData.productId + ')" title="查看历史工价">暂无工价</a>';
                        }
                        return res;
                    }
                },
                {title: '成本价最小值', field: 'costPriceMin', width: 100},
                {title: '成本价最大值', field: 'costPriceMax', width: 100},
                {title: '头程费用最小值', field: 'headTripCostMin', width: 100},
                {title: '头程费用最大值', field: 'headTripCostMax', width: 100},
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
            },
                '-', {
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
                },
                '-', {
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
        initOperationRight();
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

    function bindDeveloperUserId() {
        $('#s_developerUserId').combobox({
            valueField: 'userId',
            textField: 'realName',
            url: "${pageContext.request.contextPath }/user/comboboxlist",//获取数据
        });
    }

    function showAddDialog() {
        $('#dlg').dialog('open').dialog('setTitle', '添加');
        $('#frm').form('clear');
        $("#btn_save").show();
        $(".view_hide").hide();
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
                } else {
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
                var productIds = new Array();
                for (var i = 0; i < rows.length; i++) {
                    productIds.push(rows[i].productId);
                }
                $.post('${pageContext.request.contextPath }/product/delete', {productIds: productIds}, function (data) {
                    if (data.code == '200') {
                        $('#dlg').dialog('close');
                        bindData();
                    } else {
                        $.messager.alert("提示", data.message);
                    }
                });
            }
        });
    }

    function showImg(url) {
        window.open(url);
    }

    var importUrl;

    function showDialogImport(importType) {
        var importTitle;
        switch (importType) {
            case 'product':
                importTitle = "导入产品信息";
                importTemplateUrl = "${pageContext.request.contextPath }/static/template/product/productTemplate.xlsx";
                importUrl = '${pageContext.request.contextPath }/product/importProduct';
                break;
            case 'developerUser':
                importTitle = "导入产品开发人员";
                importTemplateUrl = "${pageContext.request.contextPath }/static/template/product/developerUserTemplate.xlsx";
                importUrl = "${pageContext.request.contextPath }/product/importDeveloperUser";
                break;
            case 'developmentLevel':
                importTitle = "导入开发等级";
                importTemplateUrl = "${pageContext.request.contextPath }/static/template/product/developmentLevelTemplate.xlsx";
                importUrl = "${pageContext.request.contextPath }/product/importDevelopmentLevel";
                break;
            case 'labourCost':
                importTitle = "导入工价";
                importTemplateUrl = "${pageContext.request.contextPath }/static/template/product/labourCostTemplate.xlsx";
                importUrl = "${pageContext.request.contextPath }/product/importLabourCost";
                break;
                case 'hsCode':
                    importTitle = "导入海关编码";
                    importTemplateUrl = "${pageContext.request.contextPath }/static/template/product/hsCodeTemplate.xlsx";
                    importUrl = "${pageContext.request.contextPath }/product/importHsCode";
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
                } else {
                    $.messager.alert("提示", res.message);
                }
            }
        });
    }

    function getQueryParams() {
        queryParams = {
            productName: $("#s_productName").val(),
            productCode: $("#s_productCode").val()
        };
        return queryParams;
    }

    function exportProduct() {
        queryParams = getQueryParams();
        url = "${pageContext.request.contextPath }/product/exportProduct" + getUrlParams(getQueryParams());
        window.open(url);
    }

    var productLabourCostProductId;

    function showProductLabourCostHisDialog(productId) {
        $('#dlgProductLabourCostHis').dialog('open').dialog('setTitle', '工价历史');
        productLabourCostProductId = productId;
        bindProductLabourCostHisData();
    }

    function bindProductLabourCostHisData() {
        dg = '#dgProductLabourCostHis';
        url = "${pageContext.request.contextPath }/productLabourCostHis/listProductLabourCostHis";
        title = "工价历史管理";
        queryParams = {
            productId: productLabourCostProductId
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
                {title: '产品编码', field: 'productCode', width: 120},
                {title: '修改前价格', field: 'labourCostBefore', width: 90},
                {title: '修改后价格', field: 'labourCostAfter', width: 90},
                {title: '修改人姓名', field: 'createUserName', width: 80},
                {title: '修改类型', field: 'typeName', width: 100},
                {title: '修改时间', field: 'createTime', width: 160}
            ]],
            toolbar: [{
                id: 'btnSkuCostPriceReload',
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
</script>
</body>
</html>
