package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.InternalOrderNumberTransportConstant;
import com.sky.ddt.common.constant.SbErroEntity;
import com.sky.ddt.dao.custom.CustomInternalOrderNumberTransportMapper;
import com.sky.ddt.dto.internalOrderNumberTransport.request.AddInternalOrderNumberTransportRequest;
import com.sky.ddt.dto.internalOrderNumberTransport.request.ListInternalOrderNumberTransportRequest;
import com.sky.ddt.dto.internalOrderNumberTransport.request.SaveInternalOrderNumberTransportRequest;
import com.sky.ddt.dto.internalOrderNumberTransport.request.SaveInternalOrderNumberTransportWightRequest;
import com.sky.ddt.dto.internalOrderNumberTransport.response.ListInternalOrderNumberTransportResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.InternalOrderNumber;
import com.sky.ddt.entity.InternalOrderNumberTransport;
import com.sky.ddt.entity.InternalOrderNumberTransportExample;
import com.sky.ddt.service.IInternalOrderNumberService;
import com.sky.ddt.service.IInternalOrderNumberTransportService;
import com.sky.ddt.service.ITransportTypeService;
import com.sky.ddt.util.ExcelUtil;
import com.sky.ddt.util.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author baixueping
 * @description 内部单号物流信息
 * @date 2020/7/1 16:43
 */
@Service
public class InternalOrderNumberTransportService implements IInternalOrderNumberTransportService {
    @Autowired
    CustomInternalOrderNumberTransportMapper customInternalOrderNumberTransportMapper;
    @Autowired
    IInternalOrderNumberService internalOrderNumberService;
    @Autowired
    ITransportTypeService transportTypeService;

    /**
     * @param params@return
     * @description 分页查询内部单号运输信息
     * @author baixueping
     * @date 2020/7/3 14:40
     */
    @Override
    public PageInfo<ListInternalOrderNumberTransportResponse> listInternalOrderNumberTransport(ListInternalOrderNumberTransportRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListInternalOrderNumberTransportResponse> list = customInternalOrderNumberTransportMapper.listInternalOrderNumberTransport(params);
        PageInfo<ListInternalOrderNumberTransportResponse> page = new PageInfo<ListInternalOrderNumberTransportResponse>(list);
        return page;
    }

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 保存内部单号运输管理
     * @author baixueping
     * @date 2020/7/6 14:27
     */
    @Override
    public BaseResponse saveInternalOrderNumberTransport(SaveInternalOrderNumberTransportRequest params, Integer dealUserId) {
        InternalOrderNumberTransport internalOrderNumberTransport = customInternalOrderNumberTransportMapper.selectByPrimaryKey(params.getId());
        if (internalOrderNumberTransport == null) {
            return BaseResponse.failMessage(InternalOrderNumberTransportConstant.ID_NOT_EXIST);
        }
        String orderNumber = params.getSubOrderNumber().split("-")[0];
        InternalOrderNumber internalOrderNumber = internalOrderNumberService.getInternalOrderNumberByOrderNumber(orderNumber);
        if (internalOrderNumber == null) {
            return BaseResponse.failMessage(InternalOrderNumberTransportConstant.SUB_ORDER_NUMBER_PARENT_NOT_EXIST);
        }
        if (existSubOrderNumber(params.getSubOrderNumber(), internalOrderNumberTransport.getId())) {
            return BaseResponse.failMessage(InternalOrderNumberTransportConstant.SUB_ORDER_NUMBER_EXIST);
        }
        if (!params.getFbaShipmentId().startsWith(InternalOrderNumberTransportConstant.FBA_START)) {
            return BaseResponse.failMessage(InternalOrderNumberTransportConstant.FBA_SHIPMENT_ID_ERRO);
        }
        if (existFbaShipmentId(params.getFbaShipmentId(), internalOrderNumberTransport.getId())) {
            return BaseResponse.failMessage(InternalOrderNumberTransportConstant.FBA_SHIPMENT_ID_EXIST);
        }
        if (transportTypeService.notExistTransportTypeId(params.getTransportTypeId())) {
            return BaseResponse.failMessage(InternalOrderNumberTransportConstant.TRANSPORT_TYPE_ID_NOT_EXIST);
        }
        internalOrderNumberTransport.setInternalOrderNumberId(internalOrderNumber.getId());
        internalOrderNumberTransport.setFbaShipmentId(params.getFbaShipmentId());
        internalOrderNumberTransport.setFbaShipmentIdShort(params.getFbaShipmentId().replace(InternalOrderNumberTransportConstant.U_PREFIX, "U"));
        internalOrderNumberTransport.setShipmentId(params.getFbaShipmentId().substring(0, 12));
        internalOrderNumberTransport.setSubOrderNumber(params.getSubOrderNumber());
        internalOrderNumberTransport.setTransferOrderNo(params.getTransferOrderNo());
        internalOrderNumberTransport.setTransportTypeId(params.getTransportTypeId());
        if (InternalOrderNumberTransportConstant.LockHeadTripCostRateEnum.UN_LOCK.getLockHeadTripCostRate().equals(internalOrderNumberTransport.getLockHeadTripCostRate())) {
            internalOrderNumberTransport.setHeadTripCostRate(params.getHeadTripCostRate());
        }
        internalOrderNumberTransport.setUpdateBy(dealUserId);
        internalOrderNumberTransport.setUpdateTime(new Date());
        customInternalOrderNumberTransportMapper.updateByPrimaryKey(internalOrderNumberTransport);
        return BaseResponse.success();
    }

