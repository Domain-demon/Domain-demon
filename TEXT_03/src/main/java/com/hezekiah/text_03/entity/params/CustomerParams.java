package com.hezekiah.text_03.entity.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerParams {
    int userld;
    int customerld;
    @NotBlank(message = "请传入customerName")
    String customerName;
    String customerAvatar;
    String customerSex;
    String customerDate;
    @NotBlank(message = "请传入customerPhone")
    String customerPhone;
}
