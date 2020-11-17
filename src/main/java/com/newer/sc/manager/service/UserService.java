package com.newer.sc.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.sc.manager.mapper.UserDao;
import com.newer.sc.common.entity.User;

/**
 * 登录 服务层
 * @author Amichen
 *
 */
@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	/**
	 * 调用规范命名的方法
	 * @param userName
	 * @return
	 */
	public User getUserByUsername(String username) {
		return userDao.findByUsername(username);
	}
	
	/**
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public User getUserByUsernameAndPassword(String username,String password) {
		User user = userDao.getByUsernameAndPassword(username, password);
		System.out.println("ser" + user);
		return user;
	}
	
	/**
	 * 
	 * @param userName
	 * @return
	 */
	public boolean isExist(String username) {
		User user = userDao.findByUsername(username);
		return user != null;
	}
	
	/**
	 * 往数据库中添加用户
	 * @param user
	 * @return
	 */
	public User add(User user) {
		return userDao.save(user);
	}

	
}
