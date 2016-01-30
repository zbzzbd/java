package javase1.day05.exp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//ʹ��try ...catch �������쳣
public class ExceptionDemo2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("��������:");
    String str = in.nextLine();
    SimpleDateFormat fmt = 
      new SimpleDateFormat("yyyy-MM-dd");
    //ʹ��try ����ִ�д���, ׼��ʹ��catch�����쳣����
    //ʹ��try catch �����쳣
    try{
      Date date = fmt.parse(str);//�������쳣�ķ���
      System.out.println("�����ʱ��:"+date);
    }catch(ParseException e){
      //ParseException����parse() �����׳����쳣����
      // e �������쳣ʵ������, ��������а�����ϸ���쳣��Ϣ
      System.out.println(e.getMessage());       
    }
    System.out.println("ʱ���������"); 
  }
}





