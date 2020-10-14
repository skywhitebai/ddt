package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.SkuInfoConstant;
import com.sky.ddt.dao.generate.SkuInfoMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.skuinfo.request.SkuInfoListRequest;
import com.sky.ddt.dto.skuinfo.request.SkuInfoSaveRequest;
import com.sky.ddt.dto.skuinfo.request.SkuInfoTransForm;
import com.sky.ddt.entity.SkuInfo;
import com.sky.ddt.entity.SkuInfoExample;
import com.sky.ddt.service.ISkuInfoService;
import com.sky.ddt.util.ExcelUtil;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import java.util.*;

@Service
public class SkuInfoService implements ISkuInfoService {
    @Autowired
    SkuInfoMapper skuInfoMapper;

    @Override
    public PageInfo<SkuInfo> list(SkuInfoListRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        SkuInfoExample example = new SkuInfoExample();
        if (!StringUtils.isEmpty(params.getSkuSeller())) {
            example.createCriteria().andSkuSellerLike("%"+params.getSkuSeller()+"%");
        }
        if (!StringUtils.isEmpty(params.getSkuWarehouse())) {
            example.createCriteria().andSkuWarehouseLike("%"+params.getSkuWarehouse()+"%");
        }
        if (!StringUtils.isEmpty(params.getSkuSupplier())) {
            example.createCriteria().andSkuWarehouseLike("%"+params.getSkuSupplier()+"%");
        }
        List<SkuInfo> list = skuInfoMapper.selectByExample(example);
        PageInfo<SkuInfo> page = new PageInfo<SkuInfo>(list);
        return page;
    }

