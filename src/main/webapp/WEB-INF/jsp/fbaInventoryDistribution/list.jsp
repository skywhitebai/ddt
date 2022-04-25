<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2020/7/2
  Time: 10:51
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
    <title>国家管理</title>
</head>
<style>
    .textbox-wide {
        width: 500px;
    }
</style>
<body>
<!--查询条件-->
<div class="easyui-panel">
    <!--只显示用户有的店铺-->
    snapshotDay：
    <input class="easyui-datebox" id="s_snapshotDay">
    fnsku：
    <input class="easyui-validatebox textbox" id="s_fnsku">
    sku：
    <input class="easyui-validatebox textbox" id="s_sku">
    productName：
    <input class="easyui-validatebox textbox" id="s_productName">
    fulfillmentCenterId：
    <input class="easyui-validatebox textbox" id="s_fulfillmentCenterId">
    detailedDisposition：
    <input class="easyui-validatebox textbox" id="s_detailedDisposition">
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>

    <a href="javascript:void(0)" id="a_importStorageLocation" onclick="showDialogImport()"
       class="easyui-linkbutton"
       data-options="iconCls:'icon-search'"
       style="">导入库存分布信息</a>
</div>
<table id="dg" style="width: 100%; height: auto">

</table>

<!--导入信息-->
<div id="dlgImport" class="easyui-dialog" style="width: 600px; height: 300px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true,top:50, align:'center'">
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
    bindData();

    function getQueryParams() {
        queryParams = {
            snapshotDay: $("#s_snapshotDay").val(),
            fnsku: $("#s_fnsku").val(),
            sku: $("#s_sku").val(),
            productName: $("#s_productName").val(),
            fulfillmentCenterId: $("#s_fulfillmentCenterId").val(),
            detailedDisposition: $("#s_detailedDisposition").val()
        };
        return queryParams;
    }

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/fbaInventoryDistribution/listFbaInventoryDistribution";
        title = "fba库存管理";
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
                {
                    title: '日期', field: 'snapshotDay', width: 70,
                    formatter: function (value, rowData, rowIndex) {
                        return value.slice(0, 10);
                    }
                },
                {title: 'snapshotDate', field: 'snapshotDate', width: 180},
                {title: 'fnsku', field: 'fnsku', width: 100},
                {title: 'sku', field: 'sku', width: 100},
                {title: 'productName', field: 'productName', width: 180},
                {title: '数量', field: 'quantity', width: 40},
                {title: '仓库', field: 'fulfillmentCenterId', width: 60},
                {title: 'detailedDisposition', field: 'detailedDisposition', width: 100},
                {title: '国家', field: 'country', width: 60},
                {title: '创建时间', field: 'createTime', width: 120},
                {title: '修改时间', field: 'updateTime', width: 120}
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


    function closeDialog() {
        $('#dlg').dialog('close');
    }

    var importUrl;

    function showDialogImport() {
        importTitle = "导入建议零售价";
        importTemplateUrl = "${pageContext.request.contextPath }/static/template/fbaInventoryDistribution/fbaInventoryDistributionTemplate.xlsx";
        importUrl = "${pageContext.request.contextPath }/fbaInventoryDistribution/importFbaInventoryDistribution";
        $("#importTitle").text(importTitle);
        $("#importTemplate").attr("href", importTemplateUrl);
        $('#dlgImport').dialog('open').dialog('setTitle', "导入仓库细腻些");
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

    function closeDialogImport() {
        $('#dlgImport').dialog('close');
    }
</script>
</html>