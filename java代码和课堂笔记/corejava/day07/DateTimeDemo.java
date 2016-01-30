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
		System.out.println(times);//1970.1.1������Ϊֹ�ĺ�����

		long time = 0;//1970.1.1
		Date date = new Date();//��ǰ��ϵͳʱ��
		System.out.println(date);
		date.setTime(time);//1970.1.1
		System.out.println(date);
		
		Calendar cal = new GregorianCalendar();//��ǰ��ϵͳʱ��
		Calendar cal1 = Calendar.getInstance();//��ǰ��ϵͳʱ��
		System.out.println(cal);
		
		cal.setTime(date);//1970.1.1
		
		Date d = cal.getTime();
		long t = d.getTime();
		System.out.println(t);
		
		//��ȡ����ʱ�䣬������ָ����ʽ��ʾ
		//��Date��Calendar���͵�����ת����Ϊָ����ʽ���ַ���
		String format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf 
			= new SimpleDateFormat(format);
		Date now = new Date();//��ǰϵͳʱ��
		System.out.println(sdf.format(now));
		
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(new Date(0));//1970.1.1
		System.out.println(sdf.format(cal2.getTime()));

		//���ַ���ת����ΪDate���͵�����
		String birth = "1989-10-10 23:10:10";
		Date birthday = sdf.parse(birth);
		System.out.println(birthday);
	}

}
