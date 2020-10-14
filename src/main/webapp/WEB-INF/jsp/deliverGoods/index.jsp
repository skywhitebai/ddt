<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2019/9/9
  Time: 11:46
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
    <title>发货流程管理</title>
    <style type="text/css">
        .main_div {
            margin-top: 10px;
            border: 1px solid gray;
            border-radius: 5px;
            padding: 2px;
        }

        .file_div {
            margin-bottom: 5px;
        }
    </style>
</head>
<body>
<div class="main_div">
    <div class="ftitle">
        <b>生成发货计划表</b>
    </div>
    <form id="frm_deliveryPlan" method="post" novalidate="novalidate" enctype="multipart/form-data">
        <div class="file_div">
            发货单：<input type="file" id="deliveryPlanFile" name="file" accept=".xls,.xlsx"/></div>
        <div style="text-align:left;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" onclick="generateDeliveryPlan()">生成发货计划表</a>
        </div>
    </form>
</div>

<div class="main_div">
    <div class="ftitle">
        <b>生成仓库装箱单</b>
    </div>
    <form id="frm_warehousePackingList" method="post" novalidate="novalidate" enctype="multipart/form-data">
        <div class="file_div">亚马逊发货计划： <input type="file" id="warehousePackingListFile" name="file"
                                              accept=".xls,.xlsx"/></div>
        <div style="text-align:left;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" onclick="generateWarehousePackingList()">生成仓库装箱单</a>
        </div>
    </form>
</div>
<div class="main_div">
    <div class="ftitle">
        <b>生成亚马逊装箱单</b>
    </div>
    <form id="frm_amazonPackingListFile" method="post" novalidate="novalidate" enctype="multipart/form-data">
        <div class="file_div">仓库发货单： <input type="file" id="amazonPackingListFile" name="file" accept=".xls,.xlsx"/>
            箱数：<input class="easyui-numberbox" id="numberOfBoxes" name="numberOfBoxes" min="0" max="20" precision="0"
                      style="width: 50px"></div>
        <div style="text-align:left;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" onclick="generateAmazonPackingList()">生成亚马逊装箱单</a>
        </div>
    </form>
</div>
<div class="main_div">
    <div class="ftitle">
        <b>生成发票</b>
    </div>
    <form id="frm_invoice" method="post" novalidate="novalidate" enctype="multipart/form-data">
        <div class="file_div">
            亚马逊装箱单： <input type="file" id="invoiceFile" name="file" accept=".xls,.xlsx"/>
            FBA单号 ：<input class="easyui-textbox" id="fbaNo" name="fbaNo"
                          style="width: 150px">
        </div>
        <input type="hidden" name="type" id="type">
        <div style="text-align:left;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" onclick="generateInvoice('ky')">生成空运发票</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" onclick="generateInvoice('kp')">生成空派发票</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" onclick="generateInvoice('hy')">生成海运发票</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" onclick="generateInvoice('hy2')">生成新的海运发票</a>
        </div>
    </form>
</div>
<div id="cover">
    <div id="coverMsg">
        <img src="${pageContext.request.contextPath }/static/img/loading.gif" width="100px">
    </div>
</div>
</body>
<script type="text/javascript">
    /*生成仓库装箱单*/
    function generateDeliveryPlan() {
        var file = $("#deliveryPlanFile").val();
        if (file == '') {
            $.messager.alert("提示", "请选择发货单");
            return;
        }
        var dom = document.getElementById("deliveryPlanFile");
        var fileSize = dom.files[0].size;
        if (fileSize > 30000000) {
            $.messager.alert("提示", "上传文件过大,请上传小于30M的文件");
            return false;
        }
        $('#frm_deliveryPlan').form('submit', {
            url: '${pageContext.request.contextPath }/deliverGoods/generateDeliveryPlan',
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
                    $.messager.alert("提示", "生成成功");
                }
                else {
                    $.messager.alert("提示", res.message);
                }
                //关闭遮罩
            }
        });
    }

    /*生成仓库装箱单*/
    function generateWarehousePackingList() {
        var file = $("#warehousePackingListFile").val();
        if (file == '') {
            $.messager.alert("提示", "请选择亚马逊发货计划");
            return;
        }
        var dom = document.getElementById("warehousePackingListFile");
        var fileSize = dom.files[0].size;
        if (fileSize > 30000000) {
            $.messager.alert("提示", "上传文件过大,请上传小于30M的文件");
            return false;
        }
        //弹出遮罩
        $('#frm_warehousePackingList').form('submit', {
            url: '${pageContext.request.contextPath }/deliverGoods/generateWarehousePackingList',
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
                    $.messager.alert("提示", "生成成功");
                }
                else {
                    $.messager.alert("提示", res.message);
                }
                //关闭遮罩
            }
        });
    }

    /*生成亚马逊装箱单*/
    function generateAmazonPackingList() {
        var file = $("#amazonPackingListFile").val();
        if (file == '') {
            $.messager.alert("提示", "请选择仓库发货单");
            return;
        }
        var dom = document.getElementById("amazonPackingListFile");
        var fileSize = dom.files[0].size;
        if (fileSize > 30000000) {
            $.messager.alert("提示", "上传文件过大,请上传小于30M的文件");
            return false;
        }
        var numberOfBoxes = $("#numberOfBoxes").val();
        if (isEmpty(numberOfBoxes)) {
            $.messager.alert("提示", "请填写装箱箱数");
            return;
        }
        $('#frm_amazonPackingListFile').form('submit', {
            url: '${pageContext.request.contextPath }/deliverGoods/generateAmazonPackingList',
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
                    $.messager.alert("提示", "生成成功");
                }
                else {
                    $.messager.alert("提示", res.message);
                }
                //关闭遮罩
            }
        });
    }

    /*生成发票*/
    function generateInvoice(type) {
        $("#type").val(type);
        var file = $("#invoiceFile").val();
        if (file == '') {
            $.messager.alert("提示", "请选择亚马逊装箱单");
            return;
        }
        var fbaNo = $("#fbaNo").val();
        if (isEmpty(fbaNo)) {
            $.messager.alert("提示", "请填写FBA单号");
            return;
        }
        var dom = document.getElementById("invoiceFile");
        var fileSize = dom.files[0].size;
        if (fileSize > 30000000) {
            $.messager.alert("提示", "上传文件过大,请上传小于30M的文件");
            return false;
        }
        $('#frm_invoice').form('submit', {
            url: '${pageContext.request.contextPath }/deliverGoods/generateInvoice',
            onSubmit: function () {
                var isValid = $(this).form('validate');
                if (isValid) {
                    $.messager.alert("提示", "发票生成中，请等待10-20秒");
                    setTimeout(function () {
                        $(".messager-body").window('close');
                    }, 5000);
                }
                return isValid;
            },
            success: function (data) {
                res = eval("(" + data + ")")
                if (res.code == '200') {
                    $(".messager-body").window('close');
                    $.messager.alert("提示", "生成成功");
                }
                else {
                    $(".messager-body").window('close');
                    $.messager.alert("提示", res.message);
                }
            }
        });
    }
</script>
</html>
