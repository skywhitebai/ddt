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
            src="${pageContext.request.contextPath }/static/js/common/common.js?t=20200929"></script>

    <title>店铺列表</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    店铺名：
    <input class="easyui-validatebox textbox" id="s_shopName">
    卖家Id：
    <input class="easyui-validatebox textbox" id="s_sellerId">
    商城编号：
    <input class="easyui-validatebox textbox" id="s_shopMarketplaceId">
    店铺类型：
    <select class="easyui-combobox" id="s_type" style="width:100px;">
        <option value="">全部</option>
        <option value="1">店铺</option>
        <option value="2">仓库</option>
    </select>
    状态：
    <select class="easyui-combobox" id="s_status" style="width:100px;">
        <option value="">全部</option>
        <option value="1">启用</option>
        <option value="0">停用</option>
    </select>
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
</div>
<table id="dg" style="width: 100%; height: auto">

</table>
<!--编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 700px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
    <div class="ftitle">
        <b>店铺信息</b>
        <hr/>
    </div>
    <form id="frm" method="post" novalidate="novalidate">
        <table>
            <tr style="display: none">
                <td>shopId：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="shopId">
                </td>
            </tr>
            <tr>
                <td>店铺名：</td>
                <td colspan="3">
                    <input class="easyui-textbox" type="text" name="shopName" style="width: 90%"
                           data-options="required:true">
                </td>
            </tr>
            <tr>
                <td>店铺连接：</td>
                <td colspan="3">
                    <input class="easyui-textbox" type="text" name="shopUrl" style="width: 90%">
                </td>
            </tr>

            <tr>
                <td>卖家id：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="sellerId" >
                </td>
                <td>商城编号：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="shopMarketplaceId" >
                </td>
            </tr>
            <tr>
                <td>店铺类型：</td>
                <td>
                    <select class="easyui-combobox" name="type" style="width:100px;" data-options="required:true">
                        <option value="1">店铺</option>
                        <option value="2">仓库</option>
                    </select>
                </td>
                <td>状态：</td>
                <td>
                    <select class="easyui-combobox" name="status" style="width:100px;" data-options="required:true">
                        <option value="1">启用</option>
                        <option value="0">停用</option>
                    </select>
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

<!--店铺用户页面-->
<div id="dlgShopUser" class="easyui-dialog" style="width: 600px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, align:'center'">
    <div class="ftitle">
        <b>店铺用户管理</b>
        <hr/>
    </div>
    <input type="hidden" id="shopUser_shopId">
    <!--店铺用户-->
    <table id="dgShopUser" style="width: 100%; height: auto">

    </table>
    <!--添加用户-->
    <div id="dlgAddShopUser" class="easyui-dialog" style="width: 300px; height: 200px; padding: 10px 20px"
         data-options="closed:true, resizable:true, modal:true, align:'center'">
        <select id="s_userId" style="width:150px;">
        </select>
        <div style="text-align:center;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" id="btn_save_userRole" onclick="saveShopUser()">确定</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-cancel'" onclick="closeAddShopUserDialog()">关闭</a>
        </div>
    </div>
    <div style="text-align:center;">
        <a href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-cancel'" onclick="closeShopUserDialog()">关闭</a>
    </div>
