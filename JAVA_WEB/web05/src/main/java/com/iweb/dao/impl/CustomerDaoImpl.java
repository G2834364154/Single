package com.iweb.dao.impl;


import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.iweb.beans.Customer;
import com.iweb.dao.CustomerDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wj
 * @create 2020-07-29 14:29:05
 */
public class CustomerDaoImpl implements CustomerDao {
    @Override
    public Customer getById(String id) throws SQLException {
        final List<Entity> entities = Db.use().query("select * from customer where status=1 and id=?",id);

        return entities.get(0).toBean(Customer.class);
    }

    @Override
    public int delById(String id) throws SQLException {
        final int result = Db.use().update(
                Entity.create().set("status", 0), //修改的数据
                Entity.create("customer").set("id", id) //where条件
        );

        return result;
    }

    @Override
    public int batchDel(String ids) throws SQLException {
        final String[] params = ids.split(",");
        final int result = Db.use().update(
                Entity.create().set("status", 0), //修改的数据
                Entity.create("customer").set("id", params) //where条件
        );

        return result;
    }

    @Override
    public List<Customer> getAll() throws SQLException {
       // final List<Entity> entities = Db.use().findAll(Entity.create("customer"));
        final List<Entity> entities = Db.use().query("select * from customer where status=1 limit 0,5");

        List<Customer> customers = new ArrayList<>();
        //todo entities 判null，若为null，直接返回null
        for (Entity entity : entities) {
            customers.add(entity.toBean(Customer.class));
        }
        return customers;
    }
}
