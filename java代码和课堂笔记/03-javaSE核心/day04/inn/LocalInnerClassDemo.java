package javase1.day04.inn;

import java.util.Arrays;
import java.util.Comparator;

/** �ֲ��ڲ���, ���ƾֲ�����, �ڷ����ڲ�����! */
public class LocalInnerClassDemo {
  int a = 6;//ʵ������
  static int b = 10;//��̬����, �����
  public static void main(String[] args) {
    final int a = 5;//�ֲ�����
    //�߱��ڲ���, �ڷ���������, �����������ھֲ�����, ֻ��
    //��ǰ��������Ч, �ֲ��ڲ�����Է��ʷ����е�final�ֲ�����
    class Foo{
      int b = 5;
      public int add(){
        return a+b;//a ������final��! java�﷨�涨!
      }
    }
    Foo f = new Foo();
    System.out.println(f.add()); //10
    
    System.out.println("���þֲ��ڲ���ʵ������:"); 
    class ByLength implements Comparator<String>{
      public int compare(String o1, String o2) {
        return o1.length() - o2.length(); 
      }
    }
    String[] names = {"Tom","Jerry","qq", "Wooooo"};
    Arrays.sort(names, new ByLength());
    System.out.println(Arrays.toString(names));
  }
}
