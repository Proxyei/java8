package com.xywei.java.metho_constructro_invok;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

import com.xywei.java.domain.Employee;

/**
 * 所有都是基于函数式接口编程上
 * 
 * @author wodoo
 *
 */
public class TestMethod_constructor_invoke {

	/**
	 * 测试对象::实例方法
	 */
	@Test
	public void test1() {

		// 无返回值
		Consumer<String> consumer_old = (x) -> System.out.println(x);
		consumer_old.accept("我是老式使用接口方法");

		Consumer<String> consumer = System.out::println;
		consumer.accept("我是对象::实例方法");

		System.out.println("------------------------------");
		// 无参有返回值
		Employee employee = new Employee(1, "x", 111);
		Supplier<String> supplier = () -> employee.getName();
		System.out.println("旧时：" + supplier.get());

		Supplier<Integer> supplier2 = employee::getAge;
		System.out.println("新时代：" + supplier2.get());

		System.out.println("------------------------------");
		// 有参有返回值
		Function<Integer, Employee> function1 = (age) -> {
			employee.setAge(age);
			return employee;
		};

		System.out.println(function1.apply(30));

	}

	/**
	 * 测试<b>类::实例方法</b>
	 */
	@Test
	public void test2() {

		// Comparator<Integer> comparator = new Comparator<Integer>() {
		//
		// @Override
		// public int compare(Integer o1, Integer o2) {
		// return -(o1 - o2);
		// }
		// };
		// Comparator<Integer> comparator = (x,y)->-Integer.compare(x, y);
		Comparator<Integer> comparator = Integer::compare;
		List<Integer> list = Arrays.asList(5, 2, 7, 9, 1, 0);
		Collections.sort(list, comparator);
		System.out.println(list.toString());

	}

	/**
	 * 类::实例方法
	 */
	@Test
	public void test3() {

		BiPredicate<String, String> biPredicate = (x, y) -> x.equals(y);
		System.out.println(biPredicate.test("aaaa1", "a1"));

		System.out.println("-------------------------------------------");
		BiPredicate<String, String> biPredicate2 = String::equals;
		System.out.println(biPredicate2.test("ba1", "ba1"));

		System.out.println("-------------------------------------------");
		Function<String, String> function = String::toUpperCase;
		System.out.println(function.apply("aaa"));

		// 完成一个截取字符串的功能
		System.out.println("-------------------------------------------");
		// BiFunction<String, Integer, String> function2 = (x, y) ->x.substring(y);
		// 问题来了，如果截取自定义起止位置的字符串
		BiFunction<String, Integer, String> function2 = String::substring;
		System.out.println(function2.apply("abcde", 1));
	}
	
	/**
	 * 构造器引用
	 */
	@Test
	public void test4() {
		
		Supplier<Employee> supplier1=Employee::new;
		Employee employee1 = supplier1.get();
		System.out.println(employee1);
		
		
		
		
	}
	
	

}
