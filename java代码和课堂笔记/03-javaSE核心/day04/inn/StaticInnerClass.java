package javase1.day04.inn;

import java.util.LinkedList;

import javase1.day04.inn.Foo.Koo;

/** ��̬�ڲ���
 * ���ϵĵ�����,�ͽڵ�(Entry)�Ⱦ��������ڲ���!
 *  */
public class StaticInnerClass {
  public static void main(String[] args) {
    //LinkedList ����ڵ�����ڲ���
    //TreeMap
    //ArrayList
    Koo k1 = new Koo();
    System.out.println(k1.add()); //8
  }
}
class Foo{
  static int a = 7;
  int b = 2;
  /** ��̬ �ڲ���, �ⲿ��Ϊ�ڲ����ṩ�������ռ�
   * ʵ��Koo���� Foo �ڲ�����, ʵ������Koo����װ��Foo�ڲ�
   * ��̬�ڲ��� ���Թ����ⲿ��ľ�̬��Ա(����,����)
   *  */
  static class Koo{
    public int add(){
      //return b+1;//�������, ���ܷ��ʷǾ�̬��Աb!
      return a+1;
    }
  }
}