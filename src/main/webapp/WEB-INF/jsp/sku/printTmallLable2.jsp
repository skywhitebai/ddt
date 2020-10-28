<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2020/4/7
  Time: 10:52
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
    <title>打印天猫标签</title>
    <style>
        .printBack {
            width: 4cm;
            height: 9cm;
            overflow-y: hidden;
            overflow-x: hidden;
            padding: 8px;
        }

        .printBack img {
            text-align: center;
            width: 100%;
            overflow-y: hidden;
        }

        .certificate {
            margin-bottom: 10px;
        }

        .certificateTitle {
            text-align: center;
        }

        .attribute {
            margin-top: 2px;
            width: 100%;
            float: left;
            font-size: 10px;
            justify-content: left;
        }

        .attributeLeft {
            display: inline;
        }

        .attributeRight {
            display: inline;
        }

        .attributeInfo {
            font-size: 14px;
            justify-content: space-between;
            margin: 3px 10px 3px 10px;
        }

        .attributeInfoLeft {
            display: inline;
            float: left;
        }

        .attributeInfoRight {
            display: inline;
            float: right;
        }

        .skuBarcode {
            text-align: center;
        }
    </style>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel" id="search">
    <%--sku：
    <input class="easyui-validatebox textbox" id="s_Sku">
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>--%>
    <button onclick="createTmallLable()">生成标签</button>
</div>
<div id="skuInfo">
    <table>
        <tr>
            <td>品牌：</td>
            <td>
                <input type="text" name="brand" id="brand" value="歌妈珊">
            </td>

            <td>产品sku(必须数字或字母)：</td>
            <td>
                <input type="text" name="sku" id="sku" value="G6081BAIS">
            </td>
        </tr>
        <tr>
            <td>品名：</td>
            <td>
                <input type="text" name="productName" id="productName" value="歌妈珊T恤">
            </td>
            <td>货号：</td>
            <td>
                <input type="text" name="productCode" id="productCode" value="G601">
            </td>
        </tr>
        <tr>
            <td>型号：</td>
            <td>
                <input type="text" name="model" id="model" value="XXL 白">
            </td>
            <td>面料：</td>
            <td>
                <input type="text" name="fabric" id="fabric" value="90%棉，10%氨纶">
            </td>
        </tr>
        <tr>
            <td>等级：</td>
            <td>
                <input type="text" name="grade" id="grade" value="合格品">
            </td>
            <td>执行标准：</td>
            <td>
                <input type="text" name="executiveStandard" id="executiveStandard" value="FZ/T 73020-2012">
            </td>
        </tr>
        <tr>
            <td>安全类别：</td>
            <td>
                <input type="text" name="safetyCategory" id="safetyCategory" VALUE="GB18401 B类">
            </td>
            <td>检验员：</td>
            <td>
                <input type="text" name="inspector" id="inspector" value="检验员04">
            </td>
        </tr>
        <tr>
            <td>建议零售价：</td>
            <td>
                <input type="text" name="suggestedRetailPrice" id="suggestedRetailPrice" value="RMB 199元">
            </td>
        </tr>
    </table>
</div>
<div id="printInfo" class="printBack">
    <!-- 合格证条形码 -->
    <div class="certificate">
        <div class="certificateTitle">合格证</div>
    </div>
    <div class="attribute">
        <div class="attributeLeft">品牌：</div>
        <div class="attributeRight" id="printInfoBrand"></div>
    </div>
    <div class="attribute">
        <div class="attributeLeft">品名：</div>
        <div class="attributeRight" id="printInfoProductName"></div>
    </div>
    <div class="attribute">
        <div class="attributeLeft">货号：</div>
        <div class="attributeRight" id="printInfoProductCode"></div>
    </div>
    <div class="attribute">
        <div class="attributeLeft">型号：</div>
        <div class="attributeRight" id="printInfoModel"></div>
    </div>
    <div class="attribute">
        <div class="attributeLeft">面料：</div>
        <div class="attributeRight" id="printInfoFabric"></div>
    </div>
    <div class="attribute">
        <div class="attributeLeft">等级：</div>
        <div class="attributeRight" id="printInfoGrade"></div>
    </div>
    <div class="attribute">
        <div class="attributeLeft">执行标准：</div>
        <div class="attributeRight" id="printInfoExecutiveStandard"></div>
    </div>
    <div class="attribute">
        <div class="attributeLeft">安全类别：</div>
        <div class="attributeRight" id="printInfoSafetyCategory"></div>
    </div>
    <div class="attribute">
        <div class="attributeLeft">检验员：</div>
        <div class="attributeRight" id="printInfoInspector"></div>
    </div>
    <div class="attribute">
        <div class="attributeLeft">建议零售价：</div>
        <div class="attributeRight" id="printInfoSuggestedRetailPrice"></div>
    </div>
    <div class="attribute">
        <div class="attributeLeft">洗涤说明：</div>
    </div>
    <div>
        <img src="${pageContext.request.contextPath }/static/img/washingMarkInstructions.png">
    </div>
    <div class="skuBarcode">
        <img id="skuBarcode"/>
    </div>
