package com.fuxi;

//JAVABEAN
public class Person {

	private String name;// ����
	private int age;// ����
	private boolean isMarry;// ���
	private Person mate; // ����
	private String sex;// �Ա�

	// �޲εĹ��췽��
	public Person() {

	}

	// �вι���

	public Person(String name, int age, boolean isMarry, Person mate, String sex) {

		this.name = name;
		this.age = age;
		this.isMarry = isMarry;
		this.mate = mate;
		this.sex = sex;
	}
	/**
	 * �������Ե�,����δ��ģ� ������Ͳ�<=5��Ĳ��ܽ��
	 */
	public void marry(Person other) {
	        
		if (this.sex != other.sex && this.isMarry == false
				&& other.isMarry == false
				&& (Math.abs(this.age - other.age)) <= 5) {
			System.out.println(this.getName() + "���Ժ�" + other.getName() + "���");
			this.setMarry(true);
			other.setMarry(true);
			this.setMate(other);
			other.setMate(this);
		} else {
			System.out
					.println(this.getName() + "�����Ժ�" + other.getName() + "���");
		}
	}

	// SET/GET����
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

		return "������" + this.name + "\t" + " ���" + this.isMarry + "\t" + " ���£�"
				+ this.mate.getName();
	}
}
