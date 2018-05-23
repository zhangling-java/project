package com.zhangling.spring.boot1_0;

import com.zhangling.spring.boot1_0.model.ex.ServerEXModel;
import com.zhangling.spring.boot1_0.model.re.BaseREModel;
//import org.springframework.boot.actuate.endpoint.invoke.MissingParametersException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ControllerAdvice
@ResponseBody
public class ServerExceptionHander {
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    BaseREModel validateErrorHandler(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        if (bindingResult.hasErrors()) {
            List<FieldError> errorList = bindingResult.getFieldErrors();
            String errorMsg = errorList.get(0).getField() + " 字段错误，错误原因:" + errorList.get(0).getDefaultMessage();
            BaseREModel res = new BaseREModel();
            ServerEXModel serverErrorModel = new ServerEXModel(HttpStatus.BAD_REQUEST.value(),errorMsg);
            res.setData(serverErrorModel);
            res.setSuccess(false);
            return res;
        } else {
            BaseREModel res = new BaseREModel();
            res.setSuccess(false);
            res.setData(e);
            return res;
        }
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    BaseREModel validateHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        BaseREModel res = new BaseREModel();
        ServerEXModel serverErrorModel = new ServerEXModel(HttpStatus.BAD_REQUEST.value(),e.getMessage());
        res.setData(serverErrorModel);
        res.setSuccess(false);
        return res;
    }

//    @ExceptionHandler(MissingParametersException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public @ResponseBody
//    BaseREModel validateMissingParametersException(MissingParametersException e) {
//        BaseREModel res = new BaseREModel();
//        ServerEXModel serverErrorModel = new ServerEXModel(HttpStatus.BAD_REQUEST.value(),e.getMessage());
//        res.setData(serverErrorModel);
//        res.setSuccess(false);
//        return res;
//    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody
    BaseREModel validate400Exception(NoHandlerFoundException e) {
        BaseREModel res = new BaseREModel();
        res.setSuccess(false);
        res.setData(new ServerEXModel(HttpStatus.NOT_FOUND.value(),e.getMessage()));
        return res;
    }


    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    BaseREModel errorHandler(HttpServletRequest request, Exception e) {
        BaseREModel res = new BaseREModel();
        ServerEXModel serverErrorModel = new ServerEXModel(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage());
        res.setData(serverErrorModel);
        res.setSuccess(false);
        return res;
    }
}
