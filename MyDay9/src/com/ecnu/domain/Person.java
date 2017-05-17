package com.ecnu.domain;

import java.util.Date;

public class Person {
	private String name = "lianghui";
	private int age;
	private Date birthday;
	private Address address;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String name) {
		super();
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
