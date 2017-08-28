package com.qf.controll;


import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qf.crudrepository.UserRepository2;
/**
 * @ClassName: UserControll 
 * @Description: 测试
 * @author 赵凯琦
 * @date 2017-7-28 下午2:55:03
 */
@Controller
public class UserControll {

	@RequestMapping("/{jn}")
	public String hello(@PathVariable String jn) {
		return jn;
	}
	
	@RequestMapping("/index")
	public String save() {
		System.out.println("执行到了控制层");
		return "main";
	}
	
	
	
	@RequestMapping("/login.action")
	public String login(HttpServletRequest request) {
		System.out.println("控制层登录执行了！");
		// shiro在认证过程中出现错误后将异常类路径通过request返回
		// 这里的这个shiroLoginFailure字段是 shiro早登陆失败情况下自动的封装进去的
		String exceptionClassName = (String) request
				.getAttribute("shiroLoginFailure");
		if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
			throw new RuntimeException("用户名有问题");
		} else if (IncorrectCredentialsException.class.getName().equals(
				exceptionClassName)) {
			throw new RuntimeException("用户名/密码错误");
		}
		return "login";
	}

	@RequiresPermissions({ "visite", "delete", "delete2" })
	// 这句话的意思就是 必须要有 visite这个权限才能访问这个资源
	@RequestMapping("/bobo.action")
	public String bobo() {
		System.out.println("这里是st的方法....");
		return "content";
	}
	
	
}
