package com.cyh.ums.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
@ApiModel(value = "权限实体类",description = "对应权限表")
public class TRight {
    @ApiModelProperty(name = "rightId",value = "权限表id",dataType = "Long",required = false,example = "1")
    private Long rightId;
    @ApiModelProperty(name = "createDate",value = "创建时间",dataType = "Date",required = false,example = "2018-09-12 20:30:22")
    private Date createDate;
    @ApiModelProperty(name = "updateDate",value = "最后更新时间",dataType = "Date",required = false,example = "2018-09-12 20:30:22")
    private Date updateDate;
    @ApiModelProperty(name = "rightName",value = "权限名称",dataType = "String",required = false,example = "查看用户")
    private String rightName;
    @ApiModelProperty(name = "describeInfo",value = "描述",dataType = "String",required = false,example = "这是权限实体类")
    private String describeInfo;

    public Long getRightId() {
        return rightId;
    }

    public void setRightId(Long rightId) {
        this.rightId = rightId;
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

    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName == null ? null : rightName.trim();
    }

    public String getDescribeInfo() {
        return describeInfo;
    }

    public void setDescribeInfo(String describeInfo) {
        this.describeInfo = describeInfo == null ? null : describeInfo.trim();
    }
}