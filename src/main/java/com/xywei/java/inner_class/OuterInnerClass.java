package com.xywei.java.inner_class;

public class OuterInnerClass {

	private String username = "外部类名字";
	public String password = "外部类密码";
	public static String USER_LEVEL = "外部类水平1";

	public void outerSay() {
		System.out.println("我是外部类，名字:" + username + " 密码:" + password);
		// InnerClass innerClass=new InnerClass();
		// innerClass.innerSay();
		System.out.println("外部类访问内部类：" + InnerClass.TEXT);
	}

	class InnerClass {
		private String username = "内部类名字";
		private String password = "内部类密码";
		private static final String TEXT = "test";

		public void innerSay() {
			System.out.println("我是内部类，名字:" + username + " 密码:" + password);
			System.out.println("内部访问外部static成员变量：" + USER_LEVEL);
			System.out.println("内部访问外部成员变量，username:" + OuterInnerClass.this.username + " password:"
					+ OuterInnerClass.this.password);
		}

		public void staticSay() {
			System.out.println("我是非静态成员内部类的静态方法");
		}

	}

}
