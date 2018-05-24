package com.zhangling.mybatis.service;

import com.zhangling.mybatis.exception.ServerException;
import com.zhangling.mybatis.mapper.UserMapper;
import com.zhangling.mybatis.model.db.UserDBModel;
import com.zhangling.mybatis.model.ui.ExceptionDescriptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public UserDBModel register(UserDBModel userDBModel) throws ServerException {
        UserDBModel userModelInDB = userMapper.findByAccount(userDBModel.getAccount());
        if (userModelInDB != null){
            ExceptionDescriptionModel exceptionDescriptionModel = new ExceptionDescriptionModel();
            exceptionDescriptionModel.setCode(ExceptionDescriptionModel.CodeEnum.DidRegister.getCode());
            exceptionDescriptionModel.setMessage(ExceptionDescriptionModel.CodeEnum.DidRegister.getMessage());
            throw new ServerException(exceptionDescriptionModel);
        }
        userMapper.save(userDBModel);
        return userMapper.findByAccount(userDBModel.getAccount());
    }
    @Override
    public UserDBModel login(UserDBModel userDBModel) throws ServerException {
        UserDBModel userModelInDB = userMapper.findByAccount(userDBModel.getAccount());
        if (userModelInDB == null){
            ExceptionDescriptionModel exceptionDescriptionModel = new ExceptionDescriptionModel();
            exceptionDescriptionModel.setCode(ExceptionDescriptionModel.CodeEnum.NoUser.getCode());
            exceptionDescriptionModel.setMessage(ExceptionDescriptionModel.CodeEnum.NoUser.getMessage());
            throw new ServerException(exceptionDescriptionModel);
        }
        return  userModelInDB;

    }



}
