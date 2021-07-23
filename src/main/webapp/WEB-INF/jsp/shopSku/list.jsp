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

    <title>店铺sku</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    <!--只显示用户有的店铺-->
    店铺：
    <select id="s_shopId" style="width:150px;">
    </select>
    店铺sku：
    <input class="easyui-validatebox textbox" id="s_shopSku">
    店铺父sku：
    <input class="easyui-validatebox textbox" id="s_shopParentSku">
    ASIN：
    <input class="easyui-validatebox textbox" id="s_asin">
    店铺父ASIN：
    <input class="easyui-validatebox textbox" id="s_parentAsin">
    产品编码：
    <input class="easyui-validatebox textbox" id="s_productCode">
    产品sku：
    <input class="easyui-validatebox textbox" id="s_sku">
    产品名称：
    <input class="easyui-validatebox textbox" id="s_productName">
    状态：
    <select class="easyui-combobox" id="s_status" style="width:100px;">
        <option value="">全部</option>
        <option value="1">启用</option>
        <option value="0">停用</option>
    </select>
    生产状态：
    <select class="easyui-combobox" id="s_produceStatus" style="width:100px;">
        <option value="">全部</option>
        <option value="1">正常生产</option>
        <option value="2">暂停生产</option>
    </select>
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
    <a href="javascript:void(0)" id="a_importShopSkuStatus" onclick="showDialogImport('shopSkuStatus')" class="easyui-linkbutton a_hide"
       data-options="iconCls:'icon-search'"
       style="">导入店铺sku状态</a>
    <a href="javascript:void(0)" id="a_importShopSku" onclick="showDialogImport('shopSku')" class="easyui-linkbutton a_hide"
       data-options="iconCls:'icon-search'"
       style="">导入店铺sku</a>
    <a href="javascript:void(0)" id="a_exportShopSku" onclick="exportShopSku()" class="easyui-linkbutton a_hide"
       data-options="iconCls:'icon-search'"
       style="">导出店铺sku</a>
    <a href="javascript:void(0)" id="a_importShopParentSku" onclick="showDialogImport('shopParentSku')" class="easyui-linkbutton a_hide"
       data-options="iconCls:'icon-search'"
       style="">导入店铺父sku</a>
    <a href="javascript:void(0)" id="a_importSalesmanUser" onclick="showDialogImport('salesmanUser')" class="easyui-linkbutton a_hide"
       data-options="iconCls:'icon-search'"
       style="">导入店铺sku销售人员</a>
    <a href="javascript:void(0)" onclick="showTransformShopSku()" class="easyui-linkbutton"
       data-options="iconCls:'icon-search'"
       style="">店铺sku信息转换</a>

    <a href="javascript:void(0)" onclick="showPrintLabel('','')" class="easyui-linkbutton"
       data-options="iconCls:'icon-search'"
       style="">打印标签</a>
    <a href="javascript:void(0)" onclick="showPrintLabel7040('','')" class="easyui-linkbutton"
       data-options="iconCls:'icon-search'"
       style="">打印7040标签</a>
</div>
<table id="dg" style="width: 100%; height: auto">

