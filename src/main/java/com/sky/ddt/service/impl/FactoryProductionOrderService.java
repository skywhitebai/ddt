package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.*;
import com.sky.ddt.dao.custom.CustomFactoryProductionOrderMapper;
import com.sky.ddt.dao.custom.CustomFactoryProductionOrderShopSkuMapper;
import com.sky.ddt.dao.custom.CustomShopMapper;
import com.sky.ddt.dto.factoryProductionOrder.request.*;
import com.sky.ddt.dto.factoryProductionOrder.response.ListFactoryProductionOrderInfoResponse;
import com.sky.ddt.dto.factoryProductionOrder.response.ListFactoryProductionOrderShopParentSkuResponse;
import com.sky.ddt.dto.factoryProductionOrder.response.ListFactoryProductionOrderResponse;
import com.sky.ddt.dto.factoryProductionOrder.response.ShopSkuProductionQuantityDto;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shopSku.request.GetShopSkuByShopParentSkuAndSizeRequest;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.*;
import com.sky.ddt.util.DateUtil;
import com.sky.ddt.util.ExcelCopySheetUtil;
import com.sky.ddt.util.ExcelCopySheetUtil2;
import com.sky.ddt.util.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author baixueping
 * @description 工厂生产单服务
 * @date 2020/10/10 10:38
 */
@Service
public class FactoryProductionOrderService implements IFactoryProductionOrderService {
    @Autowired
    CustomFactoryProductionOrderMapper customFactoryProductionOrderMapper;
    @Autowired
    CustomFactoryProductionOrderShopSkuMapper customFactoryProductionOrderShopSkuMapper;
    @Autowired
    IShopSkuService shopSkuService;
    @Autowired
    IShopUserService shopUserService;
    @Autowired
    IStockRecordService stockRecordService;
    @Autowired
    CustomShopMapper customShopMapper;
    @Autowired
    IProduceOrderService produceOrderService;


    /**
     * @param params@return
     * @description 分页查询工厂生产单数据
     * @author baixueping
     * @date 2020/10/12 15:07
     */
    @Override
    public PageInfo<ListFactoryProductionOrderResponse> listFactoryProductionOrder(ListFactoryProductionOrderRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListFactoryProductionOrderResponse> list = customFactoryProductionOrderMapper.listFactoryProductionOrder(params);
        PageInfo<ListFactoryProductionOrderResponse> page = new PageInfo<ListFactoryProductionOrderResponse>(list);
        return page;
    }

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 保存备注
     * @author baixueping
     * @date 2020/10/12 16:34
     */
    @Override
    public BaseResponse saveFactoryProductionOrderRemark(SaveFactoryProductionOrderRemark params, Integer dealUserId) {
        FactoryProductionOrder factoryProductionOrder = new FactoryProductionOrder();
        factoryProductionOrder.setId(params.getId());
        factoryProductionOrder.setRemark(params.getRemark());
        factoryProductionOrder.setUpdateBy(dealUserId);
        factoryProductionOrder.setUpdateTime(new Date());
        customFactoryProductionOrderMapper.updateByPrimaryKeySelective(factoryProductionOrder);
        return BaseResponse.success();
    }

    /**
     * @param params @return
     * @description 获取工厂生产单产品信息
     * @author baixueping
     * @date 2020/10/15 16:46
     */
    @Override
    public PageInfo<ListFactoryProductionOrderShopParentSkuResponse> listFactoryProductionOrderShopParentSku(ListFactoryProductionOrderShopParentSkuRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListFactoryProductionOrderShopParentSkuResponse> list = customFactoryProductionOrderMapper.listFactoryProductionOrderShopParentSku(params);
        PageInfo<ListFactoryProductionOrderShopParentSkuResponse> page = new PageInfo<>(list);
        return page;
    }

