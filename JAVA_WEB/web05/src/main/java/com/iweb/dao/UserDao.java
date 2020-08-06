package com.iweb.dao;


import com.iweb.beans.User;

import java.sql.SQLException;

/**
 * @author wj
 * @create 2020-07-29 11:11:28
 */
public interface UserDao {

    /**
     * 根据用户名和密码找人
     * @param uname
     * @param pwd
     * @return
     */
    User findByUserNameAndPwd(String uname, String pwd) throws SQLException;
    /*User findByUserNameAndPwd(User user);*/
}
