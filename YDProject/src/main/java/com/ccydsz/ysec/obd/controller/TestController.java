package com.ccydsz.ysec.obd.controller;

import com.alibaba.fastjson.JSONObject;
import com.ccydsz.ysec.obd.exception.ServiceException;
import com.ccydsz.ysec.obd.model.db.DBTestTypeModel;
import com.ccydsz.ysec.obd.model.db.config.CGTestTypeModel;
import com.ccydsz.ysec.obd.model.re.REBaseModel;
import com.ccydsz.ysec.obd.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/test") // This means URL's start with /demo (after Application path)
public class TestController {

     static public class RTModel{
         public List<RTTestTypeModel> getDatas() {
             return datas;
         }

         public void setDatas(List<RTTestTypeModel> datas) {
             this.datas = datas;
         }

         List<RTTestTypeModel> datas;
    }
    static public class RTTestTypeModel {
        static public class RTTestTypeItemModel {
            private String title;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSuperTitle() {
                return superTitle;
            }

            public void setSuperTitle(String superTitle) {
                this.superTitle = superTitle;
            }

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

            private String path;

            private String superTitle;
        }
        private String title;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<RTTestTypeItemModel> getModels() {
            return models;
        }

        public void setModels(List<RTTestTypeItemModel> models) {
            this.models = models;
        }

        private List<RTTestTypeItemModel> models;
    }

    @Autowired
    private TestService testService;

    @GetMapping(path = "/config/allTest")
    public @ResponseBody
    REBaseModel getConfigAllTest(){
        REBaseModel REBaseModel = new REBaseModel();
        try {
            REBaseModel.setSuccess(true);
            REBaseModel.setData(testService.getConfigAllTest());
        }catch (ServiceException serviceException){
            REBaseModel.setSuccess(false);
            REBaseModel.setData(serviceException.getServerErrorModel());
        }catch (RuntimeException exception){
            REBaseModel.setSuccess(false);
            REBaseModel.setData(exception);
        } catch (FileNotFoundException exception) {
            REBaseModel.setSuccess(false);
            REBaseModel.setData(exception);
        } catch (IOException exception) {
            REBaseModel.setSuccess(false);
            REBaseModel.setData(exception);
        }
        return REBaseModel;
    }

    @PostMapping(path = "/config/allTest")
    public @ResponseBody
    REBaseModel configAllTest(@RequestBody @Valid RTModel requestModel){
        List<CGTestTypeModel> models = new ArrayList<CGTestTypeModel>();
        for (RTTestTypeModel m:requestModel.datas) {
            CGTestTypeModel model = JSONObject.parseObject(JSONObject.toJSONString(m),CGTestTypeModel.class); //gson.fromJson(gson.toJson(m),CGTestTypeModel.class);
            models.add(model);
        }
        REBaseModel REBaseModel = new REBaseModel();
        try {
            REBaseModel.setSuccess(true);
            REBaseModel.setData(testService.createOrupdate(models));
        }catch (ServiceException serviceException){
            REBaseModel.setSuccess(false);
            REBaseModel.setData(serviceException.getServerErrorModel());
        }catch (RuntimeException exception){
            REBaseModel.setSuccess(false);
            REBaseModel.setData(exception);
        }
        return REBaseModel;
    }


    @PostMapping(path = "/add")
    public @ResponseBody
    REBaseModel add(@RequestBody @Valid RTModel requestModel){
        List<DBTestTypeModel> models = new ArrayList<DBTestTypeModel>();
        for (RTTestTypeModel m:requestModel.datas) {
            DBTestTypeModel model = JSONObject.parseObject(JSONObject.toJSONString(m),DBTestTypeModel.class); //gson.fromJson(gson.toJson(m),DBTestTypeModel.class);
            models.add(model);
        }
        REBaseModel REBaseModel = new REBaseModel();
        try {
            REBaseModel.setSuccess(true);
            REBaseModel.setData(testService.create(models));
        }catch (ServiceException serviceException){
            REBaseModel.setSuccess(false);
            REBaseModel.setData(serviceException.getServerErrorModel());
        }catch (RuntimeException exception){
            REBaseModel.setSuccess(false);
            REBaseModel.setData(exception);
        }
        return REBaseModel;
    }

    @GetMapping(path = "/getLatest")
    public @ResponseBody
    REBaseModel add(){
        REBaseModel REBaseModel = new REBaseModel();
        try {
            REBaseModel.setSuccess(true);
            REBaseModel.setData(testService.findLatest());
        }catch (ServiceException serviceException){
            REBaseModel.setSuccess(false);
            REBaseModel.setData(serviceException.getServerErrorModel());
        }catch (RuntimeException exception){
            REBaseModel.setSuccess(false);
            REBaseModel.setData(exception);
        }
        return REBaseModel;
    }

}
