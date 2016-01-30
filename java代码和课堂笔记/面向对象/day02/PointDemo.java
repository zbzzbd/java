package oop.day02;

public class PointDemo {
  public static void main(String[] args) {
    Point p1 = new Point(3,4);
    System.out.println(p1.x);
    Point p2 = new Point(1,1);//调用 Point(int,int)
    System.out.println(p2.x); 
    Point p3 = new Point(2);//调用 Point(int)
    System.out.println(p3.y);//2
    System.out.println(p1.distance());//
    System.out.println(p2.distance());//
    System.out.println(p3.distance());//
    System.out.println(p1.distance(6,8));//5
    System.out.println(p2.distance(6,8));// 
    System.out.println(p2.distance(p1));// 
  }
}/*
public class Point {
  int x;
  int y;
  public Point(int x, int y){
    //this.代表"当前"对象的引用
    this.x = x;
    this.y = y;
  }
  public double distance(){
    return Math.sqrt(this.x*this.x + this.y*this.y);
  }
}
*/
