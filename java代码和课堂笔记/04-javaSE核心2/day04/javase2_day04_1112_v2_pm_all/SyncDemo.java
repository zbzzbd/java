package javase2.day04;

import javase2.day04.Table.Person;

/** 
 * �̲߳�������, �İ�ȫ����
 * ����̲߳�����дͬһ���ٽ���Դ(����)ʱ���� 
 * ʵ������: ������(�����߳�) ������ͬһ�̶���(����)
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
        throw new RuntimeException("û��!");
      //Thread.yield();//Thread.sleep(10)//�Ŵ����
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
        System.out.println(getName()+"����"+bean);
        Thread.yield();
      }
    }
  }
}



