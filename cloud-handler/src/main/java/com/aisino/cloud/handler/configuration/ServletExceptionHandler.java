package com.aisino.cloud.handler.configuration;

import com.aisino.cloud.common.domain.ResponseMessage;
import com.aisino.cloud.common.domain.ResponseStatus;
import com.aisino.cloud.common.domain.RestResponse;
import com.aisino.cloud.common.exception.CloudException;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.UUID;

/**
 * 异常处理切面类
 * Created by fangxm on 2017-07-18.
 *
 * 注：只截获未被catch的异常
 */
@ControllerAdvice
public class ServletExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 获取异常堆栈字符串
     */
    private String getExceptionStack(Throwable e) {
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /**
     * 生成异常ID
     */
    private String genExceptionId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 自定义异常处理
     *
     * @param req 客户端请求对象
     * @param e   异常信息
     * @return RestResponse对象
     */
    @ExceptionHandler(value = CloudException.class)
    @ResponseBody
    public Object handleCloudException(HttpServletRequest req, CloudException e) {
        logger.error("[CloudException] Host[{}] Uri[{}] Status[{}] Message[{}]",
                req.getRemoteHost(),
                req.getRequestURI(),
                e.getStatus(),
                e.getMessage());
        return RestResponse.error(e.getStatus(), e.getMessage());
    }

    /**
     * 系统异常处理
     *
     * @param req 客户端请求对象
     * @param e   异常信息
     * @return RestResponse对象
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object HandlerException(HttpServletRequest req, Exception e) {
        int status;
        String message;
        String eid = genExceptionId();
        boolean printStackTrace = false;

        if (e instanceof AuthorizationException) {
            status = ResponseStatus.UN_AUTHORIZED;
            message = ResponseMessage.UN_AUTHORIZED;
        } else if (e instanceof HttpRequestMethodNotSupportedException) {
            status = ResponseStatus.METHOD_NOT_ALLOWED;
            message = ResponseMessage.METHOD_NOT_ALLOWED + "(" + req.getMethod() + ")";
        } else if (e instanceof DuplicateKeyException) {
            status = ResponseStatus.PARAM_ERR;
            message = ResponseMessage.RECORD_REPEATED;
        } else {
            status = ResponseStatus.INTERNAL_ERR;
            message = ResponseMessage.INTERNAL_ERR;
            printStackTrace = true;
        }

        logger.error("ExceptionId:[{}] Host:[{}] Uri:[{}] Body:[{}]{}",
                eid,
                req.getRemoteHost(),
                req.getRequestURI(),
                req.getQueryString(),
                printStackTrace ? ("\n" + getExceptionStack(e)) : "");
        return RestResponse.error(status, message, eid);
    }
}
