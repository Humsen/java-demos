package pers.husen.demo.shiro.base;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Before;

import pers.husen.demo.shiro.po.SysPermissions;
import pers.husen.demo.shiro.po.SysRoles;
import pers.husen.demo.shiro.po.SysUsers;
import pers.husen.demo.shiro.service.PermissionService;
import pers.husen.demo.shiro.service.RoleService;
import pers.husen.demo.shiro.service.UserService;
import pers.husen.demo.shiro.service.impl.PermissionServiceImpl0;
import pers.husen.demo.shiro.service.impl.RoleServiceImpl0;
import pers.husen.demo.shiro.service.impl.UserServiceImpl0;
import pers.husen.demo.shiro.utils.JdbcTemplateUtils;

/**
 * @Desc 测试基类
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月28日 上午9:16:23
 * 
 * @Version 1.0.0
 */
@SuppressWarnings("deprecation")
public abstract class BaseTest1 {

	protected PermissionService permissionService = new PermissionServiceImpl0();
	protected RoleService roleService = new RoleServiceImpl0();
	protected UserService userService = new UserServiceImpl0();

	protected String password = "123";

	protected SysPermissions p1;
	protected SysPermissions p2;
	protected SysPermissions p3;
	protected SysRoles r1;
	protected SysRoles r2;
	protected SysUsers u1;

	@Before
	public void setUp() {
		JdbcTemplateUtils.jdbcTemplate().update("delete from sys_users");
		JdbcTemplateUtils.jdbcTemplate().update("delete from sys_roles");
		JdbcTemplateUtils.jdbcTemplate().update("delete from sys_permissions");
		JdbcTemplateUtils.jdbcTemplate().update("delete from sys_users_roles");
		JdbcTemplateUtils.jdbcTemplate().update("delete from sys_roles_permissions");

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
		userService.createUser(u1);
		// 5、关联用户-角色
		userService.correlationRoles(u1.getId(), r1.getId());

		// 1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
		Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:conf/shiro-cache.ini");

		// 2、得到SecurityManager实例 并绑定给SecurityUtils
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);

	}

	@After
	public void tearDown() throws Exception {
		ThreadContext.unbindSubject();// 退出时请解除绑定Subject到线程 否则对下次测试造成影响
	}

	protected void login(String username, String password) {

		// 3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);

		subject.login(token);
	}

	public Subject subject() {
		return SecurityUtils.getSubject();
	}
}