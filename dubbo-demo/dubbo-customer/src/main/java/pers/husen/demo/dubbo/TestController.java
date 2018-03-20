package pers.husen.demo.dubbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.husen.demo.dubbo.TestService;

/**
 * @Desc 消费者
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月20日 上午8:57:16
 * 
 * @Version 1.0.0
 */
@Controller
public class TestController {

	@Autowired
	private TestService testService;

	@RequestMapping("/test.do")
	public void sayDubbo() {
		testService.test();
	}

	@RequestMapping("/tests.do")
	@ResponseBody
	public String testString(String str) {
		String s = testService.testString(str);
		return s;
	}
}