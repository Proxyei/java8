package com.xywei.java.inner_class;

public class OuterLocalInnerClass {

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
			outerStaticSay();
			System.out.println("内部访问外部成员变量，username:" + OuterLocalInnerClass.this.username + " password:"
					+ OuterLocalInnerClass.this.password);
		}

		// public static void staticSay() {
		public void staticSay() {
			System.out.println("我是非静态成员内部类的静态方法");
		}

	}

	public void localInnerClassSay() {

		class LocalInnerClass {

			private String username = "局部内部类username";
			public String password = "局部内部类password";
			public static final String SERVER_NAME = "MICRO";
			private static final String SERVER_NAME1 = "MICRO1";

			public void localInnerSay() {
				System.out.println("局部内部类方法访问自己的变量,username:" + username + ",password:" + password + ",SERVER_NAME："
						+ SERVER_NAME + "，SERVER_NAME1：" + SERVER_NAME1);
				System.out.println("访问外部类成员变量,username:" + OuterLocalInnerClass.this.username + " ");
			}

			public void getOuterSay() {
				outerSay();
				outerStaticSay();
				// 测试会不会死循环，结果是栈溢出
				// localInnerClassSay();
			}

			// 不能有satic修饰的方法
			// public static void localInnerStaticSay() {
			// System.out.println("局部内部类方法");
			// }

		}

		LocalInnerClass localInnerClass = new LocalInnerClass();
		localInnerClass.localInnerSay();
		localInnerClass.getOuterSay();

	}

}
