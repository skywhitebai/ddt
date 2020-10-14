package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.RoleRight;
import com.sky.ddt.entity.RoleRightExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleRightMapper {
    long countByExample(RoleRightExample example);

    int deleteByExample(RoleRightExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoleRight record);

    int insertSelective(RoleRight record);

    List<RoleRight> selectByExample(RoleRightExample example);

    RoleRight selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoleRight record, @Param("example") RoleRightExample example);

    int updateByExample(@Param("record") RoleRight record, @Param("example") RoleRightExample example);

    int updateByPrimaryKeySelective(RoleRight record);

    int updateByPrimaryKey(RoleRight record);
}