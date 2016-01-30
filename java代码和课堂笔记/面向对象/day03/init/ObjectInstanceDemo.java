package oop.day03.init;
/** 对象的实例化过程 */
public class ObjectInstanceDemo {
  public static void main(String[] args) {
    //...
    Koo k = new Koo();
    System.out.println(k.a+","+k.b); 
  }
}
class Foo extends Object{
  int a = 1;
  public Foo(){
    System.out.println("Foo(), a:"+a);//1
    a = 5;
    System.out.println("Foo(), a:"+a);//5
  }
}
class Koo extends Foo{
  int b = 2;
  public Koo() {
    super();
    System.out.println("Koo(), a:"+a);//5
    System.out.println("Koo(), b:"+b);//2
    a = 6;
    b = 7;
  }
}
