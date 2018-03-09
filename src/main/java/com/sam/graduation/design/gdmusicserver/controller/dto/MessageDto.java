package com.sam.graduation.design.gdmusicserver.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/9 14:24:12
 */
public class MessageDto {

    @JsonProperty("message")
    private String message;

    @JsonProperty("is_success")
    private boolean isSuccess;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
