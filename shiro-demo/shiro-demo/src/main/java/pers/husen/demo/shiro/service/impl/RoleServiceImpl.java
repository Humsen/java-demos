package pers.husen.demo.shiro.service.impl;

import pers.husen.demo.shiro.dao.RoleDao;
import pers.husen.demo.shiro.po.SysRoles;
import pers.husen.demo.shiro.service.RoleService;

/**
 * @Desc 带set函数
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月28日 上午11:40:24
 * 
 * @Version 1.0.0
 */
public class RoleServiceImpl implements RoleService {

	private RoleDao roleDao;

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public SysRoles createRole(SysRoles role) {
		return roleDao.createRole(role);
	}

	public void deleteRole(Long roleId) {
		roleDao.deleteRole(roleId);
	}

	/**
	 * 添加角色-权限之间关系
	 * 
	 * @param roleId
	 * @param permissionIds
	 */
	public void correlationPermissions(Long roleId, Long... permissionIds) {
		roleDao.correlationPermissions(roleId, permissionIds);
	}

	/**
	 * 移除角色-权限之间关系
	 * 
	 * @param roleId
	 * @param permissionIds
	 */
	public void uncorrelationPermissions(Long roleId, Long... permissionIds) {
		roleDao.uncorrelationPermissions(roleId, permissionIds);
	}
}