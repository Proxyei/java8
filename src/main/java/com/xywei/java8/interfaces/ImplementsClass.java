package com.xywei.java8.interfaces;

public class ImplementsClass implements InterfaceA, InterfaceB {

	@Override
	public void aSay() {
		System.out.println("实现类实现A接口的方法");

	}

	@Override
	public void bSay() {
		System.out.println("实现类实现B接口的方法");

	}

	@Override
	public void say() {
		System.out.println("实现类实现A,B接口都有的方法");
	}

	@Override
	public void commonDefaultSay() {
		// TODO Auto-generated method stub
		InterfaceA.super.commonDefaultSay();
	}

}
