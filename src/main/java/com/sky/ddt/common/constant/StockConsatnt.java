package com.sky.ddt.common.constant;

import com.sky.ddt.common.excel.ExcelField;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baixueping
 * @description 备货信息
 * @date 2019/8/21 14:54
 */
public class StockConsatnt {
    public static final String SHOP_ID_EMPTY = "店铺id不能为空";
    public static final String SHOP_SKU_ID_EMPTY = "shopSkuId不能为空";
    public static final String STOCK_QUANTITY_ERRO = "补货数量必须大于等于0";
    public static final String SHOP_SKU_ID_NOT_EXIST = "shopSkuId不存在";
    public static final String TYPE_EERO = "请选择正确的补货类型";
    public static final String PRODUCTION_QUANTITY_ERRO = "生产数量必须大于等于0";

    public enum StockQuantityTypeEnum {
        KY("ky"),
        KP("kp"),
        HY("hy"),
        HY2("hy2"),
        DL("dl"),
        DLX("dlx"),
        AMHY("amhy"),
        AMTY("amty"),
        ;
        String type;

        public String getType() {
            return type;
        }

        StockQuantityTypeEnum(String type) {
            this.type = type;
        }

        public static StockQuantityTypeEnum getStockQuantityTypeEnum(String type) {
            StockQuantityTypeEnum[] stockQuantityTypeEnums = StockQuantityTypeEnum.values();
            for (StockQuantityTypeEnum stockQuantityTypeEnum : stockQuantityTypeEnums) {
                if (stockQuantityTypeEnum.getType().equals(type)) {
                    return stockQuantityTypeEnum;
                }
            }
            return null;
        }
    }

    @Getter
    public enum TypeEnum {
        REPLENISHMENT(1, "补货"),
        FACTORY_PRODUCTION(2, "工厂生产单");
        Integer type;
        String typeName;

        TypeEnum(Integer type, String typeName) {
            this.type = type;
            this.typeName = typeName;
        }
    }

    public static List<ExcelField> exportStockFieldList = new ArrayList<>();

    static {
        exportStockFieldList.add(new ExcelField("shopName", "店铺名", ExcelField.FieldTypeEnum.STRING));
        exportStockFieldList.add(new ExcelField("sku", "产品sku", ExcelField.FieldTypeEnum.STRING));
        exportStockFieldList.add(new ExcelField("shopSku", "店铺sku", ExcelField.FieldTypeEnum.STRING));
        exportStockFieldList.add(new ExcelField("shopParentSku", "店铺父sku", ExcelField.FieldTypeEnum.STRING));
        exportStockFieldList.add(new ExcelField("salesForTheLast7Days", "7天实销", ExcelField.FieldTypeEnum.NUMBER));
        exportStockFieldList.add(new ExcelField("salesForTheLast14Days", "14天实销", ExcelField.FieldTypeEnum.NUMBER));
        exportStockFieldList.add(new ExcelField("salesForTheLast35Days", "35天实销", ExcelField.FieldTypeEnum.NUMBER));
        exportStockFieldList.add(new ExcelField("itemPrice30", "30天售价", ExcelField.FieldTypeEnum.NUMBER));
        exportStockFieldList.add(new ExcelField("salesForTheLastYear90Days", "去年90天销量", ExcelField.FieldTypeEnum.NUMBER));
        exportStockFieldList.add(new ExcelField("estimateAverageDailySales", "预计日均销量", ExcelField.FieldTypeEnum.NUMBER));
        exportStockFieldList.add(new ExcelField("afnFulfillableQuantity", "fba可售库存", ExcelField.FieldTypeEnum.NUMBER));
        exportStockFieldList.add(new ExcelField("ableCanSaleDay", "当前库存周转", ExcelField.FieldTypeEnum.NUMBER));
        exportStockFieldList.add(new ExcelField("onTheWayQuantity", "在途", ExcelField.FieldTypeEnum.NUMBER));
        exportStockFieldList.add(new ExcelField("sendQuantity", "发送中数量", ExcelField.FieldTypeEnum.NUMBER));
        exportStockFieldList.add(new ExcelField("fbaTotalCanSaleQuantity", "fba总可售库存", ExcelField.FieldTypeEnum.NUMBER));
        exportStockFieldList.add(new ExcelField("estimateCanSaleDay", "预计总可售天数", ExcelField.FieldTypeEnum.NUMBER));
        exportStockFieldList.add(new ExcelField("replenishQuantity28Days", "28天建议补货", ExcelField.FieldTypeEnum.NUMBER));
        exportStockFieldList.add(new ExcelField("replenishQuantity42Days", "42天建议补货", ExcelField.FieldTypeEnum.NUMBER));
        exportStockFieldList.add(new ExcelField("replenishQuantity56Days", "56天建议补货", ExcelField.FieldTypeEnum.NUMBER));
        exportStockFieldList.add(new ExcelField("replenishQuantity90Days", "90天建议补货", ExcelField.FieldTypeEnum.NUMBER));
        exportStockFieldList.add(new ExcelField("stockQuantityKy", "空运补货", ExcelField.FieldTypeEnum.NUMBER));
        exportStockFieldList.add(new ExcelField("stockQuantityKp", "42天建议补货", ExcelField.FieldTypeEnum.NUMBER));
        exportStockFieldList.add(new ExcelField("replenishQuantity42Days", "空派补货", ExcelField.FieldTypeEnum.NUMBER));
        exportStockFieldList.add(new ExcelField("stockQuantityHy", "海运补货", ExcelField.FieldTypeEnum.NUMBER));
        exportStockFieldList.add(new ExcelField("estimateProductionQuantity", "预计生产数量", ExcelField.FieldTypeEnum.NUMBER));
        exportStockFieldList.add(new ExcelField("stockRemark", "备注", ExcelField.FieldTypeEnum.STRING));
        exportStockFieldList.add(new ExcelField("productionQuantity", "实际生产数量", ExcelField.FieldTypeEnum.NUMBER));
        exportStockFieldList.add(new ExcelField("inventoryQuantityWarehouse", "其他仓库库存", ExcelField.FieldTypeEnum.NUMBER));
        exportStockFieldList.add(new ExcelField("produceOrderShopSkuProductionQuantityWarehouse", "其他仓库生产中数量", ExcelField.FieldTypeEnum.NUMBER));
        exportStockFieldList.add(new ExcelField("stockQuantity", "补货数量", ExcelField.FieldTypeEnum.NUMBER));
        exportStockFieldList.add(new ExcelField("salesmanRealName", "销售负责人", ExcelField.FieldTypeEnum.STRING));
        exportStockFieldList.add(new ExcelField("createTime", "设置时间", ExcelField.FieldTypeEnum.DATE_TIME));
        exportStockFieldList.add(new ExcelField("updateTime", "修改时间", ExcelField.FieldTypeEnum.DATE_TIME));
    }
}
