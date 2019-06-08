package com.xywei.java8.interfaces;

import org.junit.Test;

public class TestInterface {

	@Test
	public void test1() {
		// 使用实现类
//		ImplementsClass interfaceA = new ImplementsClass();
		 InterfaceA interfaceA=new ImplementsClass();
		interfaceA.aDefaultSay();
		interfaceA.aSay();
//		interfaceA.bDefaultSay();
//		interfaceA.bSay();
		interfaceA.commonDefaultSay();
		System.out.println(interfaceA.username);
		// 测试A,B接口静态方法
		// InterfaceA.aStaticSay();
		// InterfaceB.bStaticSay();
	}

}
