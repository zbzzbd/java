package day02;

public class Sample01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//�������ͱ���������������ֵ
//		int age = 10;
//		add(age);//��ageֵ������������i
//		System.out.println(age);
//		�������ͱ���������������ֵ
		Foo foo1 = new Foo();
		System.out.println(foo1.a);
		add(foo1);//��foo1��ַ������������foo
		System.out.println(foo1.a);
	}
	
	public static void add(int i){
		i++;
	}
	
	public static void add(Foo foo){
		foo.a++;
	}
}

class Foo{
	int a;
}



