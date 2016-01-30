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
		
		System.out.println("������" +clz.getName());//��ȡ����
		//��ȡ���еķ���
		System.out.println("�����б�");
		Method[] methods = clz.getMethods();
		for(Method m : methods){
			System.out.println(
					m.getReturnType().getName() 
					+ " " + m.getName());
		}
		//��ȡ���еĹ�����
		System.out.println("�������б�");
		Constructor[] cons = clz.getDeclaredConstructors();
		for(Constructor c : cons){
			System.out.println(c.getName());
		}
		//��ȡ���е�����
		System.out.println("�����б�");
		Field[] fields = clz.getFields();
		for (Field f : fields){
			System.out.println(f.getName());
		}
		
		if("day16.reflect.Compute".equals(clz.getName())){
			Object o = clz.newInstance();//���ù���������ʵ��
			
			Class[] types = {int.class, double.class};//���巽���Ĳ�������
			Object[] params = {1, 2};
			Method m 
				= clz.getDeclaredMethod("add", types);
			Object result = m.invoke(o, params);
			double d = (Double)result;
			System.out.println(d);
		}
		
		
	}
	
	//���ַ�ʽ��ȡClass��ʵ����
//	public void method()throws ClassNotFoundException{
//		Class clz = String.class;//String���͵�class����
//		Class clz1 = "abc".getClass();
//		Class clz2 
//			= Class.forName("java.lang.String");
//	}

}
class Compute{
	//һ��int����
	public int c;
	//�������췽��
	public Compute(){
	}
	public Compute(int c){
		this.c = c;
	}
	//���巽��
	public double add(int a, double b){
		return a + b;
	}
	public double multi(int a, double b){
		return a * b;
	}
	
}

