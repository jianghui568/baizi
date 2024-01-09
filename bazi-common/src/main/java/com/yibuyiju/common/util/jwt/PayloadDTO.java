package com.yibuyiju.common.util.jwt;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author yjh
 * @version 1.0
 * @date 2024/1/5 13:39
 */
@Data
@ApiModel("信息实体类")
@Builder
@EqualsAndHashCode(callSuper = false)
public class PayloadDTO {
    @ApiModelProperty("主题")
    private String sub;

    @ApiModelProperty("签发时间")
    private Long iat;

    @ApiModelProperty("过期时间")
    private long exp;

    @ApiModelProperty("JWT ID")
    private String jti;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("用户Id")
    private Long id;

    @ApiModelProperty("用户权限")
    private List<String> authorities;
}