    /**
     * @param list
     * @param dealUserId
     * @return
     * @description 批量添加内部单号发货信息
     * @author baixueping
     * @date 2020/7/7 16:08
     */
    @Override
    public BaseResponse batchAddInternalOrderNumberTransport(List<AddInternalOrderNumberTransportRequest> list, Integer dealUserId) {
        if (CollectionUtils.isEmpty(list)) {
            return BaseResponse.failMessage("请填写数据");
        }
        SbErroEntity sbErroEntity = new SbErroEntity(";");
        Map<String, InternalOrderNumber> internalOrderNumberMap = new HashMap<>();
        for (AddInternalOrderNumberTransportRequest addInternalOrderNumberTransportRequest :
                list) {
            SbErroEntity sb = new SbErroEntity();
            if (StringUtils.isEmpty(addInternalOrderNumberTransportRequest.getSubOrderNumber())) {
                sb.append(InternalOrderNumberTransportConstant.SUB_ORDER_NUMBER_EMPTY);
            } else if (addInternalOrderNumberTransportRequest.getSubOrderNumber().length() > 50) {
                sb.append(InternalOrderNumberTransportConstant.SUB_ORDER_NUMBER_TOO_LONG);
            } else {
                String orderNumber = addInternalOrderNumberTransportRequest.getSubOrderNumber().split("-")[0];
                if (internalOrderNumberMap.containsKey(orderNumber)) {
                    InternalOrderNumber internalOrderNumber = internalOrderNumberMap.get(orderNumber);
                    if (internalOrderNumber == null) {
                        sb.append(InternalOrderNumberTransportConstant.SUB_ORDER_NUMBER_PARENT_NOT_EXIST);
                    }
                } else {
                    InternalOrderNumber internalOrderNumber = internalOrderNumberService.getInternalOrderNumberByOrderNumber(orderNumber);
                    if (internalOrderNumber == null) {
                        sb.append(InternalOrderNumberTransportConstant.SUB_ORDER_NUMBER_PARENT_NOT_EXIST);
                        internalOrderNumberMap.put(orderNumber, null);
                    } else {
                        internalOrderNumberMap.put(orderNumber, internalOrderNumber);
                    }
                }
                //判断是否重复
                if (repeatSubOrderNumber(addInternalOrderNumberTransportRequest.getSubOrderNumber(), list)) {
                    sb.append(InternalOrderNumberTransportConstant.SUB_ORDER_NUMBER_REPEAT);
                }
            }
            if (StringUtils.isEmpty(addInternalOrderNumberTransportRequest.getFbaShipmentId())) {
                sb.append(InternalOrderNumberTransportConstant.FBA_SHIPMENT_ID_EMPTY);
            } else if (addInternalOrderNumberTransportRequest.getFbaShipmentId().length() > 50) {
                sb.append(InternalOrderNumberTransportConstant.FBA_SHIPMENT_ID_TOO_LONG);
            } else if (!addInternalOrderNumberTransportRequest.getFbaShipmentId().startsWith(InternalOrderNumberTransportConstant.FBA_START)) {
                return BaseResponse.failMessage(InternalOrderNumberTransportConstant.FBA_SHIPMENT_ID_ERRO);
            } else {
                if (repeatFbaShipmentId(addInternalOrderNumberTransportRequest.getFbaShipmentId(), list)) {
                    sb.append(InternalOrderNumberTransportConstant.FBA_SHIPMENT_ID_REPEAT);
                }
            }
            if (StringUtils.isEmpty(addInternalOrderNumberTransportRequest.getTransferOrderNo())) {
                sb.append(InternalOrderNumberTransportConstant.TRANSFER_ORDER_NO_EMPTY);
            } else if (addInternalOrderNumberTransportRequest.getTransferOrderNo().length() > 50) {
                sb.append(InternalOrderNumberTransportConstant.TRANSFER_ORDER_NO_TOO_LONG);
            }
            if (sb.isFail()) {
                sbErroEntity.append(sb.getMessage());
            }
        }
        if (sbErroEntity.isFail()) {
            return sbErroEntity.getResponse();
        }
        //判断是否存在
        for (AddInternalOrderNumberTransportRequest addInternalOrderNumberTransportRequest :
                list) {
            SbErroEntity sb = new SbErroEntity();
            if (existSubOrderNumber(addInternalOrderNumberTransportRequest.getSubOrderNumber(), null)) {
                sb.append(InternalOrderNumberTransportConstant.SUB_ORDER_NUMBER_EXIST);
            }
            if (existFbaShipmentId(addInternalOrderNumberTransportRequest.getFbaShipmentId(), null)) {
                sb.append(InternalOrderNumberTransportConstant.FBA_SHIPMENT_ID_EXIST);
            }
            if (sb.isFail()) {
                sbErroEntity.append(sb.getMessage());
            }
        }
        if (sbErroEntity.isFail()) {
            return sbErroEntity.getResponse();
        }
        //保存
        for (AddInternalOrderNumberTransportRequest addInternalOrderNumberTransportRequest :
                list) {
            String orderNumber = addInternalOrderNumberTransportRequest.getSubOrderNumber().split("-")[0];
            InternalOrderNumberTransport internalOrderNumberTransport = new InternalOrderNumberTransport();
            internalOrderNumberTransport.setInternalOrderNumberId(internalOrderNumberMap.get(orderNumber).getId());
            internalOrderNumberTransport.setTransportTypeId(internalOrderNumberMap.get(orderNumber).getTransportTypeId());
            internalOrderNumberTransport.setSubOrderNumber(addInternalOrderNumberTransportRequest.getSubOrderNumber());
            internalOrderNumberTransport.setFbaShipmentId(addInternalOrderNumberTransportRequest.getFbaShipmentId());
            internalOrderNumberTransport.setFbaShipmentIdShort(addInternalOrderNumberTransportRequest.getFbaShipmentId().replace(InternalOrderNumberTransportConstant.U_PREFIX, "U"));
            internalOrderNumberTransport.setShipmentId(addInternalOrderNumberTransportRequest.getFbaShipmentId().substring(0, 12));
            internalOrderNumberTransport.setTransferOrderNo(addInternalOrderNumberTransportRequest.getTransferOrderNo());
            internalOrderNumberTransport.setLockHeadTripCostRate(InternalOrderNumberTransportConstant.LockHeadTripCostRateEnum.UN_LOCK.getLockHeadTripCostRate());
            internalOrderNumberTransport.setCreateBy(dealUserId);
            internalOrderNumberTransport.setCreateTime(new Date());
            customInternalOrderNumberTransportMapper.insertSelective(internalOrderNumberTransport);
        }
        return BaseResponse.success();
    }

