package com.yibuyiju.api.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/16 17:06
 */
@TableName(value = "user")
@Data
@Accessors(chain = true, fluent = true)
public class UserEntity extends BaseEntity {
    private String username;
}
