package basic.day05;

import java.util.Arrays;
import java.util.Random;

/** Sort 性能比较 */
public class SortPKDemo {
  public static void main(String[] args) {
    //int[] ary = {4,7,1,6,9};
    Random random = new Random();//Scanner s = new Scanner();
    int[] ary = new int[100000];
    for(int i=0;i<ary.length; i++){
      ary[i]=random.nextInt();//产生整数范围内的随机数
    }
    int[] ary1 = Arrays.copyOf(ary, ary.length);
    long t1 = System.currentTimeMillis();
    Arrays.sort(ary);//java API 提供的排序方法
    long t2 = System.currentTimeMillis();
    SortDemo.insertSort(ary1);
    long t3 = System.currentTimeMillis();
    System.out.println(t2-t1);
    System.out.println(t3-t2);
    //System.out.println(Arrays.toString(ary));  
  }
}




