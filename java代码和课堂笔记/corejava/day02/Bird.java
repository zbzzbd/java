package day02;

public class Bird extends Animal{
	private boolean canFly = true;
	
	public Bird(String name,String sex,double weight,boolean canFly){
//		调用父类Animal的构造方法
		super(name,sex,"鸟",weight);
//		this.setName(name);
//		this.setSex(sex);
//		this.setWeight(weight);
//		this.setType("鸟");
		this.canFly = canFly;
	}
	
	/**
	 * 飞行
	 */
	public void fly(){
		if(canFly){
			System.out.println("飞呀飞！飞呀飞！飞鸟");
		}else{
			System.out.println("Sorry！我是菜鸟俺不会飞！");
		}
	}

	public boolean isCanFly() {
		return canFly;
	}

	public void setCanFly(boolean canFly) {
		this.canFly = canFly;
	}
	
}
