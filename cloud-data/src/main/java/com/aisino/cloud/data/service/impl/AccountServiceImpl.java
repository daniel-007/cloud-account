package com.aisino.cloud.data.service.impl;

import com.aisino.cloud.common.domain.ResponseMessage;
import com.aisino.cloud.common.domain.ResponseStatus;
import com.aisino.cloud.common.exception.CloudException;
import com.aisino.cloud.data.domain.Constant;
import com.aisino.cloud.data.entity.Account;
import com.aisino.cloud.data.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service实现: 账套信息
 * Created by fangxm on 2017-07-17.
 */
@Service
public class AccountServiceImpl implements AccountService {

    private final JdbcTemplate sysJdbcTemplate;
    private final JdbcTemplate userJdbcTemplate;

    @Autowired
    public AccountServiceImpl(@Qualifier(Constant.SYS_JDBCTEMPLATE) JdbcTemplate sysJdbcTemplate,
                              @Qualifier(Constant.USER_JDBCTEMPLATE) JdbcTemplate userJdbcTemplate) {
        this.sysJdbcTemplate = sysJdbcTemplate;
        this.userJdbcTemplate = userJdbcTemplate;
    }

    @Override
    public Account create(String name) throws Exception {
        Account account = Account.builder()
                .aid(2017L)
                .currency("rmb")
                .name(name)
                .createDate(System.currentTimeMillis() / 1000)
                .creator("TODO:creator")
                .build();
        if (account == null) {
            throw new CloudException(ResponseStatus.INTERNAL_ERR,
                    ResponseMessage.CREATE_ACCOUNT_FAILED);
        }
        return account;
    }

    @Transactional
    @Override
    public void delete() throws Exception {
        String sql = "select now()";
        sysJdbcTemplate.queryForObject(sql, String.class);
        userJdbcTemplate.queryForObject(sql, String.class);
    }
}
