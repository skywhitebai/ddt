<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sku信息</title>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/main.css?t=20200928" type="text/css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/common/common.js?t=20200929"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/common/cookieUtil.js?t=20200928"></script>

</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    sku：
    <input class="easyui-validatebox textbox" id="s_sku">
    产品编码：
    <input class="easyui-validatebox textbox" id="s_productCode">
    产品名称：
    <input class="easyui-validatebox textbox" id="s_productName">
    <a href="javascript:void(0)"onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
    <a href="javascript:void(0)" id="a_importSku" onclick="showDialogImport('sku')" class="easyui-linkbutton a_hide"
       data-options="iconCls:'icon-search'"
       style="">导入sku</a>

    <a href="javascript:void(0)" id="a_exportSku" onclick="exportSku()" class="easyui-linkbutton a_hide"
       data-options="iconCls:'icon-search'"
       style="">导出sku</a>
    <a href="javascript:void(0)" id="a_importCostPrice" onclick="showDialogImport('costPrice')" class="easyui-linkbutton a_hide"
       data-options="iconCls:'icon-search'"
       style="">导入成本价</a>
    <a href="javascript:void(0)" id="a_importWeight" onclick="showDialogImport('weight')" class="easyui-linkbutton a_hide"
       data-options="iconCls:'icon-search'"
       style="">导入重量</a>
    <a href="javascript:void(0)" id="a_importTmallInfo" onclick="showDialogImport('colour')" class="easyui-linkbutton a_hide"
       data-options="iconCls:'icon-search'"
       style="">导入颜色色号</a>
    <a href="javascript:void(0)" id="a_importColour" onclick="showDialogImport('tmallInfo')" class="easyui-linkbutton a_hide"
       data-options="iconCls:'icon-search'"
       style="">导入天猫标签信息</a>
    <a href="javascript:void(0)" onclick="showPrintTmallLabelBysSelect()" class="easyui-linkbutton"
       data-options="iconCls:'icon-search'"
       style="">打印标签</a>
</div>
<table id="dg" style="width: 100%; height: auto">

</table>

<!--编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 600px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true,top:50,align:'center'">
    <div class="ftitle">
        <b>sku信息</b>
        <hr/>
    </div>
    <form id="frm" method="post" novalidate="novalidate">
        <table>
            <tr style="display: none">
                <td>skuId：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="skuId">
                </td>
            </tr>
            <tr>
                <td>产品名称：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="productProductName" readonly="readonly">
                </td>
                <td>品名：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="productName">
                </td>
            </tr>
            <tr>
                <td>产品编码：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="productCode" readonly="readonly" id="productSku">
                </td>
                <td>产品sku：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="sku" id="sku" data-options="required:true">
                </td>

            </tr>
            <tr>
                <td>颜色：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="colour" id="colour" data-options="required:true">
                </td>
                <td>色号：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="colourNumber" id="colourNumber">
                </td>
            </tr>
            <tr>
                <td>尺码：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="size" id="size" data-options="required:true">
                </td>
            </tr>
            <tr>
                <td>重量：</td>
                <td>
                    <input class="easyui-numberbox" name="weight" id="weight" min="0" precision="2"
                           data-options="required:true">
                </td>
                <td class="view_hide">库存：</td>
                <td class="view_hide">
                    <input class="easyui-numberbox" name="inventoryQuantity" readonly="readonly" id="inventoryQuantity"
                           min="0">
                </td>
            </tr>
            <tr>

                <td>成本价：</td>
                <td>
                    <input class="easyui-numberbox" min="0" precision="2" name="costPrice" id="costPrice"
                           data-options="required:true">
                </td>
                <td>头程费用：</td>
                <td>
                    <input class="easyui-numberbox" min="0" precision="2" name="headTripCost" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>副sku：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="secondSku">
                </td>
                <td>品牌：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="brand">
                </td>
            </tr>
            <tr>
                <td>面料：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="material">
                </td>
                <td>等级：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="grade">
                </td>
            </tr>
            <tr>
                <td>执行标准：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="executiveStandard">
                </td>
                <td>安全类别：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="securityCategory">
                </td>
            </tr>
            <tr>
                <td>检验员：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="inspector">
                </td>
                <td>建议零售价：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="suggestedRetailPrice">
                </td>
            </tr>
            <tr>
                <td>备注：</td>
                <td colspan="3">
                    <input class="easyui-textbox" type="text" name="remark" style="width: 90%">
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
<div id="dlgImg" class="easyui-dialog" style="width: 600px; height: 600px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true,top:50, align:'center'">
    <form id="frmImg" method="post" enctype="multipart/form-data">
        <table>
            <tr style="display: none">
                <td>skuId：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="entityId">
                </td>
                <td>imgType：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="imgType">

                </td>
            </tr>
            <tr>
                <td><input type="file" id="imgFile" name="imgFile" accept=".jpg,.jpeg,.png,.gif"></td>
                <td>
                    <a href="javascript:void(0)" class="easyui-linkbutton"
                       data-options="iconCls:'icon-ok'" onclick="btnUploadImgFile()">上传图片</a>
                </td>
            </tr>
        </table>
    </form>
    <table id="dgImg" style="width: 100%; height: auto">
    </table>
