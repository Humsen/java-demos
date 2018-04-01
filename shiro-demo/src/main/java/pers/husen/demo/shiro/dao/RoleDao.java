package pers.husen.demo.shiro.dao;

import pers.husen.demo.shiro.po.SysRoles;

/**
 * @Desc 角色dao
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月27日 下午2:32:19
 * 
 * @Version 1.0.0
 */
public interface RoleDao {

	public SysRoles createRole(SysRoles role);

	public void deleteRole(Long roleId);

	public void correlationPermissions(Long roleId, Long... permissionIds);

	public void uncorrelationPermissions(Long roleId, Long... permissionIds);

}