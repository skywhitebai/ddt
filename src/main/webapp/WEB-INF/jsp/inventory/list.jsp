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

    <title>库存列表</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    店铺：
    <select id="s_shopId" style="width:150px;">
    </select>
    卖家sku：
    <input class="easyui-validatebox textbox" id="s_sellerSku">
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
    <a href="javascript:void(0)" onclick="downInventory()" class="easyui-linkbutton"
       data-options="iconCls:'icon-search'"
       style="width: 150px">下载店铺销售信息</a>
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
                <td>产品的卖家SKU：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="sellerSku">
                </td>
                <td>产品的配送网络SKU(FNSKU)：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="fnSku">
                </td>
            </tr>

            <tr>
                <td>产品的亚马逊标准识别号 (ASIN)：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="asin">
                </td>
                <td>产品的状况：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="productCondition">
                </td>
            </tr>
            <tr>
                <td title="亚马逊物流供应链中的产品总量。此处 包括当前位于亚马逊配送中心的产品数量、 当前在入库货件中的产品数量 以及在亚马逊物流的亚马逊配送中心之间 转移的产品数量。">
                    亚马逊物流供应链中的产品总量：
                </td>
                <td>
                    <input class="easyui-validatebox textbox" name="totalSupplyQuantity">
                </td>
                <td title="当前位于的产品数量。此处不包括当前在入库货件中的产品数量，也不包括在亚马逊物流的亚马逊配送中心之间转移的产品数量。">有现货的产品数量：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="inStockSupplyQuantity">
                </td>
            </tr>
            <tr>
                <td>您的库存可供应取货的类型：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="earliestAvailabilityTimepointType">
                </td>
                <td>您的库存可供应取货的最早日期：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="earliestAvailabilityDatetime">
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


<script type="text/javascript">
    bindShop();
    bindData();
    function bindShop() {
        $('#s_shopId').combobox({
            valueField: 'shopId',
            textField: 'shopName',
            url: "${pageContext.request.contextPath }/shop/userShopComboboxlist",//获取数据
        });
    }

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/inventory/list";
        title = "订单管理";
        queryParams = {
            shopId: $('#s_shopId').combobox('getValue'),
            sellerSku: $("#s_sellerSku").val()
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
                {title: '卖家SKU', field: 'sellerSku', width: 140},
                {title: '配送网络SKU(FNSKU)', field: 'fnSku', width: 120},
                {title: 'asin', field: 'asin', width: 120},
                {title: '产品的状况', field: 'productCondition', width: 120},
                {title: '产品总量', field: 'totalSupplyQuantity', width: 120},
                {title: '有现货产品数量', field: 'inStockSupplyQuantity', width: 120},
                {title: '可供应取货类型', field: 'earliestAvailabilityTimepointType', width: 120},
                {title: '可供应取货日期', field: 'earliestAvailabilityDatetime', width: 120}
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

    function downInventory() {
        shopId = $('#s_shopId').combobox('getValue');
        if (shopId == '') {
            $.messager.alert("提示", "请选择店铺.");
            return;
        }
        sellerSku = $("#s_sellerSku").val();
        url = "${pageContext.request.contextPath }/inventory/downShopInventoryInfo?shopId=" + shopId + "&sellerSku" + sellerSku;
        window.open(url);
    }

    function closeDialog() {
        $('#dlg').dialog('close');
    }
</script>
</body>
</html>
