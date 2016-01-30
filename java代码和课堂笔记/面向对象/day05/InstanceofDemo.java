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
    //instanceof 运算符, 用来检验变量引用的对象类型兼容性
    //安全的强制类型转换
    if(obj instanceof int[]){
      int[] ary = (int[])obj;
      System.out.println(Arrays.toString(ary));
    }else{
      System.out.println(obj.toString()); 
    }
  }
}
