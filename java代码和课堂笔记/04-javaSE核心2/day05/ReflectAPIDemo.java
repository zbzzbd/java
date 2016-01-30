package javase2.day05;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/** 
 * Java JVM����ʱ��������÷���API������, ����, ����, ���Ե�
 * ������Java�����ҹ������, ����ʡ����
 * ��һЩ�ײ��ܿ���ʹ�õĺܹ㷺,��: Spring Hibernate Struts2
 * ��������ҵҵ����(CRM ���е�)��������ʹ�ú���, ���˽�Ϊ��
 * 
 * Java ����API, ��Java����API: �ṩ����,����,����,���õȹ���
 * A ���ֶ��������, ����, ������
 * B ����API���Ը�������, ���ù�������������.�����κ����͵�ʵ��
 *   1 �����޲���������
 *   2 �����в���������
 * C ����ĳ�����ĳ����
 * D ����ĳ�����ĳ����
 */
public class ReflectAPIDemo {
  public static void main(String[] args) {
    //Foo foo = new Foo();
    //discovery(foo);
    //discovery("foo");
    Object obj = create("javase2.day05.Foo");
    Object obj2 = create("javase2.day05.Foo", 
        new Class[]{int.class, String.class},
        new Object[]{8, "Tom"});
    
    discovery(obj);
    discovery(obj2);
    
    Object name = getField(obj2, "name");
    System.out.println(name);//Tom
    
    Object val = call(obj2, "getAge", 
        new Class[]{}, new Object[]{});
    System.out.println(val);//8
  }
  
  /**
   * ����ĳ�����ĳ����
   * @param obj ĳ����
   * @param name ĳ����
   * @param paramTypes ���������������б�,
   *    ��:new Class[]{int.class, String.class}
   * @param params �����б�
   *    ��:new Object[]{8, "Tom"}
   * @return ��������ֵ
   */
  public static Object call(
      Object obj, String name, 
      Class[] paramTypes, 
      Object[] params) {
    try{
      Class cls = obj.getClass();
      Method method = 
        cls.getDeclaredMethod(name, paramTypes);
      Object val = method.invoke(obj, params);
      return val;
    }catch(Exception e){
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  
  /**
   * ����ĳ�����ĳ����
   * @param obj
   * @param fieldName
   * @return ����ֵ
   */
  public static Object getField(
      Object obj, String fieldName) {
    try {
      Class cls = obj.getClass();
      Field field = cls.getDeclaredField(fieldName);
      Object val = field.get(obj);
      return val;
    } catch (SecurityException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    } catch (NoSuchFieldException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }



  /**
   * ����ĳ���͵��в������촴������
   * @param className ������: ����
   * @param paramTypes ���������������б�,
   *    ��:new Class[]{int.class, String.class}
   * @param params �����б�
   *    ��:new Object[]{8, "Tom"}
   * @return
   */
  public static Object create(
      String className, 
      Class[] paramTypes, 
      Object[] params){
    try {
      Class cls = Class.forName(className);
      Constructor constructor = 
        cls.getConstructor(paramTypes);
      Object obj = constructor.newInstance(params);
      return obj; 
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    } catch (SecurityException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    } catch (InstantiationException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    } catch (InvocationTargetException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  
  }
  
  /**
   * �������ͷ����޲�����������������
   */
  public static Object create(String className){
    try {
      //Class.forName() �Ǿ�̬����, ���ڴ��в���className
      //������ Class ʵ��. ����ڴ���û��, ��ȥCLASSPATH
      //�ϲ���className.class �ļ�, �ҵ��ͼ��������. ����
      //�����Classʵ��. ľ���ҵ�, ���׳��쳣
      //��˵: Class.forName() ����ʵ������������
      Class cls = Class.forName(className);
      //newInstance() ���������޲�����������������
      Object obj = cls.newInstance();
      return obj;
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    } catch (InstantiationException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
  
  
  /**
   * ���ֶ��������(��), ����, ������
   * @param obj
   */
  public static void discovery(Object obj){
    //Class ��һ������, "����"������, ��java.lang���ж���
    //java ��Ϊ�κξ�������(String, Integer) ����Class
    //��ʵ��, �����͵ĸ���, �Ƕ���. obj.getClass() ����
    //�Ϳ��Ի��һ�����������.
    System.out.println("1 ���ֶ��������:");
    Class cls = obj.getClass();
    System.out.println(cls.getName());//���͵�����:����
    //Foo.class ���ļ����ص��ڴ��Ժ�������Class��ʵ��
    System.out.println("2 �������͵�����:");
    //Field: �ֶ�, ����
    //Declared: ������ 
    Field[] fields = cls.getDeclaredFields();
    for(Field field: fields){
      System.out.println(
          field.getType()+" "+field.getName());
    }
    System.out.println("3 �������͵ķ���:");
    Method[] methods = cls.getDeclaredMethods();
    for (Method method : methods) {
      Class type = method.getReturnType();
      String name = method.getName();
      //Parameter: ��������
      Class[] paramTypes = method.getParameterTypes(); 
      System.out.println(type + " " + name + 
          Arrays.toString(paramTypes));
    }
    System.out.println("4 �������͵Ĺ�����:");
    Constructor[] constructors = 
      cls.getDeclaredConstructors();
    for(Constructor c : constructors){
      String name = c.getName();
      Class[] types = c.getParameterTypes();
      System.out.println(name+Arrays.toString(types)); 
    }
  }
}
class Foo{
  String name;
  int age;
  public Foo() {
  }
  public Foo(String name) {
    this.name = name;
  }
  public Foo(int age, String name) {
    this.name = name;
    this.age = age;
  }

  public int getAge(){
    return age;
  }
  public int test(int a){
    return a+age;
  }
}




