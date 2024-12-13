package com.hezekiah.text_03.entity.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserParams {

    private int userId;

    @NotBlank(message = "请传入account")
    private String account;

    @NotBlank(message = "请传入password")
    private String password;

    @NotBlank(message = "请传入userName")
    private String userName;

    @NotBlank(message = "请传入roleId")
    private String roleId;

}
