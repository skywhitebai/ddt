<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2019/8/21
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.5.4/themes/default/easyui.css"
          type="text/css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.5.4/themes/icon.css"
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
            src="${pageContext.request.contextPath }/static/js/common/common.js?t=20201028"></script>
    <title>补货信息</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    店铺：
    <select id="s_shopId" style="width:150px;">
    </select>
    店铺sku：
    <input class="easyui-validatebox textbox" id="s_shopSku">
    店铺父sku：
    <input class="easyui-validatebox textbox" id="s_shopParentSku">
    产品sku：
    <input class="easyui-validatebox textbox" id="s_sku">
    销售人员：
    <input class="easyui-validatebox textbox" id="s_salesmanUserId">
    显示类型：
    <select class="easyui-combobox" id="s_showType" style="width:200px;">
        <option value="1">全部</option>
        <option value="2">有销量或者fba库存</option>
    </select>
    生产状态：
    <select class="easyui-combobox" id="s_produceStatus" style="width:100px;">
        <option value="">全部</option>
        <option value="1">正常生产</option>
        <option value="2">暂停生产</option>
    </select>
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
    <a href="javascript:void(0)" onclick="createStockRecord()" class="easyui-linkbutton"
       data-options="iconCls:'icon-search'"
       style="">生成补货单</a>
    <a href="javascript:void(0)" onclick="createFactoryProduction()" class="easyui-linkbutton"
       data-options="iconCls:'icon-search'"
       style="">生成工厂生产单</a>
    <a href="javascript:void(0)" onclick="openThisView()" class="easyui-linkbutton">全屏显示</a>
</div>
<table id="dg" style="width: 100%; height: auto">
</table>

<!--编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 600px; height: 520px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:50,align:'center'">
    <div class="ftitle">
        <b>补货信息</b>
        <hr/>
    </div>
    <form id="frm" method="post" novalidate="novalidate">
        <table>
            <tr>
                <td>店铺sku：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="shopSku" readonly="readonly">
                </td>
                <td>日均销量：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="estimateAverageDailySales" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>FBA总可售库存：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="fbaTotalCanSaleQuantity" readonly="readonly">
                </td>
                <td>FBA当前可售库存：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="afnFulfillableQuantity" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>总库存周转：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="estimateCanSaleDay" readonly="readonly">
                </td>
                <td>当前库存周转：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="ableCanSaleDay" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>在途：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="onTheWayQuantity" readonly="readonly">
                </td>
                <td>reserver数量：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="afnReservedQuantity" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>receive数量：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="afnInboundReceivingQuantity" readonly="readonly">
                </td>
                <td>working数量：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="afnInboundWorkingQuantity" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>shipped数量：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="afnInboundShippedQuantity" readonly="readonly">
                </td>
                <td>在途周转：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="onTheWayQuantityCanSaleDay" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>补货数量：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="stockQuantity" readonly="readonly">
                </td>
                <td>补货数量周转：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="stockQuantityCanSaleDay" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>空运补货数量：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="stockQuantityKy" readonly="readonly">
                </td>
                <td>空派补货数量：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="stockQuantityKp" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>海运补货数量：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="stockQuantityHy" readonly="readonly">
                </td>
                <td>生产数量：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="productionQuantity" readonly="readonly">
                </td>
            </tr>
        </table>
        <div style="text-align:center;">
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
        </table>
    </form>
    <table id="dgImg" style="width: 100%; height: auto">
    </table>
</div>
<div id="dlgInventoryQuantity" class="easyui-dialog" style="width: 600px; height: 600px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true,top:50, align:'center'">
    <form id="frmInventoryQuantity" method="post" enctype="multipart/form-data">
        <table>
            <tr style="display: none">
                <td>skuId：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="skuId">
                </td>
                <td>shopId：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="shopId">
                </td>
                <td>
                    <input class="easyui-validatebox textbox" name="type">
                </td>
            </tr>
        </table>
    </form>
    <table id="dgInventoryQuantity" style="width: 100%; height: auto">
    </table>
