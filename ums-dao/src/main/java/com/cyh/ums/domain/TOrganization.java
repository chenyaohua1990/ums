package com.cyh.ums.domain;

import java.util.Date;

public class TOrganization {
    private Long tOrganizationId;

    private Long parentOrganizationId;

    private String organizationName;

    private Date createDate;

    private Date updateDate;

    private String describeInfo;

    public Long gettOrganizationId() {
        return tOrganizationId;
    }

    public void settOrganizationId(Long tOrganizationId) {
        this.tOrganizationId = tOrganizationId;
    }

    public Long getParentOrganizationId() {
        return parentOrganizationId;
    }

    public void setParentOrganizationId(Long parentOrganizationId) {
        this.parentOrganizationId = parentOrganizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName == null ? null : organizationName.trim();
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