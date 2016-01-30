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
    //��ʽ�����ʱ��
    String d = fmt.format(date);
    System.out.println(d);//1970-01-01 08:00:00
    String birthday = "1970-1-1";
    fmt = new SimpleDateFormat("yyyy-MM-dd");
    //��ʽ����������ʱ��,birthday��ֵ�����ǿ���̨������ַ��� 
    Date birth = fmt.parse(birthday);
    System.out.println(birth); 
    System.out.println(birth.getTime()/1000/60/60); 
    //�����֤�н������յĴ���
    ///          012345678901234567
    String id = "11111119770101111x";
    birthday = id.substring(6,14);//19770101
    fmt = new SimpleDateFormat("yyyyMMdd");
    date = fmt.parse(birthday);
    System.out.println(date); 
    //��������д���ʱ�����붼ʹ�� SimpleDateFormat parse()
        
  }
}





