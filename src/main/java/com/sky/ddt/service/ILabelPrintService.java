package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.labelPrint.request.LabelPrintListRequest;
import com.sky.ddt.dto.labelPrint.request.SaveLabelPrintRemarkRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.LabelPrint;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author baixueping
 * @description 标签打印
 * @date 2020/2/27 17:23
 */
public interface ILabelPrintService {
    /**
     * @param
     * @return
     * @description 分页查询标签打印
     * @author baixueping
     * @date 2020/2/28 10:47
     */
    PageInfo<LabelPrint> list(LabelPrintListRequest params);

    /**
     * @param
     * @return
     * @description 导入标签打印信息
     * @author baixueping
     * @date 2020/2/28 11:31
     */
    BaseResponse importLabelPrint(MultipartFile file, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 保存标签打印备注
     * @author baixueping
     * @date 2020/4/20 10:50
     */
    BaseResponse saveLabelPrintRemark(SaveLabelPrintRemarkRequest params, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 获取标签打印信息
     * @author baixueping
     * @date 2020/5/18 12:19
     */
    LabelPrint getLabelPrint(Integer labelPrintId);
}
