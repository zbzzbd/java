package oop.day05.inf;

public class QQDemo {
  public static void main(String[] args) {
    QQ qq = new QQ();
    Product p = qq;
    System.out.println(p.getPrice()); 
    Car car = qq;
    car.run();
    car.stop();
    //��������鷢����Car������û��getPrice()
    //System.out.print(car.getPrice());//�������
  }
}