    /**
     * @param file
     * @param dealUserId
     * @return
     * @description 导入转单号
     * @author baixueping
     * @date 2020/7/14 11:01
     */
    @Override
    public BaseResponse importTransferOrderNo(MultipartFile file, Integer dealUserId) {
        if (file == null) {
            return BaseResponse.failMessage("请选择要上传的文件");
        }
        //读取excel 转换为list
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        SbErroEntity sbErro = new SbErroEntity(";");
        Integer emptyCount = 0;
        for (int i = 0; i < list.size(); i++) {
            Map<String, String> map = list.get(i);
            if (map.containsKey("isEmpty")) {
                emptyCount++;
                continue;
            }
            SbErroEntity sbErroItem = new SbErroEntity();
            String subOrderNumber = map.get("内部子单号");
            String transferOrderNo = map.get("转单号");
            if (StringUtils.isEmpty(subOrderNumber)) {
                sbErroItem.append(InternalOrderNumberTransportConstant.SUB_ORDER_NUMBER_EMPTY);
            } else if (repeatOrderNumber(subOrderNumber, list)) {
                sbErroItem.append(InternalOrderNumberTransportConstant.SUB_ORDER_NUMBER_EMPTY);
            } else {
                InternalOrderNumberTransport internalOrderNumberTransport = getInternalOrderNumberTransportBySubOrderNumber(subOrderNumber);
                if (internalOrderNumberTransport == null) {
                    sbErroItem.append(InternalOrderNumberTransportConstant.SUB_ORDER_NUMBER_NOT_EXIST);
                } else {
                    map.put("subInternalOrderNumberId", internalOrderNumberTransport.getId().toString());
                }
            }
            if (StringUtils.isEmpty(transferOrderNo)) {
                sbErroItem.append(InternalOrderNumberTransportConstant.TRANSFER_ORDER_NO_EMPTY);
            }
            if (sbErroItem.isFail()) {
                sbErro.append("第" + (i + 2) + "行：" + sbErroItem.getMessage());
            }
        }
        if (sbErro.isFail()) {
            return sbErro.getResponse();
        }
        if (list.size() == emptyCount) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //修改转单号
        for (int i = 0; i < list.size(); i++) {
            Map<String, String> map = list.get(i);
            Integer subInternalOrderNumberId = MathUtil.strToInteger(map.get("subInternalOrderNumberId"));
            String transferOrderNo = map.get("转单号");
            InternalOrderNumberTransport internalOrderNumberTransport = new InternalOrderNumberTransport();
            internalOrderNumberTransport.setTransferOrderNo(transferOrderNo);
            internalOrderNumberTransport.setUpdateTime(new Date());
            internalOrderNumberTransport.setUpdateBy(dealUserId);
            internalOrderNumberTransport.setId(subInternalOrderNumberId);
            customInternalOrderNumberTransportMapper.updateByPrimaryKeySelective(internalOrderNumberTransport);
        }
        return BaseResponse.success();
    }

