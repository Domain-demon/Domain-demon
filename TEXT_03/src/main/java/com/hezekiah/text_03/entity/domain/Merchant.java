package com.hezekiah.text_03.entity.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Merchant {
    int userId;
    int merchantId;
    String merchantName;
    int merchantPhone;
    String merchantAddress;
    String corporateFront;
    String corporateReverse;
    String businessLicense;
}
