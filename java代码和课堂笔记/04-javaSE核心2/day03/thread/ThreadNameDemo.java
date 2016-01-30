package javase2.day03.thread;

public class ThreadNameDemo {
  public static void main(String[] args) {
    Thread t1 = new Thread(){
      public void run() {
        Foo.test();
      }
    };
    t1.start();
    Thread t2 = new Thread(){
      public void run() {
        Foo.test();
      }
    };
    t2.start();
    //currentThread() 方法可以获得正在调用当前方法的线程
    Thread main = Thread.currentThread();
    //线程有名字属性
    System.out.println("main 线程:"+main.getName()); 
    //在主线程中调用test()
    Foo.test();//在main方法调用test(), main被主线程调用,
  }
}
class Foo{
  /** 方法是在线程中执行的, 可以被不同的线程并发访问! */
  public static void test(){
    Thread t = Thread.currentThread();
    System.out.println(t.getName()+"调用了test()");
  }
}






