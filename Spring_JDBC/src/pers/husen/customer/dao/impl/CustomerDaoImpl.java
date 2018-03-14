package pers.husen.customer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.sql.DataSource;

import pers.husen.customer.Customer;
import pers.husen.customer.dao.CustomerDao;


/**
 * @author 何明胜
 *
 * 2017年9月19日
 */
public class CustomerDaoImpl implements CustomerDao{
	private  DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void insert(Customer customer) {
		String sql = "INSERT INTO customer (CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, customer.getCustId());
			ps.setString(2, customer.getName());
			ps.setLong(3, customer.getAge());
			ps.executeUpdate();
			ps.close();
		}catch (SQLException sqlException) {
			throw new RuntimeException(sqlException);
		}finally {
			if(conn != null) {
				try {
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	
	@Override
	public Customer findByCustomerId(int custId) {
		String sql = "SELECT * FROM customer WHERE CUST_ID = ?";
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, custId);
			Customer customer = null;
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				customer = new Customer();
				
				customer.setCustId(rs.getLong("CUST_ID"));
				customer.setName(rs.getString("NAME"));
				customer.setAge(rs.getLong("AGE"));
			}
			rs.close();
			ps.close();
			return customer;
		}catch (SQLException e) {
			 throw new RuntimeException(e);
		}finally {
			if(conn != null) {
				try {
					conn.close();
				}catch (SQLException e) {
					 e.printStackTrace();
				}
			}
		}
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
