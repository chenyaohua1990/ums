package com.cyh.ums.serviceImp;

import com.cyh.ums.dao.LanguageCodeMapper;
import com.cyh.ums.dao.LookupMapper;
import com.cyh.ums.domain.LanguageCode;
import com.cyh.ums.domain.LookupItem;
import com.cyh.ums.serviceI.LanguageCodeService;
import com.cyh.ums.util.Constant;
import com.cyh.ums.util.LookupUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class LanguageCodeServiceImp implements LanguageCodeService{
    @Autowired
    private LanguageCodeMapper languageCodeMapper;
    @Autowired
    private LookupMapper lookupMapper;
    @Override
    public List<LanguageCode> list(Integer languageType) {
        List<LookupItem> lookupItemBylookupCode = lookupMapper.findLookupItemBylookupCode(Constant.LANGUAGE_TYPE);
        String languageTypeStr="zh";

        return languageCodeMapper.list(languageTypeStr);
    }
}
