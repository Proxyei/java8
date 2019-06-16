package com.xywei.java.domain;

public class Employee {
	private Integer age;
	private String name;
	private Integer sal;

	public Employee() {
	}

	public Employee(Integer age, String name, Integer sal) {
		this.age = age;
		this.name = name;
		this.sal = sal;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSal() {
		return sal;
	}

	public void setSal(Integer sal) {
		this.sal = sal;
	}

}
