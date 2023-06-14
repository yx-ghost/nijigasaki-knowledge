package com.nijigasaki.knowledge.common.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Slf4j
@Component
@Primary
public class DataMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        if (metaObject.hasSetter("create_time")) {
            Object create_time = getFieldValByName("create_time", metaObject);
            if (Objects.isNull(create_time)) {
                this.strictInsertFill(metaObject,"create_time", LocalDateTime.class,LocalDateTime.now());
            }
        }
        if (metaObject.hasSetter("create_by")) {
            Object create_by = getFieldValByName("create_by", metaObject);
            if (Objects.isNull(create_by)) {
                this.strictInsertFill(metaObject,"create_by", String.class,"");
            }
        }
        if (metaObject.hasSetter("remark")) {
            Object remark = getFieldValByName("remark", metaObject);
            if (Objects.isNull(remark)) {
                this.strictInsertFill(metaObject,"remark", String.class,"");
            }
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (metaObject.hasSetter("update_time")) {
            Object update_time = getFieldValByName("update_time", metaObject);
            if (Objects.isNull(update_time)) {
                this.strictInsertFill(metaObject,"update_time", LocalDateTime.class,LocalDateTime.now());
            }
        }
        if (metaObject.hasSetter("update_by")) {
            Object update_by = getFieldValByName("update_by", metaObject);
            if (Objects.isNull(update_by)) {
                this.strictInsertFill(metaObject,"update_by", String.class,"");
            }
        }
    }
}
