package javase1.day04.inn;

import java.util.Arrays;
import java.util.Comparator;

/** 匿名内部类演示, 匿名类 */
public class AnnClassDemo {
  public static void main(String[] args) {
    //new Koo(){} 匿名内部类! 是继承于Koo并同时创建子类对象
    //没有类名, 结果是对象, 类型是Koo子类型. 其中{} 是子类的
    //类体(class body) 类体中可以声明类的成员(属性,方法)
    Koo koo = new Koo(){
      public String toString(){
        return "匿名类";
      }
    };
    Koo k1 = new Koo();
    System.out.println(koo + ", " + k1); 
    //证明了koo实例中成功的覆盖了toString();
    //匿名类可以继承于: 类 抽象类 和 接口
    //继承于 抽象类 和 接口 时候要实现全部的抽象方法!
    //Moo m1 = new Moo();//编译错误, 不能创建抽象类实例
    Moo m2 = new Moo(){};//没有错误, 不是直接创建抽象类实例
    //new Moo(){}是匿名类, 是继承了Moo的子类,并同时创建实例
    //Xoo xoo = new Xoo(){};//编译错误, 没有实现抽象方法
    Xoo xoo = new Xoo(){
      int add() {//实现父类的抽象方法
        return 1+1;
      }
    };
    System.out.println(xoo.add());//2,动态绑定到对象方法
    
    final int a = 4;
    Yoo yoo = new Yoo(){ //匿名类可以用来实现接口
      int c = 8;
      public int add(int c) {
        return a+c+this.c; //匿名类可以访问final局部变量, 
      }
    };
    System.out.println(yoo.add(5));//17 
    //System.out.println(yoo.c);//编译错,Yoo类型没有c属性!
    final int dir = -1;
    String[] names = {"Tom", "Jerry","Tony Wang","QQ"};
    Comparator<String> byLength = 
      new Comparator<String>(){
      public int compare(String o1, String o2) {
        return dir * (o1.length()-o2.length());
      }
    };
    Arrays.sort(names, byLength);
    System.out.println(Arrays.toString(names));  
    
    Arrays.sort(names, new Comparator<String>(){
      public int compare(String o1, String o2) {
        return o1.length()-o2.length();
      }
    });
    System.out.println(Arrays.toString(names)); 
  }
}
interface Yoo{
  int add(int c);
}
abstract class Xoo{
  abstract int add();
}
abstract class Moo{
}

class Koo{
}

