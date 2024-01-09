package com.yibuyiju.api.dto;

import lombok.Data;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/14 17:31
 */

@Data
public class GroupDTO {

    // @ApiModelProperty(value = "分组id")
    private Long id;

    // @ApiModelProperty(value = "分组名称")
    // @Size(min = 1, max = 20, message = "名称长度在1-20之间")
    private String name;

    // @ApiModelProperty(value = "分组描述")
    private String description;

}
