package com.cyh.ums.dao;

import com.cyh.ums.domain.LanguageCode;

import java.util.List;

public interface LanguageCodeMapper {
    int deleteByPrimaryKey(Long languageId);

    int insert(LanguageCode record);

    int insertSelective(LanguageCode record);

    LanguageCode selectByPrimaryKey(Long languageId);

    int updateByPrimaryKeySelective(LanguageCode record);

    int updateByPrimaryKeyWithBLOBs(LanguageCode record);

    int updateByPrimaryKey(LanguageCode record);

    List<LanguageCode> list(String languageType);
}