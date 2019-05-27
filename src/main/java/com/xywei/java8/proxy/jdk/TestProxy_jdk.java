package com.xywei.java8.proxy.jdk;

import java.lang.reflect.Proxy;

import org.junit.Test;

public class TestProxy_jdk {

	@Test
	public void testJDKProxy() {

		// 目标类
		UserService userService = new UserServiceImpl();
		// 增强类
		UserServiceImplProxyHandler userServiceImplProxyHandler = new UserServiceImplProxyHandler(userService);
		// 代理对象
		UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
				userService.getClass().getInterfaces(), userServiceImplProxyHandler);

		// 代理对象执行方法
		userServiceProxy.haveDinner();
		userServiceProxy.goSleep();
	}

}
