package javase1.day04;

import java.util.Arrays;

public class CopyDemo {
  public static void main(String[] args) {
    //Java API Ĭ�ϵ�һ�и���������ǳ����(���ܺ�)
    System.out.println("��������ĸ�����ǳ��(ǳ��)����:");
    String[] ary1 = {"1","2","3"};
    String[] ary2 = Arrays.copyOf(ary1, ary1.length);
    System.out.println("�����������:");
    System.out.println("����(ary1,ary2)ͬһ������?"+
        (ary1==ary2));//false
    System.out.println("�����Ԫ��û�и���:");
    System.out.println(
        "����Ԫ��(ary1[0],ary2[0])��ͬһ������?:"+
        (ary1[0]==ary2[0]));//true
  }
}




