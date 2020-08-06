package com.iweb;


import com.iweb.beans.Customer;
import com.iweb.dao.CustomerDao;
import com.iweb.dao.impl.CustomerDaoImpl;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

/**
 * CustomerDaoImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>7月 29, 2020</pre>
 */
public class CustomerDaoImplTest {

    private CustomerDao customerDao = new CustomerDaoImpl();

    /**
     * Method: getAll()
     */
    @Test
    public void testGetAll() throws Exception {
        final List<Customer> list = customerDao.getAll();
        list.forEach(System.out::println);
    }

    @Test
    public void testGetById()  throws Exception {
        final Customer customer = customerDao.getById("fffff-266a-4636-9328-623e9148ef24");
        System.out.println(customer);
    }

    @Test
    public void testDelById()  throws Exception {
        customerDao.delById("fffffffff-266a-4636-9328-623e9148ef24");
    }

    @Test
    public void testBatchDel() throws Exception {
        customerDao.batchDel("fffffffff-266a-4636-9328-623e9148ef24,fffffffff-266a-4636-9328-623e9148ef24");
    }
}
