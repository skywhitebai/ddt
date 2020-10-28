<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2019/8/30
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath }/static/js/jquery-easyui-1.7.0/themes/default/easyui.css"
          type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/js/jquery-easyui-1.7.0/themes/icon.css"
          type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/js/jquery-easyui-1.7.0/demo/demo.css"
          type="text/css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/jquery-easyui-1.7.0/jquery.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/jquery-easyui-1.7.0/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/jquery-easyui-1.7.0/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/common/common.js?t=20201028"></script>
    <title>销售信息</title>
</head>
<body>
<!--只显示用户有的店铺-->
店铺：
<select id="s_shopId" style="width:150px;">
</select>
店铺sku：
<input class="easyui-validatebox textbox" id="s_shopSku">
店铺父sku：
<input class="easyui-validatebox textbox" id="s_shopParentSku">
产品编码：
<input class="easyui-validatebox textbox" id="s_productCode">
产品sku：
<input class="easyui-validatebox textbox" id="s_sku">
产品名称：
<input class="easyui-validatebox textbox" id="s_productName">
创建订单时间
<input class="easyui-datebox" id="s_purchaseDateStart">
-
<input class="easyui-datebox" id="s_purchaseDateEnd">
<form id="ff">
    <input class="easyui-radiobutton" name="searchType" value="shopSku" label="店铺sku"
           data-options="labelPosition:'after',labelWidth:80,checked:true,onChange:bindData">
    <input class="easyui-radiobutton" name="searchType" value="shopParentSku" label="店铺父sku"
           data-options="labelPosition:'after',labelWidth:100,onChange:bindData">
</form>
<a href="javascript:void(0)" onclick="last30()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
>最近30天</a>
<a href="javascript:void(0)" onclick="last60()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
>最近60天</a>
<a href="javascript:void(0)" onclick="last90()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
>最近90天</a>
<a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
>查 询</a>
<a href="javascript:void(0)" onclick="showChart()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
>查询统计图</a>
<table id="dg" style="width: 100%; height: auto">
</table>
<%--<a href="javascript:void(0)" onclick="exportShopSku()" class="easyui-linkbutton"
   data-options="iconCls:'icon-search'"
   style="">导出信息</a>--%>
</body>
<script type="text/javascript">
    bindShop();

    function bindShop() {
        $('#s_shopId').combobox({
            valueField: 'shopId',
            textField: 'shopName',
            url: "${pageContext.request.contextPath }/shop/userShopComboboxlist",//获取数据
        });
    }

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/shopSku/salesCount";
        title = "订单管理";
        var purchaseDateStart = $("#s_purchaseDateStart").val();
        var purchaseDateEnd = $("#s_purchaseDateEnd").val();
        if (isEmpty(purchaseDateStart) || isEmpty(purchaseDateEnd)) {
            $.messager.alert("提示", "请选择创建订单时间.");
            return;
        }
        var columns = [];
        var res = setColunms(columns, purchaseDateStart, purchaseDateEnd);
        if (!res) {
            return;
        }
        queryParams = {
            shopId: $('#s_shopId').combobox('getValue'),
            productCode: $("#s_productCode").val(),
            shopSku: $("#s_shopSku").val(),
            sku: $("#s_sku").val(),
            productName: $("#s_productName").val(),
            shopParentSku: $("#s_shopParentSku").val(),
            purchaseDateStart: purchaseDateStart,
            purchaseDateEnd: purchaseDateEnd,
            searchType:$("input[name='searchType']:checked").val()
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
            columns: columns,
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
    }

    function setColunms(columns, purchaseDateStart, purchaseDateEnd) {
        var purchaseDateStartDate = new Date(purchaseDateStart);
        var purchaseDateEndDate = new Date(purchaseDateEnd);
        if (purchaseDateStartDate > purchaseDateEndDate) {
            $.messager.alert("提示", "创建订单开始时间必须小于等于结束时间");
            return false;
        }
        if (dayDiff(purchaseDateStartDate, purchaseDateEndDate) > 90) {
            $.messager.alert("提示", "创建订单开始时间、结束时间相差不能超过90天");
            return false;
        }
        var heads = [];
        heads.push({title: '店铺名', field: 'shopName', width: 120});
        heads.push({title: '店铺sku', field: 'shopSku', width: 120});
        heads.push({title: '店铺父sku', field: 'shopParentSku', width: 120});
        heads.push({title: '产品编码', field: 'productCode', width: 120});
        heads.push({title: '产品名', field: 'productName', width: 200});
        while (purchaseDateStartDate <= purchaseDateEndDate) {
            var dateStr = dateToString(purchaseDateStartDate);
            heads.push({title: dateStr, field: 'day' + dateStr, width: 100});
            purchaseDateStartDate = new Date(purchaseDateStartDate.setDate(purchaseDateStartDate.getDate() + 1));
        }
        heads.push({title: '合计', field: 'total', width: 100});
        columns.push(heads);
        return true;
    }

    function last30() {
        var startDate = new Date(new Date().setDate(new Date().getDate() - 31));
        var endDate = new Date(new Date().setDate(new Date().getDate() - 1));
        $("#s_purchaseDateStart").datebox('setValue', dateToString(startDate));
        $("#s_purchaseDateEnd").datebox('setValue', dateToString(endDate));
        bindData();
    }

    function last60() {
        var startDate = new Date(new Date().setDate(new Date().getDate() - 61));
        var endDate = new Date(new Date().setDate(new Date().getDate() - 1));
        $("#s_purchaseDateStart").datebox('setValue', dateToString(startDate));
        $("#s_purchaseDateEnd").datebox('setValue', dateToString(endDate));
        bindData();
    }

    function last90() {
        var startDate = new Date(new Date().setDate(new Date().getDate() - 91));
        var endDate = new Date(new Date().setDate(new Date().getDate() - 1));
        $("#s_purchaseDateStart").datebox('setValue', dateToString(startDate));
        $("#s_purchaseDateEnd").datebox('setValue', dateToString(endDate));
        bindData();
    }

    function showChart() {
        var query = "shopParentSku=" + $("#s_shopParentSku").val() + "&purchaseDateStart=" + $("#s_purchaseDateStart").val() + "&purchaseDateEnd=" + $("#s_purchaseDateEnd").val();
        window.open("${pageContext.request.contextPath }/shopSku/salesInfoChart?" + query);
    }
</script>
</html>
