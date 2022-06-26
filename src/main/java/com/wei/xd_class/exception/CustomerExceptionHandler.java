package com.wei.xd_class.exception;

import com.wei.xd_class.utils.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author www
 * @date 2022/6/25 21:45
 * @description: TODO
 */

@ControllerAdvice
public class CustomerExceptionHandler {
    private final static Logger logger = LoggerFactory.getLogger(CustomerExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonData handle(Exception e) {
        logger.error("[ 系统异常 ] :", e);
        if (e instanceof XDException) {
            XDException xdException = (XDException) e;
            return JsonData.buildError(xdException.getCode(), xdException.getMsg());
        } else {
            return JsonData.buildError("全局异常,未知错误");
        }
    }
}
