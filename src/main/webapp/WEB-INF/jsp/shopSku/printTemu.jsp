<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2019/8/12
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.5.4/jquery.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.5.4/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.5.4/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/common/common.js?t=20201028"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/common/JsBarcode.all.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/common/printArea.js"></script>
    <title>打印标签</title>
    <style>
        .printBack {
            width: 6.5cm;
            height: 3.18cm;
            overflow-y: hidden;
            overflow-x: hidden;
            padding: 5px;
            border: 1px solid;
        }

        .barcode {
            text-align: center;
        }

        .barcode img {
            height: 2.2cm;
            width: 6.1cm;
            overflow-y: hidden;
        }
        .topClass{
            font-size: 12px;
            font-weight: bold;
            height: 0.5cm;
            overflow-y: hidden;
            display: flex;
            justify-content: space-between;
        }
        .skcItemNumberClass {
            font-size: 12px;
            font-weight: bold;
        }
        .salesAttributes1Class {
            font-size: 10px;
            font-weight: bold;
        }
        .salesAttributes2Class {
            font-size: 12px;
            font-weight: bold;
        }

        .newMade {
            font-size: 12px;
            font-weight: bold;
            height: 0.5cm;
            overflow-y: hidden;
            display: flex;
            justify-content: space-between;
        }
        .skuClass {
            font-size: 12px;
            font-weight: bold;
            width: 60%;
        }
        .made {
            font-size: 12px;
            font-weight: bold;
            width: 40%;
        }
        .print {
            width: 6.5cm;
            text-align: center;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel" id="search">
    店铺sku：
    <input class="easyui-validatebox textbox" id="s_shopSku">
    条码编码：
    <input class="easyui-validatebox textbox" id="s_fnsku">
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
    <br>
    数量：
    <input class="easyui-validatebox textbox" id="quantity" readonly="readonly">
</div>

<div id="div_img">
    <div id="div_img_show">
        <img id="sku_img" style="width:300px; height:300px;"></div>
    <div id="div_img_info">
        暂无图片
    </div>
</div>
<div id="printInfo">
    <div class="printBack">
        <div class="topClass">
            <div class="skcItemNumberClass">
            </div>
            <div class="salesAttributes1Class">
            </div>
            <div class="salesAttributes2Class">
            </div>
        </div>
        <div class="barcode">
            <img id="barcode"/>
        </div>
        <div class="newMade">
            <div class="skuClass">
            </div>
            <div class="made">
            </div>
        </div>
    </div>
</div>
<div class="print" id="print">
    <button onclick="preview('printInfo');">打印标签</button>
</div>
<div class="statusInfo">
    sku已停用，不能打印标签
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        bindFirst();
        hidePrint();
    });

    function showPrint(status) {
        if (status == 0) {
            $("#print").hide();
            $("#printInfo").hide();
            $(".statusInfo").show();
        } else {
            $("#printInfo").show();
            $("#print").show();
            $(".statusInfo").hide();
        }
    }

    function hidePrint() {
        $("#printInfo").hide();
        $("#print").hide();
        $(".statusInfo").hide();
        $("#div_img").hide();
    }

    function bindFirst() {
        var shopSku = getQueryVariable('shopSku');
        if (!isEmpty(shopSku)) {
            $("#s_shopSku").val(decodeURI(shopSku));
            bindData();
        }
        var quantity = getQueryVariable('quantity');
        if (!isEmpty(quantity)) {
            $("#quantity").val(decodeURI(quantity));
        }
    }
    function bindData() {
        hidePrint();
        var shopSku = $("#s_shopSku").val();
        var barcode = $("#s_barcode").val();
        if (isEmpty(shopSku) && isEmpty(barcode)) {
            alert('请填写店铺sku或者barcode');
            return;
        }
        $.post('${pageContext.request.contextPath }/shopSku/getPrintShopSku', {
            shopSku: shopSku,
            barcode: barcode
        }, function (data) {
            if (data.code == '200') {
                if (isEmpty(data.data)) {
                    alert('sku信息不存在，请重新查询');
                    return;
                }
                createcode(data.data.barcode);
                $(".skcItemNumberClass").text(data.data.tskcItemNumber);
                $(".salesAttributes1Class").text(data.data.salesAttributes1);
                $(".salesAttributes2Class").text(data.data.salesAttributes2);
                globalFnsku = data.data.fnsku;
                $(".skuClass").text(data.data.tsku);
                $(".made").text("Made In China");
                showImg(data.data.imgUrl);
                $("#sku_img").attr("src", data.data.imgUrl);
                showPrint(data.data.status);
            } else {
                showImg("");
                alert(data.message);
            }
        });
    }

    function showImg(imgUrl) {
        if (isEmpty(imgUrl)) {
            $("#div_img").show();
            $("#div_img_show").hide();
            $("#div_img_info").show();
            $("#sku_img").removeAttr("src");
        } else {
            $("#div_img").show();
            $("#div_img_show").show();
            $("#div_img_info").hide();
            $("#sku_img").attr("src", imgUrl + "?x-oss-process=image/resize,m_fill,h_300,w_300");
        }
    }

    function createcode(str) {
        var barcode = document.getElementById('barcode'),
            options = {
                format: "CODE128",
                displayValue: false,
                fontSize: 20,
                font: "Microsoft YaHei",
                height: 50,
                margin: 4,
            };
        JsBarcode(barcode, str, options); //原生
    }

    function preview3(id) {
        $('#' + id).printArea();
    }

    function preview2(id) {

        var sprnhtml = $('#' + id).html();   //获取区域内容
        var selfhtml = $('body').html(); //获取当前页的html
        $('body').html(sprnhtml);
        window.print();
        $('body').html(selfhtml);
    }

    function preview(id) {
        //保存打印记录
        saveStockRecordItemPrintRecord();
        $("#search").hide();
        $("#div_img").hide();
        $("#print").hide();
        window.print();
        $("#search").show();
        $("#div_img").show();
        $("#print").show();
    }


    function saveStockRecordItemPrintRecord() {
        var stockRecordItemId = getQueryVariable('stockRecordItemId');
        if (!isEmpty(stockRecordItemId)) {
            $.post('${pageContext.request.contextPath }/stockRecordItemPrintRecord/saveStockRecordItemPrintRecord', {
                stockRecordItemId: stockRecordItemId
            }, function (data) {
                if (data.code == '200') {

                } else {
                    
                }
            });
        }
    }

</script>
</html>
