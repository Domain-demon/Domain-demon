package com.hezekiah.text_03.entity.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    int userId;
    int customerId;
    String customerName;
    String customerAvatar;
    String customerSex;
    String customerDate;
    String customerPhone;
}
