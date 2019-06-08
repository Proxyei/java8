package com.xywei.java.inner_class;

public class OuterStaticInnerClass {

	private String username = "外部类名字";
	public String password = "外部类密码";
	public static String USER_LEVEL = "外部类水平1";

	public void outerSay() {
		System.out.println("我是外部类，名字:" + username + " 密码:" + password);
		// InnerClass innerClass=new InnerClass();
		// innerClass.innerSay();
		System.out.println("外部类访问内部类：" + InnerClass.TEXT);
	}

	public static void outerStaticSay() {
		System.out.println("我是外部类静态方法");
	}

	class InnerClass {
		private String username = "内部类名字";
		private String password = "内部类密码";
		private static final String TEXT = "test";

		public void innerSay() {
			System.out.println("我是内部类，名字:" + username + " 密码:" + password);
			System.out.println("内部访问外部static成员变量：" + USER_LEVEL);
			System.out.println("内部访问外部成员变量，username:" + OuterStaticInnerClass.this.username + " password:"
					+ OuterStaticInnerClass.this.password);
		}

		// public static void staticSay() {
		public void staticSay() {
			System.out.println("我是非静态成员内部类的静态方法");
		}

		public void getStaticInnerClass_staticInnerClassSay() {
			StaticInnerClass.say();
		}

	}

	static class StaticInnerClass {

		private String username = "静态成员内部类username";
		public String password = "静态成员内部类password";

		public void staticInnerClassSay() {
			System.out.println("我是静态内部类，username:" + username + "password:" + password + ",外部类静态变量："
					+ OuterStaticInnerClass.USER_LEVEL);
		}

		public static void say() {
			System.out.println("我是静态成员内部类的静态方法");
		}

		public void getOuterStaticSay() {
			outerStaticSay();
		}

	}

}
