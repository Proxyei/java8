package com.xywei.java8.proxy.jdk;

public class UserServiceImpl implements UserService {

	@Override
	public void haveDinner() {
		System.out.println("吃饭");
	}

	@Override
	public void goSleep() {
		System.out.println("睡觉");

	}

}
