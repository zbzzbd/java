package javase2.day04;
/** ������������ʾ:  
 * ����������: ��һ���߳�, ������ղ�ʹ�õĶ��ڴ����, 
 * ��һ�������ȼ�, ��̨�߳�. ��������: �����κ����õĶ���
 * ����������, �߳̾���������״̬, ��"�ʵ�ʱ��"�������ն���
 * "�ʵ�ʱ��" �ǿ������õ�(JVM ���Ż�����)
 * ����ʹ�� System.gc() ��������������ڴ����
 * */
public class GCDemo {
  public static void main(String[] args) {
    Foo f = new Foo(); Foo f1 = new Foo();
    Foo ff = f; f = null; f1 = null;
    //ff = null;
    //"gc() ����������������" �Ǵ����!
    System.gc();//GC:��������, gc()������������������߳�
    ff = null;
  }// final finally finalize
}
class Foo{
  /** ����Object�ķ���, �Ǳ������������ͷŶ���ʱ�����!
   * �ǲ����鸲�ǵ�! �������һ������super.finalize();
   *  */
  protected void finalize() throws Throwable {
    super.finalize();
    Thread t = Thread.currentThread();
    System.out.println("�����������߳�:"+t.getName()); 
    System.out.println("�һ������!");//I will be back;
  }
}
