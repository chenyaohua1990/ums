package com.cyh.ums.domain;

import com.cyh.ums.validator.UserLoginCheck;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
@ApiModel(value = "用户实体类",description = "对应用户表")
public class TUser implements Serializable{
    @ApiModelProperty(name = "userId",value = "用户表id",dataType = "Long",required = false,example = "1")
    private Long userId;
    @NotBlank(message = "用户名不能为空",groups = {UserLoginCheck.class})
    @Size(min = 1,max=30)
    @ApiModelProperty(name = "userName",value = "用户名称",dataType = "String",required = false,example = "CYH")
    private String userName;
    @NotBlank(message = "用户密码不能为空",groups = {UserLoginCheck.class})
    @Pattern(regexp = "^([A-Z]|[a-z]|[0-9]|[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“'。，、？]){6,20}$",message = "用户密码必须为6-20个英文字母或符号字符",groups = {UserLoginCheck.class})
    @ApiModelProperty(name = "password",value = "用户密码",dataType = "String",required = false,example = "123456")
    private String password;
    @NotBlank(message = "用户邮箱不能为空",groups = {UserLoginCheck.class})
    @Size(min=3,max = 40,message = "邮箱地址不小于3，不大于40个字符",groups = {UserLoginCheck.class})
    @Email(message = "必须是一个邮箱地址",groups = {UserLoginCheck.class})
    @ApiModelProperty(name = "email",value = "用户邮件",dataType = "String",required = false,example = "123456@qq.com")
    private String email;
    @ApiModelProperty(name = "salt",value = "盐",dataType = "String",required = false,example = "fdsfds643434")
    private String salt;
    @ApiModelProperty(name = "createDate",value = "创建时间",dataType = "Date",required = false,example = "2018-09-12 20:30:22")
    private Date createDate;
    @ApiModelProperty(name = "updateDate",value = "最后更新时间",dataType = "Date",required = false,example = "2018-09-12 20:30:22")
    private Date updateDate;

    public TUser() {
    }

    public TUser( @NotBlank(message = "用户名不能为空", groups = {UserLoginCheck.class}) @Size(min = 1, max = 30) String userName, @NotBlank(message = "用户密码不能为空", groups = {UserLoginCheck.class}) @Pattern(regexp = "^([A-Z]|[a-z]|[0-9]|[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“'。，、？]){6,20}$", message = "用户密码必须为6-20个英文字母或符号字符", groups = {UserLoginCheck.class}) String password, @NotBlank(message = "用户邮箱不能为空", groups = {UserLoginCheck.class}) @Size(min = 3, max = 40, message = "邮箱地址不小于3，不大于40个字符", groups = {UserLoginCheck.class}) @Email(message = "必须是一个邮箱地址", groups = {UserLoginCheck.class}) String email, String salt, Date createDate, Date updateDate) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.salt = salt;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
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
}