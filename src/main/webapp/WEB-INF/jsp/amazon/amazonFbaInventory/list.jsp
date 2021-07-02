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

    <title>亚马逊库存列表</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    店铺merchantId：
    <input class="easyui-validatebox textbox" id="s_merchantId">
    asin：
    <input class="easyui-validatebox textbox" id="s_asin">
    fnSku：
    <input class="easyui-validatebox textbox" id="s_fnSku">
    卖家sku：
    <input class="easyui-validatebox textbox" id="s_sellerSku">
    产品名称：
    <input class="easyui-validatebox textbox" id="s_productName">
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
    <a href="javascript:void(0)" onclick="downAmazonFbaInventory()" class="easyui-linkbutton"
       data-options="iconCls:'icon-search'"
       >下载亚马逊库存信息</a>
</div>
<table id="dg" style="width: 100%; height: auto">

</table>
<!--编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 1000px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
    <div class="ftitle">
        <b>亚马逊库存信息</b>
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
                <td>店铺merchantId：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="merchantId">
                </td>
                <td>asin：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="asin">
                </td>
            </tr>
            <tr>
                <td>fnSku：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="fnSku">
                </td>
                <td>卖家SKU：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="sellerSku">
                </td>
            </tr>
            <tr>
                <td>condition：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="conditionStr">
                </td>
                <td>fulfillableQuantity：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="fulfillableQuantity">
                </td>
            </tr>
            <tr>
                <td>
                    inboundWorkingQuantity：
                </td>
                <td>
                    <input class="easyui-validatebox textbox" name="inboundWorkingQuantity">
                </td>
                <td>inboundReceivingQuantity：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="inboundReceivingQuantity">
                </td>
            </tr>
            <tr>
                <td>totalReservedQuantity：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="totalReservedQuantity">
                </td>
                <td>pendingCustomerOrderQuantity：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="pendingCustomerOrderQuantity">
                </td>
            </tr>
            <tr>
                <td>pendingTransshipmentQuantity：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="pendingTransshipmentQuantity">
                </td>
                <td>fcProcessingQuantity：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="fcProcessingQuantity">
                </td>
            </tr>
            <tr>
                <td>totalResearchingQuantity：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="totalResearchingQuantity">
                </td>
                <td>researchingQuantityInShortTerm：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="researchingQuantityInShortTerm">
                </td>
            </tr>
            <tr>
                <td>researchingQuantityInMidUerm：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="researchingQuantityInMidUerm">
                </td>
                <td>researchingQuantityInLongTerm：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="researchingQuantityInLongTerm">
                </td>
            </tr>
            <tr>
                <td>unfulfillableQuantity：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="unfulfillableQuantity">
                </td>
                <td>lastUpdatedTime：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="lastUpdatedTime">
                </td>
            </tr>
            <tr>
                <td>productName：</td>
                <td colspan="3">
                    <input class="easyui-validatebox textbox" style="width: 95%" name="productName">
                </td>
            </tr>
            <tr>
                <td>totalQuantity：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="totalQuantity">
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
               data-options="iconCls:'icon-cancel'" onclick="closeDialog()">关闭</a>
        </div>
    </form>
</div>


<script type="text/javascript">
    bindData();
    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/amazonFbaInventory/listAmazonFbaInventory";
        title = "亚马逊库存管理";
        queryParams = {
            merchantId: $('#s_merchantId').val(),
            asin: $("#s_asin").val(),
            fnSku: $("#s_fnSku").val(),
            sellerSku: $("#s_sellerSku").val(),
            productName: $("#s_productName").val()
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
                {title: 'merchantId', field: 'merchantId', width: 120},
                {title: 'asin', field: 'asin', width: 100},
                {title: 'fnSku', field: 'fnSku', width: 100},
                {title: 'sellerSku', field: 'sellerSku', width: 120},
                {title: 'condition', field: 'condition', width: 100},
                {title: 'fulfillableQuantity', field: 'fulfillableQuantity', width: 50},
                {title: 'inboundWorkingQuantity', field: 'inboundWorkingQuantity', width: 50},
                {title: 'inboundReceivingQuantity', field: 'inboundReceivingQuantity', width: 50},
                {title: 'totalReservedQuantity', field: 'totalReservedQuantity', width: 50},
                {title: 'pendingCustomerOrderQuantity', field: 'pendingCustomerOrderQuantity', width: 50},
                {title: 'pendingTransshipmentQuantity', field: 'pendingTransshipmentQuantity', width: 50},
                {title: 'fcProcessingQuantity', field: 'fcProcessingQuantity', width: 50},
                {title: 'totalResearchingQuantity', field: 'totalResearchingQuantity', width: 50},
                {title: 'researchingQuantityInShortTerm', field: 'researchingQuantityInShortTerm', width: 50},
                {title: 'researchingQuantityInMidUerm', field: 'researchingQuantityInMidUerm', width: 50},
                {title: 'researchingQuantityInLongTerm', field: 'researchingQuantityInLongTerm', width: 50},
                {title: 'unfulfillableQuantity', field: 'unfulfillableQuantity', width: 50},
                {title: 'lastUpdatedTime', field: 'lastUpdatedTime', width: 100},
                {title: 'productName', field: 'productName', width: 100},
                {title: 'totalQuantity', field: 'totalQuantity', width: 50},
                {title: 'createTime', field: 'createTime', width: 100},
                {title: 'updateTime', field: 'updateTime', width: 100}
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
            $('#dlg').dialog('open').dialog('setTitle', '查看');
            $('#frm').form('load', rows[0]);
            $("#btn_save").hide();
            $(".view_hide").show();
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function downAmazonFbaInventory() {
        $.messager.alert("提示", "暂未实现.");
        return;
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
