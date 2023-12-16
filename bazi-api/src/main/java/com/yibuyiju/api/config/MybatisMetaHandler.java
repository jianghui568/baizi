package com.yibuyiju.api.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.yibuyiju.common.threadlocal.BaseContext;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;
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
        System.err.println("created start !!!!!!!!!");
        System.err.println(metaObject);
        if (Objects.isNull(metaObject.getValue("updaterId"))) {
            this.setFieldValByName("updaterId", BaseContext.getCurrentId(), metaObject);
        }
        if (Objects.isNull(metaObject.getValue("creatorId"))) {
            this.setFieldValByName("creatorId", BaseContext.getCurrentId(), metaObject);
        }
        if (Objects.isNull(metaObject.getValue("createdAt"))) {
            this.setFieldValByName("createdAt", new Date(), metaObject);
        }
        if (Objects.isNull(metaObject.getValue("updatedAt"))) {
            this.setFieldValByName("updatedAt", new Date(), metaObject);
        }
        if (Objects.isNull(metaObject.getValue("deleted"))) {
            this.setFieldValByName("deleted", new Date(), metaObject);
        }
        System.err.println(metaObject);

        System.err.println("created end !!!!!!!!!");
    }

    /**
     * 更新数据执行
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        System.err.println("updated start !!!!!!!!!");
        System.err.println(metaObject);
        if (Objects.isNull(metaObject.getValue("updaterId"))) {
            this.setFieldValByName("updaterId", BaseContext.getCurrentId(), metaObject);
        }
        if (Objects.isNull(metaObject.getValue("updatedAt"))) {
            this.setFieldValByName("updatedAt", new Date(), metaObject);
        }
        if (Objects.isNull(metaObject.getValue("deleted"))) {
            this.setFieldValByName("deleted", new Date(), metaObject);
        }

        System.err.println(metaObject);

        System.err.println("updated end !!!!!!!!!");
    }

}