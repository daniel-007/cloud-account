package com.aisino.cloud.data.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 账套信息
 * Created by fangxm on 2017-07-17.
 */
@Getter
@Setter
@Builder
public class Account {

    /**
     * 账套ID
     */
    private Long aid;

    /**
     * 币种
     */
    private String currency;

    /**
     * 账套名称
     */
    private String name;

    /**
     * 启用日期
     */
    private Long createDate;

    /**
     * 会计制度
     */
    private int accounting;

    /**
     * 制单人姓名
     */
    private String creator;

    // ...
}
