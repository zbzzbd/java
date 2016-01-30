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
    super(5);//super() �����ڹ������ĵ�һ�к�this()����
  }
  public Roo(char c){
    this();
    System.out.println(this.a);//5
    super.a = c-'0';//super. �Ǵ�����ʵ��������,
  }
}
