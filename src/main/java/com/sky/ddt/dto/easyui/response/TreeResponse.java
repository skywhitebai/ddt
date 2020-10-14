package com.sky.ddt.dto.easyui.response;

import lombok.Data;

import java.util.List;

/**
 * @author baixueping
 * @description  树
 * @date 2019/6/21 16:57
 */
@Data
public class TreeResponse {
    Integer id;
    String text;
    String state;
    List<TreeResponse> children;
}
