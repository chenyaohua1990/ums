package com.cyh.ums.dao;

import com.cyh.ums.domain.Resources;

public interface ResourcesMapper {
    int deleteByPrimaryKey(Long resourcesId);

    int insert(Resources record);

    int insertSelective(Resources record);

    Resources selectByPrimaryKey(Long resourcesId);

    int updateByPrimaryKeySelective(Resources record);

    int updateByPrimaryKeyWithBLOBs(Resources record);

    int updateByPrimaryKey(Resources record);
}