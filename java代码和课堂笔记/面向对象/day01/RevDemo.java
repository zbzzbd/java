package oop.day01;
/** ตÝน้ */
public class RevDemo {
  public static void main(String[] args) {
    int n = 4;
    int y = f(n);
    System.out.println(y);
  }
  /** 1+2+3+...+n */
  public static int f(int n){
    if(n==1)
      return 1;
    return f(n-1)+n;
    
  }
}
