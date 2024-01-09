package com.yibuyiju.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yjh
 * @version 1.0
 * @date 2024/1/8 18:14
 */
@Data
public class GroupSearchDTO extends BSearch {
    @ApiModelProperty(value = "分组名称")
    private String name;
}