    /**
     * @param params@return
     * @description 获取父sku生产数量
     * @author baixueping
     * @date 2020/10/15 19:04
     */
    @Override
    public PageInfo<ListFactoryProductionOrderInfoResponse> listFactoryProductionOrderInfo(ListFactoryProductionOrderInfoRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListFactoryProductionOrderInfoResponse> list = customFactoryProductionOrderMapper.listColourByShopParentSku(params);
        List<ShopSkuProductionQuantityDto> shopSkuProductionQuantityDtoList = customFactoryProductionOrderMapper.listShopSkuProductionQuantity(params);
        for (ListFactoryProductionOrderInfoResponse listFactoryProductionOrderInfoResponse :
                list) {
            listFactoryProductionOrderInfoResponse.setShopParentSku(params.getShopParentSku());
            if (listFactoryProductionOrderInfoResponse.getColour() == null) {
                listFactoryProductionOrderInfoResponse.setRemark("存在颜色为空的产品sku，请完善颜色");
                continue;
            }
            SbErroEntity sbErroEntity = new SbErroEntity(";");
            for (ShopSkuProductionQuantityDto shopSkuProductionQuantityDto : shopSkuProductionQuantityDtoList) {
                if (equlaColourInfo(listFactoryProductionOrderInfoResponse, shopSkuProductionQuantityDto)) {
                    if (StringUtils.isEmpty(shopSkuProductionQuantityDto.getSize())) {
                        sbErroEntity.append("店铺sku：" + shopSkuProductionQuantityDto.getShopSku() + ",尺码为空，请完善尺码");
                        continue;
                    }
                    if (SkuConstant.SkuSizeEnum.F.getSize().equals(shopSkuProductionQuantityDto.getSize().toUpperCase())) {
                        listFactoryProductionOrderInfoResponse.setProductionQuantityF(shopSkuProductionQuantityDto.getProductionQuantity());
                    } else if (SkuConstant.SkuSizeEnum.XS.getSize().equals(shopSkuProductionQuantityDto.getSize().toUpperCase())) {
                        listFactoryProductionOrderInfoResponse.setProductionQuantityXS(shopSkuProductionQuantityDto.getProductionQuantity());
                    } else if (SkuConstant.SkuSizeEnum.S.getSize().equals(shopSkuProductionQuantityDto.getSize().toUpperCase())) {
                        listFactoryProductionOrderInfoResponse.setProductionQuantityS(shopSkuProductionQuantityDto.getProductionQuantity());
                    } else if (SkuConstant.SkuSizeEnum.M.getSize().equals(shopSkuProductionQuantityDto.getSize().toUpperCase())) {
                        listFactoryProductionOrderInfoResponse.setProductionQuantityM(shopSkuProductionQuantityDto.getProductionQuantity());
                    } else if (SkuConstant.SkuSizeEnum.L.getSize().equals(shopSkuProductionQuantityDto.getSize().toUpperCase())) {
                        listFactoryProductionOrderInfoResponse.setProductionQuantityL(shopSkuProductionQuantityDto.getProductionQuantity());
                    } else if (SkuConstant.SkuSizeEnum.XL.getSize().equals(shopSkuProductionQuantityDto.getSize().toUpperCase())) {
                        listFactoryProductionOrderInfoResponse.setProductionQuantityXL(shopSkuProductionQuantityDto.getProductionQuantity());
                    } else if (SkuConstant.SkuSizeEnum.XXL.getSize().equals(shopSkuProductionQuantityDto.getSize().toUpperCase())) {
                        listFactoryProductionOrderInfoResponse.setProductionQuantity2XL(shopSkuProductionQuantityDto.getProductionQuantity());
                    } else if (SkuConstant.SkuSizeEnum.XXXL.getSize().equals(shopSkuProductionQuantityDto.getSize().toUpperCase())) {
                        listFactoryProductionOrderInfoResponse.setProductionQuantity3XL(shopSkuProductionQuantityDto.getProductionQuantity());
                    } else if (SkuConstant.SkuSizeEnum.XXXXL.getSize().equals(shopSkuProductionQuantityDto.getSize().toUpperCase())) {
                        listFactoryProductionOrderInfoResponse.setProductionQuantity4XL(shopSkuProductionQuantityDto.getProductionQuantity());
                    } else if (SkuConstant.SkuSizeEnum.XXXXXL.getSize().equals(shopSkuProductionQuantityDto.getSize().toUpperCase())) {
                        listFactoryProductionOrderInfoResponse.setProductionQuantity5XL(shopSkuProductionQuantityDto.getProductionQuantity());
                    } else if (SkuConstant.SkuSizeEnum.US2.getSize().equals(shopSkuProductionQuantityDto.getSize().toUpperCase())) {
                        listFactoryProductionOrderInfoResponse.setProductionQuantityUS2(shopSkuProductionQuantityDto.getProductionQuantity());
                    } else if (SkuConstant.SkuSizeEnum.US4.getSize().equals(shopSkuProductionQuantityDto.getSize().toUpperCase())) {
                        listFactoryProductionOrderInfoResponse.setProductionQuantityUS4(shopSkuProductionQuantityDto.getProductionQuantity());
                    } else if (SkuConstant.SkuSizeEnum.US6.getSize().equals(shopSkuProductionQuantityDto.getSize().toUpperCase())) {
                        listFactoryProductionOrderInfoResponse.setProductionQuantityUS6(shopSkuProductionQuantityDto.getProductionQuantity());
                    } else if (SkuConstant.SkuSizeEnum.US8.getSize().equals(shopSkuProductionQuantityDto.getSize().toUpperCase())) {
                        listFactoryProductionOrderInfoResponse.setProductionQuantityUS8(shopSkuProductionQuantityDto.getProductionQuantity());
                    } else if (SkuConstant.SkuSizeEnum.US10.getSize().equals(shopSkuProductionQuantityDto.getSize().toUpperCase())) {
                        listFactoryProductionOrderInfoResponse.setProductionQuantityUS10(shopSkuProductionQuantityDto.getProductionQuantity());
                    } else if (SkuConstant.SkuSizeEnum.US12.getSize().equals(shopSkuProductionQuantityDto.getSize().toUpperCase())) {
                        listFactoryProductionOrderInfoResponse.setProductionQuantityUS12(shopSkuProductionQuantityDto.getProductionQuantity());
                    } else if (SkuConstant.SkuSizeEnum.US14.getSize().equals(shopSkuProductionQuantityDto.getSize().toUpperCase())) {
                        listFactoryProductionOrderInfoResponse.setProductionQuantityUS14(shopSkuProductionQuantityDto.getProductionQuantity());
                    } else if (SkuConstant.SkuSizeEnum.US16.getSize().equals(shopSkuProductionQuantityDto.getSize().toUpperCase())) {
                        listFactoryProductionOrderInfoResponse.setProductionQuantityUS16(shopSkuProductionQuantityDto.getProductionQuantity());
                    } else if (SkuConstant.SkuSizeEnum.US18.getSize().equals(shopSkuProductionQuantityDto.getSize().toUpperCase())) {
                        listFactoryProductionOrderInfoResponse.setProductionQuantityUS18(shopSkuProductionQuantityDto.getProductionQuantity());
                    } else if (SkuConstant.SkuSizeEnum.US20.getSize().equals(shopSkuProductionQuantityDto.getSize().toUpperCase())) {
                        listFactoryProductionOrderInfoResponse.setProductionQuantityUS20(shopSkuProductionQuantityDto.getProductionQuantity());
                    } else if (SkuConstant.SkuSizeEnum.US22.getSize().equals(shopSkuProductionQuantityDto.getSize().toUpperCase())) {
                        listFactoryProductionOrderInfoResponse.setProductionQuantityUS22(shopSkuProductionQuantityDto.getProductionQuantity());
                    } else if (SkuConstant.SkuSizeEnum.US24.getSize().equals(shopSkuProductionQuantityDto.getSize().toUpperCase())) {
                        listFactoryProductionOrderInfoResponse.setProductionQuantityUS24(shopSkuProductionQuantityDto.getProductionQuantity());
                    } else if (SkuConstant.SkuSizeEnum.US26.getSize().equals(shopSkuProductionQuantityDto.getSize().toUpperCase())) {
                        listFactoryProductionOrderInfoResponse.setProductionQuantityUS26(shopSkuProductionQuantityDto.getProductionQuantity());
                    } else if (SkuConstant.SkuSizeEnum.US28.getSize().equals(shopSkuProductionQuantityDto.getSize().toUpperCase())) {
                        listFactoryProductionOrderInfoResponse.setProductionQuantityUS28(shopSkuProductionQuantityDto.getProductionQuantity());
                    } else if (SkuConstant.SkuSizeEnum.US30.getSize().equals(shopSkuProductionQuantityDto.getSize().toUpperCase())) {
                        listFactoryProductionOrderInfoResponse.setProductionQuantityUS30(shopSkuProductionQuantityDto.getProductionQuantity());
                    } else if (SkuConstant.SkuSizeEnum.US32.getSize().equals(shopSkuProductionQuantityDto.getSize().toUpperCase())) {
                        listFactoryProductionOrderInfoResponse.setProductionQuantityUS32(shopSkuProductionQuantityDto.getProductionQuantity());
                    } else if (SkuConstant.SkuSizeEnum.US34.getSize().equals(shopSkuProductionQuantityDto.getSize().toUpperCase())) {
                        listFactoryProductionOrderInfoResponse.setProductionQuantityUS34(shopSkuProductionQuantityDto.getProductionQuantity());
                    } else if (SkuConstant.SkuSizeEnum.US36.getSize().equals(shopSkuProductionQuantityDto.getSize().toUpperCase())) {
                        listFactoryProductionOrderInfoResponse.setProductionQuantityUS36(shopSkuProductionQuantityDto.getProductionQuantity());
                    } else {
                        sbErroEntity.append("店铺sku：" + shopSkuProductionQuantityDto.getShopSku() + ",尺码错误，请修改尺码");
                    }
                }
            }
        }
        PageInfo<ListFactoryProductionOrderInfoResponse> page = new PageInfo<>(list);
        return page;
    }

