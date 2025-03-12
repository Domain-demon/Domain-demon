package com.hezekiah.text_03.entity.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerParams {
    private int userId;
    private int customerId;
    @NotBlank(message = "请传入customerName")
    private String customerName;
    private String customerAvatar;
    private String customerSex;
    private String customerDate;
    @NotBlank(message = "请传入customerPhone")
    private String customerPhone;
}
