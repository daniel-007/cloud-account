package com.aisino.cloud.data.service;

import com.aisino.cloud.data.entity.Account;

/**
 * Service接口: 账套信息
 * Created by fangxm on 2017-07-17.
 */
public interface AccountService {

    /**
     * 创建账套
     * @param name 帐套名称
     * @return 新创建的账套信息
     * @throws Exception 若校验信息失败，或由于其他原因导致的创建失败，抛出异常
     */
    Account create(String name) throws Exception;

    /**
     * 删除账套
     * @throws Exception 由于各种原因导致的删除失败，抛出异常
     */
    void delete() throws Exception;
}