</div>
<div class="print" id="print">
    <button onclick="preview('printInfo');">打印标签</button>
</div>
</body>
<script type="text/javascript">
    function createTmallLable() {
        clearPrintInfo();
        var brand = $("div#skuInfo input[name='brand']").val();
        if (isEmpty(brand)) {
            alert('品牌不能为空');
            return;
        }
        var sku = $("div#skuInfo input[name='sku']").val();
        if (isEmpty(sku)) {
            alert('产品sku不能为空');
            return;
        }
        var productName = $("div#skuInfo input[name='productName']").val();
        if (isEmpty(productName)) {
            alert('品名不能为空');
            return;
        }
        var productCode = $("div#skuInfo input[name='productCode']").val();
        if (isEmpty(productCode)) {
            alert('货号不能为空');
            return;
        }
        var model = $("div#skuInfo input[name='model']").val();
        if (isEmpty(model)) {
            alert('型号不能为空');
            return;
        }
        var fabric = $("div#skuInfo input[name='fabric']").val();
        if (isEmpty(fabric)) {
            alert('面料不能为空');
            return;
        }
        var grade = $("div#skuInfo input[name='grade']").val();
        if (isEmpty(grade)) {
            alert('等级不能为空');
            return;
        }
        var executiveStandard = $("div#skuInfo input[name='executiveStandard']").val();
        if (isEmpty(executiveStandard)) {
            alert('执行标准不能为空');
            return;
        }
        var safetyCategory = $("div#skuInfo input[name='safetyCategory']").val();
        if (isEmpty(safetyCategory)) {
            alert('安全类别不能为空');
            return;
        }
        var inspector = $("div#skuInfo input[name='inspector']").val();
        if (isEmpty(inspector)) {
            alert('检验员不能为空');
            return;
        }
        var suggestedRetailPrice = $("div#skuInfo input[name='suggestedRetailPrice']").val();
        if (isEmpty(suggestedRetailPrice)) {
            alert('建议零售价不能为空');
            return;
        }
        //生成条码
        $("#printInfoBrand").text(brand);
        $("#printInfoProductName").text(productName);
        $("#printInfoProductCode").text(productCode);
        $("#printInfoModel").text(model);
        $("#printInfoFabric").text(fabric);
        $("#printInfoGrade").text(grade);
        $("#printInfoExecutiveStandard").text(executiveStandard);
        $("#printInfoSafetyCategory").text(safetyCategory);
        $("#printInfoInspector").text(inspector);
        $("#printInfoSuggestedRetailPrice").text(suggestedRetailPrice);
        createBarcode("skuBarcode", sku);
    }

    function clearPrintInfo() {
        $("#skuBarcode").removeAttr("src");
        $("#printInfoBrand").text("");
        $("#printInfoProductName").text("");
        $("#printInfoProductCode").text("");
        $("#printInfoModel").text("");
        $("#printInfoFabric").text("");
        $("#printInfoGrade").text("");
        $("#printInfoExecutiveStandard").text("");
        $("#printInfoSafetyCategory").text("");
        $("#printInfoInspector").text("");
        $("#printInfoSuggestedRetailPrice").text("");
    }

    function createBarcode(elementId, str) {
        var element = document.getElementById(elementId),
            options = {
                format: "CODE128",
                displayValue: true,
                fontSize: 20,
                font: "Microsoft YaHei",
                height: 30,
                margin: 3,
            };
        JsBarcode(element, str, options); //原生
    }

    function preview(id) {
        $("#search").hide();
        $("#print").hide();
        $("#skuInfo").hide();
        window.print();
        $("#search").show();
        $("#print").show();
        $("#skuInfo").show();
    }
</script>
</html>
