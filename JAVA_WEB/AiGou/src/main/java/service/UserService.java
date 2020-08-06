package service;

import domain.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author wxh
 * @create 2020-08-05 17:43:22
 */
public interface UserService {
    public void regist(User user) throws SQLException;

    /**
     * 登陆功能
     */
    List<User> loginService(User user) throws SQLException;
}
