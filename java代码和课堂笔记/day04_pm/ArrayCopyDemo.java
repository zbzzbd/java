package basic.day04;
import java.util.Arrays;//数组的工具类, 包含数组常见操作(方法)
/** 数组的复制问题 */
public class ArrayCopyDemo {
  public static void main(String[] args) {
    int[] ary1 = {1,2,3};
    int[] ary2 = ary1;
    //ary1和ary2 是同一数组对象的引用, 没有隔离性, 
    //修改ary1的成员, 就是修改ary2的成员
    System.out.println("ary1[1]:"+ary1[1]);//2
    System.out.println("ary2[1]:"+ary2[1]);//2
    ary1[1]=5;//
    System.out.println("ary1[1]:"+ary1[1]);//5
    System.out.println("ary2[1]:"+ary2[1]);//5
    int[] ary3 = new int[ary1.length];
    for(int i=0; i<ary1.length; i++){
      ary3[i]=ary1[i];
    }
    ary3[1]=6;
    System.out.println("ary1[1]:"+ary1[1]);//5
    System.out.println("ary3[1]:"+ary3[1]);//6
    
    //Java 系统API提供了数组复制功能
    int[] ary4 = new int[ary1.length];
    //   源数组,起始位置,目标数组,目标起始位置,复制元素个数
    System.arraycopy(ary1, 0, ary4, 0, ary1.length);
    ary4[1]=8;
    System.out.println("ary1[1]:"+ary1[1]);//5
    //Java 6 提供了简化版的复制操作, 底层还是arraycopy()
    int[] ary5 = Arrays.copyOf(ary1, ary1.length);
    ary5[1]=10;
    System.out.println("ary1:"+Arrays.toString(ary1));
    //Arrays.toString()将数组元素连接为一个字符串 
    System.out.println("ary5:"+Arrays.toString(ary5));
    System.out.println("ary5:"+ary5);
    //Iterate: 重复, 迭代, 重复处理
    //"数组的迭代"处理, 就是数组元素的遍历处理
    for(int i =0; i<ary5.length; i++){
      int e = ary5[i];
      System.out.println(e);
    }
       
    
  }
}






