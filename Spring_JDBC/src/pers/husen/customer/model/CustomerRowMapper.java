package pers.husen.customer.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pers.husen.customer.Customer;

/**
 * @author 何明胜
 *
 * 2017年9月19日
 */

public class CustomerRowMapper implements RowMapper {
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setCustId(rs.getLong("CUST_ID"));
		customer.setName(rs.getString("NAME"));
		customer.setAge(rs.getLong("AGE"));
		
		return customer;
	}
}