    private boolean equlaColourInfo(ListFactoryProductionOrderInfoResponse listFactoryProductionOrderInfoResponse, ShopSkuProductionQuantityDto shopSkuProductionQuantityDto) {
        if (!listFactoryProductionOrderInfoResponse.getColour().equals(shopSkuProductionQuantityDto.getColour())) {
            return false;
        }
        if (StringUtils.isEmpty(listFactoryProductionOrderInfoResponse.getColourNumber()) && StringUtils.isEmpty(shopSkuProductionQuantityDto.getColourNumber())) {
            return true;
        }
        if (listFactoryProductionOrderInfoResponse.getColourNumber().equals(shopSkuProductionQuantityDto.getColourNumber())) {
            return true;
        }
        return false;
    }

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 保存生产数量
     * @author baixueping
     * @date 2020/10/15 20:04
     */
    @Override
    public BaseResponse saveProductionQuantity(SaveProductionQuantityRequest params, Integer dealUserId) {
        //获取生产单
        FactoryProductionOrder factoryProductionOrder = customFactoryProductionOrderMapper.selectByPrimaryKey(params.getFactoryProductionOrderId());
        if (factoryProductionOrder == null) {
            return BaseResponse.failMessage("工厂生产单id不存在");
        }
        if (!FactoryProductionOrderConstant.StatusEnum.PENDING_CONFIRM.getStatus().equals(factoryProductionOrder.getStatus())) {
            return BaseResponse.failMessage("只有待确认的工厂生产单允许修改数量");
        }
        GetShopSkuByShopParentSkuAndSizeRequest getShopSkuByShopParentSkuAndSizeRequest = new GetShopSkuByShopParentSkuAndSizeRequest();
        BeanUtils.copyProperties(params, getShopSkuByShopParentSkuAndSizeRequest);
        getShopSkuByShopParentSkuAndSizeRequest.setShopId(factoryProductionOrder.getShopId());
        List<ShopSku> shopSkuList = shopSkuService.getShopSkuByShopParentSkuAndSize(getShopSkuByShopParentSkuAndSizeRequest);
        if (CollectionUtils.isEmpty(shopSkuList)) {
            return BaseResponse.failMessage(String.format("店铺父sku：%s,颜色：%s，尺码：%s的店铺sku不存在", params.getShopParentSku(), params.getColour(), params.getSize()));
        }
        if (shopSkuList.size() > 1) {
            return BaseResponse.failMessage(String.format("店铺父sku：%s,颜色：%s，尺码：%s的店铺sku有多个", params.getShopParentSku(), params.getColour(), params.getSize()));
        }
        ShopSku shopSku = shopSkuList.get(0);
        FactoryProductionOrderShopSku factoryProductionOrderShopSku = getFactoryProductionOrderShopSku(params.getFactoryProductionOrderId(), shopSku.getShopSkuId());
        if (factoryProductionOrderShopSku == null) {
            if (params.getProductionQuantity() == 0) {
                return BaseResponse.success();
            }
            factoryProductionOrderShopSku = new FactoryProductionOrderShopSku();
            factoryProductionOrderShopSku.setFactoryProductionOrderId(params.getFactoryProductionOrderId());
            factoryProductionOrderShopSku.setProductionQuantity(params.getProductionQuantity());
            factoryProductionOrderShopSku.setShopSkuId(shopSku.getShopSkuId());
            factoryProductionOrderShopSku.setCreateBy(dealUserId);
            factoryProductionOrderShopSku.setCreateTime(new Date());
            customFactoryProductionOrderShopSkuMapper.insertSelective(factoryProductionOrderShopSku);
            return BaseResponse.success();
        } else {
            if (params.getProductionQuantity() == 0) {
                customFactoryProductionOrderShopSkuMapper.deleteByPrimaryKey(factoryProductionOrderShopSku.getId());
                return BaseResponse.success();
            }
            factoryProductionOrderShopSku.setProductionQuantity(params.getProductionQuantity());
            factoryProductionOrderShopSku.setUpdateBy(dealUserId);
            factoryProductionOrderShopSku.setUpdateTime(new Date());
            customFactoryProductionOrderShopSkuMapper.updateByPrimaryKeySelective(factoryProductionOrderShopSku);
            return BaseResponse.success();
        }
    }

