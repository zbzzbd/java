package oop.day04.stat;

public class StaticFieldDemo {
  public static void main(String[] args) {
    Foo f1 = new Foo();
    Foo f2 = new Foo();
    System.out.println(f1.id+","+f2.id+","+Foo.index);
  }//                      1        2         3
}
class Foo{
  int id;//ʵ������, ���ڶ���ʵ���ı���, ÿ������һ��id
  static int index=1;//��̬����, ���������, ֻ��һ��
  public Foo(){
    id = index++;
  }
}






