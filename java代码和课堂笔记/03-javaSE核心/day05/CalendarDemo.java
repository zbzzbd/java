package javase1.day05;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/** 时间的计算 */
public class CalendarDemo {
  public static void main(String[] args)
    throws Exception {
    //简单的时间计算, 可以采用 GMT long 直接计算
    long time = System.currentTimeMillis();
    time = time+1000L*60*60*24*5;//当前时间, 加5天
    SimpleDateFormat fmt = 
      new SimpleDateFormat("yyyy-MM-dd");
    System.out.println(fmt.format(new Date(time))); 
    //复杂时间计算: 5个月以后, 使用Calendar 计算更方便
    Calendar cal = new GregorianCalendar();//当前时间
    cal.add(Calendar.MONTH, 5);
    cal.add(Calendar.DAY_OF_MONTH, 5); 
    System.out.println(fmt.format(cal.getTime())); 
    
    //复杂时间计算案例: 计算商品促销时间. 
    // 促销时间计算策略: 输入生产日期和保质期月数, 
    //           在 过期前两周的周五开始促销!
    Date proc = fmt.parse("2005-11-23");
    Date special = specialDay(proc, 3);
    System.out.println(fmt.format(special));//2006-2-10    
    //时间实现Comparable接口, 能够默认排序, 比较大小
    Date d1 = new Date();
    Date d2 = new Date(0);
    System.out.println(d1.compareTo(d2));// >0
    System.out.println(d2.compareTo(d1));// <0
    //birthday 是今年的生日
    //if(today.compareTo(birthday)>0){
    //    过完生日了!
    //}
    //Calendar 实例的创建:
    cal = new GregorianCalendar();//格里高历法
    cal = Calendar.getInstance();//根据当前国家地区创建
    //适当的历法实例, 在"中国"就是 格里高历法
    //理论上存在 Calendar 的中国农历的实现, Java默认没有提供
    //可以到互联网上 找到!
  
  }

  public static Date specialDay(Date proc, int months){
    Calendar cal = new GregorianCalendar();
    cal.setTime(proc);//cal 是生产日期
    cal.add(Calendar.MONTH, months);//计算过期日期
    //cal.add(Calendar.WEEK_OF_YEAR, -2);
    cal.add(Calendar.DAY_OF_YEAR, -14);
    if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY){
      cal.add(Calendar.WEEK_OF_YEAR, -1);
    }
    //设置时间属性 到周五
    cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
    return cal.getTime(); 
  }
}







