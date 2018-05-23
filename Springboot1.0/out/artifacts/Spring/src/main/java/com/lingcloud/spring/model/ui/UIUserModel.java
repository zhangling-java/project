package com.lingcloud.spring.model.ui;

public class UIUserModel {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    private String password;
    private String name;
    private String nickname;

    public UIUserModel(String account, String password){
        this.account = account;
        this.password = password;
    }

}
