package com.aisino.cloud.data.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户信息
 * Created by fangxm on 2017-07-17.
 */
@Getter
@Setter
public class User {

    /**
     * 用户ID
     */
    private String uid;

    /**
     * 综合平台用户ID Integrated platform
     */
    private String platformId;

    /**
     * 用户名
     */
    String username;
}
