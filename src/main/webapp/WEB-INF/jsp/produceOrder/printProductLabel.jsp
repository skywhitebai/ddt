<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/28
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>打印标签</title>
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
            src="${pageContext.request.contextPath }/static/js/common/common.js?t=20201028"></script>
    <style>
        .printInfoBack {
            width: 10cm;
            padding: 0cm 0cm;
        }

        .printInfoProduct {
            width: 3.2cm;
            height: 1.74cm;
            overflow-y: hidden;
            overflow-x: hidden;
            padding: 3px 0.066cm;
            float: left
        }

        .certificate {
            /*margin-bottom: 10px;*/
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
            padding-left: 5px;
        }

        .attributeRight {
            display: inline;
            float: right;
            padding-right: 5px;
        }

        .attributeCenter {
            text-align: center;
            font-size: 18px;
        }
        body {
            margin: 0px;
            padding: 0px;
        }
    </style>
</head>
<body>
<!--查询条件-->
<div class="printHide">
    <div class="easyui-panel">
        产品sku：
        <input class="easyui-validatebox textbox" id="s_sku">
        <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
           style="width: 80px">查 询</a>
        <br/>
        数量
        <input class="easyui-numberbox" name="quantity" id="quantity" min="0"
               precision="0">
        <a href="javascript:void(0)" onclick="createPrintProductLable()" class="easyui-linkbutton">生成标签</a>
        <a href="javascript:void(0)" onclick="hide()" class="easyui-linkbutton">隐藏</a>
        <a href="javascript:void(0)" onclick="printProductLable()" class="easyui-linkbutton">打印</a>
    </div>
</div>
<div class="printHide">
    <table>
        <tr>
            <td>产品sku：</td>
            <td>
                <input class="easyui-validatebox textbox" name="sku" id="sku" readonly="readonly">
            </td>
            <td>尺码：</td>
            <td>
                <input class="easyui-validatebox textbox" name="size" id="size" readonly="readonly">
            </td>
        </tr>
        <tr>
            <td>颜色：</td>
            <td>
                <input class="easyui-validatebox textbox" name="colour" id="colour" deadonly="readonly">
            </td>
            <td>色号：</td>
            <td>
                <input class="easyui-validatebox textbox" name="colourNumber" id="colourNumber" readonly="readonly">
            </td>
        </tr>
    </table>
</div>
<div class="printInfo" id="printDive">
    <div class="printInfoBack" id="printInfoBackDiv">
        <%--<div class="printInfoProduct">
            <div class="certificate">
                <div class="certificateTitle">产品sku</div>
            </div>
            <div class="attribute">
                <div class="attributeLeft">颜色</div>
                <div class="attributeRight">色号</div>
            </div>
            <div class="attribute">
                <div class="attributeCenter">尺码大一点</div>
            </div>
        </div>--%>
    </div>

</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        bindFirst();
    });

    function bindFirst() {
        var sku = getQueryVariable('sku');
        if (!isEmpty(sku)) {
            $("#s_sku").val(decodeURI(sku));
            bindData();
        }
    }

    function bindData() {
        var sku = $("#s_sku").val();
        var secondSku = $("#s_secondSku").val();
        if (isEmpty(sku) && isEmpty(secondSku)) {
            alert('请填写产品sku或者副sku');
            return;
        }
        $.post('${pageContext.request.contextPath }/sku/getSkuBySku', {
            sku: sku,
            secondSku: secondSku
        }, function (data) {
            if (data.code == '200') {
                $("#sku").val(data.data.sku);
                $("#colour").val(data.data.colour);
                $("#colourNumber").val(data.data.colourNumber);
                $("#size").val(data.data.size);
            } else {
                $("#sku").val('');
                $("#colour").val('');
                $("#colourNumber").val('');
                $("#size").val('');
                alert(data.message);
            }
        });
    }

    function createPrintProductLable() {
        $('#printInfoBackDiv').html("");
        var quantity = $("#quantity").val();
        if (isEmpty(quantity)) {
            $.messager.alert("提示", "请填写数量.");
            return;
        }
        var sku = $("#sku").val();
        if (isEmpty(sku)) {
            $.messager.alert("提示", "sku信息不能为空.");
            return;
        }
        var colour = $("#colour").val();
        /*if (isEmpty(colour)) {
            $.messager.alert("提示", "颜色信息不能为空.");
            return;
        }*/
        var colourNumber = $("#colourNumber").val();
        /*if (isEmpty(colourNumber)) {
            $.messager.alert("提示", "色号信息不能为空.");
            return;
        }*/
        var size = $("#size").val();
        /*if (isEmpty(size)) {
            $.messager.alert("提示", "尺码信息不能为空.");
            return;
        }*/

        var printInfoProductHtml = '<div class="printInfoProduct">\n' +
            '            <div class="certificate">\n' +
            '                <div class="certificateTitle">产品sku</div>\n' +
            '            </div>\n' +
            '            <div class="attribute">\n' +
            '                <div class="attributeLeft">颜色</div>\n' +
            '                <div class="attributeRight">色号</div>\n' +
            '            </div>\n' +
            '            <div class="attribute">\n' +
            '                <div class="attributeCenter">尺码大一点</div>\n' +
            '            </div>\n' +
            '        </div>';
        printInfoProductHtml = printInfoProductHtml.replace('产品sku', sku);
        printInfoProductHtml = printInfoProductHtml.replace('颜色', colour);
        printInfoProductHtml = printInfoProductHtml.replace('色号', colourNumber);
        printInfoProductHtml = printInfoProductHtml.replace('尺码大一点', size);
        var html = "";
        for (i = 0; i < quantity; i++) {
            html = html + printInfoProductHtml;
        }
        $('#printInfoBackDiv').html(html);
    }

    function printProductLable() {
        $(".printHide").hide();
        window.print();
        $(".printHide").show();
    }
    function hide() {
        $(".printHide").hide();
    }
    function show() {
        $(".printHide").show();
    }
</script>
</html>
