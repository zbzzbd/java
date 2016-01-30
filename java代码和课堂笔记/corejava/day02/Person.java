package day02;

public class Person {
	private String name;
	private String sex;
	private int age;
	
	public Person(){}
	
	public Person(String name, String sex, int age) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	
	public void show(){
		System.out.println("姓名："+name);
		System.out.println("性别："+sex);
		System.out.println("年龄："+age);
	}
	
	/**
	 * 年龄加1
	 */
	public void addAge(){
		age++;
	}
	
	/**
	 * 测试当前人对象是否可以和另外一个人配对
	 * true:表示允许,false:表示不允许
	 * @return
	 */
	public boolean marryWith(Person p){
		//如果两个人性别不同,年龄女要求>20,男要求>23允许结婚
		if(p == null){
			return false;
		}
		//性别相同返回false
		if(this.sex.equals(p.sex)){
			return false;
		}
		//this对象的性别男年龄小于等于23,返回false
		if("男".equals(this.sex) && this.age <=23 ){
			return false;
		}
		//this对象的性别女年龄小于等于20,返回false
		if("女".equals(this.sex) && this.age <=20 ){
			return false;
		}
		//p对象的性别男年龄小于等于23,返回false
		if("男".equals(p.sex) && p.age <=23 ){
			return false;
		}
		//p对象的性别女年龄小于等于20,返回false
		if("女".equals(p.sex) && p.age <=20 ){
			return false;
		}
		return true;
	}
	
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
