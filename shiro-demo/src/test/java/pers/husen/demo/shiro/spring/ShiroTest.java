package pers.husen.demo.shiro.spring;

import javax.sql.DataSource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pers.husen.demo.shiro.po.SysPermissions;
import pers.husen.demo.shiro.po.SysRoles;
import pers.husen.demo.shiro.po.SysUsers;
import pers.husen.demo.shiro.realm.UserRealm;
import pers.husen.demo.shiro.service.PermissionService;
import pers.husen.demo.shiro.service.RoleService;
import pers.husen.demo.shiro.service.UserService;

/**
 * @Desc 结合spring测试
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月28日 上午11:03:01
 * 
 * @Version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-beans.xml", "classpath:spring/spring-shiro.xml" })
public class ShiroTest {

	@Autowired
	protected PermissionService permissionService;
	@Autowired
	protected RoleService roleService;
	@Autowired
	protected UserService userService;

	@Autowired
	private UserRealm userRealm;

	protected JdbcTemplate jdbcTemplate;

	@Autowired
	private void setDataSource(DataSource ds) {
		jdbcTemplate = new JdbcTemplate(ds);
	}

	protected String password = "123";

	protected SysPermissions p1;
	protected SysPermissions p2;
	protected SysPermissions p3;
	protected SysRoles r1;
	protected SysRoles r2;
	protected SysUsers u1;
	protected SysUsers u2;
	protected SysUsers u3;
	protected SysUsers u4;

	@Before
	public void setUp() {
		jdbcTemplate.update("delete from sys_users");
		jdbcTemplate.update("delete from sys_roles");
		jdbcTemplate.update("delete from sys_permissions");
		jdbcTemplate.update("delete from sys_users_roles");
		jdbcTemplate.update("delete from sys_roles_permissions");

		// 1、新增权限
		p1 = new SysPermissions("user:create", "用户模块新增", Boolean.TRUE);
		p2 = new SysPermissions("user:update", "用户模块修改", Boolean.TRUE);
		p3 = new SysPermissions("menu:create", "菜单模块新增", Boolean.TRUE);
		permissionService.createPermission(p1);
		permissionService.createPermission(p2);
		permissionService.createPermission(p3);
		// 2、新增角色
		r1 = new SysRoles("admin", "管理员", Boolean.TRUE);
		r2 = new SysRoles("user", "用户管理员", Boolean.TRUE);
		roleService.createRole(r1);
		roleService.createRole(r2);
		// 3、关联角色-权限
		roleService.correlationPermissions(r1.getId(), p1.getId());
		roleService.correlationPermissions(r1.getId(), p2.getId());
		roleService.correlationPermissions(r1.getId(), p3.getId());

		roleService.correlationPermissions(r2.getId(), p1.getId());
		roleService.correlationPermissions(r2.getId(), p2.getId());

		// 4、新增用户
		u1 = new SysUsers("zhang", password);
		u2 = new SysUsers("li", password);
		u3 = new SysUsers("wu", password);
		u4 = new SysUsers("wang", password);
		u4.setLocked(Boolean.TRUE);
		userService.createUser(u1);
		userService.createUser(u2);
		userService.createUser(u3);
		userService.createUser(u4);
		// 5、关联用户-角色
		userService.correlationRoles(u1.getId(), r1.getId());
	}

	@Test
	public void test() {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(u1.getUsername(), password);
		subject.login(token);

		Assert.assertTrue(subject.isAuthenticated());
		subject.checkRole("admin");
		subject.checkPermission("user:create");

		userService.changePassword(u1.getId(), password + "1");
		userRealm.clearCache(subject.getPrincipals());

		token = new UsernamePasswordToken(u1.getUsername(), password + "1");
		subject.login(token);
	}
}