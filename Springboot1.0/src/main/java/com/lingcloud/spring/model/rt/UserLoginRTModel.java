package com.lingcloud.spring.model.rt;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class UserLoginRTModel {
    @NotNull(message = "用户名不能为空")
    @Length(min = 4,max = 32,message = "用户名长度为4-32位")
    private String account;
    private String name;
    private String nickName;
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @NotNull(message = "密码不能为空")
    private String password;
    @Email(message = "Not a vaild Email Address")
    private String email;
    private int phone;
}
