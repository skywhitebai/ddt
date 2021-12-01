package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.ImgConstant;
import com.sky.ddt.common.constant.SkuConstant;
import com.sky.ddt.common.constant.SkuCostPriceHisConstant;
import com.sky.ddt.common.constant.SkuWeightHisConstant;
import com.sky.ddt.dao.custom.CustomShopSkuMapper;
import com.sky.ddt.dao.custom.CustomSkuMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.sku.request.GetPrintTmallSkuRequest;
import com.sky.ddt.dto.sku.request.SkuListRequest;
import com.sky.ddt.dto.sku.request.SkuSaveRequest;
import com.sky.ddt.dto.sku.response.GetPrintTmallSkuResponse;
import com.sky.ddt.dto.sku.response.SkuExportInfoResponse;
import com.sky.ddt.dto.sku.response.SkuListResponse;
import com.sky.ddt.entity.Product;
import com.sky.ddt.entity.Sku;
import com.sky.ddt.entity.SkuExample;
import com.sky.ddt.service.*;
import com.sky.ddt.util.ExcelUtil;
import com.sky.ddt.util.MathUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author baixueping
 * @description sku服务类
 * @date 2019/5/10 9:11
 */
@Service
public class SkuService implements ISkuService {
    @Autowired
    CustomSkuMapper customSkuMapper;
    @Autowired
    IProductService productService;
    @Autowired
    IImgService imgService;
    @Autowired
    ISkuCostPriceHisService skuCostPriceHisService;
    @Autowired
    ISkuWeightHisService skuWeightHisService;
    @Autowired
    IShopSkuService shopSkuService;
    @Autowired
    CustomShopSkuMapper customShopSkuMapper;

    /**
     * @param params
     * @return
     * @description 列表显示sku信息
     * @author baixueping
     * @date 2019/5/10 9:22
     */
    @Override
    public PageInfo<SkuListResponse> list(SkuListRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<SkuListResponse> list = customSkuMapper.listSku(params);
        for (SkuListResponse skuListResponse :
                list) {
            String imgUrl = imgService.getImgUrlBySkuId(skuListResponse.getSkuId());
            if (!StringUtils.isEmpty(imgUrl)) {
                skuListResponse.setImgUrl(imgUrl);
            }
            /*Integer inventoryQuantity = shopSkuService.getSkuInventoryQuantity(skuListResponse.getSkuId());
            skuListResponse.setInventoryQuantity(inventoryQuantity);*/
        }
        PageInfo<SkuListResponse> page = new PageInfo<SkuListResponse>(list);
        return page;
    }

