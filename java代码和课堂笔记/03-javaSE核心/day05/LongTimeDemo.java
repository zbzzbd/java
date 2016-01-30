package javase1.day05;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class LongTimeDemo {
  public static void main(String[] args) {
    long gmt = System.currentTimeMillis();
    long year = gmt/1000/60/60/24/365 + 1970;
    System.out.println(year);//����
    //long month = gmt/1000/60/60/24/?
    //Date : GMT long + ���������㷨(�����յ�����涨)
    Date date = new Date(gmt);
    int month = date.getMonth()+1;//month ��һ������0
    System.out.println(month);//�� 
    int d = date.getDate();
    System.out.println(d);//��
    int y = date.getYear()+1900;//��y2k(2ǧ������),������λ��
    //�����, ����2000�귵��ֵ��3λ����
    System.out.println(y);//��
    //Calendar: ����    
    //GregorianCalendar: �������, ��Calendar�Ĺ���ʵ��
    //GregorianCalendar: GMT Long + ����ʵ��
    Calendar cal = new GregorianCalendar();//Ĭ��ֵ�ǵ�ǰʱ��
    //cal.get() ���������㷨��long����Ϊ����ʱ���� 
    y = cal.get(Calendar.YEAR);
    month = cal.get(Calendar.MONTH)+1;
    d = cal.get(Calendar.DAY_OF_MONTH);
    System.out.println(y+"-"+month+"-"+d);
    
  }

}
