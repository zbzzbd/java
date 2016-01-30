package com.fuxi1;

/** 属性是静态绑定到类型 方法是动态绑定到对象 */

public class Test {
	public static void main(String[] args) {
		Goo goo = new Goo();
		Foo foo = goo;
		System.out.println(goo.a + "," + goo.getA());
		System.out.println(foo.a + "," + foo.getA());
	}
}
class Foo {
	int a = 1;
	public int getA() {
		return a;
	}
}
class Goo extends Foo {
	int a = 2;
	public int getA() {
		return super.a;
	}
}