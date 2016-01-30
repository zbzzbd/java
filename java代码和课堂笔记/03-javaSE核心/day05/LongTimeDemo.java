package javase1.day05;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class LongTimeDemo {
  public static void main(String[] args) {
    long gmt = System.currentTimeMillis();
    long year = gmt/1000/60/60/24/365 + 1970;
    System.out.println(year);//今年
    //long month = gmt/1000/60/60/24/?
    //Date : GMT long + 公历历法算法(年月日的运算规定)
    Date date = new Date(gmt);
    int month = date.getMonth()+1;//month 第一个月是0
    System.out.println(month);//月 
    int d = date.getDate();
    System.out.println(d);//日
    int y = date.getYear()+1900;//有y2k(2千年问题),返回两位数
    //的年份, 过了2000年返回值是3位数了
    System.out.println(y);//年
    //Calendar: 历法    
    //GregorianCalendar: 格里高历, 是Calendar的公历实现
    //GregorianCalendar: GMT Long + 公历实现
    Calendar cal = new GregorianCalendar();//默认值是当前时间
    //cal.get() 根据历法算法将long计算为具体时间结果 
    y = cal.get(Calendar.YEAR);
    month = cal.get(Calendar.MONTH)+1;
    d = cal.get(Calendar.DAY_OF_MONTH);
    System.out.println(y+"-"+month+"-"+d);
    
  }

}
