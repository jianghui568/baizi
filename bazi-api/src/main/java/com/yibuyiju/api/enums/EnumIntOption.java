package com.yibuyiju.api.enums;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/15 15:57
 */
@Accessors(chain = true, fluent = true)
@Data
public class EnumIntOption {
    private String text;
    private Integer value;
}
