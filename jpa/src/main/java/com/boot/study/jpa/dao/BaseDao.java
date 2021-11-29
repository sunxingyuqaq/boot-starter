package com.boot.study.jpa.dao;

import com.boot.study.jpa.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/5/20 14:23
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@NoRepositoryBean
public interface BaseDao<E extends BaseEntity, P extends Serializable> extends JpaRepository<E, P>, JpaSpecificationExecutor<E> {
}
