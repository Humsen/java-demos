package pers.husen.customer.dao;

import java.util.List;

import pers.husen.customer.Customer;


/**
 * @author 何明胜
 *
 * 2017年9月19日
 */

public interface CustomerDao {
	public void insert(Customer customer);
	public Customer findByCustomerId(int custId);
	public Customer findByCustomerId1(int custId);
	public List<Customer> findAllCustomer();
	public List<Customer> findAllCustomer1();
	public void insertBatch(final List<Customer> customers);
	public void insertBatch(final String sql);
}
