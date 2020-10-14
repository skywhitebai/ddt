package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.StockRecordMapper;
import com.sky.ddt.dto.stockRecord.request.ListStockRecordRequest;
import com.sky.ddt.dto.stockRecord.response.ExportStockRecordResponse;
import com.sky.ddt.dto.stockRecord.response.ListStockRecordResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author baixueping
 * @description 备货记录
 * @date 2019/8/22 17:03
 */
public interface CustomStockRecordMapper extends StockRecordMapper {
    List<ListStockRecordResponse> listStockRecord(ListStockRecordRequest params);

    List<ExportStockRecordResponse> listExportStockRecord(@Param("stockRecordId")Integer stockRecordId,@Param("type") String type);
}
