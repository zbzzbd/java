package oop.day04.stat;

public class StaticStatementDemo {
  public static void main(String[] args) {
    Xoo x = new Xoo();
    Xoo x2 = new Xoo();
  }
}
class Xoo{
  int a = 1;
  //System.out.println("HI");//�����, ���в��������
  { //�Ǿ�̬�����, �ڴ��������ڼ�ִ�� 
    System.out.println("���д����!");
  }
  static {// ��̬���������ļ����ڼ�ִ��
    System.out.println("���о�̬�����!");
  }
}

