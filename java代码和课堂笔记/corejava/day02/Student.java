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
	 * ��д����show����
	 */
	public void show(){
//		System.out.println("������"+getName());
//		System.out.println("�Ա�"+getSex());
//		System.out.println("���䣺"+getAge());
		super.show();//���ø����е�show����
		System.out.println("ѧУ��"+school);
	}
	
	
	public void study(){
		System.out.println("�ú�ѧϰ��������!");
	}
	

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
}
