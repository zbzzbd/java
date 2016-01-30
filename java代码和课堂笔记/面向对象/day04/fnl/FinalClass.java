package oop.day04.fnl;

public class FinalClass {
  public static void main(String[] args) {

  }
}
//Java API 中String Integer Long Math 等 是final class
final class Foo{}
//class Koo extends Foo{}//编译错误, Foo不能被继承
//class MyString extends String{}//编译错误,String不能被继承
//final class 很少使用, Spring  Struts2  Hibernate...
//都使用"动态代理技术", 动态代理: 运行期间继承类,并覆盖所有方法
//final class  会干扰"动态代理技术", 不建议使用!
