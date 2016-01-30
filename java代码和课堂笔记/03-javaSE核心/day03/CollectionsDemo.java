package javase1.day03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsDemo {
  public static void main(String[] args) {
    List<String> names = new ArrayList<String>();
    names.add("Tom");
    names.add("Andy");
    names.add("Wang");
    names.add("Robin");
    names.add("Tom");
    Collections.sort(names);//����
    System.out.println(names);
    //�ַ�������������?��:�ַ������ԱȽϴ�С, ���ݴ�С����
    //�ַ�������αȽϴ�С��?��:�ַ����ṩ�˱Ƚϴ�С�ķ���:
//  A.comapreTo(B), ����>0 �� A>B
//  A.comapreTo(B), ����==0 �� A==B
//  A.comapreTo(B), ����<0 �� A<B
    System.out.println("Bob".compareTo("Andy"));//1
    System.out.println("Andy".compareTo("Andy"));//0
    System.out.println("Andy".compareTo("Bob"));//-1
    //compareTo() ��������Comparable �ӿ��ж���, 
    //Stringʵ��������ӿ�, ���������.
    //Comparable: ���ݴ�: ���ԱȽϴ�С��
    //Stringʵ��������ӿ� ��ʾ: String �� "���ԱȽϴ�С��"!
    //Comparable �Ƚ���ʹ��: �����������ʵ��������Ĭ�ϱȽ�
    // ��С��: ��������, ����Ĭ�ϱȽϴ�С, �˿����Զ���Ƚ�.
    //compareTo() ������ʵ�ֱ�����equals() ���һ��!
    //Comparator: ����: �Ƚ��� , ����ӿڱ�ʾ��ʱ�Զ���
    //�ȽϹ���, ����\���\����!
    Collections.sort(names, new ByLength());
    System.out.println(names);//�Զ���ȽϽ��
    Collections.sort(names, new ByLast());
    System.out.println(names);//�Զ���ȽϽ��
    
    Collections.reverse(names);//��ת
    System.out.println(names);
    
    Collections.sort(names);//����
    System.out.println(names);
    //���ֲ���
    int index = Collections.binarySearch(names, "Tom");
    System.out.println(index); 
    
  }
}
/** �Զ���ȽϹ���, �����ַ������ȱȽ� */
class ByLength implements Comparator<String>{
  public int compare(String o1, String o2) {
    return -(o1.length() - o2.length());
  }
}
class ByLast implements Comparator<String>{
  public int compare(String o1, String o2) {
    return -(o1.charAt(o1.length()-1) - 
             o2.charAt(o2.length()-1) );
  }
}





