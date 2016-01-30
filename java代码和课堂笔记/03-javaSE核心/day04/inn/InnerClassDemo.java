package javase1.day04.inn;

import javase1.day04.inn.Goo.Koo;

public class InnerClassDemo {
  public static void main(String[] args) {
    //Koo k1 = new Koo();//编译错误
    Goo g1 = new Goo();
    Koo k1 = g1.new Koo();//使用外部类实创建内部类
    Koo k2 = g1.new Koo(); k2.a = 10;
    //成员内部类, 是属于外部类实例的对象, k1 和 k2是g1创建
    //k1和k2从属于g1, k1和k2 共享 g1 的属性和方法
    System.out.println(k1.add(1)+","+k2.add(2)); 
    //K21 k22 共享g2 的属性和方法
    Goo g2 = new Goo();
    g2.a = 10;
    Koo k21 = g2.new Koo();
    Koo k22 = g2.new Koo();
    k22.a = 20;
    System.out.println(k21.add(1)+","+k22.add(2)); 
                        //  19          32
  }
}
//权限定名
class Goo{
  int a = 7;
  /** 成员内部类, 作用域类似于实例变量, 必须使用外部类实例
   * 创建内部类实例, 多个内部类实例共享同一个外部类实例成员*/
  class Koo{
    int a = 8;
    public int add(int a){
//      return javase1.day04.inn.Goo.this.a + 
//      javase1.day04.inn.Goo.Koo.this.a + a;       
      return Goo.this.a + this.a + a; 
    }
  }
}