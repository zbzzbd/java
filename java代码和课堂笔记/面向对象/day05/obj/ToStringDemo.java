package oop.day05.obj;

import java.util.Arrays;

/** java API 经常默认调用toString()输出对象的文本描述 */
public class ToStringDemo {
  public static void main(String[] args) {
    Foo f = new Foo();
    Koo k = new Koo();
    //默认toString()返回 类名@hashCode, 建议覆盖掉
    System.out.println(f);//调用默认的toStirng()输出
    System.out.println(k);//调用子类的toStirng()输出
    System.out.println("k:"+k);
    Object[] ary = {new Koo(), k, f};
    System.out.println(Arrays.toString(ary));
    Point p = new Point(3,4);
    System.out.println(p); 
  }
}
class Point{
  int x; int y;
  public Point(int x, int y) {
    this.x = x; this.y = y;
  }
  public String toString() {
    return "("+x+","+y+")";
  }
}
class Foo{
}
class Koo{
  public String toString() {//覆盖了toString() 方法
    return "Koo";
  }
}
