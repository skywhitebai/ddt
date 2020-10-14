<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/28
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商户sku信息</title>
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
    <style>
        #cover{
            position: fixed;
            top: 0;
            left: 0;
            height: 100%;
            width: 100%;
            background-color: rgba(0,0,0,0.3);
            display:none;
            z-index:1000;
        }
    </style>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    卖家sku：
    <input class="easyui-validatebox textbox" id="s_skuSeller">
    仓库sku：
    <input class="easyui-validatebox textbox" id="s_skuWarehouse">
    供应商sku：
    <input class="easyui-validatebox textbox" id="s_skuSupplier">
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
    <a href="javascript:void(0)" onclick="importSkuInfoFile()" class="easyui-linkbutton"
       data-options="iconCls:'icon-search'"
       style="">导入sku信息</a>

    <a href="javascript:void(0)" onclick="transformSkuInfoFile()" class="easyui-linkbutton"
       data-options="iconCls:'icon-search'"
       style="">sku信息转换</a>
</div>
<table id="dg" style="width: 100%; height: auto">

</table>

<!--编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 600px; height: 300px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
    <div class="ftitle">
        <b>sku信息</b>
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
                <td>卖家sku：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="skuSeller" data-options="required:true">
                </td>
                <td>仓库sku：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="skuWarehouse" data-options="required:true">
                </td>
            </tr>
            <tr>
                <td>供应商sku：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="skuSupplier">
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


<!--sku导入页面-->
<div id="dlg_importSkuInfo" class="easyui-dialog" style="width: 600px; height: 300px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
    <div class="ftitle">
        <b>sku信息导入</b>
        <hr/>
        模板下载：
        <a href="${pageContext.request.contextPath }/static/template/skuInfoTemplate.xlsx" target="_blank">模板下载</a>
    </div>
    <form id="frm_importSkuInfo" method="post" novalidate="novalidate" enctype="multipart/form-data">
        <input type="file" id="importSkuInfoFile" name="file" accept=".xls,.xlsx"/>
        <div style="text-align:center;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" onclick="importSkuInfo()">导入</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-cancel'" onclick="closeDialogImportSkuInfo()">关闭</a>
        </div>
    </form>
</div>


<!--sku导入页面-->
<div id="dlg_transformSkuInfo" class="easyui-dialog" style="width: 600px; height: 300px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
    <div class="ftitle">
        <b>sku信息转换</b>
        <hr/>
        模板下载：
        <a href="${pageContext.request.contextPath }/static/template/productInfoTemplate1.xlsx" target="_blank">模板1</a>

        <a href="${pageContext.request.contextPath }/static/template/productInfoTemplate2.xlsx" target="_blank">模板2</a><br>
    </div>
    <form id="frm_transformSkuInfo" method="post" novalidate="novalidate" enctype="multipart/form-data">
        <input type="file" id="transformSkuInfoFile" name="file" accept=".xls,.xlsx"/>
        <div style="text-align:center;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" onclick="transformSkuInfo()">转换</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-cancel'" onclick="closeDialogTransformSkuInfo()">关闭</a>
        </div>
    </form>
</div>
<div id="cover"></div>
<script type="text/javascript">
    bindData();

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/skuInfo/list";
        title = "sku管理";
        queryParams = {
            skuSeller: $("#s_skuSeller").val(),
            skuWarehouse: $("#s_skuWarehouse").val(),
            skuSupplier: $("#s_skuSupplier").val()
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
                {title: '卖家sku', field: 'skuSeller', width: 150},
                {title: '仓库sku', field: 'skuWarehouse', width: 150},
                {title: '供应商sku', field: 'skuSupplier', width: 150},
                {title: '创建时间', field: 'createTime', width: 180},
                {title: '修改时间', field: 'updateTime', width: 180}
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
        var skuSeller = $("div#dlg input[name='skuSeller']").val();
        if (skuSeller == '') {
            $.messager.alert("提示", '请填写卖家sku');
            return;
        }
        var skuWarehouse = $("div#dlg input[name='skuWarehouse']").val();
        if (skuWarehouse == '') {
            $.messager.alert("提示", '请填写仓库sku');
            return;
        }

        $('#frm').form('submit', {
            url: '${pageContext.request.contextPath }/skuInfo/save',
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
                var ids = new Array();
                for (var i = 0; i < rows.length; i++) {
                    ids.push(rows[i].id);
                }
                $.post('${pageContext.request.contextPath }/skuInfo/delete', {ids: ids}, function (data) {
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

    //导入sku信息
    function importSkuInfoFile() {
        $('#dlg_importSkuInfo').dialog('open').dialog('setTitle', '导入sku信息');
    }
    function  closeDialogImportSkuInfo() {
        $('#dlg_importSkuInfo').dialog('close');
    }
    function importSkuInfo() {
        var importSkuInfoFile = $("#importSkuInfoFile").val();
        if (importSkuInfoFile == '') {
            $.messager.alert("提示", "请选择导入的文件");
            return;
        }
        var dom = document.getElementById("importSkuInfoFile");
        var fileSize = dom.files[0].size;
        if (fileSize > 30000000) {
            $.messager.alert("提示","上传文件过大,请上传小于30M的文件");
            return false;
        }
        //弹出遮罩
        showCover();
        $('#frm_importSkuInfo').form('submit', {
            url: '${pageContext.request.contextPath }/skuInfo/importSkuInfo',
            onSubmit: function () {
                return $(this).form('validate');
            },
            success: function (data) {
                res=eval("("+data+")")
                if (res.code == '200') {
                    $.messager.alert("提示", "上传成功");
                    bindImgData();
                }
                else {
                    $.messager.alert("提示", res.message);
                }
                //关闭遮罩
            }
        });
    }
    //sku信息转换
    function transformSkuInfoFile() {
        $('#dlg_transformSkuInfo').dialog('open').dialog('setTitle', 'sku信息转换');
    }
    function transformSkuInfo() {
        var transformSkuInfoFile = $("#transformSkuInfoFile").val();
        if (transformSkuInfoFile == '') {
            $.messager.alert("提示", "请选择要转换的的文件");
            return;
        }
        var dom = document.getElementById("transformSkuInfoFile");
        var fileSize = dom.files[0].size;
        if (fileSize > 30000000) {
            $.messager.alert("提示","上传文件过大,请上传小于30M的文件");
            return false;
        }
        //弹出遮罩
        showCover();
        $('#frm_transformSkuInfo').form('submit', {
            url: '${pageContext.request.contextPath }/skuInfo/transformSkuInfoAll',
            onSubmit: function () {
                return $(this).form('validate');
            },
            success: function (data) {
                res=eval("("+data+")")
                if (res.code == '200') {
                    $.messager.alert("提示", "上传成功");
                    bindImgData();
                }
                else {
                    $.messager.alert("提示", res.message);
                }
                //关闭遮罩
            }
        });
    }
function closeDialogTransformSkuInfo() {
    $('#dlg_transformSkuInfo').dialog('close');
}
    function showCover() {
        var cover=document.getElementById('cover');
        cover.style.display='block';
        setTimeout(function(){
            cover.style.display='none';
        },2000)
    }
</script>
</body>
</html>
