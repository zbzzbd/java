package oop.day05.inf;
/** 小汽车 */
public interface Car {
  //接口中的属性默认是常量! 省略了public static final
  String CLASS_A = "A";//汽车的级别A
  String CLASS_B = "B";
  String CLASS_C = "C";
  /** 接口中的方法一定是抽象方法, 省略public abstract */
  String getType();//获得汽车的级别
  
  public abstract void run();
  
  void stop();
}