</table>
<!--编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 700px; height: 560px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:50,align:'center'">
    <div class="ftitle">
        <b>卖家sku</b>
        <hr/>
    </div>
    <form id="frm" method="post" novalidate="novalidate">
        <table>
            <tr style="display: none">
                <td>shop_sku_id：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="shopSkuId">
                </td>
            </tr>
            <tr>
                <td>店铺名：</td>
                <td colspan="3">
                    <input class="easyui-textbox" type="text" data-options="disabled:true" name="shopName"
                           style="width: 90%">
                </td>
            </tr>
            <tr>
                <td>产品名：</td>
                <td colspan="3">
                    <input class="easyui-textbox" type="text" data-options="disabled:true" name="productName"
                           style="width: 90%">
                </td>
            </tr>
            <tr>
                <td>标题：</td>
                <td colspan="3">
                    <input class="easyui-textbox" type="text" name="title" data-options="required:true"
                           style="width: 90%">
                </td>
            </tr>
            <tr>
                <td>产品编码：</td>
                <td>
                    <input class="easyui-textbox" type="text" data-options="disabled:true" name="productCode">
                </td>
                <td>产品sku：</td>
                <td>
                    <input class="easyui-textbox" type="text" data-options="disabled:true" name="sku">
                </td>
            </tr>
            <tr>
                <td>颜色：</td>
                <td>
                    <input class="easyui-textbox" type="text" data-options="disabled:true" name="colour">
                </td>
                <td>色号：</td>
                <td>
                    <input class="easyui-textbox" type="text" data-options="disabled:true" name="colourNumber">
                </td>
            </tr>
            <tr>
                <td>店铺sku：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="shopSku" data-options="required:true">
                </td>

                <td>店铺父sku：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="shopParentSku" data-options="required:true">
                </td>
            </tr>
            <tr>

                <td>FNSKU：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="fnsku" data-options="required:true">
                </td>
                <td>销售人员：</td>
                <td>
                    <%--暂时使用用户下拉列表--%>
                    <select name="salesmanUserId" id="salesmanUserId" style="width:150px;">
                    </select>
                </td>
            </tr>
            <tr>

                <td>ASIN：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="asin">
                </td>

                <td>店铺父ASIN：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="parentAsin">
                </td>
            </tr>
            <tr>
                <td>中文报关名：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="chineseProductName" data-options="disabled:true">
                </td>
                <td>英文报关名：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="englishProductName"
                           data-options="disabled:true">
                </td>
            </tr>
            <tr>
                <td>状态：</td>
                <td>
                    <select class="easyui-combobox" name="status" style="width:100px;" data-options="required:true">
                        <option value="1" selected>启用</option>
                        <option value="0">停用</option>
                    </select>
                </td>
                <td>头程费：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="headTripCost" data-options="disabled:true">
                </td>
            </tr>
            <tr>
                <td>库存：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="inventoryQuantity" data-options="disabled:true">
                </td>
                <td>库位：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="storageLocation" >
                </td>
            </tr>
            <tr>
                <td>备注：</td>
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
    bindShop();
    bindData();
    bindSalesmanUserId();
    initOperationRight();

    function initOperationRight() {
        if (hasRight("shopSku/importShopSkuStatus")) {
            $("#a_importShopSkuStatus").show()
        }
        if (hasRight("shopSku/importShopSku")) {
            $("#a_importShopSku").show()
        }
        if (hasRight("shopSku/exportShopSku")) {
            $("#a_exportShopSku").show()
        }
        if (hasRight("shopSku/importShopParentSku")) {
            $("#a_importShopParentSku").show()
        }
        if (hasRight("shopSku/importSalesmanUser")) {
            $("#a_importSalesmanUser").show()
        }
        if (!hasRight("shopSku/saveShopSku")) {
            $("#btnAdd").hide();
            $("#btnEdit").hide();
        }
        if (!hasRight("shopSku/deleteShopSku")) {
            $("#btnDelete").hide()
        }
    }
    function bindShop() {
        $('#s_shopId').combobox({
            valueField: 'shopId',
            textField: 'shopName',
            url: "${pageContext.request.contextPath }/shop/userShopComboboxlist",//获取数据
        });
    }

    function bindSalesmanUserId() {
        $('#salesmanUserId').combobox({
            valueField: 'userId',
            textField: 'realName',
            url: "${pageContext.request.contextPath }/user/comboboxlist",//获取数据
        });
    }

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/shopSku/listShopSku";
        title = "订单管理";
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
            idField: 'shopSkuId',
            queryParams: queryParams,  //异步查询的参数
            columns: [[
                {field: 'ck', checkbox: true},   //选择
                {title: '店铺名', field: 'shopName', width: 120},
                {title: '产品编码', field: 'productCode', width: 140},
                {title: '产品sku', field: 'sku', width: 140},
                {title: '产品名称', field: 'productName', width: 120},
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
                {title: '店铺sku', field: 'shopSku', width: 120},
                {title: '颜色', field: 'colour', width: 100},
                {title: '色号', field: 'colourNumber', width: 100},
                {title: '店铺父sku', field: 'shopParentSku', width: 120},
                {title: 'FNSKU', field: 'fnsku', width: 120},
                {title: 'ASIN', field: 'asin', width: 120},
                {title: '店铺父ASIN', field: 'parentSsin', width: 120},
                {title: '库存', field: 'inventoryQuantity', width: 60},
                {title: '库位', field: 'storageLocation', width: 120},
                {title: '销售人员', field: 'salesmanUserName', width: 120},
                {title: '中文报关名', field: 'chineseProductName', width: 120},
                {title: '英文报关名', field: 'englishProductName', width: 120},
                {title: '头程费', field: 'headTripCost', width: 60},
                {title: '创建时间', field: 'createTime', width: 180},
                {title: '修改时间', field: 'updateTime', width: 180},
                {title: '标题', field: 'title', width: 120},
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
                {
                    title: '生产状态', field: 'produceStatus', width: 65,
                    formatter: function (value, row, rowIndex) {
                        if (value == 1) {
                            return '<a href="javascript:;" title="正常生产" onclick="setProduceStatus(' + row.shopSkuId + ",'" + row.shopSku + "'" + ',2)" >正常生产</a>';
                        } else if (value == 2) {
                            return '<a href="javascript:;" title="暂停生产" onclick="setProduceStatus(' + row.shopSkuId + ",'" + row.shopSku + "'"  + ',1)" >暂停生产</a>';
                        }
                    }
                },
                {
                    title: '操作', field: 'shopSkuId', width: 150,
                    formatter: function (value, row, index) {
                        return '<a href="javascript:;" onclick="showPrintLabel(\'' + row.shopSku + '\')" title="打印标签">打印标签</a>'
                            + '&nbsp;&nbsp;&nbsp;<a href="javascript:;" onclick="showPrintLabel7040(\'' + row.shopSku + '\')" title="打印7040标签">打印7040标签</a>';
                    }
                }
            ]],
            toolbar: [{
                id: 'btnView',
                text: '查看',
                iconCls: 'icon-search',
                handler: function () {
                    showViewDialog();//实现查看记录详细信息的方法
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

    function showImg(url) {
        window.open(url);
    }

    function save() {
        //防止重复点击
        var title = $("div#dlg input[name='title']").val();
        if (title == '') {
            $.messager.alert("提示", '请填写标题');
            return;
        }
        var shopSku = $("div#dlg input[name='shopSku']").val();
        if (shopSku == '') {
            $.messager.alert("提示", '请填写店铺sku');
            return;
        }
        var fnsku = $("div#dlg input[name='fnsku']").val();
        if (fnsku == '') {
            $.messager.alert("提示", '请填写FNSKU');
            return;
        }
        var shopParentSku = $("div#dlg input[name='shopParentSku']").val();
        if (shopParentSku == '') {
            $.messager.alert("提示", '请填写店铺父sku');
            return;
        }
        /* var asin = $("div#dlg input[name='asin']").val();
         if (asin == '') {
             $.messager.alert("提示", '请填写ASIN');
             return;
         }*/
        var status = $("div#dlg input[name='status']").val();
        if (status == '') {
            $.messager.alert("提示", '请填写状态');
            return;
        }
        $('#frm').form('submit', {
            url: '${pageContext.request.contextPath }/shopSku/saveShopSku',
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
                var shopSkuIds = new Array();
                for (var i = 0; i < rows.length; i++) {
                    shopSkuIds.push(rows[i].shopSkuId);
                }
                $.post('${pageContext.request.contextPath }/shopSku/deleteShopSku', {shopSkuIds: shopSkuIds}, function (data) {
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

    function exportShopSku() {
        queryParams = getQueryParams();
        url = "${pageContext.request.contextPath }/shopSku/exportShopSku" + getUrlParams(queryParams);
        window.open(url);
    }

    function getQueryParams() {
        queryParams = {
            shopId: $('#s_shopId').combobox('getValue'),
            productCode: $("#s_productCode").val(),
            shopSku: $("#s_shopSku").val(),
            sku: $("#s_sku").val(),
            productName: $("#s_productName").val(),
            shopParentSku: $("#s_shopParentSku").val(),
            asin: $("#s_asin").val(),
            parentAsin: $("#s_parentAsin").val(),
            status: $("#s_status").val(),
            produceStatus: $("#s_produceStatus").val()
        };
        return queryParams;
    }

    function closeDialog() {
        $('#dlg').dialog('close');
    }

    function showTransformShopSku() {
        window.open("${pageContext.request.contextPath }/shopSku/transformShopSku");
    }

    function showPrintLabel(shopSku) {
        if (isEmpty(shopSku)) {
            window.open("${pageContext.request.contextPath }/shopSku/print");
        } else {
            window.open("${pageContext.request.contextPath }/shopSku/print?shopSku=" + shopSku);
        }
    }

    function showPrintLabel7040(shopSku) {
        if (isEmpty(shopSku)) {
            window.open("${pageContext.request.contextPath }/shopSku/print7040");
        } else {
            window.open("${pageContext.request.contextPath }/shopSku/print7040?shopSku=" + shopSku);
        }
    }

    var importUrl;

    function showDialogImport(importType) {
        var importTitle;
        switch (importType) {
            case 'shopSkuStatus':
                importTitle = "导入店铺sku状态";
                importTemplateUrl = "${pageContext.request.contextPath }/static/template/shopSku/shopSkuStatusTemplate.xlsx";
                importUrl = '${pageContext.request.contextPath }/shopSku/importShopSkuStatus';
                break;
            case 'shopSku':
                importTitle = "导入店铺sku";
                importTemplateUrl = "${pageContext.request.contextPath }/static/template/shopSku/shopSkuTemplate.xlsx";
                importUrl = "${pageContext.request.contextPath }/shopSku/importShopSku";
                break;
            case 'shopParentSku':
                importTitle = "导入店铺父sku";
                importTemplateUrl = "${pageContext.request.contextPath }/static/template/shopSku/shopParentSkuTemplate.xlsx";
                importUrl = "${pageContext.request.contextPath }/shopSku/importShopParentSku";
                break;
            case 'salesmanUser':
                importTitle = "导入店铺sku销售人员";
                importTemplateUrl = "${pageContext.request.contextPath }/static/template/shopSku/salesmanUserTemplate.xlsx";
                importUrl = "${pageContext.request.contextPath }/shopSku/importSalesmanUser";
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
    function setProduceStatus(shopSkuId, shopSku, produceStatus) {
        var produceStatusName;
        if(produceStatus==1){
            produceStatusName="正常生产";
        }else if(produceStatus==2){
            produceStatusName="暂停生产";
        }
        $.messager.confirm('提示', '确认修改【' + shopSku + '】的生产状态为【'+produceStatusName+'】吗？', function (r) {
            if (r) {
                $.post('${pageContext.request.contextPath }/shopSku/setShopSkuProduceStatus', {shopSkuId: shopSkuId,produceStatus:produceStatus}, function (data) {
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
</body>
</html>
