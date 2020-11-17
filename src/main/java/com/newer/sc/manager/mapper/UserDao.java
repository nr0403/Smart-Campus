package com.newer.sc.manager.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.newer.sc.common.entity.User;

/**
 * 用户类持久化对象接口 继承JpaRepository接口 已经实现了增删改查 和分页
 * 
 * @author Amichen
 *
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	// Repository
	// CrudRepository
	// PageingAndSortRepository
	// JpaRepository

	// 继承之后已经实现了 CRUD增删改查
	// PageingAndSort 分页查询

	// 需要实现与具体业务相关的数据操作

	// 如何自定义实现
	// 1.通过命名方法 (遵循规则)查询 约定优于配置
	User findByUsername(String username);

	User getByUsernameAndPassword(String username, String password);
	
	// 2.通过注解 方法名可以随意
//	@Query("select u from User u where u.userName = ?1")
//	User findUserName(String userName);

}
