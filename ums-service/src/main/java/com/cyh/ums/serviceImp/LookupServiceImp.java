package com.cyh.ums.serviceImp;

import com.cyh.ums.dao.LookupMapper;
import com.cyh.ums.domain.LookupItem;
import com.cyh.ums.serviceI.LookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LookupServiceImp implements LookupService{

    @Autowired
    private LookupMapper    lookupMapper;


    @Override
    @Cacheable(key = "'lookupCode_'+#lookupCode",value = "lookupCode" ,unless = "#result==null")
    public List<LookupItem> lookup(String lookupCode) {

        return lookupMapper.findLookupItemBylookupCode(lookupCode);
    }
}
