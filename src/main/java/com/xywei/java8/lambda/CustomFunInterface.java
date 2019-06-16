package com.xywei.java8.lambda;

/**
 * 自定义函数式接口，求2个数的积
 * 
 * @author wodoo
 *
 */
@FunctionalInterface
public interface CustomFunInterface {

	/**
	 * 
	 * @param i
	 * @param j
	 * @return 两个数的乘积
	 */
	int getNumber(int i, int j);

}
