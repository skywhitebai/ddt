package com.sky.ddt.common.constant;

import lombok.Getter;

/**
 * @author baixueping
 * @description 图片
 * @date 2019/7/23 10:38
 */
public class ImgConstant {
    public static final String ENTITY_ID_EMPTY ="实体id不能为空" ;
    public static final String IMG_TYPE_EMPTY = "图片类型不能为空" ;
    public static final String IMG_FILE_EMPTY ="图片不能为空" ;
    public static final String IMG_READ_FAIL = "图片读取失败";
    public static final long IMG_MAX_SIZE =5;
    public final static String FILE_EMPTY="文件不能为空";
    public final static String FILE_MAX_ERRO="文件不能超过";
    public final static String FILE_TYPE_ERRO="文件类型错误";
    public static final String IMG_TYPE_NOT_EXIST ="图片类型错误" ;

    @Getter
   public enum ImgTypeEnum {
        SKU_IMG("sku.sku_img"),
        PRODUCTDEVELOP_IMG("product_develop.img");
        String imgType;

        ImgTypeEnum(String imgType) {
            this.imgType = imgType;
        }

        public static boolean contains(String imgType) {
            for (ImgTypeEnum imgTypeEnum : ImgTypeEnum.values()) {
                if (imgTypeEnum.getImgType().equals(imgType)) {
                    return true;
                }
            }
            return false;
        }
    }
}
