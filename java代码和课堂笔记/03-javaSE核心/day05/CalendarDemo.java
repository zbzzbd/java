package javase1.day05;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/** ʱ��ļ��� */
public class CalendarDemo {
  public static void main(String[] args)
    throws Exception {
    //�򵥵�ʱ�����, ���Բ��� GMT long ֱ�Ӽ���
    long time = System.currentTimeMillis();
    time = time+1000L*60*60*24*5;//��ǰʱ��, ��5��
    SimpleDateFormat fmt = 
      new SimpleDateFormat("yyyy-MM-dd");
    System.out.println(fmt.format(new Date(time))); 
    //����ʱ�����: 5�����Ժ�, ʹ��Calendar ���������
    Calendar cal = new GregorianCalendar();//��ǰʱ��
    cal.add(Calendar.MONTH, 5);
    cal.add(Calendar.DAY_OF_MONTH, 5); 
    System.out.println(fmt.format(cal.getTime())); 
    
    //����ʱ����㰸��: ������Ʒ����ʱ��. 
    // ����ʱ��������: �����������ںͱ���������, 
    //           �� ����ǰ���ܵ����忪ʼ����!
    Date proc = fmt.parse("2005-11-23");
    Date special = specialDay(proc, 3);
    System.out.println(fmt.format(special));//2006-2-10    
    //ʱ��ʵ��Comparable�ӿ�, �ܹ�Ĭ������, �Ƚϴ�С
    Date d1 = new Date();
    Date d2 = new Date(0);
    System.out.println(d1.compareTo(d2));// >0
    System.out.println(d2.compareTo(d1));// <0
    //birthday �ǽ��������
    //if(today.compareTo(birthday)>0){
    //    ����������!
    //}
    //Calendar ʵ���Ĵ���:
    cal = new GregorianCalendar();//���������
    cal = Calendar.getInstance();//���ݵ�ǰ���ҵ�������
    //�ʵ�������ʵ��, ��"�й�"���� ���������
    //�����ϴ��� Calendar ���й�ũ����ʵ��, JavaĬ��û���ṩ
    //���Ե��������� �ҵ�!
  
  }

  public static Date specialDay(Date proc, int months){
    Calendar cal = new GregorianCalendar();
    cal.setTime(proc);//cal ����������
    cal.add(Calendar.MONTH, months);//�����������
    //cal.add(Calendar.WEEK_OF_YEAR, -2);
    cal.add(Calendar.DAY_OF_YEAR, -14);
    if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY){
      cal.add(Calendar.WEEK_OF_YEAR, -1);
    }
    //����ʱ������ ������
    cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
    return cal.getTime(); 
  }
}







