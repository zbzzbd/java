package javase1.day02;
import java.util.LinkedList;
public class LinkedListDemo {
  public static void main(String[] args) {
    //LinkedList: ����˫��ѭ������ʵ�ֵ�List(���Ա�)�ṹ
    // LinkedList: ����洢�ṹ + ����Ĳ���(��ɾ�Ĳ�)
    // ArrayList: Object[]�洢�ṹ+�������(��ɾ�Ĳ�)
    // ArrayList: ��������洢, ����index�����ٶȷǳ���
    //            ˳��(indexOf)��ѯ��, ������(��Ҫ�ƶ�)
    // LinkedList: ��������洢, ͷβ����ɾ���ǳ���
    // �����д��ʹ��: ArrayList! 
    // Vector: Ҳ�� Object[]�洢�ṹ+�������(��ɾ�Ĳ�)
    
    // ArrayList: Java 1.2 �Ժ�, ���ܺ� ���̰߳�ȫ
    // Vector: ����java 1.1 �����Բ� �̰߳�ȫ
    
    
    LinkedList list = new LinkedList();
    list.add("����");
    list.add("����");
    list.add("Ƽ��");
    list.add("����");
    list.add(0, "���γ��");
    System.out.println(list); 
  }
}
