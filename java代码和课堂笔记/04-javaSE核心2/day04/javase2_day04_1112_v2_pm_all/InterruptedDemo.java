package javase2.day04;

public class InterruptedDemo {
  public static void main(String[] args) {
    final Thread main = Thread.currentThread();
    new Thread(){
      public void run() {
        try {
          Thread t = Thread.currentThread();
          System.out.println(t.getName()+"��ʼ");
          Thread.sleep(1000);
          System.out.println(
              t.getName()+"�ж�"+main.getName());
          main.interrupt();
        } catch (InterruptedException e) { } 
      }
    }.start();
    try {
      System.out.println(main.getName()+"��ʼ");
      Thread.sleep(2000);
      System.out.println(main.getName()+"����");
    } catch (InterruptedException e) {
      e.printStackTrace();
      System.out.println(main.getName()+"��������!");
    }
  }

}
