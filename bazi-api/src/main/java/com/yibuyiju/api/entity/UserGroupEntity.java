package com.yibuyiju.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/16 17:06
 */
@TableName(value = "user_group")
@Data
public class UserGroupEntity extends BaseEntity {
    private String name;
    private String description;
}
