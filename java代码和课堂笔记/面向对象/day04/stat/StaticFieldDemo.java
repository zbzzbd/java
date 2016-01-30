package oop.day04.stat;

public class StaticFieldDemo {
  public static void main(String[] args) {
    Foo f1 = new Foo();
    Foo f2 = new Foo();
    System.out.println(f1.id+","+f2.id+","+Foo.index);
  }//                      1        2         3
}
class Foo{
  int id;//实例变量, 属于对象实例的变量, 每个对象一个id
  static int index=1;//静态变量, 是属于类的, 只有一份
  public Foo(){
    id = index++;
  }
}






