package com.sky.ddt.common.constant;

import com.sky.ddt.common.excel.ExcelField;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baixueping
 * @description 内部单号静态类
 * @date 2020/6/30 15:11
 */
public class InternalOrderNumberConstant {

    public static final String NUMBER_ERRO ="数量必须为大于0的整数";
    public static final String REMARK_TOO_LONG ="备注长度不能超过200";
    public static final String NUMBER_EMPTY ="数量不能为空" ;
    public static final String ID_NOT_EXIST ="id不存在" ;
    public static final String ID_EMPTY ="id不能为空" ;
    public static final String TRANSPORT_TYPE_ID_EMPTY ="物流渠道id不能为空" ;
    public static final String TRANSPORT_TYPE_ID_NOT_EXIST ="物流渠道id不存在" ;
    public static final String FINANCIAL_REMARK_TOO_LONG ="财务备注长度不能超过200";
    public static final String PAY_AMOUNT_NULL ="实付金额不能为空" ; ;
    public static final String PAY_AMOUNT_ERRO ="实付金额必须大于0的两位小数" ;
    public static List<ExcelField> exportInternalOrderNumberFieldList=new ArrayList<>();
    static {
        exportInternalOrderNumberFieldList.add(new ExcelField("orderNumber", "单号", ExcelField.FieldTypeEnum.STRING));
        exportInternalOrderNumberFieldList.add(new ExcelField("number", "数量", ExcelField.FieldTypeEnum.STRING));
        exportInternalOrderNumberFieldList.add(new ExcelField("payAmount", "实付金额", ExcelField.FieldTypeEnum.NUMBER));
        exportInternalOrderNumberFieldList.add(new ExcelField("theoreticalAmount", "理论金额", ExcelField.FieldTypeEnum.NUMBER));
        exportInternalOrderNumberFieldList.add(new ExcelField("differenceAmount", "差额（理论-实付）", ExcelField.FieldTypeEnum.NUMBER));
        exportInternalOrderNumberFieldList.add(new ExcelField("transportTypeName", "物流渠道", ExcelField.FieldTypeEnum.STRING));
        exportInternalOrderNumberFieldList.add(new ExcelField("totalWeight", "重量kg", ExcelField.FieldTypeEnum.NUMBER));
        exportInternalOrderNumberFieldList.add(new ExcelField("remark", "备注", ExcelField.FieldTypeEnum.STRING));
        exportInternalOrderNumberFieldList.add(new ExcelField("financialRemark", "财务备注", ExcelField.FieldTypeEnum.STRING));
        exportInternalOrderNumberFieldList.add(new ExcelField("createTime", "创建时间", ExcelField.FieldTypeEnum.DATE_TIME));
    }

}
