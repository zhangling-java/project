package com.lingcloud.spring.controller;

import com.lingcloud.spring.model.ex.ServerEXModel;
import com.lingcloud.spring.model.re.BaseREModel;
import com.lingcloud.spring.model.rt.UserLoginRTModel;
import com.lingcloud.spring.model.ui.UserUIModel;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    public @ResponseBody
    BaseREModel login(@RequestBody @Valid UserLoginRTModel userLoginModel){
        BaseREModel baseModel = new BaseREModel();
        if (userLoginModel.getPassword().equals("123456")) {
            baseModel.setSuccess(true);
            baseModel.setData(new UserUIModel(userLoginModel.getAccount(),userLoginModel.getPassword()));
        }else {
            baseModel.setSuccess(false);
            baseModel.setData(new ServerEXModel(ServerEXModel.CodeEnum.ErrorPassword));
        }
        return baseModel;
    }
}
