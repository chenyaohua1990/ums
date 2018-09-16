package com.cyh.ums.dao;

import com.cyh.ums.domain.LookupItem;

public interface LookupItemMapper {
    int deleteByPrimaryKey(Long lookupItemId);

    int insert(LookupItem record);

    int insertSelective(LookupItem record);

    LookupItem selectByPrimaryKey(Long lookupItemId);

    int updateByPrimaryKeySelective(LookupItem record);

    int updateByPrimaryKeyWithBLOBs(LookupItem record);

    int updateByPrimaryKey(LookupItem record);
}