package com.fuxi;

//JAVABEAN
public class Person {

	private String name;// 姓名
	private int age;// 年龄
	private boolean isMarry;// 婚否
	private Person mate; // 伴侣
	private String sex;// 性别

	// 无参的构造方法
	public Person() {

	}

	// 有参构造

	public Person(String name, int age, boolean isMarry, Person mate, String sex) {

		this.name = name;
		this.age = age;
		this.isMarry = isMarry;
		this.mate = mate;
		this.sex = sex;
	}
	/**
	 * 假设异性的,都是未婚的， 并且年纪差<=5岁的才能结婚
	 */
	public void marry(Person other) {
	        
		if (this.sex != other.sex && this.isMarry == false
				&& other.isMarry == false
				&& (Math.abs(this.age - other.age)) <= 5) {
			System.out.println(this.getName() + "可以和" + other.getName() + "结婚");
			this.setMarry(true);
			other.setMarry(true);
			this.setMate(other);
			other.setMate(this);
		} else {
			System.out
					.println(this.getName() + "不可以和" + other.getName() + "结婚");
		}
	}

	// SET/GET方法
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isMarry() {
		return isMarry;
	}

	public void setMarry(boolean isMarry) {
		this.isMarry = isMarry;
	}

	public Person getMate() {
		return mate;
	}

	public void setMate(Person mate) {
		this.mate = mate;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String toString() {

		return "姓名：" + this.name + "\t" + " 婚否：" + this.isMarry + "\t" + " 伴侣："
				+ this.mate.getName();
	}
}
