package com.xywei.java8.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

/**
 * 测试反射
 * 
 * @author wodoo
 *
 */
public class TestReflect {

	/**
	 * 获取class的三种方法
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetClass() throws Exception {

		// class.forName()字节码文件里面
		Class class1 = Class.forName("com.xywei.java8.reflect.User");
		System.out.println(class1);
		// obj.class calssloader里面
		Class class2 = User.class;
		System.out.println(class2);
		// new class jvm里面
		User user = new User();
		Class class3 = user.getClass();
		System.out.println(class3);

		System.out.println(class1 == class2);
		System.out.println(class3 == class1);

	}

	@Test
	public void testFields() throws Exception {

		// 获取class对象
		Class user_class = User.class;

		// 获取单个public成员变量
		// Field field = user_class.getField("id");
		// System.out.println(field);
		// // 获取所有的public 成员变量
		// Field[] fields = user_class.getFields();
		// for (Field field2 : fields) {
		// System.out.println(field2);
		//
		// }
		// 获取单个指定的成员变量
		Field field1 = user_class.getDeclaredField("qq");
		System.out.println("field1=" + field1);
		// 获取所有的成员变量
		Field[] fields2 = user_class.getDeclaredFields();
		for (Field field2 : fields2) {
			System.out.println(field2);
		}

	}

	/**
	 * 测试构造方法
	 * 
	 * @throws Exception
	 * @throws NoSuchMethodException
	 */
	@Test
	public void testConstructor() throws NoSuchMethodException, Exception {

		// 获取单个public构造方法
		Class user_class = User.class;
		// Constructor constructor1 = user_class.getConstructor(null);
		// System.out.println(constructor1);
		// // 获取所有public构造方法
		// Constructor[] constructors = user_class.getConstructors();
		// for (Constructor constructor : constructors) {
		// System.out.println("所有的public构造方法有:"+constructor);
		// }

		// 获取特定的某个构造方法，私有的只能有带declare，否则报错
		// Constructor constructor = user_class.getConstructor(int.class, String.class,
		// String.class);
		Constructor constructor = user_class.getDeclaredConstructor(int.class, String.class, String.class);
		System.out.println("特定的构造方法是：" + constructor);
		// 获取所有的构造方法
		// Constructor[] constructors=user_class.getDeclaredConstructors();
		// for (Constructor constructor : constructors) {
		// System.out.println("所有的构造方法有:" + constructor);
		// }

	}

	@Test
	public void testMethod() {

		Class class_user = User.class;
		// 所有的方法
		Method[] methods = class_user.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method);

		}

	}

	/**
	 * 测试使用反射设置对象属性
	 * 
	 * @throws Exception
	 * @throws IllegalArgumentException
	 */
	@Test
	public void testGetUserByClass() throws IllegalArgumentException, Exception {

		Class class_user = User.class;
		// 获取所有属性成员变量来设置
		Field[] fields = class_user.getDeclaredFields();
		User user = (User) class_user.getConstructor(null).newInstance(null);
		for (Field field : fields) {
			field.setAccessible(true);
			switch (field.getName()) {
			case "id":
				field.set(user, 1);
				break;
			case "name":
				field.set(user, "a");

				break;
			case "address":

				field.set(user, "beijing");
				break;
			case "qq":

				field.set(user, "123321");
				break;

			default:
				break;
			}

		}
		System.out.println("user==" + user);
		System.out.println("调用user反射实现的方法sayUser:");
		Method method = class_user.getDeclaredMethod("sayUser", null);
		// Method method = class_user.getDeclaredMethod("sayUser", (Class[]) null);
		// method.setAccessible(true);
		method.invoke(user, null);
		// method.invoke(user, (Class[]) null);
	}

}
