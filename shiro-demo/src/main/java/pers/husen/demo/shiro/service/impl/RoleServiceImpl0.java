package pers.husen.demo.shiro.service.impl;

import pers.husen.demo.shiro.dao.RoleDao;
import pers.husen.demo.shiro.dao.impl.RoleDaoImpl0;
import pers.husen.demo.shiro.po.SysRoles;
import pers.husen.demo.shiro.service.RoleService;

/**
 * @Desc 角色服务
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月27日 下午2:41:28
 * 
 * @Version 1.0.0
 */
public class RoleServiceImpl0 implements RoleService {

	private RoleDao roleDao = new RoleDaoImpl0();

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