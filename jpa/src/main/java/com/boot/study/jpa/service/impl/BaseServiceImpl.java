package com.boot.study.jpa.service.impl;

import com.boot.study.jpa.dao.BaseDao;
import com.boot.study.jpa.entity.BaseEntity;
import com.boot.study.jpa.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/5/20 14:52
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
public abstract class BaseServiceImpl<E extends BaseEntity,P extends Serializable,D extends BaseDao<E,P>> implements BaseService<E,P,D> {

    @Autowired(required = false)
    private D dao;

    @Override
    public D getDao() {
        return dao;
    }
}
