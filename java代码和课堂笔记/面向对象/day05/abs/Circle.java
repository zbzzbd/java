package oop.day05.abs;
/** 编译器检查子类一定实现抽象类的全部方法. 
 * 父类型的抽象方法是子类型的行为约定! 
 * 抽象方法是子类的强制规范!
 * 实现方法就是: 方法的覆盖
 *  */
public class Circle extends Shape {
  private int r;
  public Circle() {
  }
  public Circle(Point center, int r) {
    this.location = center;
    this.r = r;
  }
  public Circle(int x, int y, int r) {
    this(new Point(x,y), r);
  }
  public double area() {
    return Math.PI*r*r;
  }
  public boolean contains(int x, int y) {
    return this.location.distance(x, y)<=r;
  }
}
