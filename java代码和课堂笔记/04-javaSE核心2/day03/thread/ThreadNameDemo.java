package javase2.day03.thread;

public class ThreadNameDemo {
  public static void main(String[] args) {
    Thread t1 = new Thread(){
      public void run() {
        Foo.test();
      }
    };
    t1.start();
    Thread t2 = new Thread(){
      public void run() {
        Foo.test();
      }
    };
    t2.start();
    //currentThread() �������Ի�����ڵ��õ�ǰ�������߳�
    Thread main = Thread.currentThread();
    //�߳�����������
    System.out.println("main �߳�:"+main.getName()); 
    //�����߳��е���test()
    Foo.test();//��main��������test(), main�����̵߳���,
  }
}
class Foo{
  /** ���������߳���ִ�е�, ���Ա���ͬ���̲߳�������! */
  public static void test(){
    Thread t = Thread.currentThread();
    System.out.println(t.getName()+"������test()");
  }
}






