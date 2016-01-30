package javase2.day03;

import java.util.Arrays;

public class DeepCopyDemo {
  public static void main(String[] args) {
    String[] names = {"Tom", "Andy"};
    System.out.println("浅层复制:");
    String[] ary = Arrays.copyOf(names, names.length);
    System.out.println(
        "数组内容:"+Arrays.equals(names, ary));//true
    System.out.println("数组对象是一个吗:"+(names==ary));//flase 
    System.out.println("数组元素是一个吗:"+
        (names[0]==ary[0]));//true 
    System.out.println("深层复制:");
    String[] ary1 = (String[])IOUtils.deepCopy(names);
    System.out.println(
        "数组内容:"+Arrays.equals(names, ary1));//true
    System.out.println("数组对象是一个吗:"+(names==ary1));//flase 
    System.out.println("数组元素是一个吗:"+
        (names[0]==ary1[0]));//false
  }
}
