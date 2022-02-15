<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2019/8/22
  Time: 17:40
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
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/main.css?t=20200928" type="text/css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/common/common.js?t=20201028"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/common/cookieUtil.js?t=20200928"></script>
    <title>补货记录</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    店铺：
    <select id="s_shopId" style="width:150px;">
    </select>
    补货记录id：
    <input class="easyui-numberbox" id="s_id" data-options="min:1,precision:0">
    店铺sku
    <input class="easyui-validatebox textbox" id="s_shopSku">
    产品sku
    <input class="easyui-validatebox textbox" id="s_sku">
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
</div>
<table id="dg" style="width: 100%; height: auto">
</table>

<!--发货单详情-->
<div id="dlgStockRecordItem" class="easyui-dialog" style="width: 1200px; height: 660px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, align:'center'">
    <div>
        <input type="hidden" id="s_stockRecordId">
        店铺sku
        <input class="easyui-validatebox textbox" id="s_stockRecordItem_shopSku">
        产品sku
        <input class="easyui-validatebox textbox" id="s_stockRecordItem_sku">
        <a href="javascript:void(0)" onclick="bindStockRecordItemData()" class="easyui-linkbutton"
           data-options="iconCls:'icon-search'"
           style="width: 80px">查 询</a>
    </div>
    <table id="dgStockRecordItem" style="width: 100%; height: auto">
    </table>
    <div style="text-align:center;">
        <a href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-cancel'" onclick="closeDlgStockRecordItem()">关闭</a>
    </div>
</div>


</body>
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
        url = "${pageContext.request.contextPath }/stockRecord/listStockRecord";
        title = "备货管理";
        queryParams = {
            shopId: $("#s_shopId").combobox('getValue'),
            id: $("#s_id").val(),
            shopSku: $("#s_shopSku").val(),
            sku: $("#s_sku").val()
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
            singleSelect: true,
            pageSize: 15,
            pageList: [10, 15, 20, 30, 50, 100, 200, 500],
            rownumbers: true,
            //sortName: 'ID',    //根据某个字段给easyUI排序
            //sortOrder: 'asc',
            remoteSort: false,
            idField: 'id',
            queryParams: queryParams,  //异步查询的参数
            columns: [[
                {field: 'ck', checkbox: true},   //选择
                {title: '补货记录id', field: 'id', width: 88},
                {title: '店铺名', field: 'shopName', width: 120},
                {title: '标题', field: 'title', width: 320},
                {title: '发货总数', field: 'stockQuantityTotal', width: 90},
                {
                    title: '状态', field: 'status', width: 88,
                    formatter: function (value, row, rowIndex) {
                        if (value == 1) {
                            return '已完成';
                        } else {
                            return ' <a href="javascript:void(0)" onclick="setDone(' + row.id + ')" class="easyui-linkbutton" style="width: 80px">设置已完成</a>';
                        }
                    }
                },
                {
                    title: '备注', field: 'remark', width: 300,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-textbox " style="width:100%"  onchange="saveStockRecordRemark(this,' + row.id + ')">';
                        } else {
                            return '<input class="easyui-textbox" style="width:100%" value="' + value + '" onchange="saveStockRecordRemark(this,' + row.id + ')">';
                        }
                    }
                },
                {title: '创建时间', field: 'createTime', width: 180},
                {
                    title: '操作', field: 'stockRecordId', width: 600,
                    formatter: function (value, row, rowIndex) {
                        return '<a href="javascript:void(0)" onclick="showDlgStockRecordItem(' + row.id + ',\'' + row.title + '\')" class="easyui-linkbutton" >查看补货单</a>'
                            + '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="exportStockRecord(' + row.id + ',\'\')" class="easyui-linkbutton" >下载补货单</a>'
                            + '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="exportStockRecord(' + row.id + ',\'ky\')" class="easyui-linkbutton" >下载空运补货单</a>'
                            + '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="exportStockRecord(' + row.id + ',\'kp\')" class="easyui-linkbutton" >下载空派补货单</a>'
                            + '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="exportStockRecord(' + row.id + ',\'hy\')" class="easyui-linkbutton" >下载海运补货单</a>'
                            + '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="exportStockRecord(' + row.id + ',\'production\')" class="easyui-linkbutton" >下载生产单</a>';
                    }
                }
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

    function showDlgStockRecordItem(stockRecordId, title) {
        $("#s_stockRecordId").val(stockRecordId);
        $('#dlgStockRecordItem').dialog('open').dialog('setTitle', title + '-发货单详情');
        bindStockRecordItemData();
    }

    function closeDlgStockRecordItem() {
        $('#dlgStockRecordItem').dialog('close');
    }

    function bindStockRecordItemData() {
        dg = '#dgStockRecordItem';
        url = "${pageContext.request.contextPath }/stockRecordItem/listStockRecordItem";
        title = "发货单详情";
        queryParams = {
            stockRecordId: $("#s_stockRecordId").val(),
            shopSku: $("#s_stockRecordItem_shopSku").val(),
            sku: $("#s_stockRecordItem_sku").val()
        };
        $(dg).datagrid({   //定位到Table标签，Table标签的ID是grid
            url: url,   //指向后台的Action来获取当前菜单的信息的Json格式的数据
            title: title,
            iconCls: 'icon-view',
            nowrap: false,
            autoRowHeight: true,
            striped: true,
            collapsible: true,
            pagination: true,
            singleSelect: true,
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
                {title: '店铺sku', field: 'shopSku', width: 150},
                {title: '产品sku', field: 'sku', width: 150},
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
                {title: '发货数量', field: 'stockQuantity', width: 80},
                {title: '空运发货', field: 'stockQuantityKy', width: 80},
                {title: '空派发货', field: 'stockQuantityKp', width: 80},
                {title: '海运发货', field: 'stockQuantityHy', width: 80},
                {title: '生产数量', field: 'productionQuantity', width: 80},
                {title: '销售人员', field: 'salesmanRealName', width: 80},
                {title: '库位', field: 'locationNos', width: 160},
                {
                    title: '操作', field: 'shopSkuId', width: 60,
                    formatter: function (value, row, rowIndex) {
                        return "<a href='${pageContext.request.contextPath }/shopSku/print?shopSku=" + row.shopSku + "&quantity=" + row.stockQuantity + "'  title='打印标签'  target='_blank'>打印标签</a>";
                    }
                }
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
        //$(dg).datagrid('clearSelections');
    }


    function exportStockRecord(stockRecordId, type) {
        url = "${pageContext.request.contextPath }/stockRecord/exportStockRecord?stockRecordId=" + stockRecordId + "&type=" + type;
        window.open(url);
    }

    function setDone(stockRecordId) {
        $.post('${pageContext.request.contextPath }/stockRecord/setStockRecordDone', {
            stockRecordId: stockRecordId
        }, function (data) {
            if (data.code == '200') {
                $.messager.alert("提示", "设置成功");
                bindData();
            } else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function saveStockRecordRemark(input, stockRecordId) {
        var remark = $(input).val();
        $.post('${pageContext.request.contextPath }/stockRecord/saveStockRecordRemark', {
            stockRecordId: stockRecordId,
            remark: remark
        }, function (data) {
            if (data.code == '200') {
                $.messager.alert("提示", "修改成功");
                bindData();
            } else {
                $.messager.alert("提示", data.message);
            }
        });
    }
</script>
</html>
