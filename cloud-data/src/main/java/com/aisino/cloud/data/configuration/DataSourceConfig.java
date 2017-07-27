package com.aisino.cloud.data.configuration;

import com.aisino.cloud.data.domain.Constant;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 数据源配置
 * Created by fangxm on 2017-07-23.
 */
@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

    /**
     * 数据源(基础数据)
     */
    @Bean(name = "sysDataSource")
    @ConfigurationProperties("spring.datasource.druid.sys")
    public DataSource sysDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 数据源(用户数据)
     */
    @Primary
    @Bean(name = "userDataSource")
    @ConfigurationProperties("spring.datasource.druid.user")
    public DataSource userDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = Constant.SYS_JDBCTEMPLATE)
    public JdbcTemplate sysJdbcTemplate(@Qualifier("sysDataSource") DataSource ds) {
        return new JdbcTemplate(ds);
    }

    @Bean(name = Constant.USER_JDBCTEMPLATE)
    public JdbcTemplate userJdbcTemplate(@Qualifier("userDataSource") DataSource ds) {
        return new JdbcTemplate(ds);
    }

    /**
     * 事务管理器(基础数据源)
     */
    @Bean(name = Constant.SYS_TRANSACTION_MGR)
    public PlatformTransactionManager sysTransactionManager(
            @Qualifier("sysDataSource") DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }

    /**
     * 事务管理器(用户数据源)
     */
    @Primary
    @Bean
    public PlatformTransactionManager userTransactionManager(
            @Qualifier("userDataSource") DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }
}
