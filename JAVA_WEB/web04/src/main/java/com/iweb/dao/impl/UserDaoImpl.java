package com.iweb.dao.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.iweb.beans.User;
import com.iweb.dao.UserDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @author:cn.wj
 * @date:2020/8/4
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User findByUserNameAndPwd(String uname, String pwd) throws SQLException {
        List<Entity> entities = Db.use().findAll(
                Entity.create("user").set("username", uname)
                                    .set("password", pwd));
        //todo 注意空指针的问题
        if(ObjectUtil.isNotNull(entities) && entities.size() > 0) {
            final Entity entity = entities.get(0);
            return entity.toBean(User.class);
        }
        return null;
    }
}
