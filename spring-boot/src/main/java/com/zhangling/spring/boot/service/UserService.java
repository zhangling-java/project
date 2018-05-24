package com.zhangling.spring.boot.service;

import com.zhangling.spring.boot.exception.ServerException;
import com.zhangling.spring.boot.model.db.UserDBModel;
import com.zhangling.spring.boot.model.rt.UserLoginRequestModel;
import com.zhangling.spring.boot.model.rt.UserRegisterRequestModel;


public interface UserService {
    public UserDBModel login(UserDBModel userDBModel) throws ServerException;
    public UserDBModel register(UserDBModel userDBModel) throws ServerException;
}
