package oop.day04;

public class ClassCastDemo {
  public static void main(String[] args) {
    Integer i = new Integer(5);
    Double d = new Double(5.5);
    Long l = new Long(1L);
    System.out.println("�Զ�����ת��: С���͵�������");
    Number n = i;//�Զ�����ת��
    System.out.println("ǿ������ת��: �����͵�С����");
    //Integer x = n;//�������
    Integer x = (Integer)n;//n������õ���Integer,ת��û����
    System.out.println(x);//5
    System.out.println("ǿ�����ͻ��п��ܻ�����쳣:");
    n = l;
    x = (Integer)n;//����������쳣, nʵ�����õ���Long
    
    
  }
}
