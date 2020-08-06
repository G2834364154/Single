package com.iweb.service.impl;

import com.iweb.beans.User;
import com.iweb.dao.UserDao;
import com.iweb.dao.impl.UserDaoImpl;
import com.iweb.service.UserService;
import java.sql.SQLException;

/**
 * @author wj
 * @create 2020-07-29 11:12:03
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User login(String uName, String pwd) {
        try {
            return userDao.findByUserNameAndPwd(uName,pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
