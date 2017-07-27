package com.aisino.cloud.handler.controller;

import com.aisino.cloud.common.domain.RestResponse;
import com.aisino.cloud.data.service.AccountService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * 控制器：账套
 * Created by fangxm on 2017-07-17.
 */
@RestController
@RequestMapping(value = "/account")
public class AccountController {

    /**
     * 账套信息服务接口类
     */
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @ApiOperation(value = "创建帐套",
            notes = "test: TODO")
    @PostMapping(value = "/create")
    public RestResponse create(
            @ApiParam(value = "帐套名称") @RequestParam String name) throws Exception {
        HashMap<String, Object> data = new HashMap<>();
        data.put("account", accountService.create(name));
        return RestResponse.success(data);
    }

    @ApiOperation(value = "删除帐套")
    @DeleteMapping(value = "/delete")
    public RestResponse delete() throws Exception {
        accountService.delete();
        return RestResponse.success();
    }
}