    /**
     * @param shopId
     * @param currentUserId
     * @return
     * @description 创建工厂生产单
     * @author baixueping
     * @date 2020/10/28 17:02
     */
    @Override
    public BaseResponse createFactoryProductionOrder(Integer shopId, Integer currentUserId) {
        if (shopId == null) {
            return BaseResponse.failMessage(StockRecordConstant.SHOP_ID_EMPTY);
        }
        if (!shopUserService.exisShopUser(shopId, currentUserId)) {
            return BaseResponse.failMessage(StockRecordConstant.USER_NO_SHOP_RIGHT);
        }
        List<StockCart> stockCartList = stockRecordService.getStockCartListByShopId(shopId, StockConsatnt.TypeEnum.FACTORY_PRODUCTION.getType());
        if (CollectionUtils.isEmpty(stockCartList)) {
            return BaseResponse.failMessage("没有设置要生产的数据");
        }
        //生成补货记录
        Shop shop = customShopMapper.selectByPrimaryKey(shopId);
        if (shop == null) {
            return BaseResponse.failMessage(StockRecordConstant.SHOP_ID_NOT_EXIST);
        }
        String title = shop.getShopName() + "工厂生产单" + DateUtil.getFormatDateStr(new Date());
        FactoryProductionOrder factoryProductionOrder = new FactoryProductionOrder();
        factoryProductionOrder.setStatus(FactoryProductionOrderConstant.StatusEnum.PENDING_CONFIRM.getStatus());
        factoryProductionOrder.setTitle(title);
        factoryProductionOrder.setShopId(shopId);
        factoryProductionOrder.setCreateBy(currentUserId);
        factoryProductionOrder.setCreateTime(new Date());
        customFactoryProductionOrderMapper.insertSelective(factoryProductionOrder);
        //生成生产单店铺sku
        for (StockCart stockCart : stockCartList) {
            FactoryProductionOrderShopSku factoryProductionOrderShopSku = new FactoryProductionOrderShopSku();
            factoryProductionOrderShopSku.setCreateBy(currentUserId);
            factoryProductionOrderShopSku.setCreateTime(new Date());
            factoryProductionOrderShopSku.setProductionQuantity(stockCart.getProductionQuantity());
            factoryProductionOrderShopSku.setShopSkuId(stockCart.getShopSkuId());
            factoryProductionOrderShopSku.setFactoryProductionOrderId(factoryProductionOrder.getId());
            customFactoryProductionOrderShopSkuMapper.insertSelective(factoryProductionOrderShopSku);
        }
        stockRecordService.deleteStockCartListByShopId(shopId, StockConsatnt.TypeEnum.FACTORY_PRODUCTION.getType());
        return BaseResponse.success();
    }

