package javase1.day03;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorDemo {
  public static void main(String[] args) {
    Collection<String> eggs = new HashSet<String>();
    eggs.add("����");
    eggs.add("Ѽ��");
    eggs.add("�ɻ���");
    eggs.add("�õ�");
    eggs.add("����");
    int count=0;
    System.out.println(eggs);
    Iterator<String> ite = eggs.iterator();
    while(ite.hasNext()){
      String egg = ite.next();
      System.out.println(egg);
      count++;
      if(egg.equals("����")){
        ite.remove();//��ԭ����eggs��,ɾ�����ڵ�����Ԫ��
      }
    }
    System.out.println(count);//5
    System.out.println(eggs);
  }
}






