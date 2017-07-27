package com.aisino.cloud.common.exception;

import lombok.Getter;

/**
 * 云记账自定义异常
 * Created by fangxm on 2017-07-18.
 */
@Getter
public class CloudException extends Exception {

    private int status;
    private String message;

    public CloudException(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
