package day09;

import java.util.Arrays;
import java.util.Comparator;

public class Student implements Comparable{
	private int id;

	private String name;

	private int age;

	private int score;

	public Student() {
		super();
	}

	public Student(int id, String name, int age, int score) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String toString() {
		return id + ", " + name + ", " + age + ", " + score;
	}
	
	public boolean equals(Object obj){
		if (obj == null){
			return false;
		}
		if (obj instanceof Student){
			return this.id == ((Student)obj).id;
		}
		return false;
	}
	public int hashCode(){
		return id;
	}
	public static void main(String[] args) {
		Student[] ss = new Student[3];
		ss[0] = new Student(100,"liucangsong", 30, 90);
		ss[1] = new Student(45, "liyi", 22, 95);
		ss[2] = new Student(58, "tangliang", 35, 93);
		Arrays.sort(ss);
		
		//可以采取两种方式定义回调函数
		//1.使用匿名类定义回调方法
//		Arrays.sort(ss, new Comparator<Student>(){
//			public int compare(Student s1, Student s2) {
//				return s1.name.compareTo(s2.name);
//			}
//			
//		});
		for(Student s : ss){
			System.out.println(s);
		}
	}

	//2.让Student类实现Comparable接口，并在compareTo方法中定义比较原则。
	public int compareTo(Object s) {
		return this.age - ((Student)s).age;
	}
}
