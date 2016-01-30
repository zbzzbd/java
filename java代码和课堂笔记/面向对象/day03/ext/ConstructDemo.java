package oop.day03.ext;
/**
 * 继承中的构造器, 语法规定:
 * 1 构造器不能继承
 * 2 类一定构造器
 * 3 子类构造器一定调用父类构造器(可能间接调用)
 * 
 * 使用super() 可以调用父构造器
 * 子类默认调用父类"无参数构造器", 
 * 如果没有无参数构造器, 需要使用super()明确调用某个构造器 
 * 
 * 编程建议: 类都提供无参数构造器!使用默认规则,方便子类书写
 *  */
public class ConstructDemo {
  public static void main(String[] args) {
    Foo foo = new Foo();//子类构造器默认调用了父类构造器
    //选择输出结果: A.编译错误 B.运行异常 C.无 D.Call Koo()
    //Moo moo = new Moo(6);//编译错, 构造器不能继承!
    Moo moo = new Moo();
    System.out.println(moo.a);//5
  }
}
class Goo{
  int a;
  public Goo(int a){
    this.a=a;
  }
}
//class Moo extends Goo{}//编译错误,父类没有无参数构造器
class Moo extends Goo{
  public Moo(){
    //super();//编译错,父类没有无参数构造器
    super(5);//调用父类有参数构造器
  }
}
class Koo{
  public Koo(){
    System.out.println("Call Koo()");
  } 
}
class Foo extends Koo{//Foo默认构造器调用了Koo的默认构造器
//  public Foo(){
//    super();
//  }
};






