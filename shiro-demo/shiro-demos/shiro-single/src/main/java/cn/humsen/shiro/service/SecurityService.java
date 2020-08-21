package cn.humsen.shiro.service;

/**
 * @author hemingsheng@bxin.cn
 * @since 2020-08-21 21:21
 */
public interface SecurityService {
    String findPasswordByLoginName(String loginName);
}
