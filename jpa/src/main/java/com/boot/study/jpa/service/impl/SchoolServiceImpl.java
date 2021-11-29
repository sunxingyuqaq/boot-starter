package com.boot.study.jpa.service.impl;

import cn.hutool.core.date.StopWatch;
import com.boot.study.jpa.dao.SchoolDao;
import com.boot.study.jpa.entity.School;
import com.boot.study.jpa.service.SchoolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/5/20 14:23
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@Slf4j
@Service
@CacheConfig(cacheManager = "caffeineCacheManager", cacheNames = "school")
public class SchoolServiceImpl extends BaseServiceImpl<School, Integer, SchoolDao> implements SchoolService {

    @Override
    public List<School> findSchoolByName(String name) {
        return getDao().findBySchoolNameLike("%" + name + "%");
    }

    @Override
    @Cacheable(condition = "#pageNumber>=1", keyGenerator = "cacheKeyGenerator")
    public List<School> findByPage(Integer pageNumber, Integer pageSize) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("findByPage");
        log.info("start search");
        Page<School> all = getDao().findAll(PageRequest.of(pageNumber - 1, pageSize));
        stopWatch.stop();
        log.info("end search cost {}s", stopWatch.getTotalTimeSeconds());
        return all.getContent();
    }
}
