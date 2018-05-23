package com.lingcloud.spring.exception;

import com.lingcloud.spring.model.ex.ServerEXModel;

public class ServerException extends RuntimeException {
    public ServerEXModel getServerEXModel() {
        return serverEXModel;
    }

    public void setServerEXModel(ServerEXModel serverEXModel) {
        this.serverEXModel = serverEXModel;
    }

    private ServerEXModel serverEXModel;

    public ServerException(){

    }

    public ServerException(ServerEXModel serverEXModel){
        this.serverEXModel = serverEXModel;
    }

}
