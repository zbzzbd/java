package javase2.day04;

public class StringBufferDemo {
  public static void main(String[] args) {
    final Demo demo = new Demo();
    new Thread(){
      public void run() {
        demo.test("Tom", 1);
      }
    }.start();
    demo.test("Jerry", 2);
  }
}
class Demo{
  //StringBuffer �ǲ������ʰ�ȫ��
  StringBuffer names = new StringBuffer();
  public void test(String name, int index){
    //StringBuilder �Ƿ��̰߳�ȫ��, �������߳��ڲ�ʹ��
    //�������߳��ڲ�����ʱ����, ÿ������test�������߳�
    //���ᴴ��һ��StringBuilderʵ��, û�в�����������!
    StringBuilder buf = new StringBuilder();
    buf.append(name).append(index);
    names.append(buf);
  }
}