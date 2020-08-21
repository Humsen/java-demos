package pers.husen.demo.shiro.dao;

import pers.husen.demo.shiro.po.SysPermissions;

/**
 * @Desc 权限Dao
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月27日 下午2:32:48
 * 
 * @Version 1.0.0
 */
public interface PermissionDao {

	public SysPermissions createPermission(SysPermissions permission);

	public void deletePermission(Long permissionId);

}