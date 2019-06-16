package com.xywei.java8.lambda;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * 测试lambda表达式使用
 * 
 * @author wodoo
 *
 */
public class TestLambda1 {

	/**
	 * 测试无参无返回值
	 */
	@Test
	public void test1() {

		Runnable runnable_old = new Runnable() {

			@Override
			public void run() {
				System.out.println(">>>>>>old");

			}
		};
		runnable_old.run();

		System.out.println("------------------------");

		Runnable runnable_new = () -> System.out.println(">>>>>>>new");

		runnable_new.run();

	}

	/**
	 * 测试无参数有返回值
	 */
	@Test
	public void test2() {

		Supplier<String> s1 = () -> {

			System.out.println("我是没参数，但是有返回值的");
			return "suppier";
		};

		String string = s1.get();
		System.out.println(string);

	}

	/**
	 * 测试有一个参数没有返回值 的
	 */
	@Test
	public void test3() {

		Consumer<String> c1 = (x) -> System.out.println(x);
		c1.accept("我是有一个形式参数，没有返回值的");

	}

	/**
	 * 测试多个参数，有返回值
	 */
	@Test
	public void test4() {

		Comparator<Integer> comparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer x, Integer y) {
				System.out.println("旧版本比较器");
				return Integer.compare(x, y);
			}
		};
		int i = comparator.compare(1, 2);
		System.out.println(i);

		System.out.println("-----------------");

		Comparator<Integer> comparator2 = (x, y) -> {
			System.out.println("新版本比较");
			return Integer.compare(x, y);
		};

		int j = comparator2.compare(3, 1);
		System.out.println("j==" + j);
	}

}
