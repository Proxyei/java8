package com.xywei.java8.interfaces;

/**
 * 默认修饰为public obstract
 * 
 * @author wodoo
 *
 */
public interface InterfaceB {

	static String username = "B";

	default void commonDefaultSay() {
		System.out.println("两个接口都有的 B default");
	}

	static void commonstaticSay() {
		System.out.println("两个接口都有的 B static");

	}

	
	void say();
	
	default void bDefaultSay() {
		System.out.println("B default");
	}

	static void bStaticSay() {
		System.out.println("B static");

	}

	void bSay();
}
