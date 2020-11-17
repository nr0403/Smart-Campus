package com.newer.sc.manager.controller;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import com.newer.sc.common.entity.User;
import com.newer.sc.common.util.Result;
import com.newer.sc.manager.service.UserService;

/**
 * 注册控制器
 * @author Amichen
 *
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class RegisterController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	@ResponseBody
	public Result register(@RequestBody User user) {
		
		String username = user.getUsername();
		String password = user.getPassword();
		
		// 用户名过滤转义，防止恶意注册
		username = HtmlUtils.htmlEscape(username);
		user.setUsername(username);
		
		// 检测用户存在
		if (userService.isExist(username)) {
			return new Result(400);
		}
		
		// 获取盐
		// 默认长度16位
		String salt = new SecureRandomNumberGenerator().nextBytes().toString();
		
		// 迭代次数
		int times = 2;
		
		
		// 生成hash值  参数列表( 加密方法, 加密对象，盐 ，迭代次数  )
		String encodePassword = new SimpleHash("md5", password, salt, times).toString();
		
		user.setPassword(encodePassword);
		user.setSalt(salt);
		userService.add(user);
		
		return new Result(200);
	}
	
}	
