package javase2.day03.thread;

public class ThreadDemo {
  public static void main(String[] args) {
    Person1 p1 = new Person1();
    Person2 p2 = new Person2();
    Person3 p3 = new Person3();
    p3.setPriority(Thread.MAX_PRIORITY);//10 最高
    p1.setPriority(Thread.MIN_PRIORITY);//1 最低
    //p2 是第5级
    p1.setDaemon(true);//将p1作为后台线程
    p1.start();//将尽快的启动run()方法
    p2.start();
    p3.start();
  }
}
class Person1 extends Thread{
  public void run(){//并发运行的过程run
    for(int i=0; i<10000; i++){
      System.out.println("做弹弓子, 打你家玻璃!"); 
      Thread.yield();
    }
    System.out.println("弹弓子!Over");
  }
}
class Person2 extends Thread{
  public void run() {
    for(int i=0; i<100; i++){
      System.out.println("你是谁?"); 
      Thread.yield();
    }
    System.out.println("你是谁?!Over");
  }
}
class Person3 extends Thread{
  public void run() {
    for(int i=0; i<100; i++){
      System.out.println("修煤气的?"); 
      Thread.yield();
    }
    System.out.println("修煤气的?!Over");
  }
}