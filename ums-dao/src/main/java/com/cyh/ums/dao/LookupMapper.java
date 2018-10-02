package com.cyh.ums.dao;

import com.cyh.ums.domain.Lookup;
import com.cyh.ums.domain.LookupItem;

import java.util.List;

public interface LookupMapper {
    int deleteByPrimaryKey(Long lookupId);

    int insert(Lookup record);

    int insertSelective(Lookup record);

    Lookup selectByPrimaryKey(Long lookupId);

    int updateByPrimaryKeySelective(Lookup record);

    int updateByPrimaryKeyWithBLOBs(Lookup record);

    int updateByPrimaryKey(Lookup record);

    List<LookupItem> findLookupItemBylookupCode(String lookupCode);

}