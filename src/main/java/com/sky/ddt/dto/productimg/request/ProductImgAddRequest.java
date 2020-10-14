package com.sky.ddt.dto.productimg.request;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductImgAddRequest {
    Integer productId;
    MultipartFile imgFile;
}
