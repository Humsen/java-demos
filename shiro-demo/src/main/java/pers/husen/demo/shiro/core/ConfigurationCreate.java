package pers.husen.demo.shiro.core;

import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.authz.permission.WildcardPermissionResolver;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @Desc 纯代码代替ini配置文件
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月27日 下午1:15:46
 * 
 * @Version 1.0.0
 */
public class ConfigurationCreate {
	public ConfigurationCreate() {
		DefaultSecurityManager securityManager = new DefaultSecurityManager();
		//设置 authenticator
		ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();
		
		authenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
		securityManager.setAuthenticator(authenticator);
		
		//设置 authorizer
		ModularRealmAuthorizer authorizer = new ModularRealmAuthorizer();
		authorizer.setPermissionResolver(new WildcardPermissionResolver());
		securityManager.setAuthorizer(authorizer);
		
		//设置Realm
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName("");
		dataSource.setUrl("");
		dataSource.setUsername("");
		dataSource.setPassword("");
		
		JdbcRealm jdbcRealm = new JdbcRealm();
		jdbcRealm.setDataSource(dataSource);
		jdbcRealm.setPermissionsLookupEnabled(true);
		securityManager.setRealms(Arrays.asList((Realm)jdbcRealm));
		
		//将SecurityManager设置到SecurityUtils 方便全局使用
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("husen", "123123");
		subject.login(token);
	}
}