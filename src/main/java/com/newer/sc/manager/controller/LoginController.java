package com.newer.sc.manager.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.newer.sc.common.entity.User;
import com.newer.sc.common.util.Result;
import com.newer.sc.manager.service.UserService;

/**
 * 登录控制器
 * @author Amichen
 *
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class LoginController {
	
	@Autowired
	UserService userService;
	
	
	/**
	 * 登录控制器 登录成功返回200result  ，失败返回400result
	 * @param loginUser
	 * @param session
	 * @return
	 */
	@PostMapping("/login")
	@ResponseBody
	public Result login(@RequestBody User loginUser,HttpSession session) {
		String username = loginUser.getUsername();
		String password = loginUser.getPassword();
		
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
		
		try {
			subject.login(usernamePasswordToken);
			return new Result(200);
		} catch (Exception e) {
			// TODO: handle exception
			return new Result(400);
		}
			
		

	}
	
}
