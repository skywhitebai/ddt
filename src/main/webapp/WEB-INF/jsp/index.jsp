<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/10
  Time: 10:46
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
            src="${pageContext.request.contextPath }/static/js/common/cookieUtil.js?t=20200928"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/common/common.js?t=20201028"></script>
    <script src="${pageContext.request.contextPath }/static/js/highcharts/highcharts.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/highcharts/modules/exporting.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/highcharts/modules/export-data.js"></script>
    <style>
        #d_left {
            width: 280px;
            height: 100px;
            float: left;
        }

        #d_right {
            height: 85px;
            overflow: hidden;
            margin-left: 280px; /*==等于左边栏宽度==*/
        }

        #d_top {
            height: 10px;
            margin-left: 280px; /*==等于左边栏宽度==*/
            text-align: right;
            margin-top: 5px;
            margin-right: 40px;
        }
    </style>
    <title>首页</title>
</head>
<body class="easyui-layout">
<div data-options="region:'north'" style="height: 102px">
    <div id="d_left">
        <h2>点点通管理系统</h2>
        <p>曾经年少爱追梦，一心只想往前飞。</p>
    </div>

    <!-- 上边 -->
    <div id="d_top">
        <label id="userName"></label>&nbsp;&nbsp;&nbsp;
        <a href="#" onclick="showChangePassword()">修改密码</a>&nbsp;&nbsp;&nbsp;
        <a href="#" onclick="logOut()">退出</a>
    </div>
    <!-- 右边 -->
    <div id="d_right">
        <ul id="announcement"></ul>
    </div>
</div>
<div data-options="region:'west',split:true" title="导航菜单" style="width: 200px;padding:15px;">
    <ul id="tree"></ul>
</div>

<div data-options="region:'center',title:'',iconCls:''">
    <div class="easyui-tabs" fit="true" border="false" id="tabs">
        <div title="首页">


        </div>
    </div>
</div>
<%--<div data-options="region:'south',split:true"  style="height:50px;display: none">版权所有</div>--%>

<!--编辑页面-->
<div id="dlg" class="easyui-dialog" style="width: 600px; height: 500px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
    <div class="ftitle">
        <b>修改密码</b>
        <hr/>
    </div>
    <form id="frm" method="post" novalidate="novalidate">
        <table>

            <tr>
                <td>旧密码：</td>
                <td>
                    <input class="easyui-validatebox textbox" type="password" name="oldPassword"
                           data-options="required:true">
                </td>
            </tr>
            <tr>
                <td>新密码：</td>
                <td>
                    <input class="easyui-validatebox textbox" type="password" name="password"
                           data-options="required:true">
                </td>
            </tr>
            <tr>
                <td>确认密码：</td>
                <td>
                    <input class="easyui-validatebox textbox" type="password" name="confirmPassword">
                </td>
            </tr>
        </table>
        <div style="text-align:center;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" onclick="save()">确定</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-cancel'" onclick="closeDialog()">关闭</a>
        </div>
    </form>
</div>

<script type="text/javascript">

    $(function () {
        // 实例化树菜单
        $("#tree").tree({
            url: "${pageContext.request.contextPath }/menu/menuTree",
            lines: true,
            onClick: function (node) {
                if (node.attributes) {
                    openTab(node.text, node.attributes.url);
                }
            }
        });
    });

    // 新增Tab
    function openTab(text, url) {
        if ($("#tabs").tabs('exists', text)) {
            $("#tabs").tabs('select', text);
        } else {
            var content = "<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%' src=" + url + "?&tttt=" + Date() + "></iframe>";
            $("#tabs").tabs('add', {
                title: text,
                //href: url,
                closable: true,
                content: content
            });
        }
    };

    function getAnnouncement() {
        $.post('${pageContext.request.contextPath }/announcement/list', {status: 1, rows: 100}, function (data) {
            if (data.rows.length > 0) {
                for (var i = 0; i < data.rows.length; i++) {
                    $('#announcement').append('<li>' + data.rows[i].title + ":" + data.rows[i].content + '</li> ');
                }
                announcementTurn();
            }
        });
    }

    var intervalId;
    $(document).ready(function () {
        getAnnouncement();
        getCurrentUserInfo();
    });

    function announcementTurn() {
        intervalId = setInterval(function () {
            $('#announcement').children().first().clone(true).appendTo('#announcement');
            $('#announcement>:first').remove();
        }, 2000);
    }

    function announcementStop() {
        clearInterval(intervalId);
    }

    $('#announcement')[0].addEventListener("mouseenter", function () {
        announcementStop();
    }, false);
    $('#announcement')[0].addEventListener("mouseleave", function () {
        announcementTurn();
    }, false);

    function getCurrentUserInfo() {
        $.post('${pageContext.request.contextPath }/account/getCurrentUser', function (data) {
            if (data.code == '200') {
                $("#userName").html(data.data.userName);
            } else {

            }
        });
    }

    function showChangePassword() {
        $('#dlg').dialog('open').dialog('setTitle', '修改密码');
        $('#frm').form('clear');
    }

    function closeDialog() {
        $('#dlg').dialog('close');
    }

    function save() {
        //防止重复点击
        var oldPassword = $("div#dlg input[name='oldPassword']").val();
        if (oldPassword == '') {
            $.messager.alert("提示", '请填旧密码');
            return;
        }
        var password = $("div#dlg input[name='password']").val();
        if (password == '') {
            $.messager.alert("提示", '请填写新密码');
            return;
        }
        var confirmPassword = $("div#dlg input[name='confirmPassword']").val();
        if (confirmPassword == '') {
            $.messager.alert("提示", '请填写确认密码');
            return;
        }
        if (password != confirmPassword) {
            $.messager.alert("提示", '新密码确认密码不一致');
            return;
        }
        $('#frm').form('submit', {
            url: '${pageContext.request.contextPath }/account/changePassword',
            onSubmit: function () {
                var validate = $(this).form('validate');
                return validate;
            },
            success: function (data) {
                res = eval('(' + data + ')');
                if (res.code == '200') {
                    $.messager.alert("提示", "修改成功");
                    closeDialog();
                }
                else {
                    $.messager.alert("提示", res.message);
                }
            }
        });
    }

    function logOut() {
        $.post('${pageContext.request.contextPath }/account/logOut', function (data) {
            if (data.code == '200') {
                delCookie("loginUserName");
                window.location.href = "${pageContext.request.contextPath }/account/login";
            } else {
                window.location.href = "${pageContext.request.contextPath }/account/login";
            }
        });
    }
</script>
</body>
</html>
