package oop.day03;
/** 方法的重载 */
public class MethodDemo {
  public static void main(String[] args) {
    Foo foo = new Foo();
    System.out.println(foo.add(3));
    //Java 根据方法签名识别方法, 就"近"调用
    System.out.println(foo.add('3'));
    System.out.println(foo.add(3,'3'));
  }
}
class Foo{
  public int add(int x, int y){//add(int,int)
    return x+y;
  }  
  public int add(int x){//add(int)
    return x+1;
  }
  public int add(char x){//add(char)
    return x-'0'+1;
  }
  //public int add(int y){//编译错误add(int)
  //  return y+1;
 // }
}