package day01;

public class Person {
	private String name;//名字属性
	private String sex;
	private int age;
	
	
	/**
	 * 修改名字的行为
	 * @param newName
	 */
	public void setName(String newName){
		name = newName;
	}
	
	public String getName(){
		return name;
	}
	
	public void setSex(String newSex){
		sex = newSex;
	}
	
	public String getSex(){
		return sex;
	}
	
	public void setAge(int newAge){
		if(newAge >150){
			age = 150;
		}else if(newAge < 0){
			age = 0;
		}else{
			age = newAge;
		}
	}
	
	public int getAge(){
		return age;
	}
	
	
}
