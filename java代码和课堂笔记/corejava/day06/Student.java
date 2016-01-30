package day06;

import java.util.ArrayList;

public class Student {
	int id;
	String name;
	 
	public Student(int id, String name){
		this.id = id;
		this.name = name;
	}
	public String toString(){
		return name;
	}
	
	public static void main(String[] args) {
		ArrayList<Student> list =
			new ArrayList<Student>();
		list.add(new Student(2, "Tom"));
		list.add(new Student(4, "Jerry"));
		list.add(new Student(3,"Lee"));
		list.add(new Student(5, "Mac"));
		list.add(new Student(8, "Andy"));
		list.add(new Student(9,"John"));
		for(Student s : list){
			System.out.println(s.name + ", " 
					+ s.name.hashCode() % 10);
		}
	
		
	}

}
