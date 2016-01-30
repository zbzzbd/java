package javase2.day04;

public class SleepDemo {
  public static void main(String[] args) 
    throws InterruptedException {
    System.out.println("开始");
    long end = System.currentTimeMillis()+10000;
    for(int i=10; i>=0; i--){
      System.out.println(i);
      long now = System.currentTimeMillis();
      //使用系统时间进行计时操作!
      System.out.println(end-now);  
      Thread.sleep(2000);
      if(end-now<=0){
        System.out.println("10秒时间到了");
        break;
      }
    }
    System.out.println("结束"); 
  }
}
