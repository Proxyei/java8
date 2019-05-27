package com.xywei.java8.reflect;

public class User {

	public int id;
	protected String name;
	String address;
	private String qq;

	public User() {
	}

	public User(int id, String name, String address, String qq) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.qq = qq;
	}

	private User(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	private String testThis(String string) {
		return "test" + " " + string;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + ", qq=" + qq + "]";
	}

	public void sayUser() {
		System.out.println("User [id=" + id + ", name=" + name + ", address=" + address + ", qq=" + qq + "]");
	}

}
