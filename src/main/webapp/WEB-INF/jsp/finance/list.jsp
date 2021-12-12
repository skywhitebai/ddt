<%--
  Created by IntelliJ IDEA.
  User: skywhite
  Date: 2019/11/19
  Time: 16:07
  To change this template use File | Settings | File Templates.
  财务统计列表
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
            src="${pageContext.request.contextPath }/static/js/common/common.js?t=20201028"></script>
    <title>财务统计列表</title>
</head>
<body>
<!--查询条件-->
<div class="easyui-panel">
    店铺：
    <select id="s_shopId" style="width:150px;">
    </select>
    年月
    <input class="easyui-validatebox textbox" id="s_month">
    <a href="javascript:void(0)" onclick="bindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       style="width: 80px">查 询</a>
</div>
<div>
    <a href="javascript:void(0)" onclick="showDlgImport('monthlySales',null)" class="easyui-linkbutton">导入月流水信息</a>
    <a href="javascript:void(0)" onclick="showDlgImport('monthlyAdvertisingFee',null)"
       class="easyui-linkbutton">导入月广告费</a>
    <a href="javascript:void(0)" onclick="showDlgImport('lightingDeal',null)" class="easyui-linkbutton">导入秒杀</a>
    <a href="javascript:void(0)" onclick="showDlgImport('monthlyStorageFee',null)" class="easyui-linkbutton">导入月仓储费</a>
    <a href="javascript:void(0)" onclick="showDlgImport('longStorageFee',null)" class="easyui-linkbutton">导入长期仓储费</a>
    <a href="javascript:void(0)" onclick="showDlgImport('coupon',null)" class="easyui-linkbutton">导入优惠券</a>
    <a href="javascript:void(0)" onclick="showDlgImport('earlyReviewerProgramFee',null)"
       class="easyui-linkbutton">导入早评</a>
    <a href="javascript:void(0)" onclick="showDlgImport('destructionFee',null)" class="easyui-linkbutton">导入销毁费用</a>
    <a href="javascript:void(0)" onclick="showDlgImport('destructionDetails',null)" class="easyui-linkbutton">导入销毁明细</a>
    <a href="javascript:void(0)" onclick="showDlgImport('inventoryDetails',null)" class="easyui-linkbutton">导入库存明细</a>
    <%--<a href="javascript:void(0)" onclick="showDlgImport('headDeduction',null)" class="easyui-linkbutton">导入头程抵扣</a>--%>
    <a href="javascript:void(0)" onclick="showDlgImport('manualAdjustment',null)" class="easyui-linkbutton">导入人工核准</a>
    <br>
    <a href="javascript:void(0)" onclick="exportFbaCustomerReturnPerUnitFeeNotExistSku()" class="easyui-linkbutton">导出退款操作费找不到sku的订单号</a>
    <a href="javascript:void(0)" onclick="exportDeveloperFinancialStatement()" class="easyui-linkbutton">导出开发人员财务报表</a>
    <a href="javascript:void(0)" onclick="exportSalesmanFinancialStatement()" class="easyui-linkbutton">导出销售人员财务报表</a>
    <a href="javascript:void(0)" onclick="exportFinancialStatementAll()" class="easyui-linkbutton">下载所有店铺报表</a>

    <br>
</div>
<table id="dg" style="width: 100%; height: auto">

</table>
<!--导入页面-->
<div id="dlgImport" class="easyui-dialog" style="width: 600px; height: 300px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
    <div class="ftitle">
        <b id="importTitle"></b>
        <hr/>
    </div>
    <form id="frmImport" method="post" novalidate="novalidate" enctype="multipart/form-data">
        年月<b style="color: red">*</b>
        <input class="easyui-validatebox textbox" id="importMonth" name="month">
        <br>
        <input type="file" id="importFile" name="file" accept=".xls,.xlsx"/>
        <input type="hidden" id="importType" name="type">
        <div style="text-align:center;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" onclick="importFinance()">导入</a>
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-cancel'" onclick="closeDlgImport()">关闭</a>
        </div>
    </form>
</div>
<div id="cover">
    <div id="coverMsg">
        <img src="${pageContext.request.contextPath }/static/img/loading.gif" width="100px">
    </div>
</div>