    /**
     * @param params@return
     * @description 导出内部单号发货记录
     * @author baixueping
     * @date 2020/7/22 11:46
     */
    @Override
    public List<ListInternalOrderNumberTransportResponse> listExportInternalOrderNumberTransport(ListInternalOrderNumberTransportRequest params) {
        return customInternalOrderNumberTransportMapper.listInternalOrderNumberTransport(params);
    }

    /**
     * @param file
     * @param dealUserId
     * @return
     * @description 导入头程费率
     * @author baixueping
     * @date 2020/8/13 14:36
     */
    @Override
    public BaseResponse importHeadTripCostRate(MultipartFile file, Integer dealUserId) {
        if (file == null) {
            return BaseResponse.failMessage("请选择要上传的文件");
        }
        //读取excel 转换为list
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        SbErroEntity sbErro = new SbErroEntity(";");
        Integer emptyCount = 0;
        for (int i = 0; i < list.size(); i++) {
            Map<String, String> map = list.get(i);
            if (map.containsKey("isEmpty")) {
                emptyCount++;
                continue;
            }
            SbErroEntity sbErroItem = new SbErroEntity();
            String subOrderNumber = map.get("内部子单号");
            String headTripCostRateStr = map.get("头程费率");
            if (StringUtils.isEmpty(subOrderNumber)) {
                sbErroItem.append(InternalOrderNumberTransportConstant.SUB_ORDER_NUMBER_EMPTY);
            } else if (repeatOrderNumber(subOrderNumber, list)) {
                sbErroItem.append(InternalOrderNumberTransportConstant.SUB_ORDER_NUMBER_REPEAT);
            } else {
                InternalOrderNumberTransport internalOrderNumberTransport = getInternalOrderNumberTransportBySubOrderNumber(subOrderNumber);
                if (internalOrderNumberTransport == null) {
                    sbErroItem.append(InternalOrderNumberTransportConstant.SUB_ORDER_NUMBER_NOT_EXIST);
                } else if (InternalOrderNumberTransportConstant.LockHeadTripCostRateEnum.LOCK.getLockHeadTripCostRate().equals(internalOrderNumberTransport.getLockHeadTripCostRate())) {
                    sbErroItem.append(InternalOrderNumberTransportConstant.LOCK_HEAD_TRIPCOST_RATE_NOT_ALLOW_CHANGE);
                } else {
                    map.put("subInternalOrderNumberId", internalOrderNumberTransport.getId().toString());
                }
            }
            if (StringUtils.isEmpty(headTripCostRateStr)) {
                sbErroItem.append(InternalOrderNumberTransportConstant.HEAD_TRIP_COST_RATE_EMPTY);
            } else {
                BigDecimal headTripCostRate = MathUtil.strToBigDecimal(headTripCostRateStr);
                if (!MathUtil.checkMinMaxDigits(headTripCostRate, 0.001, 0.200, 3)) {
                    sbErroItem.append(InternalOrderNumberTransportConstant.HEAD_TRIP_COST_RATE_ERRO);
                }
            }
            if (sbErroItem.isFail()) {
                sbErro.append("第" + (i + 2) + "行：" + sbErroItem.getMessage());
            }
        }
        if (sbErro.isFail()) {
            return sbErro.getResponse();
        }
        if (list.size() == emptyCount) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //修改转单号
        for (int i = 0; i < list.size(); i++) {
            Map<String, String> map = list.get(i);
            Integer subInternalOrderNumberId = MathUtil.strToInteger(map.get("subInternalOrderNumberId"));
            String headTripCostRateStr = map.get("头程费率");
            BigDecimal headTripCostRate = MathUtil.strToBigDecimal(headTripCostRateStr);
            InternalOrderNumberTransport internalOrderNumberTransport = new InternalOrderNumberTransport();
            internalOrderNumberTransport.setHeadTripCostRate(headTripCostRate);
            internalOrderNumberTransport.setUpdateTime(new Date());
            internalOrderNumberTransport.setUpdateBy(dealUserId);
            internalOrderNumberTransport.setId(subInternalOrderNumberId);
            customInternalOrderNumberTransportMapper.updateByPrimaryKeySelective(internalOrderNumberTransport);
        }
        return BaseResponse.success();
    }
    @Override
    public BaseResponse importInternalOrderNumberTransport(MultipartFile file, Integer dealUserId) {
        if (file == null) {
            return BaseResponse.failMessage("请选择要上传的文件");
        }
        //读取excel 转换为list
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        SbErroEntity sbErro = new SbErroEntity(";");
        Integer emptyCount = 0;
        List<AddInternalOrderNumberTransportRequest> addInternalOrderNumberTransportRequestList=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, String> map = list.get(i);
            if (map.containsKey("isEmpty")) {
                emptyCount++;
                continue;
            }
            SbErroEntity sbErroItem = new SbErroEntity();
            String subOrderNumber = map.get("内部子单号");
            String fbaShipmentId = map.get("FBAshipmentID");
            String transferOrderNo = map.get("转单号");
            if (StringUtils.isEmpty(subOrderNumber)) {
                sbErroItem.append(InternalOrderNumberTransportConstant.SUB_ORDER_NUMBER_EMPTY);
            }
            if (StringUtils.isEmpty(fbaShipmentId)) {
                sbErroItem.append(InternalOrderNumberTransportConstant.FBA_SHIPMENT_ID_EMPTY);
            }
            if (StringUtils.isEmpty(transferOrderNo)) {
                sbErroItem.append(InternalOrderNumberTransportConstant.TRANSFER_ORDER_NO_EMPTY);
            }
            AddInternalOrderNumberTransportRequest addInternalOrderNumberTransportRequest=new AddInternalOrderNumberTransportRequest();
            addInternalOrderNumberTransportRequest.setSubOrderNumber(subOrderNumber);
            addInternalOrderNumberTransportRequest.setFbaShipmentId(fbaShipmentId);
            addInternalOrderNumberTransportRequest.setTransferOrderNo(transferOrderNo);
            addInternalOrderNumberTransportRequestList.add(addInternalOrderNumberTransportRequest);
            if (sbErroItem.isFail()) {
                sbErro.append("第" + (i + 2) + "行：" + sbErroItem.getMessage());
            }
        }
        if (sbErro.isFail()) {
            return sbErro.getResponse();
        }
        if (list.size() == emptyCount) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        return batchAddInternalOrderNumberTransport(addInternalOrderNumberTransportRequestList,dealUserId);
    }
    private InternalOrderNumberTransport getInternalOrderNumberTransportBySubOrderNumber(String subOrderNumber) {
        if (StringUtils.isEmpty(subOrderNumber)) {
            return null;
        }
        InternalOrderNumberTransportExample example = new InternalOrderNumberTransportExample();
        example.createCriteria().andSubOrderNumberEqualTo(subOrderNumber);
        List<InternalOrderNumberTransport> list = customInternalOrderNumberTransportMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public boolean existHeadTripCostRateNull(Integer shopId, Date monthDate) {
        return customInternalOrderNumberTransportMapper.existHeadTripCostRateNull(shopId, monthDate) > 0;
    }

    /**
     * @param shopId
     * @param monthDate
     * @return
     * @description 锁定头程费率
     * @author baixueping
     * @date 2020/8/18 17:19
     */
    @Override
    public void lockHeadTripCostRate(Integer shopId, Date monthDate) {
        customInternalOrderNumberTransportMapper.lockHeadTripCostRate(shopId, monthDate);
    }

    @Override
    public BaseResponse saveInternalOrderNumberTransportWight(SaveInternalOrderNumberTransportWightRequest params, Integer dealUserId) {
        if(BigDecimal.ZERO.equals(params.getWeight())){
            params.setWeight(null);
        }
        InternalOrderNumberTransport internalOrderNumberTransport=customInternalOrderNumberTransportMapper.selectByPrimaryKey(params.getId());
        if(internalOrderNumberTransport==null){
            return BaseResponse.failMessage("id不存在");
        }
        internalOrderNumberTransport.setWeight(params.getWeight());
        customInternalOrderNumberTransportMapper.updateByPrimaryKey(internalOrderNumberTransport);
        return BaseResponse.success();
    }



    private boolean repeatOrderNumber(String orderNumber, List<Map<String, String>> list) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            Map<String, String> map = list.get(i);
            if (orderNumber.equals(map.get("单号"))) {
                count++;
                if (count > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existFbaShipmentId(String fbaShipmentId, Integer id) {
        InternalOrderNumberTransportExample example = new InternalOrderNumberTransportExample();
        InternalOrderNumberTransportExample.Criteria criteria = example.createCriteria();
        criteria.andFbaShipmentIdEqualTo(fbaShipmentId);
        if (id != null) {
            criteria.andIdNotEqualTo(id);
        }
        return customInternalOrderNumberTransportMapper.countByExample(example) > 0;
    }

    private boolean existSubOrderNumber(String subOrderNumber, Integer id) {
        InternalOrderNumberTransportExample example = new InternalOrderNumberTransportExample();
        InternalOrderNumberTransportExample.Criteria criteria = example.createCriteria();
        criteria.andSubOrderNumberEqualTo(subOrderNumber);
        if (id != null) {
            criteria.andIdNotEqualTo(id);
        }
        return customInternalOrderNumberTransportMapper.countByExample(example) > 0;
    }

    private boolean repeatFbaShipmentId(String fbaShipmentId, List<AddInternalOrderNumberTransportRequest> list) {
        Integer count = 0;
        for (AddInternalOrderNumberTransportRequest item :
                list) {
            if (fbaShipmentId.equals(item.getFbaShipmentId())) {
                count++;
            }
        }
        if (count > 1) {
            return true;
        }
        return false;
    }

    private boolean repeatSubOrderNumber(String subOrderNumber, List<AddInternalOrderNumberTransportRequest> list) {
        Integer count = 0;
        for (AddInternalOrderNumberTransportRequest item :
                list) {
            if (subOrderNumber.equals(item.getSubOrderNumber())) {
                count++;
            }
        }
        if (count > 1) {
            return true;
        }
        return false;
    }
}
