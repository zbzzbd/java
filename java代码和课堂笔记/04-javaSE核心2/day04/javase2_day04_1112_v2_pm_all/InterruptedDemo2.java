package javase2.day04;

public class InterruptedDemo2 {
  public static void main(String[] args) {
    //t1 线程睡觉, 如果被砸醒, 就输出破相了!
    final Thread t1 = new Thread(){
      public void run() {
        try{
          for(int i=0; i<10; i++){
            System.out.println("睡觉...");
            Thread.sleep(2000);
            System.out.println("没事!");
          }
        }catch(InterruptedException e){
          e.printStackTrace();
          System.out.println("干嘛哪! 破相了!");
        }
      }
    };
    //t2 线程砸墙, 砸8次把墙砸开! 打断t1的休眠 
    Thread t2 = new Thread(){
      public void run(){
        for(int i=0;i<8;i++){
          System.out.println("唉呦, 我砸!"); 
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        System.out.println("搞定, 砸开了!");
        t1.interrupt();//打断t1的休眠
      }
    };
    t1.start();
    t2.start();
  }
}