    @Override
    public BaseResponse save(SkuInfoSaveRequest params, Integer dealUserId) {
        StringBuilder sbErro = new StringBuilder();
        if (StringUtils.isEmpty(params.getSkuSeller())) {
            sbErro.append(",").append(SkuInfoConstant.SKUSELLER_EMPTY);
        }
        if (StringUtils.isEmpty(params.getSkuWarehouse())) {
            sbErro.append(",").append(SkuInfoConstant.SKUWAREHOUSE_EMPTY);
        }
        if (sbErro.length() > 0) {
            return BaseResponse.failMessage(sbErro.substring(1));
        }
        //判断是否存在卖家sku
        SkuInfoExample example = new SkuInfoExample();
        if (params.getId() == null) {
            example.createCriteria().andSkuSellerEqualTo(params.getSkuSeller());
        } else {
            example.createCriteria().andSkuSellerEqualTo(params.getSkuSeller()).andIdNotEqualTo(params.getId());
        }
        List<SkuInfo> list = skuInfoMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            return BaseResponse.failMessage(SkuInfoConstant.SKUSELLER_EXIST);
        }
        SkuInfo model = new SkuInfo();
        BeanUtils.copyProperties(params, model);
        if (params.getId() == null) {
            model.setCreateBy(dealUserId);
            model.setCreateTime(new Date());
            int res = skuInfoMapper.insert(model);
            //添加成功
            if (res > 0) {
                return BaseResponse.success();
            } else {
                //添加失败
                return BaseResponse.fail();
            }
        } else {
            SkuInfo modelOld = skuInfoMapper.selectByPrimaryKey(params.getId());
            if (modelOld == null) {
                return BaseResponse.failMessage(SkuInfoConstant.ID_NOT_EXIST);
            }
            model.setUpdateBy(dealUserId);
            model.setUpdateTime(new Date());
            int res = skuInfoMapper.updateByPrimaryKeySelective(model);
            //修改成功
            if (res > 0) {
                return BaseResponse.success();
            } else {
                //修改失败
                return BaseResponse.fail();
            }
        }
    }

    @Override
    public BaseResponse delete(List<Integer> ids) {
        if (ids == null || ids.size() == 0) {
            return BaseResponse.success();
        }
        SkuInfoExample example = new SkuInfoExample();
        example.createCriteria().andIdIn(ids);
        skuInfoMapper.deleteByExample(example);
        return BaseResponse.success();
    }

    @Override
    public BaseResponse importSkuInfo(MultipartFile file, Integer dealUserId) {
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
        for (int i = 0; i < list.size(); i++) {
            Map<String, String> map = list.get(i);
            //忽略空行
            Boolean isEmpty=true;
            for(String key:map.keySet()){
                if(!StringUtils.isEmpty(map.get(key))){
                    isEmpty=false;
                    break;
                }
            }
            if(isEmpty){
                continue;
            }
            StringBuilder sbErroItem = new StringBuilder();
            if (StringUtils.isEmpty(map.get("卖家sku"))) {
                sbErroItem.append(",").append("卖家sku不能为空");
            }
            if (sbErroItem.length() > 0) {
                sbErro.append(",第" + (i+2) + "行").append(sbErroItem);
            }
        }
        if (sbErro.length() > 0) {
            return BaseResponse.failMessage(sbErro.substring(1));
        }
        for (Map<String, String> map : list) {
            //忽略空行
            Boolean isEmpty=true;
            for(String key:map.keySet()){
                if(!StringUtils.isEmpty(map.get(key))){
                    isEmpty=false;
                    break;
                }
            }
            if(isEmpty){
                continue;
            }
            SkuInfoExample example = new SkuInfoExample();
            example.createCriteria().andSkuSellerEqualTo(map.get("卖家sku"));
            List<SkuInfo> existList = skuInfoMapper.selectByExample(example);
            if (existList.size() > 0) {
                SkuInfo skuInfo = existList.get(0);
                skuInfo.setSkuSeller(map.get("卖家sku"));
                if(!StringUtils.isEmpty(map.get("仓库sku"))){
                    skuInfo.setSkuWarehouse(map.get("仓库sku"));
                }
                if(!StringUtils.isEmpty(map.get("供应商sku"))){
                    skuInfo.setSkuSupplier(map.get("供应商sku"));
                }
                skuInfo.setUpdateBy(dealUserId);
                skuInfo.setUpdateTime(new Date());
                skuInfoMapper.updateByPrimaryKey(skuInfo);
            } else {
                SkuInfo skuInfo = new SkuInfo();
                skuInfo.setSkuSeller(map.get("卖家sku"));
                if(!StringUtils.isEmpty(map.get("仓库sku"))){
                    skuInfo.setSkuWarehouse(map.get("仓库sku"));
                }
                if(!StringUtils.isEmpty(map.get("供应商sku"))){
                    skuInfo.setSkuSupplier(map.get("供应商sku"));
                }
                skuInfo.setCreateBy(dealUserId);
                skuInfo.setCreateTime(new Date());
                skuInfoMapper.insert(skuInfo);
            }
        }
        return BaseResponse.success();
    }

    @Override
    public BaseResponse<List<SkuInfoTransForm>> transformSkuInfo(MultipartFile file) {
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
        for (int i = 0; i < list.size(); i++) {
            Map<String, String> map = list.get(i);
            //忽略空行
            Boolean isEmpty=true;
            for(String key:map.keySet()){
                if(!StringUtils.isEmpty(map.get(key))){
                    isEmpty=false;
                    break;
                }
            }
            if(isEmpty){
                continue;
            }
            StringBuilder sbErroItem = new StringBuilder();
            if (StringUtils.isEmpty(map.get("卖家 SKU"))) {
                sbErroItem.append(",").append("卖家 SKU不能为空");
            }
            if (sbErroItem.length() > 0) {
                sbErro.append(",第" + (i+2) + "行").append(sbErroItem);
            }
        }
        if (sbErro.length() > 0) {
            return BaseResponse.failMessage(sbErro.substring(1));
        }
        List<SkuInfoTransForm> skuInfoTransFormList = new ArrayList<SkuInfoTransForm>();
        Map<String, String> skuInfoMap = new HashMap<String, String>();
        for (Map<String, String> map : list) {
            //忽略空行
            Boolean isEmpty=true;
            for(String key:map.keySet()){
                if(!StringUtils.isEmpty(map.get(key))){
                    isEmpty=false;
                    break;
                }
            }
            if(isEmpty){
                continue;
            }
            SkuInfoTransForm skuInfoTransForm = new SkuInfoTransForm();
            skuInfoTransForm.setSkuSeller(map.get("卖家 SKU"));
            skuInfoTransForm.setSendCount(map.get("已发货"));
            SkuInfoExample example = new SkuInfoExample();
            example.createCriteria().andSkuSellerEqualTo(skuInfoTransForm.getSkuSeller());
            List<SkuInfo> existList = skuInfoMapper.selectByExample(example);
            if (existList.size() > 0) {
                skuInfoTransForm.setSkuWarehouse(existList.get(0).getSkuWarehouse());
            }
            skuInfoTransFormList.add(skuInfoTransForm);
        }

        return BaseResponse.successData(skuInfoTransFormList);
    }

    @Override
    public BaseResponse exportTransformSkuInfo(ServletOutputStream out, List<SkuInfoTransForm> list) {
        // 声明一个工作薄
        XSSFWorkbook workbook = new XSSFWorkbook();
        String sheetName = "skuInfo";
        // 生成一个表格
        XSSFSheet sheet = workbook.createSheet(sheetName);
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short) 20);
        // 产生表格标题行
        String[] headers = {"卖家 SKU", "仓库SKU", "已发货"};
        XSSFRow row = sheet.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            XSSFCell cell = row.createCell(i);
            XSSFRichTextString text = new XSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        try {
            // 遍历集合数据，产生数据行
            Iterator<SkuInfoTransForm> it = list.iterator();
            int index = 0;
            while (it.hasNext()) {
                index++;
                row = sheet.createRow(index);
                SkuInfoTransForm t = (SkuInfoTransForm) it.next();
                // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值

                for (short i = 0; i < headers.length; i++) {
                    XSSFCell cell = row.createCell(i);
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                    switch (i) {
                        case 0:
                            textValue = t.getSkuSeller();
                            break;
                        case 1:
                            textValue = t.getSkuWarehouse();
                            break;
                        case 2:
                            textValue = t.getSendCount();
                            break;
                        default:
                    }
                    if (textValue != null) {
                        XSSFRichTextString richString = new XSSFRichTextString(
                                textValue);
                        cell.setCellValue(richString);
                    }
                }
            }
            workbook.write(out);
            out.flush();
            out.close();
            return BaseResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.fail();
        }
    }
}
