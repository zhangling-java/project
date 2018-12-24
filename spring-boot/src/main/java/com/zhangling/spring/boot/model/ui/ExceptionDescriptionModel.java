package com.zhangling.spring.boot.model.ui;
public class ExceptionDescriptionModel {
    //可以枚举出来的异常
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

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public ExceptionDescriptionModel() {

    }
    public ExceptionDescriptionModel(int code, String message) {
        this.code = code;
        this.message = message;
    }
    private int code;
    private String message;
}
