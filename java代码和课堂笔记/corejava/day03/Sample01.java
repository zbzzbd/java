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
		//判断s的原本类型是否为Circle
		if(s instanceof Circle){
			Circle c = (Circle)s;//强制转型
			c.f1();//调用Circle新增方法f1
		}
		System.out.println("面积:"+s.area());
		System.out.println("周长:"+s.zhouchang());
		System.out.println("==================");
	}
	
	
	
	
	

}
