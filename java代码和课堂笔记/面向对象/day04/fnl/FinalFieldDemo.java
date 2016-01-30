package oop.day04.fnl;

public class FinalFieldDemo {
  public static void main(String[] args) {
    Yoo y1 = new Yoo();
    Yoo y2 = new Yoo();
    //y1.id = 8;//编译错误, 不能修改id
    Yoo.index=8;
    y1.index = 9;
    System.out.println(Yoo.index);//9
  }
}
class Yoo{
  final int id;//id是实例变量, 初始化以后不能再改
  static int index = 1;//index是静态, 只有一份
  public Yoo(){
    id = index++;
  }
}




