package com.ccydsz.ysec.obd.controller;
import com.alibaba.fastjson.JSONObject;
import com.ccydsz.ysec.obd.exception.ServiceException;
import com.ccydsz.ysec.obd.model.db.UserModel;
import com.ccydsz.ysec.obd.model.ex.EXServerModel;
import com.ccydsz.ysec.obd.model.rt.RTLoginModel;
import com.ccydsz.ysec.obd.service.UserService;
import com.ccydsz.ysec.obd.util.RSAUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.ccydsz.ysec.obd.model.re.REBaseModel;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/user") // This means URL's start with /demo (after Application path)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/register/verify")
    public @ResponseBody
    REBaseModel verifyRegister(@RequestBody @Valid RTLoginModel rtLoginModel){
        UserModel userModel = JSONObject.parseObject(JSONObject.toJSONString(rtLoginModel),UserModel.class); //gson.fromJson(gson.toJson(RTLoginModel),UserModel.class);
        REBaseModel REBaseModel = new REBaseModel();
        try {
            REBaseModel.setData(userService.verifyPhoneNumberRegister(userModel));
        }catch (ServiceException serviceException){
            REBaseModel.setData(serviceException.getServerErrorModel());
        }catch (RuntimeException exception){
            REBaseModel.setData(new EXServerModel(-1,exception.getCause().getMessage()));
        }
        return REBaseModel;

    }

    @PostMapping(path = "/register")
    public @ResponseBody
    REBaseModel register(@RequestBody @Valid RTLoginModel rtLoginModel){
        UserModel userModel = JSONObject.parseObject(JSONObject.toJSONString(rtLoginModel),UserModel.class);
        REBaseModel REBaseModel = new REBaseModel();
        try {
            REBaseModel.setData(userService.register(userModel));
            REBaseModel.setSuccess(true);
        }catch (ServiceException serviceException){
            REBaseModel.setData(serviceException.getServerErrorModel());
            REBaseModel.setSuccess(false);
        }catch (RuntimeException exception){
            REBaseModel.setData(exception);
            REBaseModel.setSuccess(false);
        }
        return REBaseModel;

    }

    @PostMapping(path="/login") // Map ONLY GET Requests
    @ResponseBody
    public REBaseModel login (@RequestBody @Valid RTLoginModel rtLoginModel
    ) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        REBaseModel reBaseModel = new REBaseModel();
        try {
            rtLoginModel.setPassword(RSAUtils.privateDecrypt(rtLoginModel.getPassword(),RSAUtils.getPrivateKey(RSAUtils.privateKey)));
        } catch (NoSuchAlgorithmException e) {
            reBaseModel.setData(e);
            reBaseModel.setSuccess(false);
        } catch (InvalidKeySpecException e) {
            reBaseModel.setData(e);
            reBaseModel.setSuccess(false);
        }
        UserModel userModel = JSONObject.parseObject(JSONObject.toJSONString(rtLoginModel),UserModel.class); //gson.fromJson(gson.toJson(RTLoginModel),UserModel.class);




        try {
            reBaseModel.setData(userService.login(userModel));
            reBaseModel.setSuccess(true);
        }catch (ServiceException serviceException){
            reBaseModel.setData(serviceException.getServerErrorModel());
            reBaseModel.setSuccess(false);
        }catch (RuntimeException exception){
            reBaseModel.setData(exception);
            reBaseModel.setSuccess(false);
        }
        return reBaseModel;
    }

    @GetMapping(path="/login") // Map ONLY GET Requests
    @ResponseBody
    public REBaseModel login_GET (@RequestParam("account") @Valid String account,@RequestParam("password") @Valid String password
    ) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        UserModel userModel = new UserModel(); //JSONObject.parseObject(JSONObject.toJSONString(rtLoginModel),UserModel.class); //gson.fromJson(gson.toJson(RTLoginModel),UserModel.class);
        userModel.setAccount(account);
        userModel.setPassword(password);
        REBaseModel reBaseModel = new REBaseModel();
        try {
            reBaseModel.setData(userService.login(userModel));
            reBaseModel.setSuccess(true);
        }catch (ServiceException serviceException){
            reBaseModel.setData(serviceException.getServerErrorModel());
            reBaseModel.setSuccess(false);
        }catch (RuntimeException exception){
            reBaseModel.setData(exception);
            reBaseModel.setSuccess(false);
        }
        return reBaseModel;
    }

    @PostMapping(path="/login/weixin") // Map ONLY GET Requests
    public @ResponseBody
    REBaseModel weiXinLogin (@RequestBody @Valid UserModel userModel
    ) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        REBaseModel REBaseModel = new REBaseModel();
        try {
            REBaseModel.setData(userService.weiXinLogin(userModel));
            REBaseModel.setSuccess(true);
        }catch (ServiceException serviceException){
            REBaseModel.setData(serviceException.getServerErrorModel());
            REBaseModel.setSuccess(false);
        }catch (RuntimeException exception){
            REBaseModel.setData(exception);
            REBaseModel.setSuccess(false);
        }
        return REBaseModel;
    }


    @PostMapping(path="/search/card") // Map ONLY GET Requests
    public @ResponseBody
    REBaseModel searchCard (@RequestBody @Valid UserModel userModel) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        REBaseModel REBaseModel = new REBaseModel();
        try {
            REBaseModel.setData(userService.login(userModel));
            REBaseModel.setSuccess(true);
        }catch (ServiceException serviceException){
            REBaseModel.setData(serviceException.getServerErrorModel());
            REBaseModel.setSuccess(false);
        }catch (RuntimeException exception){
            REBaseModel.setData(exception);
            REBaseModel.setSuccess(false);
        }
        return REBaseModel;
    }

    @PostMapping(path="/add/in/card") // Map ONLY GET Requests
    public @ResponseBody
    REBaseModel addInCard (@RequestBody @Valid UserModel userModel) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        REBaseModel REBaseModel = new REBaseModel();
        try {
            REBaseModel.setData(userService.addInCard(userModel));
            REBaseModel.setSuccess(true);
        }catch (ServiceException serviceException){
            REBaseModel.setData(serviceException.getServerErrorModel());
            REBaseModel.setSuccess(false);
        }catch (RuntimeException exception){
            REBaseModel.setData(exception);
            REBaseModel.setSuccess(false);
        }
        return REBaseModel;
    }



}
