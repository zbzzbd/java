package oop.day04.fnl;
/** final ����, �����ٱ������� */
public class FinalMethodDemo {
  public static void main(String[] args) {
    //����(��д): �����ṩ�븸�෽��ǩ��һ���ķ���
    //����: ������һ��, ����ǩ����ͬ(�����б�ͬ)�ķ���
  }
}
class Goo{
  public final int add(int a, int b){
    return a+b;
  }
}
class Moo extends Goo{
  public int add(int a, char c){//����������
    return a+c;
  }
  //public int add(int a, int b){//�����, ���ܸ���
  //  return 0;
  //}
}
