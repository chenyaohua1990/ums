package com.cyh.ums.dao;

import com.cyh.ums.domain.TRole;

public interface TRoleMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(TRole record);

    int insertSelective(TRole record);

    TRole selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(TRole record);

    int updateByPrimaryKeyWithBLOBs(TRole record);

    int updateByPrimaryKey(TRole record);
}