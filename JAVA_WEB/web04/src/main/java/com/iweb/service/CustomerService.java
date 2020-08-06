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
}
