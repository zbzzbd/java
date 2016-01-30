package javase2.day04;
 
public class SyncDemo2 {
  public static void main(String[] args) {
    final Goo goo = new Goo(); 
    new Thread(){
      public void run() {
        System.out.println(goo.add(1,2));
      }
    }.start();
    new Thread(){
      public void run() {
        System.out.println(goo.add(2));
      }
    }.start();
  }
}
//Goo 的两个add方法是互斥的, 一个add方法在执行期间, 并发
//访问的add方法是处于等待状态. 等待同步监视器(锁)的释放
class Goo{
  int counter=0;//临界资源
  public synchronized int add(int a, int b){
    System.out.println("开始计算add(a,b)");
    if(counter==10){
      throw new RuntimeException("到10次了!"); 
    }
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    counter++;
    System.out.println("结束计算add(a,b)");
    return a+b;
  }
  public synchronized int add(int a){
    System.out.println("开始计算add(a)");
    if(counter==10){
      throw new RuntimeException("到10次了!"); 
    }
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    counter++;
    System.out.println("结束计算add(a)");
    return a+1;
  }
}
