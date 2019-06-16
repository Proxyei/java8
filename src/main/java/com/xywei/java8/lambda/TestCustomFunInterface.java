package com.xywei.java8.lambda;

import org.junit.Test;

public class TestCustomFunInterface {

	/**
	 * 使用自定义函数式接口编程实现求两个数的乘积
	 */
	@Test
	public void test1() {

		// 问题来了，如何复用代码呢？
		CustomFunInterface customFunInterface = (x, y) -> x * y;

		int k = customFunInterface.getNumber(3, 8);

		System.out.println(k);

	}

}
