package pers.husen.demo.shiro.service.impl;

import pers.husen.demo.shiro.dao.UserDao;
import pers.husen.demo.shiro.dao.impl.UserDaoImpl0;
import pers.husen.demo.shiro.po.SysUsers;
import pers.husen.demo.shiro.service.UserService;
import pers.husen.demo.shiro.utils.PasswordHelper;

import java.util.Set;

/**
 * @Desc 用户服务
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月27日 下午2:43:23
 * 
 * @Version 1.0.0
 */
public class UserServiceImpl0 implements UserService {

	private UserDao userDao = new UserDaoImpl0();
	private PasswordHelper passwordHelper = new PasswordHelper();

	/**
	 * 创建用户
	 * 
	 * @param user
	 */
	public SysUsers createUser(SysUsers user) {
		// 加密密码
		passwordHelper.encryptPassword(user);
		return userDao.createUser(user);
	}

	/**
	 * 修改密码
	 * 
	 * @param userId
	 * @param newPassword
	 */
	public void changePassword(Long userId, String newPassword) {
		SysUsers user = userDao.findOne(userId);
		user.setPassword(newPassword);
		passwordHelper.encryptPassword(user);
		userDao.updateUser(user);
	}

	/**
	 * 添加用户-角色关系
	 * 
	 * @param userId
	 * @param roleIds
	 */
	public void correlationRoles(Long userId, Long... roleIds) {
		userDao.correlationRoles(userId, roleIds);
	}

	/**
	 * 移除用户-角色关系
	 * 
	 * @param userId
	 * @param roleIds
	 */
	public void uncorrelationRoles(Long userId, Long... roleIds) {
		userDao.uncorrelationRoles(userId, roleIds);
	}

	/**
	 * 根据用户名查找用户
	 * 
	 * @param username
	 * @return
	 */
	public SysUsers findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	/**
	 * 根据用户名查找其角色
	 * 
	 * @param username
	 * @return
	 */
	public Set<String> findRoles(String username) {
		return userDao.findRoles(username);
	}

	/**
	 * 根据用户名查找其权限
	 * 
	 * @param username
	 * @return
	 */
	public Set<String> findPermissions(String username) {
		return userDao.findPermissions(username);
	}
}