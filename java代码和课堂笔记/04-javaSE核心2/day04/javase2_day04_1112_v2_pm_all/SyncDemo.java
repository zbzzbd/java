package javase2.day04;

import javase2.day04.Table.Person;

/** 
 * 线程并发访问, 的安全问题
 * 多个线程并发读写同一个临界资源(变量)时候发生 
 * 实例场景: 两个人(两个线程) 并发吃同一盘豆子(变量)
 **/
public class SyncDemo {
  public static void main(String[] args) {
    Table table = new Table();
    Person p1 = table.new Person();
    Person p2 = table.new Person();
    p1.start();
    p2.start();
  }
}
class Table{
  int beans = 20;
  //Object monitor = new Object();//lock
  public synchronized int getBean(){
    //synchronized (monitor) {
    //synchronized (this) {
      if(beans==0)
        throw new RuntimeException("没了!");
      //Thread.yield();//Thread.sleep(10)//放大错误
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      return beans--;
    //}
  }
  class Person extends Thread{
    public void run(){
      while(true){
        int bean = getBean();
        System.out.println(getName()+"吃了"+bean);
        Thread.yield();
      }
    }
  }
}



