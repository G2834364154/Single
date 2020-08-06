package com.iweb;

import com.iweb.beans.Customer;
import com.iweb.dao.CustomerDao;
import com.iweb.dao.impl.CustomerDaoImpl;
import org.junit.Test;

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


}
