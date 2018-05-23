package com.ccydsz.ysec.obd.model.ex;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class EXServerModel {
    public enum CodeEnum{
        DidRegister(-10000,"已注册"),
        NoUser(-10001,"用户未注册"),
        ErrorPassword(-10002,"密码错误");



        private Integer code;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        private String message;
        private CodeEnum(Integer code,String message){
            this.code = code;
            this.message = message;

        }

    }
    private CodeEnum codeEnum;
    private String improveMethod;
    private Integer code;

    public CodeEnum getCodeEnum() {
        return codeEnum;
    }

    public void setCodeEnum(CodeEnum codeEnum) {
        this.codeEnum = codeEnum;
    }

    public String getImproveMethod() {
        return improveMethod;
    }

    public void setImproveMethod(String improveMethod) {
        this.improveMethod = improveMethod;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public EXServerModel(){

    }

    public EXServerModel(CodeEnum codeEnum){

        this.codeEnum = codeEnum;
    }
    public EXServerModel(Integer code, String message){
        this.code = code;
        this.message = message;
    }


}
