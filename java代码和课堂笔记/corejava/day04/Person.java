package day04;

public class Person {
	static Person p;
	
	//封闭构造方法
	private Person(){
	}
	
	//提供创建Person对象的方法
	public static Person getInstance(){
		//控制Person对象的创建
		if(p == null){
			p = new Person();
		}
		return p;
	}
	//TODO 业务方法
	
}
