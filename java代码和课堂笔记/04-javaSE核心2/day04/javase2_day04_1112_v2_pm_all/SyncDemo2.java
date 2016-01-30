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
//Goo ������add�����ǻ����, һ��add������ִ���ڼ�, ����
//���ʵ�add�����Ǵ��ڵȴ�״̬. �ȴ�ͬ��������(��)���ͷ�
class Goo{
  int counter=0;//�ٽ���Դ
  public synchronized int add(int a, int b){
    System.out.println("��ʼ����add(a,b)");
    if(counter==10){
      throw new RuntimeException("��10����!"); 
    }
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    counter++;
    System.out.println("��������add(a,b)");
    return a+b;
  }
  public synchronized int add(int a){
    System.out.println("��ʼ����add(a)");
    if(counter==10){
      throw new RuntimeException("��10����!"); 
    }
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    counter++;
    System.out.println("��������add(a)");
    return a+1;
  }
}