</div>
<div id="dlgSkuCostPriceHis" class="easyui-dialog" style="width: 700px; height: 400px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true,top:50, align:'center'">
    <table id="dgSkuCostPriceHis" style="width: 100%; height: auto">
    </table>
</div>
<div id="dlgSkuWeightHis" class="easyui-dialog" style="width: 800px; height: 400px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true,top:50,  align:'center'">
    <table id="dgSkuWeightHis" style="width: 100%; height: auto">
    </table>
</div>
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

<div id="cover">
    <div id="coverMsg">
        <img src="${pageContext.request.contextPath }/static/img/loading.gif" width="100px">
    </div>
</div>
<script type="text/javascript">
    bindData();
    initOperationRight();

    function initOperationRight() {

        if (hasRight("sku/importSku")) {
            $("#a_importSku").show()
        }
        if (hasRight("sku/exportSku")) {
            $("#a_exportSku").show()
        }
        if (hasRight("sku/importCostPrice")) {
            $("#a_importCostPrice").show()
        }
        if (hasRight("sku/importWeight")) {
            $("#a_importWeight").show()
        }
        if (hasRight("sku/importTmallInfo")) {
            $("#a_importTmallInfo").show()
        }
        if (hasRight("sku/importColour")) {
            $("#a_importColour").show()
        }
        if (!hasRight("sku/saveSku")) {
            $("#btnAdd").hide();
            $("#btnEdit").hide();
        }
        if (!hasRight("sku/deleteSku")) {
            $("#btnDelete").hide()
        }
    }
    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/sku/list";
        title = "sku管理";
        queryParams = {
            sku: $("#s_sku").val(),
            productCode: $("#s_productCode").val(),
            productName: $("#s_productName").val()
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
                {title: '产品名称', field: 'productProductName', width: 150},
                {title: '产品编码', field: 'productCode', width: 120},
                {title: '产品sku', field: 'sku', width: 120},
                {
                    title: '图片', field: 'imgUrl', width: 120,
                    formatter: function (value, rowData, rowIndex) {
                        var res = "";
                        if (value != null && value != '') {
                            res += '<a href="javascript:;" onclick="showImg(' + value + ')" ><img  src="' + value + '?x-oss-process=image/resize,m_fill,h_66,w_66"  style="width:66px; height:66px;"/></a> '
                        } else {
                            res += '暂无图片   '
                        }
                        res += '<a href="javascript:;" onclick="showImgDialog(' + rowData.skuId + ')" >编辑</a>';
                        return res;
                    }
                },
                {title: '颜色', field: 'colour', width: 100},
                {title: '色号', field: 'colourNumber', width: 100},
                {title: '尺码', field: 'size', width: 100},
                {
                    title: '重量', field: 'weight', width: 100,
                    formatter: function (value, rowData, rowIndex) {
                        var res = "";
                        if (value != null && value != '') {
                            res += '<a href="javascript:;" onclick="showSkuWeightHisDialog(' + rowData.skuId + ')" title="查看历史重量">' + value + '</a>';
                        } else {
                            res += '<a href="javascript:;" onclick="showSkuWeightHisDialog(' + rowData.skuId + ')" title="查看历史重量">暂无重量</a>';
                        }
                        return res;
                    }
                },
                {
                    title: '成本价', field: 'costPrice', width: 100,
                    formatter: function (value, rowData, rowIndex) {
                        var res = "";
                        if (value != null && value != '') {
                            res += '<a href="javascript:;" onclick="showSkuCostPriceHisDialog(' + rowData.skuId + ')" title="查看历史成本价">' + value + '</a>';
                        } else {
                            res += '<a href="javascript:;" onclick="showSkuCostPriceHisDialog(' + rowData.skuId + ')" title="查看历史成本价">暂无成本价</a>';
                        }
                        return res;
                    }
                },
                {title: '头程费用', field: 'headTripCost', width: 100},
                {title: '最低头程费用', field: 'headTripCostMin', width: 100},
                {title: '库存数量', field: 'inventoryQuantity', width: 100},
                {title: '品名', field: 'productName', width: 100},
                {title: '副sku', field: 'secondSku', width: 100},
                {title: '品牌', field: 'brand', width: 100},
                {title: '面料', field: 'material', width: 100},
                {title: '等级', field: 'grade', width: 100},
                {title: '执行标准', field: 'executiveStandard', width: 100},
                {title: '安全类别', field: 'securityCategory', width: 100},
                {title: '检验员', field: 'inspector', width: 100},
                {title: '建议零售价', field: 'suggestedRetailPrice', width: 100},
                {title: '创建时间', field: 'createTime', width: 180},
                {title: '修改时间', field: 'updateTime', width: 180},
                {title: '备注', field: 'remark', width: 180},
                {
                    title: '操作', field: 'shopSkuId', width: 80,
                    formatter: function (value, row, index) {
                        return '<a href="javascript:;" onclick="showPrintTmallLabel(\'' + row.sku + '\')" title="打印天猫标签">打印天猫标签</a>';
                    }
                }
            ]],
            toolbar: [
                {
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
                }, '-',
                {
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

    function showAddDialog() {
        $('#dlg').dialog('open').dialog('setTitle', '添加');
        $('#frm').form('clear');
        $("#btn_save").show();
        $(".view_hide").hide();
    }

    function save() {
        //防止重复点击
        var sku = $("div#dlg input[name='sku']").val();
        if (sku == '') {
            $.messager.alert("提示", '请填写sku');
            return;
        }
        var colour = $("div#dlg input[name='colour']").val();
        if (colour == '') {
            $.messager.alert("提示", '请填写颜色');
            return;
        }
        var size = $("div#dlg input[name='size']").val();
        if (size == '') {
            $.messager.alert("提示", '请填写尺码');
            return;
        }
        var weight = $("div#dlg input[name='weight']").val();
        if (weight == '') {
            $.messager.alert("提示", '请填写重量');
            return;
        }
        var costPrice = $("div#dlg input[name='costPrice']").val();
        if (costPrice == '') {
            $.messager.alert("提示", '请填写成本价');
            return;
        }
        $('#frm').form('submit', {
            url: '${pageContext.request.contextPath }/sku/save',
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
                var skuIds = new Array();
                for (var i = 0; i < rows.length; i++) {
                    skuIds.push(rows[i].skuId);
                }
                $.post('${pageContext.request.contextPath }/sku/delete', {skuIds: skuIds}, function (data) {
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


    function exportSku() {
        sku = $("#s_sku").val();
        productCode = $("#s_productCode").val();
        productName = $("#s_productName").val();
        url = "${pageContext.request.contextPath }/sku/exportSku?sku=" + sku + "&productCode=" + productCode + "&productName=" + productName;
        window.open(url);
    }


    function showImgDialog(skuId) {
        $('#dlgImg').dialog('open').dialog('setTitle', 'sku图片');
        $('#frmImg').form('clear');
        $("div#dlgImg input[name='entityId']").val(skuId);
        $("div#dlgImg input[name='imgType']").val("sku.sku_img");
        bindImgData();
    }

    function btnUploadImgFile() {
        var entityId = $("div#dlgImg input[name='entityId']").val();
        if (entityId == '') {
            $.messager.alert("提示", "skuId不能为空");
            return;
        }
        var imgType = $("div#dlgImg input[name='imgType']").val();
        if (imgType == '') {
            $.messager.alert("提示", "图片类型不能为空");
            return;
        }
        var imgFile = $("div#dlgImg input[name='imgFile']").val();
        if (imgFile == '') {
            $.messager.alert("提示", "图片不能为空");
            return;
        }
        var dom = document.getElementById("imgFile");
        var fileSize = dom.files[0].size;
        if (fileSize > 30000000) {
            $.messager.alert("提示", "上传文件过大,请上传小于3M的图片");
            return false;
        }
        $('#frmImg').form('submit', {
            url: '${pageContext.request.contextPath }/img/addImg',
            onSubmit: function () {
                return $(this).form('validate');
            },
            success: function (data) {
                res = eval("(" + data + ")");
                if (res.code == '200') {
                    $.messager.alert("提示", "上传成功");
                    bindImgData();
                }
                else {
                    $.messager.alert("提示", res.message);
                }
            }
        });
    }

    function bindImgData() {
        dg = '#dgImg';
        url = "${pageContext.request.contextPath }/img/list";
        title = "图片管理";
        queryParams = {
            entityId: $("div#dlgImg input[name='entityId']").val(),
            imgType: $("div#dlgImg input[name='imgType']").val()
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
            idField: 'imgId',
            queryParams: queryParams,  //异步查询的参数
            columns: [[
                {field: 'ck', checkbox: true},   //选择
                {title: '图片名', field: 'imgName', width: 180},
                {
                    title: '图片', field: 'imgUrl', width: 100,
                    formatter: function (value, rowData, rowIndex) {
                        return '<a href="javascript:;" onclick="showImg(' + value + ')" ><img  src="' + value + '?x-oss-process=image/resize,m_fill,h_66,w_66"  style="width:66px; height:66px;"/></a> ';
                    }
                },
                {title: '创建时间', field: 'createTime', width: 180}
            ]],
            toolbar: [{
                id: 'btnImgDelete',
                text: '删除',
                iconCls: 'icon-remove',
                handler: function () {
                    deleteImgInfo();//实现直接删除数据的方法
                }
            }, '-', {
                id: 'btnImgReload',
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

    function deleteImgInfo() {
        //防止重复点击
        var rows = $('#dgImg').datagrid('getSelections');
        if (!rows || rows.length == 0) {
            $.messager.alert("提示", "请选择要删除的数据.");
            return;
        }
        $.messager.confirm('提示', '确认删除这' + rows.length + '条数据吗？', function (r) {
            if (r) {
                var imgIds = new Array();
                for (var i = 0; i < rows.length; i++) {
                    imgIds.push(rows[i].imgId);
                }
                $.post('${pageContext.request.contextPath }/img/deleteImg', {imgIds: imgIds}, function (data) {
                    if (data.code == '200') {
                        $('#dlg').dialog('close');
                        bindImgData();
                    }
                    else {
                        $.messager.alert("提示", data.message);
                    }
                });
            }
        });
    }

    function showImg(imgUrl) {
        window.open(imgUrl);
    }

    var skuCostPriceHis;

    function showSkuCostPriceHisDialog(skuId) {
        $('#dlgSkuCostPriceHis').dialog('open').dialog('setTitle', 'sku成本价历史');
        skuCostPriceHis = skuId;
        bindSkuCostPriceHisData();
    }

    function bindSkuCostPriceHisData() {
        dg = '#dgSkuCostPriceHis';
        url = "${pageContext.request.contextPath }/skuCostPriceHis/list";
        title = "成本价历史管理";
        queryParams = {
            skuId: skuCostPriceHis
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
                {title: 'sku', field: 'sku', width: 120},
                {title: '修改前价格', field: 'costPriceBefore', width: 90},
                {title: '修改后价格', field: 'costPriceAfter', width: 90},
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

    var skuWeightHis;

    function showSkuWeightHisDialog(skuId) {
        $('#dlgSkuWeightHis').dialog('open').dialog('setTitle', 'sku重量、头程费历史');
        skuWeightHis = skuId;
        bindSkuWeightHisData();
    }

    function bindSkuWeightHisData() {
        dg = '#dgSkuWeightHis';
        url = "${pageContext.request.contextPath }/skuWeightHis/list";
        title = "重量历史管理";
        queryParams = {
            skuId: skuWeightHis
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
                {title: 'sku', field: 'sku', width: 120},
                {title: '修改前重量', field: 'weightBefore', width: 90},
                {title: '修改后重量', field: 'weightAfter', width: 90},
                {title: '修改前头程费', field: 'headTripCostBefore', width: 90},
                {title: '修改后头程费', field: 'headTripCostAfter', width: 90},
                {title: '修改前最低头程费', field: 'headTripCostMinBefore', width: 90},
                {title: '修改后最低头程费', field: 'headTripCostMinAfter', width: 90},
                {title: '修改人姓名', field: 'createUserName', width: 80},
                {title: '修改类型', field: 'typeName', width: 100},
                {title: '修改时间', field: 'createTime', width: 160}
            ]],
            toolbar: [{
                id: 'btnSkuWeightHisReload',
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

    var importUrl;

    function showDialogImport(importType) {
        var importTitle;
        switch (importType) {
            case 'sku':
                importTitle = "导入sku";
                importTemplateUrl = "${pageContext.request.contextPath }/static/template/sku/skuTemplate.xlsx";
                importUrl = '${pageContext.request.contextPath }/sku/importSku';
                break;
            case 'inventory':
                importTitle = "导入库存";
                importTemplateUrl = "${pageContext.request.contextPath }/static/template/sku/inventoryTemplate.xlsx";
                importUrl = "${pageContext.request.contextPath }/sku/importInventory";
                break;
            case 'costPrice':
                importTitle = "导入成本价";
                importTemplateUrl = "${pageContext.request.contextPath }/static/template/sku/costPriceTemplate.xlsx";
                importUrl = "${pageContext.request.contextPath }/sku/importCostPrice";
                break;
            case 'weight':
                importTitle = "导入重量";
                importTemplateUrl = "${pageContext.request.contextPath }/static/template/sku/weightTemplate.xlsx";
                importUrl = "${pageContext.request.contextPath }/sku/importWeight";
                break;
            case 'tmallInfo':
                importTitle = "导入天猫标签信息";
                importTemplateUrl = "${pageContext.request.contextPath }/static/template/sku/tmallInfoTemplate.xlsx";
                importUrl = "${pageContext.request.contextPath }/sku/importTmallInfo";
                break;
            case 'colour':
                importTitle = "导入颜色色号";
                importTemplateUrl = "${pageContext.request.contextPath }/static/template/sku/colourTemplate.xlsx";
                importUrl = "${pageContext.request.contextPath }/sku/importColour";
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

    function showPrintTmallLabelBysSelect() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            showPrintTmallLabel(rows[0].sku);
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function showPrintTmallLabel(sku) {
        if (isEmpty(sku)) {
            window.open("${pageContext.request.contextPath }/sku/printTmallLable");
        } else {
            window.open("${pageContext.request.contextPath }/sku/printTmallLable?sku=" + sku);
        }
    }
</script>
</body>
</html>
