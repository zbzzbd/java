package day02;

public class Fish extends Animal{
	private int number;//鳞片数量
	
	//Fish的构造方法
	public Fish(String name,String sex,double weight,int number){
		super(name,sex,"鱼",weight);//调用Animal构造方法
		this.number = number;
	}
	
	/**
	 * 游水
	 */
	public void swim(){
		System.out.println("在水里游！");
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
}
