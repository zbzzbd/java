package javase1.day04;

import java.util.Arrays;

public class CopyDemo {
  public static void main(String[] args) {
    //Java API 默认的一切复制现象都是浅表复制(性能好)
    System.out.println("对象数组的复制是浅表(浅层)复制:");
    String[] ary1 = {"1","2","3"};
    String[] ary2 = Arrays.copyOf(ary1, ary1.length);
    System.out.println("数组对象复制了:");
    System.out.println("数组(ary1,ary2)同一对象吗?"+
        (ary1==ary2));//false
    System.out.println("数组的元素没有复制:");
    System.out.println(
        "数组元素(ary1[0],ary2[0])是同一对象吗?:"+
        (ary1[0]==ary2[0]));//true
  }
}




