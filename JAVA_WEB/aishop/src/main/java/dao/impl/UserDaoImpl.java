package dao.impl;
import beans.User;
import dao.UserDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author azzhu
 * @create 2020-08-06 08:55:50
 */
public class UserDaoImpl implements UserDao {
    QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
    @Override
    public void save(User user) throws SQLException {
        String sql="INSERT INTO USER VALUES(?,?,?,?,?,?,?,?,?,?)";
        //为了好看
        Object[] params={user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),user.getSex(),user.getState(),user.getCode()};
        qr.execute(sql, params);
    }

    @Override
    public User findByCode(String code) throws SQLException {
        String sql="select * from user where code=?";
        User user=qr.query(sql, new BeanHandler<>(User.class),code);
        return user;
    }

    @Override
    public void updateUser(User user) throws SQLException {
        String sql="update user set username=? , password=? ,name =? ,email=?, telephone =? ,birthday =? ,sex=? ,state=? ,code= ? where uid=?";
        Object[] params={user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),user.getSex(),user.getState(),user.getCode(),user.getUid()};
        qr.update(sql,params);
    }

    @Override
    public User find(User user) throws SQLException {
        String sql="select * from user where username=?  and password= ?";
        return qr.query(sql, new BeanHandler<>(User.class),user.getUsername(),user.getPassword());
    }
}
