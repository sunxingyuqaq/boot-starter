package com.boot.study.jpa;

import cn.hutool.http.HtmlUtil;
import com.boot.study.jpa.dao.SchoolDao;
import com.boot.study.jpa.entity.School;
import com.boot.study.jpa.service.SchoolService;
import com.boot.study.tests.BaseApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.Date;
import java.util.List;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/5/20 10:15
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@Slf4j
@Rollback
public class Tests extends BaseApplicationTests {

    @Autowired
    private SchoolService schoolService;
    @Autowired
    private SchoolDao schoolDao;

    @Test
    public void test() {
        School school = new School();
        school.setSchoolAge(200);
        school.setCreatDate(new Date());
        school.setUpdateDate(new Date());
        school.setCreatUser("tom");
        school.setUpdateUser("tom-1");
        school.setSchoolLocation("江苏省");
        school.setSchoolName("hope school");
        schoolDao.save(school);
        List<School> hope = schoolService.findSchoolByName("hope");
        if (!hope.isEmpty()) {
            log.info(hope.get(0).getSchoolLocation());
        } else {
            log.info("hope list is null");
        }
        String html = "&lt;p&gt;ccececeee&lt;/p&gt;&lt;p&gt;fdfdfdf fdf&nbsp;&lt;/p&gt;&lt;p&gt;f&lt;span style=\"font-size: 18px;\"&gt;dfdfddfdf&lt;/span&gt;&lt;/p&gt;";
        String htmlTag = HtmlUtil.cleanHtmlTag(HtmlUtil.unescape(html));
        log.info(htmlTag);
    }
}
