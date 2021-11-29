package com.boot.study.vip.service;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2021/4/25 17:36
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
public interface IUserService {

    /**
     * login
     * @param loginId
     * @param password
     * @return
     */
    boolean login(String loginId, String password);
}
