package com.cyh.ums.dao;

import com.cyh.ums.domain.TUser;

public interface TUserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);

    TUser findByEmail(TUser record);

    TUser findByEmailAndPassWord(TUser record);


}