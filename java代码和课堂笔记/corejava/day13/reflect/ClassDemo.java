package day13.reflect;

import java.util.Scanner;
import java.lang.reflect.*;
public class ClassDemo {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) 
	throws ClassNotFoundException, 
			InstantiationException, 
			IllegalAccessException, 
			SecurityException, 
			NoSuchMethodException, 
			IllegalArgumentException, 
			InvocationTargetException {
		Scanner sc = new Scanner(System.in);
		String className = sc.nextLine();
		
		Class clz = Class.forName(className);
		
		System.out.println("类名：" +clz.getName());//获取类名
		//获取所有的方法
		System.out.println("方法列表：");
		Method[] methods = clz.getMethods();
		for(Method m : methods){
			System.out.println(
					m.getReturnType().getName() 
					+ " " + m.getName());
		}
		//获取所有的构造器
		System.out.println("构造器列表：");
		Constructor[] cons = clz.getDeclaredConstructors();
		for(Constructor c : cons){
			System.out.println(c.getName());
		}
		//获取所有的属性
		System.out.println("属性列表：");
		Field[] fields = clz.getFields();
		for (Field f : fields){
			System.out.println(f.getName());
		}
		
		if("day16.reflect.Compute".equals(clz.getName())){
			Object o = clz.newInstance();//调用构造器构造实例
			
			Class[] types = {int.class, double.class};//定义方法的参数类型
			Object[] params = {1, 2};
			Method m 
				= clz.getDeclaredMethod("add", types);
			Object result = m.invoke(o, params);
			double d = (Double)result;
			System.out.println(d);
		}
		
		
	}
	
	//三种方式获取Class的实例：
//	public void method()throws ClassNotFoundException{
//		Class clz = String.class;//String类型的class属性
//		Class clz1 = "abc".getClass();
//		Class clz2 
//			= Class.forName("java.lang.String");
//	}

}
class Compute{
	//一个int属性
	public int c;
	//两个构造方法
	public Compute(){
	}
	public Compute(int c){
		this.c = c;
	}
	//定义方法
	public double add(int a, double b){
		return a + b;
	}
	public double multi(int a, double b){
		return a * b;
	}
	
}

