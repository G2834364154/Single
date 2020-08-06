package dao;


import beans.User;

import java.sql.SQLException;

/**
 * @author azzhu
 * @create 2020-08-06 08:55:39
 */
public interface UserDao {
    /**
     * 保存用户
     * @param user
     * @throws SQLException
     */
    void save(User user) throws SQLException;

    /**
     * 通过激活码查询用户
     * @param code
     * @return
     * @throws SQLException
     */
    User findByCode(String code) throws SQLException;

    /**
     * 更新用户信息
     * @param user
     */
    void updateUser(User user) throws SQLException;

    /**
     * 根据用户名、密码，以及status=1
     * @param user
     * @return
     * @throws SQLException
     */
    User find(User user) throws SQLException;;
}
