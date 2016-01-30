package oop.day05;

import java.util.Arrays;

public class InstanceofDemo {
  public static void main(String[] args) {
    int[] ary = {1,2,3};
    String str = "Tom";
    print(ary);
    print(str);
  }
  public static void print(Object obj){
    //instanceof �����, ��������������õĶ������ͼ�����
    //��ȫ��ǿ������ת��
    if(obj instanceof int[]){
      int[] ary = (int[])obj;
      System.out.println(Arrays.toString(ary));
    }else{
      System.out.println(obj.toString()); 
    }
  }
}
