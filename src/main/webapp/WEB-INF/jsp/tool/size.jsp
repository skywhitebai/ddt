<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/24
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>尺码转换</title>
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
    <style>
        .txt {
            width: 60px;
        }
    </style>
</head>
<body>
<table border="1" cellspacing="0">
    <tr>
        <td>型号</td>
        <td><input class=" txt easyui-validatebox textbox" id="size1"></td>
        <td><input class=" txt easyui-validatebox textbox" id="size2"></td>
        <td><input class=" txt easyui-validatebox textbox" id="size3"></td>
        <td><input class=" txt easyui-validatebox textbox" id="size4"></td>
        <td><input class=" txt easyui-validatebox textbox" id="size5"></td>
        <td><input class=" txt easyui-validatebox textbox" id="size6"></td>
        <td><input class=" txt easyui-validatebox textbox" id="size7"></td>
        <td><input class=" txt easyui-validatebox textbox" id="size8"></td>
    </tr>
    <tr>
        <td>胸围</td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="bust1"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="bust2"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="bust3"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="bust4"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="bust5"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="bust6"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="bust7"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="bust8"></td>
    </tr>
    <tr>
        <td>腰围</td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="waist1"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="waist2"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="waist3"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="waist4"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="waist5"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="waist6"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="waist7"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="waist8"></td>
    </tr>
    <tr>
        <td>臀围</td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="hip1"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="hip2"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="hip3"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="hip4"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="hip5"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="hip6"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="hip7"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="hip8"></td>
    </tr>
    <tr>
        <td>衣长</td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="length1"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="length2"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="length3"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="length4"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="length5"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="length6"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="length7"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="length8"></td>
    </tr>
    <tr>
        <td>袖长</td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="sleeve1"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="sleeve2"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="sleeve3"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="sleeve4"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="sleeve5"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="sleeve6"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="sleeve7"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="sleeve8"></td>
    </tr>
    <tr>
        <td>肩宽</td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="shoulder1"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="shoulder2"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="shoulder3"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="shoulder4"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="shoulder5"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="shoulder6"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="shoulder7"></td>
        <td><input class=" txt easyui-numberbox" data-options="min:0,precision:2" id="shoulder8"></td>
    </tr>
    <tr>
        <td colspan="9">
            <input type="button" value="厘米转inch" onclick="convert('cm','inch')">&nbsp;&nbsp;&nbsp;&nbsp;<input
                type="button" value="英寸转inch" onclick="convert('inch','inch')">&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" value="厘米转cm" onclick="convert('cm','cm')">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button"
                                                                                                           value="英寸转cm"
                                                                                                           onclick="convert('inch','cm')">
        </td>
    </tr>
    <tr>
        <td colspan="9">
            <textarea name="a" style="width:500px;height:150px;" id="result"></textarea>

        </td>
    </tr>
</table>

<script>
    function getResult(num, fromType, toType) {
        var size = $('#size' + num).val();
        var bust = $('#bust' + num).val();
        var waist = $('#waist' + num).val();
        var hip = $('#hip' + num).val();
        var length = $('#length' + num).val();
        var sleeve = $('#sleeve' + num).val();
        var shoulder = $('#shoulder' + num).val();
        var result = "";
        var unit = "";
        if (toType == "cm") {
            unit = " cm";
        } else if (toType == "inch") {
            unit = "\"";
        }
        if (size != null && size != "") {
            result = size + "-";
        }
        if (bust != null && bust != "") {
            result = result + "Bust:" + getInchOrCm(bust, fromType, toType) + unit + ",";
        }
        if (waist != null && waist != "") {
            result = result + "Waist:" + getInchOrCm(waist, fromType, toType) + unit + ",";
        }
        if (hip != null && hip != "") {
            result = result + "Hip:" + getInchOrCm(hip, fromType, toType) + unit + ",";
        }
        if (length != null && length != "") {
            result = result + "Length:" + getInchOrCm(length, fromType, toType) + unit + ",";
        }
        if (sleeve != null && sleeve != "") {
            result = result + "Sleeve:" + getInchOrCm(sleeve, fromType, toType) + unit + ",";
        }
        if (shoulder != null && shoulder != "") {
            result = result + "Shoulder:" + getInchOrCm(shoulder, fromType, toType) + unit + ",";
        }
        result = removeLastComma(result);
        return result.replace(/\:/g,": ").replace(/,/g,", ").replace(/;/g,"; ");
    }

    function convert(fromType, toType) {
        var resultAll = "";//<br>Size Information(inch):
        for (var i = 1; i <= 8; i++) {
            var result = getResult(i, fromType, toType);
            if (result != "") {
                resultAll += "\n<br>" + result + ".";
            }
        }
        if (resultAll != "") {
            resultAll = "<br>Size Information(" + toType + "): " + resultAll;
        }
        //$('#result').text(resultAll);
        document.getElementById('result').innerText = resultAll;
        if (resultAll != "") {
            $.messager.alert("提示", "处理成功，请复制数据");
        } else {
            $.messager.alert("提示", "内容为空");
        }
        //copy(resultAll);
    }

    function getInchOrCm(value, fromType, toType) {
        if (toType == "inch") {
            if (fromType == "cm") {
                return (value / 2.54).toFixed(1);
            } else if (fromType == "inch") {
                return (value / 1).toFixed(1);
            } else {
                return (value / 1).toFixed(1);
            }
        } else if (toType == "cm") {
            if (fromType == "inch") {
                return (value * 2.54).toFixed(1);
            } else if (fromType == "cm") {
                return (value / 1).toFixed(1);
            } else {
                return (value / 1).toFixed(1);
            }
        } else {
            return (value / 1).toFixed(1);
        }
    }

    function removeLastComma(str) {
        if (str == null || str == "") {
            return str;
        }
        lastChar = str.substring(str.length - 1);
        if (lastChar == ",") {
            str = str.substring(0, str.length - 1);
        }
        return str;
    }

    function copy(result) {
        if (result == null || result == "") {
            $.messager.alert("提示", "内容为空");
            return;
        }
        var oInput = document.createElement('input');
        oInput.value = result.replace("\n", "\r\n");
        document.body.appendChild(oInput);
        oInput.select(); // 选择对象
        document.execCommand("Copy"); // 执行浏览器复制命令
        oInput.className = 'oInput';
        oInput.style.display = 'none';
        $.messager.alert("提示", "复制成功");
    }

    function doCopy() {
        result = $('#result').val();
        copy(result);
    }
</script>
</body>
</html>
