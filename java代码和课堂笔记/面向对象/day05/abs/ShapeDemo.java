package oop.day05.abs;

public class ShapeDemo {
  public static void main(String[] args) {
    Shape s = new Circle(3,4,5);
    Point p = new Point(0,0);
    System.out.println(s.contains(p));
    System.out.println(s.area()); 
    s = new Rectangle(4,5,3,3);
    System.out.println(s.contains(p));
    System.out.println(s.area()); 
  }

}
