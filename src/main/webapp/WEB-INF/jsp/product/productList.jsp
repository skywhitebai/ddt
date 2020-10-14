<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2019/6/28
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>产品列表</title>
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
    <style type="text/css">
        .product_img {
            width: 250px;
            height: 250px;
        }

        .product_name {
            font-size: small;
            font-weight: bold;
            overflow: hidden;
            text-overflow: ellipsis; /*将被隐藏的那部分用省略号代替*/
            -webkit-line-clamp: 2; /*默认显示3行*/
            -webkit-box-orient: vertical;
            display: -webkit-box;
        }

        .product_info {
            font-size: small;
            font-weight: bold;
            overflow: hidden;
            text-overflow: ellipsis; /*将被隐藏的那部分用省略号代替*/
            -webkit-line-clamp: 4; /*默认显示3行*/
            -webkit-box-orient: vertical;
            display: -webkit-box;
        }

        .div_product_info {
            width: 255px;
            /*height: 350px;*/
            display: inline-block;
            vertical-align: top;
        }

        .div_product_list {
        }
    </style>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    产品名：
    <input class="easyui-validatebox textbox" id="s_productName">
    货号：
    <input class="easyui-validatebox textbox" id="s_productCode">
    sku：
    <input class="easyui-validatebox textbox" id="s_sku">
    颜色：
    <input class="easyui-validatebox textbox" id="s_colour">
    尺码：
    <input class="easyui-validatebox textbox" id="s_size">
    状态：
    <select class="easyui-combobox" id="s_status" style="width:100px;">
        <option value="">全部</option>
        <option value="1">在售</option>
        <option value="0">停售</option>
    </select>
    <a href="javascript:void(0)" onclick="bindPage(1,200)" class="easyui-linkbutton"
       data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
    <a href="javascript:void(0)" onclick="openThisView()" class="easyui-linkbutton">全屏显示</a>

</div>

<div id="productList" class="div_product_list">

</div>
<div id="pp" class="easyui-pagination" style="background:#efefef;border:1px solid #ccc;">
</div>
<input id="pageNumber" type="hidden" value="200">
</body>
<script type="text/javascript">
    $(document).ready(function () {
        bindPage(1);
    });

    function bindPage(page) {
        rows = $('#pageNumber').val();
        queryParams = {
            productName: $("#s_productName").val(),
            productCode: $("#s_productCode").val(),
            sku: $("#s_sku").val(),
            colour: $("#s_colour").val(),
            size: $("#s_size").val(),
            status: $("#s_status").val(),
            rows: rows,
            page: page
        };

        $.post('${pageContext.request.contextPath }/product/list', queryParams, function (data) {
            bindProduct(data.rows);
            $('#pp').pagination({
                pageList: [10, 20, 50, 100, 200, 500],
                pageSize: rows,
                pageNumber: page,
                total: data.total,
                onSelectPage: function (pageNumber, pageSize) {
                    $('#pageNumber').val(pageSize);
                    bindPage(pageNumber);
                }
            });
        });
    }

    function bindProduct(rows) {
        $('#productList').html("");
        var productTemplate = "<div class=\"div_product_info\">\n" +
            "        <img class=\"product_img\" src=\"{productImg}\">\n" +
            "        <div class=\"product_name\" title=\"{productName}\">{productName}</div>\n" +
            "        <div>{colour}{size}&nbsp;成本价{cost_price}&nbsp;销售价{sales_price}</div>\n" +
            "        <div class=\"product_info\" title=\"{remark}\">{remark}</div>\n" +
            "    </div>";
        var html = "";
        $.each(rows, function (index, value) {
            var productInfo = "<div class=\"div_product_info\">\n";
            if (value.productImgId != null) {
                productInfo = productInfo + "        <img class=\"product_img\" src=\"" + "${pageContext.request.contextPath }/productImg/get?id=" + value.productImgId + "\">\n";
            } else {
                productInfo = productInfo + "        <img class=\"product_img\" src=\"#\">\n";
            }
            productInfo = productInfo + "        <div class=\"product_name\" title=\"" + value.productName + "\">" + value.productName + "</div>\n";
            productInfo = productInfo + "        <div>" + value.colour + value.size + "&nbsp;成本价" + value.costPrice + "&nbsp;销售价" + value.salesPrice + "</div>\n";
            productInfo = productInfo + "        <div class=\"product_info\" title=\"" + value.remark + "\">" + value.remark + "</div>\n" +
                "    </div>";
            html = html + productInfo;
        });
        $('#productList').html(html);
    }

    function openThisView() {
        window.open("${pageContext.request.contextPath }/product/productList")
    }
</script>
</html>
