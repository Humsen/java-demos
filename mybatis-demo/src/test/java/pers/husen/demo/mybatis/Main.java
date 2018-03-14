package pers.husen.demo.mybatis;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import pers.husen.demo.mybatis.dao.UserInfoMapper;
import pers.husen.demo.mybatis.po.UserInfo;
import pers.husen.demo.mybatis.utils.SqlSessionFactoryUtil;

/**
 * @Desc 测试
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月7日 上午10:43:54
 * 
 * @Version 1.0.0
 */
public class Main {
	public static void main(String[] args) {
		SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
		UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);

		// 根据Id查询
		// UserInfo curUser = userInfoMapper.selectById(1);

		// 查询所有
		List<UserInfo> userInfos = userInfoMapper.selectAll();
		System.out.println(userInfos);

		// 插入
		// java.sql.Date time= new java.sql.Date(new Date().getTime());
		Date date = new Date();
		UserInfo userInfo = new UserInfo(3, "龙傲天", "123123", date);
		System.out.println(date);
		Integer integer = userInfoMapper.insert(userInfo);
		System.out.println(integer);

		// 更新
		// UserInfo userInfo = new UserInfo(3, "天哥", "123123", new Date());
		// Integer curUser = userInfoMapper.update(userInfo);

		// 删除
		// Integer curUser = userInfoMapper.delete(3);

		sqlSession.commit();
		// System.out.println(curUser);
	}
}