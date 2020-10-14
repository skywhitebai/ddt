<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2020/10/10
  Time: 15:36
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
            src="${pageContext.request.contextPath }/static/js/common/common.js?t=20200929"></script>
    <title>工厂生产单管理</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    店铺：
    <select id="s_shopId" style="width:150px;">
    </select>
    工厂生产单id：
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
        url = "${pageContext.request.contextPath }/factoryProductionOrder/listFactoryProductionOrder";
        title = "工厂生产单管理";
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
                {title: '工厂生产单id', field: 'id', width: 88},
                {title: '店铺名', field: 'shopName', width: 120},
                {title: '标题', field: 'title', width: 130},
                {
                    title: '状态', field: 'status', width: 130,
                    formatter: function (value, row, rowIndex) {
                        if (value == 0) {
                            return "待确认";
                        } else if (value == 1) {
                            return "已确认";
                        }
                    }
                },
                {
                    title: '备注', field: 'remark', width: 288,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-textbox " style="width:100%"  onchange="saveFactoryProductionOrderRemark(this,' + row.id + ')">';
                        } else {
                            return '<input class="easyui-textbox" style="width:100%" value="' + value + '" onchange="saveFactoryProductionOrderRemark(this,' + row.id + ')">';
                        }
                    }
                },
                {title: '创建时间', field: 'createTime', width: 180},
                {
                    title: '操作', field: 'stockRecordId', width: 600,
                    formatter: function (value, row, rowIndex) {
                        return '<a href="javascript:void(0)" onclick="downFactoryProductionOrder(' + row.id + ')" class="easyui-linkbutton" >下载工厂生产单</a>';
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
    function saveFactoryProductionOrderRemark(input, id) {
        var remark = $(input).val();
        $.post('${pageContext.request.contextPath }/factoryProductionOrder/saveFactoryProductionOrderRemark', {
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
</script>
</html>
