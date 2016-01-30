package oop.day05.obj;

import java.util.Arrays;

/** java API ����Ĭ�ϵ���toString()���������ı����� */
public class ToStringDemo {
  public static void main(String[] args) {
    Foo f = new Foo();
    Koo k = new Koo();
    //Ĭ��toString()���� ����@hashCode, ���鸲�ǵ�
    System.out.println(f);//����Ĭ�ϵ�toStirng()���
    System.out.println(k);//���������toStirng()���
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
  public String toString() {//������toString() ����
    return "Koo";
  }
}