</div>
<div id="dlgProduceOrderShopSkuProductionQuantity" class="easyui-dialog"
     style="width: 600px; height: 600px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true,top:50, align:'center'">
    <form id="frmProduceOrderShopSkuProductionQuantity" method="post" enctype="multipart/form-data">
        <table>
            <tr style="display: none">
                <td>skuId：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="skuId">
                </td>
                <td>shopId：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="shopId">
                </td>
                <td>
                    <input class="easyui-validatebox textbox" name="type">
                </td>
            </tr>
        </table>
    </form>
    <table id="dgProduceOrderShopSkuProductionQuantity" style="width: 100%; height: auto">
    </table>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        bindShop();
        bindSalesmanUserId();
    });

    function bindShop() {
        $('#s_shopId').combobox({
            valueField: 'shopId',
            textField: 'shopName',
            url: "${pageContext.request.contextPath }/shop/userShopComboboxlist",//获取数据
        });
    }

    function bindSalesmanUserId() {
        $.post('${pageContext.request.contextPath }/user/comboboxlist', {}, function (data) {
            var userNull = {'userId': -1, 'realName': "销售人员为空"};
            data.push(userNull);
            $('#s_salesmanUserId').combobox({
                data: data,
                valueField: 'userId',
                textField: 'realName'
            });
        });
    }

    var pageSizeEnable = false;

    function bindData() {
        var shopId = $("#s_shopId").combobox('getValue');
        if (isEmpty(shopId)) {
            $.messager.alert("提示", "请选择店铺.");
            return;
        }
        var pageSize = 15;
        if (pageSizeEnable) {
            pageSize = $("#dg").datagrid("getPager").data("pagination").options.pageSize;
        } else {
            pageSizeEnable = true;
        }
        dg = '#dg';
        url = "${pageContext.request.contextPath }/stock/listStock";
        title = "备货管理";
        queryParams = {
            shopId: shopId,
            shopSku: $("#s_shopSku").val(),
            shopParentSku: $("#s_shopParentSku").val(),
            showType: $("#s_showType").val(),
            salesmanUserId: $("#s_salesmanUserId").val(),
            sku: $("#s_sku").val(),
            produceStatus: $("#s_produceStatus").val()
        };
        $(dg).datagrid({   //定位到Table标签，Table标签的ID是grid
            url: url,   //指向后台的Action来获取当前菜单的信息的Json格式的数据
            title: title,
            striped: true,
            pagination: true,
            singleSelect: true,
            pageSize: pageSize,
            pageList: [10, 15, 20, 30, 50, 100, 200, 500],
            rownumbers: true,
            remoteSort: false,
            idField: 'shopSkuId',
            queryParams: queryParams,  //异步查询的参数
            frozenColumns: [[
                {field: 'ck', checkbox: true},   //选择
                {title: '店铺名', field: 'shopName', width: 140},
                {title: '销售负责人', field: 'salesmanRealName', width: 120},
                {title: '店铺sku', field: 'shopSku', width: 168},
                {title: '店铺父sku', field: 'shopParentSku', width: 168},
                {title: '产品sku', field: 'sku', width: 168},
                {
                    title: '图片', field: 'imgUrl', width: 120,
                    formatter: function (value, rowData, rowIndex) {
                        var res = "";
                        if (value != null && value != '') {
                            res += '<a href="javascript:;" onclick="showImg(' + value + ')" ><img  src="' + value + '?x-oss-process=image/resize,m_fill,h_66,w_66"  style="width:66px; height:66px;"/></a> '
                        } else {
                            res += '暂无图片   '
                        }
                        res += '<a href="javascript:;" onclick="showImgDialog(' + rowData.skuId + ')" >查看</a>';
                        return res;
                    }
                }
            ]],
            columns: [[
                {title: '7天实销', field: 'salesForTheLast7Days', width: 70},
                {title: '14天实销', field: 'salesForTheLast14Days', width: 70},
                /*{title: '21天实销', field: 'salesForTheLast21Days', width: 70},
                {title: '28天实销', field: 'salesForTheLast28Days', width: 70},*/
                {title: '35天实销', field: 'salesForTheLast35Days', width: 70},
                {title: '预计日均销量', field: 'estimateAverageDailySales', width: 90},
                /*{title: '预计14天销量', field: 'estimateSales14Days', width: 90},
                {title: '预计28天销量', field: 'estimateSales28Days', width: 90},
                {title: '预计42天销量', field: 'estimateSales42Days', width: 90},
                {title: '预计56天销量', field: 'estimateSales56Days', width: 90},
                {title: '预计90天销量', field: 'estimateSales90Days', width: 90},*/
                {title: 'fba总可售库存', field: 'fbaTotalCanSaleQuantity', width: 90},
                {
                    title: '预计可售天数', field: 'estimateCanSaleDay', width: 90,
                    formatter: function (value, row, rowIndex) {
                        var res = "";
                        if (value >= 30) {
                            res = value;
                        } else {
                            res += '<span style="color:red">' + value + '</span>'
                        }
                        return res;
                    },
                    styler: function (value, row, rowIndex) {
                        if (value < 30) {
                            return 'background-color:yellow;'
                        }
                    }
                },
                {
                    title: '28天建议补货', field: 'replenishQuantity28Days', width: 90, styler: cellStyler,
                    formatter: cellFormatter
                },
                {
                    title: '42天建议补货', field: 'replenishQuantity42Days', width: 90, styler: cellStyler,
                    formatter: cellFormatter
                },
                {
                    title: '56天建议补货', field: 'replenishQuantity56Days', width: 90, styler: cellStyler,
                    formatter: cellFormatter
                },
                {
                    title: '90天建议补货', field: 'replenishQuantity90Days', width: 90, styler: cellStyler,
                    formatter: cellFormatter
                },
                {title: '店铺sku', field: 'shopSku', width: 168},
                {title: 'fba可售库存', field: 'afnFulfillableQuantity', width: 90},
                {title: '店铺库存', field: 'inventoryQuantity', width: 90},
                {
                    title: '其他店铺库存', field: 'inventoryQuantityOtherShop', width: 90,
                    formatter: function (value, row, rowIndex) {
                        return '<a href="javascript:;" title="查看其他店铺库存" onclick="showInventoryQuantityDialog(' + row.skuId + ',' + row.shopId + ',1)" >' + value + '</a>';
                    }
                },
                {
                    title: '其他仓库库存', field: 'inventoryQuantityWarehouse', width: 90,
                    formatter: function (value, row, rowIndex) {
                        return '<a href="javascript:;" title="查看其他仓库库存" onclick="showInventoryQuantityDialog(' + row.skuId + ',' + row.shopId + ',2)" >' + value + '</a>';
                    }
                },
                {
                    title: '生产中数量', field: 'produceOrderShopSkuProductionQuantity', width: 90,
                    formatter: function (value, row, rowIndex) {
                        return '<a href="javascript:;" title="生产中数量" onclick="showProduceOrderShopSkuProductionQuantityDialog(' + row.skuId + ',' + row.shopId + ',0)" >' + value + '</a>';
                    }
                },
                {
                    title: '其他店铺生产中数量', field: 'produceOrderShopSkuProductionQuantityOtherShop', width: 90,
                    formatter: function (value, row, rowIndex) {
                        return '<a href="javascript:;" title="查看其他店铺库存" onclick="showProduceOrderShopSkuProductionQuantityDialog(' + row.skuId + ',' + row.shopId + ',1)" >' + value + '</a>';
                    }
                },
                {
                    title: '其他仓库生产中数量', field: 'produceOrderShopSkuProductionQuantityWarehouse', width: 90,
                    formatter: function (value, row, rowIndex) {
                        return '<a href="javascript:;" title="查看其他店铺库存" onclick="showProduceOrderShopSkuProductionQuantityDialog(' + row.skuId + ',' + row.shopId + ',2)" >' + value + '</a>';
                    }
                },
                {title: '补货数量', field: 'stockQuantity', width: 90},
                {
                    title: '空运补货', field: 'stockQuantityKy', width: 90,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-numberbox " min="0" precision="0" onchange="saveStockQuantity(this,' + row.shopSkuId + ',\'ky\')">';
                        } else {
                            return '<input class="easyui-numberbox" min="0" precision="0" value="' + value + '" onchange="saveStockQuantity(this,' + row.shopSkuId + ',\'ky\')">';
                        }
                    }
                },
                {
                    title: '空派补货', field: 'stockQuantityKp', width: 90,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-numberbox " min="0" precision="0" onchange="saveStockQuantity(this,' + row.shopSkuId + ',\'kp\')">';
                        } else {
                            return '<input class="easyui-numberbox" min="0" precision="0" value="' + value + '" onchange="saveStockQuantity(this,' + row.shopSkuId + ',\'kp\')">';
                        }
                    }
                },
                {
                    title: '海运补货', field: 'stockQuantityHy', width: 90,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-numberbox " min="0" precision="0" onchange="saveStockQuantity(this,' + row.shopSkuId + ',\'hy\')">';
                        } else {
                            return '<input class="easyui-numberbox" min="0" precision="0" value="' + value + '" onchange="saveStockQuantity(this,' + row.shopSkuId + ',\'hy\')">';
                        }
                    }
                },
                {
                    title: '预计生产数量', field: 'estimateProductionQuantity', width: 100, styler: cellStyler,
                    formatter: cellFormatter
                },
                {
                    title: '实际生产数量', field: 'productionQuantity', width: 100,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-numberbox " min="0" precision="0" onchange="saveProductionQuantity(this,' + row.shopSkuId + ')">';
                        } else {
                            return '<input class="easyui-numberbox" min="0" precision="0" value="' + value + '" onchange="saveProductionQuantity(this,' + row.shopSkuId + ')">';
                        }
                    }
                },
                {title: '设置时间', field: 'createTime', width: 180},
                {title: '修改时间', field: 'updateTime', width: 180},
                {
                    title: '生产状态', field: 'produceStatus', width: 65,
                    formatter: function (value, row, rowIndex) {
                        if (value == 1) {
                            return '<a href="javascript:;" title="正常生产" onclick="setProduceStatus(' + row.shopSkuId + ",'" + row.shopSku + "'" + ',2)" >正常生产</a>';
                        } else if (value == 2) {
                            return '<a href="javascript:;" title="暂停生产" onclick="setProduceStatus(' + row.shopSkuId + ",'" + row.shopSku + "'"  + ',1)" >暂停生产</a>';
                        }
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
            }, '-', {
                id: 'btnReload',
                text: '刷新',
                iconCls: 'icon-reload',
                handler: function () {
                    //实现刷新栏目中的数据
                    $(dg).datagrid("reload");
                    $(dg).datagrid('uncheckAll');
                }
            }, '-', {
                id: 'btnReload',
                text: '停用',
                iconCls: 'icon-remove',
                handler: function () {
                    stopShopSku();
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
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function closeDialog() {
        $('#dlg').dialog('close')
    }

    function cellStyler(value, row, index) {
        if (value > 0) {
            return 'background-color:yellow;'
        }
    }

    function cellFormatter(value, row, index) {
        var res = "";
        if (value <= 0) {
            res = value;
        } else {
            res += '<span style="color:red">' + value + '</span>'
        }
        return res;
    }

    function saveStockQuantity(input, shopSkuId, type) {
        var stockQuantity = $(input).val();
        if (isEmpty(stockQuantity)) {
            stockQuantity = 0;
        }
        var r = /^\d+$/;　　//正整数
        if (!r.test(stockQuantity)) {
            $.messager.alert("提示", "补货数量必须为大于等于0的数字.");
            $(input).focus()
            return;
        }
        $.post('${pageContext.request.contextPath }/stock/saveStockQuantity', {
            stockQuantity: stockQuantity,
            shopSkuId: shopSkuId,
            type: type
        }, function (data) {
            if (data.code == '200') {
                //保存成功
                refreshStockQuantity(stockQuantity, shopSkuId, type);
            } else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function saveProductionQuantity(input, shopSkuId) {
        var productionQuantity = $(input).val();
        if (isEmpty(productionQuantity)) {
            productionQuantity = 0;
        }
        var r = /^\d+$/;　　//正整数
        if (!r.test(productionQuantity)) {
            $.messager.alert("提示", "生产数量必须为大于等于0的数字.");
            $(input).focus()
            return;
        }
        $.post('${pageContext.request.contextPath }/stock/saveProductionQuantity', {
            productionQuantity: productionQuantity,
            shopSkuId: shopSkuId
        }, function (data) {
            if (data.code == '200') {
                //保存成功
            } else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function refreshStockQuantity(stockQuantity, shopSkuId, type) {
        var rowIndex = $('#dg').datagrid('getRowIndex', shopSkuId);//id是关键字值
        var row = $('#dg').datagrid('getData').rows[rowIndex];
        if (type == "ky") {
            row.stockQuantityKy = stockQuantity;
        } else if (type == "kp") {
            row.stockQuantityKp = stockQuantity;
        } else if (type == "hy") {
            row.stockQuantityHy = stockQuantity;
        }
        var stockQuantityKy = parseInt(row.stockQuantityKy);
        var stockQuantityKp = parseInt(row.stockQuantityKp)
        var stockQuantityHy = parseInt(row.stockQuantityHy)
        var stockQuantityTotal = stockQuantityKy + stockQuantityKp + stockQuantityHy;
        var estimateProductionQuantity = stockQuantityTotal - row.inventoryQuantity;
        var stockQuantityTotal = stockQuantityKy + stockQuantityKp + stockQuantityHy;
        var stockQuantityCanSaleDay = getCanSaleDay(stockQuantityTotal, row.estimateAverageDailySales);
        $('#dg').datagrid('updateRow', {
            index: rowIndex,
            row: {
                'stockQuantity': stockQuantityTotal,
                'stockQuantityKy': stockQuantityKy,
                'stockQuantityKp': stockQuantityKp,
                'stockQuantityHy': stockQuantityHy,
                'stockQuantityCanSaleDay': stockQuantityCanSaleDay,
                'estimateProductionQuantity': estimateProductionQuantity
            }
        });
    }

    function getCanSaleDay(quantity, estimateAverageDailySales) {
        if (quantity == 0) {
            return 0.00;
        }
        if (estimateAverageDailySales == 0) {
            return 365.00;
        }
        var canSaleDay = fomatFloat(quantity / estimateAverageDailySales, 2);
        return canSaleDay;
    }

    function createStockRecord() {
        var shopId = $("#s_shopId").combobox('getValue');
        if (isEmpty(shopId)) {
            $.messager.alert("提示", "请选择店铺.");
            return;
        }
        var shopName = $("#s_shopId").combobox('getText');
        $.messager.confirm('提示', '确认生成店铺' + shopName + '的补货单数据吗？', function (r) {
            if (r) {
                $.post('${pageContext.request.contextPath }/stockRecord/createStockRecord', {shopId: shopId}, function (data) {
                    if (data.code == '200') {
                        $('#dlg').dialog('close');
                        //跳转到补货单列表页
                        $.messager.alert("提示", "生成补货单数据成功，请到补货单记录管理查看");
                        bindData();
                    } else {
                        $.messager.alert("提示", data.message);
                    }
                });
            }
        });
    }

    function createFactoryProduction() {
        var shopId = $("#s_shopId").combobox('getValue');
        if (isEmpty(shopId)) {
            $.messager.alert("提示", "请选择店铺.");
            return;
        }
        var shopName = $("#s_shopId").combobox('getText');
        $.messager.confirm('提示', '确认生成店铺' + shopName + '的工厂生产单数据吗？', function (r) {
            if (r) {
                $.post('${pageContext.request.contextPath }/factoryProductionOrder/createFactoryProductionOrder', {shopId: shopId}, function (data) {
                    if (data.code == '200') {
                        $('#dlg').dialog('close');
                        //跳转到补货单列表页
                        $.messager.alert("提示", "生成工厂生产单数据成功，请到工厂生产单管理查看");
                        bindData();
                    } else {
                        $.messager.alert("提示", data.message);
                    }
                });
            }
        });
    }

    function openThisView() {
        window.open("${pageContext.request.contextPath }/stock/index");
    }

    function showImgDialog(skuId) {
        $('#dlgImg').dialog('open').dialog('setTitle', 'sku图片');
        $('#frmImg').form('clear');
        $("div#dlgImg input[name='entityId']").val(skuId);
        $("div#dlgImg input[name='imgType']").val("sku.sku_img");
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

    function showInventoryQuantityDialog(skuId, shopId, type) {
        if (type == 1) {
            $('#dlgInventoryQuantity').dialog('open').dialog('setTitle', '其他店铺库存');
        } else {

            $('#dlgInventoryQuantity').dialog('open').dialog('setTitle', '仓库库存');
        }
        $("div#dlgInventoryQuantity input[name='shopId']").val(shopId);
        $("div#dlgInventoryQuantity input[name='skuId']").val(skuId);
        $("div#dlgInventoryQuantity input[name='type']").val(type);
        bindInventoryQuantityData();
    }

    function bindInventoryQuantityData() {
        dg = '#dgInventoryQuantity';
        url = "${pageContext.request.contextPath }/shopSku/listInventoryQuantity";
        title = "其他店铺仓库库存";
        queryParams = {
            shopId: $("div#dlgInventoryQuantity input[name='shopId']").val(),
            skuId: $("div#dlgInventoryQuantity input[name='skuId']").val(),
            type: $("div#dlgInventoryQuantity input[name='type']").val()
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
            idField: 'shopSkuId',
            queryParams: queryParams,  //异步查询的参数
            columns: [[
                {field: 'ck', checkbox: true},   //选择
                {title: '店铺名称', field: 'shopName', width: 100},
                {title: '店铺sku', field: 'shopSku', width: 180},
                {title: '库存', field: 'inventoryQuantity', width: 80}
            ]],
            toolbar: [{
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

    function showProduceOrderShopSkuProductionQuantityDialog(skuId, shopId, type) {
        if (type == 0) {
            $('#dlgProduceOrderShopSkuProductionQuantity').dialog('open').dialog('setTitle', '生产中数量');
        } else if (type == 1) {
            $('#dlgProduceOrderShopSkuProductionQuantity').dialog('open').dialog('setTitle', '其他店铺生产中数量');
        } else if (type == 2) {
            $('#dlgProduceOrderShopSkuProductionQuantity').dialog('open').dialog('setTitle', '其他仓库生产中数量');
        }
        $("div#dlgProduceOrderShopSkuProductionQuantity input[name='shopId']").val(shopId);
        $("div#dlgProduceOrderShopSkuProductionQuantity input[name='skuId']").val(skuId);
        $("div#dlgProduceOrderShopSkuProductionQuantity input[name='type']").val(type);
        bindProduceOrderShopSkuProductionQuantityData();
    }

    function bindProduceOrderShopSkuProductionQuantityData() {
        dg = '#dgProduceOrderShopSkuProductionQuantity';
        url = "${pageContext.request.contextPath }/produceOrderShopSku/listProduceOrderShopSkuProductionQuantity";
        title = "生产中数量";
        queryParams = {
            shopId: $("div#dlgProduceOrderShopSkuProductionQuantity input[name='shopId']").val(),
            skuId: $("div#dlgProduceOrderShopSkuProductionQuantity input[name='skuId']").val(),
            type: $("div#dlgProduceOrderShopSkuProductionQuantity input[name='type']").val()
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
            idField: 'shopSkuId',
            queryParams: queryParams,  //异步查询的参数
            columns: [[
                {field: 'ck', checkbox: true},   //选择
                {title: '店铺名称', field: 'shopName', width: 100},
                {title: '店铺sku', field: 'shopSku', width: 180},
                {title: '生产中数量', field: 'productionQuantity', width: 80},
                {title: '入库数量', field: 'warehousingQuantity', width: 80}
            ]],
            toolbar: [{
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

    function stopShopSku() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            var shopSkuId = rows[0].shopSkuId;
            var shopSku = rows[0].shopSku;
            $.messager.confirm('提示', '确认停用【' + shopSku + '】吗？', function (r) {
                if (r) {
                    $.post('${pageContext.request.contextPath }/shopSku/stopShopSku', {shopSkuId: shopSkuId}, function (data) {
                        if (data.code == '200') {
                            bindData();
                        } else {
                            $.messager.alert("提示", data.message);
                        }
                    });
                }
            });
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
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
</html>
