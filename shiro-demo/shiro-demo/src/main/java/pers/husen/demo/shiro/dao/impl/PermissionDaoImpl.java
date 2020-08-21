package pers.husen.demo.shiro.dao.impl;

import pers.husen.demo.shiro.dao.PermissionDao;
import pers.husen.demo.shiro.po.SysPermissions;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Desc 带数据库连接池
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月28日 上午11:26:21
 * 
 * @Version 1.0.0
 */
public class PermissionDaoImpl extends JdbcDaoSupport implements PermissionDao {

	public SysPermissions createPermission(final SysPermissions permission) {
		final String sql = "insert into sys_permissions(permission, description, available) values(?,?,?)";

		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement psst = connection.prepareStatement(sql, new String[] { "id" });
				psst.setString(1, permission.getPermission());
				psst.setString(2, permission.getDescription());
				psst.setBoolean(3, permission.getAvailable());
				return psst;
			}
		}, keyHolder);
		permission.setId(keyHolder.getKey().longValue());

		return permission;
	}

	public void deletePermission(Long permissionId) {
		// 首先把与permission关联的相关表的数据删掉
		String sql = "delete from sys_roles_permissions where permission_id=?";
		getJdbcTemplate().update(sql, permissionId);

		sql = "delete from sys_permissions where id=?";
		getJdbcTemplate().update(sql, permissionId);
	}
}