function showShopSkuDialogFrom() {
    var shopId = $('#dg').datagrid('getSelections')[0].shopIdFrom;
    var shopName = $('#dg').datagrid('getSelections')[0].shopNameFrom;
    $('#s_dlgShopSkuFrom_shopName').val(shopName);
    $('#s_dlgShopSkuFrom_shopId').val(shopId);
    $('#dlgShopSkuFrom').dialog('open').dialog('setTitle', '选择店铺sku');
    bindShopSkuFrom();
}

function bindShopSkuFrom() {
    dg = '#dgShopSkuFrom';
    url = "../shopSku/listShopSku";
    title = "选择产品sku";
    queryParams = {
        shopId: $('#s_dlgShopSkuFrom_shopId').val(),
        shopSku: $("#s_dlgShopSkuFrom_shopSku").val(),
        sku: $("#s_dlgShopSkuFrom_sku_id").val()
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
                {title: '店铺sku', field: 'shopSku', width: 140},
                {title: '产品sku', field: 'sku', width: 140},
                {title: '产品名称', field: 'productName', width: 160},
                {
                    title: '操作', field: 'deal', width: 60, formatter: function (value, row, index) {
                    var content = '<a href="javascript:void(0)" onclick="selectShopSkuFrom(\'' + row.shopSku + '\')" class="easyui-linkbutton" >选择</a>';
                    return content;
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
        }
    )
    $(dg).datagrid('clearSelections');
}

function selectShopSkuFrom(shopSku) {
    $('#info_shopSkuFrom').val(shopSku);
    $('#dlgShopSkuFrom').dialog('close');
}


function showShopSkuDialogTo() {
    var shopId = $('#dg').datagrid('getSelections')[0].shopIdTo;
    var shopName = $('#dg').datagrid('getSelections')[0].shopNameTo;
    $('#s_dlgShopSkuTo_shopName').val(shopName);
    $('#s_dlgShopSkuTo_shopId').val(shopId);
    $('#dlgShopSkuTo').dialog('open').dialog('setTitle', '选择店铺sku');
    bindShopSkuTo();
}

function bindShopSkuTo(type) {
    dg = '#dgShopSkuTo';
    url = "../shopSku/listShopSku";
    title = "选择产品sku";
    queryParams = {
        shopId: $('#s_dlgShopSkuTo_shopId').val(),
        shopSku: $("#s_dlgShopSkuTo_shopSku").val(),
        sku: $("#s_dlgShopSkuTo_sku_id").val()
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
                {title: '店铺sku', field: 'shopSku', width: 140},
                {title: '产品sku', field: 'sku', width: 140},
                {title: '产品名称', field: 'productName', width: 160},
                {
                    title: '操作', field: 'deal', width: 60, formatter: function (value, row, index) {
                    var content = '<a href="javascript:void(0)" onclick="selectShopSkuTo(\'' + row.shopSku + '\')" class="easyui-linkbutton" >选择</a>';

                    return content;
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
        }
    )
    $(dg).datagrid('clearSelections');
}

function selectShopSkuTo(shopSku) {
    $('#info_shopSkuTo').val(shopSku);
    $('#dlgShopSkuTo').dialog('close');
}