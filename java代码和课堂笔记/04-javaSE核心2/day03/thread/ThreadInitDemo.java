package javase2.day03.thread;
/** �̵߳Ĵ���: */
public class ThreadInitDemo {
  public static void main(String[] args) {
    final String name = "Robin";
    System.out.println("1 �̳�Thread��");
    Thread t1 = new Thread(){
      public void run() {
        System.out.println(name+"ʹ��������̳�Thread!"); 
      }
    };
    t1.start();
    
    System.out.println("2 ʹ��Runnable�ӿ�ʵ������");
    Runnable r = new Runnable(){
      public void run() {
        System.out.println(name+"ʹ��������ʵ��Runnable�ӿ�"); 
      }
    }; 
    Thread t2 = new Thread(r);
    t2.start();
    
    new Thread(){
      public void run() {
        System.out.println(name+"û�б��������߳�");
      };
    }.start();
    
    new Thread(new Runnable(){
      public void run() {
        System.out.println(name+"��һ��û�������߳�!"); 
      }
    }).start();
    
  }
}



