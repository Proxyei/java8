package com.xywei.java8.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 产生代理类，增强类
 * 
 * @author wodoo
 *
 */
public class CglibProxyHandler implements MethodInterceptor {

	public Object createProxy(Class clzz) {
		// cglib核心类
		Enhancer enhancer = new Enhancer();
		// 设置目标类父类
		enhancer.setSuperclass(clzz);
		// 设置回调
		enhancer.setCallback(this);
		// 产生代理对象
		return enhancer.create();
	}

	/**
	 * @param obj
	 *            目标类
	 * @param method
	 *            目标类方法
	 * @param args
	 *            目标类方法参数
	 * @param proxy
	 *            代理类
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

		Object object = null;

		if ("haveDinner".equals(method.getName())) {
			System.out.println("吃饭前洗手");
			object = proxy.invokeSuper(obj, args);
			System.out.println("好好吃饭");
		}
		if ("goSleep".equals(method.getName())) {
			System.out.println("睡觉前关灯");
			object = proxy.invokeSuper(obj, args);
			System.out.println("安心睡觉");
		}

		if (object == null) {
			return object = proxy.invokeSuper(obj, args);
		}

		return object;
	}

}
