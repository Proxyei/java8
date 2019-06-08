package com.xywei.java8.interfaces;

/**
 * 默认修饰为public obstract
 * 
 * @author wodoo
 *
 */
public interface InterfaceA {

	static String username = "A";

	default void commonDefaultSay() {
		System.out.println("两个接口都有的  A default");
	}

	static void commonStaticSay() {
		System.out.println("两个接口都有的  A static");

	}
	
	void say();

	default void aDefaultSay() {
		System.out.println("A default");
	}

	static void aStaticSay() {
		System.out.println("A static");

	}

	void aSay();
}
