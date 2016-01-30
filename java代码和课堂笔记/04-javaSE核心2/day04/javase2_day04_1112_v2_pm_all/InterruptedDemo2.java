package javase2.day04;

public class InterruptedDemo2 {
  public static void main(String[] args) {
    //t1 �߳�˯��, ���������, �����������!
    final Thread t1 = new Thread(){
      public void run() {
        try{
          for(int i=0; i<10; i++){
            System.out.println("˯��...");
            Thread.sleep(2000);
            System.out.println("û��!");
          }
        }catch(InterruptedException e){
          e.printStackTrace();
          System.out.println("������! ������!");
        }
      }
    };
    //t2 �߳���ǽ, ��8�ΰ�ǽ�ҿ�! ���t1������ 
    Thread t2 = new Thread(){
      public void run(){
        for(int i=0;i<8;i++){
          System.out.println("����, ����!"); 
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        System.out.println("�㶨, �ҿ���!");
        t1.interrupt();//���t1������
      }
    };
    t1.start();
    t2.start();
  }
}




