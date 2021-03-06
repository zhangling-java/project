package com.zhangling.mybatis.controller;

import com.alibaba.fastjson.JSON;
import com.zhangling.mybatis.exception.ServerException;
import com.zhangling.mybatis.model.ResponseModel;
import com.zhangling.mybatis.model.db.UserDBModel;
import com.zhangling.mybatis.model.rt.UserLoginRequestModel;
import com.zhangling.mybatis.model.rt.UserRegisterRequestModel;
import com.zhangling.mybatis.model.ui.ExceptionDescriptionModel;
import com.zhangling.mybatis.model.ui.UserModel;
import com.zhangling.mybatis.service.UserService;
import com.zhangling.mybatis.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserService userService;

    @ResponseBody
    @PostMapping("register")
    public ResponseModel register(@Valid @RequestBody UserRegisterRequestModel userRegisterRequestModel){
        ResponseModel userModelResponseModel = new ResponseModel();
        try {
            UserDBModel userDBModel = JSON.parseObject(JSON.toJSONString(userRegisterRequestModel),UserDBModel.class);
            StringUtil.PasswordUtil.PasswordModel passwordModel = StringUtil.PasswordUtil.generate(userDBModel.getPassword(),StringUtil.PasswordUtil.Type.MD5);
            userDBModel.setPassword(passwordModel.getEncryptedPassword());
            userDBModel.setSalt(passwordModel.getSalt());
            userDBModel.setPasswordEncryptedCount(passwordModel.getEncryptedCount());
            UserModel userModel = JSON.parseObject(JSON.toJSONString(userService.register(userDBModel)),UserModel.class);
            userModelResponseModel.setData(userModel);
            userModelResponseModel.setSuccess(true);
        }catch (UnsupportedEncodingException e) {
            ExceptionDescriptionModel exceptionDescriptionModel = new ExceptionDescriptionModel();
            exceptionDescriptionModel.setMessage(e.getMessage());
            userModelResponseModel.setData(exceptionDescriptionModel);
        } catch (ServerException e) {
            if (e.getExceptionDescriptionModel() != null){
                userModelResponseModel.setData(e.getExceptionDescriptionModel());
            }else {
                ExceptionDescriptionModel exceptionDescriptionModel = new ExceptionDescriptionModel();
                exceptionDescriptionModel.setMessage(e.getMessage());
                userModelResponseModel.setData(exceptionDescriptionModel);
            }
        }
        return  userModelResponseModel;
    }

    @ResponseBody
    @PostMapping("login")
    public ResponseModel login(@Valid @RequestBody UserLoginRequestModel userLoginRequestModel){
        ResponseModel userModelResponseModel = new ResponseModel();
        try {
            UserDBModel userRequestDBModel = JSON.parseObject(JSON.toJSONString(userLoginRequestModel),UserDBModel.class);
            UserDBModel userDBModel = userService.login(userRequestDBModel);
            if (!StringUtil.PasswordUtil.verify(userRequestDBModel.getPassword(),userDBModel.getSalt(),StringUtil.PasswordUtil.Type.MD5,userDBModel.getPassword(),userDBModel.getPasswordEncryptedCount())){
                ExceptionDescriptionModel exceptionDescriptionModel = new ExceptionDescriptionModel();
                exceptionDescriptionModel.setMessage(ExceptionDescriptionModel.CodeEnum.ErrorPassword.getMessage());
                exceptionDescriptionModel.setCode(ExceptionDescriptionModel.CodeEnum.ErrorPassword.getCode());
                userModelResponseModel.setData(exceptionDescriptionModel);
            }else {
                UserModel userModel = JSON.parseObject(JSON.toJSONString(userDBModel),UserModel.class);
                userModelResponseModel.setData(userModel);
                userModelResponseModel.setSuccess(true);
            }
        }catch (UnsupportedEncodingException e) {
            ExceptionDescriptionModel exceptionDescriptionModel = new ExceptionDescriptionModel();
            exceptionDescriptionModel.setMessage(e.getMessage());
            userModelResponseModel.setData(exceptionDescriptionModel);
        } catch (ServerException e) {
            if (e.getExceptionDescriptionModel() != null){
                userModelResponseModel.setData(e.getExceptionDescriptionModel());
            }else {
                ExceptionDescriptionModel exceptionDescriptionModel = new ExceptionDescriptionModel();
                exceptionDescriptionModel.setMessage(e.getMessage());
                userModelResponseModel.setData(exceptionDescriptionModel);
            }
        }
        return  userModelResponseModel;
    }
}