    /**
     * @param shopParentSku
     * @param factoryProductionOrderId
     * @param response                 @return
     * @description 下载工厂生产单
     * @author baixueping
     * @date 2020/10/28 19:23
     */
    @Override
    public BaseResponse downFactoryProductionOrderByShopParentSku(String shopParentSku, Integer factoryProductionOrderId, HttpServletResponse response) {
        if (StringUtils.isEmpty(shopParentSku)) {
            return BaseResponse.failMessage("店铺父sku不能为空");
        }
        if (factoryProductionOrderId == null) {
            return BaseResponse.failMessage("工厂生产单id不能为空");
        }
        FactoryProductionOrder factoryProductionOrder = customFactoryProductionOrderMapper.selectByPrimaryKey(factoryProductionOrderId);
        if (factoryProductionOrder == null) {
            return BaseResponse.failMessage("工厂生产单id不存在");
        }

        if (!FactoryProductionOrderConstant.StatusEnum.CONFIRM.getStatus().equals(factoryProductionOrder.getStatus())) {
            return BaseResponse.failMessage("只有已确认的工厂生产单允许下载");
        }
        //读取模板
        String path = FactoryProductionOrderService.class.getClassLoader().getResource("template/factoryProduction/factoryProductionTemplate.xls").getPath();
        Workbook wb = ExcelUtil.readExcel(path);
        Sheet sheet = wb.getSheetAt(0);
        setSheetInfo(sheet, factoryProductionOrderId, shopParentSku);
        String fileName = factoryProductionOrder.getTitle() + "-" + shopParentSku;
        return ExcelUtil.exportExcelXls(response, wb, fileName);
    }

