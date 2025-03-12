package com.hezekiah.text_03.entity.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Taker {
    int userId;
    int takerId;
    String takerName;
    String takerDate;
    String takerAvatar;
    String takerSex;
    String takerAddress;
    int takerPhone;
    String idFront;
    String idReverse;
    String certificateUrl;
}
