<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2020/2/27
  Time: 9:35
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
            src="${pageContext.request.contextPath }/static/js/common/common.js?t=20200929"></script>
    <title>标签打印</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
    <a href="javascript:void(0)" onclick="showDialogImport()" class="easyui-linkbutton"
       data-options="iconCls:'icon-search'"
       style="">导入标签打印信息</a>
</div>
<table id="dg" style="width: 100%; height: auto">

</table>
<!--编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 800px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
    <div class="ftitle">
        <b>卖家sku</b>
        <a href="javascript:void(0)" onclick="exportLablePrint(null)" class="easyui-linkbutton"
           data-options="iconCls:'icon-search'"
           style="">下载</a>
        <hr/>
    </div>
    <table id="dgShopSku" style="width: 100%; height: auto">

    </table>
    <div style="text-align:center;">
        <a href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-cancel'" onclick="closeDialog()">关闭</a>
    </div>
</div>
<!--导入信息-->
<div id="dlgImport" class="easyui-dialog" style="width: 600px; height: 300px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
    <div class="ftitle">
        <b id="importTitle"></b>
        <hr/>
        模板下载：
        <a href="${pageContext.request.contextPath }/static/template/labelPrint/labelPrintTemplate.xlsx"
           id="importTemplate"
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
</body>
<script type="text/javascript">
    bindData();

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/labelPrint/list";
        title = "标签打印";
        queryParams = {};
        $(dg).datagrid({   //定位到Table标签，Table标签的ID是grid
            url: url,   //指向后台的Action来获取当前菜单的信息的Json格式的数据
            title: title,
            iconCls: 'icon-view',
            nowrap: true,
            autoRowHeight: false,
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
                {
                    title: 'sku标签打印', field: 'id', width: 150,
                    formatter: function (value, row, index) {
                        return '<a href="javascript:;" onclick="showShopSku(\'' + row.id + '\')" title="sku标签打印">sku标签打印</a>';
                    }
                }, {
                    title: '操作', field: 'deal', width: 150,
                    formatter: function (value, row, index) {
                        return '<a href="javascript:;" onclick="exportLablePrint(\'' + row.id + '\')" title="下载">下载</a>';
                    }
                },
                {
                    title: '备注', field: 'remark', width: 288,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-textbox " style="width:100%"  onchange="saveLabelPrintRemark(this,' + row.id + ')">';
                        } else {
                            return '<input class="easyui-textbox" style="width:100%" value="' + value + '" onchange="saveLabelPrintRemark(this,' + row.id + ')">';
                        }
                    }
                },
                {title: '创建时间', field: 'createTime', width: 180}
            ]],
            toolbar: [{
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

    function showViewDialog() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            showShopSku(rows[0].id);
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function closeDialog() {
        $('#dlg').dialog('close');
    }

    var localLabelPrintId;

    function showShopSku(labelPrintId) {
        $('#dlg').dialog('open').dialog('setTitle', '查看');
        localLabelPrintId = labelPrintId;
        bindShopSku(labelPrintId);
    }

    function bindShopSku(labelPrintId) {
        dg = '#dgShopSku';
        url = "${pageContext.request.contextPath }/labelPrintShopSku/list";
        title = "标签打印";
        queryParams = {
            labelPrintId: labelPrintId
        }
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
                {title: '店铺sku', field: 'shopSku', width: 120},
                {title: '产品sku', field: 'sku', width: 120},
                {title: 'fnsku', field: 'fnsku', width: 120},
                {title: '数量', field: 'quantity', width: 100},
                {
                    title: '图片', field: 'imgUrl', width: 70,
                    formatter: function (value, rowData, rowIndex) {
                        var res = "";
                        if (value != null && value != '') {
                            res += '<img  src="' + value + '?x-oss-process=image/resize,m_fill,h_66,w_66" style="width:66px; height:66px;"/>'
                        } else {
                            res += '暂无图片'
                        }
                        return res;
                    }
                },
                {
                    title: '操作', field: 'shopSkuId', width: 150,
                    formatter: function (value, row, index) {
                        return '<a href="javascript:;" onclick="showPrintLabel(\'' + row.shopSku + '\','+row.quantity+')" title="打印标签">打印标签</a>'
                            +'&nbsp;&nbsp;&nbsp;<a href="javascript:;" onclick="showPrintLabel7040(\'' + row.shopSku + '\','+row.quantity+')" title="打印7040标签">打印7040标签</a>';
                    }
                }
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

    function showPrintLabel(shopSku,quantity) {
        if (isEmpty(shopSku)) {
            window.open("${pageContext.request.contextPath }/shopSku/print");
        } else {
            window.open("${pageContext.request.contextPath }/shopSku/print?shopSku=" + shopSku+"&quantity="+quantity);
        }
    }

    function showPrintLabel7040(shopSku,quantity) {
        if (isEmpty(shopSku)) {
            window.open("${pageContext.request.contextPath }/shopSku/print7040");
        } else {
            window.open("${pageContext.request.contextPath }/shopSku/print7040?shopSku=" + shopSku+"&quantity="+quantity);
        }
    }

    function showDialogImport() {
        $('#dlgImport').dialog('open').dialog('setTitle', '导入标签打印');
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
        $('#frmImport').form('submit', {
            url: "${pageContext.request.contextPath }/labelPrint/importLabelPrint",
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

    function saveLabelPrintRemark(input, labelPrintId) {
        var remark = $(input).val();
        $.post('${pageContext.request.contextPath }/labelPrint/saveLabelPrintRemark', {
            labelPrintId: labelPrintId,
            remark: remark
        }, function (data) {
            if (data.code == '200') {
                $.messager.alert("提示", "修改成功");
                bindData();
            }
            else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function exportLablePrint(labelPrintId) {
        if (isEmpty(labelPrintId)) {
            labelPrintId = localLabelPrintId;
        }
        if (isEmpty(labelPrintId)) {
            $.messager.alert("提示", "请选择要下载的标签打印信息");
            return;
        }
        window.open('${pageContext.request.contextPath }/labelPrint/exportLablePrint?labelPrintId=' + labelPrintId);
    }
</script>
</html>
