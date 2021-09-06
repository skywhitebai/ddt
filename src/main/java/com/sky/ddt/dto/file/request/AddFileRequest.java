package com.sky.ddt.dto.file.request;

import com.sky.ddt.common.constant.FileConstant;
import com.sky.ddt.common.constant.ImgConstant;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

/**
 * @author sky
 * @Description 添加文件入参
 * @date 2021/9/6 22:14
 */
@Data
public class AddFileRequest {
    @NotNull(message = FileConstant.ENTITY_ID_EMPTY)
    Integer entityId;
    @NotBlank(message = FileConstant.FILE_TYPE_EMPTY)
    String fileType;
    @NotNull(message = FileConstant.FILE_EMPTY)
    MultipartFile file;
}
