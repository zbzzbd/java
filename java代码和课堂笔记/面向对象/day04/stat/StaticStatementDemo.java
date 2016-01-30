package oop.day04.stat;

public class StaticStatementDemo {
  public static void main(String[] args) {
    Xoo x = new Xoo();
    Xoo x2 = new Xoo();
  }
}
class Xoo{
  int a = 1;
  //System.out.println("HI");//编译错, 类中不能有语句
  { //非静态代码块, 在创建对象期间执行 
    System.out.println("运行代码块!");
  }
  static {// 静态代码块在类的加载期间执行
    System.out.println("运行静态代码块!");
  }
}

