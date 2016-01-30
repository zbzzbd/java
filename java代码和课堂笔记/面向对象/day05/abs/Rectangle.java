package oop.day05.abs;
/** ¾ØÐÎ */
public class Rectangle extends Shape {
  
  private int width;
  private int height;
  public Rectangle() {
  }
  public Rectangle(Point location, int w, int h) {
    this.location = location;
    width = w;
    height = h;
  }
  public Rectangle(int x, int y, int w, int h) {
    this(new Point(x, y), w, h);
  }
  
  public double area() {
    return this.width * this.height;
  }
  
  public boolean contains(int x, int y) {
    int w = x - location.x;
    int h = y-location.y;
    return w>=0 &&  w <= width 
        && h>=0 &&  h <=height;
  }
}
