package javase2.day03;

import java.util.Arrays;

public class DeepCopyDemo {
  public static void main(String[] args) {
    String[] names = {"Tom", "Andy"};
    System.out.println("ǳ�㸴��:");
    String[] ary = Arrays.copyOf(names, names.length);
    System.out.println(
        "��������:"+Arrays.equals(names, ary));//true
    System.out.println("���������һ����:"+(names==ary));//flase 
    System.out.println("����Ԫ����һ����:"+
        (names[0]==ary[0]));//true 
    System.out.println("��㸴��:");
    String[] ary1 = (String[])IOUtils.deepCopy(names);
    System.out.println(
        "��������:"+Arrays.equals(names, ary1));//true
    System.out.println("���������һ����:"+(names==ary1));//flase 
    System.out.println("����Ԫ����һ����:"+
        (names[0]==ary1[0]));//false
  }
}
