package day02;

public class Student extends Person{
	private String school;
	
	public Student(){
		super();
	}
	
	public Student(String name,String sex,int age,String school){
		super(name,sex,age);
		this.school = school;
	}
	
	/**
	 * 重写父类show方法
	 */
	public void show(){
//		System.out.println("姓名："+getName());
//		System.out.println("性别："+getSex());
//		System.out.println("年龄："+getAge());
		super.show();//调用父类中的show方法
		System.out.println("学校："+school);
	}
	
	
	public void study(){
		System.out.println("好好学习天天向上!");
	}
	

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
}
