package com.cyh.ums.serviceI;

import com.cyh.ums.domain.LookupItem;

import java.util.List;

public interface LookupService {
    /**
     * 根据lookupcode获取lookup信息
     * @param lookupCode
     * @return
     */
    List<LookupItem> lookup(String lookupCode);
}
