package pers.husen.demo.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * @Desc realm3
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月27日 上午10:27:14
 * 
 * @Version 1.0.0
 */
public class MyRealm3 implements Realm {

    @Override
    public String getName() {
        return "myrealm3";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken; //仅支持UsernamePasswordToken类型的Token
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String)token.getPrincipal();  //得到用户名
        String password = new String((char[])token.getCredentials()); //得到密码
        if(!"zhang".equals(username)) {
            throw new UnknownAccountException(); //如果用户名错误
        }
        if(!"123".equals(password)) {
            throw new IncorrectCredentialsException(); //如果密码错误
        }
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(username + "@163.com", password, getName());
    }
}
