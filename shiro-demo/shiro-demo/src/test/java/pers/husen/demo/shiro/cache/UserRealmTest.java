package pers.husen.demo.shiro.cache;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.junit.Test;

import pers.husen.demo.shiro.base.BaseTest1;
import pers.husen.demo.shiro.realm.UserCacheRealm;

public class UserRealmTest extends BaseTest1 {
	@Override
	public void tearDown() throws Exception {
		userService.changePassword(u1.getId(), password);
		RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
		UserCacheRealm userRealm = (UserCacheRealm) securityManager.getRealms().iterator().next();
		userRealm.clearCachedAuthenticationInfo(subject().getPrincipals());

		super.tearDown();
	}

	@Test
	public void testClearCachedAuthenticationInfo() {
		login(u1.getUsername(), password);
		userService.changePassword(u1.getId(), password + "1");

		RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
		UserCacheRealm userRealm = (UserCacheRealm) securityManager.getRealms().iterator().next();
		userRealm.clearCachedAuthenticationInfo(subject().getPrincipals());

		login(u1.getUsername(), password + "1");
	}

	@Test
	public void testClearCachedAuthorizationInfo() {
		login(u1.getUsername(), password);
		subject().checkRole(r1.getRole());
		userService.correlationRoles(u1.getId(), r2.getId());

		RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
		UserCacheRealm userRealm = (UserCacheRealm) securityManager.getRealms().iterator().next();
		userRealm.clearCachedAuthorizationInfo(subject().getPrincipals());

		subject().checkRole(r2.getRole());
	}

	@Test
	public void testClearCache() {
		login(u1.getUsername(), password);
		subject().checkRole(r1.getRole());

		userService.changePassword(u1.getId(), password + "1");
		userService.correlationRoles(u1.getId(), r2.getId());

		RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
		UserCacheRealm userRealm = (UserCacheRealm) securityManager.getRealms().iterator().next();
		userRealm.clearCache(subject().getPrincipals());

		login(u1.getUsername(), password + "1");
		subject().checkRole(r2.getRole());
	}
}