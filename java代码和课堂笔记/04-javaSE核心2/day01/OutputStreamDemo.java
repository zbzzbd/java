package javase2.day01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamDemo {
  public static void main(String[] args) 
    throws IOException {
    //�����: �Ǵ�Ӧ�ó����ڴ�(����)���������(�����ļ�)
    String file = "out.dat";
    OutputStream out = new FileOutputStream(file);
    out.write(65);
    out.write(66);
    int i=-2;
    out.write(i>>>24);
    out.write(i>>>16);
    out.write(i>>>8);
    out.write(i);
    out.write("��������".getBytes("GBK"));
    out.close();
    IOUtils.print(file);
  }
}
