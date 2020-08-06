package com.iweb;

import com.iweb.beans.User;
import com.iweb.dao.UserDao;
import com.iweb.dao.impl.UserDaoImpl;
import org.junit.Test;

/**
 * @author azzhu
 * @create 2020-07-29 11:19:24
 */
public class TestUserDaoImpl {

    private UserDao userDao = new UserDaoImpl();
    /**
     *
     * Method: findByUserNameAndPwd(String uname, String pwd)
     *
     */
    @Test
    public void testFindByUserNameAndPwd() throws Exception {
        final User loginUser = userDao.findByUserNameAndPwd("admin", "aaa");
        System.out.println(loginUser);
    }
}
