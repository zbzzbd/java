package basic.day05;

import java.util.Arrays;
import java.util.Random;

/** Sort ���ܱȽ� */
public class SortPKDemo {
  public static void main(String[] args) {
    //int[] ary = {4,7,1,6,9};
    Random random = new Random();//Scanner s = new Scanner();
    int[] ary = new int[100000];
    for(int i=0;i<ary.length; i++){
      ary[i]=random.nextInt();//����������Χ�ڵ������
    }
    int[] ary1 = Arrays.copyOf(ary, ary.length);
    long t1 = System.currentTimeMillis();
    Arrays.sort(ary);//java API �ṩ�����򷽷�
    long t2 = System.currentTimeMillis();
    SortDemo.insertSort(ary1);
    long t3 = System.currentTimeMillis();
    System.out.println(t2-t1);
    System.out.println(t3-t2);
    //System.out.println(Arrays.toString(ary));  
  }
}




