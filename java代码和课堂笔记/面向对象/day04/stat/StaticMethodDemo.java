package oop.day04.stat;

public class StaticMethodDemo {
  public static void main(String[] args) {
    int x = Koo.add(3, 3);
    System.out.println(x);
    Koo k = new Koo();
    System.out.println(k.add(8));//add(k,8) 
    //Java API 中的静态方法:
    // Integer.toHexString(); Arrays.sort()
    // Math.pow() Math.sqrt() Math.sin() 
    // Long.toBinarryString()
    
    System.out.println(Math.sin(Math.PI/2));  
    
    int i = Integer.parseInt("1000", 2);
    System.out.println(i);//8
    i = Integer.parseInt("800");
    System.out.println(i);//800
    
  }
}
class Koo{
  int c=4;
  static int d=2;
  public static int add(int a, int b){
    return a+b+d;
  }
  public int add(/* Koo this */int a){
    return a+this.c;
  }
}



