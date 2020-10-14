<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2020/8/13
  Time: 18:44
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
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/main.css?t=20200928" type="text/css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/common/common.js?t=20200929"></script>
    <title>店铺头程费管理</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    店铺：
    <select id="s_shopId" style="width:150px;">
    </select>
    年月
    <input class="easyui-validatebox textbox" id="s_month">
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>

    <a href="javascript:void(0)" onclick="createShopHeadTripCost()" class="easyui-linkbutton"
       data-options="iconCls:'icon-search'">生成店铺头程费</a>
</div>
<table id="dg" style="width: 100%; height: auto">

</table>

<!--编辑页面-->
<div id="dlgShopSkuHeadTripCostHis" class="easyui-dialog" style="width: 850px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', top:50,align:'center'">
    <input type="hidden" id="dlgShopSkuHeadTripCostHis_ShopHeadTripCostId">
    <!--查询条件-->
    <div class="easyui-panel">
        店铺sku：
        <input class="easyui-validatebox textbox" id="dlgShopSkuHeadTripCostHis_shopSku">
        <a href="javascript:void(0)" onclick="bindShopSkuHeadTripCostHis()" class="easyui-linkbutton"
           data-options="iconCls:'icon-search'"
           style="width: 80px">查 询</a>
    </div>
    <table id="dgShopSkuHeadTripCostHis" style="width: 100%; height: auto">
    </table>
</div>

<div id="cover">
    <div id="coverMsg">
        <img src="${pageContext.request.contextPath }/static/img/loading.gif" width="100px">
    </div>
</div>
<script type="text/javascript">
    $(function () {
        initMonth('s_month');
        bindShop();
        bindData();
    });

    function bindShop() {
        $('#s_shopId').combobox({
            valueField: 'shopId',
            textField: 'shopName',
            url: "${pageContext.request.contextPath }/shop/userShopComboboxlist",//获取数据
        });
    }

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/shopHeadTripCost/list";
        title = "订单管理";
        queryParams = {
            shopId: $("#s_shopId").combobox('getValue'),
            month: $("#s_month").val()
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
            nowrap: false,
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
                    title: '年月', field: 'month', width: 80, formatter: function (value, row, index) {
                    if (value) {
                        return value.substr(0, 7);
                    }
                }
                }, {
                    title: '店铺sku头程费',
                    field: 'shopSkuHeadTripCost',
                    width: 120,
                    formatter: function (value, row, index) {
                        return "<a href='#' onclick=\"showDlgShopSkuHeadTripCost(" + row.id + ")\" title='店铺sku头程费' >店铺sku头程费</a>";
                    }
                },
                {
                    title: '备注', field: 'remark', width: 288,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-textbox " style="width:100%"  onchange="saveRemark(this,' + row.id + ')">';
                        } else {
                            return '<input class="easyui-textbox" style="width:100%" value="' + value + '" onchange="saveRemark(this,' + row.id + ')">';
                        }
                    }
                }, {
                    title: '操作',
                    field: 'deal',
                    width: 120,
                    formatter: function (value, row, index) {
                        return "<a href='#' onclick=\"exportShopSkuHeadTripCostHis(" + row.id + ")\" title='下载店铺sku头程费' >下载店铺sku头程费</a>";
                    }
                },
                {title: '创建时间', field: 'createTime', width: 150},
                {title: '修改时间', field: 'updateTime', width: 150}
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

    function saveRemark(input, id) {
        var remark = $(input).val();
        $.post('${pageContext.request.contextPath }/shopHeadTripCost/saveShopHeadTripCostRemark', {
            id: id,
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

    function createShopHeadTripCost() {
        var shopId = $("#s_shopId").combobox('getValue');
        if (isEmpty(shopId)) {
            $.messager.alert("提示", "请选择店铺");
            return;
        }
        var month = $("#s_month").val();
        if (isEmpty(month)) {
            $.messager.alert("提示", "请选择月份");
            return;
        }
        var shopName = $("#s_shopId").combobox('getText');
        $.messager.confirm('提示', '生成时间较长，建议用户使用较少时生成，是否生成店铺：' + shopName + ',月份：' + month + '的头程费信息？', function (r) {
            if (r) {
                showCover();
                $.post('${pageContext.request.contextPath }/shopHeadTripCost/createShopHeadTripCost', {
                    shopId: shopId,
                    month: month,
                    type: 1
                }, function (data) {
                    hideCover();
                    if (data.code == '200') {
                        bindData();
                        $.messager.alert("提示", "生成成功");
                    }
                    else {
                        $.messager.alert("提示", data.message);
                    }
                });
                //createShopHeadTripCostByType(shopId, month, 1, null);
            }
        });

    }

    function createShopHeadTripCostByType(shopId, month, type, createRemark) {
        showCover();
        $.post('${pageContext.request.contextPath }/shopHeadTripCost/createShopHeadTripCost', {
            shopId: shopId,
            month: month,
            createRemark: createRemark,
            type: type
        }, function (data) {
            hideCover();
            if (data.code == '200') {
                hideCover();
                bindData();
                $.messager.alert("提示", "生成成功");
            } else if (data.code == "301") {
                $.messager.confirm('提示', data.message + ',是否要继续生成头程费信息？', function (r) {
                    if (r) {
                        createShopHeadTripCostByType(shopId, month, 2, data.message);
                    } else {
                        hideCover();
                    }
                });
            }
            else {
                $.messager.alert("提示", data.message);
                hideCover();
            }
        });
    }

    function showDlgShopSkuHeadTripCost(id) {
        $('#dlgShopSkuHeadTripCostHis').dialog('open').dialog('setTitle', '店铺sku头程费信息');
        $('#dlgShopSkuHeadTripCostHis_ShopHeadTripCostId').val(id);
        $('#dlgShopSkuHeadTripCostHis_shopSku').val(null);
        bindShopSkuHeadTripCostHis();
    }

    function bindShopSkuHeadTripCostHis() {
        dg = '#dgShopSkuHeadTripCostHis';
        url = "${pageContext.request.contextPath }/shopSkuHeadTripCostHis/listShopSkuHeadTripCostHis";
        title = "店铺sku头程费信息";
        queryParams = {
            shopHeadTripCostId: $('#dlgShopSkuHeadTripCostHis_ShopHeadTripCostId').val(),
            shopSku: $('#dlgShopSkuHeadTripCostHis_shopSku').val()
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
                {title: '店铺sku', field: 'shopSku', width: 160},
                {title: '旧头程费', field: 'headTripCostBefore', width: 80},
                {title: '新头程费', field: 'headTripCostAfter', width: 80},
                {title: '上个月库存', field: 'inventoryQuantity', width: 80},
                {title: 'fba发货数', field: 'fbaSendQuantity', width: 80},
                {title: 'fba发货头程费', field: 'fbaHeadTripCost', width: 80},
                {title: '总头程费', field: 'totalHeadTripCost', width: 80},
                {title: '创建时备注', field: 'createRemark', width: 180}
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

    function exportShopSkuHeadTripCostHis(id) {
        url = "${pageContext.request.contextPath }/shopSkuHeadTripCostHis/exportShopSkuHeadTripCostHis?shopHeadTripCostId="+id;
        window.open(url);
    }
</script>

</body>
</html>
