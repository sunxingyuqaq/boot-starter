package com.boot.study.vip.service.impl;

import cn.dev33.satoken.stp.StpInterface;
import com.boot.study.vip.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2021/4/14 11:13
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@Service
public class UserServiceImpl implements StpInterface, IUserService {

    @Override
    public List<String> getPermissionList(Object loginId, String loginKey) {
        // 本list仅做模拟，实际项目中要根据具体业务逻辑来查询权限
        List<String> list = new ArrayList<>();
        list.add("user-all");
        list.add("user-add");
        list.add("user-delete");
        list.add("user-update");
        list.add("user-get");
        list.add("article-get");
        return list;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginKey) {
        // 本list仅做模拟，实际项目中要根据具体业务逻辑来查询角色
        List<String> list = new ArrayList<>();
        list.add("admin");
        list.add("super-admin");
        return list;
    }

    @Override
    public boolean login(String loginId, String password) {
        return true;
    }
}
