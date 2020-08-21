package cn.humsen.shiro.realm;

import cn.humsen.shiro.encode.DigestsUtil;
import cn.humsen.shiro.service.SecurityService;
import cn.humsen.shiro.service.SecurityServiceImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author hemingsheng@bxin.cn
 * @since 2020-08-21 21:23
 */
public class MyRealm extends AuthorizingRealm {
    public MyRealm() {
        //指定密码匹配方式为sha1
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(DigestsUtil.SHA1);
        //指定密码迭代次数
        matcher.setHashIterations(DigestsUtil.ITERATIONS);
        //使用父亲方法使匹配方式生效
        setCredentialsMatcher(matcher);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //从AuthenticationToken中获得登录名称
        String loginName = (String) token.getPrincipal();
        SecurityService securityService = new SecurityServiceImpl();
        String password = securityService.findPasswordByLoginName(loginName);
        if ("".equals(password) || password == null) {
            throw new UnknownAccountException("账户不存在");
        }
        //传递账号和密码
        return new SimpleAuthenticationInfo(loginName, password, getName());
    }
}
