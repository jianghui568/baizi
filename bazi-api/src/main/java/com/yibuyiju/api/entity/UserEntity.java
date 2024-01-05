package com.yibuyiju.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/16 17:06
 */
@TableName(value = "user")
@Data
public class UserEntity extends BaseEntity {
    private String phone;
    private String password;
    private String username;
    private String useragent;
    private String ip;
}
