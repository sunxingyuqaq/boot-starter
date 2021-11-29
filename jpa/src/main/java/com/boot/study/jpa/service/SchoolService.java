package com.boot.study.jpa.service;

import com.boot.study.jpa.entity.School;

import java.util.List;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/5/20 14:33
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
public interface SchoolService{
    /**
     * findBySchoolNameLike
     * @param name n
     * @return s
     */
    List<School> findSchoolByName(String name);

    /**
     * findByPage
     * @param pageNumber
     * @param pageSize
     * @return
     */
    List<School> findByPage(Integer pageNumber,Integer pageSize);
}
