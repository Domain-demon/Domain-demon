package com.hezekiah.text_03.entity.params;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class LoginParams {
    @NotBlank(message = "请传入account")
    private String account;

    @NotBlank(message = "请传入password")
    private String password;

}
