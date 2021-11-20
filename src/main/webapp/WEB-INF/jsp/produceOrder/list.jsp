<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2020/3/25
  Time: 15:39
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
            src="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.5.4/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/main.css?t=20200928" type="text/css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/common/common.js?t=20201028"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/common/selectShopSku.js"></script>
    <title>生产单</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    <!--只显示用户有的店铺-->
    店铺：
    <select class="easyui-combobox" id="s_shopId" style="width:150px;">
    </select>
    生产日期：
    <input class="easyui-datebox" id="s_productionTimeStart">
    -
    <input class="easyui-datebox" id="s_productionTimeEnd">
    批号：
    <input class="easyui-validatebox textbox" id="s_batchNumber">
    店铺sku：
    <input class="easyui-validatebox textbox" id="s_shopSku">
    产品sku：
    <input class="easyui-validatebox textbox" id="s_sku">
    类型：
    <select class="easyui-combobox" id="s_type" style="width:100px;">
        <option value="">全部</option>
        <option value="1">手工生产单</option>
        <option value="2">工厂生产单</option>
    </select>
    状态：
    <select class="easyui-combobox" id="s_status" style="width:100px;">
        <option value="">全部</option>
        <option value="1">待入库</option>
        <option value="2">部分入库</option>
        <option value="3">生产完毕</option>
        <option value="0">作废</option>
    </select>
    生产完成月份：
    <input class="easyui-validatebox textbox" id="s_month">
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
    <a href="javascript:void(0)" onclick="showDialogImport('produceOrder')" class="easyui-linkbutton"
       data-options="iconCls:'icon-search'"
       style="width: 110px">导入生产单</a>

    <a href="javascript:void(0)" onclick="generationCost()" class="easyui-linkbutton"
       data-options="iconCls:'icon-search'">月度成本核算</a>
</div>
<table id="dg" style="width: 100%; height: auto">

</table>

<!--编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 700px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true,top:50, align:'center'">
    <div class="ftitle">
        <b>生产单</b>
        <hr/>
    </div>
    <form id="frm" method="post" novalidate="novalidate">
        <table>
            <tr style="display: none">
                <td>生产单id：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="id">
                </td>
            </tr>
            <tr>
                <td>店铺名：</td>
                <td colspan="3">
                    <select id="shopId" name="shopId" style="width: 90%">
                    </select>
                </td>
            </tr>
            <tr class="view_status">

                <td>批号：</td>
                <td>
                    <input class="easyui-textbox" type="text" readonly="readonly" name="batchNumber">
                </td>
                <td>状态：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="statusName" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>布料成本：</td>
                <td>
                    <input class="easyui-numberbox" name="fabricCost" id="fabricCost" min="0"
                           max="1000000"
                           precision="2">
                </td>
                <td>辅料成本：</td>
                <td>
                    <input class="easyui-numberbox" name="auxiliaryMaterialCost" id="auxiliaryMaterialCost" min="0"
                           max="1000000"
                           precision="2">
                </td>
            </tr>
            <tr>
                <td>成本备注：</td>
                <td colspan="3">
                    <input class="easyui-textbox" type="text" name="costRemark" style="width: 90%">
                </td>
            </tr>
            <tr>
                <td>备注：</td>
                <td colspan="3">
                    <input class="easyui-textbox" type="text" name="remark" style="width: 90%">
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

<!--编辑页面-->
<div id="dlgProduceOrderShopSku" class="easyui-dialog" style="width: 1000px; height: 600px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:50, align:'center'">
    <div class="ftitle">
        <b>生产单店铺sku管理</b>
        <hr/>
    </div>
    <form id="frmProduceOrderShopSku" method="post" novalidate="novalidate">
        <table>
            <tr>
                <td>店铺名：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="shopName" readonly="readonly">
                    <input type="hidden">
                </td>
                <td>批号：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="batchNumber" readonly="readonly">
                </td>
                <td>状态：</td>
                <td>
                    <input class="easyui-textbox" type="text" name="statusName" readonly="readonly">
                </td>
            </tr>
        </table>
        <a href="javascript:void(0)" onclick="bindProduceOrderShopSkuData()" class="easyui-linkbutton"
           data-options="iconCls:'icon-search'"
           style="width: 80px">查 询</a>
        <%--<a href="javascript:void(0)" onclick="showImportProduceOrderShopSku()" class="easyui-linkbutton"
           data-options="iconCls:'icon-search'">导入生产单店铺sku</a>--%>
        <a href="javascript:void(0)" onclick="exportProduceOrderShopSku()" class="easyui-linkbutton"
           data-options="iconCls:'icon-search'">导出生产单店铺sku</a>
    </form>
    <table id="dgProduceOrderShopSku" style="width: 100%; height: auto">

    </table>
