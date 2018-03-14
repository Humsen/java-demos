package pers.husen.customer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import pers.husen.customer.Customer;
import pers.husen.customer.dao.CustomerDao;
import pers.husen.customer.model.CustomerRowMapper;

/**
 * @author 何明胜
 *
 * 2017年9月19日
 */
public class CustomerDaoImplTemplate implements CustomerDao{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void insert(Customer customer) {
		String sql = "INSERT INTO customer (CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, new Object[]{
			customer.getCustId(),
			customer.getName(),
			customer.getAge()
		});
	}

	
	@Override
	public Customer findByCustomerId(int custId) {
		String sql = "SELECT * FROM customer WHERE CUST_ID = ?";
		jdbcTemplate = new JdbcTemplate(dataSource);
		Customer lCustomers = (Customer) jdbcTemplate.queryForObject(sql, new Object[]{custId}, new CustomerRowMapper());
		
		
		return lCustomers;
	}

	/* (non-Javadoc)
	 * @see pers.husen.customer.dao.CustomerDao#findByCustomerId1(int)
	 */
	@Override
	public Customer findByCustomerId1(int custId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see pers.husen.customer.dao.CustomerDao#findAllCustomer()
	 */
	@Override
	public List<Customer> findAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see pers.husen.customer.dao.CustomerDao#findAllCustomer1()
	 */
	@Override
	public List<Customer> findAllCustomer1() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see pers.husen.customer.dao.CustomerDao#inertBatch(java.util.List)
	 */
	@Override
	public void insertBatch(List<Customer> customers) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see pers.husen.customer.dao.CustomerDao#inertBatch(java.lang.String)
	 */
	@Override
	public void insertBatch(String sql) {
		// TODO Auto-generated method stub
		
	}

}
