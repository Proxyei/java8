package com.xywei.java.inner_class;

import org.junit.Test;

import com.xywei.java.inner_class.OuterInnerClass.InnerClass;

public class TestInnerClass {

	@Test
	public void testOuterInnerClass() {

		// 使用外部类
		OuterInnerClass outerInnerClass = new OuterInnerClass();
		outerInnerClass.outerSay();

		// 使用内部类
		// OuterInnerClass.InnerClass innerClass=new OuterInnerClass().new InnerClass();
		// innerClass.innerSay();
		InnerClass innerClass = new OuterInnerClass().new InnerClass();
		innerClass.innerSay();

	}

}
