package javase1.day04.inn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/** ʹ�þ�̬�ڲ��ඨ��ȽϹ���, ʵ���Զ������� */
public class InnerDemo {
  public static void main(String[] args) {
    String[] names = {"Tom", "Andy", "Robin", "QQ"};
    List<String> list = 
      new ArrayList<String>(Arrays.asList(names));
    Collections.sort(list, new ByLength());
    System.out.println(list); 
  }
  private static class ByLength 
    implements Comparator<String>{
    public int compare(String o1, String o2) {
      return o1.length()-o2.length();
      //return o1.charAt(1)-o2.charAt(1);
    }
  }
}




