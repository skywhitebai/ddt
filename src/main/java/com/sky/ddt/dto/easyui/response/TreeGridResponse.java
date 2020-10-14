package com.sky.ddt.dto.easyui.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baixueping
 * @description 树表
 * @date 2019/6/18 18:54
 */
@Data
public class TreeGridResponse<T> {
    Long total;
    List<T> rows;
}
