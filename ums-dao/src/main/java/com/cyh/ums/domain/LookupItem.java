package com.cyh.ums.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author CYH
 */
public class LookupItem implements Serializable {
    private static final long serialVersionUID = 3825926741568073198L;
    private Long lookupItemId;

    private Long lookupId;

    private String lookupItemCode;

    private String lookupItemName;

    private String language;

    private String version;

    private Date createDate;

    private Date updateDate;

    private String describeInfo;

    public Long getLookupItemId() {
        return lookupItemId;
    }

    public void setLookupItemId(Long lookupItemId) {
        this.lookupItemId = lookupItemId;
    }

    public Long getLookupId() {
        return lookupId;
    }

    public void setLookupId(Long lookupId) {
        this.lookupId = lookupId;
    }

    public String getLookupItemCode() {
        return lookupItemCode;
    }

    public void setLookupItemCode(String lookupItemCode) {
        this.lookupItemCode = lookupItemCode == null ? null : lookupItemCode.trim();
    }

    public String getLookupItemName() {
        return lookupItemName;
    }

    public void setLookupItemName(String lookupItemName) {
        this.lookupItemName = lookupItemName == null ? null : lookupItemName.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDescribeInfo() {
        return describeInfo;
    }

    public void setDescribeInfo(String describeInfo) {
        this.describeInfo = describeInfo == null ? null : describeInfo.trim();
    }
}