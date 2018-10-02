package com.cyh.ums.util;

import com.cyh.ums.domain.LookupItem;

import java.util.List;

/**
 * lookup工具类
 */
public class LookupUtils {
    /**
     *
     * @param lookupItemBylookupCode    lookup节点集合
     * @param lookupCode lookup节点编号
     * @return  名称
     */
    public static String getLookupItemName(List<LookupItem> lookupItemBylookupCode, String lookupCode) {
        if (lookupItemBylookupCode == null) {
            return null;
        }
        for (int i = 0; i < lookupItemBylookupCode.size(); i++) {
            LookupItem lookupItem = lookupItemBylookupCode.get(i);
            if(lookupItem.getLookupItemCode().equals(lookupCode)){
                return lookupItem.getLookupItemName();
            }
        }
        return null;
    }
}
