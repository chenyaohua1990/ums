package com.cyh.ums.serviceImp;

import com.cyh.ums.dao.LanguageCodeMapper;
import com.cyh.ums.domain.LanguageCode;
import com.cyh.ums.serviceI.LanguageCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageCodeServiceImp implements LanguageCodeService{
    @Autowired
    private LanguageCodeMapper languageCodeMapper;
    @Override
    public List<LanguageCode> list() {
        return languageCodeMapper.list();
    }
}
