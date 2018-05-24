package com.zhangling.mybatis.service;

import com.zhangling.mybatis.exception.ServerException;
import com.zhangling.mybatis.model.db.UserDBModel;


public interface UserService {
    public UserDBModel login(UserDBModel userDBModel) throws ServerException;
    public UserDBModel register(UserDBModel userDBModel) throws ServerException;
}
