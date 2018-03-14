package pers.husen.demo.mybatis.dao;

import java.util.List;

import pers.husen.demo.mybatis.po.UserInfo;

/**
 * @Desc dao层
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月7日 上午10:42:06
 * 
 * @Version 1.0.0
 */
public interface UserInfoMapper {
	public UserInfo selectById(Integer userId);
	public List<UserInfo> selectAll();
	
	public Integer insert(UserInfo userInfo);
	public Integer update(UserInfo userInfo);
	public Integer delete(Integer userId);
}