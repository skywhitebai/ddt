package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.common.constant.ProduceOrderShopSkuConstant;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.produceOrderShopSku.request.ListProduceOrderShopSkuRequest;
import com.sky.ddt.dto.produceOrderShopSku.request.SaveProduceOrderShopSkuRequest;
import com.sky.ddt.dto.produceOrderShopSku.request.SaveProductionQuantityRequest;
import com.sky.ddt.dto.produceOrderShopSku.response.ListProduceOrderShopSkuResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.IProduceOrderShopSkuService;
import com.sky.ddt.util.ExcelExportByExcelFieldUtil;
import com.sky.ddt.util.ExcelExportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author baixueping
 * @description 生产单店铺sku管理
 * @date 2020/4/1 15:00
 */
@Controller
@RequestMapping("/produceOrderShopSku")
public class ProduceOrderShopSkuController extends SuperController {
    @Autowired
    IProduceOrderShopSkuService produceOrderShopSkuService;

    @RequestMapping("/importProduceOrderShopSkuPage")
    @MenuAnnotation("produceOrder/index")
    public String importProduceOrderShopSkuPage() {
        return "produceOrder/importProduceOrderShopSkuPage";
    }

    @RequestMapping("/listProduceOrderShopSku")
    @ResponseBody
    @MenuAnnotation("produceOrder/index")
    public DataGridResponse listProduceOrderShopSku(ListProduceOrderShopSkuRequest listProduceOrderShopSkuRequest) {
        PageInfo<ListProduceOrderShopSkuResponse> page = produceOrderShopSkuService.listProduceOrderShopSku(listProduceOrderShopSkuRequest);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }

    @RequestMapping("saveProduceOrderShopSku")
    @ResponseBody
    @MenuAnnotation("produceOrder/index")
    public BaseResponse saveProduceOrderShopSku(@Validated SaveProduceOrderShopSkuRequest params) {
        Integer dealUserId = getCurrentUserId();
        return produceOrderShopSkuService.saveProduceOrderShopSku(params, dealUserId);
    }

    @RequestMapping("deleteProduceOrderShopSku")
    @ResponseBody
    @MenuAnnotation("produceOrder/index")
    public BaseResponse deleteProduceOrderShopSku(Integer id) {
        return produceOrderShopSkuService.deleteProduceOrderShopSku(id);
    }
    @RequestMapping("/importProduceOrderShopSku")
    @ResponseBody
    @MenuAnnotation("produceOrder/index")
    public BaseResponse importProduceOrderShopSku(MultipartFile file,Integer produceOrderId) {
        Integer dealUserId = getCurrentUserId();
        return produceOrderShopSkuService.importProduceOrderShopSku(file,produceOrderId,dealUserId);
    }
    @RequestMapping("/exportProduceOrderShopSku")
    @ResponseBody
    @MenuAnnotation("produceOrder/index")
    public BaseResponse exportProduceOrderShopSku(Integer produceOrderId) {
        if(produceOrderId==null){
            return BaseResponse.failMessage(ProduceOrderShopSkuConstant.PRODUCE_ORDER_ID_EMPTY);
        }
        List<ListProduceOrderShopSkuResponse> list=produceOrderShopSkuService.listProduceOrderShopSkuByProduceOrderId(produceOrderId);
        BaseResponse exportResponse = new ExcelExportByExcelFieldUtil().export(response, list, ProduceOrderShopSkuConstant.exportProduceOrderShopSkuFieldList, "生产单店铺sku");
        return exportResponse;
    }


    /**
     * @param
     * @return
     * @description 保存补货数量
     * @author baixueping
     * @date 2019/8/22 14:57
     */
    @RequestMapping("/saveProductionQuantity")
    @ResponseBody
    @MenuAnnotation("produceOrder/index")
    public BaseResponse saveProductionQuantity(@Validated SaveProductionQuantityRequest params) {
        return produceOrderShopSkuService.saveProductionQuantity(params,getCurrentUserId());
    }
}
