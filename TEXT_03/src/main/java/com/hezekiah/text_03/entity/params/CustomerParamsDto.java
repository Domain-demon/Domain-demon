package com.hezekiah.text_03.entity.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerParamsDto {
    @NotNull(message = "userParams not null")
    @Valid
    private UserParams userParams;
    @NotBlank(message = "customerParams not null")
    @Valid
    private CustomerParams customerParams;
}
