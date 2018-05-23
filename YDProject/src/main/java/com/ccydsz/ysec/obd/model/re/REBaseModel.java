package com.ccydsz.ysec.obd.model.re;

import com.ccydsz.ysec.obd.exception.ServiceException;

public class REBaseModel<T> {
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private T data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    private Boolean success;

}