</div>
<!--店铺发货地址页面-->
<div id="dlgShopSenderAddress" class="easyui-dialog" style="width: 600px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, align:'center'">
    <div class="ftitle">
        <b>店铺发货地址管理</b>
        <hr/>
    </div>
    <form id="frm_ShopSenderAddress" method="post" novalidate="novalidate">
        <table>
            <tr style="display: none">
                <td>id：</td>
                <td>
                    <input type="hidden" id="shopSenderAddress_shopId" name="shopId">
                </td>
            </tr>
            <tr>
                <td>ShipToCountry：</td>
                <td width="380px">
                    <input class="easyui-textbox" type="text" name="shipToCountry"
                           data-options="required:true">
                </td>

            </tr>
            <tr>
                <td>AddressName：</td>
                <td width="380px">
                    <input class="easyui-textbox" type="text" name="addressName" data-options="required:true"></td>
            </tr>
            <tr>
                <td>AddressFieldOne:</td>
                <td width="380px">
                    <input class="easyui-textbox" type="text" name="addressFieldOne" data-options="required:true"
                    >
                </td>
            </tr>
            <tr>
                <td>AddressFieldTwo:</td>
                <td width="380px">
                    <input class="easyui-textbox" type="text" name="addressFieldTwo">
                </td>
            </tr>
            <tr>
                <td>AddressCity:</td>
                <td width="380px">
                    <input class="easyui-textbox" type="text" name="addressCity" data-options="required:true">
                </td>
            </tr>
            <tr>
                <td>AddressCountryCode:</td>
                <td width="380px">
                    <input class="easyui-textbox" type="text" name="addressCountryCode" data-options="required:true"
                           data-options="required:true">
                </td>
            </tr>
            <tr>
                <td>AddressStateOrRegion:</td>
                <td width="380px">
                    <input class="easyui-textbox" type="text" name="addressStateOrRegion" data-options="required:true">
                </td>
            </tr>
            <tr>
                <td>AddressPostalCode:</td>
                <td width="380px">
                    <input class="easyui-textbox" type="text" name="addressPostalCode" data-options="required:true">
                </td>
            </tr>
            <tr>
                <td>AddressDistrict:</td>
                <td width="380px">
                    <input class="easyui-textbox" type="text" name="addressDistrict">
                </td>
            </tr>
        </table>
        <div style="text-align:center;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" onclick="saveShopSenderAddress()">确定</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-cancel'" onclick="closeShopSenderAddressDialog()">关闭</a>
        </div>
    </form>
