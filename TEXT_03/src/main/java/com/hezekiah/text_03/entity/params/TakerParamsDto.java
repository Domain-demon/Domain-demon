package com.hezekiah.text_03.entity.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TakerParamsDto {
    @NotNull(message = "userParams not null")
    @Valid
    private UserParams userParams;

    @NotNull(message = "takerParams not null")
    @Valid
    private TakerParams takerParams;

}
