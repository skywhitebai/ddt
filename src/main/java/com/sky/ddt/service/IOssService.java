package com.sky.ddt.service;

import com.sky.ddt.dto.img.response.OssObjectResponse;
import com.sky.ddt.dto.response.BaseResponse;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author baixueping
 * @description oss服务
 * @date 2019/12/31 15:44
 */
public interface IOssService {
    /**
     * @param
     * @return
     * @author baixueping
     * @date 2019/4/16 14:22
     */
    public BaseResponse uploadFile(MultipartFile file);

    /**
     * @param
     * @return
     * @description 导入图片文件
     * @author baixueping
     * @date 2019/4/16 14:35
     */
    BaseResponse<OssObjectResponse> uploadPicFile(MultipartFile file);
    /**
     * @param
     * @return
     * @description 删除
     * @author baixueping
     * @date 2019/4/16 14:35
     */
    BaseResponse deleteObjectByKey(String key);
}
