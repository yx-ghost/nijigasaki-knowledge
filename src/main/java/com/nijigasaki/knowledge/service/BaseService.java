package com.nijigasaki.knowledge.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nijigasaki.knowledge.common.enums.basic.Status;
import com.nijigasaki.knowledge.common.enums.error.BusinessError;
import com.nijigasaki.knowledge.common.utils.exception.BusinessException;
import com.nijigasaki.knowledge.model.entity.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Slf4j
public abstract class BaseService<M extends BaseMapper<T>, T extends BaseEntity> extends ServiceImpl<M, T> {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(T entity) {
        log.info("开始执行插入:{}",entity);
        if (Objects.isNull(entity)) {
            throw new BusinessException(BusinessError.PARAM_CAN_NOT_EMPTY);
        }
        entity.setId(null);
        entity.setStatus(Status.ACTIVE.getCode());
        preSaveCheckParam(entity);
        return super.save(entity);
    }

    protected void preSaveCheckParam(T entity) {
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateById(T entity) {
        log.info("开始执行更新:{}",entity);
        if (Objects.isNull(entity) || Objects.isNull(entity.getId())) {
            throw new BusinessException(BusinessError.PARAM_CAN_NOT_EMPTY);
        }
        T t = getById(entity.getId());
        if (Objects.isNull(t)) {
            throw new BusinessException(BusinessError.DATA_NOT_FOUND);
        }
        preUpdateCheckParam(t);
        return super.updateById(entity);
    }

    protected void preUpdateCheckParam(T t){}
}
