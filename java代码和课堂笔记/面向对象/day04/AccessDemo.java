package oop.day04;

import oop.day04.sub.Koo;

public class AccessDemo{
  public static void main(String[] args){
    Foo f = new Foo();
    System.out.println(f.a);
    System.out.println(f.b);
    System.out.println(f.c);
    //System.out.println(f.d);//编译错误, d不可见,封装
    System.out.println(f.getD());//4, 读取d的值,只读属性
    f.c = 8;
    System.out.println("跨package访问");
    Koo k = new Koo();
    System.out.println(k.a);
    //System.out.println(k.b);//编译错误, 不可见
    //System.out.println(k.c);//编译错误, 不可见
    //System.out.println(k.d);//编译错误, 不可见
    Goo g = new Goo();
    //System.out.println(g.b);//编译错误, 不可见
    System.out.println(g.add());//7
  }
}
class Goo extends Koo{
  public int add(){
    return a+b+getD();//7 getD() 能够返回d的值,说明有d
    //return a+b+c+d;//编译错误, 
    //return a+b;//在子类内部可以访问 父类中保护的属性b
  }
}
class Foo{
  public int a = 1;
  protected int b = 2;
  int c = 3;
  private int d = 4;
  public int getD(){
    return this.d; 
  }
}


