package com.iweb.dao;

import com.iweb.beans.Customer;
import java.sql.SQLException;
import java.util.List;

/**
 * Customer的dao层接口
 * @author wj
 * @create 2020-07-29 14:28:40
 */
public interface CustomerDao {
    /**
     * 查询所有
     * @return
     */
    List<Customer> getAll() throws SQLException;

    /**
     * 根据id查询客户信息
     * @param id
     * @return
     * @throws SQLException
     */
    Customer getById(String id)  throws SQLException;

    /**
     * 根据id删除用户
     * @param id
     * @return
     * @throws SQLException
     */
    int delById(String id)  throws SQLException;

    /**
     * 批量删
     * @param ids
     * @return
     * @throws SQLException
     */
    int batchDel(String ids) throws SQLException;
}
