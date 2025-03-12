package com.hezekiah.text_03.entity.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * oclassify
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OClassify implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer oclassifyId;
    private String oclassifyTitle;
}