    /**
     * 导入sku数据
     *
     * @param file
     * @param dealUserId
     * @return
     */
    @Override
    public BaseResponse importSku(MultipartFile file, Integer dealUserId) {
        if (file == null) {
            return BaseResponse.failMessage("请选择要上传的文件");
        }
        //读取excel 转换为list
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //遍历list导入信息
        StringBuilder sbErro = new StringBuilder();
        Map<String, String> productMap = new HashMap<>();
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
            String productCode = map.get("产品编码");
            if (StringUtils.isEmpty(productCode)) {
                sbErroItem.append(",").append(SkuConstant.PRODUCT_CODE_EMPTY);
            } else {
                //获取产品id
                if (productMap.containsKey(productCode)) {
                    String productId = productMap.get(productCode);
                    if (StringUtils.isEmpty(productId)) {
                        sbErroItem.append(",").append(SkuConstant.PRODUCT_CODE_NOT_EXIST);
                    } else {
                        map.put("productId", productId);
                    }
                } else {
                    Product product = productService.getProductByProductCode(map.get("产品编码"));
                    if (product == null) {
                        sbErroItem.append(",").append(SkuConstant.PRODUCT_CODE_NOT_EXIST);
                    } else {
                        String productId = product.getProductId().toString();
                        productMap.put(productCode, productId);
                        map.put("productId", productId);
                    }
                }
            }
            if (StringUtils.isEmpty(map.get("sku"))) {
                sbErroItem.append(",").append(SkuConstant.SKU_EMPTY);
            }
            if (StringUtils.isEmpty(map.get("颜色"))) {
                sbErroItem.append(",").append(SkuConstant.COLOR_EMPTY);
            }
            if (StringUtils.isEmpty(map.get("尺码"))) {
                sbErroItem.append(",").append(SkuConstant.SIZE_EMPTY);
            } else if (!SkuConstant.SkuSizeEnum.containSize(map.get("尺码").toUpperCase())) {
                sbErroItem.append(",").append(SkuConstant.SIZE_ERRO);
            }
            if (StringUtils.isEmpty(map.get("重量"))) {
                sbErroItem.append(",").append(SkuConstant.WEIGHT_EMPTY);
            } else {
                Double weight = MathUtil.strToDouble(map.get("重量"));
                if (weight == null || weight <= 0) {
                    sbErroItem.append(",").append(SkuConstant.WEIGHT_ERRO);
                }
            }
            if (StringUtils.isEmpty(map.get("成本价"))) {
                sbErroItem.append(",").append(SkuConstant.COST_PRICE_EMPTY);
            } else {
                BigDecimal costPrice = MathUtil.strToBigDecimal(map.get("成本价"));
                if (costPrice == null || costPrice.compareTo(BigDecimal.ZERO) <= 0) {
                    sbErroItem.append(",").append(SkuConstant.COST_PRICE_ERRO);
                }
            }
            if (sbErroItem.length() > 0) {
                sbErro.append(",第" + (i + 2) + "行").append(sbErroItem);
            }
        }
        if (sbErro.length() > 0) {
            return BaseResponse.failMessage(sbErro.substring(1));
        }
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

