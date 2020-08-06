package com.iweb.dao.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.iweb.beans.User;
import com.iweb.dao.UserDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @author wj
 * @create 2020-07-29 11:11:40
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User findByUserNameAndPwd(String uname, String pwd) throws SQLException {
        final List<Entity> entities = Db.use().findAll(Entity.create("user").set("username", uname)
                .set("password", pwd));
        /*List<Entity> entities = Db.use().query("select id,username,password,nickname as nickName,picpath from user where username=? and password=?", uname,pwd);*/
        //难点：如何从Entity映射出User
        //todo 注意空指针的问题
        if(ObjectUtil.isNotNull(entities) && entities.size() > 0) {
            final Entity entity = entities.get(0);
            return entity.toBean(User.class);
        }
        return null;
    }
}
