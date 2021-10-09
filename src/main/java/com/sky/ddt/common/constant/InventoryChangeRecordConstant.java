package com.sky.ddt.common.constant;

import com.sky.ddt.common.excel.ExcelField;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baixueping
 * @description 库存记录变更静态类
 * @date 2020/5/7 16:48
 */
public class InventoryChangeRecordConstant {
    public static List<ExcelField> exportInventoryChangeRecordFieldList=new ArrayList<>();
    static {
        exportInventoryChangeRecordFieldList.add(new ExcelField("shopName", "店铺名", ExcelField.FieldTypeEnum.STRING));
        exportInventoryChangeRecordFieldList.add(new ExcelField("shopSku", "店铺sku", ExcelField.FieldTypeEnum.STRING));
        exportInventoryChangeRecordFieldList.add(new ExcelField("sku", "产品sku", ExcelField.FieldTypeEnum.STRING));
        exportInventoryChangeRecordFieldList.add(new ExcelField("changeTypeName", "变更类型", ExcelField.FieldTypeEnum.STRING));
        exportInventoryChangeRecordFieldList.add(new ExcelField("batchNumber", "批号", ExcelField.FieldTypeEnum.STRING));
        exportInventoryChangeRecordFieldList.add(new ExcelField("inventoryQuantityOld", "变更前库存", ExcelField.FieldTypeEnum.NUMBER));
        exportInventoryChangeRecordFieldList.add(new ExcelField("modifiedQuantity", "变更值", ExcelField.FieldTypeEnum.NUMBER));
        exportInventoryChangeRecordFieldList.add(new ExcelField("inventoryQuantityNew", "变更后库存", ExcelField.FieldTypeEnum.NUMBER));
        exportInventoryChangeRecordFieldList.add(new ExcelField("createByRealName", "变更人", ExcelField.FieldTypeEnum.STRING));
        exportInventoryChangeRecordFieldList.add(new ExcelField("remark", "备注", ExcelField.FieldTypeEnum.STRING));
        exportInventoryChangeRecordFieldList.add(new ExcelField("createTime", "创建时间", ExcelField.FieldTypeEnum.DATE_TIME));
        exportInventoryChangeRecordFieldList.add(new ExcelField("updateTime", "修改时间", ExcelField.FieldTypeEnum.DATE_TIME));
    }
    @Getter
    public enum ChangeTypeEnum {
        WAREHOUSING(1,"入库"),
        CHECK(2,"盘点"),
        OUT_BOUND(3,"出库"),
        TRANSFER_FROM(4,"调拨调出"),
        TRANSFER_TO(5,"调拨调入"),;
        Integer changeType;
        String changeTypeName;

        ChangeTypeEnum(Integer changeType, String changeTypeName) {
            this.changeType = changeType;
            this.changeTypeName = changeTypeName;
        }
        public static String getChangeTypeName(Integer status) {
            for (ChangeTypeEnum changeTypeEnum : ChangeTypeEnum.values()) {
                if (changeTypeEnum.getChangeType().equals(status)) {
                    return changeTypeEnum.changeTypeName;
                }
            }
            return null;
        }
    }
}
