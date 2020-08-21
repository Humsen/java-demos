package pers.husen.demo.shiro.service;

import pers.husen.demo.shiro.po.SysPermissions;

public interface PermissionService {
	public SysPermissions createPermission(SysPermissions permission);

	public void deletePermission(Long permissionId);
}