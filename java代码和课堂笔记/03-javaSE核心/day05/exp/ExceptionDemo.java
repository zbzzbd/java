package javase1.day05.exp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ExceptionDemo {
  public static void main(String[] args) 
    throws Exception {
    //String str = "2012-十二-31";
    Scanner in = new Scanner(System.in);
    System.out.print("输入日期:");
    String str = in.nextLine();
    SimpleDateFormat fmt = 
      new SimpleDateFormat("yyyy-MM-dd");
    //异常是在方法上声明的, 是方法的一种意外结果, 意外结束
    //fmt.parse(str)方法上声明了可能抛出解析错误的异常
    Date date = fmt.parse(str);//可能出异常的方法, 声明
    //有可能抛出异常, 调用可能有异常抛出的方法, 需要处理异常
    //否则有编译错误
    System.out.println(date);
    //异常处理:有两种方式: 一种是抛出, 一种是捕获处理
  }
}





