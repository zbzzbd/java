package basic.day05;

import java.util.Arrays;

public class SortDemo {
  public static void main(String[] args) {
    int[] ary = { 8, 2, 3, 7, 5 };
    //System.out.println("开始排序");
    // selectionSort(ary);
    //bubbleSort(ary);
    insertSort(ary);
    //System.out.println("结束排序");
    System.out.println(Arrays.toString(ary));
  }
  /** 插入式排序: 将后组的每一张插入到前组合适的位置 */
  public static void insertSort(int[] ary){
    int i,j,t;//声明变量
    for(i=1; i<ary.length; i++){
      t = ary[i];//取出待插入排序
      for(j=i-1; j>=0 && t<ary[j]; j--){
        ary[j+1]=ary[j];
      }
//      for(j=i-1; j>=0; j--){//扫描查找插入位置
//        if(t<ary[j]){//前面元素大就移动元素
//          ary[j+1]=ary[j];//向后移动元素
//        }else{
//          break;//前面没有大的元素了,就找到插入位置j+1
//        }
//      }
      //插入位置有两种情况,到头j=-1,找到不大于t的位置j,都需要+1
      ary[j+1]=t;//插入t
    }
  }

  /** 冒泡排序: 比较相邻元素,大的向后交换 */
  //加入跟踪调试语句, 查看跟踪结果
  public static void bubbleSort(int[] ary) {
    //System.out.println("Call bubbleSort:"+ Arrays.toString(ary));
    for (int i = 0; i < ary.length - 1; i++) {
      //System.out.println("Run at for:i="+i);
      for (int j = 0; j < ary.length - i - 1; j++) {
        //System.out.println("Run at for:j="+j);
        System.out.print(Arrays.toString(ary) + " ");
        System.out.print(i + " " +j + " ");
        System.out.print(ary[j] + " " +ary[j+1] + " ");
        System.out.print((ary[j] > ary[j + 1]) + " ");
        if (ary[j] > ary[j + 1]) {
          System.out.print(ary[j]+ "<->"+ary[j+1]);
          int t = ary[j];
          ary[j] = ary[j + 1];
          ary[j + 1] = t;
        }
        System.out.println();
      }
    }
  }

  /** 选择排序: 每轮选择一个最小的交换到前面 */
  public static void selectionSort(int[] ary) {
    for (int i = 0; i < ary.length - 1; i++) {
      for (int j = i + 1; j < ary.length; j++) {
        if (ary[i] > ary[j]) {
          int t = ary[j];
          ary[j] = ary[i];
          ary[i] = t;
        }
      }
    }
  }
}