    /**
     * @param id
     * @param dealUserId
     * @return
     * @description 确认工厂生产单
     * @author baixueping
     * @date 2020/10/29 19:46
     */
    @Override
    public BaseResponse confirmFactoryProductionOrder(Integer id, Integer dealUserId) {
        if (id == null) {
            return BaseResponse.failMessage("工厂生产单id不能为空");
        }
        FactoryProductionOrder factoryProductionOrder = customFactoryProductionOrderMapper.selectByPrimaryKey(id);
        if (factoryProductionOrder == null) {
            return BaseResponse.failMessage("工厂生产单id不存在");
        }
        if (!FactoryProductionOrderConstant.StatusEnum.PENDING_CONFIRM.getStatus().equals(factoryProductionOrder.getStatus())) {
            return BaseResponse.failMessage("只有待确认的生产单允许确认");
        }
        FactoryProductionOrder factoryProductionOrderUpdate = new FactoryProductionOrder();
        factoryProductionOrderUpdate.setId(id);
        factoryProductionOrderUpdate.setStatus(FactoryProductionOrderConstant.StatusEnum.CONFIRM.getStatus());
        factoryProductionOrderUpdate.setUpdateBy(dealUserId);
        factoryProductionOrderUpdate.setUpdateTime(new Date());
        customFactoryProductionOrderMapper.updateByPrimaryKeySelective(factoryProductionOrderUpdate);
        //生成生产单
        produceOrderService.createProduceOrder(factoryProductionOrder, dealUserId);
        return BaseResponse.success();
    }

    /**
     * @param id
     * @param dealUserId
     * @return
     * @description 取消工厂生产单
     * @author baixueping
     * @date 2020/10/29 19:47
     */
    @Override
    public BaseResponse cancelFactoryProductionOrder(Integer id, Integer dealUserId) {
        if (id == null) {
            return BaseResponse.failMessage("工厂生产单id不能为空");
        }
        FactoryProductionOrder factoryProductionOrder = customFactoryProductionOrderMapper.selectByPrimaryKey(id);
        if (factoryProductionOrder == null) {
            return BaseResponse.failMessage("工厂生产单id不存在");
        }
        if (!FactoryProductionOrderConstant.StatusEnum.PENDING_CONFIRM.getStatus().equals(factoryProductionOrder.getStatus())) {
            return BaseResponse.failMessage("只有待确认的生产单允许取消");
        }
        FactoryProductionOrder factoryProductionOrderUpdate = new FactoryProductionOrder();
        factoryProductionOrderUpdate.setId(id);
        factoryProductionOrderUpdate.setStatus(FactoryProductionOrderConstant.StatusEnum.CANCEL.getStatus());
        factoryProductionOrderUpdate.setUpdateBy(dealUserId);
        factoryProductionOrderUpdate.setUpdateTime(new Date());
        customFactoryProductionOrderMapper.updateByPrimaryKeySelective(factoryProductionOrderUpdate);
        return BaseResponse.success();
    }

