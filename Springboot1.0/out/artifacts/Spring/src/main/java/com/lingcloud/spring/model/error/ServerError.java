package com.lingcloud.spring.model.error;

public class ServerError {
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMeaagse() {
        return meaagse;
    }

    public void setMeaagse(String meaagse) {
        this.meaagse = meaagse;
    }

    private String meaagse;
}