</div>

<!--编辑页面-->
<div id="dlgProduceOrderShopSkuInfo" class="easyui-dialog" style="width: 700px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:50, align:'center'">
    <div class="ftitle">
        <b>生产单店铺sku管理</b>
        <hr/>
    </div>
    <form id="frmProduceOrderShopSkuInfo" method="post" novalidate="novalidate">
        <table>
            <tr style="display: none">
                <td>生产单id：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="produceOrderId">
                </td>
                <td>生产单店铺skuid：</td>
                <td>
                    <input class="easyui-validatebox textbox" name="id">
                </td>
            </tr>
            <tr>
                <td>店铺sku：</td>
                <td colspan="3">
                    <input class="easyui-validatebox textbox" name="shopSku" id="info_shopSkuId">
                    <a href="javascript:void(0)" onclick="showShopSkuDialog()" class="easyui-linkbutton"
                       data-options="iconCls:'icon-search'"
                       style="width: 80px">选择</a>
                </td>

            </tr>
            <tr>
                <td>生产数量：</td>
                <td>
                    <input class="easyui-numberbox" name="productionQuantity" data-options="min:1,precision:0">
                </td>
            </tr>
            <tr>
                <td>备注：</td>
                <td colspan="3">
                    <input class="easyui-textbox" type="text" name="remark" style="width: 90%">
                </td>
            </tr>
            <tr class="view_hide_produceOrderShopSku">
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
               data-options="iconCls:'icon-ok'" id="btn_save_produceOrderShopSku"
               onclick="saveProduceOrderShopSku()">确定</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-cancel'" onclick="closeProduceOrderShopSkuInfoDialog()">关闭</a>
        </div>
    </form>
</div>
<div id="dlgImportProduceOrderShopSku" class="easyui-dialog" style="width: 700px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:50, align:'center'">
    <iframe id="iframeImportProduceOrderShopSku" style="width: 100%;height: 100%;border: 0px"></iframe>
</div>

<!--导入信息-->
<div id="dlgImport" class="easyui-dialog" style="width: 600px; height: 300px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:50, align:'center'">
    <div class="ftitle">
        <b id="importTitle"></b>
        <hr/>
        模板下载：
        <a href="" id="importTemplate"
           target="_blank">模板下载</a>
    </div>
    <form id="frmImport" method="post" novalidate="novalidate" enctype="multipart/form-data">
        <input type="file" id="importFile" name="file" accept=".xls,.xlsx"/>
        <div style="text-align:center;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" onclick="doImport()">导入</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-cancel'" onclick="closeDialogImport()">关闭</a>
        </div>
    </form>
</div>
<div id="dlgShopSku" class="easyui-dialog" style="width: 660px; height: 600px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons',top:50,align:'center'">
    <div class="ftitle">
        <b>店铺sku</b>
        <hr/>
    </div>
    <!--查询条件-->
    <div class="easyui-panel">
        店铺：
        <input class="easyui-validatebox textbox" id="s_dlgShopSku_shopName" readonly="readonly">
        <input type="hidden" id="s_dlgShopSku_shopId">
        店铺sku：
        <input class="easyui-validatebox textbox" id="s_dlgShopSku_shopSku">
        <a href="javascript:void(0)" onclick="bindShopSku()" class="easyui-linkbutton"
           data-options="iconCls:'icon-search'"
           style="width: 80px">查 询</a>
    </div>
    <table id="dgShopSku" style="width: 100%; height: auto">

    </table>
</div>

<div id="cover">
    <div id="coverMsg">
        <img src="${pageContext.request.contextPath }/static/img/loading.gif" width="100px">
    </div>
