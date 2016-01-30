package day07;

public class InnerClassDemo{
	private int a = 10; //成员变量，实例变量
	private static int b = 100; //静态成员变量
	
	public void testOuter(){
		//使用成员内部类
		InnerClass inner = new InnerClass();
		inner.testInner();
		//使用静态内部类
		MyInnerClass myInner = new MyInnerClass();
		myInner.testInner();
	}

	//内部类定义：成员内部类
    private class InnerClass{
		public void testInner(){
			System.out.println(a);
			System.out.println(b);
		}
	}
	//静态成员内部类
	static class MyInnerClass{
		public void testInner(){
			//System.out.println(a);//静态内部类不能访问宿主类的实例变量。
			System.out.println(b);//静态内部类只能访问宿主类的静态变量。
		}
	}
	//局部内部类的宿主方法
	public void localMethod(){
		int m;
		final int n = 10;
//		局部内部类。
		class LocalMethodClass{
			public void testLocalMethod(){
				System.out.println(n);
			}
		}

	}
	public static void main(String[] args) {
		InnerClassDemo demo = new InnerClassDemo();
		demo.testOuter();
		
		Animal person = new Animal(){
			public void move() {
				System.out.println("走！");
			}
		};
		person.move();
		Animal bird = new Animal(){
			public void move(){
				System.out.println("飞！");
			}
		};
		bird.move();
	}
}

interface Animal{
	public void move();
}
class Person implements Animal{
	public void move() {
		System.out.println("走！");
	}
	
}

