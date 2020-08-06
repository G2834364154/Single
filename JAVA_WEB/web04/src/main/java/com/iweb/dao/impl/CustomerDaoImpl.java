package com.iweb.dao.impl;

import com.iweb.beans.Customer;
import com.iweb.dao.CustomerDao;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author azzhu
 * @create 2020-07-29 14:29:05
 */
public class CustomerDaoImpl implements CustomerDao {
    @Override
    public List<Customer> getAll() throws SQLException {
       // final List<Entity> entities = Db.use().findAll(Entity.create("customer"));
        final List<Entity> entities = Db.use().query("select * from customer where status=1");

        List<Customer> customers = new ArrayList<>();
        //todo entities 判null，若为null，直接返回null
        for (Entity entity : entities) {
            customers.add(entity.toBean(Customer.class));
        }
        return customers;
    }
}
