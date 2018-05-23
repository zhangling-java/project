package com.ccydsz.ysec.obd;
import com.ccydsz.ysec.obd.model.ex.EXServerModel;
import com.ccydsz.ysec.obd.model.re.REBaseModel;
import javassist.NotFoundException;
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

/**
 * @author yoqu
 * @date 2017年06月30日
 * @time 下午2:53
 * @email wcjiang2@iflytek.com
 */
@ControllerAdvice
@ResponseBody
public class ServerExceptionHandler {

//    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);



    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    REBaseModel validateErrorHandler(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        if (bindingResult.hasErrors()) {
            List<FieldError> errorList = bindingResult.getFieldErrors();
            String errorMsg = errorList.get(0).getField() + " 字段错误，错误原因:" + errorList.get(0).getDefaultMessage();
            REBaseModel res = new REBaseModel();
            res.setData(new EXServerModel(HttpStatus.BAD_REQUEST.value(),errorMsg));
            res.setSuccess(false);
            return res;
        } else {
            REBaseModel res = new REBaseModel();
            EXServerModel serverErrorModel = new EXServerModel();
            serverErrorModel.setMessage(e.getMessage());
            res.setSuccess(false);
            res.setData(serverErrorModel);
            return res;
        }
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    REBaseModel validateHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        REBaseModel res = new REBaseModel();
        res.setSuccess(false);
        res.setData(new EXServerModel(HttpStatus.BAD_REQUEST.value(),e.getMessage()));
        return res;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody
    REBaseModel validate400Exception(NoHandlerFoundException e) {
        REBaseModel res = new REBaseModel();
        res.setSuccess(false);
        res.setData(new EXServerModel(HttpStatus.NOT_FOUND.value(),e.getMessage()));
        return res;
    }


    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    REBaseModel errorHandler(HttpServletRequest request, Exception e) {
        REBaseModel res = new REBaseModel();
        res.setSuccess(false);
        res.setData(new EXServerModel(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage()));
        return res;
    }
}
