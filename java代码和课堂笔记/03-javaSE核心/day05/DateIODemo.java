package javase1.day05;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateIODemo {
  public static void main(String[] args) 
    throws Exception {
    long gmt = -1000*60*60*24;
    Date date = new Date(gmt);
    DateFormat fmt = 
      new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //格式化输出时间
    String d = fmt.format(date);
    System.out.println(d);//1970-01-01 08:00:00
    String birthday = "1970-1-1";
    fmt = new SimpleDateFormat("yyyy-MM-dd");
    //格式化解析输入时间,birthday的值可能是控制台输入的字符串 
    Date birth = fmt.parse(birthday);
    System.out.println(birth); 
    System.out.println(birth.getTime()/1000/60/60); 
    //从身份证中解析生日的代码
    ///          012345678901234567
    String id = "11111119770101111x";
    birthday = id.substring(6,14);//19770101
    fmt = new SimpleDateFormat("yyyyMMdd");
    date = fmt.parse(birthday);
    System.out.println(date); 
    //软件开发中处理时间输入都使用 SimpleDateFormat parse()
        
  }
}





