package com.aisino.cloud.common.domain;

/**
 * 状态码定义
 * Created by fangxm on 2017-07-18.
 */
public class ResponseStatus {

    /**
     * 正确
     */
    public static final int OK = 200;

    /**
     * 参数错误
     */
    public static final int PARAM_ERR = 400;

    /**
     * 未授权
     */
    public static final int UN_AUTHORIZED = 401;

    /**
     * 未发现
     */
    public static final int NOT_FOUND = 404;

    /**
     * 请求方法未允许
     */
    public static final int METHOD_NOT_ALLOWED = 405;

    /**
     * 服务端内部错误
     */
    public static final int INTERNAL_ERR = 500;
}
