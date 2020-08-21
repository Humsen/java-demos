package pers.husen.demo.shiro.realm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

/**
 * @Desc 自定义域2
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月26日 下午11:28:04
 * 
 * @Version 1.0.0
 */
public class MyRealm2 implements Realm {
	private static final Logger logger = LogManager.getLogger(MyRealm2.class.getName());

	@Override
	public String getName() {
		logger.info("2 getName()");
		return "myrealm1";
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		logger.info("2 supports()");

		// 仅支持UsernamePasswordToken 类型的Token
		return token instanceof UsernamePasswordToken;
	}

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		logger.info("2 getAuthenticationInfo()");

		String username = (String) token.getPrincipal(); // 得到用户名
		String password = new String((char[]) token.getCredentials()); // 得到密码
		if (!"zhang".equals(username)) {
			throw new UnknownAccountException(); // 如果用户名错误
		}
		if (!"123".equals(password)) {
			throw new IncorrectCredentialsException(); // 如果密码错误
		}
		// 如果身份认证验证成功，返回一个AuthenticationInfo实现；
		return new SimpleAuthenticationInfo(username, password, getName());
	}
}