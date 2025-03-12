package com.hezekiah.text_03.entity.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MerchantParams {
    int userId;
    int merchantId;

    @NotBlank(message = "请传入merchantName")
    String merchantName;

    @NotNull(message = "请传入merchantPhone")
    int merchantPhone;

    @NotBlank(message = "请传入merchantAddress")
    String merchantAddress;

    //    @NotBlank(message = "请传入corporateFront")
    String corporateFront;

    //    @NotBlank(message = "请传入corporateReverse")
    String corporateReverse;

    //    @NotBlank(message = "请传入businessLicense")
    String businessLicense;
}
