package com.sky.ddt.dto.productDevelop.response;

import com.sky.ddt.entity.ProductDevelop;
import lombok.Data;

/**
 * @author sky
 * @Description TODO
 * @date 2021/9/1 21:55
 */
@Data
public class ListProductDevelopResponse extends ProductDevelop {
    //图片
    String imgUrl;
    //开发人员名称
    String developerUserName;
}
