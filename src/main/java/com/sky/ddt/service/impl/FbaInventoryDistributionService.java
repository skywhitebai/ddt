package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.dao.custom.CustomFbaInventoryDistributionMapper;
import com.sky.ddt.dto.fbaInventoryDistribution.req.DownFbaInventoryDistributionReq;
import com.sky.ddt.dto.fbaInventoryDistribution.req.ListFbaInventoryDistributionReq;
import com.sky.ddt.dto.fbaInventoryDistribution.resp.FbaInventoryDistributionExistInfo;
import com.sky.ddt.dto.fbaInventoryDistribution.resp.FulfillmentCenterIdQuantity;
import com.sky.ddt.dto.fbaInventoryDistribution.resp.ListFbaInventoryDistributionResp;
import com.sky.ddt.dto.fbaInventoryDistribution.resp.SkuFulfillmentCenterIdQuantity;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shopSku.response.ShopSkuInfo;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.IFbaInventoryDistributionService;
import com.sky.ddt.service.IShopSkuService;
import com.sky.ddt.util.DateUtil;
import com.sky.ddt.util.ExcelUtil;
import com.sky.ddt.util.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sky
 * @Description fba库存分布
 * @date 2022/4/21 23:27
 */
@Service
public class FbaInventoryDistributionService implements IFbaInventoryDistributionService {
    @Autowired
    CustomFbaInventoryDistributionMapper customFbaInventoryDistributionMapper;
    @Autowired
    IShopSkuService shopSkuService;

