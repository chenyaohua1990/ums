package com.cyh.ums.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
@ApiModel(value = "角色实体类",description = "对应角色表")
public class TRole {
    @ApiModelProperty(name = "roleId",value = "角色表id",dataType = "Long",required = false,example = "1")
    private Long roleId;
    @ApiModelProperty(name = "roleName",value = "角色名称",dataType = "String",required = false,example = "主管")
    private String roleName;
    @ApiModelProperty(name = "createDate",value = "创建时间",dataType = "Date",required = false,example = "2018-09-12 20:30:22")
    private Date createDate;
    @ApiModelProperty(name = "updateDate",value = "最后更新时间",dataType = "Date",required = false,example = "2018-09-12 20:30:22")
    private Date updateDate;
    @ApiModelProperty(name = "describeInfo",value = "描述",dataType = "String",required = false,example = "这是组实体类")
    private String describeInfo;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
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