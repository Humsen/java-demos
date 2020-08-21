package pers.husen.demo.shiro.service.impl;

import pers.husen.demo.shiro.dao.PermissionDao;
import pers.husen.demo.shiro.dao.impl.PermissionDaoImpl0;
import pers.husen.demo.shiro.po.SysPermissions;
import pers.husen.demo.shiro.service.PermissionService;

/**
 * @Desc 权限服务
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月27日 下午2:39:46
 * 
 * @Version 1.0.0
 */
public class PermissionServiceImpl0 implements PermissionService {

	private PermissionDao permissionDao = new PermissionDaoImpl0();

	public SysPermissions createPermission(SysPermissions permission) {
		return permissionDao.createPermission(permission);
	}

	public void deletePermission(Long permissionId) {
		permissionDao.deletePermission(permissionId);
	}
}