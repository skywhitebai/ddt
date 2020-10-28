<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2020/7/7
  Time: 10:05
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
    <title>添加内部单号发货记录</title>
</head>
<style>
    .div_main{
        width: 508px;
    }
</style>
<body>
<div class="div_main">

    <div style="text-align:center;">
        <a href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-ok'" onclick="save()">保存</a>
    </div>
    <table>
        <tr>
            <th>内部子单号</th>
            <th>FBAshipmentID</th>
            <th>转单号</th>
        </tr>
        <tr>
            <td><input type="text" id="subOrderNumber_1" name="subOrderNumber"></td>
            <td><input type="text" id="fbaShipmentId_1"></td>
            <td><input type="text" id="transferOrderNo_1"></td>
        </tr>
        <tr>
            <td><input type="text" id="subOrderNumber_2" name="subOrderNumber"></td>
            <td><input type="text" id="fbaShipmentId_2"></td>
            <td><input type="text" id="transferOrderNo_2"></td>
        </tr>
        <tr>
            <td><input type="text" id="subOrderNumber_3" name="subOrderNumber"></td>
            <td><input type="text" id="fbaShipmentId_3"></td>
            <td><input type="text" id="transferOrderNo_3"></td>
        </tr>
        <tr>
            <td><input type="text" id="subOrderNumber_4" name="subOrderNumber"></td>
            <td><input type="text" id="fbaShipmentId_4"></td>
            <td><input type="text" id="transferOrderNo_4"></td>
        </tr>
        <tr>
            <td><input type="text" id="subOrderNumber_5" name="subOrderNumber"></td>
            <td><input type="text" id="fbaShipmentId_5"></td>
            <td><input type="text" id="transferOrderNo_5"></td>
        </tr>
        <tr>
            <td><input type="text" id="subOrderNumber_6" name="subOrderNumber"></td>
            <td><input type="text" id="fbaShipmentId_6"></td>
            <td><input type="text" id="transferOrderNo_6"></td>
        </tr>
        <tr>
            <td><input type="text" id="subOrderNumber_7" name="subOrderNumber"></td>
            <td><input type="text" id="fbaShipmentId_7"></td>
            <td><input type="text" id="transferOrderNo_7"></td>
        </tr>
        <tr>
            <td><input type="text" id="subOrderNumber_8" name="subOrderNumber"></td>
            <td><input type="text" id="fbaShipmentId_8"></td>
            <td><input type="text" id="transferOrderNo_8"></td>
        </tr>
        <tr>
            <td><input type="text" id="subOrderNumber_9" name="subOrderNumber"></td>
            <td><input type="text" id="fbaShipmentId_9"></td>
            <td><input type="text" id="transferOrderNo_9"></td>
        </tr>
        <tr>
            <td><input type="text" id="subOrderNumber_10" name="subOrderNumber"></td>
            <td><input type="text" id="fbaShipmentId_10"></td>
            <td><input type="text" id="transferOrderNo_10"></td>
        </tr>
        <tr>
            <td><input type="text" id="subOrderNumber_11" name="subOrderNumber"></td>
            <td><input type="text" id="fbaShipmentId_11"></td>
            <td><input type="text" id="transferOrderNo_11"></td>
        </tr>
        <tr>
            <td><input type="text" id="subOrderNumber_12" name="subOrderNumber"></td>
            <td><input type="text" id="fbaShipmentId_12"></td>
            <td><input type="text" id="transferOrderNo_12"></td>
        </tr>
        <tr>
            <td><input type="text" id="subOrderNumber_13" name="subOrderNumber"></td>
            <td><input type="text" id="fbaShipmentId_13"></td>
            <td><input type="text" id="transferOrderNo_13"></td>
        </tr>
        <tr>
            <td><input type="text" id="subOrderNumber_14" name="subOrderNumber"></td>
            <td><input type="text" id="fbaShipmentId_14"></td>
            <td><input type="text" id="transferOrderNo_14"></td>
        </tr>
        <tr>
            <td><input type="text" id="subOrderNumber_15" name="subOrderNumber"></td>
            <td><input type="text" id="fbaShipmentId_15"></td>
            <td><input type="text" id="transferOrderNo_15"></td>
        </tr>
        <tr>
            <td><input type="text" id="subOrderNumber_16" name="subOrderNumber"></td>
            <td><input type="text" id="fbaShipmentId_16"></td>
            <td><input type="text" id="transferOrderNo_16"></td>
        </tr>
        <tr>
            <td><input type="text" id="subOrderNumber_17" name="subOrderNumber"></td>
            <td><input type="text" id="fbaShipmentId_17"></td>
            <td><input type="text" id="transferOrderNo_17"></td>
        </tr>
        <tr>
            <td><input type="text" id="subOrderNumber_18" name="subOrderNumber"></td>
            <td><input type="text" id="fbaShipmentId_18"></td>
            <td><input type="text" id="transferOrderNo_18"></td>
        </tr>
        <tr>
            <td><input type="text" id="subOrderNumber_19" name="subOrderNumber"></td>
            <td><input type="text" id="fbaShipmentId_19"></td>
            <td><input type="text" id="transferOrderNo_19"></td>
        </tr>
        <tr>
            <td><input type="text" id="subOrderNumber_20" name="subOrderNumber"></td>
            <td><input type="text" id="fbaShipmentId_20"></td>
            <td><input type="text" id="transferOrderNo_20"></td>
        </tr>
        <tr>
            <td><input type="text" id="subOrderNumber_21" name="subOrderNumber"></td>
            <td><input type="text" id="fbaShipmentId_21"></td>
            <td><input type="text" id="transferOrderNo_21"></td>
        </tr>
        <tr>
            <td><input type="text" id="subOrderNumber_22" name="subOrderNumber"></td>
            <td><input type="text" id="fbaShipmentId_22"></td>
            <td><input type="text" id="transferOrderNo_22"></td>
        </tr>
        <tr>
            <td><input type="text" id="subOrderNumber_23" name="subOrderNumber"></td>
            <td><input type="text" id="fbaShipmentId_23"></td>
            <td><input type="text" id="transferOrderNo_23"></td>
        </tr>
        <tr>
            <td><input type="text" id="subOrderNumber_24" name="subOrderNumber"></td>
            <td><input type="text" id="fbaShipmentId_24"></td>
            <td><input type="text" id="transferOrderNo_24"></td>
        </tr>
        <tr>
            <td><input type="text" id="subOrderNumber_25" name="subOrderNumber"></td>
            <td><input type="text" id="fbaShipmentId_25"></td>
            <td><input type="text" id="transferOrderNo_25"></td>
        </tr>
        <tr>
            <td><input type="text" id="subOrderNumber_26" name="subOrderNumber"></td>
            <td><input type="text" id="fbaShipmentId_26"></td>
            <td><input type="text" id="transferOrderNo_26"></td>
        </tr>
        <tr>
            <td><input type="text" id="subOrderNumber_27" name="subOrderNumber"></td>
            <td><input type="text" id="fbaShipmentId_27"></td>
            <td><input type="text" id="transferOrderNo_27"></td>
        </tr>
        <tr>
            <td><input type="text" id="subOrderNumber_28" name="subOrderNumber"></td>
            <td><input type="text" id="fbaShipmentId_28"></td>
            <td><input type="text" id="transferOrderNo_28"></td>
        </tr>
        <tr>
            <td><input type="text" id="subOrderNumber_29" name="subOrderNumber"></td>
            <td><input type="text" id="fbaShipmentId_29"></td>
            <td><input type="text" id="transferOrderNo_29"></td>
        </tr>
        <tr>
            <td><input type="text" id="subOrderNumber_30" name="subOrderNumber"></td>
            <td><input type="text" id="fbaShipmentId_30"></td>
            <td><input type="text" id="transferOrderNo_30"></td>
        </tr>

    </table>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        addEnterEvent();
    });

    function addEnterEvent() {
        $('input:text:first').focus();
        $('input:text').bind("keydown", function (e) {
            var n = $("input:text").length;
            if (e.which == 13) {
                //Enter key
                e.preventDefault(); //Skip default behavior of the enter key
                var nextIndex = $('input:text').index(this) + 1;
                if (nextIndex < n)
                    $('input:text')[nextIndex].focus();
                else {
                    $('input:text')[nextIndex - 1].blur();
                }
            }
        });
    }

    function save() {
        var list = []
        var subOrderNumberInputs = $("input[name='subOrderNumber']");
        for (var i = 0; i < subOrderNumberInputs.length; i++) {
            item = subOrderNumberInputs[i];
            // 你要实现的业务逻辑
            var number = item.id.split('_')[1];
            var subOrderNumber = item.value;
            var fbaShipmentId = $('#fbaShipmentId_' + number).val();
            var transferOrderNo = $('#transferOrderNo_' + number).val();
            var existCount = 0;
            if (!isEmpty(subOrderNumber)) {
                existCount++;
            }
            if (!isEmpty(fbaShipmentId)) {
                existCount++;
            }
            if (!isEmpty(transferOrderNo)) {
                existCount++;
            }
            if (existCount == 0) {
                continue;
            }
            if (existCount < 3) {
                if (isEmpty(subOrderNumber)) {
                    var str = "第" + (i + 1) + "行,内部子单号不能为空";
                    $.messager.alert("提示", str);
                    return;
                }
                if (isEmpty(fbaShipmentId)) {
                    var str = "第" + (i + 1) + "行,fbaShipmentId不能为空";
                    $.messager.alert("提示", str);
                    return;
                }
                if (isEmpty(transferOrderNo)) {
                    var str = "第" + (i + 1) + "行,转单号不能为空";
                    $.messager.alert("提示", str);
                    return;
                }
            }
            var transportInfo = new Object();
            transportInfo.subOrderNumber = subOrderNumber;
            transportInfo.fbaShipmentId = fbaShipmentId;
            transportInfo.transferOrderNo = transferOrderNo;
            list.push(transportInfo);
        }
        if(list.length==0){
            $.messager.alert("提示", "请填写数据");
            return;
        }
        $.ajax({
            type: 'post',
            url: "${pageContext.request.contextPath }/internalOrderNumberTransport/batchAddInternalOrderNumberTransport",
            contentType: "application/json",
            data: JSON.stringify(list),
            dataType: 'json',
            success: function (data) {
                if (data.code == '200') {
                    $.messager.alert("提示", data.message);
                }
                else {
                    $.messager.alert("提示", data.message);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                $.messager.alert("error");
            }
        });

    }
</script>
</html>
