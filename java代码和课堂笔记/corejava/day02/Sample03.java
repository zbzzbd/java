package day02;

public class Sample03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Animal a1 = new Animal("���","��","����",50);
		Animal a2 = new Animal("Сǿ","��","����",0.1);
		a1.call();
		a1.eat("��ͷ");
		a2.call();
		a2.eat("ʣ��");
		Bird b1 = new Bird("С�۷�","��",1,false);
		b1.eat("С��");
		b1.fly();
		System.out.println(b1.getType());
		Fish f1 = new Fish("����","ĸ",2,1001);
		f1.swim();
		System.out.println(f1.getType());
	}

}
