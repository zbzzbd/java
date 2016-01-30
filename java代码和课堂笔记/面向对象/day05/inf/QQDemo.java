package oop.day05.inf;

public class QQDemo {
  public static void main(String[] args) {
    QQ qq = new QQ();
    Product p = qq;
    System.out.println(p.getPrice()); 
    Car car = qq;
    car.run();
    car.stop();
    //编译器检查发现在Car类型上没有getPrice()
    //System.out.print(car.getPrice());//编译错误
  }
}
