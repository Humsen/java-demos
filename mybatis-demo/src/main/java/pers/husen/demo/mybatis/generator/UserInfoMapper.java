package pers.husen.demo.mybatis.generator;

import java.util.List;
import pers.husen.demo.mybatis.generator.UserInfo;

public interface UserInfoMapper {
	int deleteByPrimaryKey(Integer userId);

	int insert(UserInfo record);

	UserInfo selectByPrimaryKey(Integer userId);

	List<UserInfo> selectAll();

	int updateByPrimaryKey(UserInfo record);
}