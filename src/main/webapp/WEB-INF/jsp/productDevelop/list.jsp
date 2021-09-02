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
            src="${pageContext.request.contextPath }/static/js/easyuiDateTool.js"></script>
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
    <title>产品开发管理</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    产品名：
    <input class="easyui-validatebox textbox" id="s_productName">
    货号：
    <input class="easyui-validatebox textbox" id="s_productCode">
    <select id="s_developerUserId" name="developerUserId" style="width:150px;">
    </select>
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
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
                <td>id：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="id">
                </td>
            </tr>
            <tr>
                <td>产品名：</td>
                <td>
                    <input class="easyui-textbox" name="productName" data-options="required:true">
                </td>
                <td>货号：</td>
                <td>
                    <input class="easyui-textbox" name="productCode" >
                </td>
            </tr>
            <tr>
                <td>中文报关名：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="chineseProductName" >
                </td>
                <td>英文报关名：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="englishProductName" >
                </td>
            </tr>
            <tr>
                <td>产品描述：</td>
                <td colspan="3">
                    <input class="easyui-textbox" data-options="multiline:true" name="description" value=""
                           style="width:95%;height:66px">
                </td>
            </tr>
            <tr class="add_hide">
                <td>状态：</td>
                <td>
                    <select class="easyui-combobox" name="status" style="width:100px;" >
                        <option value="1">开发中</option>
                        <option value="2">开发完成</option>
                        <option value="3">确认生产</option>
                        <option value="4">开发失败</option>
                    </select>
                </td>
            </tr>
            <tr class="view_hide">
                <td>开发人员：</td>
                <td>
                    <%--暂时使用用户下拉列表--%>
                    <input class="easyui-validatebox textbox" name="developerUserName" readonly="readonly"></td>
                </td>
                <td>开发时间：</td>
                <td>
                    <input name="developmentTime" id="developmentTime"
                           class="easyui-validatebox textbox" readonly="readonly" />
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
<script type="text/javascript">
    $(document).ready(function (){
        bindDeveloperUserId();
        bindData();
    });


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
    }

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/productDevelop/listProductDevelop";
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
                    title: '图片', field: 'imgUrl', width: 120,
                    formatter: function (value, rowData, rowIndex) {
                        var res = "";
                        if (value != null && value != '') {
                            res += '<a href="javascript:;" onclick="showImg(' + value + ')" ><img  src="' + value + '?x-oss-process=image/resize,m_fill,h_66,w_66"  style="width:66px; height:66px;"/></a> '
                        } else {
                            res += '暂无图片   '
                        }
                        res += '<a href="javascript:;" onclick="showImgDialog(' + rowData.id + ')" >编辑</a>';
                        return res;
                    }
                },
                {title: '产品编码', field: 'productCode', width: 100},
                {title: '中文报关名', field: 'chineseProductName', width: 100},
                {title: '英文报关名', field: 'englishProductName', width: 100},
                {title: '开发人员', field: 'developerUserName', width: 100},
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
    function showImgDialog(id) {
        $('#dlgImg').dialog('open').dialog('setTitle', 'sku图片');
        $('#frmImg').form('clear');
        $("div#dlgImg input[name='entityId']").val(id);
        $("div#dlgImg input[name='imgType']").val("productDevelop.productDevelop_img");
        bindImgData();
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
    function showEditDialog() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $('#dlg').dialog('open').dialog('setTitle', '修改');
            $('#frm').form('load', rows[0]);
            $("#btn_save").show();
            $(".view_hide").hide();
            $(".add_hide").show();
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
            $(".add_hide").show();
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
        $(".add_hide").hide();

    }

    function save() {
        //防止重复点击
        var productName = $("div#dlg input[name='productName']").val();
        if (productName == '') {
            $.messager.alert("提示", '请填写产品名称');
            return;
        }
        $('#frm').form('submit', {
            url: '${pageContext.request.contextPath }/productDevelop/saveProductDevelop',
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

    function showImg(url) {
        window.open(url);
    }


    function getQueryParams() {
        queryParams = {
            productName: $("#s_productName").val(),
            productCode: $("#s_productCode").val(),
            developUserId: $("#s_developUserId").val()
        };
        return queryParams;
    }

    function exportProduct() {
        url = "${pageContext.request.contextPath }/productDevelop/exportProductDevelop" + getUrlParams(getQueryParams());
        window.open(url);
    }
</script>
</body>
</html>
