package com.zhangling.spring.boot.exception;

import com.zhangling.spring.boot.model.ui.ExceptionDescriptionModel;

public class ServerException extends RuntimeException {

    public ServerException(){

    }

    public ServerException(ExceptionDescriptionModel exceptionDescriptionModel){
        this.exceptionDescriptionModel = exceptionDescriptionModel;
    }

    public ExceptionDescriptionModel getExceptionDescriptionModel() {
        return exceptionDescriptionModel;
    }

    public void setExceptionDescriptionModel(ExceptionDescriptionModel exceptionDescriptionModel) {
        this.exceptionDescriptionModel = exceptionDescriptionModel;
    }

    private ExceptionDescriptionModel exceptionDescriptionModel;

}
