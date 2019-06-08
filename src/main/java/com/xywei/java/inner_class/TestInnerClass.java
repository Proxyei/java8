package com.xywei.java.inner_class;

import org.junit.Test;

import com.xywei.java.inner_class.OuterInnerClass.InnerClass;
import com.xywei.java.inner_class.OuterStaticInnerClass.StaticInnerClass;

public class TestInnerClass {

	@Test
	public void testOuterInnerClass() {

		// 使用外部类
		OuterInnerClass outerInnerClass = new OuterInnerClass();
		outerInnerClass.outerSay();

		// 使用非静态成员内部类
		// OuterInnerClass.InnerClass innerClass=new OuterInnerClass().new InnerClass();
		// innerClass.innerSay();
		InnerClass innerClass = new OuterInnerClass().new InnerClass();
		innerClass.innerSay();
		
		
	}
	@Test
	public void testOuterStaticInnerClass() {
		//静态成员内部类使用
		StaticInnerClass staticInnerClass=new StaticInnerClass();
		staticInnerClass.staticInnerClassSay();
		staticInnerClass.getOuterStaticSay();
		//静态类直接使用静态方法
		StaticInnerClass.say();
		
	}

}
