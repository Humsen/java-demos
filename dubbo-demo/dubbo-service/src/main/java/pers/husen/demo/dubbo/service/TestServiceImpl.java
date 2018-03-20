package pers.husen.demo.dubbo.service;

import pers.husen.demo.dubbo.TestService;

/**
 * @Desc 提供者
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月20日 上午8:58:03
 * 
 * @Version 1.0.0
 */
public class TestServiceImpl implements TestService {
	public void test() {
		System.out.println("---TestServiceImpl test()----服务被调用----------");
	}

	public String testString(String str) {
		System.out.println("---TestServiceImpl testString(" + str + ")----服务被调用----------");
		return "还给你：" + str;
	}
}