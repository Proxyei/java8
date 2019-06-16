package com.xywei.java.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.xywei.java.domain.Employee;

public class TestStream {

	/**
	 * 流的生成操作
	 */
	@Test
	public void test1() {

		// 集合
		List<Employee> employees = new ArrayList<>();
		Stream<Employee> eStream = employees.stream();
		eStream.close();

		// stream静态方法Of
		Stream<String> stream = Stream.of("1", "11","b", "c", "d", "a", "A", "aa", "c", "d");
		stream.sorted().filter((x) -> (x).length() < 2).skip(2)/**limit(5)**/.distinct().forEach(System.out::println);
		stream.close();

		// arrays静态方法
		String[] arrays = new String[] { "a", "b", "c" };
		Stream<String> stream2 = Arrays.stream(arrays);
		stream2.close();

		// 无限stream
		// Stream<Integer> stream3=Stream.iterate(1,(x)->x+1 );
		// stream3.limit(300).forEach(System.out::println);
		// stream3.close();

	}

}
