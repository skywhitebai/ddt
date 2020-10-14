package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.ProductConstant;
import com.sky.ddt.common.constant.SkuConstant;
import com.sky.ddt.common.constant.UserConstant;
import com.sky.ddt.dao.custom.CustomProductMapper;
import com.sky.ddt.dao.generate.ProductMapper;
import com.sky.ddt.dto.product.request.ProductListRequest;
import com.sky.ddt.dto.product.request.ProductSaveRequest;
import com.sky.ddt.dto.product.response.ProductExportInfoResponse;
import com.sky.ddt.dto.product.response.ProductListResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.Product;
import com.sky.ddt.entity.ProductExample;
import com.sky.ddt.entity.User;
import com.sky.ddt.service.IProductService;
import com.sky.ddt.service.ISkuService;
import com.sky.ddt.service.IUserService;
import com.sky.ddt.util.ExcelUtil;
import com.sky.ddt.util.MathUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ProductService implements IProductService {
    @Autowired
    CustomProductMapper customerProductMapper;
    @Autowired
    IUserService userService;
    @Autowired
    ISkuService skuService;

    @Override
    public PageInfo<ProductListResponse> list(ProductListRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ProductListResponse> list = customerProductMapper.listProduct(params);
        PageInfo<ProductListResponse> page = new PageInfo<ProductListResponse>(list);
        return page;
    }

    @Override
    public BaseResponse save(ProductSaveRequest params, Integer dealUserId) {
        //判断是否存在
        ProductExample example = new ProductExample();
        if (params.getProductId() == null) {
            example.createCriteria().andProductCodeEqualTo(params.getProductCode());
        } else {
            example.createCriteria().andProductCodeEqualTo(params.getProductCode()).andProductIdNotEqualTo(params.getProductId());
        }
        List<Product> list = customerProductMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            return BaseResponse.failMessage(ProductConstant.PRODUCTCODE_EXIST);
        }
        if (params.getDeveloperUserId() != null) {
            if (!userService.exist(params.getDeveloperUserId())) {
                return BaseResponse.failMessage(ProductConstant.DEVELOPER_USER_ID_NOT_EXIST);
            }
        }
        if (params.getProductId() == null) {
            Product model = new Product();
            BeanUtils.copyProperties(params, model);
            model.setCreateBy(dealUserId);
            model.setCreateTime(new Date());
            int res = customerProductMapper.insertSelective(model);
            //添加成功
            if (res > 0) {
                return BaseResponse.success();
            } else {
                //添加失败
                return BaseResponse.fail();
            }
        } else {
            Product model = customerProductMapper.selectByPrimaryKey(params.getProductId());
            if (model == null) {
                return BaseResponse.failMessage(ProductConstant.PRODUCTID_NOT_EXIST);
            }
            model.setProductName(params.getProductName());
            model.setProductCode(params.getProductCode());
            model.setDescription(params.getDescription());
            model.setDeveloperUserId(params.getDeveloperUserId());
            model.setDevelopmentTime(params.getDevelopmentTime());
            model.setRemark(params.getRemark());
            model.setChineseProductName(params.getChineseProductName());
            model.setEnglishProductName(params.getEnglishProductName());
            model.setUpdateBy(dealUserId);
            model.setUpdateTime(new Date());
            int res = customerProductMapper.updateByPrimaryKey(model);
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
    public BaseResponse delete(List<Integer> productIds, Integer dealUserId) {
        if (productIds == null || productIds.size() == 0) {
            return BaseResponse.success();
        }
        if(skuService.existSku(productIds)){
            return BaseResponse.failMessage("已存在产品sku，不允许删除");
        }
        ProductExample example = new ProductExample();
        example.createCriteria().andProductIdIn(productIds);
        customerProductMapper.deleteByExample(example);

        //skuService.deleteByProductIds(productIds);
        return BaseResponse.success();
    }

    /**
     * @param productCode@return
     * @description 通过productCode获取产品信息
     * @author baixueping
     * @date 2019/5/10 15:28
     */
    @Override
    public Product getProductByProductCode(String productCode) {
        if (StringUtils.isEmpty(productCode)) {
            return null;
        }
        ProductExample example = new ProductExample();
        example.createCriteria().andProductCodeEqualTo(productCode);
        List<Product> res = customerProductMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(res)) {
            return null;
        }
        return res.get(0);
    }

    /**
     * @param file
     * @param dealUserId
     * @return
     * @description 导入产品
     * @author baixueping
     * @date 2019/5/13 16:18
     */
    @Override
    public BaseResponse importProduct(MultipartFile file, Integer dealUserId) {
        if (file == null) {
            return BaseResponse.failMessage("请选择要上传的文件");
        }
        //读取excel 转换为list
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("导入的数据内容为空");
        } //遍历list导入信息
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
            String productSku = map.get("产品名");
            if (StringUtils.isEmpty(map.get("产品名"))) {
                sbErroItem.append(",").append(ProductConstant.PRODUCTNAME_EMPTY);
            }
            if (StringUtils.isEmpty(map.get("产品编码"))) {
                sbErroItem.append(",").append(ProductConstant.PRODUCTCODE_EMPTY);
            }
            if (StringUtils.isEmpty(map.get("中文报关名"))) {
                sbErroItem.append(",").append(ProductConstant.CHINESE_PRODUCT_NAME_EMPTY);
            }
            if (StringUtils.isEmpty(map.get("英文报关名"))) {
                sbErroItem.append(",").append(ProductConstant.ENGLISH_PRODUCT_NAME_EMPTY);
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

            Product product = getProductByProductCode(map.get("产品编码"));
            if (product != null) {
                setProductByMap(product, map);
                product.setUpdateBy(dealUserId);
                product.setUpdateTime(new Date());
                customerProductMapper.updateByPrimaryKeySelective(product);
            } else {
                product = new Product();
                setProductByMap(product, map);
                product.setCreateBy(dealUserId);
                product.setCreateTime(new Date());
                customerProductMapper.insertSelective(product);
            }
        }
        return BaseResponse.success();
    }

    /**
     * @param
     * @return
     * @description 导入时通过map设置product
     * @author baixueping
     * @date 2019/8/2 9:13
     */
    private void setProductByMap(Product product, Map<String, String> map) {
        if (product == null || map == null) {
            return;
        }
        product.setProductName(map.get("产品名"));
        product.setProductCode(map.get("产品编码"));
        product.setChineseProductName(map.get("中文报关名"));
        product.setEnglishProductName(map.get("英文报关名"));
        product.setDescription(map.get("产品描述"));
        product.setRemark(map.get("备注"));
    }


    /**
     * @param params
     * @return
     * @description 获取产品导出信息
     * @author baixueping
     * @date 2019/5/13 16:44
     */
    @Override
    public List<ProductExportInfoResponse> listProductExportInfo(ProductListRequest params) {
        return customerProductMapper.listProductExportInfo(params);
    }

    /**
     * @param file
     * @param dealUserId
     * @return
     * @description 导入开发人员
     * @author baixueping
     * @date 2020/1/2 17:00
     */
    @Override
    public BaseResponse importDeveloperUser(MultipartFile file, Integer dealUserId) {
        //读取excel 转换为list
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //遍历list导入信息
        StringBuilder sbErro = new StringBuilder();
        Map<String, User> userMap = new HashMap<>();
        List<String> userNameNotExistList = new ArrayList<>();
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
            if (StringUtils.isEmpty(map.get("产品编码"))) {
                sbErroItem.append(",").append(ProductConstant.PRODUCTCODE_EMPTY);
            } else {
                Product product = getProductByProductCode(map.get("产品编码"));
                if (product == null) {
                    sbErroItem.append(",").append(ProductConstant.PRODUCTCODE_NOT_EXIST);
                } else {
                    map.put("productId", product.getProductId().toString());
                }
            }
            if (StringUtils.isEmpty(map.get("开发人员用户名"))) {
                sbErroItem.append(",").append(ProductConstant.DEVELOPER_USERNAME_EMPTY);
            } else {
                User user = userMap.get(map.get("开发人员用户名"));
                if (user == null) {
                    if (!userNameNotExistList.contains(map.get("开发人员用户名"))) {
                        user = userService.getUserByUserName(map.get("开发人员用户名"));
                        if (user == null) {
                            userNameNotExistList.add(map.get("开发人员用户名"));
                        }else{
                            userMap.put(map.get("开发人员用户名"),user);
                        }
                    }
                }
                if (user == null) {
                    sbErroItem.append(",").append(ProductConstant.DEVELOPER_USERNAME_NOT_EXIST);
                } else {
                    map.put("developerUserId", user.getUserId().toString());
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
            Product productUpdate =new Product();
            productUpdate.setProductId(MathUtil.strToInteger(map.get("productId")));
            productUpdate.setDeveloperUserId(MathUtil.strToInteger(map.get("developerUserId")));
            productUpdate.setUpdateBy(dealUserId);
            productUpdate.setUpdateTime(new Date());
            customerProductMapper.updateByPrimaryKeySelective(productUpdate);
        }
        return BaseResponse.success();
    }

}
