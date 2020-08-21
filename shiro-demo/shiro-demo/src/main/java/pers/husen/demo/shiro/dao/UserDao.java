package pers.husen.demo.shiro.dao;

import java.util.Set;

import pers.husen.demo.shiro.po.SysUsers;

/**
 * @Desc 用户Dao
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月27日 下午2:31:43
 * 
 * @Version 1.0.0
 */
public interface UserDao {

	public SysUsers createUser(SysUsers user);

	public void updateUser(SysUsers user);

	public void deleteUser(Long userId);

	public void correlationRoles(Long userId, Long... roleIds);

	public void uncorrelationRoles(Long userId, Long... roleIds);

	SysUsers findOne(Long userId);

	SysUsers findByUsername(String username);

	Set<String> findRoles(String username);

	Set<String> findPermissions(String username);
}