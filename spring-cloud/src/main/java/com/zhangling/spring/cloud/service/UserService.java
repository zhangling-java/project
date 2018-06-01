package com.zhangling.spring.cloud.service;

import com.zhangling.spring.cloud.exception.ServerException;
import com.zhangling.spring.cloud.model.db.UserDBModel;


public interface UserService {
    public UserDBModel login(UserDBModel userDBModel) throws ServerException;
    public UserDBModel register(UserDBModel userDBModel) throws ServerException;
}
