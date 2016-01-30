package javase2.day03.thread;
/** 线程的创建: */
public class ThreadInitDemo {
  public static void main(String[] args) {
    final String name = "Robin";
    System.out.println("1 继承Thread类");
    Thread t1 = new Thread(){
      public void run() {
        System.out.println(name+"使用匿名类继承Thread!"); 
      }
    };
    t1.start();
    
    System.out.println("2 使用Runnable接口实例创建");
    Runnable r = new Runnable(){
      public void run() {
        System.out.println(name+"使用匿名类实现Runnable接口"); 
      }
    }; 
    Thread t2 = new Thread(r);
    t2.start();
    
    new Thread(){
      public void run() {
        System.out.println(name+"没有变量名的线程");
      };
    }.start();
    
    new Thread(new Runnable(){
      public void run() {
        System.out.println(name+"又一个没有名的线程!"); 
      }
    }).start();
    
  }
}



