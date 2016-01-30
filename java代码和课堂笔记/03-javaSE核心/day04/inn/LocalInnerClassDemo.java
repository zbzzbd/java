package javase1.day04.inn;

import java.util.Arrays;
import java.util.Comparator;

/** 局部内部类, 类似局部变量, 在方法内部定义! */
public class LocalInnerClassDemo {
  int a = 6;//实例变量
  static int b = 10;//静态变量, 类变量
  public static void main(String[] args) {
    final int a = 5;//局部变量
    //具备内部类, 在方法中声明, 作用域类似于局部变量, 只在
    //当前方法中有效, 局部内部类可以访问方法中的final局部变量
    class Foo{
      int b = 5;
      public int add(){
        return a+b;//a 必须是final的! java语法规定!
      }
    }
    Foo f = new Foo();
    System.out.println(f.add()); //10
    
    System.out.println("利用局部内部类实现排序:"); 
    class ByLength implements Comparator<String>{
      public int compare(String o1, String o2) {
        return o1.length() - o2.length(); 
      }
    }
    String[] names = {"Tom","Jerry","qq", "Wooooo"};
    Arrays.sort(names, new ByLength());
    System.out.println(Arrays.toString(names));
  }
}
