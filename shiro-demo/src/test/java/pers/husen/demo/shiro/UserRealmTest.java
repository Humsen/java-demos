package pers.husen.demo.shiro;

import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.junit.Assert;
import org.junit.Test;

import pers.husen.demo.shiro.base.BaseTest;

/**
 * @Desc 测试
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月27日 下午2:52:55
 * 
 * @Version 1.0.0
 */
public class UserRealmTest extends BaseTest {

	@Test
	public void testLoginSuccess() {
		login("classpath:conf/shiro.ini", u1.getUsername(), password);
		Assert.assertTrue(subject().isAuthenticated());
	}

	@Test(expected = UnknownAccountException.class)
	public void testLoginFailWithUnknownUsername() {
		login("classpath:conf/shiro.ini", u1.getUsername() + "1", password);
	}

	@Test(expected = IncorrectCredentialsException.class)
	public void testLoginFailWithErrorPassowrd() {
		login("classpath:conf/shiro.ini", u1.getUsername(), password + "1");
	}

	@Test(expected = LockedAccountException.class)
	public void testLoginFailWithLocked() {
		login("classpath:conf/shiro.ini", u4.getUsername(), password + "1");
	}

	@Test(expected = ExcessiveAttemptsException.class)
	public void testLoginFailWithLimitRetryCount() {
		for (int i = 1; i <= 5; i++) {
			try {
				login("classpath:conf/shiro.ini", u3.getUsername(), password + "1");
			} catch (Exception e) {
				/* ignore */}
		}
		login("classpath:conf/shiro.ini", u3.getUsername(), password + "1");

		// 需要清空缓存，否则后续的执行就会遇到问题(或者使用一个全新账户测试)
	}

	@Test
	public void testHasRole() {
		login("classpath:conf/shiro.ini", u1.getUsername(), password);
		Assert.assertTrue(subject().hasRole("admin"));
	}

	@Test
	public void testNoRole() {
		login("classpath:conf/shiro.ini", u2.getUsername(), password);
		Assert.assertFalse(subject().hasRole("admin"));
	}

	@Test
	public void testHasPermission() {
		login("classpath:conf/shiro.ini", u1.getUsername(), password);
		Assert.assertTrue(subject().isPermittedAll("user:create", "menu:create"));
	}

	@Test
	public void testNoPermission() {
		login("classpath:conf/shiro.ini", u2.getUsername(), password);
		Assert.assertFalse(subject().isPermitted("user:create"));
	}
}