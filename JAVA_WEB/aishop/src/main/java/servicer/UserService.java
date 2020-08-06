package servicer;

import beans.User;

import java.sql.SQLException;

/**
 * @author azzhu
 * @create 2020-08-06 08:54:20
 */
public interface UserService {
    /**
     * 注册
     * @param user
     * @throws SQLException
     */
    void regist(User user) throws SQLException;;

    boolean activeUser(String code) throws SQLException;

    User login(User user) throws SQLException;;
}
