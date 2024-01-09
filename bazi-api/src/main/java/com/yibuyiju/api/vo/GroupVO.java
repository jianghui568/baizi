package com.yibuyiju.api.vo;

import lombok.Data;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/14 17:31
 */

@Data
public class GroupVO {
    private Long id;
    private String name;
    private String description;
    private String createdAt;
}
