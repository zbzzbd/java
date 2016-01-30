package javase2.day04;

public class StringBufferDemo {
  public static void main(String[] args) {
    final Demo demo = new Demo();
    new Thread(){
      public void run() {
        demo.test("Tom", 1);
      }
    }.start();
    demo.test("Jerry", 2);
  }
}
class Demo{
  //StringBuffer 是并发访问安全的
  StringBuffer names = new StringBuffer();
  public void test(String name, int index){
    //StringBuilder 是非线程安全是, 可以在线程内部使用
    //这里是线程内部的临时变量, 每个调用test方法的线程
    //都会创建一个StringBuilder实例, 没有并发访问现象!
    StringBuilder buf = new StringBuilder();
    buf.append(name).append(index);
    names.append(buf);
  }
}