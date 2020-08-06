package com.iweb.dao;

import com.iweb.beans.User;

import java.sql.SQLException;

/**
 * @author:cn.wj
 * @date:2020/8/4
 */
public interface UserDao {

    User findByUserNameAndPwd(String uname,String pwd) throws SQLException;
}