</div>
<script type="text/javascript">
    bindData();
    bindUser();

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/shop/list";
        title = "店铺管理";
        queryParams = {
            shopName: $("#s_shopName").val(),
            sellerId: $("#s_sellerId").val(),
            shopMarketplaceId: $("#s_shopMarketplaceId").val(),
            status: $("#s_status").val(),
            type: $("#s_type").val()
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
            nowrap:false,
            remoteSort: false,
            idField: 'shopId',
            queryParams: queryParams,  //异步查询的参数
            columns: [[
                {field: 'ck', checkbox: true},   //选择
                {title: '店铺名', field: 'shopName', width: 120},
                {title: '店铺员工', field: 'shopUserRealNames', width: 150},
                {title: '店铺类型', field: 'type', width: 140,
                    formatter: function (value, rowData, rowIndex) {
                        if (value == null) {
                            return '';
                        }
                        if(value==1){
                            return '店铺';
                        }
                        if(value==2){
                            return '仓库';
                        }
                    }
                },
                {title: '卖家id', field: 'sellerId', width: 140},
                {
                    title: '店铺链接', field: 'shopUrl', width: 100,
                    formatter: function (value, rowData, rowIndex) {
                        if (value == null || value == '') {
                            return '暂无链接';
                        }
                        return "<a href='" + value + "' target='_blank'>店铺链接</a>";
                    }
                },
                {title: '商城编号', field: 'shopMarketplaceId', width: 140},
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
                    title: '店铺地址', field: 'shopSenderAddress', width: 300,
                    formatter: function (value, rowData, rowIndex) {
                        if (value == null) {
                            return '';
                        }
                        return getSenderAddress(value);
                    }
                },
                {title: '创建时间', field: 'createTime', width: 160},
                {title: '修改时间', field: 'updateTime', width: 160},
                {title: '备注', field: 'remark', width: 300}
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
                id: 'btnEditShopUser',
                text: '店铺用户',
                iconCls: 'icon-edit',
                handler: function () {
                    showShopUserDialog();//实现修改记录的方法
                }
            }, '-', {
                id: 'btnEditShopSenderAddress',
                text: '店铺发货地址',
                iconCls: 'icon-edit',
                handler: function () {
                    showShopSenderAddressDialog();//实现修改记录的方法
                }
            }, '-', {
                id: 'btnDelete',
                text: '停用',
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


    function getSenderAddress(senderAddress) {
        if (isEmpty(senderAddress)) {
            return '';
        }
        var str="";
        if(!isEmpty(senderAddress.shipToCountry)){
            str=str+senderAddress.shipToCountry+', ';
        }
        if(!isEmpty(senderAddress.addressName)){
            str=str+senderAddress.addressName+', ';
        }
        if(!isEmpty(senderAddress.addressFieldOne)){
            str=str+senderAddress.addressFieldOne+', ';
        }
        if(!isEmpty(senderAddress.addressFieldTwo)){
            str=str+senderAddress.addressFieldTwo+', ';
        }
        if(!isEmpty(senderAddress.addressCity)){
            str=str+senderAddress.addressCity+', ';
        }
        if(!isEmpty(senderAddress.addressCountryCode)){
            str=str+senderAddress.addressCountryCode+', ';
        }
        if(!isEmpty(senderAddress.addressStateOrRegion)){
            str=str+senderAddress.addressStateOrRegion+', ';
        }
        if(!isEmpty(senderAddress.addressPostalCode)){
            str=str+senderAddress.addressPostalCode+', ';
        }
        if(!isEmpty(senderAddress.addressDistrict)){
            str=str+senderAddress.addressDistrict+', ';
        }
        return str;
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
        var shopName = $("div#dlg input[name='shopName']").val();
        if (shopName == '') {
            $.messager.alert("提示", '请填写店铺名');
            return;
        }
        var type = $("div#dlg input[name='type']").val();
        if (type == '') {
            $.messager.alert("提示", '请选择类型');
            return;
        }

        var status = $("div#dlg input[name='status']").val();
        if (status == '') {
            $.messager.alert("提示", '请选择状态');
            return;
        }

        $('#frm').form('submit', {
            url: '${pageContext.request.contextPath }/shop/save',
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
            $.messager.alert("提示", "请选择要停用的数据.");
            return;
        }
        $.messager.confirm('提示', '确认停用这' + rows.length + '条数据吗？', function (r) {
            if (r) {
                var shopIds = new Array();
                for (var i = 0; i < rows.length; i++) {
                    shopIds.push(rows[i].shopId);
                }
                $.post('${pageContext.request.contextPath }/shop/delete', {shopIds: shopIds}, function (data) {
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

    function bindUser() {
        $('#s_userId').combobox({
            valueField: 'userId',
            textField: 'realName',
            url: "${pageContext.request.contextPath }/user/comboboxlist"//获取数据
        });
    }

    //展示店铺用户
    function showShopUserDialog() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $('#shopUser_shopId').val(rows[0].shopId);
            closeAddShopUserDialog();
            $('#dlgShopUser').dialog('open').dialog('setTitle', '用户角色');
            bindShopUserData();
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function closeShopUserDialog() {
        $('#dlgShopUser').dialog('close');
    }

    function showAddShopUserDialog() {
        $('#dlgAddShopUser').dialog('open').dialog('setTitle', '添加店铺用户');
    }

    //绑定店铺用户数据
    function bindShopUserData() {
        dg = '#dgShopUser';
        url = "${pageContext.request.contextPath }/shopUser/getShopUserList";
        title = "店铺用户";
        queryParams = {
            shopId: $("#shopUser_shopId").val()
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
            remoteSort: false,
            queryParams: queryParams,  //异步查询的参数
            columns: [[
                {field: 'ck', checkbox: true},   //选择
                {title: '用户名', field: 'userName', width: 100}
            ]],
            toolbar: [{
                id: 'btnAddShopUser',
                text: '添加',
                iconCls: 'icon-add',
                handler: function () {
                    showAddShopUserDialog();//实现添加记录的页面
                }
            }, '-', {
                id: 'btnDeleteShopUser',
                text: '删除',
                iconCls: 'icon-remove',
                handler: function () {
                    deleteShopUser();//实现直接删除数据的方法
                }
            }, '-', {
                id: 'btnReloadShopUser',
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

    function saveShopUser() {
        shopId = $("#shopUser_shopId").val();
        userId = $("#s_userId").combobox('getValue');
        if (shopId == '') {
            $.messager.alert("提示", '请选择店铺');
            return;
        }
        if (userId == '') {
            $.messager.alert("提示", '请选择用户');
            return;
        }
        $.post('${pageContext.request.contextPath }/shopUser/saveShopUser', {
            userId: userId,
            shopId: shopId
        }, function (data) {
            if (data.code == '200') {
                closeAddShopUserDialog();
                bindShopUserData();
            }
            else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function deleteShopUser() {
        var rows = $('#dgShopUser').datagrid('getSelections');
        if (!rows || rows.length == 0) {
            $.messager.alert("提示", "请选择要删除的数据.");
            return;
        }
        $.messager.confirm('提示', '确认删除这' + rows.length + '条数据吗？', function (r) {
            if (r) {
                var shopUserIds = new Array();
                for (var i = 0; i < rows.length; i++) {
                    shopUserIds.push(rows[i].shopUserId);
                }
                $.post('${pageContext.request.contextPath }/shopUser/deleteShopUser', {shopUserIds: shopUserIds}, function (data) {
                    if (data.code == '200') {
                        $('#dlg').dialog('close');
                        bindShopUserData();
                    }
                    else {
                        $.messager.alert("提示", data.message);
                    }
                });
            }
        });
    }

    function closeAddShopUserDialog() {
        $('#dlgAddShopUser').dialog('close');
    }

    function showShopSenderAddressDialog() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $('#shopSenderAddress_shopId').val(rows[0].shopId);
            $('#dlgShopSenderAddress').dialog('open').dialog('setTitle', '店铺发货地址');
            bindShopSenderAddress(rows[0].shopId);
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function bindShopSenderAddress(shopId) {
        $('#frm_ShopSenderAddress').form('clear');
        $('#shopSenderAddress_shopId').val(shopId);
        $.post('${pageContext.request.contextPath }/shopSenderAddress/getShopSenderAddress', {shopId: shopId}, function (data) {
            if (data.code == '200') {
                if (data.data != null) {
                    $('#frm_ShopSenderAddress').form('load', data.data);
                }
            }
            else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function closeShopSenderAddressDialog() {
        $('#dlgShopSenderAddress').dialog('close');
    }

    function saveShopSenderAddress() {
        //防止重复点击
        var shopId = $("div#dlgShopSenderAddress input[name='shopId']").val();
        if (shopId == '') {
            $.messager.alert("提示", '请选择店铺');
            return;
        }
        var shipToCountry = $("div#dlgShopSenderAddress input[name='shipToCountry']").val();
        if (shipToCountry == '') {
            $.messager.alert("提示", '请填写ShipToCountry');
            return;
        }
        var addressName = $("div#dlgShopSenderAddress input[name='addressName']").val();
        if (addressName == '') {
            $.messager.alert("提示", '请填写AddressName');
            return;
        }
        var addressFieldOne = $("div#dlgShopSenderAddress input[name='addressFieldOne']").val();
        if (addressFieldOne == '') {
            $.messager.alert("提示", '请填写AddressFieldOne');
            return;
        }
        var addressCity = $("div#dlgShopSenderAddress input[name='addressCity']").val();
        if (addressCity == '') {
            $.messager.alert("提示", '请填写AddressCity');
            return;
        }
        var addressCountryCode = $("div#dlgShopSenderAddress input[name='addressCountryCode']").val();
        if (addressCountryCode == '') {
            $.messager.alert("提示", '请填写AddressCountryCode');
            return;
        }
        var addressStateOrRegion = $("div#dlgShopSenderAddress input[name='addressStateOrRegion']").val();
        if (addressStateOrRegion == '') {
            $.messager.alert("提示", '请填写AddressStateOrRegione');
            return;
        }
        var addressPostalCode = $("div#dlgShopSenderAddress input[name='addressPostalCode']").val();
        if (addressPostalCode == '') {
            $.messager.alert("提示", '请填写AddressPostalCode');
            return;
        }

        $('#frm_ShopSenderAddress').form('submit', {
            url: '${pageContext.request.contextPath }/shopSenderAddress/saveShopSenderAddress',
            onSubmit: function () {
                var validate = $(this).form('validate');
                return validate;
            },
            success: function (data) {
                res = eval('(' + data + ')');
                if (res.code == '200') {
                    bindData();
                    closeShopSenderAddressDialog();
                }
                else {
                    $.messager.alert("提示", res.message);
                }
            }
        });
    }
</script>
</body>
</html>
