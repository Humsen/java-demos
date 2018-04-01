package pers.husen.demo.shiro.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Desc JDBC工具类
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月27日 下午2:34:43
 * 
 * @Version 1.0.0
 */
public class JdbcTemplateUtils {

	private static JdbcTemplate jdbcTemplate;

	public static JdbcTemplate jdbcTemplate() {
		if (jdbcTemplate == null) {
			jdbcTemplate = createJdbcTemplate();
		}
		return jdbcTemplate;
	}

	private static JdbcTemplate createJdbcTemplate() {

		DruidDataSource ds = new DruidDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://rm-wz9lp2i9322g0n06zvo.mysql.rds.aliyuncs.com:3306/shiro?useSSL=true");
		ds.setUsername("webuser");
		ds.setPassword("123456");

		return new JdbcTemplate(ds);
	}
}