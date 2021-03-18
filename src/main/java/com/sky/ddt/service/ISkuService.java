package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.sku.request.GetPrintTmallSkuRequest;
import com.sky.ddt.dto.sku.request.SkuListRequest;
import com.sky.ddt.dto.sku.request.SkuSaveRequest;
import com.sky.ddt.dto.sku.response.SkuExportInfoResponse;
import com.sky.ddt.dto.sku.response.SkuListResponse;
import com.sky.ddt.entity.Sku;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author baixueping
 * @description sku服务类
 * @date 2019/5/10 9:11
 */
public interface ISkuService {
    /**
     * @param
     * @return
     * @description 列表显示sku信息
     * @author baixueping
     * @date 2019/5/10 9:22
     */
    PageInfo<SkuListResponse> list(SkuListRequest params);

    /**
     * 导入sku数据
     *
     * @param file
     * @param dealUserId
     * @return
     */
    BaseResponse importSku(MultipartFile file, Integer dealUserId);

    /**
     * 修改sku信息
     *
     * @param params
     * @param dealUserId
     * @return
     */
    BaseResponse save(SkuSaveRequest params, Integer dealUserId);

    /**
     * 查询下载的sku信息
     *
     * @param params
     * @return
     */
    List<SkuExportInfoResponse> listSkuExportInfo(SkuListRequest params);

    /**
     * 刪除sku
     *
     * @param skuIds
     * @return
     */
    BaseResponse delete(List<Integer> skuIds);

    /**
     * @param
     * @return
     * @description 通过商品id删除sku
     * @author baixueping
     * @date 2019/7/24 10:55
     */
    BaseResponse deleteByProductIds(List<Integer> productIds);

    /**
     * @param
     * @return
     * @description 获取sku
     * @author baixueping
     * @date 2019/7/29 14:21
     */
    Sku getSkuBySku(String sku);

    /**
     * @param
     * @return
     * @description 导入仓库库存
     * @author baixueping
     * @date 2019/8/15 17:12
     */
    BaseResponse importInventory(MultipartFile file, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 根据id获取sku信息
     * @author baixueping
     * @date 2019/9/11 10:04
     */
    Sku getSku(Integer skuId);

    /**
     * @param
     * @return
     * @description 导入成本价
     * @author baixueping
     * @date 2019/12/27 9:40
     */
    BaseResponse importCostPrice(MultipartFile file, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 导入重量
     * @author baixueping
     * @date 2019/12/27 9:40
     */
    BaseResponse importWeight(MultipartFile file, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 导入天猫标签信息
     * @author baixueping
     * @date 2020/4/30 16:39
     */
    BaseResponse importTmallInfo(MultipartFile file, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 获取天猫打印sku信息
     * @author baixueping
     * @date 2020/4/30 17:09
     */
    BaseResponse getPrintTmallSku(GetPrintTmallSkuRequest params);

    /**
     * @param
     * @return
     * @description 导入颜色色号
     * @author baixueping
     * @date 2020/6/23 10:52
     */
    BaseResponse importColour(MultipartFile file, Integer dealUserId);

    boolean existSku(List<Integer> productIds);

    /**
     * @param
     * @return
     * @description 导入开发等级
     * @author baixueping
     * @date 2021/3/18 10:49
     */
    BaseResponse importDevelopmentLevel(MultipartFile file, Integer dealUserId);
}
