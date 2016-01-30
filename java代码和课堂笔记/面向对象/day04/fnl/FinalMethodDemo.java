package oop.day04.fnl;
/** final 方法, 不能再被覆盖了 */
public class FinalMethodDemo {
  public static void main(String[] args) {
    //覆盖(重写): 子类提供与父类方法签名一样的方法
    //重载: 方法名一样, 方法签名不同(参数列表不同)的方法
  }
}
class Goo{
  public final int add(int a, int b){
    return a+b;
  }
}
class Moo extends Goo{
  public int add(int a, char c){//方法的重载
    return a+c;
  }
  //public int add(int a, int b){//编译错, 不能覆盖
  //  return 0;
  //}
}
