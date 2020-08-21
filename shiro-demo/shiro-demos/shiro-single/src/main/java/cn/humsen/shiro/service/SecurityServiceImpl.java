package cn.humsen.shiro.service;

/**
 * @author hemingsheng@bxin.cn
 * @since 2020-08-21 21:22
 */
public class SecurityServiceImpl implements SecurityService{
    @Override
    public String findPasswordByLoginName(String loginName) {
        return "12345678";
    }
}
