package com.aisino.cloud.handler.controller;

import com.aisino.cloud.common.domain.RestResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * 控制器：用户
 * Created by fangxm on 2017-07-17.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/create")
    public RestResponse create(
            @ApiParam(value = "用户名称") @RequestParam String name) throws Exception {
        return RestResponse.success();
    }

    @ApiOperation(value = "用户登录")
    @DeleteMapping(value = "/login")
    public RestResponse login() throws Exception {
        return RestResponse.success();
    }

    @ApiOperation(value = "退出登录")
    @DeleteMapping(value = "/logout")
    public RestResponse logout() throws Exception {
        return RestResponse.success();
    }
}
