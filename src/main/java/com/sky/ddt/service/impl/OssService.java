package com.sky.ddt.service.impl;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.internal.Mimetypes;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.sky.ddt.dto.img.response.OssObjectResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.IOssService;
import com.sky.ddt.util.FileCheckUtil;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Random;

/**
 * @author baixueping
 * @description Oss服务
 * @date 2019/12/31 15:45
 */
@Service
public class OssService implements IOssService{
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Value("${aliyun.oss.endpoint}")
    private String endpoint ;
    // accessKey
    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId ;
    @Value("${aliyun.oss.secretAccessKey}")
    private String accessKeySecret;
    // 域名
    @Value("${aliyun.oss.domain}")
    private String domain ;
    // 空间
    @Value("${aliyun.oss.img.bucketName}")
    private String bucketName ;
    // 文件存储目录
    @Value("${aliyun.oss.img.path}")
    private String filedir ;



    @Override
    public BaseResponse<OssObjectResponse> uploadFile(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        String fileExtension = originalFilename.substring(
                originalFilename.lastIndexOf(".")).toLowerCase();
        String name = getFileName(fileExtension);
        try {
            InputStream inputStream = file.getInputStream();
            String key=uploadFile(inputStream, name);
            String imgUrl = getImgUrl(name);
            OssObjectResponse ossObjectResponse=new OssObjectResponse();
            ossObjectResponse.setKey(filedir+ name);
            ossObjectResponse.setUrl(imgUrl);
            return BaseResponse.success("上传成功", ossObjectResponse);
        } catch (Exception e) {
            logger.error("上传失败", e);
            e.printStackTrace();
            return BaseResponse.failMessage("上传失败");
        }
    }

    /**
     * @param file@return
     * @description 导入图片文件
     * @author baixueping
     * @date 2019/4/16 14:35
     */
    @Override
    public BaseResponse<OssObjectResponse> uploadPicFile(MultipartFile file) {
        BaseResponse baseResponse= FileCheckUtil.checkPic(file,50);
        if(!baseResponse.isSuccess()){
            return baseResponse;
        }
        return uploadFile(file);
    }

    /**
     * @param key@return
     * @description 删除
     * @author baixueping
     * @date 2019/4/16 14:35
     */
    @Override
    public BaseResponse deleteObjectByKey(String key) {
        String ret = "";
        // 创建OSSClient实例
        OSSClient ossClient = null;
        ossClient = new OSSClient(endpoint, getAccessKeyId(), getAccessKeySecret());
        ossClient.deleteObject(bucketName, key);
        if (ossClient != null) {
            ossClient.shutdown();
        }
        return BaseResponse.success();
    }

    private String getAccessKeySecret() {
        String res=new String(Base64.getDecoder().decode(accessKeySecret));
        return  res;
    }

    private String getAccessKeyId() {
        String res=new String(Base64.getDecoder().decode(accessKeyId));
        return  res;
    }

    /**
     * @description 获取随机文件名
     * @author baixueping
     * @date 2019/4/16 14:22
     * @param
     * @return
     */
    String getFileName(String fileExtension) {
        Random random = new Random();
        String name = random.nextInt(10000) + System.currentTimeMillis()
                + fileExtension;
        return name;
    }
    /**
     * @description 获取图片链接
     * @author baixueping
     * @date 2019/4/16 14:23
     * @param
     * @return
     */
    String getImgUrl(String name) {
        String imgUrl = domain + filedir + name;
        return imgUrl;
    }


    /**
     * 上传到OSS服务器 如果同名文件会覆盖服务器上的
     *
     * @param instream
     *            文件流
     * @param fileName
     *            文件名称 包括后缀名
     * @return 出错返回"" ,唯一MD5数字签名
     */
    private String uploadFile(InputStream instream, String fileName) {
        String ret = "";
        // 创建OSSClient实例
        OSSClient ossClient = null;
        try {
            ossClient = new OSSClient(endpoint, getAccessKeyId(), getAccessKeySecret());
            // 创建上传Object的Metadata
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(instream.available());
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setHeader("Pragma", "no-cache");
            objectMetadata.setContentType(getcontentType(fileName));
            objectMetadata.setContentDisposition("inline;filename=" + fileName);
            // 上传文件
            PutObjectResult putResult = ossClient.putObject(bucketName, filedir
                    + fileName, instream, objectMetadata);
            ret = putResult.getETag();
        } catch (IOException e) {
            logger.error("上传失败", e);
            e.printStackTrace();
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
            if (instream != null) {
                try {
                    instream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ret;
    }

    String getcontentType(String filename) {
        Mimetypes allTypes = Mimetypes.getInstance();
        String contentType = allTypes.getMimetype(filename);
        if (StringUtils.isEmpty(contentType)) {
            contentType = "application/octet-stream";
        }
        return contentType;
    }
}
