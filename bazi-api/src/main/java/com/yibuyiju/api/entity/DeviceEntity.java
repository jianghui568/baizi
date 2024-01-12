package com.yibuyiju.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/16 17:06
 */
@TableName(value = "device")
@Data
public class DeviceEntity extends BaseEntity {
    private String uuid;
    private String client;
    private String name;
    private String model;
    private String utsname;
    private String systemName;
    private String systemVersion;
    private String useragent;
    private String ip;
}
