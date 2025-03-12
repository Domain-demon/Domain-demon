package com.hezekiah.text_03.entity.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MerchantParamsDto {
    @NotNull(message = "userParams not null")
    @Valid
    private UserParams userParams;

    @NotNull(message = "merchantParams not null")
    @Valid
    private MerchantParams merchantParams;

}
