package com.iweb.dao;

import com.iweb.beans.Customer;

import java.sql.SQLException;
import java.util.List;

/**
 * Customer的dao层接口
 * @author azzhu
 * @create 2020-07-29 14:28:40
 */
public interface CustomerDao {
    /**
     * 查询所有
     * @return
     */
    List<Customer> getAll() throws SQLException;
}
