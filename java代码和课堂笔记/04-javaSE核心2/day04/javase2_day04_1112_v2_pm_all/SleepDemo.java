package javase2.day04;

public class SleepDemo {
  public static void main(String[] args) 
    throws InterruptedException {
    System.out.println("��ʼ");
    long end = System.currentTimeMillis()+10000;
    for(int i=10; i>=0; i--){
      System.out.println(i);
      long now = System.currentTimeMillis();
      //ʹ��ϵͳʱ����м�ʱ����!
      System.out.println(end-now);  
      Thread.sleep(2000);
      if(end-now<=0){
        System.out.println("10��ʱ�䵽��");
        break;
      }
    }
    System.out.println("����"); 
  }
}
