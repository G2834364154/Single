package dao;

import domain.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author wxh
 * @create 2020-08-05 17:42:08
 */
public interface UserDao {
    /**
     * 注册
     * @param user
     * @throws SQLException
     */
    public void save(User user) throws SQLException;

    /**
     * 登陆功能
     */
    public List<User> login(User user) throws SQLException;
}
