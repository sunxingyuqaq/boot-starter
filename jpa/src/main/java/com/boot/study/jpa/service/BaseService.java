package com.boot.study.jpa.service;

import com.boot.study.jpa.dao.BaseDao;
import com.boot.study.jpa.entity.BaseEntity;

import java.io.Serializable;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/5/20 14:30
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
public interface BaseService<E extends BaseEntity,P extends Serializable,D extends BaseDao<E,P>>{

    /**
     * dao
     * @return d
     */
    D getDao();

}
