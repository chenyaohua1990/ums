package com.cyh.ums.serviceI;

import com.cyh.ums.domain.LanguageCode;

import java.util.List;

public interface LanguageCodeService {
    /**
     * 获取全部数据
     * @return
     */
    List<LanguageCode> list();
}