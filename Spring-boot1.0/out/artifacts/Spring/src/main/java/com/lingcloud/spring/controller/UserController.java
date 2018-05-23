package com.lingcloud.spring.controller;

import com.lingcloud.spring.model.re.REBaseModel;
import com.lingcloud.spring.model.ui.UIUserModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public @ResponseBody REBaseModel login(){
        REBaseModel baseModel = new REBaseModel();
        baseModel.setData(new UIUserModel("zhangling","123456"));
        return baseModel;
    }
}
