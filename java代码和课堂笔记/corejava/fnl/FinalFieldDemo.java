package oop.day04.fnl;

public class FinalFieldDemo {
  public static void main(String[] args) {
    Yoo y1 = new Yoo();
    Yoo y2 = new Yoo();
    //y1.id = 8;//�������, �����޸�id
    Yoo.index=8;
    y1.index = 9;
    System.out.println(Yoo.index);//9
  }
}
class Yoo{
  final int id;//id��ʵ������, ��ʼ���Ժ����ٸ�
  static int index = 1;//index�Ǿ�̬, ֻ��һ��
  public Yoo(){
    id = index++;
  }
}




