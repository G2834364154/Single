package com.iweb.service;

import com.iweb.beans.User;

/**
 * @author wj
 * @create 2020-07-29 11:11:54
 */
public interface UserService {

    /**
     * 登录业务
     * @param uName
     * @param pwd
     * @return
     */
    User login(String uName, String pwd);
}
