package day02;

public class Sample01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//基本类型变量给参数变量赋值
//		int age = 10;
//		add(age);//将age值传给参数变量i
//		System.out.println(age);
//		引用类型变量给参数变量赋值
		Foo foo1 = new Foo();
		System.out.println(foo1.a);
		add(foo1);//将foo1地址传给参数变量foo
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



