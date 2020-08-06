package service.impi;

import dao.impi.UserDaoImpl;
import domain.User;
import service.UserService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author wxh
 * @create 2020-08-05 17:43:36
 */
public class UserServiceImpi implements UserService {
    UserDaoImpl u = new UserDaoImpl();
    @Override
    public void regist(User user) throws SQLException {
        u.save(user);
    }

    /**
     * 登陆功能
     */
    @Override
    public List<User> loginService(User user) throws SQLException {
        List<User> userList = u.login(user);
        return userList;
    }
}