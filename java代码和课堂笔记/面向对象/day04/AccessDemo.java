package oop.day04;

import oop.day04.sub.Koo;

public class AccessDemo{
  public static void main(String[] args){
    Foo f = new Foo();
    System.out.println(f.a);
    System.out.println(f.b);
    System.out.println(f.c);
    //System.out.println(f.d);//�������, d���ɼ�,��װ
    System.out.println(f.getD());//4, ��ȡd��ֵ,ֻ������
    f.c = 8;
    System.out.println("��package����");
    Koo k = new Koo();
    System.out.println(k.a);
    //System.out.println(k.b);//�������, ���ɼ�
    //System.out.println(k.c);//�������, ���ɼ�
    //System.out.println(k.d);//�������, ���ɼ�
    Goo g = new Goo();
    //System.out.println(g.b);//�������, ���ɼ�
    System.out.println(g.add());//7
  }
}
class Goo extends Koo{
  public int add(){
    return a+b+getD();//7 getD() �ܹ�����d��ֵ,˵����d
    //return a+b+c+d;//�������, 
    //return a+b;//�������ڲ����Է��� �����б���������b
  }
}
class Foo{
  public int a = 1;
  protected int b = 2;
  int c = 3;
  private int d = 4;
  public int getD(){
    return this.d; 
  }
}


