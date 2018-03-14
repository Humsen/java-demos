package pers.husen.customer.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import pers.husen.customer.Customer;
import pers.husen.customer.dao.CustomerDao;
import pers.husen.customer.model.CustomerRowMapper;

/**
 * @author 何明胜
 *
 *         2017年9月19日
 */

public class CustomerDaoImplSupport extends JdbcDaoSupport implements CustomerDao {
	@Override
	public void insert(Customer customer) {
		String sql = "INSERT INTO customer (CUST_ID, NAME, AGE) VALUES (?, ?, ?)";

		getJdbcTemplate().update(sql, new Object[] { customer.getCustId(), customer.getName(), customer.getAge() });
	}

	@Override
	public Customer findByCustomerId(int custId) {
		String sql = "SELECT * FROM customer WHERE cust_id = ? ";

		Customer customer = (Customer) getJdbcTemplate().queryForObject(sql, new Object[] { custId },
				new CustomerRowMapper());

		return customer;
	}

	public Customer findByCustomerId1(int custId) {
		String sql = "SELECT * FROM customer WHERE cust_id = ? ";

		Customer customer = (Customer) getJdbcTemplate().queryForObject(sql, new Object[] { custId },
				new BeanPropertyRowMapper<Customer>(Customer.class));

		return customer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pers.husen.customer.dao.CustomerDao#findAllCustomer()
	 */
	@Override
	public List<Customer> findAllCustomer() {
		String sql = "SELECT * FROM customer ";

		List<Customer> customers = new ArrayList<Customer>();

		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (Map<String, Object> row : rows) {
			Customer customer = new Customer((Long) row.get("CUST_ID"), (String) row.get("NAME"),
					(Long) row.get("AGE"));
			customers.add(customer);
		}

		return customers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pers.husen.customer.dao.CustomerDao#findAllCustomer1()
	 */
	@Override
	public List<Customer> findAllCustomer1() {
		String sql = "SELECT * FROM customer ";

		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<Customer> list = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Customer.class));

		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pers.husen.customer.dao.CustomerDao#inertBatch(java.util.List)
	 */
	@Override
	public void insertBatch(final List<Customer> customers) {
		String sql = "INSERT INTO customer (CUST_ID, NAME, AGE) VALUES (?, ?, ?)";

		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Customer customer = customers.get(i);

				ps.setLong(1, customer.getCustId());
				ps.setString(2, customer.getName());
				ps.setLong(3, customer.getAge());
			}

			@Override
			public int getBatchSize() {
				return customers.size();
			}
		});

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pers.husen.customer.dao.CustomerDao#inertBatch(java.lang.String)
	 */
	@Override
	public void insertBatch(final String sql) {
		getJdbcTemplate().batchUpdate(sql);
	}
}