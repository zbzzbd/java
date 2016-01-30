package javase2.day04;

public class InterruptedDemo {
  public static void main(String[] args) {
    final Thread main = Thread.currentThread();
    new Thread(){
      public void run() {
        try {
          Thread t = Thread.currentThread();
          System.out.println(t.getName()+"开始");
          Thread.sleep(1000);
          System.out.println(
              t.getName()+"中断"+main.getName());
          main.interrupt();
        } catch (InterruptedException e) { } 
      }
    }.start();
    try {
      System.out.println(main.getName()+"开始");
      Thread.sleep(2000);
      System.out.println(main.getName()+"醒来");
    } catch (InterruptedException e) {
      e.printStackTrace();
      System.out.println(main.getName()+"被吵醒了!");
    }
  }

}
