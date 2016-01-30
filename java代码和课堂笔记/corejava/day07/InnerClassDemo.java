package day07;

public class InnerClassDemo{
	private int a = 10; //��Ա������ʵ������
	private static int b = 100; //��̬��Ա����
	
	public void testOuter(){
		//ʹ�ó�Ա�ڲ���
		InnerClass inner = new InnerClass();
		inner.testInner();
		//ʹ�þ�̬�ڲ���
		MyInnerClass myInner = new MyInnerClass();
		myInner.testInner();
	}

	//�ڲ��ඨ�壺��Ա�ڲ���
    private class InnerClass{
		public void testInner(){
			System.out.println(a);
			System.out.println(b);
		}
	}
	//��̬��Ա�ڲ���
	static class MyInnerClass{
		public void testInner(){
			//System.out.println(a);//��̬�ڲ��಻�ܷ����������ʵ��������
			System.out.println(b);//��̬�ڲ���ֻ�ܷ���������ľ�̬������
		}
	}
	//�ֲ��ڲ������������
	public void localMethod(){
		int m;
		final int n = 10;
//		�ֲ��ڲ��ࡣ
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
				System.out.println("�ߣ�");
			}
		};
		person.move();
		Animal bird = new Animal(){
			public void move(){
				System.out.println("�ɣ�");
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
		System.out.println("�ߣ�");
	}
	
}

