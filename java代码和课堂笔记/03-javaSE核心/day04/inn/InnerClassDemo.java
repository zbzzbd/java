package javase1.day04.inn;

import javase1.day04.inn.Goo.Koo;

public class InnerClassDemo {
  public static void main(String[] args) {
    //Koo k1 = new Koo();//�������
    Goo g1 = new Goo();
    Koo k1 = g1.new Koo();//ʹ���ⲿ��ʵ�����ڲ���
    Koo k2 = g1.new Koo(); k2.a = 10;
    //��Ա�ڲ���, �������ⲿ��ʵ���Ķ���, k1 �� k2��g1����
    //k1��k2������g1, k1��k2 ���� g1 �����Ժͷ���
    System.out.println(k1.add(1)+","+k2.add(2)); 
    //K21 k22 ����g2 �����Ժͷ���
    Goo g2 = new Goo();
    g2.a = 10;
    Koo k21 = g2.new Koo();
    Koo k22 = g2.new Koo();
    k22.a = 20;
    System.out.println(k21.add(1)+","+k22.add(2)); 
                        //  19          32
  }
}
//Ȩ�޶���
class Goo{
  int a = 7;
  /** ��Ա�ڲ���, ������������ʵ������, ����ʹ���ⲿ��ʵ��
   * �����ڲ���ʵ��, ����ڲ���ʵ������ͬһ���ⲿ��ʵ����Ա*/
  class Koo{
    int a = 8;
    public int add(int a){
//      return javase1.day04.inn.Goo.this.a + 
//      javase1.day04.inn.Goo.Koo.this.a + a;       
      return Goo.this.a + this.a + a; 
    }
  }
}