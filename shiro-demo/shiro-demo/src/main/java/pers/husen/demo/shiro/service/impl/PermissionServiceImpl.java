package pers.husen.demo.shiro.service.impl;

import pers.husen.demo.shiro.dao.PermissionDao;
import pers.husen.demo.shiro.po.SysPermissions;
import pers.husen.demo.shiro.service.PermissionService;

/**
 * @Desc 带set函数
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月28日 上午11:39:42
 * 
 * @Version 1.0.0
 */
public class PermissionServiceImpl implements PermissionService {

	private PermissionDao permissionDao;

	public void setPermissionDao(PermissionDao permissionDao) {
		this.permissionDao = permissionDao;
	}

	public SysPermissions createPermission(SysPermissions permission) {
		return permissionDao.createPermission(permission);
	}

	public void deletePermission(Long permissionId) {
		permissionDao.deletePermission(permissionId);
	}
}