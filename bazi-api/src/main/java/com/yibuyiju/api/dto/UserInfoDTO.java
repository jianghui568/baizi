package com.yibuyiju.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/14 17:31
 */
@Accessors(chain = true, fluent = true)
@Data
public class UserInfoDTO {
    @ApiModelProperty(value = "用户id")
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String username;

    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    private Long creatorId;
    private Long updaterId;
}
