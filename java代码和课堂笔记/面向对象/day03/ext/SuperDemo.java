package oop.day03.ext;

public class SuperDemo {
  public static void main(String[] args) {
    Roo r = new Roo('6');
    System.out.println(r.a); 
  }
}
class Soo{
  int a;
  public Soo(int a) {
    System.out.println(this.a);//0
    this.a=a;
  }
}
class Roo extends Soo{
  public Roo(){
    super(5);//super() 必须在构造器的第一行和this()互斥
  }
  public Roo(char c){
    this();
    System.out.println(this.a);//5
    super.a = c-'0';//super. 是代表父类实例的引用,
  }
}
