package com.cyh.ums.dao;

import com.cyh.ums.domain.TOrganization;

public interface TOrganizationMapper {
    int deleteByPrimaryKey(Long tOrganizationId);

    int insert(TOrganization record);

    int insertSelective(TOrganization record);

    TOrganization selectByPrimaryKey(Long tOrganizationId);

    int updateByPrimaryKeySelective(TOrganization record);

    int updateByPrimaryKeyWithBLOBs(TOrganization record);

    int updateByPrimaryKey(TOrganization record);
}