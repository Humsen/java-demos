package pers.husen.demo.shiro.service;

import pers.husen.demo.shiro.po.SysRoles;

/**
 * @Desc 角色服务
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月27日 下午2:40:40
 * 
 * @Version 1.0.0
 */
public interface RoleService {

	public SysRoles createRole(SysRoles role);

	public void deleteRole(Long roleId);

	/**
	 * 添加角色-权限之间关系
	 * 
	 * @param roleId
	 * @param permissionIds
	 */
	public void correlationPermissions(Long roleId, Long... permissionIds);

	/**
	 * 移除角色-权限之间关系
	 * 
	 * @param roleId
	 * @param permissionIds
	 */
	public void uncorrelationPermissions(Long roleId, Long... permissionIds);

}
