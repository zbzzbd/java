package day07;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTimeDemo {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		long times = System.currentTimeMillis();
		System.out.println(times);//1970.1.1到现在为止的毫秒数

		long time = 0;//1970.1.1
		Date date = new Date();//当前的系统时间
		System.out.println(date);
		date.setTime(time);//1970.1.1
		System.out.println(date);
		
		Calendar cal = new GregorianCalendar();//当前的系统时间
		Calendar cal1 = Calendar.getInstance();//当前的系统时间
		System.out.println(cal);
		
		cal.setTime(date);//1970.1.1
		
		Date d = cal.getTime();
		long t = d.getTime();
		System.out.println(t);
		
		//获取现在时间，并按照指定格式显示
		//把Date或Calendar类型的数据转换成为指定格式的字符串
		String format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf 
			= new SimpleDateFormat(format);
		Date now = new Date();//当前系统时间
		System.out.println(sdf.format(now));
		
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(new Date(0));//1970.1.1
		System.out.println(sdf.format(cal2.getTime()));

		//把字符串转换成为Date类型的数据
		String birth = "1989-10-10 23:10:10";
		Date birthday = sdf.parse(birth);
		System.out.println(birthday);
	}

}
