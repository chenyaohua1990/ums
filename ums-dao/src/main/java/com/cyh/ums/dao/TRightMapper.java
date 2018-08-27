package com.cyh.ums.dao;

import com.cyh.ums.domain.TRight;

public interface TRightMapper {
    int deleteByPrimaryKey(Long rightId);

    int insert(TRight record);

    int insertSelective(TRight record);

    TRight selectByPrimaryKey(Long rightId);

    int updateByPrimaryKeySelective(TRight record);

    int updateByPrimaryKeyWithBLOBs(TRight record);

    int updateByPrimaryKey(TRight record);
}