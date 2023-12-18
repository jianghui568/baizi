package com.yibuyiju.api.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.yibuyiju.common.threadlocal.BaseContext;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 数据库公共字段自动填充
 *
 * @author yjh
 * @version 1.0
 * @date 2023/12/8 9:27
 */
@Component
public class MybatisMetaHandler implements MetaObjectHandler {

    /**
     * 新增数据执行
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        if (Objects.isNull(metaObject.getValue("updaterId"))) {
            this.strictInsertFill(metaObject, "updaterId", Long.class, BaseContext.getCurrentId());
        }
        if (Objects.isNull(metaObject.getValue("creatorId"))) {
            this.strictInsertFill(metaObject, "creatorId", Long.class, BaseContext.getCurrentId());
        }
        if (Objects.isNull(metaObject.getValue("createdAt"))) {
            this.strictInsertFill(metaObject, "createdAt", LocalDateTime.class, LocalDateTime.now());
        }
        if (Objects.isNull(metaObject.getValue("updatedAt"))) {
            this.strictInsertFill(metaObject, "updatedAt", LocalDateTime.class, LocalDateTime.now());
        }
        if (Objects.isNull(metaObject.getValue("deleted"))) {
            this.strictInsertFill(metaObject, "deleted", Boolean.class, false);
        }
    }

    /**
     * 更新数据执行
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        System.err.println(metaObject);
        if (Objects.isNull(metaObject.getValue("updaterId"))) {
            this.strictUpdateFill(metaObject, "updaterId", Long.class, BaseContext.getCurrentId());
        }
        if (Objects.isNull(metaObject.getValue("updatedAt"))) {
            this.strictUpdateFill(metaObject, "updatedAt", Long.class, BaseContext.getCurrentId());
        }
        if (Objects.isNull(metaObject.getValue("deleted"))) {
            this.strictUpdateFill(metaObject, "deleted", Boolean.class, false);
        }
    }

}