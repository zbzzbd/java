package javase2.day02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/** �ַ����뷽�� 
 * ��Java�ڲ���char(16λunicode ����)�������л�Ϊbyte����
 * �б��뷽��
 * ������ı�(char����)д�뵽�ļ�, �ͱ������Ϊbyte, �ļ�
 * ֻ�ܴ洢byte����!
 **/
public class CharEncodingDemo {
  public static void main(String[] args) 
    throws IOException {
    String str = "ABCD�й�����";
    System.out.println(str); 
    System.out.println("UTF-16BE ���뷽��:");
    String file = "utf16be.txt";
    byte[] buf = str.getBytes("UTF-16BE");
    OutputStream out = new FileOutputStream(file);
    out.write(buf);
    out.close();
    IOUtils.print(file);
    
    System.out.println("UTF-8���뷽��:"); 
    file = "utf8.txt";
    buf = str.getBytes("UTF-8");
    out = new FileOutputStream(file);
    out.write(buf);
    out.close();
    IOUtils.print(file);
    
    System.out.println("GBK���뷽��:"); 
    file = "gbk.txt";
    buf = str.getBytes("GBK");
    out = new FileOutputStream(file);
    out.write(buf);
    out.close();
    IOUtils.print(file);
    
    System.out.println("iso8859-1���뷽��(ֻ֧��Ӣ��!):"); 
    file = "iso8859.txt";
    buf = str.getBytes("iso8859-1");
    out = new FileOutputStream(file);
    out.write(buf);
    out.close();
    IOUtils.print(file);
    
    System.out.println("�ı��ļ���byte���еĽ���:");
    file = "gbk.txt";
    InputStream in = new FileInputStream(file);
    //in.available() �������п��Զ�ȡ��byte���ݸ���, 
    //�������ļ��ĳ���!
    byte[] gbk = new byte[in.available()];
    in.read(gbk);//��ȡ�ļ���ȫ������
    in.close();
    //new String(byte,encoding)���Խ�byte���н���Ϊ�ַ���
    String s = new String(gbk, "gbk");
    System.out.println(s); 
    String ss = new String(gbk, "utf-8");//��������
    System.out.println(ss); 
    
    System.out.println("ϵͳĬ�ϱ���:" +
        System.getProperty("file.encoding"));//GBK
  }
}


