package javase1.day05;

import java.util.Calendar;
import java.util.Date;//注意不要导入错误!
import java.util.GregorianCalendar;

public class DateCastDemo {
  public static void main(String[] args) {
    long gmt = 0;
    Date date = new Date();//Date默认是当前时间
    //转换gmt long 到Date
    date.setTime(gmt);//修改到1970 
    System.out.println(date.getYear()+1900);//1970
    System.out.println(date); 
    //转换Date 到 Calendar
    Calendar cal = new GregorianCalendar();// 当前时间
    cal.setTime(date);//修改到1970 
    System.out.println(cal.get(Calendar.YEAR));//1970
    //Calendar 转换为Date
    //时间计算的原理: 根据历法计算时间毫秒数
    //减少一天, 本质上是在当前时间毫秒数上减少一天的毫秒数
    // 一天的毫秒数: 1000*60*60*24 
    cal.add(Calendar.DAY_OF_YEAR, -2);//0-2*1000*60*60*24
    System.out.println(cal.get(Calendar.YEAR));//1969
    Date d = cal.getTime();
    long l = d.getTime();
    System.out.println(l);
    System.out.println(0-2*1000*60*60*24);
  }

}
