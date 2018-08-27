package com.cyh.ums.dao;

import com.cyh.ums.domain.TGroup;

public interface TGroupMapper {
    int deleteByPrimaryKey(Long groupId);

    int insert(TGroup record);

    int insertSelective(TGroup record);

    TGroup selectByPrimaryKey(Long groupId);

    int updateByPrimaryKeySelective(TGroup record);

    int updateByPrimaryKeyWithBLOBs(TGroup record);

    int updateByPrimaryKey(TGroup record);
}