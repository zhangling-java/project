package com.lingcloud.spring.model.db;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class UserDBModel extends BaseDBModel {
    @Column(unique=true,nullable=false,length = 32)
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Column(nullable=false)
    private String password;
    @Column(unique=true)
    private String email;
    @Column(unique=true)
    private String phone;


    public UserDBModel(String account, String password){
        this.account = account;
        this.password = password;
    }
}
