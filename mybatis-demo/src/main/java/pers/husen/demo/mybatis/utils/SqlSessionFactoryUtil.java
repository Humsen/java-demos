package pers.husen.demo.mybatis.utils;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @Desc 工具类
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月7日 上午10:40:48
 * 
 * @Version 1.0.0
 */
public class SqlSessionFactoryUtil {
	private static SqlSessionFactory sqlSessionFactory;

	public static SqlSessionFactory getSqlSessionFactory() {
		if (sqlSessionFactory == null) {
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream("mybatis-config.xml");
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sqlSessionFactory;
	}

	public static SqlSession openSession() {
		return getSqlSessionFactory().openSession();
	}
}