</div>
</body>
<script type="text/javascript">
    $(function () {
        initMonth('s_month');
        bindShop();
    })

    function bindShop() {
        $.post('${pageContext.request.contextPath }/shop/comboboxlist', {}, function (data) {
            $('#s_shopId').combobox({
                data: data,
                valueField: 'shopId',
                textField: 'shopName'
            });
            $('#shopId').combobox({
                data: data,
                valueField: 'shopId',
                textField: 'shopName'
            });
            bindData();
        });
    }

    function getQueryParams() {
        queryParams = {
            shopId: $('#s_shopId').combobox('getValue'),
            productionTimeStart: $("#s_productionTimeStart").val(),
            productionTimeEnd: $("#s_productionTimeEnd").val(),
            batchNumber: $("#s_batchNumber").val(),
            shopSku: $("#s_shopSku").val(),
            sku: $("#s_sku").val(),
            status: $("#s_status").val(),
            type: $("#s_type").val(),
            month: $("#s_month").val()
        };
        return queryParams;
    }

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/produceOrder/listProduceOrder";
        title = "生产单管理";
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
                    {title: '店铺名', field: 'shopName', width: 120},
                    {title: '批号', field: 'batchNumber', width: 140},
                    {title: '状态', field: 'statusName', width: 50},
                    {
                        title: '成本核算', field: 'costStatus', width: 50, formatter: function (value, row, index) {
                            if (value == 1) {
                                return '已核算';
                            } else if (value == 0) {
                                return '未核算';
                            }
                        }
                    },
                    {
                        title: '生产类型', field: 'type', width: 80, formatter: function (value, row, index) {
                            if (value == 1) {
                                return '手工生产单';
                            } else if (value == 2) {
                                return '工厂生产单';
                            }
                        }
                    },
                    {
                        title: '图片', field: 'imgUrl', width: 120,
                        formatter: function (value, rowData, rowIndex) {
                            var res = "";
                            if (value != null && value != '') {
                                res += '<a href="javascript:;" onclick="showImg(' + value + ')" ><img  src="' + value + '?x-oss-process=image/resize,m_fill,h_66,w_66"  style="width:66px; height:66px;"/></a> '
                            } else {
                                res += '暂无图片'
                            }
                            return res;
                        }
                    },
                    {
                        title: '布料成本', field: 'fabricCost', width: 66,
                        formatter: function (value, row, rowIndex) {
                            if (isEmpty(value)) {
                                return '<input class="easyui-numberbox " min="0.01" precision="2" onchange="saveFabricCost(this,' + row.id + ')">';
                            } else {
                                return '<input class="easyui-numberbox" min="0.01" precision="2" value="' + value + '" onchange="saveFabricCost(this,' + row.id + ')">';
                            }
                        }
                    },
                    {
                        title: '辅料成本', field: 'auxiliaryMaterialCost', width: 66,
                        formatter: function (value, row, rowIndex) {
                            if (isEmpty(value)) {
                                return '<input class="easyui-numberbox " min="0" precision="2" onchange="saveAuxiliaryMaterialCost(this,' + row.id + ')">';
                            } else {
                                return '<input class="easyui-numberbox" min="0" precision="2" value="' + value + '" onchange="saveAuxiliaryMaterialCost(this,' + row.id + ')">';
                            }
                        }
                    },
                    {
                        title: '成本备注', field: 'costRemark', width: 288,
                        formatter: function (value, row, rowIndex) {
                            if (isEmpty(value)) {
                                return '<input class="easyui-textbox" style="width:100%"  onchange="saveProduceOrderCostRemark(this,' + row.id + ')">';
                            } else {
                                return '<input class="easyui-textbox" style="width:100%" value="' + value + '" onchange="saveProduceOrderCostRemark(this,' + row.id + ')">';
                            }
                        }
                    },
                    {title: '生产数量', field: 'productionQuantityTotal', width: 66},
                    {title: '创建时间', field: 'createTime', width: 180},
                    {title: '修改时间', field: 'updateTime', width: 180},
                    {title: '生产完成时间', field: 'completionTime', width: 180},
                    {
                        title: '操作', field: 'deal', width: 200, formatter: function (value, row, index) {
                            var content = '<a href="javascript:void(0)" onclick="exportProduceOrderShopSkuById(' + row.id + ')" class="easyui-linkbutton" >导出店铺sku</a>';
                            if (row.status == 1) {
                                content += '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="showImportProduceOrderShopSkuById(' + row.id + ')" class="easyui-linkbutton" >导入店铺sku</a>';
                            }
                            return content;
                        }
                    },

                    {title: '店铺父sku', field: 'shopParentSkus', width: 150},
                    {title: '备注', field: 'remark', width: 180}
                ]],
                toolbar: [{
                    id: 'btnView',
                    text: '查看',
                    iconCls: 'icon-search',
                    handler: function () {
                        showViewDialog();//实现查看记录详细信息的方法
                    }
                }, '-', {
                    id: 'btnAdd',
                    text: '添加',
                    iconCls: 'icon-add',
                    handler: function () {
                        showAddDialog();//实现查看记录详细信息的方法
                    }
                }, '-', {
                    id: 'btnEdit',
                    text: '修改',
                    iconCls: 'icon-edit',
                    handler: function () {
                        showEditDialog();//实现修改记录的方法
                    }
                }, '-', {
                    id: 'btnProduceOrderShopSku',
                    text: '生产单店铺sku管理',
                    iconCls: 'icon-edit',
                    handler: function () {
                        showProduceOrderShopSkuDialog();
                    }
                }, '-', {
                    id: 'btnFinishedProduction',
                    text: '生产完毕',
                    iconCls: 'icon-edit',
                    handler: function () {
                        finishedProduction();
                    }
                }, '-', {
                    id: 'btnDelete',
                    text: '作废',
                    iconCls: 'icon-remove',
                    handler: function () {
                        cancelProduceOrder();//实现直接删除数据的方法
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
                onDblClickRow:

                    function (rowIndex, rowData) {
                        $(dg).datagrid('uncheckAll');
                        $(dg).datagrid('checkRow', rowIndex);
                        showViewDialog();
                    }
            }
        )
        $(dg).datagrid('clearSelections');
    }

    function finishedProduction() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            //添加二次确认
            $.messager.confirm('提示', '确认要设置店铺[' + rows[0].shopName + '],批号[' + rows[0].batchNumber + ']的生产单为生产完毕吗？', function (r) {
                if (r) {
                    finishedProductionById(rows[0].id);
                }
            });
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function finishedProductionById(id) {
        $.post('${pageContext.request.contextPath }/produceOrder/finishedProduction', {id: id}, function (data) {
            if (data.code == '200') {
                bindData();
            } else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function showAddDialog() {
        $('#dlg').dialog('open').dialog('setTitle', '添加');
        $('#frm').form('clear');
        $(".view_status").hide();
        $("#btn_save").show();
        $(".view_hide").hide();
    }

    function showViewDialog() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $('#dlg').dialog('open').dialog('setTitle', '查看');
            $('#frm').form('load', rows[0]);
            $("#btn_save").hide();
            $(".view_status").show();
            $(".view_hide").show();
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function showEditDialog() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $('#dlg').dialog('open').dialog('setTitle', '修改');
            $('#frm').form('load', rows[0]);
            $(".view_status").show();
            $("#btn_save").show();
            $(".view_hide").hide();
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function closeDialog() {
        $('#dlg').dialog('close');
    }

    function save() {
        var shopId = $("div#dlg input[name='shopId']").val();
        if (shopId == '') {
            $.messager.alert("提示", '请选择店铺');
            return;
        }
        $('#frm').form('submit', {
            url: '${pageContext.request.contextPath }/produceOrder/saveProduceOrder',
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

    function cancelProduceOrder() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $.messager.confirm('提示', '确认废除店铺[' + rows[0].shopName + '],批号[' + rows[0].batchNumber + ']的生产单吗？', function (r) {
                if (r) {
                    $.post('${pageContext.request.contextPath }/produceOrder/cancelProduceOrder', {id: rows[0].id}, function (data) {
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

    function showProduceOrderShopSkuDialog() {
        var rows = $('#dg').datagrid('getSelections');
        if (!rows || rows.length != 1) {
            $.messager.alert("提示", "请选择一条记录.");
            return;
        }
        $('#dlgProduceOrderShopSku').dialog('open').dialog('setTitle', '生产单店铺sku管理');
        $('#frmProduceOrderShopSku').form('load', rows[0]);
        bindProduceOrderShopSkuData();
    }

    function bindProduceOrderShopSkuData() {
        dg = '#dgProduceOrderShopSku';
        url = "${pageContext.request.contextPath }/produceOrderShopSku/listProduceOrderShopSku";
        title = "生产单店铺sku管理";
        queryParams = {produceOrderId: $('#dg').datagrid('getSelections')[0].id};
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
            idField: 'id',
            queryParams: queryParams,  //异步查询的参数
            columns: [[
                {field: 'ck', checkbox: true},   //选择
                {title: '店铺名', field: 'shopName', width: 120},
                {title: '产品sku', field: 'sku', width: 140},
                {title: '店铺sku', field: 'shopSku', width: 140},
                {
                    title: '生产数量', field: 'productionQuantity', width: 66,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-numberbox " min="1" precision="0" onchange="saveProductionQuantity(this,' + row.id + ')">';
                        } else {
                            return '<input class="easyui-numberbox" min="1" precision="0" value="' + value + '" onchange="saveProductionQuantity(this,' + row.id + ')">';
                        }
                    }
                },
                {title: '入库数量', field: 'warehousingQuantity', width: 66},
                {
                    title: '预入库数量', field: 'preWarehousingQuantity', width: 66,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-numberbox " min="1" precision="0" onchange="savePreWarehousingQuantity(this,' + row.id + ')">';
                        } else {
                            return '<input class="easyui-numberbox" min="1" precision="0" value="' + value + '" onchange="savePreWarehousingQuantity(this,' + row.id + ')">';
                        }
                    }
                },
                {
                    title: '打印标签', field: 'shopSkuId', width: 80,
                    formatter: function (value, row, index) {
                        return '<a href="javascript:;" onclick="showPrintProductLabel(\'' + row.sku + '\',' + row.preWarehousingQuantity + ')" title="打印产品标签">打印标签</a>';
                    }
                },

                {title: '创建时间', field: 'createTime', width: 180},
                {title: '修改时间', field: 'updateTime', width: 180},
                {title: '备注', field: 'remark', width: 180}
            ]],
            toolbar: [{
                id: 'btnProduceOrderShopSkuView',
                text: '查看',
                iconCls: 'icon-search',
                handler: function () {
                    showViewProduceOrderShopSkuDialog();//实现查看记录详细信息的方法
                }
            }, '-', {
                id: 'btnAdd',
                text: '添加',
                iconCls: 'icon-add',
                handler: function () {
                    showAddProduceOrderShopSkuDialog();//实现查看记录详细信息的方法
                }
            }, '-', {
                id: 'btnEdit',
                text: '修改',
                iconCls: 'icon-edit',
                handler: function () {
                    showEditProduceOrderShopSkuDialog();//实现修改记录的方法
                }
            }, '-', {
                id: 'btnDelete',
                text: '删除',
                iconCls: 'icon-remove',
                handler: function () {
                    deleteProduceOrderShopSku();//实现直接删除数据的方法
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
                showViewProduceOrderShopSkuDialog();
            }
        })
        $(dg).datagrid('clearSelections');
    }

    function showAddProduceOrderShopSkuDialog() {
        $('#dlgProduceOrderShopSkuInfo').dialog('open').dialog('setTitle', '添加生产单店铺sku');
        $('#frmProduceOrderShopSkuInfo').form('clear');
        $("#btn_save_produceOrderShopSku").show();
        $(".view_hide_produceOrderShopSku").hide();
        $("div#dlgProduceOrderShopSkuInfo input[name='produceOrderId']").val($('#dg').datagrid('getSelections')[0].id);
    }

    function showEditProduceOrderShopSkuDialog() {
        var rows = $('#dgProduceOrderShopSku').datagrid('getSelections');
        if (!rows || rows.length != 1) {
            $.messager.alert("提示", "请选择一条记录.");
            return;
        }
        $('#dlgProduceOrderShopSkuInfo').dialog('open').dialog('setTitle', '编辑生产单店铺sku');
        $('#frmProduceOrderShopSkuInfo').form('load', rows[0]);
        $("#btn_save_produceOrderShopSku").show();
        $(".view_hide_produceOrderShopSku").hide();
    }

    function showViewProduceOrderShopSkuDialog() {
        var rows = $('#dgProduceOrderShopSku').datagrid('getSelections');
        if (!rows || rows.length != 1) {
            $.messager.alert("提示", "请选择一条记录.");
            return;
        }
        $('#dlgProduceOrderShopSkuInfo').dialog('open').dialog('setTitle', '查看生产单店铺sku');
        $('#frmProduceOrderShopSkuInfo').form('load', rows[0]);
        $("#btn_save_produceOrderShopSku").hide();
        $(".view_hide_produceOrderShopSku").show();
    }

    function saveProduceOrderShopSku() {
        var shopSku = $("div#dlgProduceOrderShopSkuInfo input[name='shopSku']").val();
        if (shopSku == '') {
            $.messager.alert("提示", '请填写店铺sku');
            return;
        }
        var productionQuantity = $("div#dlgProduceOrderShopSkuInfo input[name='productionQuantity']").val();
        if (productionQuantity == '') {
            $.messager.alert("提示", '请填写生产数量');
            return;
        }
        $('#frmProduceOrderShopSkuInfo').form('submit', {
            url: '${pageContext.request.contextPath }/produceOrderShopSku/saveProduceOrderShopSku',
            onSubmit: function () {
                var validate = $(this).form('validate');
                return validate;
            },
            success: function (data) {
                res = eval('(' + data + ')');
                if (res.code == '200') {
                    closeProduceOrderShopSkuInfoDialog();
                    bindProduceOrderShopSkuData();
                } else {
                    $.messager.alert("提示", res.message);
                }
            }
        });
    }

    function deleteProduceOrderShopSku() {
        var rows = $('#dgProduceOrderShopSku').datagrid('getSelections');
        if (rows && rows.length == 1) {
            $.messager.confirm('提示', '确认废除店铺[' + rows[0].shopName + '],店铺sku[' + rows[0].shopSku + ']的生产单店铺sku吗？', function (r) {
                if (r) {
                    $.post('${pageContext.request.contextPath }/produceOrderShopSku/deleteProduceOrderShopSku', {id: rows[0].id}, function (data) {
                        if (data.code == '200') {
                            bindProduceOrderShopSkuData();
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

    function closeProduceOrderShopSkuInfoDialog() {
        $('#dlgProduceOrderShopSkuInfo').dialog('close')
    }

    function showImportProduceOrderShopSku() {
        var produceOrderId = $('#dg').datagrid('getSelections')[0].id;
        showImportProduceOrderShopSkuById(produceOrderId);
    }

    function showImportProduceOrderShopSkuById(produceOrderId) {
        var iframeImportProduceOrderShopSku = document.getElementById('iframeImportProduceOrderShopSku');
        iframeImportProduceOrderShopSku.src = "${pageContext.request.contextPath }/produceOrderShopSku/importProduceOrderShopSkuPage?produceOrderId=" + produceOrderId;
        $('#dlgImportProduceOrderShopSku').dialog('open').dialog('setTitle', '导入生产单店铺sku');
    }

    function closeImportProduceOrderShopSkuDialog() {
        $('#dlgImportProduceOrderShopSku').dialog('close');
    }

    function exportProduceOrderShopSku(produceOrderId) {
        exportProduceOrderShopSkuById(produceOrderId);
    }

    function exportProduceOrderShopSkuById(produceOrderId) {
        var url = "${pageContext.request.contextPath }/produceOrderShopSku/exportProduceOrderShopSku?produceOrderId=" + produceOrderId;
        window.open(url);
    }

    function showDialogImport(importType) {
        var importTitle;
        switch (importType) {
            case 'produceOrder':
                importTitle = "导入生产单";
                importTemplateUrl = "${pageContext.request.contextPath }/static/template/produceOrder/produceOrderImportTemplate.xlsx";
                importUrl = '${pageContext.request.contextPath }/produceOrder/importProduceOrder';
                break;
        }
        if (isEmpty(importTitle)) {
            $.messager.alert("提示", "请选择正确的导入类型.");
            return;
        }
        $("#importTitle").text(importTitle);
        $("#importTemplate").attr("href", importTemplateUrl);
        $('#dlgImport').dialog('open').dialog('setTitle', importTitle);
    }

    function closeDialogImport() {
        $('#dlgImport').dialog('close');
    }

    function doImport() {
        var importFile = $("#importFile").val();
        if (importFile == '') {
            $.messager.alert("提示", "请选择导入的文件");
            return;
        }
        var dom = document.getElementById("importFile");
        var fileSize = dom.files[0].size;
        if (fileSize > 30000000) {
            $.messager.alert("提示", "上传文件过大,请上传小于30M的文件");
            return false;
        }
        if (isEmpty(importUrl)) {
            $.messager.alert("提示", "请选择正确的导入类型");
            return;
        }
        $('#frmImport').form('submit', {
            url: importUrl,
            onSubmit: function () {
                var isValid = $(this).form('validate');
                if (isValid) {
                    showCover();
                }
                return isValid;
            },
            success: function (data) {
                hideCover();
                res = eval("(" + data + ")")
                if (res.code == '200') {
                    $.messager.alert("提示", "上传成功");
                    bindData();
                } else {
                    $.messager.alert("提示", res.message);
                }
            }
        });
    }

    function saveProductionQuantity(input, id) {
        var productionQuantity = $(input).val();
        if (isEmpty(productionQuantity)) {
            $.messager.alert("提示", "生产数量不能为空");
            return;
        }
        var r = /^[1-9][0-9]*$/;　　//正整数
        if (!r.test(productionQuantity)) {
            $.messager.alert("提示", "生产数量必须为大于等于1的数字.");
            $(input).focus()
            return;
        }
        $.post('${pageContext.request.contextPath }/produceOrderShopSku/saveProductionQuantity', {
            productionQuantity: productionQuantity,
            id: id
        }, function (data) {
            if (data.code == '200') {
                //保存成功
                $.messager.alert("提示", data.message);
            } else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function savePreWarehousingQuantity(input, id) {
        var preWarehousingQuantity = $(input).val();
        if (isEmpty(preWarehousingQuantity)) {
            $.messager.alert("提示", "预入库不能为空");
            return;
        }
        var r = /^[1-9][0-9]*$/;　　//正整数
        if (!r.test(preWarehousingQuantity)) {
            $.messager.alert("提示", "生产数量必须为大于等于1的数字.");
            $(input).focus()
            return;
        }
        $.post('${pageContext.request.contextPath }/produceOrderShopSku/savePreWarehousingQuantity', {
            preWarehousingQuantity: preWarehousingQuantity,
            id: id
        }, function (data) {
            if (data.code == '200') {
                //保存成功
                $.messager.alert("提示", data.message);
            } else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function showPrintProductLabel(sku, preWarehousingQuantity) {
        if (isEmpty(sku)) {
            window.open("${pageContext.request.contextPath }/produceOrder/printProductLabel");
        } else {
            if (isEmpty(preWarehousingQuantity)) {
                window.open("${pageContext.request.contextPath }/produceOrder/printProductLabel?sku=" + sku);
            } else {
                window.open("${pageContext.request.contextPath }/produceOrder/printProductLabel?sku=" + sku + "&preWarehousingQuantity=" + preWarehousingQuantity);
            }
        }
    }

    function generationCost() {
        var month = $("#s_month").val();
        if (isEmpty(month)) {
            $.messager.alert("提示", "请选择月份");
            return;
        }
        $.post('${pageContext.request.contextPath }/produceOrder/generationCost', {
            month: month
        }, function (data) {
            if (data.code == '200') {
                //保存成功
                $.messager.alert("提示", data.message);
            } else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function saveProduceOrderCostRemark(input, id) {
        var costRemark = $(input).val();
        $.post('${pageContext.request.contextPath }/produceOrder/saveProduceOrderCostRemark', {
            id: id,
            remark: costRemark
        }, function (data) {
            if (data.code == '200') {
                bindData();
            } else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function saveFabricCost(input, id) {
        var fabricCost = $(input).val();
        $.post('${pageContext.request.contextPath }/produceOrder/saveFabricCost', {
            id: id,
            fabricCost: fabricCost
        }, function (data) {
            if (data.code == '200') {
                bindData();
            } else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function saveAuxiliaryMaterialCost(input, id) {
        var auxiliaryMaterialCost = $(input).val();
        $.post('${pageContext.request.contextPath }/produceOrder/saveAuxiliaryMaterialCost', {
            id: id,
            auxiliaryMaterialCost: auxiliaryMaterialCost
        }, function (data) {
            if (data.code == '200') {
                bindData();
            } else {
                $.messager.alert("提示", data.message);
            }
        });
    }
</script>
</html>
