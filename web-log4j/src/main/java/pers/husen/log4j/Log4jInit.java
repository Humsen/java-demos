package pers.husen.log4j;

import java.io.FileInputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

/**
 * @author : 何明胜
 *
 *         2017年9月21日
 */
public class Log4jInit {
	private static Logger logger = LogManager.getLogger(Log4jInit.class.getName());

	public static void main(String[] args) {
		// System.out.println(System.getProperty("user.dir"));
		String root = System.getProperty("user.dir");
		String path = root + "/config/log4j2.xml";
		testLog4j();
	}

	public static void testLog4j(String path) {
		ConfigurationSource source;
		try {
			source = new ConfigurationSource(new FileInputStream(path));

			Configurator.initialize(null, source);
			// Logger logger = LogManager.getLogger(Log4jInit.class.getName());
			logger.trace("trace...");
			logger.debug("debug...");
			logger.info("info...");
			logger.warn("warn...");
			logger.error("error...");
			logger.fatal("fatal...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testLog4j() {
		try {
			// Logger logger = LogManager.getLogger(Log4jInit.class.getName());

				logger.trace("trace...");
				logger.debug("debug...");
				logger.info("info...");
				logger.warn("warn...");
				logger.error("error...");
				logger.fatal("fatal...");

			// String string = null;
			// System.out.println(string.length());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}