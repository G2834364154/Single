package com.iweb.service;


import com.iweb.beans.Customer;

import java.util.List;

/**
 * Customer服务接口
 * @author wj
 * @create 2020-07-29 14:39:40
 */
public interface CustomerService {

    /**
     * 获取所有数据
     * @return
     */
    List<Customer> getAll();

    /**
     * 根据id查询客户信息
     * @param id
     * @return
     */
    Customer getById(String id);

    /**
     * 根据id删除一个客户
     * @param id
     * @return
     */
    int delById(String id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int batchDel(String ids);
}
