package com.ccydsz.ysec.obd.model;


import com.ccydsz.ysec.obd.model.db.UserModel;

import javax.persistence.*;

@Entity
public class UserTokenModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String userToken;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }


    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    @OneToOne(mappedBy = "userTokenModel", fetch=FetchType.EAGER)
    private UserModel userModel;
}
