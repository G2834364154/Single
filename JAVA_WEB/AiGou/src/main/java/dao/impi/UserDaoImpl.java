package dao.impi;


import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import dao.UserDao;
import domain.User;
import utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wxh
 * @create 2020-08-05 17:42:21
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void save(User user) throws SQLException {
        String sql="INSERT INTO USER VALUES(?,?,?,?,?,?,?,?,?,?)";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] params = {user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),user.getSex(),user.getState(),user.getCode()};
        Connection conn = JDBCUtils.getConnection();
        queryRunner.execute(sql,params);
    }

    /**
     * 登陆功能
     */
    @Override
    public List<User> login(User user) throws SQLException {
       /* String sql = "select * from user where username = ? and password = ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] params = {user.getUsername(),user.getPassword()};
        Connection conn = JDBCUtils.getConnection();
        int i = queryRunner.execute(sql, params);
        return i;*/

       //hutool
        List<Entity> list = Db.use().findAll(Entity.create("user").set("username", user.getUsername())
                .set("password", user.getPassword()));
        List<User> list1 = new ArrayList<>();
        for (Entity entity : list) {
            list1.add(entity.toBean(User.class));
        }

return list1;
    }
}