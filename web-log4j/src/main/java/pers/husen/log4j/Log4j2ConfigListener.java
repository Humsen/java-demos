package pers.husen.log4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Log4j2ConfigListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("1111111111");
		//Log4jInit.testLog4j();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}
}