package javase1.day05.exp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//使用try ...catch 捕获处理异常
public class ExceptionDemo2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("输入日期:");
    String str = in.nextLine();
    SimpleDateFormat fmt = 
      new SimpleDateFormat("yyyy-MM-dd");
    //使用try 尝试执行代码, 准备使用catch捕获异常对象
    //使用try catch 处理异常
    try{
      Date date = fmt.parse(str);//可能有异常的方法
      System.out.println("输入的时间:"+date);
    }catch(ParseException e){
      //ParseException就是parse() 可能抛出的异常类型
      // e 引用了异常实例对象, 这个对象中包含详细的异常信息
      System.out.println(e.getMessage());       
    }
    System.out.println("时间输入结束"); 
  }
}





