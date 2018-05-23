package com.lingcloud.spring.model.ex;

public class ServerEXModel {

    public enum CodeEnum {
        ErrorPassword(10000,"密码错误");


        private Integer code;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        private  String message;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        private CodeEnum(Integer code,String message){
            this.code = code;
            this.message = message;
        }

    }

    public CodeEnum getCodeEnum() {
        return codeEnum;
    }


    public void setCodeEnum(CodeEnum codeEnum) {
        this.codeEnum = codeEnum;
    }

    private CodeEnum codeEnum;
    private Integer code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private  String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ServerEXModel(){

    }
    public ServerEXModel(Integer code, String message){
        this.code = code;
        this.message = message;
    }
    public ServerEXModel(CodeEnum codeEnum){
        this.codeEnum = codeEnum;
    }
}
