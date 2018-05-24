package com.zhangling.mybatis.model.rt;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterRequestModel {
    @NotNull
    @Size(min=2, max=32)
    private String account;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull
    private String password;
}
