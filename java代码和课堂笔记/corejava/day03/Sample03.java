package day03;

public class Sample03 {
	public static final int OK = 0;//常量定义
	public static final String SEX_MALE = "M";
	final int i = 10;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Bean1.i);//i为静态属性
		Bean1.f1();//f1为静态方法
		Bean1 b1 = new Bean1();
		b1.addI();//addI为对象方法
		b1.addJ();//addJ为对象方法
		System.out.println(Bean1.i);
		System.out.println(b1.j);//j为对象属性
		System.out.println("------------------");
		Bean1 b2 = new Bean1();
		b2.addI();//对象方法
		b2.addJ();
		System.out.println(Bean1.i);
		System.out.println(b2.j);//j为对象属性

	}
	
	public void test1(){
		System.out.println(i);
	}


}
