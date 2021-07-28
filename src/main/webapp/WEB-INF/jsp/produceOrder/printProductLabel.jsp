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
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    产品sku：
    <input class="easyui-validatebox textbox" id="s_sku">
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
    <button onclick="createTmallLable()">生成标签</button>
</div>
<div class="printHide">
    <table>
        <tr>
            <td>产品名称：</td>
            <td>
                <input class="easyui-validatebox textbox" name="productName" id="productProductName" readonly="readonly">
            </td>
        </tr>
        <tr>
            <td>产品编码：</td>
            <td>
                <input class="easyui-validatebox textbox" name="productCode" readonly="readonly" id="productSku">
            </td>
            <td>产品sku：</td>
            <td>
                <input class="easyui-validatebox textbox" name="sku" id="sku" readonly="readonly">
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
        <tr>
            <td>尺码：</td>
            <td>
                <input class="easyui-validatebox textbox" name="size" id="size" readonly="readonly">
            </td>
        </tr>
    </table>
</div>
</body>
<script type="javascript">
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
        $.post('${pageContext.request.contextPath }/sku/getPrintTmallSku', {
            sku: sku,
            secondSku: secondSku
        }, function (data) {
            if (data.code == '200') {
                $("#sku").val(data.data.secondSku);
                $("#productName").val(data.data.productName);
                $("#productCode").val(data.data.productCode);
                $("#colour").val(data.data.colour);
                $("#colourNumber").val(data.data.colourNumber);
                $("#size").val(data.data.size);
            }
            else {
                $("#sku").val('');
                $("#productName").val('');
                $("#productCode").val('');
                $("#colour").val('');
                $("#colourNumber").val('');
                $("#size").val('');
                alert(data.message);
            }
        });
    }
</script>
</html>
