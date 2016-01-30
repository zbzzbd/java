package oop.day02;
/**
 * 类一定有构造器! 
 * A 如果没有声明任何构造器, Javac自动提供默认构造器
 * B 如果声明了构造器Javac不在提供默认构造器
 */
public class ConstructorDemo {
  public static void main(String[] args) {
    Foo foo = new Foo();//调用默认构造器
    //Koo koo = new Koo();//编译错误, Koo没有无参数构造器
    Koo k = new Koo(3);//Koo只有有参数构造器!
    System.out.println(k.a); //3
  }
}
class Foo{ //Foo中有默认构造器, 由javac自动添加
  //public Foo(){};//默认构造器
}
class Koo{
  int a;
  public Koo(int a){ //Javac不再提供默认构造器
    this.a=a;
  }
}

