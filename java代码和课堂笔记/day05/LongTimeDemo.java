package basic.day05;

public class LongTimeDemo {
  public static void main(String[] args) {
    long now = System.currentTimeMillis();
    System.out.println(now);//1970~现在的毫秒数
    System.out.println(now/1000/60/60/24/365 + 1970);
    long max = 0x7fffffffffffffffl;
    System.out.println(max/1000/60/60/24/366+1970);
  }
}
