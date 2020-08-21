package pers.husen.demo.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @Desc 密码加密
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月27日 下午1:49:58
 * 
 * @Version 1.0.0
 */
public class PasswordRealm extends AuthorizingRealm {
	private PasswordService passwordService;

	/**
	 * @param passwordService
	 *            the passwordService to set
	 */
	public void setPasswordService(PasswordService passwordService) {
		this.passwordService = passwordService;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		return new SimpleAuthenticationInfo("husen", passwordService.encryptPassword("123456"), getName());
	}
}