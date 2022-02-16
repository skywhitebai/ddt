package com.sky.ddt.common.constant;

import lombok.Getter;

/**
 * @author sky
 * @Description 文件静态类
 * @date 2021/9/6 22:15
 */
public class FileConstant {
    public static final String ENTITY_ID_EMPTY ="实体id不能为空" ;
    public static final String FILE_TYPE_EMPTY = "文件类型不能为空" ;
    public static final String FILE_FILE_EMPTY ="文件不能为空" ;
    public static final String FILE_READ_FAIL = "文件读取失败";
    public static final long FILE_MAX_SIZE =50 ;
    public final static String FILE_EMPTY="文件不能为空";
    public final static String FILE_MAX_ERRO="文件不能超过";
    public final static String FILE_TYPE_ERRO="文件类型错误";
    public static final String FILE_TYPE_NOT_EXIST ="文件类型错误" ;

    @Getter
    public enum FileTypeEnum {
        PRODUCT_DEVELOP_FILE("product_develop.file"),
        FINANCIAL_DOCUMENT_FILE("financial_document.file");
        String fileType;

        FileTypeEnum(String fileType) {
            this.fileType = fileType;
        }

        public static boolean contains(String fileType) {
            for (FileConstant.FileTypeEnum fileTypeEnum : FileConstant.FileTypeEnum.values()) {
                if (fileTypeEnum.getFileType().equals(fileType)) {
                    return true;
                }
            }
            return false;
        }
    }
}
