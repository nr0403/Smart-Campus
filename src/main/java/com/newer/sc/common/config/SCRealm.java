package com.newer.sc.common.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.newer.sc.common.entity.User;
import com.newer.sc.manager.service.UserService;

/**
 * 信息桥梁
 * 从数据源获取数据并加工
 * @author Amichen
 *
 */
public class SCRealm extends AuthorizingRealm {
	
	@Autowired
	UserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		System.out.println("获取授权信息方法");
		return null;
	}
	
	
	/**
	 * 获取认证信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		
		String username = token.getPrincipal().toString();
		User user = userService.getUserByUsername(username);
		// 获得盐和密文
		String encordPassword = user.getPassword();
		String salt = user.getSalt();
		
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username,encordPassword,ByteSource.Util.bytes(salt),getName());
		
		
		return authenticationInfo;
	}

}
