package javase2.day04;
/** 垃圾回收器演示:  
 * 垃圾回收器: 是一个线程, 负责回收不使用的对内存对象, 
 * 是一个低优先级, 后台线程. 垃圾对象: 不被任何引用的对象
 * 垃圾回收器, 线程经常是休眠状态, 在"适当时候"启动回收对象
 * "适当时候" 是可以配置的(JVM 的优化配置)
 * 可以使用 System.gc() 尽快的启动回收内存对象
 * */
public class GCDemo {
  public static void main(String[] args) {
    Foo f = new Foo(); Foo f1 = new Foo();
    Foo ff = f; f = null; f1 = null;
    //ff = null;
    //"gc() 调用了垃圾回收器" 是错误的!
    System.gc();//GC:垃圾回收, gc()尽快的启动垃圾回收线程
    ff = null;
  }// final finally finalize
}
class Foo{
  /** 覆盖Object的方法, 是被垃圾回收器释放对象时候调用!
   * 是不建议覆盖的! 如果覆盖一定调用super.finalize();
   *  */
  protected void finalize() throws Throwable {
    super.finalize();
    Thread t = Thread.currentThread();
    System.out.println("垃圾回收器线程:"+t.getName()); 
    System.out.println("我会回来的!");//I will be back;
  }
}
