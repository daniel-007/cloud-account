package com.aisino.cloud.common.domain;

/**
 * 状态信息定义
 * Created by fangxm on 2017-07-18.
 */
public class ResponseMessage {

    public static final String OK = "OK";
    public static final String NOT_FOUND = "资源未找到";
    public static final String METHOD_NOT_ALLOWED = "请求方法未允许";
    public static final String ACCOUNT_NOT_EXIST = "帐号不存在";
    public static final String ACCOUNT_DISABLED = "帐号被禁用";
    public static final String UN_AUTHORIZED = "没有权限，请先登录或注册";
    public static final String RECORD_REPEATED = "记录重复";
    public static final String INTERNAL_ERR = "未知错误";
    public static final String CREATE_ACCOUNT_FAILED = "创建账套失败";
}
