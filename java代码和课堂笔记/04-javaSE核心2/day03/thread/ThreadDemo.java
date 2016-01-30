package javase2.day03.thread;

public class ThreadDemo {
  public static void main(String[] args) {
    Person1 p1 = new Person1();
    Person2 p2 = new Person2();
    Person3 p3 = new Person3();
    p3.setPriority(Thread.MAX_PRIORITY);//10 ���
    p1.setPriority(Thread.MIN_PRIORITY);//1 ���
    //p2 �ǵ�5��
    p1.setDaemon(true);//��p1��Ϊ��̨�߳�
    p1.start();//�����������run()����
    p2.start();
    p3.start();
  }
}
class Person1 extends Thread{
  public void run(){//�������еĹ���run
    for(int i=0; i<10000; i++){
      System.out.println("��������, ����Ҳ���!"); 
      Thread.yield();
    }
    System.out.println("������!Over");
  }
}
class Person2 extends Thread{
  public void run() {
    for(int i=0; i<100; i++){
      System.out.println("����˭?"); 
      Thread.yield();
    }
    System.out.println("����˭?!Over");
  }
}
class Person3 extends Thread{
  public void run() {
    for(int i=0; i<100; i++){
      System.out.println("��ú����?"); 
      Thread.yield();
    }
    System.out.println("��ú����?!Over");
  }
}