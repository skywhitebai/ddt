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

    <title>订单列表</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    店铺：
    <select id="s_shopId" style="width:150px;">
    </select>
    亚马逊订单id：
    <input class="easyui-validatebox textbox" id="s_amazonOrderId">
    创建订单时间：
    <input class="easyui-datetimebox" id="s_purchaseDateStart">
    -
    <input class="easyui-datetimebox" id="s_purchaseDateEnd">
    订单最后更新时间
    <input class="easyui-datetimebox" id="s_lastUpdateDateStart">
    -
    <input class="easyui-datetimebox" id="s_lastUpdateDateEnd">
    订单状态：
    <select class="easyui-combobox" id="s_orderStatus" style="width:100px;">
        <option value="">全部</option>
        <option value="Shipped">Shipped</option>
    </select>
    订单生成所在商城的匿名编码
    <input class="easyui-validatebox textbox" id="s_marketplaceId">
    买家姓名
    <input class="easyui-validatebox textbox" id="s_buyerName">
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
</div>
<table id="dg" style="width: 100%; height: auto">

</table>
<!--编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 700px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
    <div class="ftitle">
        <b>订单信息</b>
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
                <td>店铺名：</td>
                <td colspan="3">
                    <input class="easyui-textbox" type="text" name="shopName">
                </td>
            </tr>
            <tr>
                <td>亚马逊订单id：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="amazonOrderId">
                </td>
                <td>创建订单的日期：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="purchaseDate">
                </td>
            </tr>

            <tr>
                <td>订单更新时间：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="lastUpdateDate">
                </td>
                <td>订单状态：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="orderStatus">
                </td>
            </tr>
            <tr>
                <td>订单的总费用：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="orderTotalAmount">
                </td>
                <td>货币代码：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="orderTotalCurrencyCode">
                </td>
            </tr>
            <tr>
                <td>已配送的产品数量：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="numberOfItemsShipped">
                </td>
                <td>未配送的产品数量：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="numberOfItemsUnshipped">
                </td>
            </tr>
            <tr>
                <td>订单的主要付款方式：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="paymentMethod">
                </td>
                <td>买家姓名：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="buyerName">
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
<div id="dlgOrderItem" class="easyui-dialog" style="width: 1000px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
    <table id="dgOrderItem" style="width: 100%; height: auto">

    </table>
</div>
<script type="text/javascript">
    bindShop();
    bindData();
    function bindShop() {
        $('#s_shopId').combobox({
            valueField: 'shopId',
            textField: 'shopName',
            url: "${pageContext.request.contextPath }/shop/comboboxlist",//获取数据
        });
    }

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/order/list";
        title = "订单管理";
        queryParams = {
            shopId: $("#s_shopId").combobox('getValue'),
            amazonOrderId: $("#s_amazonOrderId").val(),
            purchaseDateStart: $("#s_purchaseDateStart").val(),
            purchaseDateEnd: $("#s_purchaseDateEnd").val(),
            lastUpdateDateStart: $("#s_lastUpdateDateStart").val(),
            lastUpdateDateEnd: $("#s_lastUpdateDateEnd").val(),
            orderStatus: $("#s_orderStatus").val(),
            marketplaceId: $("#s_marketplaceId").val(),
            buyerName: $("#s_buyerName").val()
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
                {title: '店铺名', field: 'shopName', width: 120},
                {
                    title: '亚马逊订单id', field: 'amazonOrderId', width: 170, formatter: function (value, row, index) {
                    return "<a href='#' onclick=\"showOrderItem('" + value + "')\"' title='查看产品信息' >" + value + "</a>";
                }},
                {title: '创建订单时间', field: 'purchaseDate', width: 120},
                {title: '卖家SKU', field: 'sellerSku', width: 140},
                {title: '订单最后更新时间', field: 'lastUpdateDate', width: 140},
                {title: '订单生成所在商城的匿名编码', field: 'marketplaceId', width: 120},
                {title: '买家姓名', field: 'buyerName', width: 120},
                {title: '订单的总费用', field: 'orderTotalAmount', width: 120},
                {title: '已配送的产品数量', field: 'numberOfItemsShipped', width: 120},
                {title: '未配送的产品数量', field: 'numberOfItemsUnshipped', width: 120}
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

    function closeDialog() {
        $('#dlg').dialog('close');
    }

    function showOrderItem(amazonOrderId) {
        $('#dlgOrderItem').dialog('open').dialog('setTitle', '订单产品信息');
        //加载订单产品信息
        bindOrderItem(amazonOrderId);
    }
    function bindOrderItem(amazonOrderId) {
        dg = '#dgOrderItem';
        url = "${pageContext.request.contextPath }/orderItem/listByAmazonOrderId";
        title = "订单产品";
        queryParams = {
            amazonOrderId: amazonOrderId
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
                {title: '亚马逊订单id', field: 'amazonOrderId', width: 170},
                {title: 'asin', field: 'asin', width: 115},
                {title: '卖家SKU', field: 'sellerSku', width: 140},
                {title: '产品名称', field: 'title', width: 140},
                {title: '已配送产品数量', field: 'quantityShipped', width: 110},
                {title: '订单产品的售价', field: 'itemPriceAmount', width: 110},
                {title: '运费', field: 'shippingPriceAmount', width: 50}
            ]],
            toolbar: [{
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
               // showViewDialog();
            }
        })
    }

</script>
</body>
</html>
