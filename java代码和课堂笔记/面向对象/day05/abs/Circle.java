package oop.day05.abs;
/** �������������һ��ʵ�ֳ������ȫ������. 
 * �����͵ĳ��󷽷��������͵���ΪԼ��! 
 * ���󷽷��������ǿ�ƹ淶!
 * ʵ�ַ�������: �����ĸ���
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
