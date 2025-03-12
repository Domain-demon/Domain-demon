package com.hezekiah.text_03.entity.params;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TakerParams {
    int userId;
    int takerId;

    @NotBlank(message = "请传入takerName")
    String takerName;

    @NotBlank(message = "请传入takerDate")
    String takerDate;

    //    @NotBlank(message = "请传入takerAvatar")
    String takerAvatar;

    @NotBlank(message = "请传入takerSex")
    String takerSex;

    @NotBlank(message = "请传入takerAddress")
    String takerAddress;

    @NotNull(message = "请传入takerPhone")
    int takerPhone;

    //    @NotBlank(message = "请传入idFront")
    String idFront;

    //    @NotBlank(message = "请传入idReverse")
    String idReverse;

    //    @NotBlank(message = "请传入certificateUrl")
    String certificateUrl;
}
