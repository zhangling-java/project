package com.zhangling.spring.boot.controller;

import com.zhangling.spring.boot.model.ResponseModel;
import com.zhangling.spring.boot.model.rt.UserLoginRequestModel;
import com.zhangling.spring.boot.model.ui.UserModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @ResponseBody
    @PostMapping("login")
    public ResponseModel<UserModel> login(UserLoginRequestModel userLoginRequestModel){
        ResponseModel<UserModel> userModelResponseModel = new ResponseModel<UserModel>();
        userModelResponseModel.setSuccess(true);
        return  userModelResponseModel;
    }
}
