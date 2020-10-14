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
    <%--<link rel="stylesheet"
          href="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.5.4/themes/default/easyui.css"
          type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.5.4/themes/icon.css"
          type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.5.4/demo/demo.css"
          type="text/css">--%>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.5.4/jquery.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.5.4/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.5.4/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/common/common.js?t=20200929"></script>
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
            padding-left: 1px;
            padding-right: 4px;
        }

        .barcode {
            text-align: center;
        }

        .barcode img {
            height: 1.6cm;
            width: 6.1cm;
            overflow-y: hidden;
        }

        .title {
            font-size: 12px;
            height: 0.8cm;
            overflow-y: hidden;
            padding-top: 0.03cm;
        }

        .newMade {
            font-size: 12px;
            font-weight: bold;
            height: 0.35cm;
            overflow-y: hidden;
            display: flex;
            justify-content: space-between;
        }

        .new {
            font-size: 12px;
            font-weight: bold;
        }
        .colourNumber {
            font-size: 10px;
            font-weight: bold;
        }
        .made {
            font-size: 12px;
            font-weight: bold;
        }

        .skuInfo {
            overflow-y: hidden;
            font-size: 12px;
            font-weight: bold;
            height: 0.4cm;
            padding-top: 0.03cm;
            width: 100%;
            display: inline;
            display: flex;
            justify-content: space-between;
        }

        .sku {
            font-size: 10px;
        }

        .shopParentSku {
            text-align: right;
            font-size: 10px;
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
    FNSKU：
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
        <!-- 产品名条形码 -->
        <div class="barcode">
            <img id="barcode"/>
        </div>
        <div class="title">

        </div>
        <div class="newMade">
            <div class="new">
            </div>
            <div class="colourNumber">
            </div>
            <div class="made">
            </div>
        </div>
        <div class="skuInfo">
            <div class="sku"></div>
            <div class="shopParentSku"></div>
        </div>
    </div>
</div>
<div class="print" id="print">
    <button onclick="preview('printInfo');">打印标签</button>
    <%--
    <button onclick="preview2('printInfo');">打印标签2</button>
    <button onclick="preview3('printInfo');">打印标签3</button>--%>
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
    var globalFnsku;
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
        var quantity=getQueryVariable('quantity');
        if (!isEmpty(quantity)) {
            $("#quantity").val(decodeURI(quantity));
        }
    }

    function getTitle(title) {
        if (isEmpty(title) || title.length < 67) {
            return title;
        }
        var start = title.substr(0, 32);
        var end = title.substr(title.length - 32, 32);
        return start + '...' + end;
    };

    function bindData() {
        hidePrint();
        var shopSku = $("#s_shopSku").val();
        var fnsku = $("#s_fnsku").val();
        if (isEmpty(shopSku) && isEmpty(fnsku)) {
            alert('请填写店铺sku或者FNSKU');
            return;
        }
        $.post('${pageContext.request.contextPath }/shopSku/getPrintShopSku', {
            shopSku: shopSku,
            fnsku: fnsku
        }, function (data) {
            if (data.code == '200') {
                if (isEmpty(data.data)) {
                    alert('sku信息不存在，请重新查询');
                    return;
                }
                createcode(data.data.fnsku);
                $(".title").text(getTitle(data.data.title));
                $(".sku").text(data.data.sku);
                $(".shopParentSku").text(data.data.shopParentSku);
                globalFnsku=data.data.fnsku;
                $(".new").text("New");
                if(!isEmpty(data.data.colourNumber)){
                    $(".colourNumber").text(data.data.colourNumber);
                }
                $(".made").text("MADE IN CHINA");
                showImg(data.data.imgUrl);
                $("#sku_img").attr("src", data.data.imgUrl);
                showPrint(data.data.status);
            }
            else {
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
            $("#sku_img").attr("src", imgUrl+"?x-oss-process=image/resize,m_fill,h_300,w_300");
        }
    }

    function createcode(str) {
        var barcode = document.getElementById('barcode'),
            options = {
                format: "CODE128",
                displayValue: true,
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
        if(isEmpty(globalFnsku)){
            alert('sku信息错误，fnsku不能为空');
            return;
        }
        if(globalFnsku.indexOf("X0") != 0&&globalFnsku.indexOf("B0") != 0) {
            alert('sku信息错误，fnsku必须以X0或B0开头');
            return;
        }
        $("#search").hide();
        $("#div_img").hide();
        $("#print").hide();
        window.print();
        $("#search").show();
        $("#div_img").show();
        $("#print").show();
    }

</script>
</html>
