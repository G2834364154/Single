package com.iweb.service.impl;

import com.iweb.beans.Customer;
import com.iweb.dao.CustomerDao;
import com.iweb.dao.impl.CustomerDaoImpl;
import com.iweb.service.CustomerService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author wj
 * @create 2020-07-29 14:40:38
 */
public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao = new CustomerDaoImpl();
    @Override
    public List<Customer> getAll() {
        try {
            return customerDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Customer getById(String id) {
        try {
            return customerDao.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    @Override
    public int batchDel(String ids) {
        try {
            return customerDao.batchDel(ids);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delById(String id) {
        try {
            return customerDao.delById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
