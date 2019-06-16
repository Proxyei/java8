package com.xywei.java8.lambda;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * jdk8内置的4大函数式接口
 * 
 * @author wodoo
 *
 */
public class TestInnerFunInterface {

	/**
	 * 无参数有返回值，不给你东西，只有你给我东西<br/>
	 * 功能：返回num个随机数总和
	 */
	@Test
	public void testSupplier() {

		int num = 10;
		Supplier<Integer> supplier = () -> {
			return (int) (Math.random() * 10);

		};
		int sum = supplier(num, supplier);
		System.out.println("sum=" + sum);
	}

	public int supplier(int num, Supplier<Integer> supplier) {

		int sum = 0;

		for (int i = 1; i <= num; i++) {
			int j = supplier.get();
			System.out.println(j);
			sum = sum + j;
		}
		return sum;
	}

	/**
	 * 有参数无返回值,有去无回<br/>
	 * 功能：倒数一个数
	 */
	@Test
	public void testConsumer() {

		int number = 100;

		consumer(number, (y) -> {
			while (y > 0) {
				System.out.println("y==" + y);
				y--;
			}
		});

	}

	public void consumer(int num, Consumer<Integer> consumer) {
		consumer.accept(num);
	}

	/**
	 * 有来有往<br/>
	 * 也是倒数number
	 */
	@Test
	public void testFunction() {

		int number = 10;

		function(number, (x) -> {
			x--;
			return x;
		});

	}

	public void function(int number, Function<Integer, Integer> function) {
		while (number > 0) {
			int i = function.apply(number);
			System.out.println(i);
			number--;
		}
	}

	/**
	 * 判断，有一个参数，一个boolean返回值 功能测试：集合字符串去重
	 */
	@Test
	public void testPredicate() {

		List<String> old = new ArrayList<>();
		old.add("aaa");
		old.add("a");
		old.add("aaa");
		old.add("a");
		old.add("aaa");
		old.add("a");
		List<String> new_ = predicate(old, (x, y) -> {
			return y.contains(x);
		});

		System.out.println("去重的的集合有：" + new_);
	}

	public List<String> predicate(List<String> strings, BiPredicate<String, List<String>> predicate) {

		List<String> result = new ArrayList<>();

		for (String string : strings) {
			// 如果不相等，则假如到集合中
			if (!predicate.test(string, result)) {
				result.add(string);
			}
		}

		return result;
	}

}
