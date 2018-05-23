package com.ccydsz.ysec.obd.model.rt;

import com.ccydsz.ysec.obd.model.ClientInfoModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RTLoginModel {
    private String name;


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
    @NotNull(message = "用户名不能为空")
    @Length(min = 4,max = 32,message = "用户名长度为4-32位")
    private String account;
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull(message = "密码不能为空")
//    @Length(min = 8,max = 32,message = "密码长度为8-32位")
    private String password;

    public ClientInfoModel getClientInfoModel() {
        return clientInfoModel;
    }

    public void setClientInfoModel(ClientInfoModel clientInfoModel) {
        this.clientInfoModel = clientInfoModel;
    }

    private ClientInfoModel clientInfoModel;
}
