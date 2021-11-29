package com.boot.study.jpa.dao;

import com.boot.study.jpa.entity.School;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/5/20 10:11
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@Repository
public interface SchoolDao extends BaseDao<School,Integer>{

    /**
     * findBySchoolNameLike
     * @param name n
     * @return s
     */
    List<School> findBySchoolNameLike(String name);

    /**
     * findAll
     * @param pageable
     * @return
     */
    @Override
    Page<School> findAll(@Nullable Pageable pageable);
}
