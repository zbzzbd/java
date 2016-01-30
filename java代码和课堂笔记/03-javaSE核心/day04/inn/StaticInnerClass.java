package javase1.day04.inn;

import java.util.LinkedList;

import javase1.day04.inn.Foo.Koo;

/** 静态内部类
 * 集合的迭代器,和节点(Entry)等经常都是内部类!
 *  */
public class StaticInnerClass {
  public static void main(String[] args) {
    //LinkedList 链表节点就是内部类
    //TreeMap
    //ArrayList
    Koo k1 = new Koo();
    System.out.println(k1.add()); //8
  }
}
class Foo{
  static int a = 7;
  int b = 2;
  /** 静态 内部类, 外部类为内部类提供了命名空间
   * 实现Koo属于 Foo 内部命名, 实现类型Koo被封装到Foo内部
   * 静态内部类 可以共享外部类的静态成员(属性,方法)
   *  */
  static class Koo{
    public int add(){
      //return b+1;//编译错误, 不能访问非静态成员b!
      return a+1;
    }
  }
}