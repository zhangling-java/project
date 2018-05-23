package com.zhangling.controller;

import com.zhangling.model.ResponseModel;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/greeting")
    @ResponseBody
    public ResponseModel greeting(@RequestParam(value="name", defaultValue="World") String name) {
        ResponseModel res = new ResponseModel();
        res.setSuccess(true);
        res.setData(name);
        return res;
    }
}
