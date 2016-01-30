package oop.day04;

public class ClassCastDemo {
  public static void main(String[] args) {
    Integer i = new Integer(5);
    Double d = new Double(5.5);
    Long l = new Long(1L);
    System.out.println("自动类型转换: 小类型到大类型");
    Number n = i;//自动类型转换
    System.out.println("强制类型转换: 大类型到小类型");
    //Integer x = n;//编译错误
    Integer x = (Integer)n;//n如果引用的是Integer,转换没问题
    System.out.println(x);//5
    System.out.println("强制类型换行可能会出现异常:");
    n = l;
    x = (Integer)n;//会出现运行异常, n实际引用的是Long
    
    
  }
}
