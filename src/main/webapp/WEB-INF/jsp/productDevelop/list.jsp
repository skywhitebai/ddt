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
