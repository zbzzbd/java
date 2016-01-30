package day07;
import java.util.*;
public class WrapperDemo {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("abc");//String
		list.add(new Integer(10));//Integer
		list.add(10);//自动装箱add(new Integer(10));
		
		int i = 10;
		Integer m = i;//自动装箱
		int j = m; //自动拆箱
		
		double pi = 3.14d;
		Double d = pi;//自动装箱：new Double(3.14);
		double d1 = d;//自动拆箱：d1 = d.getValue();
		
		//字符串和数字之间的转换
		String age = "19";
		int intAge = Integer.parseInt(age);//字符->int
		String strAge = intAge + "";//int->字符
		String strAge1 = Integer.toString(intAge);//int->字符
		//十进制数字 -> 16进制字符串
		String hexAge = Integer.toHexString(intAge);
		System.out.println(hexAge);
		//十进制数字 -> 2进制字符串
		String binaryAge = Integer.toBinaryString(intAge);
		System.out.println(binaryAge);
		
		
		String salary = "5678.9";
		double dSalary = Double.parseDouble(salary);
		
		
		String a = "hello";
		a = "world";
		Integer i1 = 1;
		Integer i2 = 2;
		i1 = i1 + i2;//new Integer(i1.getValue + i2.getValue);

		Object o = new Object();
		Integer n = new Integer(100);
		System.out.println(o);
		System.out.println(n);
		
		Object o1 = new Object();
		System.out.println(o.equals(o1));
		Integer n1 = new Integer(100);
		System.out.println(n.equals(n1));
	}
}
