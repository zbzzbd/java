package javase1.day05;

import java.util.Calendar;
import java.util.Date;//ע�ⲻҪ�������!
import java.util.GregorianCalendar;

public class DateCastDemo {
  public static void main(String[] args) {
    long gmt = 0;
    Date date = new Date();//DateĬ���ǵ�ǰʱ��
    //ת��gmt long ��Date
    date.setTime(gmt);//�޸ĵ�1970 
    System.out.println(date.getYear()+1900);//1970
    System.out.println(date); 
    //ת��Date �� Calendar
    Calendar cal = new GregorianCalendar();// ��ǰʱ��
    cal.setTime(date);//�޸ĵ�1970 
    System.out.println(cal.get(Calendar.YEAR));//1970
    //Calendar ת��ΪDate
    //ʱ������ԭ��: ������������ʱ�������
    //����һ��, ���������ڵ�ǰʱ��������ϼ���һ��ĺ�����
    // һ��ĺ�����: 1000*60*60*24 
    cal.add(Calendar.DAY_OF_YEAR, -2);//0-2*1000*60*60*24
    System.out.println(cal.get(Calendar.YEAR));//1969
    Date d = cal.getTime();
    long l = d.getTime();
    System.out.println(l);
    System.out.println(0-2*1000*60*60*24);
  }

}
