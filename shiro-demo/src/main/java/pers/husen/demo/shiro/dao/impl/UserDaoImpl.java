package pers.husen.demo.shiro.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import pers.husen.demo.shiro.dao.UserDao;
import pers.husen.demo.shiro.po.SysUsers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Desc 带数据库连接池
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月28日 上午11:27:07
 * 
 * @Version 1.0.0
 */
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

	public SysUsers createUser(final SysUsers user) {
		final String sql = "insert into sys_users(username, password, salt, locked) values(?,?,?, ?)";

		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement psst = connection.prepareStatement(sql, new String[] { "id" });
				psst.setString(1, user.getUsername());
				psst.setString(2, user.getPassword());
				psst.setString(3, user.getSalt());
				psst.setBoolean(4, user.getLocked());
				return psst;
			}
		}, keyHolder);

		user.setId(keyHolder.getKey().longValue());
		return user;
	}

	public void updateUser(SysUsers user) {
		String sql = "update sys_users set username=?, password=?, salt=?, locked=? where id=?";
		getJdbcTemplate().update(sql, user.getUsername(), user.getPassword(), user.getSalt(), user.getLocked(), user.getId());
	}

	public void deleteUser(Long userId) {
		String sql = "delete from sys_users where id=?";
		getJdbcTemplate().update(sql, userId);
	}

	@Override
	public void correlationRoles(Long userId, Long... roleIds) {
		if (roleIds == null || roleIds.length == 0) {
			return;
		}
		String sql = "insert into sys_users_roles(user_id, role_id) values(?,?)";
		for (Long roleId : roleIds) {
			if (!exists(userId, roleId)) {
				getJdbcTemplate().update(sql, userId, roleId);
			}
		}
	}

	@Override
	public void uncorrelationRoles(Long userId, Long... roleIds) {
		if (roleIds == null || roleIds.length == 0) {
			return;
		}
		String sql = "delete from sys_users_roles where user_id=? and role_id=?";
		for (Long roleId : roleIds) {
			if (exists(userId, roleId)) {
				getJdbcTemplate().update(sql, userId, roleId);
			}
		}
	}

	private boolean exists(Long userId, Long roleId) {
		String sql = "select count(1) from sys_users_roles where user_id=? and role_id=?";
		return getJdbcTemplate().queryForObject(sql, Integer.class, userId, roleId) != 0;
	}

	@Override
	public SysUsers findOne(Long userId) {
		String sql = "select id, username, password, salt, locked from sys_users where id=?";
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<SysUsers> userList = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(SysUsers.class), userId);
		if (userList.size() == 0) {
			return null;
		}
		return userList.get(0);
	}

	@Override
	public SysUsers findByUsername(String username) {
		String sql = "select id, username, password, salt, locked from sys_users where username=?";
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<SysUsers> userList = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(SysUsers.class), username);
		if (userList.size() == 0) {
			return null;
		}
		return userList.get(0);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Set<String> findRoles(String username) {
		String sql = "select role from sys_users u, sys_roles r,sys_users_roles ur where u.username=? and u.id=ur.user_id and r.id=ur.role_id";
		return new HashSet(getJdbcTemplate().queryForList(sql, String.class, username));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Set<String> findPermissions(String username) {
		// 此处可以优化，比如查询到role后，一起获取roleId，然后直接根据roleId获取即可
		String sql = "select permission from sys_users u, sys_roles r, sys_permissions p, sys_users_roles ur, sys_roles_permissions rp where u.username=? and u.id=ur.user_id and r.id=ur.role_id and r.id=rp.role_id and p.id=rp.permission_id";
		return new HashSet(getJdbcTemplate().queryForList(sql, String.class, username));
	}
}