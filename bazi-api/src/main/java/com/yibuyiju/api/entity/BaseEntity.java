package com.yibuyiju.api.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/16 13:59
 */

@Accessors(chain = true, fluent = true)
@Data
public class BaseEntity implements Serializable {

    private Long id;
    @TableField(fill = FieldFill.INSERT)
    private Long creatorId;
    @TableField(fill = FieldFill.UPDATE)
    private Long updaterId;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updatedAt;
    @TableField(fill = FieldFill.INSERT)
    private Boolean deleted;
}