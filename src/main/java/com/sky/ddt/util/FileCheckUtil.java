package com.sky.ddt.util;
import com.sky.ddt.common.constant.ImgConstant;
import com.sky.ddt.dto.response.BaseResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

/**
 * @author baixueping
 * @description FileCheckUtil
 * @date 2019/4/16 14:31
 */
public class FileCheckUtil {
    private static final String[] PICTYPE = {"image/x-png","image/png","image/gif","image/jpeg","image/pjpeg"};

    /**
     * 检查MultipartFile
     */
    public static BaseResponse checkPic(MultipartFile mulFile, long maxFileSize) {
        return checkMultipartFile(mulFile, PICTYPE, maxFileSize);
    }

    /**
     * 检查MultipartFile
     */
    public static BaseResponse checkFile(MultipartFile mulFile, long maxFileSize) {
        return checkMultipartFile(mulFile, null, maxFileSize);
    }

    /**
     * 检查MultipartFile
     */
    public static BaseResponse checkMultipartFile(MultipartFile mulFile, String[] type, long maxFileSize) {

        // 检测文件是否存在
        if (mulFile == null) {
            return BaseResponse.failMessage(ImgConstant.FILE_EMPTY);
        }
        String fileName = mulFile.getOriginalFilename();
        if (fileName.trim() == "") {
            return BaseResponse.failMessage(ImgConstant.FILE_EMPTY);
        }

        // 检测类型
        String contentType = mulFile.getContentType();
        if (type!=null && !Arrays.asList(type).contains(contentType)) {
            return BaseResponse.failMessage( ImgConstant.FILE_TYPE_ERRO);
        }

        // 检测大小
        long fileSize = mulFile.getSize();
        long maxFileSizeTemp = maxFileSize * 1024 * 1024;
        if (fileSize > maxFileSizeTemp || fileSize <= 0) {
            return BaseResponse.failMessage(ImgConstant.FILE_MAX_ERRO + maxFileSize + "M");
        }
        return BaseResponse.success();
    }
}
