package oop.day05;

import java.util.Arrays;

/** 
 * Java ������û�ж�ά����!
 * Java �Ķ�ά������һά��������, ÿ��������һ��һά����
 * ��ά���� ������Ԫ�������������
 */
public class Array2DDemo {
  public static void main(String[] args) {
    int[][] ary = {{1,2,3},{4,5,6},{5,6,7,8}};
    
    int[] a = ary[2];
    ary[2] = null;
    System.out.println(Arrays.toString(a)); 
    ary[2] = new int[]{9,1,1};
    System.out.println(ary[2][2]);//1
    
    ary = new int[5][]; // {null,null,null,null,null}
    ary = new int[2][2];//{{0,0},{0,0}} 
  }

}





