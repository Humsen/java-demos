package pers.husen.demo.log4j2.gelf;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @Desc gelf测试
 *
 * @Author 何明胜
 *
 * @Created at 2018年2月8日 下午5:15:18
 * 
 * @Version 1.0.0
 */
public class Log4jGeilTest {
	public final static Logger logger = LogManager.getLogger(Log4jGeilTest.class.getName());

	public static void main(String[] args) {
		logger.info("这是一条Info日志");
		logger.error("这是一条error日志");

		try {
			throw new NullPointerException();// 此行会抛出NullPointedException
		} catch (NullPointerException e) {
		}
	}
}
