package oop.day05.inf;
/** QQ 是小汽车, 也是商品, 是多继承现象 
 * 实现接口使用关键字: implements 本质上也是继承关系
 *  */
public class QQ 
  implements Car, Product {
  public double getPrice() {
    return 29999;
  }
  public String getType() {
    return CLASS_A;//CLASS_A 继承于Car
  }
  public void run() {
    System.out.println("QQ 跑了!");
  }
  public void stop() {
    System.out.println("QQ 停了!");
  }
}
