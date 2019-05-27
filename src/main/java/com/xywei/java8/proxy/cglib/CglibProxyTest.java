package com.xywei.java8.proxy.cglib;

import org.junit.Test;

public class CglibProxyTest {

	@Test
	public void testCglibProxy() {

		UserServiceImpl userServiceImpl = (UserServiceImpl) new CglibProxyHandler().createProxy(UserServiceImpl.class);
//		userServiceImpl.haveDinner();
//		userServiceImpl.goSleep();

		userServiceImpl.getup();

	}

}