    @Override
    public PageInfo<ListFbaInventoryDistributionResp> listFbaInventoryDistribution(ListFbaInventoryDistributionReq params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListFbaInventoryDistributionResp> list = customFbaInventoryDistributionMapper.listFbaInventoryDistribution(params);
        PageInfo<ListFbaInventoryDistributionResp> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public BaseResponse importFbaInventoryDistribution(MultipartFile file, Integer dealUserId) {
        //读取excel 转换为list
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //遍历list导入信息
        StringBuilder sbErro = new StringBuilder();
        Map<String, ShopSkuInfo> shopSkuMap = getShopSkuMap(list);
        String snapshotDate = "";
        Date snapshotDay = null;
        for (int i = 0; i < list.size(); i++) {
            Map<String, String> map = list.get(i);
            //忽略空行
            Boolean isEmpty = true;
            for (String key : map.keySet()) {
                if (!StringUtils.isEmpty(map.get(key))) {
                    isEmpty = false;
                    break;
                }
            }
            if (isEmpty) {
                continue;
            }
            StringBuilder sbErroItem = new StringBuilder();
            if (StringUtils.isEmpty(map.get("snapshot-date"))) {
                sbErroItem.append(",").append("snapshot-date不能为空");
            } else {
                if (StringUtils.isEmpty(snapshotDate)) {
                    if (map.get("snapshot-date").length() < 10) {
                        sbErroItem.append(",").append("snapshot-date格式错误，必须为日期");
                    } else {
                        snapshotDate = map.get("snapshot-date");
                        snapshotDay = DateUtil.strToDate(map.get("snapshot-date").substring(0, 10));
                        if (snapshotDay == null) {
                            sbErroItem.append(",").append("snapshot-date格式错误，必须为日期");
                        }
                    }
                }
            }
            if (StringUtils.isEmpty(map.get("fnsku"))) {
                sbErroItem.append(",").append("fnsku不能为空");
            }
            if (StringUtils.isEmpty(map.get("sku"))) {
                sbErroItem.append(",").append("sku不能为空");
            } else if (shopSkuMap.get(map.get("sku")) == null) {
                sbErroItem.append(",").append("sku[" + map.get("sku") + "]不存在");
            }
            if (StringUtils.isEmpty(map.get("product-name"))) {
                sbErroItem.append(",").append("product-name不能为空");
            }
            if (StringUtils.isEmpty(map.get("quantity"))) {
                sbErroItem.append(",").append("quantity不能为空");
            } else {
                if (MathUtil.isNotInteger(map.get("quantity"))) {
                    sbErroItem.append(",").append("quantity必须位数字");
                }
            }
            if (StringUtils.isEmpty(map.get("fulfillment-center-id"))) {
                sbErroItem.append(",").append("fulfillment-center-id不能为空");
            }
            if (sbErroItem.length() > 0) {
                sbErro.append(",第" + (i + 2) + "行").append(sbErroItem);
            }
        }
        if (sbErro.length() > 0) {
            return BaseResponse.failMessage(sbErro.substring(1));
        }
        //获取历史数据
        Map<String, Integer> fbaInventoryDistributionMap = getfbaInventoryDistributionMap(snapshotDay, list);
        for (Map<String, String> map : list) {
            //忽略空行
            Boolean isEmpty = true;
            for (String key : map.keySet()) {
                if (!StringUtils.isEmpty(map.get(key))) {
                    isEmpty = false;
                    break;
                }
            }
            if (isEmpty) {
                continue;
            }

            FbaInventoryDistribution fbaInventoryDistribution = new FbaInventoryDistribution();
            fbaInventoryDistribution.setSnapshotDay(snapshotDay);
            fbaInventoryDistribution.setSnapshotDate(map.get("snapshot-date"));
            fbaInventoryDistribution.setFnsku(map.get("fnsku"));
            fbaInventoryDistribution.setSku(map.get("sku"));
            fbaInventoryDistribution.setShopId(shopSkuMap.get(map.get("sku")).getShopId());
            fbaInventoryDistribution.setShopSkuId(shopSkuMap.get(map.get("sku")).getShopSkuId());
            fbaInventoryDistribution.setProductName(map.get("product-name"));
            fbaInventoryDistribution.setQuantity(MathUtil.strToInteger(map.get("quantity")));
            fbaInventoryDistribution.setFulfillmentCenterId(map.get("fulfillment-center-id"));
            fbaInventoryDistribution.setDetailedDisposition(map.get("detailed-disposition"));
            fbaInventoryDistribution.setCountry(map.get("country"));
            fbaInventoryDistribution.setId(fbaInventoryDistributionMap.get(map.get("sku")));
            if (fbaInventoryDistribution.getId() != null) {
                fbaInventoryDistribution.setUpdateBy(dealUserId);
                fbaInventoryDistribution.setUpdateTime(new Date());
                customFbaInventoryDistributionMapper.updateByPrimaryKeySelective(fbaInventoryDistribution);
            } else {
                fbaInventoryDistribution.setCreateBy(dealUserId);
                fbaInventoryDistribution.setCreateTime(new Date());
                customFbaInventoryDistributionMapper.insertSelective(fbaInventoryDistribution);
            }
        }
        return BaseResponse.success();
    }

    @Override
    public BaseResponse downFbaInventoryDistribution(DownFbaInventoryDistributionReq params, HttpServletResponse response) {
        if (params == null) {
            return BaseResponse.failMessage("日期不能为空");
        }
        FbaInventoryDistributionExample fbaInventoryDistributionExample = new FbaInventoryDistributionExample();
        fbaInventoryDistributionExample.createCriteria().andSnapshotDayEqualTo(params.getSnapshotDay()).andShopIdEqualTo(params.getShopId());
        List<FbaInventoryDistribution> list = customFbaInventoryDistributionMapper.selectByExample(fbaInventoryDistributionExample);
        if (CollectionUtils.isEmpty(list)) {
            return BaseResponse.failMessage("库位分布信息不存在");
        }
        return exportFbaInventoryDistribution(list, response);
    }

    private BaseResponse exportFbaInventoryDistribution(List<FbaInventoryDistribution> list, HttpServletResponse response) {
        //构建列数据
        Set<String> fulfillmentCenterIdSet = list.stream().map(item -> item.getFulfillmentCenterId()).collect(Collectors.toSet());
        //统计每个库位数量，按数量从多到少排序
        List<FulfillmentCenterIdQuantity> fulfillmentCenterIdQuantityList = getFulfillmentCenterIdQuantityList(list);
        //构建sku及库位信息 Map<Sku,Map<String,Integer>> 排序 数量从多到少排序
        List<SkuFulfillmentCenterIdQuantity> skuFulfillmentCenterIdQuantityList=getSkuFulfillmentCenterIdQuantityList(list);
        //构建excel
        //导出
        return BaseResponse.success();
    }

    private List<SkuFulfillmentCenterIdQuantity> getSkuFulfillmentCenterIdQuantityList(List<FbaInventoryDistribution> list) {
        //先按sku分组，然后求出每组数量，然后排序返回
        Map<String,SkuFulfillmentCenterIdQuantity> map=new HashMap<>();
        for (FbaInventoryDistribution fbaInventoryDistribution :
                list) {
            SkuFulfillmentCenterIdQuantity skuFulfillmentCenterIdQuantity = map.get(fbaInventoryDistribution.getSku());
            if(skuFulfillmentCenterIdQuantity==null){
                skuFulfillmentCenterIdQuantity=new SkuFulfillmentCenterIdQuantity();
                skuFulfillmentCenterIdQuantity.setFulfillmentCenterIdQuantityList(new ArrayList<>());
            }
            //设置总数
            skuFulfillmentCenterIdQuantity.setQuantity(MathUtil.addInteger(skuFulfillmentCenterIdQuantity.getQuantity(), fbaInventoryDistribution.getQuantity()));
            skuFulfillmentCenterIdQuantity.getFulfillmentCenterIdQuantityList().add(getFulfillmentCenterIdQuantity(fbaInventoryDistribution));
            map.put(fbaInventoryDistribution.getFulfillmentCenterId(), skuFulfillmentCenterIdQuantity);
        }
        List<SkuFulfillmentCenterIdQuantity> skuFulfillmentCenterIdQuantityList=map.values().stream().sorted((a1,a2)->{return a1.getQuantity()-a2.getQuantity();}).collect(Collectors.toList());
        return skuFulfillmentCenterIdQuantityList;
    }

    private FulfillmentCenterIdQuantity getFulfillmentCenterIdQuantity(FbaInventoryDistribution fbaInventoryDistribution) {
        FulfillmentCenterIdQuantity fulfillmentCenterIdQuantity=new FulfillmentCenterIdQuantity();
        fulfillmentCenterIdQuantity.setFulfillmentCenterId(fbaInventoryDistribution.getFulfillmentCenterId());;
        fulfillmentCenterIdQuantity.setQuantity(fbaInventoryDistribution.getQuantity());
        return fulfillmentCenterIdQuantity;
    }

    private List<FulfillmentCenterIdQuantity> getFulfillmentCenterIdQuantityList(List<FbaInventoryDistribution> list) {
        Map<String, FulfillmentCenterIdQuantity> map = new HashMap<>();
        for (FbaInventoryDistribution fbaInventoryDistribution :
                list) {
            FulfillmentCenterIdQuantity fulfillmentCenterIdQuantity = map.getOrDefault(fbaInventoryDistribution.getFulfillmentCenterId(), new FulfillmentCenterIdQuantity());
            fulfillmentCenterIdQuantity.setQuantity(MathUtil.addInteger(fulfillmentCenterIdQuantity.getQuantity(), fbaInventoryDistribution.getQuantity()));
            map.put(fbaInventoryDistribution.getFulfillmentCenterId(), fulfillmentCenterIdQuantity);
        }
        List<FulfillmentCenterIdQuantity> fulfillmentCenterIdQuantityList=map.values().stream().sorted((a1,a2)->{return a1.getQuantity()-a2.getQuantity();}).collect(Collectors.toList());
        return fulfillmentCenterIdQuantityList;
    }

    private Map<String, Integer> getfbaInventoryDistributionMap(Date snapshotDay, List<Map<String, String>> list) {
        List<FbaInventoryDistributionExistInfo> fbaInventoryDistributionExistInfoList = customFbaInventoryDistributionMapper.listFbaInventoryDistributionExist(snapshotDay, list);
        if (CollectionUtils.isEmpty(fbaInventoryDistributionExistInfoList)) {
            return new HashMap<>();
        }
        Map<String, Integer> fbaInventoryDistributionMap = new HashMap<>();
        for (FbaInventoryDistributionExistInfo fbaInventoryDistributionExistInfo : fbaInventoryDistributionExistInfoList) {
            fbaInventoryDistributionMap.put(fbaInventoryDistributionExistInfo.getSku(), fbaInventoryDistributionExistInfo.getId());
        }
        return fbaInventoryDistributionMap;
    }

    private Map<String, ShopSkuInfo> getShopSkuMap(List<Map<String, String>> list) {
        Map<String, ShopSkuInfo> shopSkuMap = new HashMap<>();
        List<String> shopSkuList = list.stream().map(item -> item.get("sku")).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(shopSkuList)) {
            return shopSkuMap;
        }
        shopSkuMap = shopSkuService.getShopSkuInfoMap(shopSkuList);
        return shopSkuMap;
    }

    private FbaInventoryDistributionExample buildFbaInventoryDistributionExample(ListFbaInventoryDistributionReq params) {
        FbaInventoryDistributionExample fbaInventoryDistributionExample = new FbaInventoryDistributionExample();
        FbaInventoryDistributionExample.Criteria criteria = fbaInventoryDistributionExample.createCriteria();
        if (params.getSnapshotDay() != null) {
            criteria.andSnapshotDayEqualTo(params.getSnapshotDay());
        }
        if (params.getFnsku() != null) {
            criteria.andFnskuLike(params.getFnsku());
        }
        if (params.getProductName() != null) {
            criteria.andProductNameLike(params.getProductName());
        }
        if (params.getFulfillmentCenterId() != null) {
            criteria.andFulfillmentCenterIdLike(params.getFulfillmentCenterId());
        }
        if (params.getDetailedDisposition() != null) {
            criteria.andDetailedDispositionLike(params.getDetailedDisposition());
        }
        fbaInventoryDistributionExample.setOrderByClause("snapshot_day desc,sku asc");
        return fbaInventoryDistributionExample;
    }
}
