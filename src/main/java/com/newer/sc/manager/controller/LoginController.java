package com.newer.sc.manager.controller;

import javax.servlet.http.HttpSession;

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
	
	
	@PostMapping("/login")
	@ResponseBody
	public Result login(@RequestBody User loginUser,HttpSession session) {
		String username = loginUser.getUsername();
		String password = loginUser.getPassword();
		
		User user = userService.getUserByUsernameAndPassword(username, password);
		System.out.println(user);
		if (user != null) {
			return new Result(200);
		}
		else {
			return new Result(400);
		}
	}
	
}
