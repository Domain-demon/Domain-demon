package com.hezekiah.text_03.entity.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @TableName order
 */
@Data
public class Order {
    private static final long serialVersionUID = 1L;

    private Integer orderId;

    private Integer userId;

    private Date orderTime;

    private Date orderStart;

    private Date orderEnd;

    private BigDecimal guidingPrice;

    private Integer personNum;

    private String describe;

    private String address;

    private Integer ostatusId;

    private Integer oclassifyId;

    private String workPerson;
}