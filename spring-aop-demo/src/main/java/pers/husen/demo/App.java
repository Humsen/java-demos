package pers.husen.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Desc 测试Spring AOP
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月2日 上午11:47:21
 * 
 * @Version 1.0.0
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello Spring AOP!");
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerManager customerManager = (CustomerManager) factory.getBean("customerManager");
		customerManager.getCustomerById(2015);
		factory.close();
	}
}