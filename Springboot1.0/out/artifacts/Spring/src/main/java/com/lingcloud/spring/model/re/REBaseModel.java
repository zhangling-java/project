package com.lingcloud.spring.model.re;

import com.lingcloud.spring.model.error.ServerError;

public class REBaseModel<T> {
    private T data;
    private ServerError serverError;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ServerError getServerError() {
        return serverError;
    }

    public void setServerError(ServerError serverError) {
        this.serverError = serverError;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    private Boolean success;
}