            Sku skuOld = getSkuBySku(map.get("sku"));
            if (skuOld != null) {
                Sku sku = new Sku();
                BeanUtils.copyProperties(skuOld, sku);
                setSkuByMap(map, sku);
                sku.setUpdateBy(dealUserId);
                sku.setUpdateTime(new Date());
                customSkuMapper.updateByPrimaryKeySelective(sku);
                skuCostPriceHisService.saveSkuCostPriceHis(sku.getSkuId(), skuOld.getCostPrice(), sku.getCostPrice(), SkuCostPriceHisConstant.TypeEnum.IMPORT_SKU, dealUserId);
                skuWeightHisService.saveSkuWeightHis(skuOld, sku, SkuWeightHisConstant.WeightHisTypeEnum.SAVE, dealUserId);
            } else {
                Sku sku = new Sku();
                setSkuByMap(map, sku);
                sku.setCreateBy(dealUserId);
                sku.setCreateTime(new Date());
                customSkuMapper.insertSelective(sku);
                skuCostPriceHisService.saveSkuCostPriceHis(sku.getSkuId(), null, sku.getCostPrice(), SkuCostPriceHisConstant.TypeEnum.IMPORT_SKU, dealUserId);
                skuWeightHisService.saveSkuWeightHis(skuOld, sku, SkuWeightHisConstant.WeightHisTypeEnum.SAVE, dealUserId);
                customShopSkuMapper.insertWarehouseShopSku(sku);
            }
        }
        return BaseResponse.success();
    }

    private void setSkuByMap(Map<String, String> map, Sku sku) {
        sku.setSku(map.get("sku"));
        sku.setProductId(MathUtil.strToInteger(map.get("productId")));
        sku.setColour(map.get("颜色"));
        sku.setColourNumber(map.get("色号"));
        sku.setSize(map.get("尺码").toUpperCase());
        sku.setWeight(MathUtil.strToBigDecimal(map.get("重量")));
        sku.setCostPrice(MathUtil.strToBigDecimal(map.get("成本价")));
        sku.setRemark(map.get("备注"));
        sku.setHeadTripCost(getHeadTripCost(sku.getWeight()));
        sku.setHeadTripCostMin(getHeadTripCostMin(sku.getWeight()));
    }


    /**
     * 修改sku信息
     *
     * @param params
     * @param dealUserId
     * @return
     */
    @Override
    public BaseResponse save(SkuSaveRequest params, Integer dealUserId) {
        Sku skuOld = customSkuMapper.selectByPrimaryKey(params.getSkuId());
        if (skuOld == null) {
            return BaseResponse.failMessage(SkuConstant.SKU_ID_NOT_EXIST);
        }
        Sku sku = new Sku();
        BeanUtils.copyProperties(skuOld, sku);
        BigDecimal costPrice = sku.getCostPrice();
        sku.setSku(params.getSku());
        sku.setColour(params.getColour());
        sku.setColourNumber(params.getColourNumber());
        if (!SkuConstant.SkuSizeEnum.containSize(params.getSize().toUpperCase())) {
            return BaseResponse.failMessage(SkuConstant.SIZE_ERRO);
        }
        sku.setSize(params.getSize().toUpperCase());
        sku.setWeight(params.getWeight());
        sku.setCostPrice(params.getCostPrice());
        sku.setHeadTripCost(getHeadTripCost(params.getWeight()));
        sku.setHeadTripCostMin(getHeadTripCostMin(params.getWeight()));
        sku.setRemark(params.getRemark());
        sku.setSecondSku(params.getSecondSku());
        sku.setBrand(params.getBrand());
        sku.setProductName(params.getProductName());
        sku.setMaterial(params.getMaterial());
        sku.setGrade(params.getGrade());
        sku.setExecutiveStandard(params.getExecutiveStandard());
        sku.setSecurityCategory(params.getSecurityCategory());
        sku.setInspector(params.getInspector());
        sku.setSuggestedRetailPrice(params.getSuggestedRetailPrice());
        sku.setUpdateBy(dealUserId);
        sku.setUpdateTime(new Date());
        customSkuMapper.updateByPrimaryKeySelective(sku);
        skuCostPriceHisService.saveSkuCostPriceHis(sku.getSkuId(), costPrice, sku.getCostPrice(), SkuCostPriceHisConstant.TypeEnum.SAVE, dealUserId);
        skuWeightHisService.saveSkuWeightHis(skuOld, sku, SkuWeightHisConstant.WeightHisTypeEnum.SAVE, dealUserId);
        return BaseResponse.success();
    }

    BigDecimal getHeadTripCost(BigDecimal weight) {
        if (weight == null) {
            return BigDecimal.ZERO;
        } else {
            return SkuConstant.HEAD_TRIP_COST_RATE.multiply(weight);
        }
    }

    private BigDecimal getHeadTripCostMin(BigDecimal weight) {
        if (weight == null) {
            return BigDecimal.ZERO;
        } else {
            return SkuConstant.HEAD_TRIP_COST_MIN_RATE.multiply(weight);
        }
    }

    /**
     * 查询下载的sku信息
     *
     * @param params
     * @return
     */
    @Override
    public List<SkuExportInfoResponse> listSkuExportInfo(SkuListRequest params) {
        return customSkuMapper.listSkuExportInfo(params);
    }

    /**
     * 刪除sku
     *
     * @param skuIds
     * @return
     */
    @Override
    public BaseResponse delete(List<Integer> skuIds) {
        if (CollectionUtils.isEmpty(skuIds)) {
            return BaseResponse.success();
        }
        //判断是否有店铺sku，如果有，则不允许删除
        if (shopSkuService.existShopSku(skuIds)) {
            return BaseResponse.failMessage("已存在店铺或仓库sku，不允许删除,如需删除，请联系管理员");
        }
        SkuExample example = new SkuExample();
        example.createCriteria().andSkuIdIn(skuIds);
        customSkuMapper.deleteByExample(example);
        imgService.deleteImgByEntityId(skuIds, ImgConstant.ImgTypeEnum.SKU_IMG);
        return BaseResponse.success();
    }

    /**
     * @param productIds@return
     * @description 通过商品id删除sku
     * @author baixueping
     * @date 2019/7/24 10:55
     */
    @Override
    public BaseResponse deleteByProductIds(List<Integer> productIds) {
        if (CollectionUtils.isEmpty(productIds)) {
            return BaseResponse.success();
        }
        SkuExample skuExample = new SkuExample();
        skuExample.createCriteria().andProductIdIn(productIds);
        List<Sku> skuList = customSkuMapper.selectByExample(skuExample);
        if (CollectionUtils.isEmpty(skuList)) {
            return BaseResponse.success();
        }
        List<Integer> skuIds = skuList.stream().map(Sku::getSkuId).collect(Collectors.toList());
        BaseResponse res = delete(skuIds);
        return res;
    }

    /**
     * @param
     * @return
     * @description 获取sku
     * @author baixueping
     * @date 2019/7/29 14:23
     */
    @Override
    public Sku getSkuBySku(String sku) {
        if (StringUtils.isEmpty(sku)) {
            return null;
        }
        SkuExample example = new SkuExample();
        example.createCriteria().andSkuEqualTo(sku);
        List<Sku> existList = customSkuMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(existList)) {
            return null;
        }
        return existList.get(0);
    }

    /**
     * @param file
     * @param dealUserId
     * @return
     * @description 导入仓库库存
     * @author baixueping
     * @date 2019/8/15 17:12
     */
    @Deprecated
    @Override
    public BaseResponse importInventory(MultipartFile file, Integer dealUserId) {
        //读取excel 转换为list
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //遍历list导入信息
        StringBuilder sbErro = new StringBuilder();
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
            if (StringUtils.isEmpty(map.get("产品sku"))) {
                sbErroItem.append(",").append(SkuConstant.SKU_EMPTY);
            } else {
                Sku sku = getSkuBySku(map.get("产品sku"));
                if (sku == null) {
                    sbErroItem.append(",").append(SkuConstant.SKU_NOT_EXIST);
                } else {
                    map.put("skuId", sku.getSkuId().toString());
                }
            }
            if (sbErroItem.length() > 0) {
                sbErro.append(",第" + (i + 2) + "行").append(sbErroItem);
            }
        }
        if (sbErro.length() > 0) {
            return BaseResponse.failMessage(sbErro.substring(1));
        }
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
            Sku sku = new Sku();
            sku.setSkuId(MathUtil.strToInteger(map.get("skuId")));
            customSkuMapper.updateByPrimaryKeySelective(sku);
        }
        return BaseResponse.success();
    }

    /**
     * @param skuId@return
     * @description 根据id获取sku信息
     * @author baixueping
     * @date 2019/9/11 10:04
     */
    @Override
    public Sku getSku(Integer skuId) {
        if (skuId == null) {
            return null;
        }
        return customSkuMapper.selectByPrimaryKey(skuId);
    }

    /**
     * @param file
     * @param dealUserId
     * @return
     * @description 导入成本价
     * @author baixueping
     * @date 2019/12/27 9:40
     */
    @Override
    public BaseResponse importCostPrice(MultipartFile file, Integer dealUserId) {
        //读取excel 转换为list
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //遍历list导入信息
        StringBuilder sbErro = new StringBuilder();
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
            if (StringUtils.isEmpty(map.get("产品sku"))) {
                sbErroItem.append(",").append(SkuConstant.SKU_EMPTY);
            } else {
                Sku sku = getSkuBySku(map.get("产品sku"));
                if (sku == null) {
                    sbErroItem.append(",").append(SkuConstant.SKU_NOT_EXIST);
                } else {
                    map.put("skuId", sku.getSkuId().toString());
                    if (sku.getCostPrice() != null) {
                        map.put("costPirceBefore", sku.getCostPrice().toString());
                    }
                }
            }
            if (StringUtils.isEmpty(map.get("成本价"))) {
                sbErroItem.append(",").append(SkuConstant.COST_PRICE_EMPTY);
            } else {
                BigDecimal costPrice = MathUtil.strToBigDecimal(map.get("成本价"));
                if (costPrice == null || costPrice.compareTo(BigDecimal.ZERO) <= 0) {
                    sbErroItem.append(",").append(SkuConstant.COST_PRICE_ERRO);
                }
            }
            if (sbErroItem.length() > 0) {
                sbErro.append(",第" + (i + 2) + "行").append(sbErroItem);
            }
        }
        if (sbErro.length() > 0) {
            return BaseResponse.failMessage(sbErro.substring(1));
        }
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
            BigDecimal costPriceBefore = MathUtil.strToBigDecimal(map.get("costPirceBefore"));
            Sku sku = new Sku();
            sku.setSkuId(MathUtil.strToInteger(map.get("skuId")));
            sku.setCostPrice(MathUtil.strToBigDecimal(map.get("成本价")));
            customSkuMapper.updateByPrimaryKeySelective(sku);
            skuCostPriceHisService.saveSkuCostPriceHis(sku.getSkuId(), costPriceBefore, sku.getCostPrice(), SkuCostPriceHisConstant.TypeEnum.IMPORT_COST_PRICE, dealUserId);
        }
        return BaseResponse.success();
    }

    /**
     * @param file
     * @param dealUserId
     * @return
     * @description 导入重量
     * @author baixueping
     * @date 2019/12/27 9:40
     */
    @Override
    public BaseResponse importWeight(MultipartFile file, Integer dealUserId) {
        //读取excel 转换为list
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //遍历list导入信息
        StringBuilder sbErro = new StringBuilder();
        Map<String, Sku> skuMap = new HashMap<>();
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
            if (StringUtils.isEmpty(map.get("产品sku"))) {
                sbErroItem.append(",").append(SkuConstant.SKU_EMPTY);
            } else {
                Sku sku = getSkuBySku(map.get("产品sku"));
                if (sku == null) {
                    sbErroItem.append(",").append(SkuConstant.SKU_NOT_EXIST);
                } else {
                    skuMap.put(map.get("产品sku"), sku);
                }
            }
            if (StringUtils.isEmpty(map.get("重量"))) {
                sbErroItem.append(",").append(SkuConstant.WEIGHT_EMPTY);
            } else {
                BigDecimal weight = MathUtil.strToBigDecimal(map.get("重量"));
                if (weight == null || weight.compareTo(BigDecimal.ZERO) <= 0) {
                    sbErroItem.append(",").append(SkuConstant.WEIGHT_ERRO);
                }
            }
            if (sbErroItem.length() > 0) {
                sbErro.append(",第" + (i + 2) + "行").append(sbErroItem);
            }
        }
        if (sbErro.length() > 0) {
            return BaseResponse.failMessage(sbErro.substring(1));
        }
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
            Sku skuOld = skuMap.get(map.get("产品sku"));
            Sku sku = new Sku();
            sku.setSkuId(skuOld.getSkuId());
            sku.setWeight(MathUtil.strToBigDecimal(map.get("重量")));
            sku.setHeadTripCost(getHeadTripCost(sku.getWeight()));
            sku.setHeadTripCostMin(getHeadTripCostMin(sku.getWeight()));
            customSkuMapper.updateByPrimaryKeySelective(sku);
            skuWeightHisService.saveSkuWeightHis(skuOld, sku, SkuWeightHisConstant.WeightHisTypeEnum.SAVE, dealUserId);
        }
        return BaseResponse.success();
    }

    /**
     * @param file
     * @param dealUserId
     * @return
     * @description 导入天猫标签信息
     * @author baixueping
     * @date 2020/4/30 16:39
     */
    @Override
    public BaseResponse importTmallInfo(MultipartFile file, Integer dealUserId) {
        //读取excel 转换为list
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //遍历list导入信息
        StringBuilder sbErro = new StringBuilder();
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
            if (StringUtils.isEmpty(map.get("产品sku"))) {
                sbErroItem.append(",").append(SkuConstant.SKU_EMPTY);
            } else {
                Sku sku = getSkuBySku(map.get("产品sku"));
                if (sku == null) {
                    sbErroItem.append(",").append(SkuConstant.SKU_NOT_EXIST);
                } else {
                    map.put("skuId", sku.getSkuId().toString());
                }
            }
            if (sbErroItem.length() > 0) {
                sbErro.append(",第" + (i + 2) + "行").append(sbErroItem);
            }
        }
        if (sbErro.length() > 0) {
            return BaseResponse.failMessage(sbErro.substring(1));
        }
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
            Sku sku = new Sku();
            sku.setSkuId(MathUtil.strToInteger(map.get("skuId")));
            sku.setSecondSku(map.get("副sku"));
            sku.setBrand(map.get("品牌"));
            sku.setProductName(map.get("品名"));
            sku.setMaterial(map.get("面料"));
            sku.setGrade(map.get("等级"));
            sku.setExecutiveStandard(map.get("执行标准"));
            sku.setSecurityCategory(map.get("安全类别"));
            sku.setInspector(map.get("检验员"));
            sku.setSuggestedRetailPrice(map.get("建议零售价"));
            customSkuMapper.updateByPrimaryKeySelective(sku);
        }
        return BaseResponse.success();
    }

    /**
     * @param params@return
     * @description 获取天猫打印sku信息
     * @author baixueping
     * @date 2020/4/30 17:09
     */
    @Override
    public BaseResponse getPrintTmallSku(GetPrintTmallSkuRequest params) {
        if (StringUtils.isEmpty(params.getSecondSku()) && StringUtils.isEmpty(params.getSku())) {
            return BaseResponse.failMessage("请填写产品sku或者副sku");
        }
        GetPrintTmallSkuResponse res = customSkuMapper.getPrintTmallSku(params);
        return BaseResponse.successData(res);
    }

    /**
     * @param file
     * @param dealUserId
     * @return
     * @description 导入颜色色号
     * @author baixueping
     * @date 2020/6/23 10:52
     */
    @Override
    public BaseResponse importColour(MultipartFile file, Integer dealUserId) {
        //读取excel 转换为list
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //遍历list导入信息
        StringBuilder sbErro = new StringBuilder();
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
            if (StringUtils.isEmpty(map.get("产品sku"))) {
                sbErroItem.append(",").append(SkuConstant.SKU_EMPTY);
            } else {
                Sku sku = getSkuBySku(map.get("产品sku"));
                if (sku == null) {
                    sbErroItem.append(",").append(SkuConstant.SKU_NOT_EXIST);
                } else {
                    map.put("skuId", sku.getSkuId().toString());
                }
            }
            if (sbErroItem.length() > 0) {
                sbErro.append(",第" + (i + 2) + "行").append(sbErroItem);
            }
        }
        if (sbErro.length() > 0) {
            return BaseResponse.failMessage(sbErro.substring(1));
        }
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
            Sku sku = new Sku();
            sku.setSkuId(MathUtil.strToInteger(map.get("skuId")));
            sku.setColour(map.get("颜色"));
            sku.setColourNumber(map.get("色号"));
            customSkuMapper.updateByPrimaryKeySelective(sku);
        }
        return BaseResponse.success();
    }

    @Override
    public boolean existSku(List<Integer> productIds) {
        if (CollectionUtils.isEmpty(productIds)) {
            return false;
        }
        SkuExample example = new SkuExample();
        example.createCriteria().andProductIdIn(productIds);
        return customSkuMapper.countByExample(example) > 0;
    }

    @Override
    public BaseResponse importSuggestedRetailPrice(MultipartFile file, Integer dealUserId) {
        //读取excel 转换为list
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //遍历list导入信息
        StringBuilder sbErro = new StringBuilder();
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
            if (StringUtils.isEmpty(map.get("产品sku"))) {
                sbErroItem.append(",").append(SkuConstant.SKU_EMPTY);
            } else {
                Sku sku = getSkuBySku(map.get("产品sku"));
                if (sku == null) {
                    sbErroItem.append(",").append(SkuConstant.SKU_NOT_EXIST);
                } else {
                    map.put("skuId", sku.getSkuId().toString());
                }
            }
            if (StringUtils.isEmpty(map.get("建议零售价"))) {
                sbErroItem.append(",").append(SkuConstant.SUGGESTED_RETAIL_PRICE_EMPTY);
            }
            if (sbErroItem.length() > 0) {
                sbErro.append(",第" + (i + 2) + "行").append(sbErroItem);
            }
        }
        if (sbErro.length() > 0) {
            return BaseResponse.failMessage(sbErro.substring(1));
        }
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
            Sku sku = new Sku();
            sku.setSkuId(MathUtil.strToInteger(map.get("skuId")));
            sku.setSuggestedRetailPrice(map.get("建议零售价"));
            customSkuMapper.updateByPrimaryKeySelective(sku);
        }
        return BaseResponse.success();
    }
}
