package javase1.day05.exp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ExceptionDemo {
  public static void main(String[] args) 
    throws Exception {
    //String str = "2012-ʮ��-31";
    Scanner in = new Scanner(System.in);
    System.out.print("��������:");
    String str = in.nextLine();
    SimpleDateFormat fmt = 
      new SimpleDateFormat("yyyy-MM-dd");
    //�쳣���ڷ�����������, �Ƿ�����һ��������, �������
    //fmt.parse(str)�����������˿����׳�����������쳣
    Date date = fmt.parse(str);//���ܳ��쳣�ķ���, ����
    //�п����׳��쳣, ���ÿ������쳣�׳��ķ���, ��Ҫ�����쳣
    //�����б������
    System.out.println(date);
    //�쳣����:�����ַ�ʽ: һ�����׳�, һ���ǲ�����
  }
}





