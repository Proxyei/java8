package com.xywei.java8.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 基于JDK的代理，只能对接口实现类进行代理
 * 
 * @author wodoo 增强类对象
 */
public class UserServiceImplProxyHandler implements InvocationHandler {

	private UserService userService;

	public UserServiceImplProxyHandler(UserService userService) {
		this.userService = userService;
	}

	/**
	 * @param proxy
	 *            代理对象
	 * @param method
	 *            目标对象的方法
	 * @param args
	 *            目标对象方法的参数
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		Object object = null;

		if ("haveDinner".equals(method.getName())) {
			System.out.println("吃饭前一定要洗手;");
			// 执行目标类方法
			object = method.invoke(userService, args);
			System.out.println("好好吃饭");
		}

		if ("goSleep".equals(method.getName())) {
			System.out.println("睡觉前一定要关灯;");
			object = method.invoke(userService, args);
			System.out.println("好好睡觉");
		}

		return object;
		// return method.invoke(proxy, args);
	}

}
