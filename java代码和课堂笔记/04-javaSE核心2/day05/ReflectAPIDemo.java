package javase2.day05;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/** 
 * Java JVM运行时候就是利用反射API管理类, 方法, 对象, 属性的
 * 反射是Java的自我管理机制, 是自省机制
 * 在一些底层框架开发使用的很广泛,如: Spring Hibernate Struts2
 * 但是在商业业务软(CRM 银行等)件开发中使用很少, 以了解为主
 * 
 * Java 反射API, 是Java基础API: 提供发现,访问,创建,调用等功能
 * A 发现对象的类型, 属性, 方法等
 * B 反射API可以根据类名, 调用构造器创建对象.创建任何类型的实例
 *   1 访问无参数构造器
 *   2 访问有参数构造器
 * C 访问某对象的某属性
 * D 调用某对象的某方法
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
   * 调用某对象的某方法
   * @param obj 某对象
   * @param name 某方法
   * @param paramTypes 构造器参数类型列表,
   *    如:new Class[]{int.class, String.class}
   * @param params 参数列表
   *    如:new Object[]{8, "Tom"}
   * @return 方法调用值
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
   * 访问某对象的某属性
   * @param obj
   * @param fieldName
   * @return 属性值
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
   * 调用某类型的有参数构造创建对象
   * @param className 类型名: 类名
   * @param paramTypes 构造器参数类型列表,
   *    如:new Class[]{int.class, String.class}
   * @param params 参数列表
   *    如:new Object[]{8, "Tom"}
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
   * 根据类型访问无参数构造器创建对象
   */
  public static Object create(String className){
    try {
      //Class.forName() 是静态方法, 在内存中查找className
      //对象类 Class 实例. 如果内存中没有, 就去CLASSPATH
      //上查找className.class 文件, 找到就加载这个类. 加载
      //结果是Class实例. 木有找到, 就抛出异常
      //简单说: Class.forName() 可以实现类的懒惰加载
      Class cls = Class.forName(className);
      //newInstance() 会调用类的无参数构造器创建对象
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
   * 发现对象的类型(类), 属性, 方法等
   * @param obj
   */
  public static void discovery(Object obj){
    //Class 是一个类型, "类型"的类型, 在java.lang包中定义
    //java 认为任何具体类型(String, Integer) 都是Class
    //的实例, 是类型的个体, 是对象. obj.getClass() 方法
    //就可以获得一个对象的类型.
    System.out.println("1 发现对象的类型:");
    Class cls = obj.getClass();
    System.out.println(cls.getName());//类型的名字:类名
    //Foo.class 类文件加载到内存以后就是这个Class的实例
    System.out.println("2 发现类型的属性:");
    //Field: 字段, 属性
    //Declared: 声明的 
    Field[] fields = cls.getDeclaredFields();
    for(Field field: fields){
      System.out.println(
          field.getType()+" "+field.getName());
    }
    System.out.println("3 发现类型的方法:");
    Method[] methods = cls.getDeclaredMethods();
    for (Method method : methods) {
      Class type = method.getReturnType();
      String name = method.getName();
      //Parameter: 方法参数
      Class[] paramTypes = method.getParameterTypes(); 
      System.out.println(type + " " + name + 
          Arrays.toString(paramTypes));
    }
    System.out.println("4 发现类型的构造器:");
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




