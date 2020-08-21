package pers.husen.demo.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Desc 控制器
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月28日 下午1:11:55
 * 
 * @Version 1.0.0
 */
@Controller
public class AnnotationController {

	@RequestMapping("/hello1")
	public String hello1() {
		SecurityUtils.getSubject().checkRole("admin");
		return "success";
	}

	@RequiresRoles("admin")
	@RequestMapping("/hello2")
	public String hello2() {
		return "success";
	}
}