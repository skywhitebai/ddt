package com.sky.ddt.dto.img.request;

import com.sky.ddt.common.constant.ImgConstant;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 添加图片入参
 * @date 2019/7/23 10:37
 */
@Data
public class AddImgRequest {
    @NotNull(message = ImgConstant.ENTITY_ID_EMPTY)
    Integer entityId;
    @NotBlank(message = ImgConstant.IMG_TYPE_EMPTY)
    String imgType;
    @NotNull(message = ImgConstant.IMG_FILE_EMPTY)
    MultipartFile imgFile;
}
