package day03;

public class Sample01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Circle c1 = new Circle(5,3,10);
//		c1.show();
//		Circle c2 = new Circle(3,4,20);
//		c2.show();
		
//		System.out.println(c1.hashCode());
//		Circle c2 = c1;
//		System.out.println(c2.hashCode());
		Rect r1 = new Rect(10,20);
//		r1.show();
//		Shape s = new Circle(5,3,10);
//		Shape s1 = new Rect(5,5);
		display(c1);
		display(r1);
	}
	
	public static void display(Shape s){
		System.out.println("=================");
		//�ж�s��ԭ�������Ƿ�ΪCircle
		if(s instanceof Circle){
			Circle c = (Circle)s;//ǿ��ת��
			c.f1();//����Circle��������f1
		}
		System.out.println("���:"+s.area());
		System.out.println("�ܳ�:"+s.zhouchang());
		System.out.println("==================");
	}
	
	
	
	
	

}
