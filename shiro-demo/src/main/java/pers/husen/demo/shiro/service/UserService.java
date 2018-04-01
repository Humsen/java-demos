package pers.husen.demo.shiro.service;

import java.util.Set;

import pers.husen.demo.shiro.po.SysUsers;

/**
 * @Desc 用户服务
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月27日 下午2:42:20
 * 
 * @Version 1.0.0
 */
public interface UserService {

	/**
	 * 创建用户
	 * 
	 * @param user
	 */
	public SysUsers createUser(SysUsers user);

	/**
	 * 修改密码
	 * 
	 * @param userId
	 * @param newPassword
	 */
	public void changePassword(Long userId, String newPassword);

	/**
	 * 添加用户-角色关系
	 * 
	 * @param userId
	 * @param roleIds
	 */
	public void correlationRoles(Long userId, Long... roleIds);

	/**
	 * 移除用户-角色关系
	 * 
	 * @param userId
	 * @param roleIds
	 */
	public void uncorrelationRoles(Long userId, Long... roleIds);

	/**
	 * 根据用户名查找用户
	 * 
	 * @param username
	 * @return
	 */
	public SysUsers findByUsername(String username);

	/**
	 * 根据用户名查找其角色
	 * 
	 * @param username
	 * @return
	 */
	public Set<String> findRoles(String username);

	/**
	 * 根据用户名查找其权限
	 * 
	 * @param username
	 * @return
	 */
	public Set<String> findPermissions(String username);
}