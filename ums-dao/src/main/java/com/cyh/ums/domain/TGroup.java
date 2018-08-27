package com.cyh.ums.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
@ApiModel(value = "组实体类",description = "对应组表")
public class TGroup {
    @ApiModelProperty(name = "groupId",value = "组表id",dataType = "Long",required = false,example = "1")
    private Long groupId;
    @ApiModelProperty(name = "groupName",value = "组名称",dataType = "String",required = false,example = "userGroup")
    private String groupName;
    @ApiModelProperty(name = "createDate",value = "创建时间",dataType = "Date",required = false,example = "2018-09-12 20:30:22")
    private Date createDate;
    @ApiModelProperty(name = "updateDate",value = "最后更新时间",dataType = "Date",required = false,example = "2018-09-12 20:30:22")
    private Date updateDate;
    @ApiModelProperty(name = "describeInfo",value = "描述",dataType = "String",required = false,example = "这是组实体类")
    private String describeInfo;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
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