    /**
     * @param factoryProductionOrderId
     * @param response
     * @return
     * @description 下载工厂生产单
     * @author baixueping
     * @date 2020/10/29 20:12
     */
    @Override
    public BaseResponse downFactoryProductionOrder(Integer factoryProductionOrderId, HttpServletResponse response) {
        if (factoryProductionOrderId == null) {
            return BaseResponse.failMessage("工厂生产单id不能为空");
        }
        FactoryProductionOrder factoryProductionOrder = customFactoryProductionOrderMapper.selectByPrimaryKey(factoryProductionOrderId);
        if (factoryProductionOrder == null) {
            return BaseResponse.failMessage("工厂生产单id不存在");
        }

        if (!FactoryProductionOrderConstant.StatusEnum.CONFIRM.getStatus().equals(factoryProductionOrder.getStatus())) {
            return BaseResponse.failMessage("只有已确认的工厂生产单允许下载");
        }
        //获取工厂生产单所有店铺父sku
        ListFactoryProductionOrderShopParentSkuRequest params = new ListFactoryProductionOrderShopParentSkuRequest();
        params.setFactoryProductionOrderId(factoryProductionOrderId);
        List<ListFactoryProductionOrderShopParentSkuResponse> listShopParentSku = customFactoryProductionOrderMapper.listFactoryProductionOrderShopParentSku(params);
        if (CollectionUtils.isEmpty(listShopParentSku)) {
            return BaseResponse.failMessage("店铺父sku列表为空");
        }
        //获取店铺sku生产单sheet
        //读取模板
        String path = FactoryProductionOrderService.class.getClassLoader().getResource("template/factoryProduction/factoryProductionTemplate.xls").getPath();
        Workbook wb = ExcelUtil.readExcel(path);
        HSSFSheet sheetFirst = (HSSFSheet) wb.getSheetAt(0);
        //创建新的sheet
        for (int i = 1; i < listShopParentSku.size(); i++) {
            HSSFSheet sheetNew = (HSSFSheet) wb.createSheet(listShopParentSku.get(i).getShopParentSku());
            ExcelCopySheetUtil2.copySheets(sheetFirst, sheetNew);
        }
        for (int i = 0; i < listShopParentSku.size(); i++) {
            Sheet sheet = wb.getSheetAt(i);
            wb.setSheetName(i, listShopParentSku.get(i).getShopParentSku());
            setSheetInfo(sheet, factoryProductionOrderId, listShopParentSku.get(i).getShopParentSku());
        }

        //组装一个excel
        //下载excel
        String fileName = factoryProductionOrder.getTitle();
        return ExcelUtil.exportExcelXls(response, wb, fileName);
    }

    private void setSheetInfo(Sheet sheet, Integer factoryProductionOrderId, String shopParentSku) {
        ListFactoryProductionOrderInfoRequest productionOrderInfoRequest = new ListFactoryProductionOrderInfoRequest();
        productionOrderInfoRequest.setFactoryProductionOrderId(factoryProductionOrderId);
        productionOrderInfoRequest.setShopParentSku(shopParentSku);
        productionOrderInfoRequest.setPage(1);
        productionOrderInfoRequest.setRows(Integer.MAX_VALUE);
        PageInfo<ListFactoryProductionOrderInfoResponse> pageInfo = listFactoryProductionOrderInfo(productionOrderInfoRequest);
        List<ListFactoryProductionOrderInfoResponse> list = pageInfo.getList();
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        Row row3 = sheet.getRow(3);
        setCellValue(row3, 1, shopParentSku);
        setFactoryProductionOrderByShopParentSkuInfo(list, sheet);
    }

