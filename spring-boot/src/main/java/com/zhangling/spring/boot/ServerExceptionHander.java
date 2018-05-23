package com.zhangling.spring.boot;

import com.zhangling.spring.boot.exception.ServerException;
import com.zhangling.spring.boot.model.ResponseModel;
import com.zhangling.spring.boot.model.ui.ExceptionDescriptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

@ControllerAdvice
@ResponseBody
public class ServerExceptionHander {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseModel handle400Exception(MissingServletRequestParameterException exception){
        ResponseModel responseModel = new ResponseModel();
        responseModel.setSuccess(false);
        ExceptionDescriptionModel exceptionDescriptionModel = new ExceptionDescriptionModel();
        exceptionDescriptionModel.setCode(HttpStatus.BAD_REQUEST.value());
        exceptionDescriptionModel.setMessage(exception.getMessage());
        responseModel.setData(exceptionDescriptionModel);
        return responseModel;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseModel handle400Exception(HttpMessageNotReadableException exception){
        ResponseModel responseModel = new ResponseModel();
        responseModel.setSuccess(false);
        ExceptionDescriptionModel exceptionDescriptionModel = new ExceptionDescriptionModel();
        exceptionDescriptionModel.setCode(HttpStatus.BAD_REQUEST.value());
        exceptionDescriptionModel.setMessage(exception.getMessage());
        responseModel.setData(exceptionDescriptionModel);
        return responseModel;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseModel handle400Exception(MethodArgumentNotValidException exception){
        ResponseModel responseModel = new ResponseModel();
        responseModel.setSuccess(false);
        ExceptionDescriptionModel exceptionDescriptionModel = new ExceptionDescriptionModel();
        exceptionDescriptionModel.setCode(HttpStatus.BAD_REQUEST.value());
        exceptionDescriptionModel.setMessage(exception.getMessage());
        responseModel.setData(exceptionDescriptionModel);
        return responseModel;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public ResponseModel handle400Exception(BindException exception){
        ResponseModel responseModel = new ResponseModel();
        responseModel.setSuccess(false);
        ExceptionDescriptionModel exceptionDescriptionModel = new ExceptionDescriptionModel();
        exceptionDescriptionModel.setCode(HttpStatus.BAD_REQUEST.value());
        exceptionDescriptionModel.setMessage(exception.getMessage());
        responseModel.setData(exceptionDescriptionModel);
        return responseModel;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseModel handle400Exception(ConstraintViolationException exception){
        ResponseModel responseModel = new ResponseModel();
        responseModel.setSuccess(false);
        ExceptionDescriptionModel exceptionDescriptionModel = new ExceptionDescriptionModel();
        exceptionDescriptionModel.setCode(HttpStatus.BAD_REQUEST.value());
        exceptionDescriptionModel.setMessage(exception.getMessage());
        responseModel.setData(exceptionDescriptionModel);
        return responseModel;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public ResponseModel handle400Exception(ValidationException exception){
        ResponseModel responseModel = new ResponseModel();
        responseModel.setSuccess(false);
        ExceptionDescriptionModel exceptionDescriptionModel = new ExceptionDescriptionModel();
        exceptionDescriptionModel.setCode(HttpStatus.BAD_REQUEST.value());
        exceptionDescriptionModel.setMessage(exception.getMessage());
        responseModel.setData(exceptionDescriptionModel);
        return responseModel;
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseModel handle405Exception(HttpRequestMethodNotSupportedException exception){
        ResponseModel responseModel = new ResponseModel();
        responseModel.setSuccess(false);
        ExceptionDescriptionModel exceptionDescriptionModel = new ExceptionDescriptionModel();
        exceptionDescriptionModel.setCode(HttpStatus.METHOD_NOT_ALLOWED.value());
        exceptionDescriptionModel.setMessage(exception.getMessage());
        responseModel.setData(exceptionDescriptionModel);
        return responseModel;
    }

    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseModel handle415Exception(HttpMediaTypeNotSupportedException exception){
        ResponseModel responseModel = new ResponseModel();
        responseModel.setSuccess(false);
        ExceptionDescriptionModel exceptionDescriptionModel = new ExceptionDescriptionModel();
        exceptionDescriptionModel.setCode(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value());
        exceptionDescriptionModel.setMessage(exception.getMessage());
        responseModel.setData(exceptionDescriptionModel);
        return responseModel;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseModel handle500Exception(Exception exception){
        ResponseModel responseModel = new ResponseModel();
        responseModel.setSuccess(false);
        ExceptionDescriptionModel exceptionDescriptionModel = new ExceptionDescriptionModel();
        exceptionDescriptionModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        exceptionDescriptionModel.setMessage(exception.getMessage());
        responseModel.setData(exceptionDescriptionModel);
        return responseModel;
    }
}
