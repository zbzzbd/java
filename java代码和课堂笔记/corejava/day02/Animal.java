package day02;

public class Animal {
	private String name;
	private String sex;
	private String type;
	private double weight;
	
	public Animal(){}
	
	public Animal(String name,String sex,String type,double weight){
		this.name = name;
		this.sex = sex;
		this.type = type;
		this.weight = weight;
	}
	
	public void call(){
		System.out.println("½ÐÒ»Éù");
	}
	
	public void eat(String eat){
		System.out.println("³Ô"+eat);
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getName(){
		return name;
	}
	
	
}
