package com.cyh.ums.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;

@ApiModel(value = "响应前端结果集类")
public class Result<T>{
    @ApiModelProperty(name="status",value="响应状态(0:成功，默认成功)",dataType = "Integer",example = "0",required = true)
    private Integer status=0;
    @ApiModelProperty(name="message",value="消息",dataType = "String",example = "消息",required = false)
    private String message;
    @ApiModelProperty(name="data",value="响应数据",required = false)
    private T data;

    public Result() {
    }

    public Result(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Result(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Result(T data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
