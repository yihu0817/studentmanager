package com.ittx.stumanger.model;

public class Student {
	private int id;
	private String name; // 姓名
	private int age; // 年龄
	private int number; // 学号
	private boolean sex; // 性别
	private String headerImg; // 头像

	public Student(String name, int age, int number, boolean sex, String headerImg) {
		this.name = name;
		this.age = age;
		this.number = number;
		this.sex = sex;
		this.headerImg = headerImg;
	}
	public Student(int id,String name, int age, int number, boolean sex, String headerImg) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.number = number;
		this.sex = sex;
		this.headerImg = headerImg;
	}
	public Student() {
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getHeaderImg() {
		return headerImg;
	}

	public void setHeaderImg(String headerImg) {
		this.headerImg = headerImg;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", number=" + number + ", sex=" + sex + ", headerImg="
				+ headerImg + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
