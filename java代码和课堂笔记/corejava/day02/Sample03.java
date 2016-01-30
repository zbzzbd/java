package day02;

public class Sample03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Animal a1 = new Animal("大黄","公","走兽",50);
		Animal a2 = new Animal("小强","公","飞禽",0.1);
		a1.call();
		a1.eat("骨头");
		a2.call();
		a2.eat("剩饭");
		Bird b1 = new Bird("小蜜蜂","公",1,false);
		b1.eat("小米");
		b1.fly();
		System.out.println(b1.getType());
		Fish f1 = new Fish("鲤鱼","母",2,1001);
		f1.swim();
		System.out.println(f1.getType());
	}

}
