package javase1.day03;

import java.util.HashSet;
import java.util.Set;

/** ��������: ����, ����, ��, ��, �� */
public class CollectionOptDemo {
  public static void main(String[] args) {
    Set<String> a = new HashSet<String>();
    a.add("Tom"); a.add("Andy"); a.add("Wang");
    Set<String> b = new HashSet<String>();
    b.add("Tom"); b.add("Robin"); b.add("John");
    Set<String> c = new HashSet<String>();
    c.add("Tom");  c.add("Andy");
    System.out.println("A:"+a);
    System.out.println("B:"+b);
    System.out.println("C:"+c);
    System.out.println("Tom ����a:"+a.contains("Tom"));
    System.out.println("Tom ����b:"+b.contains("Tom"));
    System.out.println("a ���� c:" + a.containsAll(c));  
    System.out.println("a ���� b:" + a.containsAll(b));  
    a.addAll(b); //��b�ܲ���a
    System.out.println("��b�ܲ���a"); 
    System.out.println("A:"+a);
    System.out.println("B:"+b);
    System.out.println("a��b");
    a.retainAll(b);//��a�б���, a b �Ĺ�������
    System.out.println("A:"+a);
    System.out.println("B:"+b);
    System.out.println("a-c");
    a.removeAll(c);// a��ȥ��������c��Ԫ��
    System.out.println("A:"+a);
    System.out.println("c:"+c);
  }
}
