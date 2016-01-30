package oop.day05.abs;

/** 抽象类型, 是有概念, 但是不够具体 
 * 抽象类型可以定义变量
 * 抽象类型不能实例化(创建对象)
 * 抽象类型可以(只能)被继承
 * 具体类型继承一个抽象类型, 必须实现全部的抽象方法
 * */
public abstract class Shape {
  /** 图形在坐标系中的位置 */
  protected Point location;
  
  /** 计算图形的面积, 抽象的方法, 只有行为名, 
   * 没有具体的计算过程 */
  public abstract double area();
  /** 判断坐标是否在图形区域之内 */
  public abstract boolean contains(int x, int y);
  /** 判断点是否在图形区域之内, 是具体方法 */
  public boolean contains(Point p){
    return this.contains(p.x, p.y);
  }
}