<div id="dlgFinanceStatistic" class="easyui-dialog" style="width: 1500px; height: 300px; padding: 10px 20px"
     data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
    <div class="ftitle">
        回款信息
    </div>
    <table id="dgFinanceStatistic" style="width: 100%; height: auto">

    </table>
    <a href="javascript:void(0)" class="easyui-linkbutton"
       data-options="iconCls:'icon-cancel'" onclick="closeDlgFinanceStatistic()">关闭</a>
</div>
</body>
<script type="text/javascript">
    var financeIdLocal;
    $(function () {
        initMonth('s_month');
        initMonth('importMonth');
        bindShop();
        bindData();
    });

    function bindShop() {
        $('#s_shopId').combobox({
            valueField: 'shopId',
            textField: 'shopName',
            url: "${pageContext.request.contextPath }/shop/comboboxlist",//获取数据
        });
    }

    function bindData() {
        dg = '#dg';
        url = "${pageContext.request.contextPath }/finance/list";
        title = "财务列表";
        queryParams = {
            shopId: $("#s_shopId").combobox('getValue'),
            month: $("#s_month").val()
        };
        $(dg).datagrid({   //定位到Table标签，Table标签的ID是grid
            url: url,   //指向后台的Action来获取当前菜单的信息的Json格式的数据
            title: title,
            iconCls: 'icon-view',
            nowrap: true,
            autoRowHeight: false,
            striped: true,
            collapsible: true,
            pagination: true,
            //singleSelect: true,
            pageSize: 15,
            pageList: [10, 15, 20, 30, 50],
            rownumbers: true,
            //sortName: 'ID',    //根据某个字段给easyUI排序
            //sortOrder: 'asc',
            remoteSort: false,
            idField: 'id',
            queryParams: queryParams,  //异步查询的参数
            columns: [[
                {field: 'ck', checkbox: true},   //选择
                {title: '店铺名', field: 'shopName', width: 120},
                {
                    title: '年月', field: 'month', width: 80, formatter: function (value, row, index) {
                    if (value) {
                        return value.substr(0, 7);
                    }
                }
                },
                {
                    title: '月销售流水', field: 'monthlySales', width: 100, formatter: function (value, row, index) {
                    if (value) {
                        return "<a href='#' onclick=\"showDlgImport('monthlySales','" + row.month + "')\"' title='更新月销售流水' >已导入</a>";
                    } else {
                        return "<a href='#' onclick=\"showDlgImport('monthlySales','" + row.month + "')\"' title='导入月销售流水' >未导入</a>";
                    }
                }
                },
                {
                    title: '月广告费', field: 'monthlyAdvertisingFee', width: 80, formatter: function (value, row, index) {
                    if (value) {
                        return "<a href='#' onclick=\"showDlgImport('monthlyAdvertisingFee','" + row.month + "')\"' title='更新月广告费' >已导入</a>";
                    } else {
                        return "<a href='#' onclick=\"showDlgImport('monthlyAdvertisingFee','" + row.month + "')\"' title='导入月广告费' >未导入</a>";
                    }
                }
                },
                {
                    title: '秒杀', field: 'lightingDeal', width: 80, formatter: function (value, row, index) {
                    if (value) {
                        return "<a href='#' onclick=\"showDlgImport('lightingDeal','" + row.month + "')\"' title='更新秒杀' >已导入</a>";
                    } else {
                        return "<a href='#' onclick=\"showDlgImport('lightingDeal','" + row.month + "')\"' title='导入秒杀' >未导入</a>";
                    }
                }
                },
                {
                    title: '月仓储费', field: 'monthlyStorageFee', width: 80, formatter: function (value, row, index) {
                    if (value) {
                        return "<a href='#' onclick=\"showDlgImport('monthlyStorageFee','" + row.month + "')\"' title='更新月仓储费' >已导入</a>";
                    } else {
                        return "<a href='#' onclick=\"showDlgImport('monthlyStorageFee','" + row.month + "')\"' title='导入月仓储费' >未导入</a>";
                    }
                }
                },
                {
                    title: '长期仓储费', field: 'longStorageFee', width: 80, formatter: function (value, row, index) {
                    if (value) {
                        return "<a href='#' onclick=\"showDlgImport('longStorageFee','" + row.month + "')\"' title='更新长期仓储费' >已导入</a>";
                    } else {
                        return "<a href='#' onclick=\"showDlgImport('longStorageFee','" + row.month + "')\"' title='导入长期仓储费' >未导入</a>";
                    }
                }
                },
                {
                    title: '优惠券', field: 'coupon', width: 80, formatter: function (value, row, index) {
                    if (value) {
                        return "<a href='#' onclick=\"showDlgImport('coupon','" + row.month + "')\"' title='更新优惠券' >已导入</a>";
                    } else {
                        return "<a href='#' onclick=\"showDlgImport('coupon','" + row.month + "')\"' title='导入优惠券' >未导入</a>";
                    }
                }
                },
                {
                    title: '早评', field: 'earlyReviewerProgramFee', width: 80, formatter: function (value, row, index) {
                    if (value) {
                        return "<a href='#' onclick=\"showDlgImport('earlyReviewerProgramFee','" + row.month + "')\"' title='更新早评' >已导入</a>";
                    } else {
                        return "<a href='#' onclick=\"showDlgImport('earlyReviewerProgramFee','" + row.month + "')\"' title='导入早评' >未导入</a>";
                    }
                }
                },
                {
                    title: '销毁费用', field: 'destructionFee', width: 80, formatter: function (value, row, index) {
                    if (value) {
                        return "<a href='#' onclick=\"showDlgImport('destructionFee','" + row.month + "')\"' title='更新销毁费用' >已导入</a>";
                    } else {
                        return "<a href='#' onclick=\"showDlgImport('destructionFee','" + row.month + "')\"' title='导入销毁费用' >未导入</a>";
                    }
                }
                },
                {
                    title: '销毁明细', field: 'destructionDetails', width: 80, formatter: function (value, row, index) {
                    if (value) {
                        return "<a href='#' onclick=\"showDlgImport('destructionDetails','" + row.month + "')\"' title='更新销毁明细' >已导入</a>";
                    } else {
                        return "<a href='#' onclick=\"showDlgImport('destructionDetails','" + row.month + "')\"' title='导入销毁明细' >未导入</a>";
                    }
                }
                },
                {
                    title: '库存明细', field: 'inventoryDetails', width: 80, formatter: function (value, row, index) {
                    if (value) {
                        return "<a href='#' onclick=\"showDlgImport('inventoryDetails','" + row.month + "')\"' title='更新库存明细' >已导入</a>";
                    } else {
                        return "<a href='#' onclick=\"showDlgImport('inventoryDetails','" + row.month + "')\"' title='导入库存明细' >未导入</a>";
                    }
                }
                },
                /* {
                     title: '头程抵扣', field: 'headDeduction', width: 80, formatter: function (value, row, index) {
                     if (value) {
                         return "<a href='#' onclick=\"showDlgImport('headDeduction','" + row.month + "')\"' title='更新头程抵扣' >已导入</a>";
                     } else {
                         return "<a href='#' onclick=\"showDlgImport('headDeduction','" + row.month + "')\"' title='导入头程抵扣' >未导入</a>";
                     }
                 }
                 },*/
                {
                    title: '人工核准', field: 'manualAdjustment', width: 80, formatter: function (value, row, index) {
                    if (value) {
                        return "<a href='#' onclick=\"showDlgImport('manualAdjustment','" + row.month + "')\"' title='更新人工核准' >已导入</a>";
                    } else {
                        return "<a href='#' onclick=\"showDlgImport('manualAdjustment','" + row.month + "')\"' title='导入人工核准' >未导入</a>";
                    }
                }
                },

                {
                    title: '操作', field: 'id', width: 180,
                    formatter: function (value, row, rowIndex) {
                        if (row.status == 0) {
                            return '<a href="javascript:void(0)" onclick="createFinancialStatement(' + row.id + ')" class="easyui-linkbutton" >生成报表</a>';
                        } else if (row.status == 1) {
                            return '<a href="javascript:void(0)" onclick="createFinancialStatement(' + row.id + ')" class="easyui-linkbutton" >重新生成</a>'
                                + '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="exportFinancialStatement(' + row.id + ')" class="easyui-linkbutton" >下载报表</a>'
                                + '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="lockFinance(' + row.id + ')" title="锁定后不能再重新生成" class="easyui-linkbutton" >锁定</a>';
                        } else if (row.status == 2) {
                            return '<a href="javascript:void(0)" onclick="exportFinancialStatement(' + row.id + ')" class="easyui-linkbutton" >下载报表</a>'
                                + '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="unlockFinance(' + row.id + ')" title="解锁" class="easyui-linkbutton" >解锁</a>';
                        }
                    }
                },
                {
                    title: '回款信息', field: 'statisticStatus', width: 130,
                    formatter: function (value, row, rowIndex) {
                        if (row.status == 0) {
                            return '请先生成财务报表';
                        }
                        if (value == 0) {
                            return '<a href="javascript:void(0)" onclick="createFinanceStatistic(' + row.id + ')" class="easyui-linkbutton" >生成</a>';
                        } else if (value == 1) {
                            return '<a href="javascript:void(0)" onclick="createFinanceStatistic(' + row.id + ')" class="easyui-linkbutton" >重新生成</a>'
                                + '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="showFinanceStatistic(' + row.id + ')" class="easyui-linkbutton" >查看</a>'
                                + '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="lockFinanceStatistic(' + row.id + ')" title="锁定后不能再重新生成" class="easyui-linkbutton" >锁定</a>';
                        } else if (value == 2) {
                            return '<a href="javascript:void(0)" onclick="showFinanceStatistic(' + row.id + ')" class="easyui-linkbutton" >查看</a>'
                                + '&nbsp;&nbsp;已锁定'
                                + '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="unlockFinanceStatistic(' + row.id + ')" title="解锁" class="easyui-linkbutton" >解锁</a>';
                        }
                    }
                },
                {
                    title: '备注', field: 'remark', width: 288,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-textbox " style="width:100%"  onchange="saveFinanceRemark(this,' + row.id + ')">';
                        } else {
                            return '<input class="easyui-textbox" style="width:100%" value="' + value + '" onchange="saveFinanceRemark(this,' + row.id + ')">';
                        }
                    }
                },
                {title: '创建时间', field: 'createTime', width: 120},
                {title: '修改时间', field: 'updateTime', width: 120}
            ]],
            toolbar: [{
                id: 'btnReload',
                text: '刷新',
                iconCls: 'icon-reload',
                handler: function () {
                    //实现刷新栏目中的数据
                    $(dg).datagrid("reload");
                }
            }]
        })
        $(dg).datagrid('clearSelections');
    }

    function showDlgImport(importType, month) {
        var importTitle;
        switch (importType) {
            case 'monthlySales':
                importTitle = "导入月流水信息";
                break;
            case 'lightingDeal':
                importTitle = "导入秒杀";
                break;
            case 'monthlyStorageFee':
                importTitle = "导入月仓储费";
                break;
            case 'longStorageFee':
                importTitle = "导入长期仓储费";
                break;
            case 'coupon':
                importTitle = "导入优惠券";
                break;
            case 'earlyReviewerProgramFee':
                importTitle = "导入早评";
                break;
            case 'destructionFee':
                importTitle = "导入销毁费";
                break;
            case 'destructionDetails':
                importTitle = "导入销毁明细";
                break;
            case 'inventoryDetails':
                importTitle = "导入库存明细";
                break;
            case 'headDeduction':
                importTitle = "导入头程抵扣";
                break;
            case 'monthlyAdvertisingFee':
                importTitle = "导入月广告费";
                break;
            case 'manualAdjustment':
                importTitle = "导入人工核准";
                break;
        }
        if (isEmpty(importTitle)) {
            $.messager.alert("提示", "请选择正确的导入类型.");
            return;
        }
        $("#importTitle").text(importTitle);
        $("#importType").val(importType);
        $("#importFile").val('');
        if (!isEmpty(month)) {
            $('#importMonth').datebox('setValue', month);
        }
        $('#dlgImport').dialog('open').dialog('setTitle', importTitle);
    }

    function closeDlgImport() {
        $('#dlgImport').dialog('close');
    }

    function showFinanceStatistic(financeId) {
        financeIdLocal = financeId;
        $('#dlgFinanceStatistic').dialog('open').dialog('setTitle', '回款信息');
        bindFinanceStatistic();
    }
    function saveManualAdjustment(input, id) {
        var manualAdjustment = $(input).val();
        if (isEmpty(manualAdjustment)) {
            manualAdjustment = 0;
        }
        $.post('${pageContext.request.contextPath }/financeStatistic/saveFinanceStatisticManualAdjustment', {
            manualAdjustment: manualAdjustment,
            id: id
        }, function (data) {
            if (data.code == '200') {
                //保存成功
                bindFinanceStatistic();
            }
            else {
                $.messager.alert("提示", data.message);
            }
        });
    }
    function saveFinanceStatisticRemark(input, id) {
        var remark = $(input).val();
        $.post('${pageContext.request.contextPath }/financeStatistic/saveFinanceStatisticRemark', {
            remark: remark,
            id: id
        }, function (data) {
            if (data.code == '200') {
                //保存成功
                bindFinanceStatistic();
            }
            else {
                $.messager.alert("提示", data.message);
            }
        });
    }
    function bindFinanceStatistic() {
        dg = '#dgFinanceStatistic';
        url = "${pageContext.request.contextPath }/financeStatistic/listFinanceStatistic";
        title = "回款信息";
        queryParams = {
            financeId: financeIdLocal
        };
        $(dg).datagrid({   //定位到Table标签，Table标签的ID是grid
            url: url,   //指向后台的Action来获取当前菜单的信息的Json格式的数据
            title: title,
            iconCls: 'icon-view',
            nowrap: true,
            autoRowHeight: false,
            striped: true,
            collapsible: true,
            pagination: true,
            //singleSelect: true,
            pageSize: 15,
            pageList: [10, 15, 20, 30, 50],
            rownumbers: true,
            //sortName: 'ID',    //根据某个字段给easyUI排序
            //sortOrder: 'asc',
            remoteSort: false,
            idField: 'id',
            queryParams: queryParams,  //异步查询的参数
            columns: [[
                {field: 'ck', checkbox: true},   //选择
                {title: '店铺名', field: 'shopName', width: 120},
                {title: '年月', field: 'monthStr', width: 80},
                {title: '期初价值', field: 'initialInventoryCost', width: 95},
                {title: '期末价值', field: 'finalInventoryCost', width: 95},
                {title: '当月发送价值', field: 'sendCost', width: 95},
                {title: '当月销售价值', field: 'saleCost', width: 95},
                {title: '当月回款', field: 'mainBusinessIncome', width: 95},
                {
                    title: '账外调整', field: 'manualAdjustment', width: 95,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-numberbox " precision="2" onchange="saveManualAdjustment(this,' + row.id + ')">';
                        } else {
                            return '<input class="easyui-numberbox" precision="2" value="' + value + '" onchange="saveManualAdjustment(this,' + row.id + ')">';
                        }
                    }
                },
                {title: '当月净入', field: 'netIncome', width: 95},
                {
                    title: '备注', field: 'remark', width: 300,
                    formatter: function (value, row, rowIndex) {
                        if (isEmpty(value)) {
                            return '<input class="easyui-textbox " style="width:100%"  onchange="saveFinanceStatisticRemark(this,' + row.id + ')">';
                        } else {
                            return '<input class="easyui-textbox" style="width:100%" value="' + value + '" onchange="saveFinanceStatisticRemark(this,' + row.id + ')">';
                        }
                    }
                },
                {title: '毛利润', field: 'mainBusinessProfit', width: 80},
                {title: '创建时间', field: 'createTime', width: 120},
                {title: '修改时间', field: 'updateTime', width: 120}
            ]],
            toolbar: [{
                id: 'btnReload',
                text: '刷新',
                iconCls: 'icon-reload',
                handler: function () {
                    //实现刷新栏目中的数据
                    $(dg).datagrid("reload");
                }
            }]
        })
        $(dg).datagrid('clearSelections');
    }

    function closeDlgFinanceStatistic() {
        $('#dlgFinanceStatistic').dialog('close');
    }

    function importFinance() {
        var month = $('#importMonth').datebox('getValue');
        if (isEmpty(month)) {
            $.messager.alert("提示", "请选择年月.");
            return;
        }
        var importFile = $("#importFile").val();
        if (importFile == '') {
            $.messager.alert("提示", "请选择导入的文件");
            return;
        }
        var dom = document.getElementById("importFile");
        var fileSize = dom.files[0].size;
        if (fileSize > 30000000) {
            $.messager.alert("提示", "上传文件过大,请上传小于30M的文件");
            return false;
        }
        $('#frmImport').form('submit', {
            url: '${pageContext.request.contextPath }/finance/importFinance',
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
                    $.messager.alert("提示", "上传成功");
                    bindData();
                }
                else {
                    $.messager.alert("提示", res.message);
                }
                //关闭遮罩
            }
        });
    }

    function createFinancialStatement(id) {
        showCover();
        $.post('${pageContext.request.contextPath }/financialStatement/createFinancialStatement', {financeId: id}, function (data) {
            hideCover();
            if (data.code == '200') {
                $.messager.alert("提示", "生成成功");
                bindData();
            }
            else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function createFinanceStatistic(id) {
        showCover();
        $.post('${pageContext.request.contextPath }/financeStatistic/createFinanceStatistic', {financeId: id}, function (data) {
            hideCover();
            if (data.code == '200') {
                $.messager.alert("提示", "生成成功");
                bindData();
            }
            else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function exportFinancialStatement(id) {
        window.open('${pageContext.request.contextPath }/financialStatement/exportFinancialStatement?financeId=' + id);
    }

    function lockFinance(id) {
        $.post('${pageContext.request.contextPath }/finance/lockFinance', {id: id}, function (data) {
            if (data.code == '200') {
                $.messager.alert("提示", "锁定成功");
                bindData();
            }
            else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function unlockFinance(id) {
        $.post('${pageContext.request.contextPath }/finance/unlockFinance', {id: id}, function (data) {
            if (data.code == '200') {
                $.messager.alert("提示", "解锁成功");
                bindData();
            }
            else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function lockFinanceStatistic(id) {
        $.post('${pageContext.request.contextPath }/finance/lockFinanceStatistic', {id: id}, function (data) {
            if (data.code == '200') {
                $.messager.alert("提示", "锁定成功");
                bindData();
            }
            else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function unlockFinanceStatistic(id) {
        $.post('${pageContext.request.contextPath }/finance/unlockFinanceStatistic', {id: id}, function (data) {
            if (data.code == '200') {
                $.messager.alert("提示", "解锁成功");
                bindData();
            }
            else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function exportFbaCustomerReturnPerUnitFeeNotExistSku() {
        var rows = $('#dg').datagrid('getSelections');
        if (rows && rows.length == 1) {
            window.open('${pageContext.request.contextPath }/finance/exportFbaCustomerReturnPerUnitFeeNotExistSku?financeId=' + rows[0].id);
        } else {
            $.messager.alert("提示", "请选择一条记录.");
        }
    }

    function saveFinanceRemark(input, financeId) {
        var remark = $(input).val();
        $.post('${pageContext.request.contextPath }/finance/saveFinanceRemark', {
            financeId: financeId,
            remark: remark
        }, function (data) {
            if (data.code == '200') {
                $.messager.alert("提示", "修改成功");
                bindData();
            }
            else {
                $.messager.alert("提示", data.message);
            }
        });
    }

    function exportDeveloperFinancialStatement() {
        var month = $("#s_month").val();
        if (isEmpty(month)) {
            $.messager.alert("提示", "请选择月份");
            return;
        }
        window.open('${pageContext.request.contextPath }/financialStatement/exportDeveloperFinancialStatement?month=' + month);
    }

    function exportSalesmanFinancialStatement() {
        var month = $("#s_month").val();
        if (isEmpty(month)) {
            $.messager.alert("提示", "请选择月份");
            return;
        }
        window.open('${pageContext.request.contextPath }/financialStatement/exportSalesmanFinancialStatement?month=' + month);
    }

    function exportFinancialStatementAll() {
        var month = $("#s_month").val();
        if (isEmpty(month)) {
            $.messager.alert("提示", "请选择月份");
            return;
        }
        window.open('${pageContext.request.contextPath }/financialStatement/exportFinancialStatementAll?month=' + month);
    }
</script>
</html>