    private void setFactoryProductionOrderByShopParentSkuInfo(List<ListFactoryProductionOrderInfoResponse> list, Sheet sheet) {
        Row row0 = sheet.getRow(0);
        row0.getCell(0).setCellValue(DateUtil.getFormatDateStrBySlash(new Date()));
        int contentIndex = 8;
        for (int i = 0; i < list.size(); i++) {
            ListFactoryProductionOrderInfoResponse listFactoryProductionOrderInfoResponse = list.get(i);

            if (i >= 20) {
                sheet.shiftRows(contentIndex + i, sheet.getLastRowNum(), 1, true, false);
            }
            Row rowContent = sheet.getRow(contentIndex + i);
            if (rowContent == null) {
                rowContent = sheet.createRow(contentIndex + i);
            }
            setCellValue(rowContent, 3, listFactoryProductionOrderInfoResponse.getColourInfo());
            setCellValue(rowContent, 5, listFactoryProductionOrderInfoResponse.getProductionQuantityXS());
            setCellValue(rowContent, 6, listFactoryProductionOrderInfoResponse.getProductionQuantityS());
            setCellValue(rowContent, 7, listFactoryProductionOrderInfoResponse.getProductionQuantityM());
            setCellValue(rowContent, 8, listFactoryProductionOrderInfoResponse.getProductionQuantityL());
            setCellValue(rowContent, 9, listFactoryProductionOrderInfoResponse.getProductionQuantityXL());
            setCellValue(rowContent, 10, listFactoryProductionOrderInfoResponse.getProductionQuantity2XL());
            setCellValue(rowContent, 11, listFactoryProductionOrderInfoResponse.getProductionQuantity3XL());
            setCellValue(rowContent, 12, listFactoryProductionOrderInfoResponse.getProductionQuantity4XL());
            setCellValue(rowContent, 13, listFactoryProductionOrderInfoResponse.getProductionQuantity5XL());
            setCellValue(rowContent, 14, listFactoryProductionOrderInfoResponse.getProductionQuantity6XL());
            setCellValue(rowContent, 15, listFactoryProductionOrderInfoResponse.getProductionQuantityUS2());
            setCellValue(rowContent, 16, listFactoryProductionOrderInfoResponse.getProductionQuantityUS4());
            setCellValue(rowContent, 17, listFactoryProductionOrderInfoResponse.getProductionQuantityUS6());
            setCellValue(rowContent, 18, listFactoryProductionOrderInfoResponse.getProductionQuantityUS8());
            setCellValue(rowContent, 19, listFactoryProductionOrderInfoResponse.getProductionQuantityUS10());
            setCellValue(rowContent, 20, listFactoryProductionOrderInfoResponse.getProductionQuantityUS12());
            setCellValue(rowContent, 21, listFactoryProductionOrderInfoResponse.getProductionQuantityUS14());
            setCellValue(rowContent, 22, listFactoryProductionOrderInfoResponse.getProductionQuantityUS16());
            setCellValue(rowContent, 23, listFactoryProductionOrderInfoResponse.getProductionQuantityUS18());
            setCellValue(rowContent, 24, listFactoryProductionOrderInfoResponse.getProductionQuantityUS20());
            setCellValue(rowContent, 25, listFactoryProductionOrderInfoResponse.getProductionQuantityUS22());
            setCellValue(rowContent, 26, listFactoryProductionOrderInfoResponse.getProductionQuantityUS24());
            setCellValue(rowContent, 27, listFactoryProductionOrderInfoResponse.getProductionQuantityUS26());
            setCellValue(rowContent, 28, listFactoryProductionOrderInfoResponse.getProductionQuantityUS28());
            setCellValue(rowContent, 29, listFactoryProductionOrderInfoResponse.getProductionQuantityUS30());
            setCellValue(rowContent, 30, listFactoryProductionOrderInfoResponse.getProductionQuantityUS32());
            setCellValue(rowContent, 31, listFactoryProductionOrderInfoResponse.getProductionQuantityUS34());
            setCellValue(rowContent, 32, listFactoryProductionOrderInfoResponse.getProductionQuantityUS36());


        }
    }

    private void setCellValue(Row row, Integer cellIndex, String str) {
        if (StringUtils.isEmpty(str) || row == null || cellIndex == null || cellIndex < 0) {
            return;
        }
        Cell cell = row.getCell(cellIndex);
        if (cell == null) {
            cell = row.createCell(cellIndex);
        }
        cell.setCellValue(str);
    }

    private void setCellValue(Row row, Integer cellIndex, Integer a) {
        if (a == null || row == null || cellIndex == null || cellIndex < 0) {
            return;
        }
        Cell cell = row.getCell(cellIndex);
        if (cell == null) {
            cell = row.createCell(cellIndex);
        }
        cell.setCellValue(a);
    }

    private void setCellValue(Cell cell, Integer a) {
        if (a != null && cell != null) {
            cell.setCellValue(a);
        }
    }

    private void setCellValue(Cell cell, String str) {
        if (str != null && cell != null) {
            cell.setCellValue(str);
        }
    }

    private FactoryProductionOrderShopSku getFactoryProductionOrderShopSku(Integer factoryProductionOrderId, Integer shopSkuId) {
        FactoryProductionOrderShopSkuExample example = new FactoryProductionOrderShopSkuExample();
        example.createCriteria().andFactoryProductionOrderIdEqualTo(factoryProductionOrderId).andShopSkuIdEqualTo(shopSkuId);
        List<FactoryProductionOrderShopSku> factoryProductionOrderShopSkuList = customFactoryProductionOrderShopSkuMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(factoryProductionOrderShopSkuList)) {
            return null;
        }
        return factoryProductionOrderShopSkuList.get(0);
    }
}
