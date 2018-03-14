package pers.husen.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pers.husen.customer.Customer;
import pers.husen.customer.dao.CustomerDao;


/**
 * @author 何明胜
 *
 * 2017年9月19日
 */
public class SpringJDBCTest {
	public static void main(String []args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerDao customerDao = (CustomerDao) context.getBean("customerDAO");
		
		//Customer customer = new Customer(14, "husen", 22);
		//customerDao.insert(customer);
		
		//Customer customer2 = customerDao.findByCustomerId1(9);
		//System.out.println(customer2);
		
		//List<Customer> list = customerDao.findAllCustomer1();
		//System.out.println(list);
		
        List<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer(15L,  "何明胜", 22L));
        customers.add(new Customer(16L, "何明胜", 22L));
        customers.add(new Customer(17L, "何明胜", 22L));
        
        customerDao.insertBatch(customers);

       /* String sql = "UPDATE customer SET NAME ='husen'";
        customerDao.insertBatch(sql);*/
      
	}
}
