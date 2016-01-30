package day01;

public class Sample06 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//-----使用无参构造方法------
		Point p1 = new Point();
		p1.show();
		Point p2 = new Point();
		p2.show();
		//-----使用有参构造方法------
		Point p3 = new Point(5,5);
		p3.show();
		Point p4 = new Point(6,6);
		p4.show();
		p4.getDistan(new Point(1,1));
		Point p5 = new Point(p3);
		p5.show();
		
	}

}
