package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.DailyReport;
import com.sky.ddt.entity.DailyReportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DailyReportMapper {
    long countByExample(DailyReportExample example);

    int deleteByExample(DailyReportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DailyReport record);

    int insertSelective(DailyReport record);

    List<DailyReport> selectByExample(DailyReportExample example);

    DailyReport selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DailyReport record, @Param("example") DailyReportExample example);

    int updateByExample(@Param("record") DailyReport record, @Param("example") DailyReportExample example);

    int updateByPrimaryKeySelective(DailyReport record);

    int updateByPrimaryKey(DailyReport record);
}