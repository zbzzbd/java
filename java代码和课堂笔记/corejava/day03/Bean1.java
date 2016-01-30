package day03;

public class Bean1 {
	public static int i;
	public int j;
	
	static{
		System.out.println("---静态代码块---");
	}
	public static void f1(){
		System.out.println("---执行了f1方法---");
	}
	public void addI(){
		i++;
	}
	public void addJ(){
		j++;
	}
}
